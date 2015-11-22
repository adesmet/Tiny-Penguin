package net.ghentleman.logic;

import net.ghentleman.model.TuplePojo;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by Anthony on 26/03/14.
 */
public class HashGenerator {
    public static TreeSet<TuplePojo> sortTuples(Collection<TuplePojo> tuples) {
        return new TreeSet<TuplePojo>(tuples);
    }

    public static String generateFrontEndHash(TreeSet<TuplePojo> sortedTuples) {
        StringBuilder builder = new StringBuilder();

        for (TuplePojo tuple : sortedTuples) {
            toHashTuple(builder, tuple.getVerb(), tuple.getNoun());
        }

        return builder.toString();
    }

    public static List<String> generateBackEndHashes(TreeSet<TuplePojo> sortedTuples) {
        TuplePojo[] tupleArray = sortedTuples.toArray(new TuplePojo[sortedTuples.size()]);

        List<StringBuilder> startingList = new ArrayList<StringBuilder>();
        startingList.add(new StringBuilder());
        List<StringBuilder> stringBuilders = generateHashLevels(tupleArray, startingList, 0);

        List<String> output = new ArrayList<String>();

        for (StringBuilder stringBuilder : stringBuilders) {
            output.add(stringBuilder.toString());
        }

        return output;
    }

    private static List<StringBuilder> generateHashLevels(TuplePojo[] tupleArray, List<StringBuilder> currentList, int level) {
        if (level >= tupleArray.length) {
            return currentList;
        }

        boolean hasNoun = StringUtils.isNotBlank(tupleArray[level].getNoun());
        List<StringBuilder> withNounList = new ArrayList<StringBuilder>();

        for (StringBuilder stringBuilder : currentList) {
            if(hasNoun){
                StringBuilder toAppendNoun = new StringBuilder(stringBuilder.toString());
                toHashTuple(toAppendNoun, tupleArray[level].getVerb(), tupleArray[level].getNoun());
                withNounList.add(toAppendNoun);
            }

            toHashTuple(stringBuilder, tupleArray[level].getVerb(), null);
        }

        currentList.addAll(withNounList);
        return generateHashLevels(tupleArray, currentList, ++level);
    }

    public static TuplePojo unhashTuple(String hash) {
        if(StringUtils.isBlank(hash) || !hash.endsWith("||")){
            return null;
        }

        TuplePojo tuple = new TuplePojo();

        String[] split = hash.split("@");
        if(split.length == 2){
            tuple.setVerb(split[0]);
            tuple.setNoun(StringUtils.removeEnd(split[1], "||"));
        }else if(split.length == 1){
            tuple.setVerb(StringUtils.removeEnd(split[0], "||"));
        }else{
            return null;
        }

        return tuple;

    }

    public static String hashTuple(TuplePojo tuple) {
        StringBuilder stringBuilder = new StringBuilder();
        toHashTuple(stringBuilder, tuple.getVerb(), tuple.getNoun());
        return stringBuilder.toString();
    }

    private static void toHashTuple(StringBuilder builder, String verb, String noun) {
        builder.append(verb);
        if (noun != null) {
            builder.append("@");
            builder.append(noun);
        }
        builder.append("||");
    }


}

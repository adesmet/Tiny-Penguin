package net.tinypenguin.logic;

import net.tinypenguin.dto.TupleDto;
import net.tinypenguin.model.Tuple;
import org.apache.commons.lang.StringUtils;

import java.util.*;

/**
 * Created by Anthony on 26/03/14.
 */
public class HashGenerator {
    public static TreeSet<TupleDto> sortTuples(Collection<TupleDto> tuples) {
        return new TreeSet<TupleDto>(tuples);
    }

    public static String generateFrontEndHash(TreeSet<TupleDto> sortedTuples) {
        StringBuilder builder = new StringBuilder();

        for (TupleDto tupleDto : sortedTuples) {
            tupleToHash(builder, tupleDto.getVerb(), tupleDto.getNoun());
        }

        return builder.toString();
    }

    public static List<String> generateBackEndHashes(TreeSet<TupleDto> sortedTuples) {
        TupleDto[] tupleArray = sortedTuples.toArray(new TupleDto[]{});

        List<StringBuilder> startingList = new ArrayList<StringBuilder>();
        startingList.add(new StringBuilder());
        List<StringBuilder> stringBuilders = generateHashLevels(tupleArray, startingList, 0);

        List<String> output = new ArrayList<String>();

        for (StringBuilder stringBuilder : stringBuilders) {
            output.add(stringBuilder.toString());
        }

        return output;
    }

    private static List<StringBuilder> generateHashLevels(TupleDto[] tupleArray, List<StringBuilder> currentList, int level) {
        if (level >= tupleArray.length) {
            return currentList;
        }

        boolean hasNoun = StringUtils.isNotBlank(tupleArray[level].getNoun());
        List<StringBuilder> withNounList = new ArrayList<StringBuilder>();

        for (StringBuilder stringBuilder : currentList) {
            if(hasNoun){
                StringBuilder toAppendNoun = new StringBuilder(stringBuilder.toString());
                tupleToHash(toAppendNoun, tupleArray[level].getVerb(), tupleArray[level].getNoun());
                withNounList.add(toAppendNoun);
            }

            tupleToHash(stringBuilder, tupleArray[level].getVerb(), null);
        }

        currentList.addAll(withNounList);
        return generateHashLevels(tupleArray, currentList, ++level);
    }

    private static void tupleToHash(StringBuilder builder, String verb, String noun) {
        builder.append(verb);
        if (noun != null) {
            builder.append("@");
            builder.append(noun);
        }
        builder.append("||");
    }
}

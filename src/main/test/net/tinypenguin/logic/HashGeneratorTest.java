package net.tinypenguin.logic;

import junit.framework.TestCase;
import net.tinypenguin.dto.TupleDto;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by Anthony on 26/03/14.
 */
public class HashGeneratorTest extends TestCase {
    public void testSortTuples() throws Exception {

    }

    public void testGenerateFrontEndHash() throws Exception {

    }

    public void testGenerateBackEndHashes() throws Exception {
        TreeSet<TupleDto> sortedTuples = HashGenerator.sortTuples(Arrays.asList(makeTuple("eat", "pizza"), makeTuple("drink", null), makeTuple("love", "my girl")));
        List<String> strings = HashGenerator.generateBackEndHashes(sortedTuples);
        for (String string : strings) {
            System.out.println(string);
        }
    }

    private TupleDto makeTuple(String verb, String noun){
        TupleDto tupleDto = new TupleDto();
        tupleDto.setVerb(verb);
        tupleDto.setNoun(noun);
        return tupleDto;
    }
}

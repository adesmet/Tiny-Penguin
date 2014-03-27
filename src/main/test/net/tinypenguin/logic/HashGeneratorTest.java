package net.tinypenguin.logic;

import junit.framework.TestCase;
import net.tinypenguin.model.TuplePojo;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class HashGeneratorTest extends TestCase {
    //todo: rewrite to use asserts
    @Test
    public void testSortTuples() throws Exception {
        TreeSet<TuplePojo> tuples = HashGenerator.sortTuples(Arrays.asList(makeTuple("eat", null), makeTuple("eat", "dog food"), makeTuple("eat", "meat"), makeTuple("dance", null)));

        for (TuplePojo tuple : tuples) {
            System.out.println(HashGenerator.hashTuple(tuple));
        }
    }

    @Test
    public void testGenerateFrontEndHash() throws Exception {
        TreeSet<TuplePojo> sortedTuples = HashGenerator.sortTuples(Arrays.asList(makeTuple("eat", "pizza"), makeTuple("drink", null), makeTuple("love", "my girl")));
        String string = HashGenerator.generateFrontEndHash(sortedTuples);

        assertEquals(string, "drink||eat@pizza||love@my girl||");
    }

    @Test
    public void testGenerateBackEndHashes() throws Exception {
        TreeSet<TuplePojo> sortedTuples = HashGenerator.sortTuples(Arrays.asList(makeTuple("eat", "pizza"), makeTuple("drink", null), makeTuple("love", "my girl")));
        List<String> strings = HashGenerator.generateBackEndHashes(sortedTuples);
        assertTrue(strings.contains("drink||eat@pizza||love@my girl||"));
        assertTrue(strings.contains("drink||eat||love||"));
        assertTrue(strings.contains("drink||eat||love@my girl||"));
        assertTrue(strings.contains("drink||eat@pizza||love||"));
    }

    @Test
    public void testIntegration() throws Exception {
        TreeSet<TuplePojo> sortedTuples = HashGenerator.sortTuples(Arrays.asList(makeTuple("eat", "pizza"), makeTuple("drink", null), makeTuple("love", "my girl")));

        String frontEndHash = HashGenerator.generateFrontEndHash(sortedTuples);
        List<String> backEndHashes = HashGenerator.generateBackEndHashes(sortedTuples);

        assertTrue(backEndHashes.contains(frontEndHash));
    }
    @Test
    public void testUnhashTuple() throws Exception{
        TuplePojo firstExample = HashGenerator.unhashTuple("eat@pizza||");
        assertEquals(firstExample.getNoun(), "pizza");
        assertEquals(firstExample.getVerb(), "eat");

        TuplePojo secondExample = HashGenerator.unhashTuple("dance||");
        assertEquals(secondExample.getNoun(), null);
        assertEquals(secondExample.getVerb(), "dance");
    }

    private TuplePojo makeTuple(String verb, String noun) {
        TuplePojo tuple = new TuplePojo();
        tuple.setVerb(verb);
        tuple.setNoun(noun);
        return tuple;
    }
}

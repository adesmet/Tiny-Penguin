package net.tinypenguin.model;

import junit.framework.TestCase;

import java.util.TreeSet;
import java.util.UUID;

/**
 * Created by Anthony on 26/03/14.
 */
public class TupleTest extends TestCase {
    public void testTupleSorting() throws Exception {
        TreeSet<Tuple> tuples = new TreeSet<Tuple>();
        for (int i=0; i<10; i++) {
            tuples.add(create(""+Math.floor(Math.random()*10), ""+Math.floor(Math.random()*10)));
        }

        for (Tuple tuple : tuples) {
            System.out.println(tuple);
        }
    }

    private Tuple create(String verb, String noun){
        Tuple tuple = new Tuple();
        NounKeyword theNoun = new NounKeyword();
        theNoun.setKeyword(noun);
        tuple.setNoun(theNoun);

        VerbKeyword theVerb = new VerbKeyword();
        theVerb.setKeyword(verb);
        tuple.setVerb(theVerb);

        return tuple;
    }
}

package net.tinypenguin.dto;

/**
 * Created by Anthony on 26/03/14.
 */
public class TupleDto implements Comparable<TupleDto> {
    public TupleDto() {
    }

    private String verb;
    private String noun;

    public String getVerb() {
        return verb;
    }

    public void setVerb(String verb) {
        this.verb = verb;
    }

    public String getNoun() {
        return noun;
    }

    public void setNoun(String noun) {
        this.noun = noun;
    }

    @Override
    public int compareTo(TupleDto o) {
        int verbCompare = o.getVerb().compareTo(verb);
        if(verbCompare == 0){
            return -o.getNoun().compareTo(noun);
        }
        return -verbCompare;
    }
}

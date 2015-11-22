package net.ghentleman.model;

/**
 * Created by Anthony on 26/03/14.
 */
public class TuplePojo implements Comparable<TuplePojo> {
    public TuplePojo() {
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
    public int compareTo(TuplePojo o) {
        int verbCompare = o.getVerb().compareTo(verb);
        if(verbCompare == 0){
            if(noun == null && o.getNoun() != null){
                return -1;
            }else if(noun != null && o.getNoun() == null){
                return 1;
            }else if(noun == null && o.getNoun() == null){
                return 0;
            }

            // no nouns are null
            return -o.getNoun().compareTo(noun);
        }
        return -verbCompare;
    }
}

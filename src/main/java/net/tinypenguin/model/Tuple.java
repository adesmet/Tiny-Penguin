package net.tinypenguin.model;

import org.mongojack.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Anthony on 19/03/14.
 */
@Document(collection = "tuple")
public class Tuple{
    @ObjectId
    @Id
    private String id = new org.bson.types.ObjectId().toString();

    private VerbKeyword verb;
    private NounKeyword noun;

    public Tuple() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public VerbKeyword getVerb() {
        return verb;
    }

    public void setVerb(VerbKeyword verb) {
        this.verb = verb;
    }

    public NounKeyword getNoun() {
        return noun;
    }

    public void setNoun(NounKeyword noun) {
        this.noun = noun;
    }

    @Override
    public String toString() {
        return "Tuple{" +
                "id='" + id + '\'' +
                ", verb=" + verb +
                ", noun=" + noun +
                '}';
    }
}

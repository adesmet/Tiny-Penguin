package net.tiny.penguin.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Query {

    @JsonProperty("verb")
    private Integer verb;
    @JsonProperty("noun")
    private Integer noun;

    @JsonProperty("verb")
    public Integer getVerb() {
        return verb;
    }

    @JsonProperty("verb")
    public void setVerb(Integer verb) {
        this.verb = verb;
    }

    @JsonProperty("noun")
    public Integer getNoun() {
        return noun;
    }

    @JsonProperty("noun")
    public void setNoun(Integer noun) {
        this.noun = noun;
    }

}
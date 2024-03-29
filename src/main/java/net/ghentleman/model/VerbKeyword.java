package net.ghentleman.model;

import org.mongojack.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "verb")
public class VerbKeyword implements Keyword {

    @ObjectId @Id
    private String id = new org.bson.types.ObjectId().toString();

    private String keyword;

    public VerbKeyword() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public String toString() {
        return keyword;
    }
}

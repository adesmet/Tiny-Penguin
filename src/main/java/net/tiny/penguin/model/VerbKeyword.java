package net.tiny.penguin.model;

import org.mongojack.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "verb")
public class VerbKeyword implements KeywordI {

    @ObjectId @Id
    private String id;

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
}

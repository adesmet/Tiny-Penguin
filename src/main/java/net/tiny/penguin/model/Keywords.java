package net.tiny.penguin.model;


import org.mongojack.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "keywords")
public class Keywords {

    @ObjectId @Id
    private String id;
    @DBRef
    private List<KeywordI> keywords;

    public Keywords() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<KeywordI> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<KeywordI> keywords) {
        this.keywords = keywords;
    }
}

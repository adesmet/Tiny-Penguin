package net.tiny.penguin.model;


import org.springframework.data.annotation.Id;

public interface KeywordI {

    @Id
    public String getId();

    public String getKeyword();
}

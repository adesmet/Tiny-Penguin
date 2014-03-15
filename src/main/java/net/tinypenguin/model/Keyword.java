package net.tinypenguin.model;


import org.springframework.data.annotation.Id;

public interface Keyword {

    @Id
    public String getId();

    public String getKeyword();
}

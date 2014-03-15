package net.tiny.penguin.service;

import net.tiny.penguin.json.Query;

public interface KeywordService {

    int register(String userId, Query query);
}

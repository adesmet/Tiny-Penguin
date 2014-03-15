package net.tinypenguin.service;

import net.tinypenguin.json.Query;

public interface KeywordService {
    int register(String userId, Query query);
}

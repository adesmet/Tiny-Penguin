package net.tinypenguin.service;

import net.tinypenguin.json.Query;

import java.util.ArrayList;
import java.util.HashMap;

public interface KeywordService {
    HashMap<String,ArrayList<String>> fetchKeywords();
}

package net.ghentleman.service;

import java.util.ArrayList;
import java.util.HashMap;

public interface KeywordService {
    HashMap<String,ArrayList<String>> fetchKeywords();
}

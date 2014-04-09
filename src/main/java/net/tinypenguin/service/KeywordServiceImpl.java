package net.tinypenguin.service;

import net.tinypenguin.dao.UserDao;
import net.tinypenguin.json.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class KeywordServiceImpl implements KeywordService {

    @Override
    public HashMap<String,ArrayList<String>> fetchKeywords() {

        return null;
    }

}

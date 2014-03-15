package net.tinypenguin.service;

import net.tinypenguin.dao.UserDao;
import net.tinypenguin.json.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class KeywordServiceImpl implements KeywordService {

    @Resource
    private UserDao userDao;

    @Override
    public int register(String userId, Query query) {
        //TODO add user <-> queries
        //TODO search for other queries like this and return the result (count)
        return 42;
    }

}

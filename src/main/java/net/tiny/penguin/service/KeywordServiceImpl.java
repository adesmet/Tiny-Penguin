package net.tiny.penguin.service;

import net.tiny.penguin.dao.UserDao;
import net.tiny.penguin.json.Query;
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
        return 0;
    }

}

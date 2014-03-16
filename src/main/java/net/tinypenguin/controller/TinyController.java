package net.tinypenguin.controller;


import com.mongodb.DB;
import net.tinypenguin.dao.UserDao;
import net.tinypenguin.json.Query;
import net.tinypenguin.model.Keywords;
import net.tinypenguin.model.User;
import net.tinypenguin.service.KeywordService;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.support.PersistenceExceptionTranslator;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.ws.rs.*;

@Controller
@Path("tiny")
public class TinyController {

    @Resource
    UserDao userDao;

    @Resource
    KeywordService keywordService;

    @POST
    @Consumes("application/json")
    @Produces("text/plain")
    public int register(String uid, Query query) {
        return keywordService.register(uid, query);
    }

    @GET
    public String test() {
    //TODO: pas op, delete all
        userDao.deleteAll();
        User user = new User();
        user.setId("I've just done stuff to the db and the connection works");
        userDao.save(user);

        return userDao.findAll().get(0).getId();
    }
}

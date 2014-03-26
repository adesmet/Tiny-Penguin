package net.tinypenguin.controller;


import net.tinypenguin.dao.EntryDao;
import net.tinypenguin.dao.UserDao;
import net.tinypenguin.dto.EntryDto;
import net.tinypenguin.json.Query;
import net.tinypenguin.model.*;
import net.tinypenguin.service.KeywordService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@Path("tiny")
public class TinyController {

    @Resource
    UserDao userDao;

    @Resource
    EntryDao entryDao;

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
        User user = new User();
        user.setId("I've just done stuff to the db and the connection works");
        userDao.save(user);
        return userDao.findAll().get(0).getId();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/post")
    public List<EntryDto> createTrackInJSON(EntryDto entryDto) {

        return null;
    }
}

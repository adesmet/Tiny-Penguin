package net.tinypenguin.controller;


import net.tinypenguin.dao.EntryDao;
import net.tinypenguin.dao.UserDao;
import net.tinypenguin.dto.EntryDto;
import net.tinypenguin.json.Query;
import net.tinypenguin.model.*;
import net.tinypenguin.service.EntryService;
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
    //todo: remove entry daos
    @Resource
    EntryDao entryDao;

    @Resource
    UserDao userDao;

    @Resource
    EntryService entryService;

    @Resource
    KeywordService keywordService;

    @GET
    @Path("/delete")
    public String deleteAll() {
        entryDao.deleteAll();
        return "All entries removed.";
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
    @Path("/postNoSave")
    public List<EntryDto> getEntries(EntryDto entryDto) {
        return entryService.getEntriesWithoutSaving(entryDto);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/post")
    public List<EntryDto> postEntry(EntryDto entryDto) {
        return entryService.processEntry(entryDto);
    }
}

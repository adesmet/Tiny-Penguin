package net.tinypenguin.controller;


import net.tinypenguin.json.Query;
import net.tinypenguin.service.KeywordService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.ws.rs.*;

@Controller
@Path("tiny")
public class TinyController {

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
        return "All ok";
    }
}

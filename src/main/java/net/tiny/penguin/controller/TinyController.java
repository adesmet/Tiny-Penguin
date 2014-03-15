package net.tiny.penguin.controller;

import net.tiny.penguin.json.Query;
import net.tiny.penguin.service.KeywordService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;


@Controller
@RequestMapping("/tiny")
public class TinyController {

    @Resource
    KeywordService keywordService;

    @RequestMapping(value = "/register", method = {RequestMethod.POST}, consumes = "application/json", produces = "text/plain")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody int register(@RequestParam(value = "uid") String uid, @RequestBody Query query) {
        return keywordService.register(uid, query);
    }
}

package net.ghentleman.controller;

import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Controller
@Path("keyword")
public class KeywordController {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/fetch")
    public HashMap<String, List<String>> fetchKeywords() {
        HashMap<String, List<String>> list = new HashMap<String, List<String>>();

        list.put("Eating", Arrays.asList("Pizza", "Kebab", "Fish", "Meat", "Vegetables"));
        list.put("Playing", Arrays.asList("Video games", "Cards", "Outside", "Hide & seek"));
        list.put("Sitting", Arrays.asList("On the floor", "In the yard", "In the couch"));

        return list;
    }
}

package net.ghentleman.controller;


import net.ghentleman.dao.EntryDao;
import net.ghentleman.dao.UserDao;
import net.ghentleman.dto.EntryDto;
import net.ghentleman.model.User;
import net.ghentleman.service.EntryService;
import net.ghentleman.service.KeywordService;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Controller
@Path("activity")
public class ActivityController {
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
        List<EntryDto> entryDtos = entryService.processEntry(entryDto);

        //TODO add test images
        for (EntryDto dto : entryDtos) {
            dto.getUserDto().setThumbnail(getUserImage());
        }

        return entryDtos;
    }

    //TODO test method
    private byte[] getUserImage() {
        ByteArrayOutputStream bais = new ByteArrayOutputStream();
        InputStream is = null;
        try {
            String image = "http://img.pandawhale.com/55294-easter-egg-meme-BYo0.jpeg";
            URL url = new URL(image);
            is = url.openStream();
            byte[] byteChunk = new byte[4096]; // Or whatever size you want to read in at a time.
            int n;

            while ((n = is.read(byteChunk)) > 0) {
                bais.write(byteChunk, 0, n);
            }
            return bais.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @GET
    @Path("/randomUser")
    public String getForwardNews() throws Exception {
        String url = "http://api.randomuser.me/?seed=" + new ObjectId().toString();

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", "Mozilla/5.0");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer resp = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            resp.append(inputLine);
        }
        in.close();

        return resp.toString();
    }
}

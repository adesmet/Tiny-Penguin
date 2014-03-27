package net.tinypenguin.model;

import org.mongojack.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "entry")
public class Entry {
    @ObjectId
    @Id
    private String id = new org.bson.types.ObjectId().toString();

    private List<String> tuples = new ArrayList<String>();

    private List<String> hashes = new ArrayList<String>();

    private User user;

    private LocationPojo location;

    public Entry() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getTuples() {
        return tuples;
    }

    public void setTuples(ArrayList<String> tuples) {
        this.tuples = tuples;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocationPojo getLocation() {
        return location;
    }

    public void setLocation(LocationPojo location) {
        this.location = location;
    }

    public List<String> getHashes() {
        return hashes;
    }

    public void setHashes(List<String> hashes) {
        this.hashes = hashes;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "id='" + id + '\'' +
                ", tuples=" + tuples +
                ", user=" + user +
                ", location=" + location +
                '}';
    }
}

package net.tinypenguin.model;

import org.mongojack.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

@Document(collection = "entry")
public class Entry {
    @ObjectId
    @Id
    private String id = new org.bson.types.ObjectId().toString();

    private ArrayList<String> tuples = new ArrayList<String>();

    private ArrayList<String> hashes = new ArrayList<String>();

    private User user;

    private Location location;

    public Entry() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<String> getTuples() {
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public ArrayList<String> getHashes() {
        return hashes;
    }

    public void setHashes(ArrayList<String> hashes) {
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

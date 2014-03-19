package net.tinypenguin.model;

import org.mongojack.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "entry")
public class Entry {
    @ObjectId
    @Id
    private String id;

    private ArrayList<Tuple> tuples = new ArrayList<Tuple>();

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

    public ArrayList<Tuple> getTuples() {
        return tuples;
    }

    public void setTuples(ArrayList<Tuple> tuples) {
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

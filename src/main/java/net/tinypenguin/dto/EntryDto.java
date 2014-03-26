package net.tinypenguin.dto;

import net.tinypenguin.model.Location;
import net.tinypenguin.model.User;

import java.util.ArrayList;

/**
 * Created by Anthony on 26/03/14.
 */
public class EntryDto {

    private ArrayList<String> tuples = new ArrayList<String>();

    private User user;

    private Location location;

    public EntryDto() {
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

}

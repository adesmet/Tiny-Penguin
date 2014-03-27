package net.tinypenguin.dto;

import net.tinypenguin.logic.HashGenerator;
import net.tinypenguin.model.Entry;
import net.tinypenguin.model.LocationPojo;
import net.tinypenguin.model.TuplePojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anthony on 26/03/14.
 */
public class EntryDto {

    private ArrayList<TuplePojo> tuples = new ArrayList<TuplePojo>();

    private UserDto userDto;

    private LocationPojo location;

    public EntryDto() {
    }


    public ArrayList<TuplePojo> getTuples() {
        return tuples;
    }

    public void setTuples(ArrayList<TuplePojo> tuples) {
        this.tuples = tuples;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public LocationPojo getLocation() {
        return location;
    }

    public void setLocation(LocationPojo location) {
        this.location = location;
    }

    public static List<EntryDto> fromEntries(List<Entry> entries){
        ArrayList<EntryDto> entryDtos = new ArrayList<EntryDto>();

        if(entries == null){
            return entryDtos;
        }

        for (Entry entry : entries) {
            entryDtos.add(fromEntry(entry));
        }

        return entryDtos;
    }

    public static EntryDto fromEntry(Entry entry) {
        EntryDto entryDto = new EntryDto();
        entryDto.setUserDto(UserDto.fromUser(entry.getUser()));
        entryDto.setLocation(entry.getLocation());
        ArrayList<TuplePojo> tuples = new ArrayList<TuplePojo>();

        for (String tupleHash : entry.getTuples()) {
            tuples.add(HashGenerator.unhashTuple(tupleHash));
        }

        entryDto.setTuples(tuples);
        return entryDto;
    }

    public Entry toEntry(List<String> backEndHashes){
        Entry entry = new Entry();
        entry.setLocation(location);
        entry.setUser(userDto.toUser());
        entry.setHashes(backEndHashes);

        ArrayList<String> tupleHashes = new ArrayList<String>();
        for (TuplePojo tuple : tuples) {
            tupleHashes.add(HashGenerator.hashTuple(tuple));
        }

        entry.setTuples(tupleHashes);

        return entry;
    }

}

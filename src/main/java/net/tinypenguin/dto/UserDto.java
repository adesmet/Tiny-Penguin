package net.tinypenguin.dto;

/**
 * Created by Anthony on 26/03/14.
 */
public class UserDto {
    private String id;

    public UserDto() {
    }

    private byte[] thumbnail = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public byte[] getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(byte[] thumbnail) {
        this.thumbnail = thumbnail;
    }
}

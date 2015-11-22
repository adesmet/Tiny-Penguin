package net.ghentleman.dto;

import net.ghentleman.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDto {
    private String id;

    private byte[] thumbnail = null;

    public UserDto() {
    }

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

    public static List<UserDto> fromUsers(List<User> users) {
        ArrayList<UserDto> userDtos = new ArrayList<UserDto>();

        if (users == null || users.isEmpty()) {
            return userDtos;
        }

        for (User user : users) {
            userDtos.add(UserDto.fromUser(user));
        }

        return userDtos;
    }

    public static UserDto fromUser(User user) {
        if (user == null) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setThumbnail(user.getThumbnail());

        return userDto;
    }

    public User toUser() {
        User user = new User();

        if (id != null) {
            user.setId(id);
        }

        user.setThumbnail(thumbnail);

        return user;
    }
}

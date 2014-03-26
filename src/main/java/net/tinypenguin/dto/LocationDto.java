package net.tinypenguin.dto;

/**
 * Created by Anthony on 26/03/14.
 */
public class LocationDto {
    private Long lat;
    private Long lng;
    private String address;

    public LocationDto() {
    }

    public Long getLat() {
        return lat;
    }

    public void setLat(Long lat) {
        this.lat = lat;
    }

    public Long getLng() {
        return lng;
    }

    public void setLng(Long lng) {
        this.lng = lng;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

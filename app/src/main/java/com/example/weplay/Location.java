package com.example.weplay;

public class Location {
    String locationId;

    String playGroundLocation;

    public Location(String locationId,String playGroundLocation) {
        this.locationId = locationId;
        this.playGroundLocation = playGroundLocation;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getPlayGroundLocation() {
        return playGroundLocation;
    }

    public void setPlayGroundLocation(String playGroundLocation) {
        this.playGroundLocation = playGroundLocation;
    }
}

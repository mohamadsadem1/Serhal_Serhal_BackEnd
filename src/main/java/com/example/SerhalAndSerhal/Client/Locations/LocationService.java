package com.example.SerhalAndSerhal.Client.Locations;

import com.example.SerhalAndSerhal.Client.Locations.DTO.LocationRequest;
import com.example.SerhalAndSerhal.Client.Locations.DTO.LocationResponse;

public interface LocationService {

    public void createLocation(LocationRequest locationRequest);

    public LocationResponse updateLocation(LocationRequest locationRequest);

    public LocationResponse deleteLocation(LocationRequest locationRequest);

    public LocationResponse getLocationById(Long id);

    public LocationResponse getLocationByName(String name);
}

package com.example.SerhalAndSerhal.Client.Locations;

import com.example.SerhalAndSerhal.Client.Locations.DTO.LocationRequest;
import com.example.SerhalAndSerhal.Client.Locations.DTO.LocationResponse;
import com.example.SerhalAndSerhal.Exceptions.LocationAlreadyExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    @Override
    public void createLocation(LocationRequest locationRequest) {

        Optional<Location> optionalLocation = locationRepository.findLocationByName(locationRequest.getLocation());
        if (optionalLocation.isPresent()) {
            throw new LocationAlreadyExistException("Brand already exists for location ");
        }


        locationRepository.save(Location.builder()
                .Street(locationRequest.getStreet())
                .City(locationRequest.getCity())
                .build());
    }

    @Override
    public LocationResponse updateLocation(LocationRequest locationRequest) {
        return null;
    }

    @Override
    public LocationResponse deleteLocation(LocationRequest locationRequest) {
        return null;
    }

    @Override
    public LocationResponse getLocationById(Long id) {
        return null;
    }

    @Override
    public LocationResponse getLocationByName(String name) {
        return null;
    }
}

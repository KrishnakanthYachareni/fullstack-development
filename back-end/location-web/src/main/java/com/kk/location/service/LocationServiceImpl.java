/*
 * Copyright (c) 2020. Krishnakanth Yachareni
 */

package com.kk.location.service;

import com.kk.location.entities.Location;
import com.kk.location.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository repository;

    @Override
    public Location saveLocation(Location location) {
        return repository.save(location);
    }

    @Override
    public Location updateLocation(Location location) {
        return repository.save(location);
    }

    @Override
    public void deleteLocation(Location location) {
        repository.delete(location);
    }

    @Override
    public Location getLocationById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Location> getAllLocations() {
        return repository.findAll();
    }
}

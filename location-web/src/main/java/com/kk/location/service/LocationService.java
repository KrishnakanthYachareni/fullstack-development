/*
 * Copyright (c) 2020. Krishnakanth Yachareni
 */

package com.kk.location.service;

import com.kk.location.entities.Location;

import java.util.List;

public interface LocationService {
    Location saveLocation(Location location);

    Location updateLocation(Location location);

    void deleteLocation(Location location);

    Location getLocationById(int id);

    List<Location> getAllLocations();
}

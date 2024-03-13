package org.ritesh;

import java.util.HashSet;
import java.util.Set;

public class Ship {
    String id;
    int size;
    Set<Coordinate> coordinates;

    public Ship(String id, int size) {
        this.id = id;
        this.size = size;
        this.coordinates = new HashSet<>();
    }
}

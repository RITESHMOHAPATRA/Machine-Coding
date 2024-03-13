package org.ritesh;

import java.util.ArrayList;
import java.util.List;

public class Player {
    String name;
    List<Ship> fleet;

    public Player(String name) {
        this.name = name;
        this.fleet = new ArrayList<>();
    }
}

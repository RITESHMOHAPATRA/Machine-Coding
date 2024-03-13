package org.ritesh;

import java.util.HashMap;
import java.util.Map;

public class Battlefield {
    int size;
    char[][] grid;
    Map<Coordinate, Ship> shipMap;

    public Battlefield(int size) {
        this.size = size;
        this.grid = new char[size][size];
        this.shipMap = new HashMap<>();
        initializeGrid();
    }

    private void initializeGrid() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = '.';
            }
        }
    }

    public void addShip(Ship ship, Coordinate start) {
        for (int i = start.x; i < start.x + ship.size; i++) {
            for (int j = start.y; j < start.y + ship.size; j++) {
                grid[i][j] = ship.id.charAt(0);
                ship.coordinates.add(new Coordinate(i, j));
                shipMap.put(new Coordinate(i, j), ship);
            }
        }
    }

    public boolean isHit(Coordinate coordinate) {
        return shipMap.containsKey(coordinate);
    }

    public void markHit(Coordinate coordinate) {
        Ship ship = shipMap.get(coordinate);
        ship.coordinates.remove(coordinate);
        if (ship.coordinates.isEmpty()) {
            System.out.println("Hit! " + ship.id + " of " + ship.id.charAt(0) + " destroyed.");
            shipMap.remove(coordinate);
        }
    }

    public void displayGrid() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}

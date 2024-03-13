package org.ritesh;

import java.util.Random;

public class BattleshipGame {
    Player playerA;
    Player playerB;
    Battlefield battlefield;

    public BattleshipGame(int N) {
        this.playerA = new Player("Player A");
        this.playerB = new Player("Player B");
        this.battlefield = new Battlefield(N);
    }

    public void addShip(Player player, Ship ship, Coordinate coordinate) {
        battlefield.addShip(ship, coordinate);
        player.fleet.add(ship);
    }

    public void startGame() {
        Player currentPlayer = playerA;
        Player opponentPlayer = playerB;
        Random random = new Random();

        while (!playerA.fleet.isEmpty() && !playerB.fleet.isEmpty()) {
            Coordinate target = new Coordinate(random.nextInt(battlefield.size), random.nextInt(battlefield.size));

            System.out.println(currentPlayer.name + "'s turn: Missile fired at (" + target.x + ", " + target.y + ").");

            if (battlefield.isHit(target)) {
                battlefield.markHit(target);
            } else {
                System.out.println("Miss.");
            }

            // Switch players
            Player temp = currentPlayer;
            currentPlayer = opponentPlayer;
            opponentPlayer = temp;
        }

        System.out.println("Game over. " + (playerA.fleet.isEmpty() ? "Player B" : "Player A") + " wins!");
    }
}

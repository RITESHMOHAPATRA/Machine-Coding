package org.ritesh;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        BattleshipGame game = new BattleshipGame(10);
        game.addShip(game.playerA, new Ship("SH1", 4), new Coordinate(0, 0));
        game.addShip(game.playerB, new Ship("SH2", 4), new Coordinate(5, 5));
        game.startGame();
    }
}

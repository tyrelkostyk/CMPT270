package model;

/**
 * The interface to control the Game, and information needed to control the Game.
 */
public interface GameControl {
    void start();

    void togglePaused();

    Player getPlayer();
}

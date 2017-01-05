package de.craften.plugins.gameapi.providers.game;

public interface Game {

	/**
     * Gets the id of the game.
     * This id must be unique. Use e.g. your package name. 
     *
     * @return unique game id
     */
	public String getGameID();
	
	/**
     * Gets the display name of the game.
     *
     * @return the display name of the game
     */
	public String getDisplayName();
	
}

package de.craften.plugins.gameapi.providers.game;

public interface Game {

	/**
     * Gets the id of the game.
     * This id should be unique. Use e.g. your package name. 
     *
     * @return unique game id
     */
	public String getGameID();
	
	/**
     * Gets the display name of the game.
     *
     * @return unique game id
     */
	public String getDisplayName();
	
}

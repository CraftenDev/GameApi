package de.craften.plugins.gameapi.providers;


import de.craften.plugins.gameapi.GameApi;
import de.craften.plugins.gameapi.GameManager;

public class GameProvider {

	private GameApi plugin;
	
	public GameProvider(GameApi plugin) {
		this.plugin = plugin;
	}
	
	public GameManager getGameManager() {
		return plugin.getGameManager();
	}
	
}

package de.craften.plugins.gameapi.providers;

import java.util.Optional;

import de.craften.plugins.gameapi.GameApi;
import de.craften.plugins.gameapi.providers.game.Game;

public class GameProvider {

	private GameApi plugin;
	
	public GameProvider(GameApi plugin) {
		this.plugin = plugin;
	}
	
	public void registerGame(Game game) {
		plugin.getGameManager().addGame(game);
	}
	
	public Optional<Game> getGame(String gameID) {
		return plugin.getGameManager().getGame(gameID);
	}

}

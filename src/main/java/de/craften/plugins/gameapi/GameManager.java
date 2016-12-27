package de.craften.plugins.gameapi;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import de.craften.plugins.gameapi.providers.game.Game;

public class GameManager {

	private final GameApi plugin;
	
	private Map<String, Game> games = new HashMap<String, Game>();
	
	public GameManager(GameApi plugin) {
		this.plugin = plugin;
	}
	
	public boolean addGame(Game game) {
		
		if (games.containsKey(game.getGameID())) {
			plugin.getLogger().warning("Duplicated game id: " + game.getGameID());
			return false;
		}
		
		this.games.put(game.getGameID(), game);
		plugin.getLogger().info("New game registered: " + game.getGameID());
		
		return true;
	}

	public Optional<Game> getGame(String gameID) {
		return Optional.ofNullable(games.get(gameID));
	}
	
	public Collection<Game> getGames() {
		return games.values();
	}
}

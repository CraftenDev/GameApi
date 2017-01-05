package de.craften.plugins.gameapi;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import de.craften.plugins.gameapi.providers.game.Arena;
import de.craften.plugins.gameapi.providers.game.Game;
import de.craften.plugins.gameapi.providers.game.Arena.EndReason;

public class GameManager {

	private final GameApi plugin;
	
	private Map<String, Game> games = new HashMap<String, Game>();
	
	private Map<String, Map<String, Arena>> arenas = new HashMap<String, Map<String, Arena>>();
	
	public GameManager(GameApi plugin) {
		this.plugin = plugin;
	}
	
	public void addGame(Game game) {
		
		if (games.containsKey(game.getGameID())) {
			throw new RuntimeException("Duplicated game id: " + game.getGameID());
		}
		
		this.games.put(game.getGameID(), game);
		plugin.getLogger().info("New game registered: " + game.getGameID());
		
	}

	public Optional<Game> getGame(String gameID) {
		return Optional.ofNullable(games.get(gameID));
	}
	
	public Collection<Game> getGames() {
		return games.values();
	}
	
	public void startArena(Game game, Arena arena) {
		String gameID = game.getGameID();
		if (arenas.get(gameID) == null) {
			arenas.put(gameID, new HashMap<String, Arena>());
		}
		arena.onStart();
		
		if (arena.getMaxRoundTime() != -1) {
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				
				@Override
				public void run() {
					arena.onEnd(EndReason.NO_TIME_LEFT);
				}
			}, arena.getMaxRoundTime());
		}
		
		arenas.get(gameID).put(arena.getArenaID(), arena);
		
	}
	
	public Map<String, Arena> getArenas(Game game) {
		String gameID = game.getGameID();
		if (arenas.get(gameID) == null) {
			arenas.put(gameID, new HashMap<String, Arena>());
		}
		return arenas.get(gameID);
	}
	
	public Optional<Arena> getArena(Game game, String arenaID) {
		
		return Optional.ofNullable(arenas.get(game.getGameID()).get(arenaID));
		
	}
	
}

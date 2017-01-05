package de.craften.plugins.gameapi.providers.game;

import java.util.Optional;

import org.bukkit.entity.Player;

public interface Arena {

	/**
     * Gets the lobby of this arena.
     * If there is no lobby the optional is empty.
     *
     * @return the lobby
     */
	public default Optional<Lobby> getLobby() {
		return Optional.empty();
	}
	
	/**
     * Gets the id of the arena.
     * This id must be unique. 
     *
     * @return unique arena id
     */
	public String getArenaID();
	
	public void onStart();
	
	public void onEnd(EndReason reason);
	
	/**
     * This method will be called, after a player joins the arena.
     * @param player who joined the arena
     *
     */
	public void onPlayerJoin(Player player);
	
	/**
     * Gets the maximal round time in ticks.
     * If there is no maximal round time return the value -1.
     *
     * @return the maximal round time in ticks.
     */
	public default long getMaxRoundTime() {
		return -1;
	}
	
	public Game getGame();
	
	public enum EndReason {
		NORMAL, NO_TIME_LEFT
	}
	
}

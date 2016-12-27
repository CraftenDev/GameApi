package de.craften.plugins.gameapi;

import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;

import de.craften.plugins.gameapi.providers.GameProvider;

public class GameApi extends JavaPlugin{

	private GameProvider provider;
	
	private GameManager gameManager;
	
	private static boolean debug = true;
	
	@Override
	public void onLoad() {
		
		super.onLoad();
	}
	
	@Override
	public void onEnable() {
		
		this.provider = new GameProvider(this);
		
		getServer().getServicesManager().register(GameProvider.class, provider, this, ServicePriority.Normal);
		
		super.onEnable();
	}
	
	@Override
	public void onDisable() {
		
		super.onDisable();
	}
	
	public GameProvider getProvider() {
		return provider;
	}
	
	public GameManager getGameManager() {
		return gameManager;
	}
	
	public static boolean isDebbuging() {
		return debug;
	}
	
}

package com.ystoreplugins.ybolsa;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.ystoreplugins.ybolsa.api.yBolsaAPI;
import com.ystoreplugins.ybolsa.config.Config;
import com.ystoreplugins.ybolsa.methods.BolsaTask;
import com.ystoreplugins.ybolsa.placeholders.PlaceholderAPI;

public class Main extends JavaPlugin {
	
	public Config config = new Config();

	@Override
	public void onEnable() {
		saveDefaultConfig();
		register();
		Bukkit.getConsoleSender().sendMessage("§7================================");
		Bukkit.getConsoleSender().sendMessage("§7| §6Plugin yBolsa enabled!");
		Bukkit.getConsoleSender().sendMessage("§7| §6Made by yChusy.");
		Bukkit.getConsoleSender().sendMessage("§7| §6Version " + getDescription().getVersion());
		Bukkit.getConsoleSender().sendMessage("§7================================");
	}

	@Override
	public void onDisable() {
		saveDefaultConfig();
		Bukkit.getConsoleSender().sendMessage("§7================================");
		Bukkit.getConsoleSender().sendMessage("§7| §6Plugin yBolsa disabled!");
		Bukkit.getConsoleSender().sendMessage("§7| §6Made by yChusy.");
		Bukkit.getConsoleSender().sendMessage("§7| §6Version " + getDescription().getVersion());
		Bukkit.getConsoleSender().sendMessage("§7================================");
	}

	private void register() {
		config.setup(this);
		yBolsaAPI.ybolsa = new yBolsaAPI();
		new PlaceholderAPI(this).register();
		if (getConfig().getBoolean("Bolsa.Ativar"))
			new BolsaTask(this).runTaskTimerAsynchronously(this, 20, 20 * config.delay);
	}
	
	public static yBolsaAPI getAPI() {
		return yBolsaAPI.ybolsa;
	}
}
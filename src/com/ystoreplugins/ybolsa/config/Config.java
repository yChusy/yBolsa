package com.ystoreplugins.ybolsa.config;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.ConfigurationSection;

import com.ystoreplugins.ybolsa.Main;

public class Config {
	
	public int min, max, delay;
	public List<String> valorizou = new ArrayList<>();
	public List<String> desvalorizou = new ArrayList<>();

	public Config setup(Main main) {
		Config config = main.config;
		
		ConfigurationSection bolsa = main.getConfig().getConfigurationSection("Bolsa");
		config.min = bolsa.getInt("Min");
		config.max = bolsa.getInt("Max");
		config.delay = bolsa.getInt("Delay");
		
		ConfigurationSection mensagens = main.getConfig().getConfigurationSection("Mensagens");
		mensagens.getStringList("Valorizou").forEach(msg -> config.valorizou.add(msg.replace('&', '§')));
		mensagens.getStringList("Desvalorizou").forEach(msg -> config.desvalorizou.add(msg.replace('&', '§')));
		
		return this;
	}
}

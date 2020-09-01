package com.ystoreplugins.ybolsa.placeholders;

import org.bukkit.OfflinePlayer;

import com.ystoreplugins.ybolsa.Main;
import com.ystoreplugins.ybolsa.methods.BolsaTask;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;

public class PlaceholderAPI extends PlaceholderExpansion {
	
	private final Main main;
	
	public PlaceholderAPI(Main main) {
        this.main = main;
    }
	
	@Override
    public boolean canRegister() {
        return true;
    }

	@Override
	public String getAuthor() {
		return "yChusy";
	}

	@Override
	public String getIdentifier() {
		return "ybolsa";
	}

	@Override
	public String getVersion() {
		return main.getDescription().getVersion();
	}
	
	@Override
    public String onRequest(OfflinePlayer player, String identifier){
        if(identifier.equals("bolsa")){
            return "" + BolsaTask.valor;
        }
        return null;
    }
}

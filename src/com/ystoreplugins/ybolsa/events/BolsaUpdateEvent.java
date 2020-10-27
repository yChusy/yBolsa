package com.ystoreplugins.ybolsa.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class BolsaUpdateEvent extends Event {
	
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private double antigo;
    private double novo;
    
    public BolsaUpdateEvent(double antigo, double novo){
        this.antigo = antigo;
        this.novo = novo;
    }
    
    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
    
    public double getAntigo() {
    	return antigo;
    }
    
    public void setAntigo(double antigo) {
    	this.antigo = antigo;
    }

	public double getNovo() {
		return novo;
	}

	public void setNovo(double novo) {
		this.novo = novo;
	}
}
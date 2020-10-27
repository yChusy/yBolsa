package com.ystoreplugins.ybolsa.methods;

import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import com.ystoreplugins.ybolsa.Main;
import com.ystoreplugins.ybolsa.events.BolsaUpdateEvent;

public class BolsaTask extends BukkitRunnable {

	public static int valor;
	private final Main main;

	public BolsaTask(Main main) {
		this.main = main;
	}

	@Override
	public void run() {
		int antigo = valor;

		int i = ThreadLocalRandom.current().nextInt(main.config.min, main.config.max);
		valor = i;
		
		BolsaUpdateEvent updateEvent = new BolsaUpdateEvent(antigo, valor);
		Bukkit.getScheduler().runTask(main, () -> main.getServer().getPluginManager().callEvent(updateEvent));

		if (valor > antigo) {
			Bukkit.getOnlinePlayers().forEach(p -> {
				main.config.valorizou.forEach(msg -> {
					p.sendMessage(msg.replace("{antigo}", "" + antigo).replace("{novo}", "" + valor));
				});
			});
			return;
		}
		
		Bukkit.getOnlinePlayers().forEach(p -> {
			main.config.desvalorizou.forEach(msg -> {
				p.sendMessage(msg.replace("{antigo}", "" + antigo).replace("{novo}", "" + valor));
			});
		});
		
		return;
	}
}

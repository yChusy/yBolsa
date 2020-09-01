package com.ystoreplugins.ybolsa.api;

import com.ystoreplugins.ybolsa.methods.BolsaTask;

public class yBolsaAPI {
	
	public static yBolsaAPI ybolsa;
	
	public int getBolsaValor() {
		return BolsaTask.valor;
	}
}

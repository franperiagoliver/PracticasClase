package com.everis.curso;

import java.util.ArrayList;

import com.everis.otro.Tarjeta;

public class Main {

	public static void main(String[] args) {
		ArrayList<Tarjeta> lista = new ArrayList<Tarjeta>();
		Tarjeta tj1 = new Tarjeta(1, "Luis", "luis@net.com");
		Tarjeta tj2 = new Tarjeta(1, "Pepe", "pepe@net.com");
		
		lista.add(tj1);
		lista.add(tj2);
		
		System.out.println("Mi agenda:");
		System.out.println(lista.get(0).toString());
		System.out.println(lista.get(1).toString());
		
	}
	
}

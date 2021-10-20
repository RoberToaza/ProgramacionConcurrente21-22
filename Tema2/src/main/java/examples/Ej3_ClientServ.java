package examples;

import static es.urjc.etsii.code.concurrency.SimpleConcurrent.*;

public class Ej3_ClientServ {
	
	static volatile boolean pedido;
	static volatile boolean respondido;
	
	static volatile double respuesta;	
	static volatile double peticion;
	
	
	public static void client() {
		peticion = Math.random();
		pedido = true;
		while(!respondido);
		printlnI("Respuesta: "+respuesta);
		
	}
	
	public static void server() {
		while(!pedido);
		respuesta = peticion + 1;
		respondido = true;
		
	}
	
	public static void main(String[] args) {
		
		pedido = false;
		respondido = false;
		
		createThread("client");
		createThread("server");
		
		startThreadsAndWait();
		
	}

}

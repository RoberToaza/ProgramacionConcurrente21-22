package examples;

import static es.urjc.etsii.code.concurrency.SimpleConcurrent.*;

public class Ej1_ProdCons {
	
	static volatile boolean ready;
	static volatile double producto;
	
	public static void productor() {
		producto = Math.random();
		ready = true;
	}
	
	public static void consumidor() {
		
		while(!ready);
		printlnI("Producido: " + producto);
	}
	
	public static void main(String args[]) {
		
		ready = false;
		
		createThread("productor");
		createThread("consumidor");
		
		startThreadsAndWait();
		
	}

}

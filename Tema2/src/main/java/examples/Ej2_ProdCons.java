package examples;

import static es.urjc.etsii.code.concurrency.SimpleConcurrent.*;

public class Ej2_ProdCons {
	
	static volatile boolean consumido;
	static volatile int num;
	
	public static void productor() {
		num = 0;
		
		for(int i = 0; i<4; i++) {
			while(!consumido);
			num++;
			consumido = false;
		}
	}
	
	public static void consumidor() {
		for(int j = 0; j <5; j++) {
			while(consumido);
			printlnI(""+num);
			sleep(500);
			consumido = true;
		}
		
	}

	public static void main(String[] args) {
		consumido = false;
		
		createThread("consumidor");
		createThread("productor");
		
		startThreadsAndWait();
	}
	
	
}

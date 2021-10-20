package examples;

import static es.urjc.etsii.code.concurrency.SimpleConcurrent.*;

public class Ej4B_NCLients1ServerNPeticiones {
	
	static volatile boolean pedido;
	static volatile boolean respondido;
	
	static volatile int[] respuestas;
	static volatile int[] peticiones;
	
	static final int N = 2;
	
	public static void client(int num) {
		peticiones[num] = num*10;
		for (int i = 0; i<N; i++) {
			peticiones[num] = peticiones[num]+1;
			pedido = true;
			while(!respondido);
			respondido = false;
			printlnI("Respuesta: "+respuestas[num]);
		}
	}
	
	public static void server() {
		while(true) {
			while(!pedido);
			pedido = false;
			respuestas[peticiones[/10]] = peticiones + 1;
			respondido = true;
		}
	}

	
	public static void main(String[] args) {
		
		pedido = false;
		respondido = false;
		respuestas = new int[10];
		peticiones = new int[10];
		
		for(int i = 0; i < N; i++) {
			createThread("client", i);
		}
		
		createThread("server");
		
		startThreadsAndWait();
		
	}

}

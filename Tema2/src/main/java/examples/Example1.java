package examples;

import static es.urjc.etsii.code.concurrency.SimpleConcurrent.*;

public class Example1 {
	
	public static void repeat(String text) {
		for(int i=0; i<5; i ++) {
			println(text);
		}
	}
	
	public static void printText() {
		printlnI("B1");
		printlnI("B2");
		printlnI("B3");
	}
	
	public static void main(String[] args) {
		createThread("repeat", "XXXXX");
		createThread("repeat", "-----");
		createThread("printText");
		
		startThreadsAndWait();
	}
	
}

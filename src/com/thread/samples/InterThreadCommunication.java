package com.thread.samples;

import java.util.LinkedList;
import java.util.Queue;

public class InterThreadCommunication {

	public static void main(String args[]) {
		 Queue<Integer> sharedqueue = new LinkedList<Integer>();

		Producer producer = new Producer(sharedqueue);

		Consumer consumer = new Consumer(sharedqueue);
		
		producer.start();
		consumer.start();
		
	}

}

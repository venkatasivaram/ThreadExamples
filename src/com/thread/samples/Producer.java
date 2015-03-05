package com.thread.samples;

import java.util.Queue;

public class Producer extends Thread {

	private  Queue<Integer> sharedQueue;

	public Producer(Queue<Integer> sharedQueue) {
		super("Producer");
		this.sharedQueue = sharedQueue;
	}

	@Override
	public void run() {
		try {

			for (int i = 1; i < 5; i++) {
				synchronized (sharedQueue) {

					// before filling up the queue need to check the condition
					// whether queue is empty or not
					// if queue is full we have to wait for the notification
					// from consumer

					while (sharedQueue.size() >= 1) {

						try {
							System.out.println("Queue is full. waiting....."
									+ Thread.currentThread().getName()
									+ " size of queue " + sharedQueue.size());
							sharedQueue.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

					// fill the queue

					sharedQueue.add(i);
					sharedQueue.notify();
					System.out.println("Producing..."+i);

				}

			}
		} catch (Exception e) {
			//System.out.println("yesss");
			e.printStackTrace();
		}
	}

}

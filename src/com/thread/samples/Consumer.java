package com.thread.samples;

import java.util.Queue;

public class Consumer extends Thread {

	 private  Queue<Integer> sharedQueue;

	public Consumer(Queue<Integer> sharedQueue) {
		super();
		this.sharedQueue = sharedQueue;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// super.run();
		
		while(true)
		{
			
			synchronized (sharedQueue) {
				
				//Need to wait while queue is empty
				while(sharedQueue.size()==0)
				{
					try {
						System.out.println("Queue is empty. waiting....."+Thread.currentThread().getName()+" size of queue "+sharedQueue.size());
						sharedQueue.wait();
						
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				int val=sharedQueue.poll();
				System.out.println("Consumed..."+ val);

				sharedQueue.notify();
				//break condition
				if (val == 4) {
					break;
				}
				
			}
					
		}

	}

}

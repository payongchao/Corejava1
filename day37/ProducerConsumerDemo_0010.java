package com.briup.jd1721.corejava.day37;

/**
 * 多个线程操作了同一个资源：product对象。
 * 出现的现象：还没有生产，就被消费了。
 * 怎么办？加同步。
 * 新的问题：生产了多个，但是消费的是最新的那个，而且，
 * 			最新的被消费了多次。
 * 解决方案：
 * 给商品类添加标记，如果标记为true，则表示商品容器中
 * 有商品，就不再生产，同时告诉消费者去消费。
 * 如果标记为false，则表示商品容器中没有商品，消费者不再消费，
 * 同时，告诉生产者去生产。
 *
 */
public class ProducerConsumerDemo_0010{
	public static void main(String[] args){
		Product product=new Product();
		new Thread(new Producer(product)).start();
		new Thread(new Consumer(product)).start();
	}
}

// 1.定义商品类
class Product{ // produce
	private static final Object LOCK=new Object();
	private String name;
	private int no;
	// 定义标记，用来表示商品的存在与否
	private boolean flag;
	/*
		标记的使用：
		生产者判断：
			true：	意味着有商品，生产者等待。

			false：	没有商品，生产者生产商品；
					将flag改为true；
					将消费者唤醒。

		消费者判断：
			true：	有商品，去消费；
					把flag改为false；
					将生产者唤醒。

			false：	没有商品，直接等待。
	 */

	// 能被生产
	public void produce(String name) throws InterruptedException{
		synchronized(this){
		//synchronized(LOCK){
			if(flag){
				// 有商品，等待
				this.wait();
			}else{
				this.name=name+(no++);
				System.out.println("---生产者---"+this.name);
				flag=true;
				this.notify();
			}
		}
	}

	// 能被消费
	public synchronized void consume() throws InterruptedException{
		//synchronized(LOCK){
		if(flag){
			// 有商品，消费
			System.out.println("...消费者..."+name);
			flag=false;
			//LOCK.notify();
			this.notify();
		}else{
			//没有商品，等待
			//LOCK.wait();
			this.wait();
		}
		//}
	}
}

// 2.生产者类
class Producer implements Runnable{
	private Product product;

	public Producer(Product product){
		this.product=product;
	}

	@Override
	public void run(){
		while(true){
			try{
				product.produce("面包");
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}

// 3.消费者类
class Consumer implements Runnable{
	private Product product;

	public Consumer(Product product){
		this.product=product;
	}

	@Override
	public void run(){
		while(true){
			try{
				product.consume();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}

package com.briup.jd1721.corejava.day45;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStreamDemo_0010{
	public static void main(String[] args) throws IOException{
		PipedInputStream pis=new PipedInputStream();
		PipedOutputStream pos=new PipedOutputStream(pis);

		new Thread(new Input(pis)).start();
		new Thread(new Output(pos)).start();
	}
}

class Input implements Runnable{
	private PipedInputStream pis;

	public Input(PipedInputStream pis){
		this.pis=pis;
	}

	@Override
	public void run(){
		try{
			byte[] bytes=new byte[1024];
			int length=pis.read(bytes);
			System.out.println(
				new String(bytes,0,length));
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}

class Output implements Runnable{
	private PipedOutputStream pos;

	public Output(PipedOutputStream pos){
		this.pos=pos;
	}

	@Override
	public void run(){
		try{
			pos.write("Hello".getBytes());
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}


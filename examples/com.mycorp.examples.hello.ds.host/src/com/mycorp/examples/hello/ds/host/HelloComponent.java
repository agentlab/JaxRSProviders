package com.mycorp.examples.hello.ds.host;

import com.mycorp.examples.hello.IHello;
import com.mycorp.examples.hello.model.HelloMessage;

public class HelloComponent implements IHello {
	
	public HelloComponent() {
	}
	
	public String hello() {
		//System.out.println("received hello");
		return "Hello service host says 'Hi' back to WWWWWWWW";
	}

	public HelloMessage hello2() {
		return new HelloMessage("RRR", "EEE");
	}
	
	public HelloMessage hello3(String from) {
		//System.out.println("received hello from="+from);
		return new HelloMessage("RRR", "EEE");
	}

	public HelloMessage hello4(HelloMessage message) {
		//System.out.println("received HelloMessage="+message);
		return message;
	}
	
	
	
	public void start() {
		System.out.println("Hello service started");
	}
	
	public void stop() {
		System.out.println("Hello service stopped");
	}
	
	public void modify() {
		System.out.println("Hello service modified");
	}
}

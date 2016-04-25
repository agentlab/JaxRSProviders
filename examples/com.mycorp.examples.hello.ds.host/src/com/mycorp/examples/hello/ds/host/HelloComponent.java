package com.mycorp.examples.hello.ds.host;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;

import com.mycorp.examples.hello.IHello;
import com.mycorp.examples.hello.model.HelloMessage;

@Component(
	enabled = true
	,immediate = true
	,property = {
		"service.exported.interfaces=*"
		,"service.exported.configs=ecf.jaxrs.jersey.server"
		,"ecf.jaxrs.jersey.server.urlContext=http://localhost:8080"
		,"ecf.jaxrs.jersey.server.alias=/hello"
	}
)
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
	
	
	@Activate
	public void start() {
		System.out.println("Hello service started");
	}
	@Deactivate
	public void stop() {
		System.out.println("Hello service stopped");
	}
	@Modified
	public void modify() {
		System.out.println("Hello service modified");
	}
}

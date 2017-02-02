package com.mycorp.examples.hello.ds.host;

import java.io.IOException;
import java.util.Dictionary;

import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.cm.ManagedService;
import org.osgi.service.component.ComponentContext;
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
		,"service.pid=com.mycorp.examples.hello.ds.host.HelloComponent"
	}
)
public class HelloComponent implements IHello, ManagedService {
    //private String id;
    //private String database;
    //private String user;
    //private String password;
    //private String create;

	public HelloComponent() {
	}

	public String hello() {
		//System.out.println("received hello");
		return "Hello service host says 'Hi' back to WWWWWWWW";
	}

	public HelloMessage hello2() {
        return new HelloMessage("Nika", "Dyoma", "Хочу сдать курсач!");
	}

	public HelloMessage hello3(String from) {
		//System.out.println("received hello from="+from);
        return new HelloMessage(from, "UUU");
	}

	public HelloMessage hello4(HelloMessage message) {
		//System.out.println("received HelloMessage="+message);
		return message;
	}

	@Activate
	public void activate(ComponentContext context) throws IOException {
        //Dictionary<String, Object> properties = context.getProperties();
		//properties.put("database.id", "wewe");
        //id = (String) properties.get("database.id");
        //database = (String) properties.get("database");
        //user = (String) properties.get("user");
        //password = (String) properties.get("password");
        //create = (String)properties.get("create");
		System.out.println("Hello service started");
	}
	@Deactivate
	public void deactivate(ComponentContext context) {
		System.out.println("Hello service stopped");
	}
	@Modified
	public void modify() {
		System.out.println("Hello service modified");
	}

    public void updated(Dictionary<String, ?> properties) throws ConfigurationException {
        System.out.println(properties);
    }
}

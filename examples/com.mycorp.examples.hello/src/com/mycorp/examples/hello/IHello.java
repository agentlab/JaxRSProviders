package com.mycorp.examples.hello;

import javax.ws.rs.PathParam;

//@Path("/api/blob")
public interface IHello {

//	public String hello();
//
//	public HelloMessage hello2();

//  @Path("/{token}")
//  @GET
    public String hello3(@PathParam("token") String token);

//	public HelloMessage hello4(HelloMessage message);
}


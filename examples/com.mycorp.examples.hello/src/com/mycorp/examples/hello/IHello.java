package com.mycorp.examples.hello;

//@Path("/api/blob")
public interface IHello {

//	public String hello();
//
//	public HelloMessage hello2();

//  @Path("/{token}")
//  @GET
	public String hello3(/*@PathParam("token")*/ String token);

//	public HelloMessage hello4(HelloMessage message);
}


/*******************************************************************************
* Copyright (c) 2015 Composent, Inc. and others. All rights reserved. This
* program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution, and is
* available at http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*   Composent, Inc. - initial API and implementation
******************************************************************************/
package com.mycorp.examples.student;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

@Path("/ihello")
public interface StudentService {

	@GET
    @Produces(MediaType.TEXT_PLAIN)
	@Path("/hello")
    public String hello();

	@GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("{name}")
    public String hello6(@Context HttpHeaders header, @PathParam("name") String name);

    /*@GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/students")
    List<Student> getStudents();
    */

	/*@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/students/{studentId}")
	Student getStudent(@PathParam("studentId") String id);

	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Path("/students/add/{studentName}")
	Student addStudent(@PathParam("studentName") String studentName);

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	@Path("/students/update")
	Student updateStudent(Student student);

	@DELETE
	@Path("/students/delete/{studentId}")
	@Produces(MediaType.APPLICATION_XML)
	Student deleteStudent(@PathParam("studentId") String studentId);*/
}

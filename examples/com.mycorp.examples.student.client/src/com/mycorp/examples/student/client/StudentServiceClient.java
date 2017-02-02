/*******************************************************************************
* Copyright (c) 2015 Composent, Inc. and others. All rights reserved. This
* program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution, and is
* available at http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*   Composent, Inc. - initial API and implementation
******************************************************************************/
package com.mycorp.examples.student.client;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.mycorp.examples.student.StudentService;

@Path("/ihello")
public class StudentServiceClient
    implements StudentService {

    @Override
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/hello")
    public String hello() {
        return "hello";
    }


    @Override
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("{name}")
    public String hello6(@Context HttpHeaders header, @PathParam("name") String name) {
        String result = "Hello" + name;
        return result;
    }
}

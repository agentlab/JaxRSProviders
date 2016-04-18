package com.javacodegeeks.resteasy;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/sampleservice")
public interface ISampleService {

	@GET
	@Path("/hello")
	@Produces(MediaType.APPLICATION_JSON)
	public String hello();

	@GET
	@Path("/echo/{message}")
	@Produces(MediaType.APPLICATION_JSON)
	public String echo(@PathParam("message") String message);

	/*@GET
	@Path("/employees")
	@Produces("application/xml")
	public List<Employee> listEmployees();

	@GET
	@Path("/employee/{employeeid}")
	@Produces("application/xml")
	public Employee getEmployee(@PathParam("employeeid") String employeeId);

	@GET
	@Path("/json/employees/")
	@Produces("application/json")
	public List<Employee> listEmployeesJSON();

	@GET
	@Path("/json/employee/{employeeid}")
	@Produces("application/json")
	public Employee getEmployeeJSON(@PathParam("employeeid") String employeeId);
*/
}

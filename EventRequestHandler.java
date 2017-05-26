/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yang.microservice.event.rest;

/**
 * @author Richard Yang
 *
 *
 * do mvn compile, mvn clean install and then mvn exec:java
 * -Dexec.mainClass="org.yang.jersey.sample.grizzly.App"
 *
 * start Postman and select POST and enter http://localhost:8080/api/atmevent
 *
 * select raw and JSON and enter { "date":"2016-03-16 08:15:30", "location":"Des
 * Moines, IA", "atmId":"ABC123", "action":"deposit", "amount":1234567,
 * "userId":"YNG123", "corelationId":"4567" } and send
 *
 */
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.yang.microservice.event.request.AtmEventRequest;
import org.yang.microservice.event.response.AtmEventResponse;

@Path("rest/api")
public class EventRequestHandler {

    @POST
    @Path("/atmevent")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response submitAtmEvent(AtmEventRequest request) {

        System.out.println(String.format("Date: %s", request.getDate()));
        System.out.println(String.format("Location: %S", request.getLocation()));
        System.out.println(String.format("ATM ID: %S", request.getAtmId()));
        System.out.println(String.format("Action: %s", request.getAction()));
        System.out.println(String.format("Amount: %d", request.getAmount()));
        System.out.println(String.format("User ID: %S", request.getUserId()));
        System.out.println(String.format("Correlation ID: %s", request.getCorelationId()));

        AtmEventResponse resp = new AtmEventResponse();
        resp.setStatus("Completed successfully");
        resp.setIsCompleted(true);
        resp.setDate(new Date());

        Response retVal = Response.ok().entity(resp).build();

        return retVal;

    }

}

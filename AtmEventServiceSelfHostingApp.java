/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yang.microservice.event.selfhosting;

/**
 * @author Richard Yang
 * 
 * To run it, mvn compile, mvn exec:java -Dexec.mainClass="org.yang.microservice.event.selfhosting.AtmEventServiceSelfHostingApp"
 * 
 * start Postman and select POST and enter http://localhost:8080/api/atmevent
 * 
 * select raw and JSON and enter 
/* json format data
{
"date":"2016-03-16 08:15:30",
"location":"Des Moines, IA",
"AtmId":"ABC123",
"action":"deposit",
"amount":12345.67,
"isCompleted":true,
"userId":"YNG123",
"corelationId":"4567"
}

 */
import java.io.IOException;
import java.net.URI;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class AtmEventServiceSelfHostingApp {

    public static final URI URI = UriBuilder.fromUri("http://localhost/").port(8080).build();
    
    protected static HttpServer startServer() throws IOException {
        ResourceConfig config = new ResourceConfig().packages("org.yang.microservice.event");
        
        System.out.println("Starting Atm Event Microservice...");
        
        return GrizzlyHttpServerFactory.createHttpServer(URI, config);
    }

    public static void main(String ... args) {  
        try {
            HttpServer httpServer = startServer();
            System.out.println("Press any key to shutdown...");
            
            System.in.read();
            
            httpServer.shutdownNow();
        } catch (Exception e) {
            System.out.println("Exception occurred...");
            e.printStackTrace();
        }
    }
    
    
}

package it.example.ewallet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/conti")
public class ContoCorrenteRest {
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }
}
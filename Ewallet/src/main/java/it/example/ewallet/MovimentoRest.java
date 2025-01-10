package it.example.ewallet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/movimenti")
public class MovimentoRest {
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }
}
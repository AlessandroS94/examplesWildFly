package it.example.ewalletrest.ws;

import it.example.ewalletrest.dao.MovimentiDao;
import it.example.ewalletrest.dao.impl.MovimentiDaoImpl;
import it.example.ewalletrest.model.Movimenti;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("movimenti")
public class MovimentiRest {
	
	@Path("/")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Movimenti> findAll() {
		MovimentiDao mDao = new MovimentiDaoImpl();

		return mDao.findAll();
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(Movimenti m) {

		MovimentiDao mDao = new MovimentiDaoImpl();

		mDao.save(m);
		String result = "utente salvato con successo ";
		System.out.println("dentro inserimento");

		return Response.status(201).entity(result).build();

	}
}

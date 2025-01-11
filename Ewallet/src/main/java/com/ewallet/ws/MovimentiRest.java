package com.ewallet.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ewallet.dao.MovimentiDao;
import com.ewallet.dao.impl.MovimentiDaoImpl;
import com.ewallet.model.Movimenti;

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

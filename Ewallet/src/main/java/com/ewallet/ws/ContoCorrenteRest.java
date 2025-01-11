package com.ewallet.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import com.ewallet.dao.ContoCorrenteDao;
import com.ewallet.dao.impl.ContoCorrenteDaoImpl;
import com.ewallet.model.ContoCorrente;

@Path("contocorrente")
public class ContoCorrenteRest {

	
	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ContoCorrente findById(@PathParam("id")int idContoCorrente) {
		ContoCorrenteDao ccDao = new ContoCorrenteDaoImpl();
		
		return ccDao.findById(idContoCorrente);
	}

	
	//
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(ContoCorrente cc) {

		ContoCorrenteDao ccDao = new ContoCorrenteDaoImpl();

		ccDao.save(cc);
		String result = "utente salvato con successo ";
		System.out.println("dentro inserimento");



		return Response.status(201).entity(result).build();

	}
	
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(ContoCorrente cc) {

		ContoCorrenteDao ccDao = new ContoCorrenteDaoImpl();

		ccDao.update(cc);
		String result = "utente salvato con successo ";
		System.out.println("dentro inserimento");



		return Response.status(201).entity(result).build();

	}
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response delete(ContoCorrente cc) {

		ContoCorrenteDao ccDao = new ContoCorrenteDaoImpl();

		ccDao.delete(cc.getId());
		String result = "utente salvato con successo ";
		System.out.println("dentro inserimento");



		return Response.status(201).entity(result).build();

	}
}

package it.example.ewalletrest.ws;

import it.example.ewalletrest.dao.ContoCorrenteDao;
import it.example.ewalletrest.dao.impl.ContoCorrenteDaoImpl;
import it.example.ewalletrest.model.ContoCorrente;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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

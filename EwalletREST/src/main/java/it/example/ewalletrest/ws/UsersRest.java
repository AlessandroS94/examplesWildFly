package it.example.ewalletrest.ws;

import it.example.ewalletrest.dao.UsersDao;
import it.example.ewalletrest.dao.impl.UsersDaoImpl;
import it.example.ewalletrest.model.Users;
import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/user")
public class UsersRest {
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Users> findAll(){
		
		UsersDao uDao = new UsersDaoImpl();
		return uDao.findAll();
	}
	
	
	/**
	 *  restituisce OK se le credenziali inserite esistono
	 *  
	 * @param user corrisponde alla username dell'utente
	 * @param pwd   password dell'utente 
	 * @return Response
	 */
	@GET
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(@QueryParam("user") String user,@QueryParam("pwd") String pwd){
		
		UsersDao uDao = new UsersDaoImpl();
		Users u = uDao.findByUserAndPwd(user);
		System.out.println("utente trovato");
		System.out.println(u);
		String result="OK";
		if(!BCrypt.checkpw(pwd, u.getPassword()))
			result = "KO";
		
		return Response.status(201).entity(result).build();
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(Users u) {
		UsersDao uDao = new UsersDaoImpl();
		
		uDao.create(u);
		
		return Response.status(201).entity("Success").build();
	}

	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(Users u) {
		UsersDao uDao = new UsersDaoImpl();
		uDao.update(u);
		return Response.status(201).entity("Success").build();
		
	}
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response delete(Users u) {
		UsersDao uDao = new UsersDaoImpl();
		uDao.delete(u.getId());
		return Response.status(201).entity("Success").build();
	}
	
}

package it.example.rest_jboss;

import it.example.rest_jboss.DAO.UsersDAO;
import it.example.rest_jboss.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/users")
public class HelloResource {
    private UsersDAO usersDAO = new UsersDAO();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {
        List<User> users = this.usersDAO.getAllUsers();
        return Response.ok(users).build();
    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("id") int id) {
        User user = this.usersDAO.getUser(id);
        return Response.ok(user).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser(@PathParam("id")int id) {
        this.usersDAO.deleteUser(id);
        return Response.accepted().build();
    }
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response putUser(User user) {
        this.usersDAO.updateUser(user);
        return Response.ok(user).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response postUser(User user) {
        this.usersDAO.insertUser(user);
        return Response.ok().build();
    }

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;



import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author c0638820
 */
@Path("words")
@RequestScoped
public class WordREST {
    
    @Inject
    wordController words;
    
    @GET
    @Produces("application/json")
    public Response getAll() {
        return Response.ok(words.getAllJson()).build();
    }
    
    @GET
    @Path("{wordId}")
    @Produces("application/json")
    public Response getById(@PathParam("wordId") int id) {
        JsonObject json = words.getByIdJson(id);
        if (json != null) {
            return Response.ok(json).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response add(JsonObject json) {
        return Response.ok(words.addJson(json)).build();
    }
    
    @PUT
    @Path("{wordId}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response set(@PathParam("id") int id) {
        //todo use controller's editJson method
        return null;
    }
    
    
    
    
    
    
}

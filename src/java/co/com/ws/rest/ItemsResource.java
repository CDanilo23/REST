/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.ws.rest;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author cristian.ordonez
 */
@Path("/Items")
public class ItemsResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ItemsResource
     */
    public ItemsResource() {
    }

    /**
     * Retrieves representation of an instance of co.com.ws.rest.ItemsResource
     * @return an instance of java.lang.String
     */
    
    //Se consume asi localhost:puertoServer/REST/rest/Items
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getXml() {
        //TODO return proper representation object
        return "{\"firstName\":\"John\", \"lastName\":\"Doe\"}";
    }
    
    // //Se consume asi localhost:puertoServer/REST/rest/Items/name=laura
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/name={nombre}")
    public String getNombre(@PathParam("nombre") String nombre ) {
        if(nombre.equals("laura")){
            return "{\"firstName\":\"Laura\", \"lastName\":\"Doe\"}";
        }
        return "{\"firstName\":\"John\", \"lastName\":\"Doe\"}";
    }

    /**
     * POST method for creating an instance of ItemResource
     * @param content representation for the new resource
     * @return an HTTP response with content of the created resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response postXml(String content) {
        //TODO
        return Response.created(context.getAbsolutePath()).build();
    }

    /**
     * Sub-resource locator method for {id}
     */
    @Path("{id}")
    public ItemResource getItemResource(@PathParam("id") String id) {
        return ItemResource.getInstance(id);
    }
    
    @POST
    @Path("/add")
    public Response addUser(@FormParam("name")String name, @FormParam("age")int age){
        return Response.status(200).entity(" Hola "+name+" tienes "+age+" años").build();
    } 
}

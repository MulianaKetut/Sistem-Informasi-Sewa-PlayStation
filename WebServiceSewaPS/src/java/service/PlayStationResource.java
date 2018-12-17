/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.gson.Gson;
import helper.PlaystationHelper;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Playstation;
import util.NewHibernateUtil;

/**
 * REST Web Service
 *
 * @author admin
 */
@Path("playStation")
public class PlayStationResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PlayStationResource
     */
    public PlayStationResource() {
    }

    /**
     * Retrieves representation of an instance of service.PlayStationResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public Response getJson() {
        //TODO return proper representation object
        PlaystationHelper test = new PlaystationHelper();
        List<Playstation> list = test.getAllPlaystation();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return Response
                .status(200)
                .entity(json)
                .build();
    }

    @GET
    @Path("searchStatus")
    @Produces(MediaType.APPLICATION_JSON)
    public String cariStatus(@QueryParam("status") String status) {
        return new Gson().toJson(new PlaystationHelper().searchStatus(status));
    }
    
    @GET
    @Path("searchIdPs")
    @Produces(MediaType.APPLICATION_JSON)
    public String cariIdPs(@QueryParam("idPlayStation") String idPlayStation) {
        return new Gson().toJson(new PlaystationHelper().searchIdPs(idPlayStation));
    }

    /**
     * PUT method for updating or creating an instance of PlayStationResource
     *
     * @param content representation for the resource
     */
    @POST
    @Path("addPlaystation")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNewPasien(String data) {
        Gson gson = new Gson();
        Playstation ps = gson.fromJson(data, Playstation.class);
        PlaystationHelper helper = new PlaystationHelper();
        helper.addNewPlaystation(ps.getIdPlayStation(),
                ps.getNamaPlayStation(),
                ps.getHargaSewaPlayStation(),
                ps.getStatus());
        return Response
                .status(200)
                .entity(ps)
                .build();
    }
    
    @POST
    @Path("updateStatus")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateStatus(String data){
        Gson gson = new Gson();
        Playstation ps = gson.fromJson(data, Playstation.class);
        PlaystationHelper psHelper = new PlaystationHelper();
        psHelper.updateStatus(ps.getIdPlayStation(), 
                ps.getStatus());
        return Response
                .status(200)
                .entity(ps)
                .build();
    }
    

}

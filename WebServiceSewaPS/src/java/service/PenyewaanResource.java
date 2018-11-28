/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.gson.Gson;
import helper.PenyewaanHelper;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import pojos.Penyewaan;

/**
 * REST Web Service
 *
 * @author danielbram
 */
@Path("penyewaan")
public class PenyewaanResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PenyewaanResource
     */
    public PenyewaanResource() {
    }

    /**
     * Retrieves representation of an instance of service.PenyewaanResource
     * @return an instance of java.lang.String
     */
    @GET   
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public Response getJson() {
        //TODO return proper representation object
        PenyewaanHelper test = new PenyewaanHelper();
        List<Penyewaan> list = test.getAllPenyewaan();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return Response
                .status(200)
                .entity(json)
                .build();
    }

    /**
     * PUT method for updating or creating an instance of PenyewaanResource
     * @param content representation for the resource
     */
    @POST
    @Path("addPenyewaan")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNewPenyewaan(String data){
        Gson gson = new Gson();
        Penyewaan penyewaan = gson.fromJson(data, Penyewaan.class);            
        PenyewaanHelper helper = new PenyewaanHelper();
        helper.addNewPenyewaan(penyewaan.getNik(),
                penyewaan.getNama(),
                penyewaan.getNomorHp(),
                penyewaan.getAlamat(),
                penyewaan.getTglSewa(), 
                penyewaan.getTglKembali(),                
                penyewaan.getIdPlayStation());
        return Response
                .status(200)
                .entity(penyewaan)
                .build();
    }
}

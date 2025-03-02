package com.umbertociccia.controllers;

import java.util.List;

import com.umbertociccia.models.Dogs;
import com.umbertociccia.models.DogsCreateRequest;
import com.umbertociccia.services.DogsService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/dogs")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DogsController {

    @Inject
    private DogsService dogsService;

    @GET
    public List<Dogs> getDogs() {
        return dogsService.getDogs();
    }

    @GET
    @Path("/dog")
    public Dogs getDog(@QueryParam("id") Long id) {
        return dogsService.getDog(id).isPresent() ? dogsService.getDog(id).get() : null;
    }

    @POST
    @Path("/dog")
    public Dogs addDog(DogsCreateRequest dog) {
        return dogsService.addDog(dog);
    }

    @PUT
    @Path("/dog")
    public Dogs updateDog(@QueryParam("id") Long id, Dogs dog) {
        return dogsService.updateDog(id, dog);
    }

    @DELETE
    @Path("/dog")
    public void deleteDog(@QueryParam("id") Long id) {
        dogsService.deleteDog(id);
    }

}

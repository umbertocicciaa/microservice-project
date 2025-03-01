package com.umbertociccia.controllers;

import java.util.List;

import com.umbertociccia.models.Cats;
import com.umbertociccia.services.CatsService;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

@Path("/cats")
public class CatsController {
    @Inject
    private CatsService catsService;

    @GET
    public List<Cats> getCats() {
        return catsService.getCats();
    }

    @GET
    @Path("/cat")
    public Cats getCat(@QueryParam("id") Long id) {
        if (catsService.getCat(id).isPresent()) {
            return catsService.getCat(id).get();
        } else {
            return null;
        }
    }

    @POST
    @Path("/cat")
    public Cats addCat(Cats cats) {
        return catsService.addCat(cats);
    }

    @PUT
    @Path("/cat")
    public Cats updateCat(@QueryParam("id") Long id, Cats cats) {
        return catsService.updateCat(id, cats);
    }

    @DELETE
    @Path("/cat")
    public boolean deleteCat(@QueryParam("id") Long id) {
        return catsService.deleteCat(id);
    }

}

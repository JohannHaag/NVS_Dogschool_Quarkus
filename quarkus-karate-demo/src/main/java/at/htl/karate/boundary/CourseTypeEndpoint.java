package at.htl.karate.boundary;

import at.htl.karate.control.CourseDao;
import at.htl.karate.control.CourseTypeDao;
import at.htl.karate.entity.Course;
import at.htl.karate.entity.CourseType;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/coursetype")
public class CourseTypeEndpoint {
    @Inject
    CourseTypeDao courseTypeDao;

    @Inject
    CourseDao courseDao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        CourseType courseType = courseTypeDao
                .find("name","Welpenkurs")
                .firstResult();
        return Response
                .ok(courseType)
                .build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findone(@PathParam("id") long id) {
        CourseType courseType = courseTypeDao.findById(id);
        return Response
                .ok(courseType)
                .build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create() {
        CourseType courseType = new CourseType("Welpenkurs2", "welp");
        courseTypeDao.persist(courseType);
        return Response
                .status(Response.Status.CREATED)
                .location(URI.create("coursetype/" + courseType.id))
                .build();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(@PathParam("id") long id, CourseType courseType) {
        CourseType updated = courseTypeDao.findById(id);
        if (updated != null) {
            updated.name= courseType.name;
            updated.abbr = courseType.abbr;
        }
        return Response.ok().entity(updated).build();
    }


    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response delete(@PathParam("id") long id){
        CourseType courseType = courseTypeDao.findById(id);
        courseTypeDao.delete(courseType);
        return Response.noContent().build();
    }

}

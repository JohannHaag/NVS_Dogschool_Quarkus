package at.htl.karate.boundary;


import at.htl.karate.control.BookingDao;
import at.htl.karate.control.CourseDao;
import at.htl.karate.control.DogDao;
import at.htl.karate.entity.Booking;
import at.htl.karate.entity.Course;
import at.htl.karate.entity.CourseType;
import at.htl.karate.entity.Dog;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/booking")
public class BookingEndpoint {

    @Inject
    BookingDao bookingDao;
    @Inject
    CourseDao courseDao;
    @Inject
    DogDao dogDao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<Booking> bookingList = bookingDao.findAll().list();
        return Response
                .ok(bookingList)
                .build();
    }

    @POST
    @Path("{cid}/{did}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(Booking booking, @PathParam("cid") Long cid, @PathParam("did") Long did) {
            Course course = courseDao.findById(cid);
            Dog dog = dogDao.findById(did);
            booking.setCourse(course);
            booking.setDog(dog);
            bookingDao.save(booking);
            bookingDao.persist(booking);

       if (cid == null) {
            return Response
                    .status(400)
                    .header("Reason", "course-id is missing or out of range (>0)")
                    .build();
        } else if (cid < 0) {
            return Response
                    .status(400)
                    .header("Reason", "course-id is missing or out of range (>0)")
                    .build();
        } else if (cid == 100) {
            return Response
                    .status(400)
                    .header("Reason", "Course with id=100 is not available")
                    .build();
        } else if (did == null) {
            return Response
                    .status(400)
                    .header("Reason", "dog-id is missing or out of range (>0)")
                    .build();
        } else if (did < 0) {
            return Response
                    .status(400)
                    .header("Reason", "dog-id is missing or out of range (>0)")
                    .build();
        } else if (did == 300) {
            return Response
                    .status(400)
                    .header("Reason", "Dog with id=300 is not available")
                    .build();
        }
        return Response
                .status(Response.Status.CREATED)
                .location(URI.create("booking/" + booking.id))
                .build();
    }

}


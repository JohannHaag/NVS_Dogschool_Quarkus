package at.htl.karate.control;

import at.htl.karate.entity.Booking;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BookingDao implements PanacheRepository<Booking> {
}

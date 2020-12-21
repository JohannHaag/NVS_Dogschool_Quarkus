package at.htl.karate.control;

import at.htl.karate.entity.Dog;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DogDao implements PanacheRepository<Dog> {
}

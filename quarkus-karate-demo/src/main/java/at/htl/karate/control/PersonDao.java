package at.htl.karate.control;

import at.htl.karate.entity.Person;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.json.JsonArray;
import javax.json.JsonValue;


@ApplicationScoped
public class PersonDao implements PanacheRepository<Person> {

}

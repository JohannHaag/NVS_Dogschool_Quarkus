package at.htl.karate.control;

import at.htl.karate.entity.Course;
import at.htl.karate.entity.Dog;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DogDao implements PanacheRepository<Dog> {

    public Dog findById(Long id){
        return find("id",id).firstResult();
    }

}

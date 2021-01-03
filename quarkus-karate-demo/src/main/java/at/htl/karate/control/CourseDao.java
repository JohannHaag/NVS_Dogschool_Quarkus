package at.htl.karate.control;


import at.htl.karate.entity.Course;
import at.htl.karate.entity.CourseType;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CourseDao implements PanacheRepository<Course> {

    public Course findById(Long id){
        return find("id",id).firstResult();
    }
}

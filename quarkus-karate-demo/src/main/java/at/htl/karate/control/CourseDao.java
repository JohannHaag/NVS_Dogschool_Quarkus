package at.htl.karate.control;


import at.htl.karate.entity.Course;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CourseDao implements PanacheRepository<Course> {

}

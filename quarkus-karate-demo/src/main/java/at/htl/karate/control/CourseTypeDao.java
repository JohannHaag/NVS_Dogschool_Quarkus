package at.htl.karate.control;


import at.htl.karate.entity.CourseType;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CourseTypeDao implements PanacheRepository<CourseType> {

    public CourseType findByName(String abbr){
        return find("abbr",abbr).firstResult();
    }

    public CourseType save(CourseType courseType){
        persistAndFlush(courseType);
        return courseType;
    }
}

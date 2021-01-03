package at.htl.karate.control;


import at.htl.karate.entity.CourseType;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;

@ApplicationScoped
public class CourseTypeDao implements PanacheRepository<CourseType> {

    JsonObject jsonObject;

    public CourseType findByName(String abbr){
        return find("abbr",abbr).firstResult();
    }

    public CourseType findById(Long id){
        return find("id",id).firstResult();
    }
    public CourseType save(CourseType courseType){
        persistAndFlush(courseType);
        return courseType;
    }

    public JsonArray allCourseTypes(){
        JsonArray jsonArray = Json.createArrayBuilder(jsonObject.getJsonArray("Name")).build();
        return jsonArray;
    }
}

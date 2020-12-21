package at.htl.karate.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;


/**
 * abbreviation:
 * - bg1 ... Begleithunde1
 * - bg2 ... Begleithunde2
 * - w ... Welpenkurs
 */

@Entity
@Table(name = "S_COURSE_TYPE")
public class CourseType  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    public String name;
    public String abbr; // abbreviation

    //region Constructors


    public  CourseType(){}

    public CourseType(String name, String abbr) {
        this.name = name;
        this.abbr = abbr;
    }

}

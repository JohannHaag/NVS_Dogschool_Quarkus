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
@Table(name = "C_CourseType")
public class CourseType extends PanacheEntity {

    @Column(name = "C_Name")
    public String name;
    @Column(name = "C_Abbr")
    public String abbr; // abbreviation

    //region Constructors


    public  CourseType(){}

    public CourseType(String name, String abbr) {
        this.name = name;
        this.abbr = abbr;
    }

}

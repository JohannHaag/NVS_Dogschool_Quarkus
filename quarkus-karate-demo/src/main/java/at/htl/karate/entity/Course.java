package at.htl.karate.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "C_Course")
public class Course extends PanacheEntity {


    @Column(name = "C_Name")
    String name;
    @Column(name = "C_Price")
    public double price;
    @Column(name = "C_StartDateTime")
    public LocalDateTime startDatetime;
    @Column(name = "C_NoOfMeetings")
    public int noOfMeetings;
    @ManyToOne
    @JoinColumn(name = "A_CourseType_ID")
    CourseType courseType;

    //region Constructors


    public Course(){}
    public Course(String name, LocalDateTime startDatetime, Double price, int noOfMeetings,  CourseType courseType) {
        this.name = name;
        this.startDatetime = startDatetime;
        this.price = price;
        this.noOfMeetings = noOfMeetings;
        this.courseType = courseType;
    }

    //endregion

}

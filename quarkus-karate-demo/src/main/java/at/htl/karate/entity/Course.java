package at.htl.karate.entity;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "S_COURSE")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    String name;
    public double price;
    public LocalDateTime startDatetime;
    public int noOfMeetings;
    @ManyToOne
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

    //region Getter and Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getLocalDateTime() {
        return startDatetime;
    }

    public void setLocalDateTime(LocalDateTime startDatetime) {
        this.startDatetime = startDatetime;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNoOfMeetings() {
        return noOfMeetings;
    }

    public void setNoOfMeetings(int noOfMeetings) {
        this.noOfMeetings = noOfMeetings;
    }

    public CourseType getCourseType(){
        return courseType;
    }
    public  void  setCourseType(CourseType courseType){
        this.courseType = courseType;
    }
    //endregion

    @Override
    public String toString() {
        return name;
    }

}

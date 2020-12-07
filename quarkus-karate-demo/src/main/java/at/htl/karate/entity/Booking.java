package at.htl.karate.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "B_Booking")
public class Booking extends PanacheEntity {


    @Column(name = "B_Date")
    public LocalDate bookingDate;
    @Column(name = "B_Price")
    public double price;
    @ManyToOne
    @JoinColumn(name = "A_Dog_ID")
    Dog dog;
    @ManyToOne
    @JoinColumn(name = "A_Course_ID")
    Course course;

    //region Constructor
    public Booking() {
    }

    public Booking(Course course, Dog dog, LocalDate bookingDate, double price) {
        this.course = course;
        this.dog =dog;
        this.bookingDate = bookingDate;
        this.price = price;
    }
    //endregion
}

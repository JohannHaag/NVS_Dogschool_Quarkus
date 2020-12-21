package at.htl.karate.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "S_BOOKING")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate bookingDate;
    private double price;
    @ManyToOne(cascade = CascadeType.ALL)
    Dog dog;
    @ManyToOne(cascade = CascadeType.ALL)
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


    //region Getter and Setter
    public Long getId() {
        return id;
    }


    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Course getCourse(){
        return course;
    }
    public  void  setCourse(Course course){
        this.course = course;
    }
    public Dog getDog(){
        return dog;
    }
    public  void  setDog(Dog dog){
        this.dog = dog;
    }


    @Override
    public String toString() {
        return String.format("Buchung: %s mit %s (%s %s)",
                course.getName(),
                dog.getName(),
                dog.getOwner().getFirstName(),
                dog.getOwner().getLastName());
    }
}
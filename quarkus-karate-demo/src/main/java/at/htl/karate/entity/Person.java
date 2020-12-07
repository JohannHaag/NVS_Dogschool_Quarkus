package at.htl.karate.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;

@Entity
@Table(name = "P_Person")
public class Person  extends PanacheEntity {

    @Column(name="P_FirstName")
    public String firstName;
    @Column(name="P_LastName")
    public String lastName;

    //region Constructors
    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    //endregion

}

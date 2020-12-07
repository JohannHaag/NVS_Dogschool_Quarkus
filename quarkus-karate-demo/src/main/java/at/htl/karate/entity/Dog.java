package at.htl.karate.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;

@Entity
@Table(name = "D_Dog")
public class Dog extends PanacheEntity {

    @Column(name = "D_Name")
    public String name;
    @ManyToOne
    @JoinColumn(name = "A_Person_ID")
    public Person owner;

    //region Constructors
    public Dog() {
    }

    public Dog(String name, Person owner) {
        this.name = name;
        this.owner = owner;
    }
    //endregion
}

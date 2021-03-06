package at.htl.karate.entity;

import javax.persistence.*;

@Entity
@Table(name = "S_DOG")
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    @OneToOne(cascade = CascadeType.ALL)
    public Person owner;

    @Transient
    @ManyToOne
    Person person;

    //region Constructors
    public Dog() {
    }

    public Dog(String name, Person owner) {
        this.setName(name);
        this.setOwner(owner);
    }
    //endregion

    //region Getter and Setter
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }
    //endregion


    @Override
    public String toString() {
        return String.format("%s, (%s, %s)", owner.getLastName(), owner.getFirstName());
    }
}
package it.nttdata.concessionari.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "concessionarie")
public class Dealership {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 1)
    private String name;

    @NotNull
    private Region region;

    @NotNull
    @Size(min = 1)
    private String address;

    @NotNull
    @Size(min = 1)
    private String city;

    @OneToMany(mappedBy = "concessionarie")
    private Set<Employee> employees;

    @OneToMany(mappedBy = "concessionarie")
    private Set<Car> cars;

    public Dealership(String name, Region region, String address, String city) {
        this.name = name;
        this.region = region;
        this.address = address;
        this.city = city;
    }

    public Dealership() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }
}
package it.nttdata.concessionari.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "macchine")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 1)
    private String model;
    private Double price;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "concessionario_id")
    private Dealership dealership;

    public Car(String model, Double price, Dealership dealership) {
        this.model = model;
        this.price = price;
        this.dealership = dealership;
    }

    public Car() {
    }

    public Long getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Dealership getDealership() {
        return dealership;
    }

    public void setDealership(Dealership dealership) {
        this.dealership = dealership;
    }
}

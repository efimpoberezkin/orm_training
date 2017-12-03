package com.epam.homework.orm.db.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static com.epam.homework.orm.ConstantsContainer.*;

@Entity
@Table(name = AIRPLANE)
public class Airplane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = MODEL_NUMBER)
    private String modelNumber;

    @Column
    private int capacity;

    @JsonIgnore
    @OneToMany(
            mappedBy = AIRPLANE,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private List<Flight> flights = new ArrayList<>();

    public Airplane() {
    }

    public Airplane(String modelNumber, int capacity) {
        this.modelNumber = modelNumber;
        this.capacity = capacity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
        flight.setAirplane(this);
    }

    public void removeFlight(Flight flight) {
        flights.remove(flight);
        flight.setAirplane(null);
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "id=" + id +
                ", modelNumber='" + modelNumber + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}

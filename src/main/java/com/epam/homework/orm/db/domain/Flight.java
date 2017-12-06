package com.epam.homework.orm.db.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import static com.epam.homework.orm.ConstantsContainer.*;

@Entity
@Table(name = FLIGHT)
@NamedQueries({
        @NamedQuery(name = Flight.FIND_ALL_FLIGHTS, query = "SELECT f FROM Flight f"),
        @NamedQuery(name = Flight.FIND_FLIGHT_BY_ID, query = "SELECT f FROM Flight f WHERE id = :id")
})
public class Flight {

    public static final String FIND_ALL_FLIGHTS = "findAllFlights";
    public static final String FIND_FLIGHT_BY_ID = "findFlightById";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = FROM_LOC)
    private String fromLoc;

    @Column(name = TO_LOC)
    private String toLoc;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column
    private Timestamp departure;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column
    private Timestamp arrival;

    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinColumn(name = AIRPLANE_ID)
    private Airplane airplane;

    @ManyToMany(
            fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = BOOKING,
            joinColumns = @JoinColumn(name = FLIGHT_ID),
            inverseJoinColumns = @JoinColumn(name = PASSENGER_ID)
    )
    private Set<Passenger> passengers = new HashSet<>();

    public Flight() {
    }

    public Flight(String fromLoc, String toLoc, Timestamp departure, Timestamp arrival) {
        this.fromLoc = fromLoc;
        this.toLoc = toLoc;
        this.departure = departure;
        this.arrival = arrival;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFromLoc() {
        return fromLoc;
    }

    public void setFromLoc(String fromLoc) {
        this.fromLoc = fromLoc;
    }

    public String getToLoc() {
        return toLoc;
    }

    public void setToLoc(String toLoc) {
        this.toLoc = toLoc;
    }

    public Timestamp getDeparture() {
        return departure;
    }

    public void setDeparture(Timestamp departure) {
        this.departure = departure;
    }

    public Timestamp getArrival() {
        return arrival;
    }

    public void setArrival(Timestamp arrival) {
        this.arrival = arrival;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public Set<Passenger> getPassengers() {
        return passengers;
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
        passenger.getFlights().add(this);
    }

    public void removePassenger(Passenger passenger) {
        passengers.remove(passenger);
        passenger.getFlights().remove(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return id != null && id.equals(((Flight) o).id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", from='" + fromLoc + '\'' +
                ", to='" + toLoc + '\'' +
                ", departure=" + departure +
                ", arrival=" + arrival +
                '}';
    }
}

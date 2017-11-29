package com.epam.homework.orm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import static com.epam.homework.orm.ConstantsContainer.*;

@Entity
@Table(name = FLIGHT)
@NamedQueries({
        @NamedQuery(name = Flight.FIND_ALL_FLIGHTS, query = "SELECT f FROM Flight f"),
        @NamedQuery(name = Flight.FIND_FLIGHT_BY_ID, query = "SELECT f FROM Flight f WHERE id = :id"),
        @NamedQuery(
                name = Flight.FIND_FLIGHTS_WITH_LESS_THAN_FILTER_PASSENGERS_NAMED_QUERY,
                query = "SELECT f, COUNT(p) "
                        + "FROM Flight f "
                        + "INNER JOIN f.passengers p "
                        + "GROUP BY f "
                        + "HAVING COUNT(p) < :filter"
        ),
        @NamedQuery(
                name = Flight.FIND_AIRPLANE_DETAILS_FOR_FLIGHT_NAMED_QUERY,
                query = "SELECT f, a "
                        + "FROM Flight f "
                        + "INNER JOIN f.airplane a "
                        + "WHERE f.id = :id"
        )
})
@NamedNativeQueries({
        @NamedNativeQuery(
                name = Flight.FIND_FLIGHTS_WITH_LESS_THAN_FILTER_PASSENGERS_NATIVE_QUERY,
                query = "SELECT f.id, f.to_loc, f.from_loc, f.departure, f.arrival, COUNT(b) "
                        + "FROM flight f "
                        + "INNER JOIN booking b ON f.id = b.flight_id "
                        + "GROUP BY f.id, f.to_loc, f.from_loc, f.departure, f.arrival "
                        + "HAVING COUNT(b) < :filter"
        ),
        @NamedNativeQuery(
                name = Flight.FIND_AIRPLANE_DETAILS_FOR_FLIGHT_NATIVE_QUERY,
                query = "SELECT f.id AS flightid, f.to_loc, f.from_loc, f.departure, f.arrival, "
                        + "a.id AS airplaneid, a.model_number, a.capacity "
                        + "FROM flight f "
                        + "INNER JOIN airplane a ON f.airplane_id = a.id "
                        + "WHERE f.id = :id"
        )
})
public class Flight {

    public static final String FIND_ALL_FLIGHTS = "findAllFlights";
    public static final String FIND_FLIGHT_BY_ID = "findFlightById";
    public static final String FIND_FLIGHTS_WITH_LESS_THAN_FILTER_PASSENGERS_NAMED_QUERY = "findFlightsWithLessThanFilterPassengersNamedQuery";
    public static final String FIND_FLIGHTS_WITH_LESS_THAN_FILTER_PASSENGERS_NATIVE_QUERY = "findFlightsWithLessThanFilterPassengersNativeQuery";
    public static final String FIND_AIRPLANE_DETAILS_FOR_FLIGHT_NAMED_QUERY = "findAirplaneDetailsForFlightNamedQuery";
    public static final String FIND_AIRPLANE_DETAILS_FOR_FLIGHT_NATIVE_QUERY = "findAirplaneDetailsForFlightNativeQuery";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = FROM_LOC, nullable = false)
    private String from;

    @Column(name = TO_LOC, nullable = false)
    private String to;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(nullable = false)
    private Timestamp departure;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(nullable = false)
    private Timestamp arrival;

    @ManyToOne(
            fetch = FetchType.EAGER, //TODO Change back to LAZY after switching to Spring
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinColumn(name = AIRPLANE_ID)
    private Airplane airplane;

    @JsonIgnore
    @ManyToMany(
            fetch = FetchType.EAGER, //TODO Change back to LAZY after switching to Spring
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

    public Flight(String from, String to, Timestamp departure, Timestamp arrival) {
        this.from = from;
        this.to = to;
        this.departure = departure;
        this.arrival = arrival;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
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
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", departure=" + departure +
                ", arrival=" + arrival +
                '}';
    }
}

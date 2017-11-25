package com.epam.homework.orm.domain;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

import static com.epam.homework.orm.ConstantsContainer.*;

@Entity
@Table(name = PASSENGER)
@NamedQueries({
        @NamedQuery(
                name = Passenger.FIND_PASSENGERS_BY_FLIGHT_NAMED_QUERY,
                query = "SELECT DISTINCT p FROM Passenger p "
                        + "INNER JOIN p.flights f "
                        + "WHERE f.id = :id "
                        + "ORDER BY p.name"
        )
})
@NamedNativeQueries({
        @NamedNativeQuery(
                name = Passenger.FIND_ALL_PASSENGERS,
                query = "SELECT p.id, p.name, p.gender FROM passenger p",
                resultClass = Passenger.class
        ),
        @NamedNativeQuery(
                name = Passenger.FIND_PASSENGER_BY_ID,
                query = "SELECT p.id, p.name, p.gender FROM passenger p WHERE p.id = ?",
                resultClass = Passenger.class
        ),
        @NamedNativeQuery(
                name = Passenger.FIND_PASSENGERS_BY_FLIGHT_NATIVE_QUERY,
                query = "SELECT DISTINCT p.id, p.name, p.gender "
                        + "FROM passenger p "
                        + "INNER JOIN booking b ON p.id = b.passenger_id "
                        + "WHERE b.flight_id = ? "
                        + "ORDER BY p.name",
                resultClass = Passenger.class
        )
})
public class Passenger {

    public static final String FIND_ALL_PASSENGERS = "findAllPassengers";
    public static final String FIND_PASSENGER_BY_ID = "findPassengerById";
    public static final String FIND_PASSENGERS_BY_FLIGHT_NAMED_QUERY = "findPassengersByFlightNamedQuery";
    public static final String FIND_PASSENGERS_BY_FLIGHT_NATIVE_QUERY = "findPassengersByFlightNativeQuery";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Enumerated(EnumType.STRING)
    @Column
    private Gender gender;

    @OneToOne(
            mappedBy = PASSENGER,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private PassengerContactInfo passengerContactInfo;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = BOOKING,
            joinColumns = @JoinColumn(name = PASSENGER_ID),
            inverseJoinColumns = @JoinColumn(name = FLIGHT_ID)
    )
    private Set<Flight> flights = new HashSet<>();

    public Passenger() {
    }

    public Passenger(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public PassengerContactInfo getPassengerContactInfo() {
        return passengerContactInfo;
    }

    public void setPassengerContactInfo(PassengerContactInfo passengerContactInfo) {
        this.passengerContactInfo = passengerContactInfo;
        passengerContactInfo.setPassenger(this);
    }

    public Set<Flight> getFlights() {
        return flights;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return id != null && id.equals(((Passenger) o).id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }
}

package com.epam.homework.orm.db.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import static com.epam.homework.orm.ConstantsContainer.*;

@Entity
@Table(name = PASSENGER_CONTACT_INFO)
public class PassengerContactInfo {

    @Id
    @Column(name = PASSENGER_ID)
    private Long passenger_id;

    @Column
    private String email;

    @Column
    private String phone;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Passenger passenger;

    public PassengerContactInfo() {
    }

    public PassengerContactInfo(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }

    public long getPassengerId() {
        return passenger_id;
    }

    public void setPassengerId(long passenger_id) {
        this.passenger_id = passenger_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}

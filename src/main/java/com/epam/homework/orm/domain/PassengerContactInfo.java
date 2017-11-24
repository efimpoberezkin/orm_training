package com.epam.homework.orm.domain;

import javax.persistence.*;

import static com.epam.homework.orm.ConstantsContainer.*;

@Entity
@Table(name = PASSENGER_CONTACT_INFO)
public class PassengerContactInfo {

    @Id
    private Long id;

    @Column
    private String email;

    @Column
    private String phone;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Passenger passenger;

    public PassengerContactInfo() {
    }

    public PassengerContactInfo(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

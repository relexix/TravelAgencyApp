package sda.TravelAgencyApp.entities;

import javax.persistence.*;

@Entity
@Table(name = "trips")
public class TripEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tripId;

}

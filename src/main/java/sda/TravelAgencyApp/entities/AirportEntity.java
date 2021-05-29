package sda.TravelAgencyApp.entities;

import javax.persistence.*;

@Entity
@Table(name = "airports")
public class AirportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer airportId;
    private String name;

    @ManyToOne
    @JoinColumn(name = "countryId")
    private CountryEntity country;

    public AirportEntity() {
    }

    public AirportEntity(Integer airportId, String name, CountryEntity country) {
        this.airportId = airportId;
        this.name = name;
        this.country = country;
    }

    public Integer getAirportId() {
        return airportId;
    }

    public void setAirportId(Integer airportId) {
        this.airportId = airportId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CountryEntity getCountry() {
        return country;
    }

    public void setCountry(CountryEntity country) {
        this.country = country;
    }
}

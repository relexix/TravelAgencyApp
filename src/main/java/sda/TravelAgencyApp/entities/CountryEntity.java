package sda.TravelAgencyApp.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "countries")
public class CountryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer countryId;

    private String name;

    @ManyToOne
    @JoinColumn(name = "continentId")
    private ContinentEntity continent;

    @OneToMany(mappedBy = "country")
    private List<CityEntity> cities;

    @OneToMany(mappedBy = "country")
    private List<AirportEntity> airports;

    public CountryEntity() {
    }

    public CountryEntity(Integer countryId, String name, ContinentEntity continent, List<CityEntity> cities, List<AirportEntity> airports) {
        this.countryId = countryId;
        this.name = name;
        this.continent = continent;
        this.cities = cities;
        this.airports = airports;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String countryName) {
        this.name = countryName;
    }

    public ContinentEntity getContinent() {
        return continent;
    }

    public void setContinent(ContinentEntity continent) {
        this.continent = continent;
    }

    public List<CityEntity> getCities() {
        return cities;
    }

    public void setCities(List<CityEntity> cities) {
        this.cities = cities;
    }

    public List<AirportEntity> getAirports() {
        return airports;
    }

    public void setAirports(List<AirportEntity> airports) {
        this.airports = airports;
    }
}

package sda.TravelAgencyApp.entities;

import jdk.nashorn.internal.runtime.Scope;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cities")
public class CityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cityId;
    private String name;

    @ManyToOne
    @JoinColumn(name = "countryId")
    private CountryEntity country;

    @OneToMany(mappedBy = "city")
    private List<HotelEntity> hotels;

    public CityEntity() {
    }

    public CityEntity(Integer cityId, String name, CountryEntity country, List<HotelEntity> hotels) {
        this.cityId = cityId;
        this.name = name;
        this.country = country;
        this.hotels = hotels;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
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

    public List<HotelEntity> getHotels() {
        return hotels;
    }

    public void setHotels(List<HotelEntity> hotels) {
        this.hotels = hotels;
    }
}

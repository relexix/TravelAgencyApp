package sda.TravelAgencyApp.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "continents")
public class ContinentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer continentId;

    private String name;

    @OneToMany(mappedBy = "continent")
    private List<CountryEntity> countries;


    public ContinentEntity() {
    }

    public ContinentEntity(Integer continentId, String name, List<CountryEntity> countries) {
        this.continentId = continentId;
        this.name = name;
        this.countries = countries;
    }

    public Integer getContinentId() {
        return continentId;
    }

    public void setContinentId(Integer continentId) {
        this.continentId = continentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String continentName) {
        this.name = continentName;
    }

    public List<CountryEntity> getCountries() {
        return countries;
    }

    public void setCountries(List<CountryEntity> countries) {
        this.countries = countries;
    }
}

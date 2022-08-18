package com.vipindubey.springrestjpa.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name ="building_limit")
public class BuildingLimit implements Serializable {

    private static final long serialVersionUID = 1390982270797715882L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Version
    private Long version;

    @NotNull
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "coordinate_id", referencedColumnName = "id")
    private List<Coordinate> coordinates;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BuildingLimit(){ }

    public BuildingLimit(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }



    @Override
    public String toString() {
        return "BuildingLimit{" +
                "id=" + id +
                ", coordinates=" + coordinates +
                '}';
    }
}

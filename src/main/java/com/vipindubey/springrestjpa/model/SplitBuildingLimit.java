package com.vipindubey.springrestjpa.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="split_building_limit")
public class SplitBuildingLimit  implements Serializable {

    private static final long serialVersionUID = -5936063285545951401L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @ManyToMany
    private List<Coordinate> coordinates;

    @NotNull
    @Column
    private long elevation;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "height_plateau_id", referencedColumnName = "id")
    private HeightPlateau heightPlateau;

    public SplitBuildingLimit() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public HeightPlateau getHeightPlateau() {
        return heightPlateau;
    }

    public void setHeightPlateau(HeightPlateau heightPlateau) {
        this.heightPlateau = heightPlateau;
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "SplitBuildingLimit{" +
                "id=" + id +
                ", coordinates=" + coordinates +
                ", elevation=" + elevation +
                ", heightPlateau=" + heightPlateau +
                '}';
    }
}

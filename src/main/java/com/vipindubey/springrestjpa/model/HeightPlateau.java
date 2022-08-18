package com.vipindubey.springrestjpa.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Entity
@Table(name="height_plateau")
public class HeightPlateau implements Serializable {

    private static final long serialVersionUID = 6006650582718588680L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Version
    private Long version;

    @NotNull
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "coordinate_with_height_id", referencedColumnName = "id")
    private List<CoordinateWithHeight> coordinatesWithHeight;

    public HeightPlateau(){}

    public HeightPlateau(List<CoordinateWithHeight> coordinatesWithHeight) {
        this.coordinatesWithHeight = coordinatesWithHeight;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<CoordinateWithHeight> getCoordinatesWithHeight() {
        return coordinatesWithHeight;
    }

    public void setCoordinatesWithHeight(List<CoordinateWithHeight> coordinatesWithHeight) {
        this.coordinatesWithHeight = coordinatesWithHeight;
    }

    @Override
    public String toString() {
        return "HeightPlateau{" +
                "id=" + id +
                ", coordinatesWithHeight=" + coordinatesWithHeight +
                '}';
    }
}

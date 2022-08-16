package com.vipindubey.springrestjpa.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name="coordinate_with_height")
public class CoordinateWithHeight extends Coordinate implements Serializable {

    private static final long serialVersionUID = -4245331524774962161L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Column
    private long elevation;

    public CoordinateWithHeight(long latitude, long longitude, long elevation) {
        super(latitude, longitude);
        this.elevation = elevation;
    }

    public CoordinateWithHeight() {}


    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public long getElevation() {
        return elevation;
    }

    public void setElevation(long elevation) {
        this.elevation = elevation;
    }

    public long getHeight() {
        return elevation;
    }

    public void setHeight(long height) {
        this.elevation = height;
    }

    @Override
    public String toString() {
        return "CoordinateWithHeight{" +
                "id=" + id +
                ", elevation=" + elevation +
                '}';
    }
}

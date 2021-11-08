package com_reto3_ciclo3.reto3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "cinemas")
@Getter
@Setter
public class Cinema implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCinema;

    private String name;
    private String owner;
    private Integer capacity;
    private String description;


    @ManyToOne
    @JoinColumn(name = "idCategory")
    @JsonIgnoreProperties("cinemas")
    private Category category;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "cinema")
    @JsonIgnoreProperties({"cinema", "client"})
    private List<Message> messages;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "cinema")
    @JsonIgnoreProperties({"cinema", "client"})
    private List<Reservation> reservations;

}

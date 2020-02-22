package pl.sda.ticketing_software_sda_gp.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Queue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long idQueue;
    @Column(unique = true )
    @NotNull
    private  String name;


}


package com.utn.ejercicio1.entidades;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "domicilio")
public class Domicilio extends BaseEntidad {

    @Column(name = "calle", length = 50, nullable = false)
    private String calle;

    @Column(name = "numero", length = 50, nullable = false)
    private String numero;

    @Column(name = "localidad", length = 50, nullable = false)
    private String localidad;

}

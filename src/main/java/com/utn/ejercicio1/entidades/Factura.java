package com.utn.ejercicio1.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "factura")
public class Factura extends BaseEntidad {

    @Column(name = "numero", nullable = false)
    private int numero;

    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @Column(name = "descuento", nullable = false)
    private double descuento;

    @Column(name = "formaPago", nullable = false)
    private String formaPago;

    @Column(name = "total", nullable = false)
    private int total;
}

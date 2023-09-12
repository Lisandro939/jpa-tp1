package com.utn.ejercicio1.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "producto")
public class Producto extends BaseEntidad {

    @Column(name = "tipo", length = 50, nullable = false)
    private String tipo;

    @Column(name = "tiempoEstimadoCocina", nullable = false)
    private int tiempoEstimadoCocina;

    @Column(name = "denominacion", length = 50, nullable = false)
    private String denominacion;

    @Column(name = "precioVenta", nullable = false)
    private double precioVenta;

    @Column(name = "precioCompra", nullable = false)
    private double precioCompra;

    @Column(name = "stockActual", nullable = false)
    private int stockAnual;

    @Column(name = "stockMinimo", nullable = false)
    private int stockMinimo;

    @Column(name = "unidadMedida", nullable = false)
    private String unidadMedida;

    @Column(name = "receta", length = 50, nullable = false)
    private String receta;
}

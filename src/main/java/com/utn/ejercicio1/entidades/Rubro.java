package com.utn.ejercicio1.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "rubro")
public class Rubro extends BaseEntidad{

    @Column(name = "denominacion", length = 50, nullable = false)
    private String denominacion;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "producto_id", referencedColumnName = "id")
    @Builder.Default
    private List<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
    }

    public void mostrarProductos(){
        for (Producto producto : productos) {
            System.out.println("Producto: " + producto.getDenominacion() +
                    " Tipo: " + producto.getTipo() +
                    " Tiempo de cocina: " + producto.getTiempoEstimadoCocina() +
                    " Precio de venta: " + producto.getPrecioVenta() +
                    " Precio de compra: " + producto.getPrecioCompra() +
                    " Stock actual: " + producto.getStockAnual() +
                    " Stock minimo: " + producto.getStockMinimo() +
                    " Unidad de medida: " + producto.getUnidadMedida() +
                    " Receta: " + producto.getReceta());
        }
    }
}

package com.utn.ejercicio1.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "pedido")
public class Pedido extends BaseEntidad {

    @Column(name = "estado", length = 50, nullable = false)
    private String estado;

    @Column(name = "fecha", length = 50, nullable = false)
    private Date fecha;

    @Column(name = "tipoEnvio", nullable = false)
    private Integer tipoEnvio;

    @Column(name = "total", nullable = false)
    private Double total;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "detallePedido_id", referencedColumnName = "id")
    @Builder.Default
    private List<DetallePedido> detallePedidos = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "factura_id", referencedColumnName = "id")
    private Factura factura;

    public void agregarDetallePedido(DetallePedido detallePedido) {
        this.detallePedidos.add(detallePedido);
    }

    public void mostrarDetallePedido() {
        System.out.println("Detalle del pedido:");
        for (DetallePedido detallePedido : detallePedidos) {
            System.out.println("Cantidad: " + detallePedido.getCantidad() + " Subtotal: " + detallePedido.getSubtotal() + " Producto: " + detallePedido.getProducto());
        }
    }


    public void mostrarFactura() {
        System.out.println("Factura del pedido:");
        System.out.println("Numero: " + factura.getNumero() + " Fecha: " + factura.getFecha() + " Descuento: " + factura.getDescuento() + " Forma de pago: " + factura.getFormaPago() + " Total: " + factura.getTotal());
    }
}

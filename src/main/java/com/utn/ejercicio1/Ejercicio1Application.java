package com.utn.ejercicio1;

import com.utn.ejercicio1.entidades.*;
import com.utn.ejercicio1.repositories.ClienteRepository;
import com.utn.ejercicio1.repositories.PedidoRepository;
import com.utn.ejercicio1.repositories.ProductoRepository;
import com.utn.ejercicio1.repositories.RubroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.Date;

@SpringBootApplication
public class Ejercicio1Application {

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	PedidoRepository pedidoRepository;

	@Autowired
	RubroRepository rubroRepository;

	@Autowired
	ProductoRepository productoRepository;

	public static void main(String[] args) {

		SpringApplication.run(Ejercicio1Application.class, args);
		System.out.println("Ya funcioné B)");
	}

	@Bean
	CommandLineRunner init(ClienteRepository clienteRepo) {
		return args -> {
			System.out.println("Voy a realizar cosas sobre el cliente...");
			Cliente cliente = Cliente.builder()
					.nombre("Juan")
					.apellido("Perez")
					.telefono("123456789")
					.email("juanperez@gmail.com")
					.build();

			Domicilio domicilio1 = Domicilio.builder()
					.calle("Calle 123")
					.numero("123")
					.localidad("CABA")
					.build();

			Domicilio domicilio2 = Domicilio.builder()
					.calle("Avenida siempre viva")
					.numero("123")
					.localidad("Mendoza")
					.build();

			cliente.agregarDomicilio(domicilio1);
			cliente.agregarDomicilio(domicilio2);

			clienteRepository.save(cliente);

			Cliente clienteRecuperada = clienteRepository.findById(cliente.getId()).orElse(null);
			if (clienteRecuperada != null) {
				System.out.println("Nombre: " + clienteRecuperada.getNombre());
				System.out.println("Apellido: " + clienteRecuperada.getApellido());
				System.out.println("Telefono: " + clienteRecuperada.getTelefono());
				System.out.println("Email: " + clienteRecuperada.getEmail());

				clienteRecuperada.mostrarDomicilios();
			} else {
				System.out.println("No se pudo recuperar la persona");
			};
		};
	}

	@Bean
	CommandLineRunner init2(PedidoRepository pedidoRepo) {
		return args -> {
			Date date = new Date();
			System.out.println("Voy a realizar cosas sobre el pedido...");
			Factura factura = Factura.builder()
					.numero(1)
					.fecha(date)
					.descuento(50.0)
					.formaPago("Efectivo")
					.total(1000)
					.build();

			Pedido pedido = Pedido.builder()
					.estado("En proceso")
					.fecha(date)
					.tipoEnvio(1)
					.total(1000.0)
					.factura(factura)
					.build();

			DetallePedido detallePedido1 = DetallePedido.builder()
					.cantidad(1)
					.subtotal(100.0)
					.build();

			DetallePedido detallePedido2 = DetallePedido.builder()
					.cantidad(2)
					.subtotal(200.0)
					.build();

			pedido.agregarDetallePedido(detallePedido1);
			pedido.agregarDetallePedido(detallePedido2);

			pedidoRepository.save(pedido);

			Pedido pedidoRecuperado = pedidoRepository.findById(pedido.getId()).orElse(null);
			if (pedidoRecuperado != null) {
				System.out.println("Estado: " + pedidoRecuperado.getEstado());
				System.out.println("Fecha: " + pedidoRecuperado.getFecha());
				System.out.println("Tipo de envio: " + pedidoRecuperado.getTipoEnvio());
				System.out.println("Total: " + pedidoRecuperado.getTotal());

				pedidoRecuperado.mostrarDetallePedido();
				pedidoRecuperado.mostrarFactura();
			} else {
				System.out.println("No se pudo recuperar el pedido");

			}
			;
		};
	}

	@Bean
	CommandLineRunner init3(RubroRepository rubroRepo, ProductoRepository productoRepo) {
		return args -> {
			System.out.println("Voy a realizar cosas sobre el rubro y el producto...");
			Producto producto = Producto.builder()
					.tipo("Lacteo")
					.tiempoEstimadoCocina(10)
					.denominacion("Leche")
					.precioVenta(100.0)
					.precioCompra(50.0)
					.stockAnual(100)
					.stockMinimo(10)
					.unidadMedida("Litros")
					.receta("Leche")
					.build();

			Producto producto2 = Producto.builder()
					.tipo("Lacteo")
					.tiempoEstimadoCocina(10)
					.denominacion("Queso")
					.precioVenta(100.0)
					.precioCompra(50.0)
					.stockAnual(100)
					.stockMinimo(10)
					.unidadMedida("Litros")
					.receta("Leche")
					.build();

			Rubro rubro = Rubro.builder()
					.denominacion("Lacteos")
					.build();

			rubro.agregarProducto(producto);
			rubro.agregarProducto(producto2);

			rubroRepository.save(rubro);
			productoRepository.save(producto);
			productoRepository.save(producto2);

			Rubro rubroRecuperado = rubroRepository.findById(rubro.getId()).orElse(null);
			if (rubroRecuperado != null) {
				System.out.println("Denominacion: " + rubroRecuperado.getDenominacion());
				rubroRecuperado.mostrarProductos();
			} else {
				System.out.println("No se pudo recuperar el rubro");
			}
		};
	};
}

package actividadEntradas4;

import java.time.LocalDate;

import actividadEntradas4.Boleto;
import actividadEntradas4.Cliente;

public class Venta {
	private LocalDate fechaVenta;
	private Boleto boleto ;
	private Cliente cliente = new Cliente();
	


	public Venta(LocalDate fechaVenta, Boleto boleto, Cliente cliente) {
		this.fechaVenta = fechaVenta;
		this.boleto = boleto;
		this.cliente = cliente;
	}

	public Venta() {
		
	}

	public LocalDate getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public Boleto getBoleto() {
		return boleto;
	}

	public void setBoleto(Boleto boleto) {
		this.boleto = boleto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	
	

}

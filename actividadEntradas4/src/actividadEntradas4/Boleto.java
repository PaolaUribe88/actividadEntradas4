package actividadEntradas4;

import java.time.LocalDate;

public class Boleto {
	private int valor;
	private boolean estadoBoleto;
	private LocalDate fechaEvento;
	private String nomEvento;
	private Asiento asiento = new Asiento();
	
	public Boleto() {
		
	}
	
	
	public Boleto(int valor, boolean estadoBoleto, LocalDate fechaEvento, String nomEvento, Asiento asiento) {
		this.valor = valor;
		this.estadoBoleto = estadoBoleto;
		this.fechaEvento = fechaEvento;
		this.nomEvento = nomEvento;
		this.asiento = asiento;
	}
	
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public boolean isEstadoBoleto() {
		return estadoBoleto;
	}
	public void setEstadoBoleto(boolean estadoBoleto) {
		this.estadoBoleto = estadoBoleto;
	}
	public LocalDate getFechaEvento() {
		return fechaEvento;
	}
	public void setFechaEvento(LocalDate fechaEvento) {
		this.fechaEvento = fechaEvento;
	}
	public String getNomEvento() {
		return nomEvento;
	}
	public void setNomEvento(String nomEvento) {
		this.nomEvento = nomEvento;
	}


	public Asiento getAsiento() {
		return asiento;
	}


	public void setAsiento(Asiento asiento) {
		this.asiento = asiento;
	}
	
}

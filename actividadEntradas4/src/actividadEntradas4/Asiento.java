package actividadEntradas4;

public class Asiento {

    private int asiento;
    private boolean estado;
    private String tipo;
    
    

	public Asiento(int asiento, boolean estado, String tipo) {
		this.asiento = asiento;
		this.estado = estado;
		this.tipo = tipo;
	}

	public Asiento() {

	}

	public Asiento(int asiento) {

	}
	public Asiento(int asiento, boolean estado) {
		this.asiento = asiento;
		this.estado = estado;
	}


	public int getAsiento() {
		return asiento;
	}

	public void setAsiento(int asiento) {
		this.asiento = asiento;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int checkTipoBoleto() {
		if (this.tipo == "PALCO") {
			return 100000;
		}else if (this.tipo == "PLATEA") {
			return 60000;
		}else {
			return 30000;
		}
	}
	}
package banco.modelos;

import java.util.Date;

public class Transferencia {
	
	private Integer id;
	private Integer idOrigen;
	private Integer idDestino;
	private Double saldo;
	private Date fecha;

	public Transferencia(Integer id, Integer idOrigen, Integer idDestino, Double saldo) {
		this.id = id;
		this.idOrigen = idOrigen;
		this.idDestino = idDestino;
		this.saldo = saldo;
		this.fecha = new Date();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdOrigen() {
		return idOrigen;
	}

	public void setIdOrigen(Integer idOrigen) {
		this.idOrigen = idOrigen;
	}

	public Integer getIdDestino() {
		return idDestino;
	}

	public void setIdDestino(Integer idDestino) {
		this.idDestino = idDestino;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String toString() {
		return "Transferencia{id: " + this.id + ", texto: " + this.saldo + "}";
	}

	//public boolean equals(Object o) {
		//Transferencia t = (Transferencia) o;
		//boolean mismoId = this.id == t.id;
		//return mismoId;
}
package com.example.UD26EJ3.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="reserva")//en caso que la tabala sea diferente
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "dni")
	Investigador investigador;

	@ManyToOne
	@JoinColumn(name = "numserie")
	Equipo equipo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date comienzoAt;

	@Temporal(TemporalType.TIMESTAMP)
	private Date finAt;
	

	public Reserva() {
		super();
	}


	public Reserva(Investigador investigador, Equipo equipo, Date comienzoAt, Date finAt) {
		super();
		this.investigador = investigador;
		this.equipo = equipo;
		this.comienzoAt = comienzoAt;
		this.finAt = finAt;
	}


	public Investigador getInvestigador() {
		return investigador;
	}


	public void setInvestigador(Investigador investigador) {
		this.investigador = investigador;
	}


	public Equipo getEquipo() {
		return equipo;
	}


	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}


	public Date getComienzoAt() {
		return comienzoAt;
	}


	public void setComienzoAt(Date comienzoAt) {
		this.comienzoAt = comienzoAt;
	}


	public Date getFinAt() {
		return finAt;
	}


	public void setFinAt(Date finAt) {
		this.finAt = finAt;
	}


	@Override
	public String toString() {
		return "Reserva [investigador=" + investigador + ", equipo=" + equipo + ", comienzoAt=" + comienzoAt
				+ ", finAt=" + finAt + "]";
	}
	
	
	
	
	
	
	

}

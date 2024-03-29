package com.example.opentable.repository.entity;





import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tableorder")
public class TableOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int tableOrderId;
	
	@Column
	private LocalDateTime arrivalTime;
	
	@Column 
	private LocalDateTime departureTime;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "table_Id")
	private Bench bench;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "booking_Id")
	private Booking booking;
	

	public TableOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Bench getBench() {
		return bench;
	}



	public void setBench(Bench bench) {
		this.bench = bench;
	}



	public TableOrder(int tableOrderId, LocalDateTime arrivalTime, LocalDateTime departTime, Bench bench, Booking booking) {
		super();
		this.tableOrderId = tableOrderId;
		this.arrivalTime = arrivalTime;
		this.departureTime = departTime;
		this.bench = bench;
		this.booking = booking;
	}



	public int getTableOrderId() {
		return tableOrderId;
	}

	public void setTableOrderId(int tableOrderId) {
		this.tableOrderId = tableOrderId;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public LocalDateTime getDepartTime() {
		return departureTime;
	}

	public void setDepartTime(LocalDateTime departTime) {
		this.departureTime = departTime;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}
}

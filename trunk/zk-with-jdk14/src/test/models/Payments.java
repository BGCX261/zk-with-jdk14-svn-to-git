package test.models;

import java.sql.Timestamp;

/**
 * Payments entity. @author MyEclipse Persistence Tools
 */

public class Payments implements java.io.Serializable {

	// Fields

	private PaymentsId id;
	private Timestamp paymentDate;
	private Double amount;

	// Constructors

	/** default constructor */
	public Payments() {
	}

	/** full constructor */
	public Payments(PaymentsId id, Timestamp paymentDate, Double amount) {
		this.id = id;
		this.paymentDate = paymentDate;
		this.amount = amount;
	}

	// Property accessors

	public PaymentsId getId() {
		return this.id;
	}

	public void setId(PaymentsId id) {
		this.id = id;
	}

	public Timestamp getPaymentDate() {
		return this.paymentDate;
	}

	public void setPaymentDate(Timestamp paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

}
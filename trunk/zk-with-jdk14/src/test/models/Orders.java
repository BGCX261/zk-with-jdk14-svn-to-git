package test.models;

import java.sql.Timestamp;

/**
 * Orders entity. @author MyEclipse Persistence Tools
 */

public class Orders implements java.io.Serializable {

	// Fields

	private Integer orderNumber;
	private Timestamp orderDate;
	private Timestamp requiredDate;
	private Timestamp shippedDate;
	private String status;
	private String comments;
	private Integer customerNumber;

	// Constructors

	/** default constructor */
	public Orders() {
	}

	/** minimal constructor */
	public Orders(Timestamp orderDate, Timestamp requiredDate, String status,
			Integer customerNumber) {
		this.orderDate = orderDate;
		this.requiredDate = requiredDate;
		this.status = status;
		this.customerNumber = customerNumber;
	}

	/** full constructor */
	public Orders(Timestamp orderDate, Timestamp requiredDate,
			Timestamp shippedDate, String status, String comments,
			Integer customerNumber) {
		this.orderDate = orderDate;
		this.requiredDate = requiredDate;
		this.shippedDate = shippedDate;
		this.status = status;
		this.comments = comments;
		this.customerNumber = customerNumber;
	}

	// Property accessors

	public Integer getOrderNumber() {
		return this.orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Timestamp getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	public Timestamp getRequiredDate() {
		return this.requiredDate;
	}

	public void setRequiredDate(Timestamp requiredDate) {
		this.requiredDate = requiredDate;
	}

	public Timestamp getShippedDate() {
		return this.shippedDate;
	}

	public void setShippedDate(Timestamp shippedDate) {
		this.shippedDate = shippedDate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Integer getCustomerNumber() {
		return this.customerNumber;
	}

	public void setCustomerNumber(Integer customerNumber) {
		this.customerNumber = customerNumber;
	}

}
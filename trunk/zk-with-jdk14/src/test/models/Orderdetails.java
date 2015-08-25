package test.models;

/**
 * Orderdetails entity. @author MyEclipse Persistence Tools
 */

public class Orderdetails implements java.io.Serializable {

	// Fields

	private OrderdetailsId id;
	private Integer quantityOrdered;
	private Double priceEach;
	private Short orderLineNumber;

	// Constructors

	/** default constructor */
	public Orderdetails() {
	}

	/** full constructor */
	public Orderdetails(OrderdetailsId id, Integer quantityOrdered,
			Double priceEach, Short orderLineNumber) {
		this.id = id;
		this.quantityOrdered = quantityOrdered;
		this.priceEach = priceEach;
		this.orderLineNumber = orderLineNumber;
	}

	// Property accessors

	public OrderdetailsId getId() {
		return this.id;
	}

	public void setId(OrderdetailsId id) {
		this.id = id;
	}

	public Integer getQuantityOrdered() {
		return this.quantityOrdered;
	}

	public void setQuantityOrdered(Integer quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

	public Double getPriceEach() {
		return this.priceEach;
	}

	public void setPriceEach(Double priceEach) {
		this.priceEach = priceEach;
	}

	public Short getOrderLineNumber() {
		return this.orderLineNumber;
	}

	public void setOrderLineNumber(Short orderLineNumber) {
		this.orderLineNumber = orderLineNumber;
	}

}
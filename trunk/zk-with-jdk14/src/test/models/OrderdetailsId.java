package test.models;

/**
 * OrderdetailsId entity. @author MyEclipse Persistence Tools
 */

public class OrderdetailsId implements java.io.Serializable {

	// Fields

	private Integer orderNumber;
	private String productCode;

	// Constructors

	/** default constructor */
	public OrderdetailsId() {
	}

	/** full constructor */
	public OrderdetailsId(Integer orderNumber, String productCode) {
		this.orderNumber = orderNumber;
		this.productCode = productCode;
	}

	// Property accessors

	public Integer getOrderNumber() {
		return this.orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getProductCode() {
		return this.productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OrderdetailsId))
			return false;
		OrderdetailsId castOther = (OrderdetailsId) other;

		return ((this.getOrderNumber() == castOther.getOrderNumber()) || (this
				.getOrderNumber() != null
				&& castOther.getOrderNumber() != null && this.getOrderNumber()
				.equals(castOther.getOrderNumber())))
				&& ((this.getProductCode() == castOther.getProductCode()) || (this
						.getProductCode() != null
						&& castOther.getProductCode() != null && this
						.getProductCode().equals(castOther.getProductCode())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getOrderNumber() == null ? 0 : this.getOrderNumber()
						.hashCode());
		result = 37
				* result
				+ (getProductCode() == null ? 0 : this.getProductCode()
						.hashCode());
		return result;
	}

}
package test.models;

/**
 * PaymentsId entity. @author MyEclipse Persistence Tools
 */

public class PaymentsId implements java.io.Serializable {

	// Fields

	private Integer customerNumber;
	private String checkNumber;

	// Constructors

	/** default constructor */
	public PaymentsId() {
	}

	/** full constructor */
	public PaymentsId(Integer customerNumber, String checkNumber) {
		this.customerNumber = customerNumber;
		this.checkNumber = checkNumber;
	}

	// Property accessors

	public Integer getCustomerNumber() {
		return this.customerNumber;
	}

	public void setCustomerNumber(Integer customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getCheckNumber() {
		return this.checkNumber;
	}

	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PaymentsId))
			return false;
		PaymentsId castOther = (PaymentsId) other;

		return ((this.getCustomerNumber() == castOther.getCustomerNumber()) || (this
				.getCustomerNumber() != null
				&& castOther.getCustomerNumber() != null && this
				.getCustomerNumber().equals(castOther.getCustomerNumber())))
				&& ((this.getCheckNumber() == castOther.getCheckNumber()) || (this
						.getCheckNumber() != null
						&& castOther.getCheckNumber() != null && this
						.getCheckNumber().equals(castOther.getCheckNumber())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCustomerNumber() == null ? 0 : this.getCustomerNumber()
						.hashCode());
		result = 37
				* result
				+ (getCheckNumber() == null ? 0 : this.getCheckNumber()
						.hashCode());
		return result;
	}

}
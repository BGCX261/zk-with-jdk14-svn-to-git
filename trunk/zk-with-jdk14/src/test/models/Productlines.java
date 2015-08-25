package test.models;

/**
 * Productlines entity. @author MyEclipse Persistence Tools
 */

public class Productlines implements java.io.Serializable {

	// Fields

	private String productLine;
	private String textDescription;
	private String htmlDescription;
	private String image;

	// Constructors

	/** default constructor */
	public Productlines() {
	}

	/** full constructor */
	public Productlines(String textDescription, String htmlDescription,
			String image) {
		this.textDescription = textDescription;
		this.htmlDescription = htmlDescription;
		this.image = image;
	}

	// Property accessors

	public String getProductLine() {
		return this.productLine;
	}

	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}

	public String getTextDescription() {
		return this.textDescription;
	}

	public void setTextDescription(String textDescription) {
		this.textDescription = textDescription;
	}

	public String getHtmlDescription() {
		return this.htmlDescription;
	}

	public void setHtmlDescription(String htmlDescription) {
		this.htmlDescription = htmlDescription;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
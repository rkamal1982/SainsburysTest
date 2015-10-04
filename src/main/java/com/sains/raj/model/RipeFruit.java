/**
 * 
 */
package com.sains.raj.model;

/**
 * @author Raj_Kamal02
 *
 */
public class RipeFruit {
	
	private String title;
	private String Size;
	private Double unit_price;
	private String desctription;
	
	public RipeFruit(String title, String size, Double unit_price,
			String desctription) {
		super();
		this.title = title;
		Size = size;
		this.unit_price = unit_price;
		this.desctription = desctription;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSize() {
		return Size;
	}

	public void setSize(String size) {
		Size = size;
	}

	public Double getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(Double unit_price) {
		this.unit_price = unit_price;
	}

	public String getDesctription() {
		return desctription;
	}

	public void setDesctription(String desctription) {
		this.desctription = desctription;
	}
	
	

}

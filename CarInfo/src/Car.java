
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author SHIVSHANKAR
 */
public class Car implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String manufacturerName;
	private String modelName;
	private String colour;
	private double carPrice;
	private String purchaseDate;
	private String servicePeriod;

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String ManufacturerName) {
		this.manufacturerName = ManufacturerName;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String ModelName) {
		this.modelName = ModelName;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String Colour) {
		this.colour = Colour;
	}

	public double getCarPrice() {
		return carPrice;
	}

	public void setCarPrice(double CarPrice) {
		this.carPrice = CarPrice;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getServicePeriod() {
		return servicePeriod;
	}

	public void setServicePeriod(String servicePeriod) {
		this.servicePeriod = servicePeriod;
	}

	public Car() {
	}

	public Car(String manufacturerName, String modelName, String purchaseDate, String servicePeriod, double carPrice) {

		this.manufacturerName = manufacturerName;
		this.modelName = modelName;
		this.purchaseDate = purchaseDate;
		this.servicePeriod = servicePeriod;
		this.carPrice = carPrice;
	}

	@Override
	public String toString() {
		return "Car [manufacturerName=" + manufacturerName + ", modelName=" + modelName + ", colour=" + colour
				+ ", carPrice=" + carPrice + ", purchaseDate=" + purchaseDate + ", servicePeriod=" + servicePeriod
				+ "]";
	}

	
	
}

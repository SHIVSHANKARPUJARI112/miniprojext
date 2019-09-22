import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author SHIVSHANKAR
 */
@SuppressWarnings("serial")
public class Customer implements java.io.Serializable  {
    
    private String customerName;
    private int age;
    private String idProof;
    private String addressProof;
    private ArrayList<Car> cars;

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getAge() {
        return age;
    }

    public String getIdProof() {
        return idProof;
    }

    public String getAddressProof() {
        return addressProof;
    }

    public Customer(String customerName, int age, String idProof, String addressProof, ArrayList<Car> cars) {
        this.customerName = customerName;
        this.age = age;
        this.idProof = idProof;
        this.addressProof = addressProof;
        this.cars = cars;
    }

	public Customer() {
	}

	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", age=" + age + ", idProof=" + idProof + ", addressProof="
				+ addressProof + ", cars=" + cars + "]";
	}
    
}

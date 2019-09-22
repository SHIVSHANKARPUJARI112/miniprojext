
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author SHIVSHANKAR
 */

public class MainClass  {
    
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
    	
    	MainClass mainClass = new MainClass();
        System.out.println("Welcome To Car Info");
        int i =1;
        String userChoice ="";
     
        
        System.out.println("Press 1 for Registration Form:"+"\n"+"Press 2 for Login Form:"
        +"\n"+"Press 3 for Exit");
        
        System.out.println("Enter Your Choice:");
        Scanner sc1=new Scanner(System.in);
        userChoice=sc1.nextLine();
         while(i==1) {
       
        	 
        if(userChoice.equals("1")){
    	 Customer  customer=mainClass.RegistrationForm();
           mainClass.Writetofile(customer);  
           System.out.println(" Enter 1 for car Details : "+"\n"+"Enter 2 For Registration for Car");
           Scanner sc2=new Scanner(System.in);
           String numStr = sc2.nextLine();
           int userInput=Integer.parseInt(numStr); 
          // int userInput=sc1.nextInt();
           if(userInput==1) {
        	 System.out.println("Your registered cars are :-");
        	 ArrayList<Car> cars = customer.getCars();
        	 mainClass.PrintCarDetails(cars);
        	// System.out.println(customer.getCars().toString());
        	 userChoice = mainClass.intialStep();
        	 System.out.println("User choice is "+userChoice);
           }else if(userInput==2) {
        	  Car car= mainClass.registerCar();
        	  ArrayList<Car> cars =customer.getCars();
        	  cars.add(car);
        	  customer.setCars(cars);
              boolean isWritten = mainClass.Writetofile(customer);
              if (isWritten == true ) {
                  System.out.println("Your Car has been successfully Registered");       
             	 userChoice = mainClass.intialStep();

             	 
             	 System.out.println("User choice is "+userChoice);
          }else {
            	  System.out.println("Something went wrong while registering ...");
             	 userChoice = mainClass.intialStep();
            	 System.out.println("User choice is "+userChoice);

              }

           }
         
        }
        else if(userChoice.equals("2")){
        	
            System.out.print("Enter UserName:");
            Scanner scanner=new Scanner(System.in);
            String userName=scanner.nextLine();
            System.out.println("Enter SecretID:");
            String id=sc.nextLine();
            
           boolean isCorrectUser = mainClass.LoginForm(userName, id);
            if (isCorrectUser == true) {
            	Customer customerFromFile = mainClass.ReadFromFile(userName+id);
            	System.out.println("Hello "+customerFromFile.getCustomerName()+",");
            	
                System.out.println(" Enter 1 for car Details : "+"\n"+"Enter 2 For Registration for Car");
                String numStr = sc.nextLine();
                int userInput=Integer.parseInt(numStr);
                
                if(userInput==1) {
             	   System.out.println("Your registered cars are :-");
             	  ArrayList<Car> cars = customerFromFile.getCars();
             	 mainClass.PrintCarDetails(cars);
             	// System.out.println(customerFromFile.getCars().toString());
             	 
             	userChoice = mainClass.intialStep();
            	 System.out.println("User choice is "+userChoice);

                }else if(userInput==2) {
             	  Car car= mainClass.registerCar();
             	  ArrayList<Car> cars =customerFromFile.getCars();
             	  cars.add(car);
             	 customerFromFile.setCars(cars);
                 boolean isWritten = mainClass.Writetofile(customerFromFile);
                 if(isWritten) {
                     System.out.println("Your Car has been successfully Registered");
                	 userChoice= mainClass.intialStep();
                	 System.out.println("User choice is "+userChoice);
                	 
                 }else if (isWritten == false) {
                	 System.out.println("Something went wrong while registering ");
                	 userChoice= mainClass.intialStep();
                	 System.out.println("User choice is "+userChoice);                	 
                 }
                
                }
            	
            }else {
            	System.out.println("Wrong username or password ");
                userChoice = mainClass.intialStep();   
            }
        }else if(userChoice.equals("3")){
            System.out.println("ThankYou For Visting CarInfo");
            break;
        }
        else{
            System.out.println("Invalid option.Please Enter Correct Choice");
            userChoice = mainClass.intialStep();   
        	System.out.println("User choice is "+userChoice);
            
        }
   
        }      
         
    }
    
    public boolean Writetofile(Customer customer) {
    	try
        {    
            //Saving of object in a file 
            FileOutputStream file = new FileOutputStream("src/users/"+customer.getCustomerName()+customer.getIdProof()); 
            ObjectOutputStream out = new ObjectOutputStream(file); 
              
            // Method for serialization of object 
            out.writeObject(customer);  
            out.close(); 
            file.close(); 
//            System.out.println("Object has been serialized"); 
            return true;
  
        } 
          
        catch(IOException ex) 
        { 
            System.out.println("IOException is caught"); 
            return false;
        } 
    }
    
    public Customer ReadFromFile(String filename) {
    	System.out.println("filename is "+filename);
    	Customer customer = null;
    	try
        {    
            // Reading the object from a file 
            FileInputStream file = new FileInputStream("src/users/"+filename); 
            ObjectInputStream in = new ObjectInputStream(file); 
            // Method for deserialization of object 
            customer = (Customer)in.readObject(); 
            in.close(); 
            file.close(); 
//            System.out.println("Object has been deserialized "); 
             
        } 
          
        catch(IOException | ClassNotFoundException ex) 
        { 
            System.out.println("IOException is caught"); 
        } 
        return customer;

    }
    
    public Customer RegistrationForm(){
    	////Customer customer=new Customer();
    
        System.out.println("Fill the Registration Form:");
                
        System.out.println("Enter your user name :");
        
        String username=sc.nextLine();
      
        System.out.println("Enter Your Age:");
        String ageStr = sc.nextLine();
        int age=Integer.parseInt(ageStr);
        
        System.out.println("Enter Aadhar or PanCard No.");
        String idNo=sc.nextLine();
        
        System.out.println("Enter your address proof");
        String address=sc.nextLine();
        
        
     return new Customer(username, age, idNo, address,new ArrayList<Car>());
    }
     
    public Car registerCar() {
    	 Car car=new Car();
    	 System.out.println("Enter manufacturer name");
    	 String manufacturer=sc.nextLine();
    	 
    	 System.out.println("Enter model");
    	 String model=sc.nextLine();
    	 
    	 System.out.println("Enter car price");
         String ageStr = sc.nextLine();
         double price=Double.parseDouble(ageStr);

    	 String servicePeriod ="6 months";
    	 System.out.println("Service Period :-  "+servicePeriod);
    	 
    	 System.out.println("Enter colour");
    	 String colour=sc.nextLine();
    	 
    	 DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
         Date dateobj = new Date();
         String currentTime = df.format(dateobj);
         System.out.println();
         
         car.setManufacturerName(manufacturer);
         car.setModelName(model);
         car.setColour(colour);
         car.setCarPrice(price);
         car.setPurchaseDate(currentTime);
         car.setServicePeriod(servicePeriod);
         return car;
    	
    }
    
    public String intialStep() {
        System.out.println("Press 1 for Registration Form:"+"\n"+"Press 2 for Login Form:"
        +"\n"+"Press 3 for Exit");
        
        System.out.println("Enter Your Choice:");
        Scanner scanner=new Scanner(System.in);
        String userChoice=scanner.nextLine();
        return userChoice;
    }
    
    public boolean LoginForm(String userName,String id){
            
        boolean isCorrectDetails=VerifyDetail(userName,id);
         return isCorrectDetails;
    }
    
    public boolean VerifyDetail(String UserName,String id){
    String filename = UserName+id;    
    File file = new File("src/users/"+filename);
    boolean fileExists = file.exists() ; 
    return fileExists;      
    }
    
    public void PrintCarDetails(ArrayList<Car> cars) {
    	int size = cars.size();
    	if (size==0)
    	{ System.out.println("No Cars are Found");
    	return;}	
    for (int i = 0; i < size; i++) {
		Car car = cars.get(i);
    	System.out.println("Available cars are :- ");
    	System.out.println(i+") "+" Manufacturer name : "+car.getManufacturerName());
    	System.out.println("Model name : "+car.getModelName()+"  Registered date : "+car.getPurchaseDate()+" Colour : "+car.getColour());
    	System.out.println("Price : "+car.getCarPrice()+" Service date : "+car.getServicePeriod());
    	
	}
    	
    }
    
    }
    
    


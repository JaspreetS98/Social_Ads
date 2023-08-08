public class IndividualConsumer extends Consumer {
	private String DOB;
	private String passportNumber;
	public IndividualConsumer(AdBank adBank) {
		super(adBank);
	}
	
	public String getDOB() {
		return DOB;
	}
	
	public String getPassportNumber() {
		return passportNumber;
	}
	
	public void setDOB(String DOB) {
		this.DOB = DOB;
	}
	
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	
	public void display(){
        System.out.println("Id Number: " +  id + "\n" + name +  "\n" + telephoneNumber + "\n" + address + "\n" + email +"\n" + DOB + "\n" + passportNumber +"\n*******************************************");
    }
	
public void signUp(){
        // get details from consumer and store in consumer
        System.out.println("*******************************************");
        System.out.println("Input Details for an IndividualConsumer ");
        System.out.println("*******************************************");
        
        // stub- get details for a Consumer 
        name = "John";
        telephoneNumber = "07384983844";
        email= "JohnK@bcu.ac.uk";
        address = "B42 2SU";
        DOB = "21/05/1980";
        passportNumber = "UI302RNM";
        display(); 
    }
}
public class CorporateConsumer extends Consumer {
	String sector;
	
	public CorporateConsumer(AdBank adBank) {
		super(adBank);
	}
	
	public String getSector() {
		return sector;
	}
	
	public void setSector(String sector) {
		this.sector = sector;
	}
	
	public void display(){
        System.out.println("Id Number: " +  id + "\n" + name +  "\n" + telephoneNumber + "\n" + address + "\n" + email +"\n" + sector + "\n*******************************************");
    }
	
public void signUp(){
        // get details from consumer and store in consumer
        System.out.println("*******************************************");
        System.out.println("Input Details for an CorporateConsumer ");
        System.out.println("*******************************************");
        // stub- get details for a Consumer 
        name = "Casanova";
        telephoneNumber = "07534826982";
        email= "CasanovaJ@bcu.ac.uk";
        address = "B42 2SU";
        sector = "healthcare";
        display();  
    } 
}

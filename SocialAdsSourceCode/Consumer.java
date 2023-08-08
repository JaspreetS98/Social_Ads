import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.ArrayList;

public class Consumer {
    protected String id = "00000";
    protected String name;
    protected String address;
    protected String email;
    protected String telephoneNumber;
    private HashMap<String, Advertisement> activity;
    private AdBank adBank;
    private Administration admin;
    private ArrayList<Advertisement> results;
    private DisplaySearch displaySearch ;
    private LoyaltyCard loyaltyCard;
    private RRDisplay rrDisplay;
    private RRDatabase  rrDatabase;

    public Consumer( AdBank adBank) {
         //create stubs for online advertisements and Admin
        this.adBank = adBank;
        //Hashmap to record activity
        activity=new HashMap<String,Advertisement>();  
       //setup Loyalty card
        loyaltyCard = new LoyaltyCard(rrDisplay,rrDatabase);
        // Display searches
        displaySearch = new DisplaySearch();
        rrDisplay =  new RRDisplay(loyaltyCard);
        rrDatabase = new RRDatabase(loyaltyCard);
        //attach to the loyalty card    
    }
    
    public void display(){
        System.out.println("Id Number: " +  id + "\n" + name +  "\n" + telephoneNumber + "\n" + address + "\n" + email +"\n" + "*******************************************");
    }
    
    public void changeDetails(){ 
        System.out.println("Display new details after update");
        // get change details from consumer and store
        address = "WV69 7G";
        display();
        System.out.println("*******************************************");
        System.out.println("*******************************************");    
    } 

    public void setId(String id) {
        this.id= id;
    }
    public String getId() {
        return id;
    }
    
   public void simulation() {
       //search
       searchSectorByLocation("Double Glazing","B42 2SU");
       searchSectorByLocation("Books","DY1 4YP");
       searchSectorByLocation("Books","DY1 4VP");
       //display all results
       displaySearch.displayAllActivity(activity); 
       //some advertisements are used
       activityRegistered(); 
       //The consumer displays reviewable/ratable advertisments
       loyaltyCard.displayUsed();
       //Review an advertisement and display
       reviewAd("Smiths:Bay Window");
       reviewAd("B&Q:Hammer");
       //Display Reviews from Database
       rrDisplay.displayReviews(); 
       //Rate an advertisement and display
       rateAd("Smiths:Bay Window");
       rateAd("Screwfix:Screw Driver");
       //Display Reviews from Database
        rrDisplay.displayRatings();
       //dump database
       rrDatabase.displayAdverts(); 
    }
   
   public  void searchSectorByLocation(String sector, String location){
        //do a search by location
        Search s1  =  new Search(sector,adBank);
        results = s1.searchByLocation(location);
        // Remember the activity
        for (Advertisement a:results){
            activity.put(a.getTitle(),a );
            }

        //display search results
        displaySearch.showRecentSearch(results);   
    }
   
    public void activityRegistered() {
     //***************************************************************
        //The system is informed of completion of transactions associated with this consumer - would normally be a parallel thread
        loyaltyCard.registerUse(adBank.getAdvertisement("Smiths:Bay Window"));
        loyaltyCard.registerUse(adBank.getAdvertisement("Johnsons:Bay Window"));
        loyaltyCard.registerUse(adBank.getAdvertisement("Screwfix:Screw Driver"));
        loyaltyCard.registerUse(adBank.getAdvertisement("B&Q:Hammer"));
        //loyaltyCard.registerUse(activity.get("Smiths:Bay Window"));
        //loyaltyCard.registerUse(activity.get("Johnsons:Bay Window"));
        
     //****************************************************************    
    }
    
   public void reviewAd(String title) {
        System.out.println("*******************************************");
        System.out.println("The consumer reviews an advertisement");
        System.out.println("*******************************************");
       //review an advertisement 
        loyaltyCard.reviewAd(title);  
    }
    
    public void rateAd(String title) {
       //The consumer displays reviewable/ratable advertisments
        System.out.println("*******************************************");
        System.out.println("The consumer rates an advertisement");
        System.out.println("*******************************************");
       //rate an advertisement 
        loyaltyCard.rateAd(title);  
    }
}
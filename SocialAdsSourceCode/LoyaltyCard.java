/**
 * Stub class for Displaying Serach Results
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;

public class LoyaltyCard implements Subject
{
    private HashMap<String, Advertisement> usedAds;
    private RRDisplay rrDisplay;
    private RRDatabase  rrDatabase;
    private List<Observer> observers;

    public LoyaltyCard (RRDisplay rrDisplay, RRDatabase rrDatabase){
        usedAds = new HashMap<String,Advertisement>(); 
        this.rrDisplay = rrDisplay;
        this.rrDatabase =rrDatabase;
        observers = new ArrayList<Observer>();  
    }
    
    public void registerUse(Advertisement used){
        System.out.println("*******************************************");
        System.out.println("Register a Used Advertisement on the Loyalty Card" );
        System.out.println("*******************************************");
        if (used != null){
            System.out.println("*******************************************");
            System.out.println(used.getTitle() + "  Registered as Used Advertisement");
            System.out.println("*******************************************");
            usedAds.put(used.getTitle(),used);}
        else { System.out.println("Sorry you have not used that Advertisement");
        }
        System.out.println();
    }
    public void displayUsed(){
        System.out.println("*******************************************");
        System.out.println("Results of Search for Used Advertisements");
        System.out.println("*******************************************");
        Set set = usedAds.entrySet();
        Iterator i = set.iterator();
        while (i.hasNext())
        {
            Map.Entry me = (Map.Entry)i.next();
            usedAds.get(me.getKey()).display(); 
        }
        System.out.println();
        }
    
    public void rateAd(String title){
        if (usedAds.containsKey(title)){
            Advertisement ratedAd = usedAds.get(title);
            ratedAd.addRating();
            notifyObservers(ratedAd);
        }
        else {
            System.out.println("Sorry you cannot rate this advertisement as not used: " + title);
        }    
       System.out.println();
    }

	public void reviewAd(String title) {
		  if (usedAds.containsKey(title)){
	            Advertisement reviewedAd = usedAds.get(title);
	            reviewedAd.addReview();
	            notifyObservers(reviewedAd);
	        }
	        else {
	            System.out.println("Sorry you cannot rate this advertisement as not used: " + title);
	        }    
	       System.out.println();
	}

	@Override
	public void register(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void remove(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers(Advertisement reviewedAd) {
		for (Observer o: observers)
			o.update(reviewedAd);
	}
}
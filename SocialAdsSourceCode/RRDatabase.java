import java.util.ArrayList;

class RRDatabase implements Observer
 // Rate and Reviewstub class for Database
{
    private ArrayList<Advertisement> reviewedAds;
    private Subject subject;
    
    // private constructor restricted to this class itself
    public RRDatabase(Subject LoyaltyCard)
    {
       reviewedAds = new ArrayList<Advertisement>(); 
       LoyaltyCard.register(this);
    }
    
    @Override
    public void update(Advertisement reviewedAd){
    if (!reviewedAds.contains(reviewedAd)){
          reviewedAds.add(reviewedAd); 
        }     
    } 
    
    public void displayAdverts(){
        //stub for database activites
        System.out.println("*******************************************");
        System.out.println("Display Reviewed and Rated Advertisements");
        System.out.println("*******************************************");
        for (Advertisement a:reviewedAds){
            System.out.println("Information  for " + a.getTitle());
            a.display();
            for (String r:a.getReviews()){
                System.out.println("Review: " + r + "\n*******************************************");   
            }
            System.out.println("Average Rating:  " + a.getAvgRanking());
            System.out.println("*******************************************" +  "\n"); 
        }
    }  
}
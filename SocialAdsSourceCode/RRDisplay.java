/**
 *
 * @author Jaspreet Singh 19150299 / Roheel Ahmed 19127784
 * @version 1.25 20/05/2021
 */
import java.util.ArrayList;

public class RRDisplay  implements Observer
{//stub class for Ranking Display
    private ArrayList<Advertisement> reviewedAds;
    private Subject subject;
    
    public RRDisplay (Subject LoyaltyCard){
        reviewedAds = new ArrayList<Advertisement>();
        LoyaltyCard.register(this);
    }
    
	@Override
    public void update(Advertisement reviewedAd){
        if (!reviewedAds.contains(reviewedAd)){
          reviewedAds.add(reviewedAd); 
        }
    } 
	
    public void displayReviews(){
        System.out.println("*******************************************");
        System.out.println("Display Reviews");
        System.out.println("*******************************************");
        System.out.println("*******************************************");
        for (Advertisement a:reviewedAds){
            System.out.println("Reviews for " + a.getTitle());
            for (String r:a.getReviews()){
                System.out.println(r + "\n*******************************************");
            }
        System.out.println();
        }
    }
    
    public void displayRatings(){
        System.out.println("*******************************************");
        System.out.println("Display Ratings");
        System.out.println("*******************************************");
        System.out.println("*******************************************");
        for (Advertisement a:reviewedAds){
            System.out.println("Average Rating for " + a.getTitle());
            System.out.println("Average Rating:  " + a.getAvgRanking());
            System.out.println("*******************************************");   
        }
        System.out.println();
    }
}
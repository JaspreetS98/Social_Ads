import java.util.ArrayList;
import java.util.List;

public interface Subject {
	List<Observer> observers = new ArrayList<>();
	public default void register(Observer observer) {
        this.observers.add(observer);
    }   
	
	public default void remove(Observer observer) {
        if(this.observers.contains(observer)) {
            this.observers.remove(observer);
        }
    }
	
	public default void notifyObservers(Advertisement reviewedAd) {
        for(Observer o : observers) {
            o.update(reviewedAd);
        }
    }
}
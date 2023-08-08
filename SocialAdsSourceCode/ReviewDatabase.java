public class ReviewDatabase {
		private static ReviewDatabase reviewDatabase = null;
		
		// private constructor
		private ReviewDatabase() { }
		
		//static method to return  instance of the class
		public static ReviewDatabase getReviewDatabase() {		
			if(reviewDatabase == null) {
				reviewDatabase = new ReviewDatabase();
				return reviewDatabase;
			}		
			return reviewDatabase;				
		}
}
package debuggingexample;

//TODO: Auto-generated Javadoc
/**
* The Class Review.
*
* @author john_ortega
*/
public class Review {
	
	/** The stars. */
	int stars = 0;

	/** The review. */
	String review = null;
	
	/** The song. */
	Song song = null;

	
	/**
	 * Instantiates a new review.
	 *
	 * @param song the song
	 */
	public Review(Song song) {
		super();
		this.song = song;
	}

	/**
	 * Gets the stars.
	 *
	 * @return the stars
	 */
	public int getStars() {
		return stars;
	}
	
	/**
	 * Sets the stars.
	 *
	 * @param stars the new stars
	 */
	public void setStars(int stars) {
		this.stars = stars;
	}
	
	/**
	 * Gets the review.
	 *
	 * @return the review
	 */
	public String getReview() {
		return review;
	}
	
	/**
	 * Sets the review.
	 *
	 * @param review the new review
	 */
	public void setReview(String review) {
		this.review = review;
	}
	
	

}

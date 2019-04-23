package uned.webtechnologies.shop.controllers.output;

public class RatingOutput implements Output{
    private String message;
    private double averageRating;
    private double ratingPercent;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public double getRatingPercent() {
        return ratingPercent;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public void setRatingPercent(double ratingPercent) {
        this.ratingPercent = ratingPercent;
    }
}
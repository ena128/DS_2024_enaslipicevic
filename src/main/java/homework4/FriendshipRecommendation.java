package homework4;

public class FriendshipRecommendation implements Comparable<FriendshipRecommendation> {
    // implement the relevant properties, constructor and methods
    //properties
    private String user;
    private int recommendationStrength;
    //constructor
    public FriendshipRecommendation(String user, int recommendationStrength) {
        this.user = user;
        this.recommendationStrength = recommendationStrength;
    }
    //get, set, methods
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getRecommendationStrength() {
        return recommendationStrength;
    }

    public void setRecommendationStrength(int recommendationStrength) {
        this.recommendationStrength = recommendationStrength;
    }

    @Override
    public int compareTo(FriendshipRecommendation o) {
        return Integer.compare(o.recommendationStrength, this.recommendationStrength);
    }

    @Override
    public String toString() {
        return user + ": " + recommendationStrength;
    }

}
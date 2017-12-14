import appliance.*;
import java.util.ArrayList;

/** Created by Devon on 12/13/2017
 * Represents a User for the notApp application
 */
public class User {

    private String name;
    private ArrayList<Appliance> favorites;

    public User(String inName) {
        name = inName;
        favorites = new ArrayList<Appliance>();
    }

    //Copy Constructor (might not need beyond testing)
    public User(User inUser) {
        name = inUser.getName();
        favorites = new ArrayList<Appliance>(inUser.getFavorites());
    }

    public String getName() {
        return name;
    }
    
    public ArrayList<Appliance> getFavorites() {
        return new ArrayList<Appliance>(favorites);
    }

    public void addFavorite(Appliance newFavorite) {
        favorites.add(newFavorite);
    }

    @Override
    public String toString() {
        return name + "\n" + "Favorited Appliances: " + favorites;
    }
}

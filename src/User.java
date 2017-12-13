import appliance.*;
import java.util.ArrayList;

/** Created by Devon on 12/13/2017
 * Represents a User for the notApp application
 */
public class User {

    private String name = "default";
    private ArrayList<Appliance> favorites;

    public User(String inName) {
        name = inName;
        favorites = new ArrayList<Appliance>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Appliance> getFavorites() {
        return favorites;
    }

    public void addFavorite(Appliance newFavorite) {
        //This next line is for testing/debug purposes
        System.out.println(newFavorite);
        favorites.add(newFavorite);
    }

    @Override
    public String toString() {
        return name + "\n" + "Favorited Appliances: " + favorites.toString();
    }
}

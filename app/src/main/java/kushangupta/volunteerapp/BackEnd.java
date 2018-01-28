package kushangupta.volunteerapp;

import android.media.Image;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by raghavan on 1/27/18.
 */

public class BackEnd {
    static DatabaseReference myRef = FirebaseDatabase.getInstance().getReference();

    public static void addEvent(String name, String description, int numPeople, int numPeopleRequired, String location) {
        Event e = new Event(name, description, numPeople, numPeopleRequired, location);
        myRef.child("Event").child(name).setValue(e);
    }

    public static void joinEvent(String eventName, User user) {
        // null
        myRef.child("Event").child(eventName).child("Users").child(user.email).setValue(user);
    }
}

class Event {

    String title;
    String description;
    int numPeople;
    int numPeopleRequired;

    String loc;
    private Image img;

    public Event(String title, String description, int numPeople, int numPeopleRequired, String loc) {
        this.title = title;
        this.description = description;
        this.numPeople = numPeople;
        this.numPeopleRequired = numPeopleRequired;
        this.loc = loc;
    }
}

class User {
    String name;
    String phoneNumber;
    String email;

    public User(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}

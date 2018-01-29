package kushangupta.volunteerapp;

import android.media.Image;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by raghavan on 1/27/18.
 */

public class BackEnd {

    static DatabaseReference myRef = FirebaseDatabase.getInstance().getReference();
    private static ArrayList<Event> events = new ArrayList<Event>();

    // Loads Firebase database
    public static void loadBackEnd() {
        myRef.keepSynced(true);
        myRef.child("Event").addValueEventListener(new ValueEventListener() {
            // Checks for changes in events ie loads new data from database
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot c : snapshot.getChildren()) {
                    Event e = c.getValue(Event.class);
                    boolean in = false;
                    for (Event f : events) {
                        if (f.title.equals(e.title))
                            in = true;
                    }

                    if (!in) {
                        events.add(e);
                        System.out.println(e.title);
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    // Creates an Array List of event objects
    public static ArrayList<Event> getEvents() {
        return new ArrayList<Event>(events);
    }
    ArrayList<Event> myEvent = BackEnd.getEvents();

    // Adds events to database with given parameters
    public static void addEvent(String name, String description, int numPeople, int numPeopleRequired, String location, String calendarDate) {
        Event e = new Event(name, description, numPeople, numPeopleRequired, location, calendarDate);
        myRef.child("Event").child(name).setValue(e);
    }

    // Adds users to given event
    public static void joinEvent(String eventName, User user) {
        // null
        myRef.child("Event").child(eventName).child("Users").child(user.email).setValue(user);
    }

    // Creates new user in database
    public static void newUser(String name, String email, String password) {
        User user = new User(name, email, password);
        myRef.child("Users").child(name).setValue(user);
    }

    // REFERENCE ONLY
    // Retrieves a single value from child
    public static void getName(String name){
        myRef.child("Users").child(name).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                System.out.println(snapshot.getValue());  //prints "Do you have data? You'll love Firebase."
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });    }
}

// User class
class User {
    String name;
    String email;
    private String password;

    public User(String name, String phoneNumber, String email) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}

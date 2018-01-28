package kushangupta.volunteerapp;

import android.media.Image;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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

    public static void newUser(String name, String email, String password) {
        User user = new User(name, email, password);
        Log.d("i", "slkdfjkljsdfklj");
        myRef.child("Users").child(name).setValue(user);
    }

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

class Event {

    String title;
    String address;
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
    String email;
    private String password;

    public User(String name, String phoneNumber, String email) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}

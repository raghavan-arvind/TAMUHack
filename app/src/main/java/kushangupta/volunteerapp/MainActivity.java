package kushangupta.volunteerapp;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.location.Location;
import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Write a message to the database

        Event harvey = new Event("Hurricane Harvey Relief",
                "Come help rebuild the areas destroyed by Hurricane Harvey!", 7, 200, "Houston, Texas")
        myRef = FirebaseDatabase.getInstance().getReference();
        myRef.child("Event").child("harvey-skdlhjfakdj").setValue(harvey);
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

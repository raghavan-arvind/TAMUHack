package kushangupta.volunteerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Write a message to the database
        mDatabase = FirebaseDatabase.getInstance().getReference();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        writeNewUser("kushan", "kushan gupta", "kg@gmail.com");

        writeNewUser("d", "kushan gupta", "k12g@gmail.com");
        writeNewUser("kushsan", "kushanwe gupta", "kg@gmail.com");
        writeNewUser("kushaasdfn", "kushanfd gupta", "kg@gmail.com");
        writeNewUser("kushqwerfvqfan", "kushadfn gupta", "kg@gmail.com");

        mDatabase.keepSynced(true);

    }



    private void writeNewUser(String userId, String name, String email) {
        User user = new User(name, email);

        mDatabase.child("users").child(userId).setValue(user);

    }
}

@IgnoreExtraProperties
 class User {

    public String username;
    public String email;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

}

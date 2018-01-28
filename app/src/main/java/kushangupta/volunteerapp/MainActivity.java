package kushangupta.volunteerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.google.firebase.database.DatabaseReference;


public class MainActivity extends AppCompatActivity {

    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        BackEnd.loadBackEnd();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button orgLoginBtn = (Button) findViewById(R.id.orgLoginBtn);
        Button volLoginBtn = (Button) findViewById(R.id.volunteerLoginBtn);
        TextView alreadyTv = (TextView) findViewById(R.id.alreadyTv);

        /* user clicked organization */
        orgLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OrgSignup.class);
                startActivity(intent);
            }
        });

        /* user clicked volunteer */
        volLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, VolunteerSignup.class);
                startActivity(intent);
            }
        });

        /* user clicked already account */
        alreadyTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });


    }


}




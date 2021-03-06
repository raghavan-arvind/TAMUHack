package kushangupta.volunteerapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class VolunteerSignup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_signup);


        final EditText volEmailEt = (EditText) findViewById(R.id.volEmailEt);
        final EditText volNameEt = (EditText) findViewById(R.id.volNameEt);
        final EditText volPhoneNumEt = (EditText) findViewById(R.id.volPhoneNumEt);
        final EditText volPasswordEt = (EditText) findViewById(R.id.volPasswordEt);
        Button volSignupBtn = (Button) findViewById(R.id.volSignupBtn);

        volSignupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String volName = volNameEt.getText().toString();
                String email = volEmailEt.getText().toString();
                String password = volPasswordEt.getText().toString();
                String phoneNumber = volPhoneNumEt.getText().toString();

                // Sends new user to Firebase
                BackEnd.newUser(volName, email, password);


                Intent intent = new Intent(VolunteerSignup.this, VolEventList.class);
                intent.putExtra("VOLNAME", volName);//keyvalue
                intent.putExtra("VOLEMAIL", email);
                intent.putExtra("PASSWORD", password);
                intent.putExtra("PHONENUMBER", phoneNumber);
                startActivity(intent);
            }
        });
    }


}

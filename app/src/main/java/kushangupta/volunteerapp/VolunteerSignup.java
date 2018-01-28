package kushangupta.volunteerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class VolunteerSignup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_signup);


        final EditText volEmailEt = (EditText) findViewById(R.id.orgEmailEt);
        final EditText volNameEt = (EditText) findViewById(R.id.orgNameEt);
        final EditText volPhoneNumEt = (EditText) findViewById(R.id.orgPhoneNumEt);
        final EditText volPasswordEt = (EditText) findViewById(R.id.orgPasswordEt);
        Button volSignupBtn = (Button) findViewById(R.id.volSignupBtn);

        volSignupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String volName = volNameEt.getText().toString();
                String email = volEmailEt.getText().toString();
                String password = volPasswordEt.getText().toString();
                String phoneNumber = volPhoneNumEt.getText().toString();

                BackEnd.newUser(volName, email, password);


                /* TODO: save pass in a page signup directs to*/
                //Intent intent = new Intent(OrgSignup.this, )
                //intent.putExtra("VOLNAME", volName);//keyvalue
                //intent.putExtra("VOLEMAIL", email);
                //intent.putExtra("PASSWORD", password);
                //intent.putExtra("PHONENUMBER", phoneNumber);
                //startActivity(intent);
            }
        });
    }


}

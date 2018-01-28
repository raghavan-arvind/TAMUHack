package kushangupta.volunteerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class OrgSignup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_org_signup);

        final EditText orgEmailEt = (EditText) findViewById(R.id.orgEmailEt);
        final EditText orgNameEt = (EditText) findViewById(R.id.orgNameEt);
        final EditText orgPhoneNumEt = (EditText) findViewById(R.id.orgPhoneNumEt);
        final EditText orgPasswordEt = (EditText) findViewById(R.id.orgPasswordEt);
        Button orgSignupBtn = (Button) findViewById(R.id.orgSignupBtn);

        orgSignupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String orgName = orgNameEt.getText().toString();
                String email = orgEmailEt.getText().toString();
                String password = orgPasswordEt.getText().toString();
                String phoneNumber = orgPhoneNumEt.getText().toString();


                /* TODO: save pass in a page signup directs to*/
                //Intent intent = new Intent(OrgSignup.this, )
                //intent.putExtra("ORGNAME", orgName);//keyvalue
                //intent.putExtra("ORGEMAIL", email);
                //intent.putExtra("PASSWORD", password);
                //intent.putExtra("PHONENUMBER", phoneNumber);
                //startActivity(intent);
            }
        });
    }





}

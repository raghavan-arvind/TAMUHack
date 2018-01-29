package kushangupta.volunteerapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class EventSignup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_signup);
        String[] images = new String[7];
        for (int i = 1; i <= 7; i++) {
            images[i - 1] = "@drawable/image" + i;
        }
        int randInt = (int) (Math.random() * 7);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        switch (randInt) {
            case 0:
                imageView.setImageResource(R.drawable.image1);
                break;
            case 1:
                imageView.setImageResource(R.drawable.image2);
                break;
            case 2:
                imageView.setImageResource(R.drawable.image3);
                break;
            case 3:
                imageView.setImageResource(R.drawable.image4);
                break;
            case 4:
                imageView.setImageResource(R.drawable.image5);
                break;
            case 5:
                imageView.setImageResource(R.drawable.image6);
                break;
            case 6:
                imageView.setImageResource(R.drawable.image7);
                break;
        }

        int pos = getIntent().getIntExtra("Position", 0);
        Event e = EventList.myEvents.get(pos);

        TextView titleTvTv = (TextView) findViewById(R.id.titleTvTv);
        TextView addressTv = (TextView) findViewById(R.id.addressTv);
        TextView dandtTv = (TextView) findViewById(R.id.dandtTv);
        TextView descTv = (TextView) findViewById(R.id.descTv);
        TextView numPeople = (TextView) findViewById(R.id.numPeopleTv);

        Button regBtn = (Button) findViewById(R.id.regBtn);
                /* user clicked organization */
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventSignup.this, EventList.class);
                intent.putExtra("SOURCE", "org_signup");
                startActivity(intent);
            }
        });

        titleTvTv.setText(e.getTitle());

        addressTv.setText(e.address);
        dandtTv.setText(e.calendarDate);
        descTv.setText(e.description);
        numPeople.setText(Integer.toString(e.numPeopleRequired));


    }


}

package kushangupta.volunteerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class EventSignup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_signup);
        int pos = getIntent().getIntExtra("Position", 0);
        Event e = EventList.myEvents.get(pos);

        TextView titleTvTv = (TextView) findViewById(R.id.titleTvTv);
        TextView addressTv = (TextView) findViewById(R.id.addressTv);
        TextView dandtTv = (TextView) findViewById(R.id.dandtTv);
        TextView descTv = (TextView) findViewById(R.id.descTv);
        TextView numPeople = (TextView) findViewById(R.id.numPeopleTv);

        Button regBtn = (Button) findViewById(R.id.regBtn);

        titleTvTv.setText(e.getTitle());

        addressTv.setText(e.address);
        dandtTv.setText(e.calendarDate);
        descTv.setText(e.description);
        numPeople.setText(Integer.toString(e.numPeopleRequired));


    }

}

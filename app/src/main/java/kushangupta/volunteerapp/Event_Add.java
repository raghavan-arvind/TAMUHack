package kushangupta.volunteerapp;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import android.support.v7.app.AppCompatActivity;
import com.google.android.*;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Event_Add extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_add);

        final EditText eventName = (EditText) findViewById(R.id.eventName);
        final EditText eventDescript = (EditText) findViewById(R.id.eventDescript);
        final EditText eventAddress = (EditText) findViewById(R.id.eventAddress);
        final NumberPicker numPeople = (NumberPicker) findViewById(R.id.numberPicker);
        final CalendarView eventDate = (CalendarView) findViewById(R.id.eventDate);

        Button eventCreateBtn = (Button) findViewById(R.id.eventCreateBtn);

        eventCreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = eventName.getText().toString();
                String desc = eventDescript.getText().toString();
                String address = eventAddress.getText().toString();
                int num = numPeople.getValue();

                // converting date to readable
                long date = eventDate.getDate();
                SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");
                Date resultdate = new Date(date);

                String dateString = sdf.format(resultdate);

                BackEnd.addEvent(name, desc, 0, num, address, dateString);


                Intent intent = new Intent(Event_Add.this, EventList.class);
                startActivity(intent);
            }
        });
    }
}


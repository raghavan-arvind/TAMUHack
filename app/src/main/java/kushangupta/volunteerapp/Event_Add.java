package kushangupta.volunteerapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TimePicker;


public class Event_Add extends AppCompatActivity {

    int year = 0;
    int month = 0;
    int day = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_add);

        final EditText eventName = (EditText) findViewById(R.id.eventName);
        final EditText eventDescript = (EditText) findViewById(R.id.eventDescript);
        final EditText eventAddress = (EditText) findViewById(R.id.eventAddress);
        final EditText numPeople = (EditText) findViewById(R.id.numberPicker);
        final CalendarView eventDate = (CalendarView) findViewById(R.id.eventDate);

        // Changes the date value based on what user clicks in calendar view
        eventDate.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                year = i;
                month = i1 + 1;
                day = i2;
            }
        });
        final TimePicker time = (TimePicker) findViewById(R.id.time);

        Button eventCreateBtn = (Button) findViewById(R.id.eventCreateBtn);

        eventCreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = eventName.getText().toString();
                String desc = eventDescript.getText().toString();
                String address = eventAddress.getText().toString();
                String t;
                String dateString;
                boolean PM = false;
                int num = Integer.parseInt(numPeople.getText().toString());

                if (time == null) {
                    dateString = "1/28 3:00 PM";
                } else {
                    int hours = time.getHour();
                    if (time.getHour() > 12) {
                        hours -= 12;
                        PM = true;
                    }

                    String end = PM ? "PM" : "AM";

                    t = String.format("%d/%02d %02d:%02d", month, day, hours, time.getMinute());

                    // converting date to readable
                    dateString = t + " " + end;
                }


                BackEnd.addEvent(name, desc, 0, num, address, dateString);
                //onSelectedDayChange(eventDate, );

                Intent intent = new Intent(Event_Add.this, EventList.class);
                intent.putExtra("SOURCE", "event_add");
                startActivity(intent);
            }
        });
    }
}



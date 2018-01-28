package kushangupta.volunteerapp;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Event_Add extends AppCompatActivity {

    int year = 0; int month = 0; int day = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_add);

        final EditText eventName = (EditText) findViewById(R.id.eventName);
        final EditText eventDescript = (EditText) findViewById(R.id.eventDescript);
        final EditText eventAddress = (EditText) findViewById(R.id.eventAddress);
        final NumberPicker numPeople = (NumberPicker) findViewById(R.id.numberPicker);
        final CalendarView eventDate = (CalendarView) findViewById(R.id.eventDate);

        eventDate.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                year = i; month = i1+1; day = i2;
            }
        });
        final TimePicker time = (TimePicker) findViewById(R.id.eventDate);

        Button eventCreateBtn = (Button) findViewById(R.id.eventCreateBtn);

        eventCreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = eventName.getText().toString();
                String desc = eventDescript.getText().toString();
                String address = eventAddress.getText().toString();
                String t = (time.getHour() > 12 ? time.getHour()-12: time.getHour()) + " " + time.getMinute() + (time.getHour() > 12 ? "PM" : "AM");
                int num = numPeople.getValue();

                // converting date to readable

                String dateString = String.format("%d/%d/%d ", month, day, year) + t;

                BackEnd.addEvent(name, desc, 0, num, address, dateString);
                //onSelectedDayChange(eventDate, );

                Intent intent = new Intent(Event_Add.this, EventList.class);
                intent.putExtra("SOURCE", "event_add");
                startActivity(intent);
            }
        });}

        public void onSelectedDayChange (CalendarView view, int year, int month, int dayOfMonth){

        }

    }



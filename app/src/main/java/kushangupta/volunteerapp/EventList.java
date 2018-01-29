package kushangupta.volunteerapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class EventList extends AppCompatActivity {
    static ArrayList<kushangupta.volunteerapp.Event> myEvents;
    String[] orgActivities = {"event_add", "org_signup"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Intent intent = this.getIntent();
        ListView lst;
        String source = intent.getExtras().getString("SOURCE");
        if (source != null && Arrays.asList(orgActivities).contains(source)) {
            setContentView(R.layout.activity_event_list);
            lst = (ListView) findViewById(R.id.eventsListView);
        } else {
            setContentView(R.layout.activity_vol_event_list);
            lst = (ListView) findViewById(R.id.volEventsLv);
        }

        myEvents = BackEnd.getEvents();
        CustomAdapter myAdapter = new CustomAdapter();
        lst.setAdapter(myAdapter);

        // Listens for clicks on event within Event list
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(EventList.this, EventSignup.class);
                intent.putExtra("Position", position);
                startActivity(intent);
            }
        });

        // Adds floating button if organization
        if (source != null && !source.equals("VolEventList")) {
            FloatingActionButton addEventBtn = (FloatingActionButton) findViewById(R.id.addEventBtn);
            addEventBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(EventList.this, Event_Add.class);
                    startActivity(intent);
                }
            });
        }
    }

    //
    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return myEvents.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.custom_list_layout, null);

            TextView eventTitleTv = (TextView) convertView.findViewById(R.id.eventTitleTv);
            TextView eventDescTv = (TextView) convertView.findViewById(R.id.eventDescTv);
            TextView eventDate = (TextView) convertView.findViewById(R.id.dateTv);
            eventTitleTv.setText(myEvents.get(position).getTitle());
            eventDescTv.setText(myEvents.get(position).getDescription());
            eventDate.setText(myEvents.get(position).calendarDate);


            return convertView;

        }
    }

}


package kushangupta.volunteerapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class EventList extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ArrayList<kushangupta.volunteerapp.Event> myEvents;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Intent intent = this.getIntent();
        ListView lst;
        String source = intent.getExtras().getString("SOURCE");;
        if (source != null && !source.equals("VolEventList")) {
            setContentView(R.layout.activity_event_list);
            lst = (ListView) findViewById(R.id.eventsListView);
        } else {
            setContentView(R.layout.activity_vol_event_list);
            lst = (ListView) findViewById(R.id.volEventsLv);
        }

        myEvents = BackEnd.getEvents();
        CustomAdapter myAdapter = new CustomAdapter();
        lst.setAdapter(myAdapter);
//
//


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

        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            TextView tv = (TextView) view;
            Toast.makeText(this, "You click on" + tv.getText() + position, Toast.LENGTH_SHORT).show();
        }
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
                eventTitleTv.setText(myEvents.get(position).getTitle());
                eventDescTv.setText(myEvents.get(position).getDescription());

                return convertView;

            }
        }

    }


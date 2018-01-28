package kushangupta.volunteerapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class EventList extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        ListAdapter listAdapter = new ArrayAdapter<Event>(this, android.R.layout.simple_list_item_1, BackEnd.getEvents());
        ListView listView = (ListView) findViewById(R.id.eventsListView);
        listView.setAdapter(listAdapter);


        FloatingActionButton addEventBtn = (FloatingActionButton) findViewById(R.id.addEventBtn);

        addEventBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventList.this, Event_Add.class);
                startActivity(intent);
            }
        });
    }

        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            TextView tv = (TextView) view;
            Toast.makeText(this, "You click on" + tv.getText() + position, Toast.LENGTH_SHORT).show();
        }
    }


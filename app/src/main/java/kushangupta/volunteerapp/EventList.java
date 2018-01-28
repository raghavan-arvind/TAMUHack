package kushangupta.volunteerapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class EventList extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        FloatingActionButton addEventBtn = (FloatingActionButton) findViewById(R.id.addEventBtn);
        ListAdapter listAdapter = new ArrayAdapter<Event>(this, android.R.layout.simple_list_item_1, BackEnd.getEvents());
        ListView listView = (ListView) findViewById(R.id.eventsListView);
        listView.setAdapter(listAdapter);

        addEventBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventList.this, Event_Add.class);
                startActivity(intent);
            }
        });
    }
}

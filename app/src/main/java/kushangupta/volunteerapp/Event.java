package kushangupta.volunteerapp;

import android.media.Image;

/**
 * Created by raghavan on 1/28/18.
 */
// Class for events organizations can make
public class Event {

    String title;
    String address;
    String description;
    String calendarDate;
    int numPeople;
    int numPeopleRequired;

    public Event(String title, String description, int numPeople, int numPeopleRequired, String address, String calendarDate) {
        this.title = title;
        this.description = description;
        this.numPeople = numPeople;
        this.numPeopleRequired = numPeopleRequired;
        this.calendarDate = calendarDate;
        this.address = address;
    }

        public String getTitle() { return this.title; }

        public String getDescription() { return this.description; }


}

package com.write.timecalendar;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by Vitalik on 05.09.2016.
 */
public class Event {
    Date date;
    String event;

    public Event(Date date, String event) {
        this.date = date;
        this.event = event;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;

        Event event1 = (Event) o;

        if (!date.equals(event1.date)) return false;
        return event.equals(event1.event);

    }

    @Override
    public int hashCode() {
        int result = date.hashCode();
        result = 31 * result + event.hashCode();
        return result;
    }
}

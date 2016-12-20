package com.write.timecalendar;

import java.time.LocalDate;
import java.util.Date;

/**
 * The class designed for storage methods which create event.
 * The class is created for storing information about event.
 */
public class Event {

    private LocalDate date;
    private String event;

    public Event(LocalDate date, String event) {
        this.date = date;
        this.event = event;
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;

        Event event1 = (Event) o;

        if (getDate() != null ? !getDate().equals(event1.getDate()) : event1.getDate() != null) return false;
        return getEvent() != null ? getEvent().equals(event1.getEvent()) : event1.getEvent() == null;

    }

    @Override
    public int hashCode() {
        int result = getDate() != null ? getDate().hashCode() : 0;
        result = 31 * result + (getEvent() != null ? getEvent().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "date: " + date + ", event: " + event + "\n";
    }
}

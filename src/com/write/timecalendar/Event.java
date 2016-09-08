package com.write.timecalendar;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Vitalik on 05.09.2016.
 */
public class Event {
    private Date date;
    private String event;

    public Event(Date date, String event) {
        this.date = date;
        this.event = event;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
}

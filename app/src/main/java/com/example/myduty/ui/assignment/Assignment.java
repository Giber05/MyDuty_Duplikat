package com.example.myduty.ui.assignment;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

@Entity(tableName = "assign_table")
public class Assignment implements Comparable {
    @PrimaryKey(autoGenerate = true) private int idTugas;
    @ColumnInfo(name = "course") private String course;
    @ColumnInfo(name = "topic") private String topic;
    @ColumnInfo(name = "deadline")private String deadline;
    @NonNull @ColumnInfo(name ="priority")
    private int priority;
    @ColumnInfo(name = "description") private String description;

    public Assignment(String course, String topic, String deadline, int priority, String description)
    {
        this.setCourse(course);
        this.setTopic(topic);
        this.setDeadline(deadline);
        this.setPriority(priority);
        this.setDescription(description);
    }


    public static String deadlineToString(GregorianCalendar calendar) {
        SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");
        fmt.setCalendar(calendar);
        String dateFormatted = fmt.format(calendar.getTime());

        return dateFormatted;
    }

    public String getCourse() {
        return course;
    }

    public String getTopic() {
        return topic;
    }

    public String getDeadline() {
        return deadline;
    }

    public int getPriority() {
        return priority;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int compareTo(Object o) {
        int comparePriority=((Assignment)o).getPriority();
        /* For Ascending order*/
        return this.getPriority() -comparePriority;
    }


    public int getIdTugas() {
        return idTugas;
    }

    public void setIdTugas(int idTugas) {
        this.idTugas = idTugas;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}




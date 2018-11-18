package ohtu;

import java.util.ArrayList;

public class Submission {

    private int week, hours;
    private ArrayList<Integer> exercises;
    private String course, fullName;

    public void setWeek(int week) {
        this.week = week;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setExercises(ArrayList<Integer> exercises) {
        this.exercises = exercises;
    }

    public int getHours() {
        return hours;
    }

    public ArrayList<Integer> getExercises() {
        return exercises;
    }

    public int getWeek() {
        return week;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String courseName) {
        this.course = courseName;
    }


    @Override
    public String toString() {
        return " aikaa kului " + hours + " tehdyt tehtävät " + this.exercises.toString().replace("[", "").replace("]", "");
    }

}

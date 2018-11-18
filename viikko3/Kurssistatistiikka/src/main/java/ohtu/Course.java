package ohtu;

import java.util.ArrayList;

public class Course {

    private String fullName, term, name;
    private int year;
    private ArrayList<Integer> exercises;

    public String getTerm() {
        return term;
    }

    public int getYear() {
        return year;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExercises(ArrayList<Integer> exercises) {
        this.exercises = exercises;
    }

    public ArrayList<Integer> getExercises() {
        return exercises;
    }

    @Override
    public String toString() {
        return this.fullName + " " + this.term + " " + this.year;
    }

}

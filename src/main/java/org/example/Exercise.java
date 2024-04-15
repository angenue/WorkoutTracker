package org.example;

public class Exercise {
    private String name;
    private int sets;
    private int reps;
    private double weight;
    private int duration; //for cardio and flexibility exercises
    private ExerciseType type;

    public Exercise(String name, ExerciseType type, int sets, int reps, double weight) {
        this.name = name;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
        this.type = type;
    }

    public Exercise(String name,ExerciseType type,  int duration) {
        this.name = name;
        this.duration = duration;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}

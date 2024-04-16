package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Program {
    private String name;
    private Map<DaysOfWeek, List<Exercise>> workout; //key is for workout day

    //add exercise
    //delete exercise

    public void addExercise() {
        ExerciseType type = getExerciseType();
        DaysOfWeek day = getDay();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name of exercise: ");
        String name = scanner.nextLine();

        switch (type) {
            case CARDIO: //no break statement which means it will go to flexibility
            case FLEXIBILITY:
                addCardioExercise(day, name, type);
                break;
            case STRENGTH:
                addStrengthExercise(day, name, type);
                break;

        }
        scanner.close();

    }

    //add cardio/flexibility exercise
    private void addCardioExercise(DaysOfWeek day, String name, ExerciseType type) {
        int duration = getIntegerInput("Enter duration in seconds");

        List<Exercise> exercises = workout.getOrDefault(day, new ArrayList<>());
        exercises.add(new Exercise(name, type, duration));

        workout.put(day,exercises);

        System.out.println("Exercise '" + name + "' added to " + day + ".");

    }

    //add strength exercise
    private void addStrengthExercise(DaysOfWeek day, String name, ExerciseType type) {
        int sets = getIntegerInput("Number of sets: ");
        int reps = getIntegerInput("Number of reps: ");
        double weight = getDoubleInput("Weight in lbs: ");

        List<Exercise> exercises = workout.getOrDefault(day, new ArrayList<>());
        exercises.add(new Exercise(name, type, sets, reps, weight));

        workout.put(day,exercises);

        System.out.println("Exercise '" + name + "' added to " + day + ".");
    }


    public void deleteExercise(String day, String name) {

    }

    private DaysOfWeek getDay() {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            try {
                System.out.print("Enter the day of the week (MONDAY, TUESDAY, etc.): ");
                String input = scanner.nextLine().toUpperCase();
                return DaysOfWeek.valueOf(input);
            }catch (IllegalArgumentException e) {
                System.out.println("Invalid date. Please choose from MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, " +
                        "SATURDAY, or SUNDAY.");
            }
        }
    }

    //exceptions
    private ExerciseType getExerciseType() {
        Scanner scanner = new Scanner(System.in);
        while(true) { //while true makes it so program keeps running until user puts valid input
            try {
                System.out.print("Enter exercise type (CARDIO, STRENGTH, FLEXIBILITY): ");
                String input = scanner.nextLine().toUpperCase();
                return ExerciseType.valueOf(input);
            }catch (IllegalArgumentException e) {
                System.out.println("Invalid exercise type. Please choose from CARDIO, STRENGTH, or FLEXIBILITY.");
            }
        }
    }

    private int getIntegerInput(String message) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try{
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number.");
            }
        }
    }

    private double getDoubleInput(String message) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try{
                System.out.print(message);
                return Double.parseDouble(scanner.nextLine());
            }catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a double.");
            }
        }
    }
}

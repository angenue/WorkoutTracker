package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Program {
    private String name;
    private Map<String, List<Exercise>> workout; //key is for workout day

    //add exercise
    //delete exercise

    public void addExercise(String day, String name) {
        ExerciseType type = getExerciseType();

    }

    //add cardio/flexibility exercise
    private void addExercise(String day, String name, ExerciseType type, int duration) {
        List<Exercise> exercises = new ArrayList<>();
    }

    //add strength exercise
    private void addExercise(String day, String name, ExerciseType type, int set, int reps, int weight) {
        List<Exercise> exercises = new ArrayList<>();
    }


    public void deleteExercise(String day, String name) {

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
                System.out.println(message);
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
                System.out.println(message);
                return Double.parseDouble(scanner.nextLine());
            }catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a double.");
            }
        }
    }
}

package org.example;

import java.util.*;

public class Program {
    private String name;
    private Map<DaysOfWeek, List<Exercise>> workout; //key is for workout day

    public boolean addExercise() {
        ExerciseType type = getExerciseType();
        DaysOfWeek day = getDay();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name of exercise: ");
        String name = scanner.nextLine();

        boolean exerciseAdded = switch (type) { //no break statement which means it will go to flexibility
            case CARDIO, FLEXIBILITY -> addCardioExercise(day, name, type);
            case STRENGTH -> addStrengthExercise(day, name, type);
        };

        scanner.close();
        return exerciseAdded;
    }


    //add cardio/flexibility exercise
    private boolean addCardioExercise(DaysOfWeek day, String name, ExerciseType type) {
        int duration = getIntegerInput("Enter duration in seconds");

        List<Exercise> exercises = workout.getOrDefault(day, new ArrayList<>());
        exercises.add(new Exercise(name, type, duration));

        workout.put(day, exercises);

        return true;
    }

    //add strength exercise
    private boolean addStrengthExercise(DaysOfWeek day, String name, ExerciseType type) {
        int sets = getIntegerInput("Number of sets: ");
        int reps = getIntegerInput("Number of reps: ");
        double weight = getDoubleInput("Weight in lbs: ");

        List<Exercise> exercises = workout.getOrDefault(day, new ArrayList<>());
        exercises.add(new Exercise(name, type, sets, reps, weight));

        workout.put(day, exercises);

        return true;
    }



    public boolean deleteExercise(DaysOfWeek day, String name) {
        List<Exercise> exercises = workout.get(day);

        if(!exercises.isEmpty()) {
            Iterator<Exercise> iterator = exercises.iterator();

            while(iterator.hasNext()) { //iterating through exercise list
                Exercise e = iterator.next();

                if(name.equals(e.getName())) {
                    iterator.remove();
                    System.out.println("Exercise '" + name + "' deleted from " + day + ".");
                    return true;
                }
            }
            System.out.println("Exercise '" + name + "' not found on " + day + ".");
        }
        else {
            System.out.println("No exercises found on " + day + ".");
        }

        return false;
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

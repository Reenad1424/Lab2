package org.example;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

//Q1 find all the longest word
       System.out.println("\nQ1 find all of the longest word");
       String[] dictionary = {"cat", "dog", "red", "is", "am"};
        String longest_word = dictionary[0];
        ArrayList<String> final_longest_words = new ArrayList<>();

        for (int i = 1; i < dictionary.length; i++) {
            if (dictionary[i].length() > longest_word.length()) {
                longest_word = dictionary[i];
            }
        }
        for (String word : dictionary) {
            if (word.length() == longest_word.length()) {
                final_longest_words.add(word);
            }
        }
        System.out.println("Longest words: " + final_longest_words);


//Q2 Display the number of occurrences
        System.out.println("\nQ2 Display the number of occurrences");
      
        int[] originalArray = {1, 1, 1, 3, 3, 5};
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the number to check: ");
        int target = input.nextInt(); 
        
        int count = 0;

        for (int i = 0; i < originalArray.length; i++) {
            if (originalArray[i] == target) {
                count++;
            }
        }
        System.out.println(target + " occurs " + count + " " + "time");
    }
}



//Q3 Display the biggest numbers
        System.out.println("\nQ3 Display biggest numbers");
        ArrayList<Integer> numberList = new ArrayList<>();
        numberList.add(1);
        numberList.add(4);
        numberList.add(17);
        numberList.add(7);
        numberList.add(25);
        numberList.add(3);
        numberList.add(100);

        System.out.print("Enter how many biggest numbers: ");
        int k = input.nextInt();
        int originalK = k;
        ArrayList<Integer> final_biggest = new ArrayList<>();

        while (k > 0 && !numberList.isEmpty()) {
            int maxIndex = 0;
            for (int i = 1; i < numberList.size(); i++) {
                if (numberList.get(i) > numberList.get(maxIndex))
                    maxIndex = i;
            }
            final_biggest.add(numberList.remove(maxIndex));
            k--;
        }
        System.out.println("The " + originalK + " the biggest numbers: " + final_biggest);


//Q4 Reversed Array
        System.out.println("\nQ4 Reversed Array");
        int[] originalArray = {5, 4, 3, 2, 1};
        System.out.print("Original Array: ");

        printArray(originalArray);

        reverseArray(originalArray);

        System.out.print("Reversed Array: ");
        printArray(originalArray);

        
//Q5 Display multiple choices
        System.out.println("\nQ4 Display multiple choices");
        System.out.println("Enter the size of array:");
        int size = input.nextInt();
        ArrayList<Integer> array_user = new ArrayList<>();
        boolean stop = false;

        while (!stop) {
            System.out.println("\n--- Menu ---");
            System.out.println("1- Accept elements");
            System.out.println("2- Display elements");
            System.out.println("3- Search element");
            System.out.println("4- Sort array");
            System.out.println("5- Stop");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    if (array_user.size() >= size) {
                        System.out.println("Array is already full!");
                    } else {
                        System.out.println("Enter your elements:");
                        for (int i = array_user.size(); i < size; i++) {
                            array_user.add(input.nextInt());
                        }
                    }
                    break;

                case 2:
                    System.out.println("The array is: " + array_user);
                    break;

                case 3:
                    System.out.print("Enter number to search: ");
                    int search_num = input.nextInt();
                    if (array_user.contains(search_num)) {
                        System.out.println("Found it! At index: " + array_user.indexOf(search_num));
                    } else {
                        System.out.println("Not found.");
                    }
                    break;

                case 4:

                    for (int i = 0; i < array_user.size(); i++) {
                        for (int j = 0; j < array_user.size() - 1; j++) {
                            if (array_user.get(j) > array_user.get(j + 1)) {
                                int temp = array_user.get(j);
                                array_user.set(j, array_user.get(j + 1));
                                array_user.set(j + 1, temp);
                            }
                        }
                    }
                    System.out.println("Array sorted is "+ array_user);
                    break;


                case 5:
                    stop = true;
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }


 //Q6 Display Random number from the rang given
        System.out.println("\nQ6 Display Random number from the rang given");
        System.out.println("Enter the minimum value of rhe range");
        int minimum =input.nextInt();

        System.out.println("Enter the maximum value of rhe range");
        int maximum =input.nextInt();

        System.out.println("Enter the number of random numbers to generate:");
        int count =input.nextInt();

        for (int i = 0; i < count; i++) {
            int result = random_number(minimum, maximum);

            System.out.print(result + (i < count - 1 ? " - " : ""));
        }


//Q7 calculate the score of the password
       System.out.println("\n\nQ7 calculate the score of the password");
        System.out.print("Enter a password: ");
        String password = input.next();

        int totalScore = checkLength(password) + checkSpecialCharacter(password) + checkUpperCaseLowerCase(password);

        if (totalScore >= 8) {
            System.out.println("Password is strong.");
        } else if (totalScore >= 5) {
            System.out.println("Password is moderately strong.");
        } else {
            System.out.println("Password is weak.");
        }


//Q8 Display number Fibonacci terms
        System.out.println("\nQ8 Display number Fibonacci terms  ");
        System.out.print("Enter the number of Fibonacci terms to generate: ");
        int n = input.nextInt();

        System.out.println("\nFibonacci sequence with " + n + " terms:");
        generate_fibonacci(n);

    }

    public static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {

            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num);
        }
        System.out.println();
    }
    public static int random_number(int min , int max){
        Random r = new Random();

        return r.nextInt(max-min+1)+min;
    }
    public static void generate_fibonacci(int terms) {
        int first = 0, second = 1;

        for (int i = 0; i < terms; i++) {
            System.out.print(first + " ");

            int next = first + second;
            first = second;
            second = next;
        }

    }
    public static int checkLength(String pass) {
        if (pass.length() >= 8)
            return 3;
        if (pass.length() >= 6)
            return 2;
        return 0;
    }

    public static int checkSpecialCharacter(String pass){
        for(int i =0 ; i<pass.length(); i++){
            char c =pass.charAt(i);
            if(!Character.isLetterOrDigit(c))
                return 2;}
            return 0;}


    public static int checkUpperCaseLowerCase(String pass) {
        boolean hasUpper = false;
        boolean hasLower = false;

        for (int i = 0; i < pass.length(); i++) {
            char c = pass.charAt(i);
            if (Character.isUpperCase(c))
                hasUpper = true;
            if (Character.isLowerCase(c))
                hasLower = true;
        }

        if (hasUpper && hasLower)
            return 3;
        return 0;
    }
}







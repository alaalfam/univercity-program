package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import java.util.Scanner;

public class Field {
    private String fieldName;
    private String fieldNumber;
    private String fieldPoint;
    private String fieldDate;
    private static ArrayList<Field> fields = new ArrayList<>();

    public Field(String fieldName, String fieldNumber, String fieldPoint, String fieldDate) {
        if (isNameValid(fieldName)) {
            this.fieldName = fieldName;
        }
        if (isNameValid(fieldNumber)) {
            this.fieldNumber = fieldNumber;
        }
        if (isNumberValid(fieldPoint)) {
            this.fieldPoint = fieldPoint;
        }
    }

    private boolean isNumberValid(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) >= '0' && number.charAt(i) <= '9') {
                return true;
            }
        }
        return false;
    }

    private boolean isNameValid(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z') {
                return true;
            }
        }
        return false;
    }

    public static void addToField() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the field name");
        String fieldName = scanner.nextLine();
        System.out.println("Enter the field number");
        String fieldNumber = scanner.nextLine();
        System.out.println("Enter the field point");
        String fieldPoint = scanner.nextLine();
        System.out.println("Enter the field date");
        String fieldDate = scanner.nextLine();
    }

    public static void readField(){

        try {
            File fieldFile = new File("resources/FieldFile.txt");

            BufferedReader br = new BufferedReader(new FileReader(fieldFile));

            String stop = "";
            while ((stop = br.readLine()) != null) {
                String fieldName = br.readLine();
                String fieldNumber = br.readLine();
                String fieldPoint = br.readLine();
                String fieldDate = br.readLine();
                Field field = new Field(fieldName, fieldNumber, fieldPoint, fieldDate);
                fields.add(field);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Field> getFields() {
        return fields;
    }
}
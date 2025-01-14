package com.company;

import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Employee extends Person {
    private String employeeNumber;
    private String entranceYear;
    private static ArrayList<Employee> employees = new ArrayList<>();

    public Employee(String firstName, String lastName, String employeeNumber, String entranceYear) {
        super(firstName, lastName);
        if (isNameValid(employeeNumber)) {
            this.employeeNumber = employeeNumber;
        }
        if (isNumberValid(entranceYear)) {
            this.entranceYear = entranceYear;
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

    public static void readEmployee() {
        try {
            File EmployeeFile = new File("resources/EmployeeFile.txt");

            BufferedReader br = new BufferedReader(new FileReader(EmployeeFile));

            String stop = "";
            while ((stop = br.readLine()) != null) {
                String firstName = br.readLine();
                String lastName = br.readLine();
                String employeeNumber = br.readLine();
                String entranceYear = br.readLine();
                Employee employee = new Employee(firstName, lastName, employeeNumber, entranceYear);
                employees.add(employee);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addToEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Employee First name");
        String firsName = scanner.nextLine();
        System.out.println("Enter Employee Last name");
        String lastName = scanner.nextLine();
        System.out.println("Enter Employee Number");
        String employeeNumber = scanner.nextLine();
        System.out.println("Enter Employee reputation");
        String entranceYear = scanner.nextLine();
        Employee employee = new Employee(firsName, lastName, employeeNumber, entranceYear);
        employees.add(employee);
        writeEmployee(firsName, lastName, employeeNumber, entranceYear);
    }


    public static void writeEmployee(String firstName, String lastName, String employeeNumber, String entranceYear) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("resources/EmployeeFile.txt", true));
            Random random = new Random();
            String n= String.valueOf(random.nextInt(300));
            bw.append(n);
            bw.newLine();
            bw.append(firstName);
            bw.newLine();
            bw.append(lastName);
            bw.newLine();
            bw.append(employeeNumber);
            bw.newLine();
            bw.append(entranceYear);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Employee> getEmployees() {
        return employees;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public String getEntranceYear() {
        return entranceYear;
    }
}


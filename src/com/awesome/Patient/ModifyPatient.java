package com.awesome.Patient;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ModifyPatient {

    private static Scanner scan = new Scanner(System.in);
    public static void modifyPatient(ArrayList<Patient>allpatients){
        Patient patient = findPatientIn(allpatients);
        int age = readBirthyear();
        int phoneNumber = readPhoneNumber();
        System.out.println("Please enter address of Patient");
        String address = scan.nextLine();
        // creat a new patient and update it to the user
        allpatients.set(allpatients.indexOf(patient), new Patient(patient.getFirstName(),patient.getLastName(), address, age, phoneNumber, patient.getSex()));
    }

    private static int readPhoneNumber(){
        int phoneNumber = -1;
        while(phoneNumber == -1){
            try{
                System.out.println("Enter patient phone number(can not start with 0): ");
                phoneNumber = scan.nextInt();
            } catch (InputMismatchException e){
                System.out.println("Please enter a valid phone number. \nCan not start with 0");
                scan.nextLine();

            }
        } return phoneNumber;
    }

    private static int readBirthyear(){
        int age = 0;
        while(age == 0){
            try{
                System.out.println("Enter age of Patient");
                age = scan.nextInt();
                scan.nextLine();
            } catch (InputMismatchException e){
                System.out.println("This is not a valid age, please enter an integer");
                scan.nextLine();
            }
        } return age;
    }

    private static Patient findPatientIn(ArrayList<Patient>allPatients){
        Patient patient = new Patient();
        String name = "";
        while(name.isEmpty()){
            System.out.println("Enter last name of patient: ");
            name = scan.nextLine();
            for(Patient userElement : allPatients){
                if(userElement.getFirstName().equals(name)){
                    return userElement;
                }
            }
            name = "";

        }
        return patient;
    }

    public static void removePatient(ArrayList<Patient>allPatients){
        allPatients.remove(findPatientIn(allPatients));
    }

    public static void main(String[] args) {

        //Finds the name WORKS
        ArrayList<Patient> testPatientList = new ArrayList<>();
        Patient patient = new Patient();
        testPatientList.add(patient);

        patient = findPatientIn(testPatientList);
        System.out.println(patient.getLastName());
    }
}

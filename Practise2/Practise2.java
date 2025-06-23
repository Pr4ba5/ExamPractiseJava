package Practise2;

import java.util.HashMap;
import java.util.Scanner;

public class Practise2 {

    static class InvalidEmailException extends Exception{
        public InvalidEmailException(String message1){
            super(message1);
        }
    }

    static class WrongCredentialsException extends Exception{
        public WrongCredentialsException(String message){
            super(message);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("---------------- WELCOME TO XYZ MAIL SERVICE ------------");
        HashMap<String, String> emails = new HashMap<>();
        emails.put("prabas@gmail.com", "prabas123");
        emails.put("prasanna@gmail.com", "prabas123");
        emails.put("angel@gmail.com", "prabas123");

        System.out.print("Enter email: ");
        String email = sc.nextLine();

        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        try{
            if(!emails.containsKey(email)){
                throw new InvalidEmailException("Sorry you're not valid.");
            }
            String storedPassword = emails.get(email);

            if (!storedPassword.equals(password)) {
                throw new WrongCredentialsException("Sorry password donot match!");
            }

            System.out.println("Logged in successfully!");

        }catch(InvalidEmailException | WrongCredentialsException er){
            System.err.println(er.getMessage());
        }
        
    }
}

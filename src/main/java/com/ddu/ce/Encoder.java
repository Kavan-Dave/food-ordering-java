package com.ddu.ce;

//import java.util.Scanner;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encoder {

    public static void main(String[] args) {
       // Scanner sc = new Scanner(System.in);
    	
    	// Create a BCryptPasswordEncoder instance
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        // Raw password to be encrypted
        //String rawPassword = "admin";
        String rawPassword = "ron123";

        // Encrypt the password
        String encryptedPassword = encoder.encode(rawPassword);

        // Print the encrypted password
        System.out.println("Encrypted Password: " + encryptedPassword);
    }
}
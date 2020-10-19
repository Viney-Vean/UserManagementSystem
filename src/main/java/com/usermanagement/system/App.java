package com.usermanagement.system;

import com.usermanagement.system.core.InternetConnection;
import com.usermanagement.system.user.UserUI;

import java.util.Scanner;

public class App {

    public static void welcome() {
        System.out.println("============================================");
        System.out.println("===== Welcome to User Management System ====");
        System.out.println("============================================");
    }

    public static void main(String[] args) {
        InternetConnection internetConnection = new InternetConnection();
        boolean isInternetReachable = false;
        UserUI userUI = new UserUI();
        welcome();

        do{
            isInternetReachable = internetConnection.isInternetReachable();

            if(!isInternetReachable){
                Scanner scanner = new Scanner(System.in);
                System.out.print("\nPlease make sure you have connect to internet.");
                System.out.print("\nDid your device has connect to internet? (Yes/No)  > ");
                String press = scanner.nextLine().toUpperCase();
                press.replaceAll("\\s", "");
            }
        }while (!isInternetReachable);

        userUI.openMenuUser();
    }


}

package com.usermanagement.system;

import com.usermanagement.system.user.UserUI;

public class App {

    public static void welcome() {
        System.out.println("============================================");
        System.out.println("===== Welcome to User Management System ====");
        System.out.println("============================================");
    }

    public static void main(String[] args) {
        UserUI userUI = new UserUI();
        welcome();
        userUI.openMenuUser();
    }


}

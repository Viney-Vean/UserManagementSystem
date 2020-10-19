package com.usermanagement.system.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.usermanagement.system.core.CommandLineTable;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.usermanagement.system.core.NumberValidation;
import lombok.Data;

@Data
public class UserUI {

    String[] tableHeader = {"ID", "LongIn name", "Type"};
    String[] tableHeaderDetail = {"ID", "  LongIn name", "Link to user's profile", "Number of repos",
            "Number of followers", "Number of following"};

    String[] menuItem = {"Home", "First", "Previous", "Next", "Detail", "Help", "Exit"};
    String[] shortCut = new String[]{"*", "F", "P", "N", "D", "H", "E"};
    String githubUrl = "https://api.github.com/users";

    Integer startSince = 0;
    Integer endSince = 20;
    Integer perPage = 20;
    List<Integer> sinceList = new ArrayList<>();

    public UserUI() {
    }

    public String getGithubUrl() {
        return githubUrl + "?since=" + this.getStartSince() + "&per_page=" + this.perPage;
    }

    public List<User> readJsonUsersFromUrl(String stringUrl) {
        List<User> userList = new ArrayList<>();

        try {
            ObjectMapper mapper = new ObjectMapper();
            userList = Arrays.asList(mapper.readValue(new URL(stringUrl), User[].class));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return userList;
    }

    public User readJsonUserDetailFromUrl(String stringUrl) {
        User user = new User();

        try {
            ObjectMapper mapper = new ObjectMapper();
            user = mapper.readValue(new URL(stringUrl), User.class);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return user;
    }

    private void displayDefault() {
        try {
            List<User> user = this.readJsonUsersFromUrl(this.getGithubUrl());

            CommandLineTable commandLineTable = new CommandLineTable();
            commandLineTable.setShowVerticalLines(true);
            commandLineTable.setHeaders(this.tableHeader);

            for (User u : user) {
                if (user.indexOf(u) == 0) {
                    this.startSince = u.getId();
                } else if (user.indexOf(u) == user.size() - 1) {
                    this.endSince = u.getId();
                }
                commandLineTable.addRow(Integer.toString(u.getId()), u.getLogin(), u.getType());
            }

            commandLineTable.print();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showHelp() {
        System.out.println("\n\n==================== Welcome to Help Center ====================\n");
        System.out.println("I. Shortcut key");
        String helpText = "\t1. Go to Home Page, you have to choice option: *\n" +
                "\t2. Go to First Page, you have to choice option: F\n" +
                "\t3. Go to Previous Page, you have to choice option: P\n" +
                "\t4. Go to Next Page, you have to choice option: N\n" +
                "\t5. Go to First Page, you have to choice option: D\n" +
                "\t6. Go to Help Page, you have to choice option: H\n" +
                "\t7. To exit from program, you have to choice option: E\n";

        System.out.println(helpText);

    }

    private void displayMenuItem() {

        System.out.println("\n\n**************************** Please choice option below ****************************\n");

        CommandLineTable commandLineTable = new CommandLineTable();
        commandLineTable.setShowVerticalLines(true);
        commandLineTable.setHeaders(menuItem);
        commandLineTable.addRow(shortCut);
        commandLineTable.print();
    }

    private void displayUserDetail() {
        boolean exitUserDetail = true;
        NumberValidation numberValidation = new NumberValidation();

        do {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nPlease enter user's id > ");
            String pressKey = scanner.nextLine().toUpperCase();
            pressKey.replaceAll("\\s", "");

            if (pressKey.equalsIgnoreCase("E")) {
                exitUserDetail = false;

            } else if (numberValidation.isInteger(pressKey)) {
                String userDetailUrl = this.githubUrl + "/" + pressKey;
                User user = this.readJsonUserDetailFromUrl(userDetailUrl);

                String detailText = "\n\nLongIn name: " + user.login + "\n" +
                        "Link to user's profile: " + user.avatarURL + "\n" +
                        "Number of repos: " + user.publicRepos + "\n" +
                        "Number of followers: " + user.followers + "\n" +
                        "Number of following: " + user.following + "\n";

                System.out.println(detailText);

        }else{
            System.out.printf("\"%s\" is not a valid number. ", pressKey);

        }

    } while(exitUserDetail);
}

    public void openMenuUser() {
        this.displayDefault();
        this.displayMenuItem();
        boolean exitMenu = true;
        List<String> shortCutList = Arrays.asList(this.shortCut);

        do {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nOption > ");
            String press = scanner.nextLine().toUpperCase();
            press.replaceAll("\\s", "");

            if (shortCutList.contains(press)) {

                switch (press) {
                    case "*":
                    case "F":
                        sinceList = new ArrayList<>();
                        this.setStartSince(0);
                        this.displayDefault();
                        this.sinceList.add(this.endSince);
                        break;

                    case "P":
                        if (this.sinceList.size() > 1) {
                            this.sinceList.remove(this.sinceList.get(this.sinceList.size() - 1));
                            this.setStartSince(this.sinceList.get(this.sinceList.size() - 1));

                        } else {
                            this.setStartSince(0);
                        }

                        this.displayDefault();
                        break;

                    case "N":
                        this.startSince = this.endSince;
                        this.sinceList.add(this.endSince);
                        this.displayDefault();
                        break;

                    case "D":
                        this.displayUserDetail();
                        break;

                    case "H":
                        this.showHelp();
                        break;

                    case "E":
                        exitMenu = false;
                        break;

                }

            } else {
                System.out.println("Invalid choice! Please try again.");
            }

        } while (exitMenu);

    }

}

package com.gojavaonline3.dlenchuk.module09;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

import static com.gojavaonline3.dlenchuk.module09.TestString.Commands.EXIT_COMMAND_STRING;
import static com.gojavaonline3.dlenchuk.module09.TestString.Commands.EXIT_SHORT_COMMAND_STRING;

public class TestString {

    enum Commands{
        PALINDROME_COMMAND_STRING(":1", " - for the testing of a palindrome", "Please, enter a string for palindrome: "),
        SPLIT_COMMAND_STRING(":2", " - for the testing of a split", "Please, enter a string for split: "),
        EXIT_COMMAND_STRING(":exit", " - for exit."),
        EXIT_SHORT_COMMAND_STRING(":!", " - for exit.");

        private String commandString;
        private String titleString;
        private String invitationString;

        Commands(String commandString, String titleString) {
            this.commandString = commandString;
            this.titleString = titleString;
        }
        Commands(String commandString, String titleString, String invitationString) {
            this(commandString, titleString);
            this.invitationString = invitationString;
        }

        public String getCommandString() {
            return commandString;
        }

        public String getTitleString() {
            return titleString;
        }

        public String getInvitationString() {
            return invitationString;
        }

        public static Commands command(String commandString) {
            Optional<Commands> optional = Arrays
                    .stream(Commands.values())
                    .filter(command -> command.getCommandString().equals(commandString))
                    .findFirst();
            return optional.isPresent() ? optional.get() : null;
        }

    }

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        while (true) {

            for (int i = 0; i < 100; i++) {
                System.out.println('\b');
            }

            System.out.println("Tape ('" + Commands.values()[0].commandString + "' is default): ");
            for (Commands command : Commands.values()) {
                System.out.println('\'' + command.getCommandString() + '\'' + command.getTitleString());
            }

            String commandString = scanner.next();
            if (commandString.equals("")) {
                commandString = Commands.values()[0].commandString;
            }


            Commands command = Commands.command(commandString);

            if (command == null) {
                System.out.println('\'' + commandString + "\' is not applicable");
                System.out.println("Tape any key and press enter.");
                scanner.next();
                continue;
            }

            if (command == EXIT_COMMAND_STRING || command == EXIT_SHORT_COMMAND_STRING)
                break;

            System.out.print(command.getInvitationString());
            scanner.nextLine();
            String userString = scanner.nextLine();

            switch (command) {
                case PALINDROME_COMMAND_STRING:
                    palindrome(userString);
                    break;
                case SPLIT_COMMAND_STRING:
                    split(userString);
                    break;
                default:
                    palindrome(userString);
            }
            System.out.println("Tape any key and press enter.");
            scanner.next();
        }
    }

    private static void split(String userString) {

        while (true) {
            System.out.println("Enter the char of a splitter");
            String splitter = scanner.nextLine();
            if (splitter.length() > 1) {
                System.out.println("Was entered more then one character");
                continue;
            }
            String[] splitArray = userString.split(splitter);
            int[] intArray = new int[splitArray.length];
            for (int i = 0; i < splitArray.length; i++) {
                intArray[i] = Integer.valueOf(splitArray[i].trim());
            }
            System.out.println(Arrays.toString(splitArray).replace("[", "").replace("]", ""));
            break;
        }
    }

    private static void palindrome(String userString) {
        char[] chars = userString.toCharArray();
        boolean isPalindrome = true;

        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - (i + 1)]) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println(isPalindrome ? "Palindrome" : "Not Palindrome");
    }
}

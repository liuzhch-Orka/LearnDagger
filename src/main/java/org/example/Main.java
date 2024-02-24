package org.example;

import org.example.command.Command.Result;
import org.example.command.CommandRouter;

import java.util.Scanner;

class CommandLineAtm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CommandRouter commandRouter = new CommandRouter();

        while (scanner.hasNextLine()) {
            Result unused = commandRouter.route(scanner.nextLine());
        }
    }
}
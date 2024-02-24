package org.example;

import org.example.command.Command.Result;
import org.example.command.CommandRouter;
import org.example.command.CommandRouterFactory;
import org.example.command.DaggerCommandRouterFactory;

import java.util.Scanner;

class CommandLineAtm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CommandRouterFactory commandRouterFactory = DaggerCommandRouterFactory.create();
        CommandRouter commandRouter = commandRouterFactory.router();

        while (scanner.hasNextLine()) {
            Result unused = commandRouter.route(scanner.nextLine());
        }
    }
}
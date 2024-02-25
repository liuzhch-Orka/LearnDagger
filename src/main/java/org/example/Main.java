package org.example;

import org.example.command.Command.Status;
import org.example.command.CommandProcessor;
import org.example.command.CommandProcessorFactory;
import org.example.command.DaggerCommandProcessorFactory;

import java.util.Scanner;

class CommandLineAtm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CommandProcessorFactory commandRouterFactory = DaggerCommandProcessorFactory.create();
        CommandProcessor commandProcessor = commandRouterFactory.commandProcessor();

        while (scanner.hasNextLine()) {
            Status unused = commandProcessor.process(scanner.nextLine());
        }
    }
}
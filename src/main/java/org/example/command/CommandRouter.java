package org.example.command;

import java.util.*;

import org.example.command.Command.Result;
import org.example.command.Command.Status;

import javax.inject.Inject;

final public class CommandRouter {
    private final Map<String, Command> commands = new HashMap<>();

    @Inject
    CommandRouter(Command command) {
        commands.put(command.key(), command);
    }

    public Result route(String input) {
        List<String> splitInput = split(input);
        if (splitInput.isEmpty()) {
            return invalidCommand(input);
        }

        String commandKey = splitInput.getFirst();
        Command command = commands.get(commandKey);
        if (command == null) {
            return invalidCommand(commandKey);
        }

        List<String> args = splitInput.subList(1, splitInput.size());
        Result result = command.handleInput(args);
        return result.status().equals(Status.INVALID) ? invalidCommand(commandKey) : result;
    }

    private Result invalidCommand(String input) {
        System.out.printf("invalid cmd: %s%n", input);
        return Result.invalid();
    }

    private static List<String> split(String input) {
        return Arrays.asList(input.trim().split(" "));
    }
}

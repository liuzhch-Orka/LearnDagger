package org.example.command;

import java.util.Arrays;
import java.util.Collections;

import org.example.command.Command.Result;
import org.example.command.Command.Status;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

final public class CommandRouter {
    private final Map<String, Command> commands = Collections.emptyMap();

    @Inject
    CommandRouter() {
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

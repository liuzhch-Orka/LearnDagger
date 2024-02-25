package org.example.command;

import org.example.outputter.Outputter;

import javax.inject.Inject;
import java.util.List;

final public class HelloWorldCommand implements Command {
    private final Outputter outputter;

    @Inject
    HelloWorldCommand(Outputter outputter) {
        this.outputter = outputter;
    }

    @Override
    public Result handleInput(List<String> input) {
        if (!input.isEmpty()) {
            return Result.invalid();
        }
        outputter.output("world!");
        return Result.handled();
    }
}

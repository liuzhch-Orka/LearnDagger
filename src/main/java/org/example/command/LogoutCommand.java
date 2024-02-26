package org.example.command;

import org.example.outputter.Outputter;

import javax.inject.Inject;
import java.util.List;

public final class LogoutCommand implements Command {
    private final Outputter outputter;

    @Inject
    public LogoutCommand(Outputter outputter) {
        this.outputter = outputter;
    }

    public Result handleInput(List<String> input) {
        if (!input.isEmpty()) {
            return Result.invalid();
        }
        outputter.output("Logout successfully");
        return Result.inputCompleted();
    }
}

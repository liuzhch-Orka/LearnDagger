package org.example.command;

import javax.inject.Inject;
import java.util.List;

public final class LogoutCommand implements Command {
    @Inject
    public LogoutCommand() {
    }

    public Result handleInput(List<String> input) {
        if (!input.isEmpty()) {
            return Result.invalid();
        }
        System.out.println("Logout successfully");
        return Result.inputCompleted();
    }
}

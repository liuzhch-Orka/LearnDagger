package org.example.command;

import org.example.outputter.Outputter;

import javax.inject.Inject;

public final class LoginCommand extends SingleArgCommand {
    private final Outputter outputter;

    @Inject
    LoginCommand(Outputter outputter) {
        this.outputter = outputter;
    }


    @Override
    public Result handleArg(String username) {
        outputter.output(username + " is logged in.");
        return Result.handled();
    }
}

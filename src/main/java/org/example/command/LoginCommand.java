package org.example.command;

import org.example.Database;
import org.example.Database.Account;
import org.example.outputter.Outputter;

import javax.inject.Inject;

public final class LoginCommand extends SingleArgCommand {
    private final Database database;
    private final Outputter outputter;

    @Inject
    LoginCommand(Database database, Outputter outputter) {
        this.database = database;
        this.outputter = outputter;
    }


    @Override
    public Result handleArg(String username) {
        Account account = database.getAccount(username);
        outputter.output(username + " is logged in. Balance: " + account.balance());
        return Result.handled();
    }
}

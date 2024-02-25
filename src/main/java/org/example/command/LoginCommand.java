package org.example.command;

import org.example.Database;
import org.example.Database.Account;
import org.example.command.usercommand.UserCommandRouter;
import org.example.outputter.Outputter;

import javax.inject.Inject;

public final class LoginCommand extends SingleArgCommand {
    private final Database database;
    private final Outputter outputter;
    private final UserCommandRouter.Factory userCommandsRouterFactory;

    @Inject
    LoginCommand(Database database, Outputter outputter, UserCommandRouter.Factory userCommandsRouterFactory) {
        this.database = database;
        this.outputter = outputter;
        this.userCommandsRouterFactory = userCommandsRouterFactory;
    }

    @Override
    public Result handleArg(String username) {
        Account account = database.getAccount(username);
        outputter.output(username + " is logged in. Balance: " + account.balance());
        return Result.enterNestedCommandSet(userCommandsRouterFactory.create(account).router());
    }
}

package org.example.command;

import org.example.Database;
import org.example.Database.Account;
import org.example.command.usercommand.UserCommandRouter;
import org.example.outputter.Outputter;

import javax.inject.Inject;
import java.util.Optional;

public final class LoginCommand extends SingleArgCommand {
    private final Database database;
    private final Outputter outputter;
    private final UserCommandRouter.Factory userCommandsRouterFactory;
    private final Optional<Account> account;

    @Inject
    LoginCommand(
            Database database,
            Outputter outputter,
            UserCommandRouter.Factory userCommandsRouterFactory,
            Optional<Account> account) {
        this.database = database;
        this.outputter = outputter;
        this.userCommandsRouterFactory = userCommandsRouterFactory;
        this.account = account;
    }

    @Override
    public Result handleArg(String username) {
        if (account.isPresent()) {
            outputter.output(account.get().username() + " is logged in. Logout before another login.");
            return Result.handled();
        }
        Account account = database.getAccount(username);
        outputter.output(username + " is logged in. Balance: " + account.balance());
        return Result.enterNestedCommandSet(userCommandsRouterFactory.create(account).router());
    }
}

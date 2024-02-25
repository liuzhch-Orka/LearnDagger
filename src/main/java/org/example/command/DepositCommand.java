package org.example.command;

import org.example.Database.Account;
import org.example.outputter.Outputter;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.List;

public final class DepositCommand implements Command {
    private final Account account;
    private final Outputter outputter;

    @Inject
    DepositCommand(Account account, Outputter outputter) {
        this.account = account;
        this.outputter = outputter;
    }

    @Override
    public Result handleInput(List<String> input) {
        if (input.size() != 2) {
            return Result.invalid();
        }

        account.deposit(new BigDecimal(input.get(1)));
        outputter.output(account.username() + " now has: " + account.balance());
        return Result.handled();
    }
}

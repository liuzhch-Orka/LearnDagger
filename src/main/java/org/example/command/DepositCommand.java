package org.example.command;

import org.example.Database.Account;
import org.example.outputter.Outputter;

import javax.inject.Inject;
import java.math.BigDecimal;

public final class DepositCommand extends BigDecimalCommand {
    private final Account account;
    private final Outputter outputter;
    private final WithdrawalLimiter withdrawalLimiter;

    @Inject
    DepositCommand(Account account, Outputter outputter, WithdrawalLimiter withdrawalLimiter) {
        super(outputter);
        this.account = account;
        this.outputter = outputter;
        this.withdrawalLimiter = withdrawalLimiter;
    }

    @Override
    protected void handleAmount(BigDecimal amount) {
        account.deposit(amount);
        withdrawalLimiter.recordDeposit(amount);
        outputter.output(account.username() + " now has: " + account.balance());
    }
}

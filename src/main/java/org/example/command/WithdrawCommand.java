package org.example.command;

import org.example.Database.Account;
import org.example.outputter.Outputter;

import javax.inject.Inject;
import java.math.BigDecimal;

final public class WithdrawCommand extends BigDecimalCommand {
    private Account account;
    private BigDecimal minimumBalance;
    private BigDecimal maximumWithdrawal;


    @Inject
    WithdrawCommand(
            Outputter outputter,
            Account account,
            @MinimumBalance BigDecimal minimumBalance,
            @MaximumWithdrawal BigDecimal maximumWithdrawal) {
        super(outputter);
        this.account = account;
        this.minimumBalance = minimumBalance;
        this.maximumWithdrawal = maximumWithdrawal;
    }

    @Override
    protected void handleAmount(BigDecimal amount) {
        if (amount.compareTo(maximumWithdrawal) > 0) {
            outputter.output("amount must be less than " + maximumWithdrawal);
            return;
        }

        BigDecimal newBalance = account.balance().subtract(amount);
        if (newBalance.compareTo(minimumBalance) < 0) {
            outputter.output("balance not enough");
        } else {
            account.withdraw(amount);
            outputter.output("new balance is: " + account.balance());
        }
    }
}

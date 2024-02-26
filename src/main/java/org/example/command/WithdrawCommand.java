package org.example.command;

import org.example.Database.Account;
import org.example.outputter.Outputter;

import javax.inject.Inject;
import java.math.BigDecimal;

final public class WithdrawCommand extends BigDecimalCommand {
    private Account account;
    private BigDecimal minimumBalance;
    private BigDecimal maximumWithdrawal;
    private WithdrawalLimiter withdrawalLimiter;


    @Inject
    WithdrawCommand(
            Outputter outputter,
            Account account,
            @MinimumBalance BigDecimal minimumBalance,
            @MaximumWithdrawal BigDecimal maximumWithdrawal,
            WithdrawalLimiter withdrawalLimiter) {
        super(outputter);
        this.account = account;
        this.minimumBalance = minimumBalance;
        this.maximumWithdrawal = maximumWithdrawal;
        this.withdrawalLimiter = withdrawalLimiter;
    }

    @Override
    protected void handleAmount(BigDecimal amount) {
        BigDecimal remainingWithdrawalLimit = withdrawalLimiter.remainingWithdrawalLimit();
        if (amount.compareTo(remainingWithdrawalLimit) > 0) {
            outputter.output("Withdrawal amount must be less than " + remainingWithdrawalLimit + " in this session.");
            return;
        }

        BigDecimal newBalance = account.balance().subtract(amount);
        if (newBalance.compareTo(minimumBalance) < 0) {
            outputter.output("balance not enough");
        } else {
            account.withdraw(amount);
            withdrawalLimiter.recordWithdrawal(amount);
            outputter.output("new balance is: " + account.balance());
        }
    }
}

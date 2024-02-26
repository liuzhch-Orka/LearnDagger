package org.example.command;

import javax.inject.Inject;
import java.math.BigDecimal;

@PerSession
public final class WithdrawalLimiter {
    private BigDecimal remainingWithdrawalLimit;

    @Inject
    WithdrawalLimiter(@MaximumWithdrawal BigDecimal maximumWithdrawal) {
        this.remainingWithdrawalLimit = maximumWithdrawal;
    }

    public BigDecimal remainingWithdrawalLimit() {
        return remainingWithdrawalLimit;
    }

    void recordDeposit(BigDecimal amount) {
        this.remainingWithdrawalLimit = this.remainingWithdrawalLimit.add(amount);
    }

    void recordWithdrawal(BigDecimal amount) {
        this.remainingWithdrawalLimit = this.remainingWithdrawalLimit.subtract(amount);
    }
}

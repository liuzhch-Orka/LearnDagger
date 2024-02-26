package org.example.command;

import org.example.outputter.Outputter;

import java.math.BigDecimal;

public abstract class BigDecimalCommand extends SingleArgCommand {
    protected final Outputter outputter;

    protected BigDecimalCommand(Outputter outputter) {
        this.outputter = outputter;
    }

    @Override
    protected Result handleArg(String arg) {
        BigDecimal amount = tryParse(arg);
        if (amount == null) {
            outputter.output(arg + " is not a valid number.");
        } else if (amount.signum() <= 0) {
            outputter.output("amount must be positive.");
        } else {
            handleAmount(amount);
        }
        return Result.handled();
    }

    private static BigDecimal tryParse(String number) {
        try {
            return new BigDecimal(number);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    protected abstract void handleAmount(BigDecimal amount);
}

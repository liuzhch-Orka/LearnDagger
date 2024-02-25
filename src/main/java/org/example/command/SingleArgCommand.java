package org.example.command;

import java.util.List;

public abstract class SingleArgCommand implements Command {
    @Override
    public final Result handleInput(List<String> input) {
        return input.size() == 1 ? handleArg(input.getFirst()) : Result.invalid();
    }

    protected abstract Result handleArg(String arg);
}

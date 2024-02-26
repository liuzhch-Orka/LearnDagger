package org.example.command.usercommand;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;
import org.example.command.Command;
import org.example.command.DepositCommand;
import org.example.command.WithdrawCommand;

@Module
abstract public class UserCommandModule {
    @Binds
    @IntoMap
    @StringKey("deposit")
    abstract Command depositCommand(DepositCommand command);

    @Binds
    @IntoMap
    @StringKey("withdraw")
    abstract Command withdrawCommand(WithdrawCommand command);
}

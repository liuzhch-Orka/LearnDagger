package org.example.command.usercommand;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;
import org.example.command.Command;
import org.example.command.DepositCommand;

@Module
abstract public class UserCommandModule {
    @Binds
    @IntoMap
    @StringKey("deposit")
    abstract Command depositCommand(DepositCommand command);
}

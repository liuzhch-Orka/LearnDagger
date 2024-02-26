package org.example.command;

import dagger.Binds;
import dagger.BindsOptionalOf;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;
import org.example.Database.Account;

@Module
public abstract class LoginCommandModule {
    @Binds
    @IntoMap
    @StringKey("login")
    abstract Command loginCommand(LoginCommand loginCommand);

    @BindsOptionalOf
    abstract Account optionalAccount();
}

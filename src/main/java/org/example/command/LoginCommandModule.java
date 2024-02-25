package org.example.command;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class LoginCommandModule {
    @Binds
    abstract Command loginCommand(LoginCommand loginCommand);
}

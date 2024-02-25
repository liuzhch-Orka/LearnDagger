package org.example.command.usercommand;

import dagger.BindsInstance;
import dagger.Module;
import dagger.Subcomponent;
import org.example.Database.Account;
import org.example.command.CommandRouter;

@Subcomponent(modules = UserCommandModule.class)
public interface UserCommandRouter {
    CommandRouter router();

    @Subcomponent.Factory
    interface Factory {
        UserCommandRouter create(@BindsInstance Account account);
    }

    @Module(subcomponents = UserCommandRouter.class)
    interface InstallationModule {
    }
}

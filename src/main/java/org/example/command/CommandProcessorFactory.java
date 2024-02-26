package org.example.command;

import dagger.Component;
import org.example.command.usercommand.UserCommandRouter;
import org.example.outputter.SystemOutModule;

import javax.inject.Singleton;

@Singleton
@Component(modules = {
        LoginCommandModule.class,
        HelloWorldModule.class,
        SystemOutModule.class,
        UserCommandRouter.InstallationModule.class,
        AmountsModule.class,
})
public interface CommandProcessorFactory {
    CommandProcessor commandProcessor();
}

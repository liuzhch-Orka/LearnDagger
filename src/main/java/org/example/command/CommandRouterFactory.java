package org.example.command;

import dagger.Component;
import org.example.outputter.SystemOutModule;

import javax.inject.Singleton;

@Singleton
@Component(modules = {LoginCommandModule.class, HelloWorldModule.class, UserCommandModule.class, SystemOutModule.class,})
public interface CommandRouterFactory {
    CommandRouter router();
}

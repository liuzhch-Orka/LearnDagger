package org.example.command;

import dagger.Component;
import org.example.outputter.SystemOutModule;

@Component(modules = {LoginCommandModule.class, HelloWorldModule.class, SystemOutModule.class,})
public interface CommandRouterFactory {
    CommandRouter router();
}

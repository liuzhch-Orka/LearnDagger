package org.example.command;

import dagger.Component;

@Component(modules = HelloWorldModule.class)
public interface CommandRouterFactory {
    CommandRouter router();
}

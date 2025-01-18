package vr.projects.sunnycompass.berrytracker.core.cqrs;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class CommandDispatcher {

    private final Map<Class<? extends Command>, CommandHandler<? extends Command, ?>> handlerRegistry;

    public CommandDispatcher(final List<CommandHandler<? extends Command, ?>> handlers) {
        this.handlerRegistry = handlers.stream().collect(Collectors.toConcurrentMap(CommandHandler::getType, h -> h));
    }

    @SuppressWarnings("unchecked")
    public <C extends Command, R> R dispatch(final C command) {
        final CommandHandler<C, R> handler = (CommandHandler<C, R>) this.handlerRegistry.get(command.getClass());
        if (handler == null) {
            throw new IllegalArgumentException(
                    "No handler found for command: " + command.getClass().getSimpleName());
        }
        return handler.handle(command);
    }
}

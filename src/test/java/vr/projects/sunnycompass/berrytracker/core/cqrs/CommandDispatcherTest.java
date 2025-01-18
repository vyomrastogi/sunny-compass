package vr.projects.sunnycompass.berrytracker.core.cqrs;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CommandDispatcherTest {

    @Test
    void testDipatchInvokesCorrectHandler() {
        final var dispatcher = new CommandDispatcher(List.of(new SimpleHandler()));
        final var result = dispatcher.dispatch(new SimpleCommand());
        Assertions.assertThat(result).isNotNull().isEqualTo("Success");
    }

    @Test
    void testDipatchInvokesThowsExceptionWhenNoHandlerFound() {
        final var dispatcher = new CommandDispatcher(List.of(new SimpleHandler()));
        try {
            dispatcher.dispatch(new DummyCommand());
        } catch (final Exception e) {
            Assertions.assertThat(e)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("No handler found for command: DummyCommand");
        }
    }
}

class SimpleHandler implements CommandHandler<SimpleCommand, String> {

    @Override
    public String handle(final SimpleCommand Command) {
        return "Success";
    }

    @Override
    public Class<? extends Command> getType() {
        return SimpleCommand.class;
    }
}

record SimpleCommand() implements Command {}

record DummyCommand() implements Command {}

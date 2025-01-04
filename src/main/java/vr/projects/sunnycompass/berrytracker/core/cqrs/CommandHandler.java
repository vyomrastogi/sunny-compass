package vr.projects.sunnycompass.berrytracker.core.cqrs;

public interface CommandHandler<C extends Command, R> {
    R handle(C Command);

    Class<? extends Command> getType();
}

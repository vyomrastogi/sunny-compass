package vr.projects.sunnycompass.berrytracker.core.cqrs;

public interface CommandHandler<C extends Command, R> {
    R handle(C command);

    Class<? extends Command> getType();
}

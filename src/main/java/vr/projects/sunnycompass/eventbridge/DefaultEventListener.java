package vr.projects.sunnycompass.eventbridge;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DefaultEventListener {

    @EventListener
    public void onEvent(final SunnyCompassEvents event) {
        log.info(
                "Handling custom event. event={}, createdAt={}, payload={}",
                event.eventName(),
                event.createdAt(),
                event.payload().toString());
    }
}

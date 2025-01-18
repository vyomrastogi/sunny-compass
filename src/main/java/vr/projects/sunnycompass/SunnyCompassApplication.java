package vr.projects.sunnycompass;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Theme(variant = Lumo.DARK)
@SpringBootApplication
public class SunnyCompassApplication implements AppShellConfigurator {

    public static void main(final String[] args) {
        SpringApplication.run(SunnyCompassApplication.class, args);
    }
}

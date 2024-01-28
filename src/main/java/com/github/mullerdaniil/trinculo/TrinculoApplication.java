package com.github.mullerdaniil.trinculo;

import com.github.mullerdaniil.trinculo.ui.AppPanel;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class TrinculoApplication {
    public static void main(String[] args) {
        var ctx = new SpringApplicationBuilder(TrinculoApplication.class)
                .headless(false)
                .run(args);

        var app = ctx.getBean(AppPanel.class);
        app.run();
    }
}

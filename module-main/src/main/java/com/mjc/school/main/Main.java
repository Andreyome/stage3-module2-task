package com.mjc.school.main;

import com.mjc.school.controller.ControllerCommands;
import com.mjc.school.controller.impl.NewsController;
import com.mjc.school.main.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ControllerCommands commands = context.getBean(ControllerCommands.class);

        while (true) {
            commands.printMenu();
            commands.execute();
        }
    }
}

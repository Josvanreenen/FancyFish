package nl.hu.bep.example.listeners;

import nl.hu.bep.example.domain.FancyFishManager;
import nl.hu.bep.example.security.SecurityManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Server started");
        FancyFishManager.getInstance().addGreeting("Hello World");
        SecurityManager.getInstance().addUser("Jos", "Josvanreenen", "supersecret", "admin");
        System.out.println("Greetings initialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Shutdown received");
    }
}

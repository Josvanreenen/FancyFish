package nl.hu.bep.example.listeners;

import nl.hu.bep.example.domain.Greeting;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Server started");
        Greeting.addGreeting("Hello World");
        System.out.println("Greetings initialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Shutdown received");
    }
}

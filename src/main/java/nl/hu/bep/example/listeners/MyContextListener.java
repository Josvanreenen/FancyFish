package nl.hu.bep.example.listeners;

import nl.hu.bep.example.domain.FancyFishManager;
import nl.hu.bep.example.security.SecurityManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyContextListener implements ServletContextListener {
    private static final Logger LOG = LogManager.getLogger(MyContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        LOG.info("Server started");
        FancyFishManager.getInstance().addGreeting("Hello World");
        SecurityManager.getInstance().addUser("Jos", "Josvanreenen", "supersecret", "admin");
        LOG.info("Greetings initialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        LOG.info("Shutdown received");
    }
}

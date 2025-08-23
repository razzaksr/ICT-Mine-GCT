package help;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@WebListener
public class AppContext implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        List<Card> customers = new ArrayList<>();
        customers.add(new Card("Razak Mohamed S",98887.0,9876545678L));
        customers.add(new Card("Shakthi",87657.3,678987656789L));
        customers.add(new Card("Vijaya murugan",23232.3,45678987656L));
        customers.add(new Card("Sabarinathan S",923232.3,45678987656L));
        sce.getServletContext().setAttribute("customers", customers);
        System.out.println("List initialized.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
//        // 1. Stop MySQL cleanup thread
//        try {
//            AbandonedConnectionCleanupThread.checkedShutdown();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        // 2. Unregister JDBC drivers
//        Enumeration<Driver> drivers = DriverManager.getDrivers();
//        while (drivers.hasMoreElements()) {
//            Driver driver = drivers.nextElement();
//            try {
//                DriverManager.deregisterDriver(driver);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println("App shutting down. Cleaning up...");
//        Enumeration<Driver> drivers = DriverManager.getDrivers();
//        while (drivers.hasMoreElements()) {
//            Driver driver = drivers.nextElement();
//            try {
//                DriverManager.deregisterDriver(driver);
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }

    }
}

package utils;

import entities.BaseEntity;
import entities.Menu;
import entities.Order;
import entities.OrderItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import java.util.Properties;
import java.util.logging.Level;

public class DatabaseUtils {
    private static SessionFactory FACTORY = null;
    public static SessionFactory getFactory() {

        if (FACTORY == null) {
            synchronized (SessionFactory.class) {
                if (FACTORY == null) {
                    try {
                        Properties prop= new Properties();
                        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
                        prop.setProperty(Environment.URL, "jdbc:mysql://localhost:3306/pizzaorder");
                        prop.setProperty(Environment.HBM2DDL_AUTO, "update");
                        prop.setProperty(Environment.SHOW_SQL, "false");
                        prop.setProperty(Environment.FORMAT_SQL, "false");
                        prop.setProperty(Environment.USER, "root");
                        prop.setProperty(Environment.PASS, System.getenv("MYSQL_PWD"));
                        prop.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
                        prop.setProperty(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                        prop.setProperty(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                        Configuration config = new Configuration();
                        config.setProperties(prop);
                        config.addPackage("entities");
                        config.addAnnotatedClass(Menu.class);
                        config.addAnnotatedClass(Order.class);
                        config.addAnnotatedClass(OrderItem.class);
                        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                                .applySettings(config.getProperties()).build();

                        FACTORY = config.buildSessionFactory(serviceRegistry);
                    }
                    catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
        return FACTORY;
    }

    public static boolean testConnection() {
        try (Session session = getFactory().openSession()) {
            return session.isConnected();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

package config;

import models.ClassEntity;
import models.Student;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateSessionFactoryUtil {
    //private static final Logger logger = LoggerFactory.getLogger(HibernateSessionFactoryUtil.class);

    private static SessionFactory factory;

    public static SessionFactory getSessionFactory() {
        if (factory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                System.out.println(configuration.getProperties().toString());

                configuration.addAnnotatedClass(Student.class);
                configuration.addAnnotatedClass(ClassEntity.class);

                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties());
                System.out.println(builder.toString());
                factory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                //logger.error("Exception while creating SessionFactory: " + e.getMessage());
            }
        }

        return factory;
    }

    public static void shutdown() {
        if (factory != null) {
            factory.close();
        }
    }

//    public EntityManager em(String key) {
//        EntityManagerFactory emf = e
//    }
}

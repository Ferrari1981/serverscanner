package dsu1glassfishatomic;

import dsu1glassfishatomic.workinterfaces.InSessionFactory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;
import java.net.InetAddress;
import java.util.Date;

// TODO: 09.03.2023  Класс Получение Менеджера для Hibertire


@ApplicationScoped
public class MyGetHibernate{
    @Singleton
    @Produces
    @InSessionFactory
    public SessionFactory getsessionHibernate() {
        Configuration configuration = null;
        try {
            configuration = new Configuration();
            InetAddress ip = InetAddress.getLocalHost();
            String Name = ip.getHostName();
            switch (Name.trim()) {
                case "PcProgram":
                    configuration.configure("hibernate.cfg.xml");
                    break;
                default:
                    configuration.configure("hibernate_r.cfg.xml");
                    break;
            }
            System.out.println("\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + " configuration "
                    + configuration + " время" + new Date().toLocaleString() + " configuration " + configuration);
        } catch (Exception e) {
            System.out.println("\n" + " ERROR " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + " configuration "
                    + configuration + " время" + new Date().toLocaleString() + "  e " +  e.getMessage().toString());
        }
        return configuration.buildSessionFactory();
    }
    }


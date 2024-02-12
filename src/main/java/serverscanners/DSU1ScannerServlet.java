package serverscanners;




import businesslogic.*;
import dsu1glassfishatomic.workinterfaces.InSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( value="/sous.jboss.scanner",asyncSupported = true)
public class DSU1ScannerServlet extends HttpServlet {
    private      ServletContext    ЛОГ;
    /*SessionFactory sessionSousJboss;*/
    @Inject
    SubClassWriterErros subClassWriterErros;

    @Inject
    @InSessionFactory
    private SessionFactory getsessionHibernate;

    @Inject
    private   AyntificationDontPasswordAndLogin ayntificationDontPasswordAndLogin;



    @Inject
    private TransationCompleteSession transationCompleteSession;

    @Inject
    private ListerAsyncContext listerAsyncContext;

    private  Session session;



    DSU1ScannerServlet() {
        System.out.println(" class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber());
    }

    @PreDestroy
    public void commitingTransastion() {
        transationCompleteSession.commitingTransastion( session);
        // TODO: 01.11.2023
        System.out.println(" class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"
                + " session  "  +session.isOpen()+ "    transaction.getTimeout() "  );

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.doGet(req, resp);
        ЛОГ = getServletContext();
                try {
                    if (getsessionHibernate.isOpen()) {

                 /*       transationCompleteSession.startingTransastion(ЛОГ, session);
                        // TODO: 01.11.2023 Аунтификайия Имя И Пароль
                        Boolean СтатусаАунтификацииПользователя =
                                ayntificationDontPasswordAndLogin.successAyntificationUserForServlets( req, resp, session, ЛОГ);


                        if (СтатусаАунтификацииПользователя == true) {

                            ЛОГ.log("\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"
                                    + " ((HttpServletRequest) req).getPathInfo() " + ((HttpServletRequest) req).getPathInfo());
                        }*/

                    }

                    ЛОГ.log("\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                            " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                            " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"
                            + " ((HttpServletRequest) req).getPathInfo() " + ((HttpServletRequest) req).getPathInfo());
                } catch (Exception e) {
                    // TODO: 08.02.2024  rollback
                    transationCompleteSession.erroringTransastion(ЛОГ,session);
                    // TODO: 02.11.2023 запись ошибку
                    subClassWriterErros.
                            МетодаЗаписиОшибкиВЛог(e,
                                    Thread.currentThread().
                                            getStackTrace(),
                                    ЛОГ, "ErrorsLogs/ErrorJbossServletUpdatePO.txt");

                }




    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        ЛОГ = getServletContext();
                //TODO ПОТОК ДЛЯ МЕТОДА POST
                try {
                    if (getsessionHibernate.isOpen()) {
                        // TODO: 01.11.2023 Аунтификайия Имя И Пароль
                        Boolean СтатусаАунтификацииПользователя =
                                ayntificationDontPasswordAndLogin.successAyntificationUserForServlets( req, resp , session, ЛОГ);

                        if (СтатусаАунтификацииПользователя == true) {
                            //TODO ЗАПУСКАЕМ КОДЕ МЕТОДА POST()


                        }
                    }


                    ЛОГ.log("\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                            " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                            " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" + ((HttpServletRequest) req).getPathInfo() +
                            " POOL CURRENT  " + Thread.currentThread().getName() + " req.isAsyncStarted() " + req.isAsyncStarted());
                } catch (Exception e) {
                    // TODO: 08.02.2024  rollback
                    transationCompleteSession.erroringTransastion(ЛОГ,session);
                    // TODO: 02.11.2023 запись ошибку
                    subClassWriterErros.
                            МетодаЗаписиОшибкиВЛог(e,
                                    Thread.currentThread().
                                            getStackTrace(),
                                    ЛОГ, "ErrorsLogs/ErrorJbossServletScanner.txt");

                }


    }

    public void destroy() {
        try{
          /*  if (sessionSousJboss!=null && sessionSousJboss.isOpen()) {
                sessionSousJboss.close();
            }*/
            ЛОГ.log("\n"+" class "+Thread.currentThread().getStackTrace()[2].getClassName() +"\n"+
                    " metod "+Thread.currentThread().getStackTrace()[2].getMethodName() +"\n"+
                    " line "+  Thread.currentThread().getStackTrace()[2].getLineNumber());
        } catch (Exception e) {
            subClassWriterErros.
                    МетодаЗаписиОшибкиВЛог(e,
                            Thread.currentThread().
                                    getStackTrace(),
                            ЛОГ,"ErrorsLogs/ErrorJbossServletScanner.txt");

        }

    }
}


































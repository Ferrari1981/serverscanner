package dsu1glassfishatomic;


import SessionBeans.BeanGET;
import SessionBeans.BeanPOST;
import businesslogic.ListerAsyncContext;
import businesslogic.SubClassWriterErros;
import businesslogic.TransationCompleteSession;
import dsu1glassfishatomic.workinterfaces.InSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.transaction.jta.platform.internal.JBossAppServerJtaPlatform;
import org.hibernate.engine.transaction.jta.platform.spi.JtaPlatform;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;
import java.io.IOException;


@WebServlet( value="/sous.jboss.tabel",asyncSupported = true)
public class DSU1JsonServlet extends HttpServlet {

    @EJB
    private BeanGET СессионыйБинGET;
    @EJB
    private BeanPOST СессионыйБинPOST;

    @Inject
    private   SubClassWriterErros subClassWriterErros;



    private  ServletContext   ЛОГ;



    @Inject
    @InSessionFactory
    private SessionFactory getsessionHibernate;



            DSU1JsonServlet(){
        // TODO: 10.10.2023 ihit
        //sessionSousJboss.openSession();
        System.out.println(" class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber());

    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     // super.doGet(req, resp);
       ЛОГ = getServletContext();
       try{
                            //TODO ЗАПУСКАЕМ КОДЕ МЕТОДА GET()
                            СессионыйБинGET.МетодБинаGET(ЛОГ,  req, resp ,getsessionHibernate );


                        ЛОГ.log("\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"
                                + " ((HttpServletRequest) req).getPathInfo() " + ((HttpServletRequest) req).getPathInfo() +
                                " POOL CURRENT  " + Thread.currentThread().getName() + " req.isAsyncStarted() " + req.isAsyncStarted()
                                + "  POOL  THREAD " + Thread.currentThread().getName());



                    ЛОГ.log("\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                            " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                            " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"
                            + " ((HttpServletRequest) req).getPathInfo() " + ((HttpServletRequest) req).getPathInfo() +
                            " POOL CURRENT  " + Thread.currentThread().getName() + " req.isAsyncStarted() " + req.isAsyncStarted()
                            + "  POOL  THREAD " + Thread.currentThread().getName());
                } catch (Exception e) {
                    // TODO: 02.11.2023 запись ошибку
                    subClassWriterErros.
                            МетодаЗаписиОшибкиВЛог(e,
                                    Thread.currentThread().
                                            getStackTrace(),
                                    ЛОГ, "ErrorsLogs/ErrorJbossServletDSU1.txt");
                }

    }//TODO END doGet






    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        ЛОГ = getServletContext();
        //TODO ПОТОК ДЛЯ МЕТОДА POST
                try {

                            //TODO ЗАПУСКАЕМ КОДЕ МЕТОДА POST()
                            СессионыйБинPOST.МетодБинаPOST(ЛОГ, req,  resp,getsessionHibernate  );


                    ЛОГ.log("\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                            " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                            " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" + ((HttpServletRequest) req).getPathInfo() +
                            " POOL CURRENT  " + Thread.currentThread().getName() + " req.isAsyncStarted() " + req.isAsyncStarted());
                } catch (Exception e) {
                    // TODO: 02.11.2023 запись ошибку
                    subClassWriterErros.
                            МетодаЗаписиОшибкиВЛог(e,
                                    Thread.currentThread().
                                            getStackTrace(),
                                    ЛОГ, "ErrorsLogs/ErrorJbossServletDSU1.txt");

                }

    }//todo end doPost




    public void destroy() {
      try{
          System.out.println(" class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                  " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                  " line " + Thread.currentThread().getStackTrace()[2].getLineNumber());
    } catch (Exception e) {
          subClassWriterErros.
                  МетодаЗаписиОшибкиВЛог(e,
                          Thread.currentThread().
                                  getStackTrace(),
                          ЛОГ,"ErrorsLogs/ErrorJbossServletDSU1.txt");


      }

    }

}


































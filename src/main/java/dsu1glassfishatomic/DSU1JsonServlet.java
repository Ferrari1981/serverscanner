package dsu1glassfishatomic;


import BL.CDI.QualifierWorker1;
import SessionBeans.BeanGET;
import SessionBeans.BeanPOST;
import businesslogic.SubClassWriterErros;
import com.Worker2.BL.BL_Worker2;
import com.Worker2.BL.CDI.QualifierWorker2;
import com.workers1.BL_Worker;
import dsu1glassfishatomic.workinterfaces.InSessionFactory;
import org.hibernate.SessionFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ConcurrentSkipListSet;


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


    @Inject
    @QualifierWorker1
    ConcurrentSkipListSet getWorkercon;


    @Inject
    @QualifierWorker2
    ConcurrentSkipListSet getWorker2con;




            DSU1JsonServlet(){
        System.out.println(" class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber());

    }




        @PostConstruct
        private void startup() {
            System.out.println(" class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber()+
                    "   getsessionHibernate.getCache();"+  getsessionHibernate.getCache());
        }

        @PreDestroy
        private void shutdown() {
            System.out.println(" class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber()+
                    "   getsessionHibernate.getCache();"+  getsessionHibernate.getCache());
        }








    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     // super.doGet(req, resp);
       ЛОГ = getServletContext();
       try{

           getWorkercon.size();

           ЛОГ.log("\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                   " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                   " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"
                   + " ((HttpServletRequest) req).getPathInfo() " + ((HttpServletRequest) req).getPathInfo() +
                   " POOL CURRENT  " + Thread.currentThread().getName() + " req.isAsyncStarted() " + req.isAsyncStarted()
                   + "  POOL  THREAD " + Thread.currentThread().getName());

           getWorker2con.size();


                            //TODO ЗАПУСКАЕМ КОДЕ МЕТОДА GET()
                            СессионыйБинGET.МетодБинаGET(ЛОГ,  req, resp ,getsessionHibernate );


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


































package dowsloadpojboss;


import businesslogic.*;
import com.Worker2.BL.BL_Worker2;
import com.Worker2.BL.CDI.QualifierWorker2;
import dsu1glassfishatomic.workinterfaces.InSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( value="/sous.jboss.download",asyncSupported = true)
public class DSU1DonwloadsServlet extends HttpServlet {


    @Inject
    private  SubClassWriterErros subClassWriterErros;
    @EJB
    private BeanCallsBackDownloadPO beanCallsBackDownloadPO;
    private  ServletContext   ЛОГ;

    @Inject
    @InSessionFactory
    private SessionFactory getsessionHibernate;






    DSU1DonwloadsServlet(){
        System.out.println(" class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber());
    }




    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     // super.doGet(req, resp);
           ЛОГ = getServletContext();
        // TODO: 23.12.2023
                try {
                    // TODO: 22.05.2023 lister asynccontext
                            // TODO: 24.07.2023 запуск обновение ПО
                            beanCallsBackDownloadPO.МетодЗапускаОбновлениеПО(ЛОГ, (HttpServletRequest) req,
                                            (HttpServletResponse) resp, getsessionHibernate);

                    ЛОГ.log("\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                            " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                            " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"
                            + " ((HttpServletRequest) req).getPathInfo() " + ((HttpServletRequest) req).getPathInfo());
                } catch (Exception e) {
                    // TODO: 02.11.2023 запись ошибку
                    subClassWriterErros.
                            МетодаЗаписиОшибкиВЛог(e,
                                    Thread.currentThread().
                                            getStackTrace(),
                                    ЛОГ, "ErrorsLogs/ErrorJbossServletUpdatePO.txt");

                }

    }



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
                          ЛОГ,"ErrorsLogs/ErrorJbossServletUpdatePO.txt");

    }

    }
}


































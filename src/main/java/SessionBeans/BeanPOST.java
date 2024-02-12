package SessionBeans;


import businesslogic.*;
import com.sun.istack.NotNull;
import dsu1glassfishatomic.workinterfaces.InSessionFactory;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jboss.ejb3.annotation.TransactionTimeout;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.*;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.rmi.RemoteException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Session Bean implementation class BeanPOST
 */
@Stateless(mappedName = "beanPOST")
@LocalBean
@Transactional
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class BeanPOST   {
    @Inject
    private SubClassSessionBeanPOST subClassSessionBeanPOST;
    @Inject
    private  BEANCallsBack bEANCallsBack;
    @Inject
    private    SubClassWriterErros subClassWriterErros;

    @Inject
    private  TransationCompleteSession transationCompleteSession;

    @Inject
    private AsyncContextComplete asyncContextComplete;

    @Inject
    private AyntificationDontPasswordAndLogin ayntificationDontPasswordAndLogin;

    private  Session session;



    /**
     * Default constructor.
     */
    public BeanPOST() {
        // TODO Auto-generated constructor stub
        System.out.print("\n"+" Starting.... class "+Thread.currentThread().getStackTrace()[2].getClassName() +"\n"+
                " metod "+Thread.currentThread().getStackTrace()[2].getMethodName() +"\n"+
                " line "+  Thread.currentThread().getStackTrace()[2].getLineNumber()+"\n");
    }


    @PreDestroy
    public void commitingTransastion() {
        transationCompleteSession.commitingTransastion(  session);
        // TODO: 01.11.2023
        System.out.println(" class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"
                + " session  "  +session.isOpen()+ "    transaction.getTimeout() "  );
    }


    @Asynchronous
    public void МетодБинаPOST(@NotNull ServletContext ЛОГ,
                                      @NotNull HttpServletRequest request,
                                      @NotNull  HttpServletResponse response,
                                       @NotNull  SessionFactory getsessionHibernate) throws InterruptedException, ExecutionException {;
        try {

            if (getsessionHibernate.isOpen()) {
                // TODO: 01.11.2023 Получаем Сессию
                session = transationCompleteSession.startingSession(  getsessionHibernate);
            // TODO: 01.11.2023 Аунтификайия Имя И Пароль
            Boolean СтатусаАунтификацииПользователя =
                    ayntificationDontPasswordAndLogin.successAyntificationUserForServlets(request, response, session, ЛОГ);


            if (СтатусаАунтификацииПользователя == true) {

            ///Todo  получаем данные от клиента
          byte[]  БуферРезультатPOST=		subClassSessionBeanPOST.МетодЗапускаPOST(request, response, ЛОГ,session);


            ///Todo получаем данные от Клиента на Сервер
                bEANCallsBack.МетодBackДанныеКлиентуByte(response, БуферРезультатPOST, ЛОГ  );


                // TODO: 29.11.2023 закрывам Сесиою HIbernate
                transationCompleteSession.commitingTransastion(  session);
                // TODO: 29.11.2023 закрывам Сесиою Бызова
                asyncContextComplete.endingContextComplete(request, ЛОГ);

            }
            }

            ЛОГ.log("\n"+" Starting.... class "+Thread.currentThread().getStackTrace()[2].getClassName() +"\n"+
                    " metod "+Thread.currentThread().getStackTrace()[2].getMethodName() +"\n"+
                    " line "+  Thread.currentThread().getStackTrace()[2].getLineNumber()+"\n");
        } catch (Exception e) {
            // TODO: 02.11.2023 ROLLBACK
            // TODO: 17.11.2023 ERROR transaction
            transationCompleteSession.erroringTransastion(ЛОГ,session);
            subClassWriterErros.
                    МетодаЗаписиОшибкиВЛог(e,
                            Thread.currentThread().
                                    getStackTrace(),
                            ЛОГ,"ErrorsLogs/ErrorJbossServletDSU1.txt");
        }
    }



}


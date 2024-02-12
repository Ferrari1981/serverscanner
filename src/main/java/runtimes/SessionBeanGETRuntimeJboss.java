package runtimes;

import businesslogic.*;
import com.sun.istack.NotNull;
import dsu1glassfishatomic.workinterfaces.InSessionFactory;
import jakarta.transaction.Transactional;
import jakarta.transaction.UserTransaction;
import org.hibernate.*;
import org.hibernate.engine.transaction.jta.platform.internal.JBossAppServerJtaPlatform;
import org.hibernate.resource.transaction.backend.jta.internal.synchronization.SynchronizationCallbackCoordinator;
import org.jboss.ejb3.annotation.TransactionTimeout;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.*;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.TransactionManager;
import java.rmi.RemoteException;
import java.sql.*;
import java.util.Date;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Stateless(mappedName = "sessionBeanGETRuntimeJboss")
@LocalBean
@Transactional
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class SessionBeanGETRuntimeJboss   {// extends WITH

    private ServletContext ЛОГ;
    //private	Connection conn; ////// общий коннект для всего севлтера
    private Statement stmt;
    @SuppressWarnings("unused")
    private String ПубличноеHeaderИмя = null;
    @SuppressWarnings("unused")
    private String ОшибкаВМетодеdoPOST = new String();
    private int КоличествоСтрокКоторыеМыОтправимНаКлиент;
    private String ИмяПолученныйИзSQlServerПосик = null;
    @SuppressWarnings("unused")
    private String ПарольПолученныйОтКлиента = null;
    private String ЛогинПолученныйОтКлиента = null;

    @SuppressWarnings("unused")
    private HttpServletRequest request;
    private HttpServletResponse response;


    @Inject
    private  BEANCallsBack bEANCallsBack;
    @Inject
    private  SubClassWriterErros subClassWriterErros;

    @Inject
    private StreamJSONJacksons streamJSONJacksons ;

    @Inject
    private  TransationCompleteSession transationCompleteSession;

    @Inject
    private AsyncContextComplete asyncContextComplete;

    private  Session session;





    public SessionBeanGETRuntimeJboss() {

        System.out.println("Конструктор  SessionBeanGETRuntimeJboss");

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
    public void МетодГлавныйRuntimeJboss(@NotNull ServletContext ЛОГ,
                                                 @NotNull HttpServletRequest request,
                                                 @NotNull  HttpServletResponse response,
                                         @NotNull SessionFactory getsessionHibernate) throws InterruptedException, ExecutionException {;
        try {

            if (getsessionHibernate.isOpen()) {
                // TODO: 01.11.2023 Получаем Сессию
                session = transationCompleteSession.startingSession(  getsessionHibernate);
            ///Todo  получаем данные от клиента
            byte[] БуферРезультатRuntime= 	 МетодЗапускаRuntime(request,ЛОГ,response,session);


            ///Todo получаем данные от Клиента на Сервер
            bEANCallsBack.МетодBackДанныеКлиентуByte(response, БуферРезультатRuntime, ЛОГ  );

// TODO: 29.11.2023 закрывам Async
            asyncContextComplete.endingContextComplete(request,ЛОГ);


            }
            // TODO: 01.11.2023
            ЛОГ.log("\n"+" Starting.... class "+Thread.currentThread().getStackTrace()[2].getClassName() +"\n"+
                    " metod "+Thread.currentThread().getStackTrace()[2].getMethodName() +"\n"+
                    " line "+  Thread.currentThread().getStackTrace()[2].getLineNumber()+"\n"+"  БуферРезультатRuntime  ");
        } catch (Exception e) {
            // TODO: 08.02.2024  rollback
            transationCompleteSession.erroringTransastion(ЛОГ,session);
            subClassWriterErros.
                    МетодаЗаписиОшибкиВЛог(e,
                            Thread.currentThread().
                                    getStackTrace(),
                            ЛОГ,"ErrorsLogs/ErrorJbossServletRuntime.txt");
        }
    }








    private  byte[] МетодЗапускаRuntime(@NotNull HttpServletRequest request,
                                                    @NotNull ServletContext ЛОГ,
                                                    @NotNull  HttpServletResponse response,
                                      @NotNull  Session session) throws SecurityException, SQLException {
        // TODO Auto-generated method stub
        byte[] БуферCallsBackДляAndroid = new byte[0];
        try  {
            List<?>         ЛистДанныеОтHibenide = null;
            this.ЛОГ = ЛОГ;
            // TODO
            this.request = request;
            /// TODO
            this.response = response;
            // TODO Коннектимся к Базе SQl Server
            ЛОГ.log("ЛОГ  GET() " + ЛОГ + " request " + request + " response " + response);
            ////
            // TODO получаем session
            ЛОГ.log("ЗАПУСКАЕТСЯ....... ГЛАВНЫЙ МЕТОД GET() СЕРВЛЕТА " + new Date() + "\n" + ЛОГ.getServerInfo()
                    + "  request " + request + " response " + response + " ЛОГ" + ЛОГ);




            // TODO ГАЛВНЫЙ МЕТОД GET НАЧИНАЕТ РАБОТАТЬ
            String   JobForServer = Optional.ofNullable(request.getParameter("JobForServer")).orElse("");
            if (JobForServer.length()>0) {
                // TODO: 10.03.2023 получение сессиии HIREBIANTE
                ЛОГ.log("\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                        " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                        " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"
                        + "    session.getTransaction().getStatus() " +   session.getTransaction().getStatus());

    }




            switch (JobForServer) {
                // TODO ЗАДАНИЕ ДЛЯ СЕРВЕР JOBSERVERTASK #5
                case "Хотим Получить Статус Реальной Работы SQL SERVER":
                    // TODO РЕАЛЬНЫЙ СТАТУС РАБОТЫ SQL SERVER
                       ЛистДанныеОтHibenide = Метод_РеальнаяСтатусSqlServer(session);
                    ЛОГ.log(" Отправили Хотим Получить Статус Реальной Работы SQL SERVER  JobForServer " + JobForServer
                            + " ЛистДанныеОтHibenide "
                            + ЛистДанныеОтHibenide.size());
                    break;
                // TODO ЗАДАНИЯ ДЛЯ СЕРВЕРА НЕТУ
                default:
                    ЛОГ.log("\n"+"  default:  Starting.... class "+Thread.currentThread().getStackTrace()[2].getClassName() +"\n"+
                            " metod "+Thread.currentThread().getStackTrace()[2].getMethodName() +"\n"+
                            " line "+  Thread.currentThread().getStackTrace()[2].getLineNumber()+"\n"+
                            "Метод_РеальнаяСтатусSqlServer  ЛистДанныеОтHibenide ");
                    break;
            }
            if ( ЛистДанныеОтHibenide!=null && ЛистДанныеОтHibenide.size()>0 ) {
                БуферCallsBackДляAndroid = streamJSONJacksons.getStreamJacksons(ЛистДанныеОтHibenide);
            }
            // TODO
            ЛОГ.log("БуферCallsBackДляAndroid.toString() " + "" + БуферCallsBackДляAndroid.toString() + " ЛистДанныеОтHibenide " +ЛистДанныеОтHibenide);



        } catch (Exception e) {
            subClassWriterErros.
                    МетодаЗаписиОшибкиВЛог(e,
                            Thread.currentThread().
                                    getStackTrace(),
                            ЛОГ,"ErrorsLogs/ErrorJbossServletRuntime.txt");

        }
        return  БуферCallsBackДляAndroid;
        // AsyncResult<StringBuffer>(БуферCallsBackДляAndroid);
    }

    // TODO реальный статус POST SQl Servera
    private List<model.UsersEntity> Метод_РеальнаяСтатусSqlServer(@javax.validation.constraints.NotNull Session session) {
        List<model.UsersEntity> ЛистДанныеОтHibenide  = new ArrayList<>();
        try {
            LockOptions lockOptionsREAD=new LockOptions();
            lockOptionsREAD.setLockMode(LockMode.PESSIMISTIC_READ);
            lockOptionsREAD.setScope(true);


            ЛистДанныеОтHibenide =( List<model.UsersEntity>)
                     session.createQuery("SELECT   usersentity. id FROM model.UsersEntity  as  usersentity" +
                                     " WHERE usersentity.rights =:rights1 OR  usersentity.rights =:rights2   OR  usersentity.rights =:rights3    ")
                            .setParameter("rights1",2)
                            .setParameter("rights2",6)
                            .setParameter("rights3",7)
                             .setCacheable(true)
                             .setLockOptions(lockOptionsREAD)
                             .setMaxResults(1)
                             .getResultList();
            ЛОГ.log("\n"+" Starting.... class "+Thread.currentThread().getStackTrace()[2].getClassName() +"\n"+
                    " metod "+Thread.currentThread().getStackTrace()[2].getMethodName() +"\n"+
                    " line "+  Thread.currentThread().getStackTrace()[2].getLineNumber()+"\n"+
                    "Метод_РеальнаяСтатусSqlServer  ЛистДанныеОтHibenide " +ЛистДанныеОтHibenide.size());
        } catch (Exception e) {
            subClassWriterErros.
                    МетодаЗаписиОшибкиВЛог(e,
                            Thread.currentThread().
                                    getStackTrace(),
                            ЛОГ,"ErrorsLogs/ErrorJbossServletDSU1.txt");
        }
        return ЛистДанныеОтHibenide;
    }




    // TODO: 23.04.2023 end test code
}

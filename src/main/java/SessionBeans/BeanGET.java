package SessionBeans;

import businesslogic.*;
import com.sun.istack.NotNull;
import dsu1glassfishatomic.workinterfaces.InSessionFactory;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.*;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

/**
 * Session Bean implementation class BeanGET
 */
@Stateless(mappedName = "beanGET")
@LocalBean
@Transactional
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class BeanGET   {
    /**
     * Default constructor.
     */
    @Inject
    private  GeneratorDataFromAndroid generatorDataFromAndroid;
    @Inject
    private  BEANCallsBack bEANCallsBack;
    @Inject
    private SubClassWriterErros subClassWriterErros;
    @Inject
    private TransationCompleteSession transationCompleteSession;
    @Inject
    private AsyncContextComplete asyncContextComplete;

    @Inject
    private AyntificationDontPasswordAndLogin ayntificationDontPasswordAndLogin;

    private    Session session;




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
    public void   МетодБинаGET(@NotNull ServletContext ЛОГ,
                               @NotNull HttpServletRequest request,
                               @NotNull  HttpServletResponse response,
                               @NotNull SessionFactory getsessionHibernate) throws InterruptedException, ExecutionException {
        try {
            // TODO: 10.03.2023  данные от GET метода
            byte[]    БуферРезультатGETByte=null;

            if (getsessionHibernate.isOpen()) {
                // TODO: 01.11.2023 Получаем Сессию
                session = transationCompleteSession.startingSession(  getsessionHibernate);

            // TODO: 01.11.2023 Аунтификайия Имя И Пароль
            Boolean СтатусаАунтификацииПользователя =
                    ayntificationDontPasswordAndLogin
                            .successAyntificationUserForServlets(request, response, session, ЛОГ);

            String    JobForServer = Optional.ofNullable(request.getParameter("JobForServer")).map(String::new).orElse("").trim();


            if(!JobForServer.isEmpty()){


                // TODO: 02.02.2024 когда логин и пароль правельный Succeess
            if (   СтатусаАунтификацииПользователя == true  ) {
                // TODO: 02.02.2024 когда логин и пароль правельный Succeess
                БуферРезультатGETByte = CallBackSucceessAuntificazions(ЛОГ, request, response, session, СтатусаАунтификацииПользователя, JobForServer);

                ЛОГ.log( " Класс"+Thread.currentThread().getStackTrace()[2].getClassName()
                        +"\n"+
                        " метод "+Thread.currentThread().getStackTrace()[2].getMethodName() +"\n"
                        + "Строка " + Thread.currentThread().getStackTrace()[2].getLineNumber()  +  "БуферРезультатGETByte " +БуферРезультатGETByte+
                        " JobForServer " +JobForServer);






                // TODO: 02.02.2024 когда логин и пароль неправильный
            }else {
                // TODO: 02.02.2024 когда логин и пароль неправильный

                БуферРезультатGETByte = generatorDataFromAndroid.ГлавныйМетод_МетодаGETService(request, ЛОГ, session);



                // TODO: 11.03.2023  нет не имени не пароля
                ayntificationDontPasswordAndLogin.ayntificationDontPasswordAndLogin(request, response, ЛОГ);

                ЛОГ.log( " Класс"+Thread.currentThread().getStackTrace()[2].getClassName()
                        +"\n"+
                        " метод "+Thread.currentThread().getStackTrace()[2].getMethodName() +"\n"
                        + "Строка " + Thread.currentThread().getStackTrace()[2].getLineNumber()  +  "БуферРезультатGETByte " +БуферРезультатGETByte+
                        " JobForServer " +JobForServer);
            }


                ЛОГ.log( " Класс"+Thread.currentThread().getStackTrace()[2].getClassName()
                        +"\n"+
                        " метод "+Thread.currentThread().getStackTrace()[2].getMethodName() +"\n"
                        + "Строка " + Thread.currentThread().getStackTrace()[2].getLineNumber()  +  "БуферРезультатGETByte " +БуферРезультатGETByte+
                        " JobForServer " +JobForServer);

            }

            }
            ЛОГ.log( " Класс"+Thread.currentThread().getStackTrace()[2].getClassName()
                    +"\n"+
                    " метод "+Thread.currentThread().getStackTrace()[2].getMethodName() +"\n"
                    + "Строка " + Thread.currentThread().getStackTrace()[2].getLineNumber() );

        } catch (Exception e) {
            // TODO: 17.11.2023 ERROR transaction
            transationCompleteSession.erroringTransastion(ЛОГ,session);
            subClassWriterErros.
                    МетодаЗаписиОшибкиВЛог(e,
                            Thread.currentThread().
                                    getStackTrace(),
                            ЛОГ,"ErrorsLogs/ErrorJbossServletDSU1.txt");
        }

}

    private byte[] CallBackSucceessAuntificazions(ServletContext ЛОГ, HttpServletRequest request, HttpServletResponse response,
                                                  Session session, Boolean СтатусаАунтификацииПользователя, String JobForServer) throws SQLException {
        byte[] БуферРезультатGETByte;
        if (JobForServer.trim().equalsIgnoreCase("Хотим Получить  JSON")) {

            БуферРезультатGETByte = generatorDataFromAndroid.ГлавныйМетод_МетодаGETByte(request, ЛОГ, response, session);

            ЛОГ.log( " Класс"+Thread.currentThread().getStackTrace()[2].getClassName()
                    +"\n"+
                    " метод "+Thread.currentThread().getStackTrace()[2].getMethodName() +"\n"
                    + "Строка " + Thread.currentThread().getStackTrace()[2].getLineNumber()  +  "БуферРезультатGETByte " +БуферРезультатGETByte+
                    " JobForServer " + JobForServer +" СтатусаАунтификацииПользователя " + СтатусаАунтификацииПользователя);
            // TODO: 30.10.2023  НЕ сам JSON а сопуствубщие данные для радоты обмена
        } else {
            БуферРезультатGETByte = generatorDataFromAndroid.ГлавныйМетод_МетодаGETService(request, ЛОГ, session);

            ЛОГ.log( " Класс"+Thread.currentThread().getStackTrace()[2].getClassName()
                    +"\n"+
                    " метод "+Thread.currentThread().getStackTrace()[2].getMethodName() +"\n"
                    + "Строка " + Thread.currentThread().getStackTrace()[2].getLineNumber()  +  "БуферРезультатGETByte " +БуферРезультатGETByte+
                    " JobForServer " + JobForServer +" СтатусаАунтификацииПользователя " + СтатусаАунтификацииПользователя);
        }


        ///TODO ОТВЕТ КЛИЕНТУ ОТ СЕРВЕРА
        bEANCallsBack.МетодBackДанныеКлиентуByte(response, БуферРезультатGETByte, ЛОГ);

        // TODO: 29.11.2023 закрывам Async
        asyncContextComplete.endingContextComplete(request, ЛОГ);
        return БуферРезультатGETByte;
    }




}

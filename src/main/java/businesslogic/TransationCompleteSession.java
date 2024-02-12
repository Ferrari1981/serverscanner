package businesslogic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.internal.SessionImpl;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

@Named("transationCompleteSession")
public class TransationCompleteSession {

    @Inject
    private SubClassWriterErros subClassWriterErros;

    public   Session startingSession(@NotNull ServletContext ЛОГ, @NotNull SessionFactory getsessionHibernate){
        Session session=null;
        try{
            if (getsessionHibernate.isOpen()) {
                session=   getsessionHibernate.openSession();
                // TODO: 31.10.2023
                session.joinTransaction();
            }
System.out.println(" class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
        " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
        " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"
        + "session  "  +session +" sessionFactory.isOpen() "+getsessionHibernate.isOpen());
    } catch (Exception e) {
            subClassWriterErros.
                МетодаЗаписиОшибкиВЛог(e,
                        Thread.currentThread().
                                getStackTrace(),
                        ЛОГ, "ErrorsLogs/ErrorJbossServletUpdatePO.txt");

    }
        return  session;

    }

    public   void startingTransastion(@NotNull ServletContext ЛОГ, @NotNull Session session){
        try{
            Transaction transaction=null;
                // TODO: 31.10.2023
                if (session.isOpen()) {
                     transaction= session.getTransaction() ;
                    if ( ! session.isJoinedToTransaction() ) {
                        transaction.setTimeout(1000000);
                        transaction.begin();
                        session.joinTransaction();
                        // TODO: 17.11.2023
                    }
                }
            ЛОГ.log("\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"
                    + " session  "  +session.isOpen()+ "    transaction.getTimeout() " +   transaction.getTimeout() );
        } catch (Exception e) {
            subClassWriterErros.
                    МетодаЗаписиОшибкиВЛог(e,
                            Thread.currentThread().
                                    getStackTrace(),
                            ЛОГ, "ErrorsLogs/ErrorJbossServletUpdatePO.txt");

        }
    }

    public  void commitingTransastion(@NotNull ServletContext ЛОГ,@NotNull Session session){
        try{
            Transaction transaction= null;
            if (session.isOpen()) {
                transaction = session.getTransaction();

                if (   session.isJoinedToTransaction() ) {
                if (session.isDirty()) {
                    session.flush();
                }
                transaction.commit();
            }

            }
            ЛОГ.log("\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"
                    + "+ \" session  \"  +session.isOpen()" + " session  "  +session.isOpen()+ "    transaction.getTimeout() " +   transaction.getTimeout() );
    } catch (Exception e) {
        subClassWriterErros.
        МетодаЗаписиОшибкиВЛог(e,
        Thread.currentThread().
        getStackTrace(),
        ЛОГ, "ErrorsLogs/ErrorJbossServletUpdatePO.txt");

        }
    }


    public  void erroringTransastion(@NotNull ServletContext ЛОГ,@NotNull Session session){
        try{
            Transaction transaction= null;
            if (session.isOpen()) {
                transaction = session.getTransaction();
                if (   session.isJoinedToTransaction() ) {
                    transaction.rollback();
                }
            }
            ЛОГ.log("\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"
                    + " transaction.getStatus() " +transaction.getStatus()+ "    transaction.getTimeout() " +   transaction.getTimeout() );
        } catch (Exception e) {
            subClassWriterErros.
                    МетодаЗаписиОшибкиВЛог(e,
                            Thread.currentThread().
                                    getStackTrace(),
                            ЛОГ, "ErrorsLogs/ErrorJbossServletUpdatePO.txt");

        }
    }


}

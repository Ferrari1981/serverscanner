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



    public   Session startingSession( @NotNull SessionFactory getsessionHibernate){
        Session session=null;
        try{
            if (getsessionHibernate.isOpen()) {
                session=   getsessionHibernate.openSession();
                // TODO: 31.10.2023
                startingTransastion(session);
            }
System.out.println(" class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
        " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
        " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"
        + "session  "  +session +" sessionFactory.isOpen() "+getsessionHibernate.isOpen());
    } catch (Exception e) {
            System.err.println(" error class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"
                    + " session  "  +session.isOpen()+ "    transaction.getTimeout() "  );

    }
        return  session;

    }

    public   void startingTransastion(  @NotNull Session session){
        try{
            Transaction transaction=null;
                // TODO: 31.10.2023
                if (session.isOpen()) {
                    // TODO: 12.02.2024 jion
                    session.joinTransaction();
                     transaction= session.getTransaction() ;
                    if ( ! session.isJoinedToTransaction() ) {
                       // transaction.setTimeout(1000000);
                       // transaction.begin();

                        // TODO: 17.11.2023
                    }
                }
                System.out.println(" class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                        " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                        " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"
                        + " session  "  +session.isOpen()+ "    transaction.getTimeout() " +   transaction.getTimeout());
        } catch (Exception e) {
            System.err.println(" error class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"
                    + " session  "  +session.isOpen()+ "    transaction.getTimeout() "  );

        }
    }

    public  void commitingTransastion( @NotNull Session session){
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
            System.out.println(" class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"
                    + " session  "  +session.isOpen()+ "    transaction.getTimeout() " +   transaction.getTimeout());
    } catch (Exception e) {
            System.err.println("error  class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"
                    + " session  "  +session.isOpen()+ "    transaction.getTimeout() "  );

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
            System.out.println(" error  class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"
                    + " session  "  +session.isOpen()+ "    transaction.getTimeout() " +   transaction.getTimeout());
        } catch (Exception e) {
            System.err.println(" class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"
                    + " session  "  +session.isOpen()+ "    transaction.getTimeout() "  );

        }
    }


}

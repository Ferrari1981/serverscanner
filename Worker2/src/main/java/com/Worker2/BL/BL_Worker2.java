package com.Worker2.BL;




import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import java.util.concurrent.ConcurrentSkipListSet;


@Named
@RequestScoped
public class BL_Worker2 {


    @Produces
    public ConcurrentSkipListSet getWorker2con(){
        // TODO: 13.02.2024  forfard oxhe worker
        System.out.println(" class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber());
        return new ConcurrentSkipListSet<>();

    }
}

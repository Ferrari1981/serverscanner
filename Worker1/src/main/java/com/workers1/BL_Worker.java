package com.workers1;


import BL.CDI.QualifierWorker1;
import com.Worker2.BL.BL_Worker2;
import com.Worker2.BL.CDI.QualifierWorker2;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.concurrent.ConcurrentSkipListSet;


@Named
@RequestScoped
public class BL_Worker {


    @Default
    @QualifierWorker1
    @Produces
    public ConcurrentSkipListSet getWorkercon(){
        // TODO: 13.02.2024  forfard oxhe worker
        System.out.println(" class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber());
        return new ConcurrentSkipListSet<>();

    }
}

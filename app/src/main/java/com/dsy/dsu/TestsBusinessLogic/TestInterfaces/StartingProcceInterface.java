package com.dsy.dsu.TestsBusinessLogic.TestInterfaces;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import com.dsy.dsu.TestsBusinessLogic.TestInterfaces.Interface.IFunc1;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StartingProcceInterface {
  Logger LOGGER = LoggerFactory.getLogger(StartingProcceInterface.class);


  Logger LOGGER2=LoggerFactory.getLogger(this.getClass());


 public  void  ProcceInterface( IFunc1 iFunc1 ) {
     iFunc1.applyAsByte((short) 11);

    System.out.printf("ProcceInterface()");

     LOGGER.trace("  public  void  ProcceInterface( IFunc1  iFunc1 ) ");
     LOGGER.warn("  public  void  ProcceInterface( IFunc1  iFunc1 )");
    }

  @Before
  public    void  ProcceInterfaceEnd() {
        System.out.printf("ProcceInterfaceEnd()");
      LOGGER.trace(" public    void  ProcceInterfaceEnd() ");
      LOGGER.warn(" public    void  ProcceInterfaceEnd() ");
    }






@Test
public void startingtest() throws  Exception{


  //  IFunc1  iFunc1=new ProcceInterface();
    IFunc1    iFunc1=new Procesing2nterface();


        ProcceInterface( iFunc1);

/*        String expected = "Baeldung";
        String actual = "Baeldung";

        assertEquals(expected, actual);*/

        ///fail("message");

/*        Object car =null;

        assertNull("The car should be null", car);*/

    LOGGER.trace("  public void startingtest() ");
    LOGGER.warn("  public void startingtest() ");

}

}

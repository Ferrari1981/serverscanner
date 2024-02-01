package com.dsy.dsu.TestsBusinessLogic.HiltTests;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;


public class StartingHilttest {



    Logger LOGGER2Hilt = LoggerFactory.getLogger(this.getClass());

    @Test
    public void Test() {
        LOGGER2Hilt.trace("  proccedorHiltTest()");

        IFunc2 iFunc2= new StartingHilttestTwo();
      //  IFunc2 iFunc2= new StartingHilttestTree();


        iFunc2. proccedorHiltTest();
    }
}




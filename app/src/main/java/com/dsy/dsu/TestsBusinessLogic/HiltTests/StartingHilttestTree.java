package com.dsy.dsu.TestsBusinessLogic.HiltTests;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class StartingHilttestTree implements  IFunc2 {


    Logger LOGGER2Hilt = LoggerFactory.getLogger(this.getClass());

    @Test
    @Override
    public void proccedorHiltTest() {
        LOGGER2Hilt.trace("  proccedorHiltTest()");
        LOGGER2Hilt.warn("   ");
    }
}



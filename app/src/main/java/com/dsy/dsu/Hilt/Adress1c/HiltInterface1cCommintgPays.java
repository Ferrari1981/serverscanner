package com.dsy.dsu.Hilt.Adress1c;


import android.content.Intent;

import androidx.lifecycle.MutableLiveData;

import dagger.hilt.EntryPoint;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;


@EntryPoint
@InstallIn(SingletonComponent.class)
public interface HiltInterface1cCommintgPays {


   String getHiltCommintgPays( );
}



package com.dsy.dsu.Services;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.content.ServiceConnection;
import android.util.Log;

import com.dsy.dsu.BootAndAsync.BlBootAsync.BusinessLogicActivityBootAndAsync;
import com.dsy.dsu.BootAndAsync.BlBootAsync.ClassBindServicePublish;
import com.dsy.dsu.BootAndAsync.BlBootAsync.CompleteRemoteSyncService;
import com.dsy.dsu.BootAndAsync.BlBootAsync.LogicBinessMainActivity_From_Face_Start;
import com.dsy.dsu.BootAndAsync.MainActivityBootAndAsync;
import com.dsy.dsu.BusinessLogicAll.Permissions.ClassPermissions;
import com.dsy.dsu.Errors.Class_Generation_Errors;

import java.util.Date;

import javax.inject.Inject;
import javax.net.ssl.SSLSocketFactory;

import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.AndroidEntryPoint;
import dagger.hilt.components.SingletonComponent;
import io.reactivex.rxjava3.subjects.Subject;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 *
 *
 */

@AndroidEntryPoint
public class IntentServiceBoot extends IntentService {

    @Inject
    CompleteRemoteSyncService completeRemoteSyncService;

    @Inject
    SSLSocketFactory getsslSocketFactory2;

    public IntentServiceBoot() {
        super("IntentServiceBoot");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("oncreate IntentServiceBoot");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        try {
            if (intent.getAction().contains("IntentServiceBoot.com")) {
                // TODO: 19.01.2024  запуск класса бизнес логики службы Синхроиазции и Обновление ПО
                completeRemoteSyncService.startServiceAsybc(getApplicationContext(),getsslSocketFactory2);
            }

            Log.d(getApplicationContext().getClass().getName(), "\n"
                    + " время: " + new Date() + "\n+" +
                    " Класс в процессе... " + this.getClass().getName() + "\n" +
                    " метод в процессе... " + Thread.currentThread().getStackTrace()[2].getMethodName()+
                     " intent.getAction() " +intent.getAction());
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }

    }




}
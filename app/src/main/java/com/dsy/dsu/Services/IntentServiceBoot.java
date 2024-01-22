package com.dsy.dsu.Services;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.dsy.dsu.BootAndAsync.BlBootAsync.CompleteRemoteSyncService;
import com.dsy.dsu.Errors.Class_Generation_Errors;

import java.util.Date;

import javax.inject.Inject;
import javax.net.ssl.SSLSocketFactory;

import dagger.hilt.android.AndroidEntryPoint;

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




    @Inject
    Integer getHiltPublicId;


    HiltServiceHandler hiltServiceHandler;



    public IntentServiceBoot() {
        super("IntentServiceBoot");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("oncreate IntentServiceBoot");
        hiltServiceHandler=new HiltServiceHandler(getMainLooper());
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        try {




            if (intent.getAction().contains("IntentServiceBootAsync.com")) {
                // TODO: 19.01.2024  запуск класса бизнес логики службы Синхроиазции и Обновление ПО
                completeRemoteSyncService.startServiceAsybc(getApplicationContext(),getsslSocketFactory2, hiltServiceHandler,  getHiltPublicId);

            }else {
                if (intent.getAction().contains("IntentServiceBootUpdatePo.com")) {
                    // TODO: 19.01.2024  запуск класса бизнес логики службы Синхроиазции и Обновление ПО
                    completeRemoteSyncService.startServiceAsybc(getApplicationContext(),getsslSocketFactory2, hiltServiceHandler,  getHiltPublicId);
                }

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




    public class HiltServiceHandler extends Handler {


        public  HiltServiceHandler(Looper looper) {
            super(looper);
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);


            metodOtverNaActivityAsync();

            metodOtverNaActivityPO();



            Log.d(getApplicationContext().getClass().getName(), "\n"
                    + " время: " + new Date() + "\n+" +
                    " Класс в процессе... " + this.getClass().getName() + "\n" +
                    " метод в процессе... " + Thread.currentThread().getStackTrace()[2].getMethodName());
        }

        @Override
        public void dispatchMessage(@NonNull Message msg) {
            super.dispatchMessage(msg);
            Log.d(getApplicationContext().getClass().getName(), "\n"
                    + " время: " + new Date() + "\n+" +
                    " Класс в процессе... " + this.getClass().getName() + "\n" +
                    " метод в процессе... " + Thread.currentThread().getStackTrace()[2].getMethodName());
        }
    }

    private void metodOtverNaActivityPO() {
try{
        Intent intentЗапускаемИзСлужбыДляЛистТАбеля = new Intent();
        intentЗапускаемИзСлужбыДляЛистТАбеля.setAction("Broad_messageAsyncOrUpdatePO");
        Bundle bundleЗапускемBackДанные = new Bundle();
        bundleЗапускемBackДанные.putInt("Значения", 1);
        bundleЗапускемBackДанные.putString("Статус", "3434");///"В процесс"
        intentЗапускаемИзСлужбыДляЛистТАбеля.putExtras(bundleЗапускемBackДанные);
        Log.w(this.getClass().getName(), "   bundleЗапускемBackДанные  " + bundleЗапускемBackДанные);
        LocalBroadcastManager localBroadcastManagerИзСлужбыServiceForAllTabel = LocalBroadcastManager.getInstance(getApplicationContext());
        localBroadcastManagerИзСлужбыServiceForAllTabel.sendBroadcast(intentЗапускаемИзСлужбыДляЛистТАбеля);

        Log.d(getApplicationContext().getClass().getName(), "\n"
                + " время: " + new Date() + "\n+" +
                " Класс в процессе... " + this.getClass().getName() + "\n" +
                " метод в процессе... " + Thread.currentThread().getStackTrace()[2].getMethodName());
    } catch (Exception e) {
        e.printStackTrace();
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
        new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
    }

    }


    private void metodOtverNaActivityAsync() {

  try{

        Intent  intentЗапускаемИзСлужбыДляЛистТАбеля = new Intent();
        intentЗапускаемИзСлужбыДляЛистТАбеля.setAction("Broad_messageAsyncOrUpdateAsync");
        Bundle   bundleЗапускемBackДанные = new Bundle();
        bundleЗапускемBackДанные.putInt("Значения", 15555);
        bundleЗапускемBackДанные.putString("Статус", "3434");///"В процесс"
        intentЗапускаемИзСлужбыДляЛистТАбеля.putExtras(bundleЗапускемBackДанные);
        Log.w(this.getClass().getName(), "   bundleЗапускемBackДанные  " + bundleЗапускемBackДанные);
        LocalBroadcastManager  localBroadcastManagerИзСлужбыServiceForAllTabel = LocalBroadcastManager.getInstance(getApplicationContext());
        localBroadcastManagerИзСлужбыServiceForAllTabel.sendBroadcast(intentЗапускаемИзСлужбыДляЛистТАбеля);

        Log.d(getApplicationContext().getClass().getName(), "\n"
                + " время: " + new Date() + "\n+" +
                " Класс в процессе... " + this.getClass().getName() + "\n" +
                " метод в процессе... " + Thread.currentThread().getStackTrace()[2].getMethodName());
    } catch (Exception e) {
        e.printStackTrace();
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
        new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
    }
    }

}

package com.dsy.dsu.BootAndAsync.BlBootAsync;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;

import com.dsy.dsu.BroadcastRecievers.ClassRegistraAsyncBroadcast;
import com.dsy.dsu.BusinessLogicAll.Class_Connections_Server;
import com.dsy.dsu.BusinessLogicAll.CreateFolderBinatySave.ClassCreateFolderBinatyMatrilal;
import com.dsy.dsu.BusinessLogicAll.CreateFolderBinatySave.ClassCreateFolderCommitPays1C;
import com.dsy.dsu.Dashboard.MainActivity_Dashboard;
import com.dsy.dsu.Errors.Class_Generation_Errors;
import com.dsy.dsu.Errors.MainActivity_Errors;
import com.dsy.dsu.Passwords.MainActivityPasswords;
import com.dsy.dsu.R;
import com.dsy.dsu.Services.ServiceUpdatePoОбновлениеПО;
import com.dsy.dsu.Services.Service_For_Remote_Async_Binary;
import com.google.android.material.navigation.NavigationView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.ConcurrentModificationException;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.net.ssl.SSLSocketFactory;

import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

@Module
@InstallIn(SingletonComponent.class)
public class CompleteRemoteSyncService {



    private Service_For_Remote_Async_Binary.LocalBinderAsync localBinderAsync;//TODO нова\
    private ServiceUpdatePoОбновлениеПО.localBinderОбновлениеПО localBinderОбновлениеПО;//TODO нова




    private Subject<Service_For_Remote_Async_Binary.LocalBinderAsync> AsyncPublish;
    private Subject<ServiceUpdatePoОбновлениеПО.localBinderОбновлениеПО> UpdatePublish;



    private ServiceConnection connectionОбновлениеПО;
    private ServiceConnection connectionAsync;


    private Integer ФиналПолучаемРазницуМеждуДатами = 0;



    private SharedPreferences preferences;

    private String РежимЗапускаСинхронизации = new String();


      private  Context context;

    private String success_users;
    private String success_login;
    private String date_update;

    private  Boolean СтатусРаботыСервера;


    public  @Inject CompleteRemoteSyncService(@ApplicationContext Context context) {
        //TODO сомо имя json
        this.context=context;

        System.out.println(" CompleteRemoteSyncService  context "+context  );
    }

    public void startServiceAsybc(@NonNull Context context,@NonNull SSLSocketFactory getsslSocketFactory2) {
        try {
            // TODO: 14.08.2023 вызов кода ПОльзовательский
            preferences =context. getSharedPreferences("sharedPreferencesХранилище", Context.MODE_MULTI_PROCESS);

            РежимЗапускаСинхронизации = preferences.getString("РежимЗапускаСинхронизации","");


            // TODO: 29.09.2023 создаем  Init
           МетодИнициализацияОбновленеиПО();

        МетодИнициализацияMessager();

          МетодДляСлушательБоковойПанелиAsyncApp();


            // TODO: 02.10.2023 публикации  вторая часть

                 metodBindServiceAsyncPublish();

            // TODO: 14.08.2023 методЗапукска Синхрониазйиии
          МетодБиндингаRemoteAsync();

           МетодБиндингаОбновлениеПО();


            Log.d(context.getClass().getName(), "\n"
                    + " время: " + new Date() + "\n+" +
                    " Класс в процессе... " + this.getClass().getName() + "\n" +
                    " метод в процессе... " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n");
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }



    public void metodBindServiceAsyncPublish() {
        // TODO: 02.10.2023  init
        try{
            AsyncPublish = PublishSubject.create();
            AsyncPublish.filter(fil->fil.isBinderAlive()) .publish();
            UpdatePublish = PublishSubject.create();
            UpdatePublish.filter(fil->fil.isBinderAlive()) .publish();
            // TODO: 18.12.2023
            Observable.combineLatest(AsyncPublish, UpdatePublish,
                            new BiFunction<Service_For_Remote_Async_Binary.LocalBinderAsync, ServiceUpdatePoОбновлениеПО.localBinderОбновлениеПО, Object>() {
                                @Override
                                public Object apply(Service_For_Remote_Async_Binary.LocalBinderAsync localBinderAsync,
                                                    ServiceUpdatePoОбновлениеПО.localBinderОбновлениеПО localBinderОбновлениеПО) throws Throwable {

                                    Flowable.fromAction(new Action() {
                                                @Override
                                                public void run() throws Throwable {

                                                    // TODO: 14.08.2023 создаем папку для BinaryFile Save
                                                    new ClassCreateFolderBinatyMatrilal(context).МетодCreateFoldersBinaty();

                                                    // TODO: 14.08.2023 создаем папку для BinaryFile CommitPay1C Соласования
                                                    new ClassCreateFolderCommitPays1C(context).МетодCreateFoldersBinaty();



                                                    // TODO: 14.08.2023  Запускаем Код До Сиинхрониазщции
                                                  МетодОпределениеКогдаПоследнийРазЗаходилПользователь();

                                                     МетодПингаКСереруЗапущенЛиСерерИлиНет();

                                                     medodVisiblePrograssbar(true);

                    Log.d(this.getClass().getName(), "\n" + " class "
                            + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                            " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                            " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" +
                            " localBinderAsync "+localBinderAsync.isBinderAlive()+ " " +
                            " localBinderОбновлениеПО "  + localBinderОбновлениеПО.isBinderAlive() );


                                                    // TODO: 03.10.2023 ЕСЛИ ЕСТЬ ПАРОЛЬ И ЛОГИН ПО ЗАХОД ЕСЛИ НЕТ ТО ПАОЛДЬБ
                                                    if (      date_update != null && success_users != null && success_login != null
                                                            && ФиналПолучаемРазницуМеждуДатами < 20  ) {


                                                        new SuccessAsynsStartingUpdatrPO().startingAsyncForUpSoft();

                                                        Log.d(this.getClass().getName(), "\n"
                                                                + " время: " + new Date() + "\n+" +
                                                                " Класс в процессе... " + this.getClass().getName() + "\n" +
                                                                " метод в процессе... " + Thread.currentThread().getStackTrace()[2].getMethodName()
                                                                + " localBinderОбновлениеПО.isBinderAlive() " + localBinderОбновлениеПО.isBinderAlive());

                                                    }else {

                                                        // TODO: 28.04.2023 НЕт Анутифтикации Пароль
                                                      методПереходНаActivityPassword(СтатусРаботыСервера );

                                                        Log.d(this.getClass().getName(), "  ФиналПолучаемРазницуМеждуДатами  " + ФиналПолучаемРазницуМеждуДатами
                                                                + " date_update " + date_update + " СтатусРаботыСервера " + СтатусРаботыСервера);

                                                    }




                                                }
                                            }).subscribeOn(Schedulers.single())
                                            .observeOn(AndroidSchedulers.mainThread())
                                            .doOnError(new Consumer<Throwable>() {
                                                @Override
                                                public void accept(Throwable throwable) throws Throwable {
                                                    throwable.printStackTrace();
                                                    Log.e(this.getClass().getName(), "Ошибка " + throwable + " Метод :"
                                                            + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                                                            + Thread.currentThread().getStackTrace()[2].getLineNumber());
                                                    new Class_Generation_Errors(context)
                                                            .МетодЗаписиВЖурналНовойОшибки(throwable.toString(), this.getClass().getName(),
                                                                    Thread.currentThread().getStackTrace()[2].getMethodName(),
                                                                    Thread.currentThread().getStackTrace()[2].getLineNumber());
                                                }
                                            })
                                            .doOnComplete(new Action() {
                                                @Override
                                                public void run() throws Throwable {

                                                    Log.d(getApplicationContext().getClass().getName(), "\n"
                                                            + " время: " + new Date() + "\n+" +
                                                            " Класс в процессе... " + this.getClass().getName() + "\n" +
                                                            " метод в процессе... " + Thread.currentThread().getStackTrace()[2].getMethodName()
                                                            + " ФиналПолучаемРазницуМеждуДатами " + ФиналПолучаемРазницуМеждуДатами);

                                                }
                                            }).subscribe();



                                    return localBinderAsync;
                                }
                            })
                    .doOnError(new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Throwable {
                            throwable.printStackTrace();
                            Log.e(this.getClass().getName(), "Ошибка " + throwable + " Метод :"
                                    + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
                            new Class_Generation_Errors(getApplicationContext())
                                    .МетодЗаписиВЖурналНовойОшибки(throwable.toString(), this.getClass().getName(),
                                            Thread.currentThread().getStackTrace()[2].getMethodName(),
                                            Thread.currentThread().getStackTrace()[2].getLineNumber());
                        }
                    }).filter(fil->fil!=null).subscribe();
            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" +
                    " localBinderAsync ");
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :"
                    + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }


    //TODO succeess
    class SuccessAsynsStartingUpdatrPO{
        void startingAsyncForUpSoft(){
            try{
                // TODO: 03.10.2023 запуск Анализ По
                if (      СтатусРаботыСервера == true  ) {


                    // TODO: 03.10.2023
                    Boolean    ФлагЗапускаAsyncБезUpdatePO=        logicBinessMainActivity_from_face_start.metodAsyncUpdatePO();
                    // TODO: 03.10.2023  запускаем синхрониазцию
                    Long ФинальныйРезультатAsyncBackgroud = null;

                    if (ФлагЗапускаAsyncБезUpdatePO==true) {
                        // TODO: 03.10.2023 Запуск Синхронизации
                        ФинальныйРезультатAsyncBackgroud = localBinderAsync.getService().metodStartingSync(  handlerAsync,getApplicationContext());


                        // TODO: 27.10.2022  МетодАнализа Заблокирован или Нет пользователь и запуск Программы
                        Boolean СтатусБлокировкиПользотеляТекущего=   logicBinessMainActivity_from_face_start.getBlockCurrentUser();

                        if (СтатусБлокировкиПользотеляТекущего==false) {
                            // TODO: 03.10.2023 КОНЕЦ
                            logicBinessMainActivity_from_face_start.   metoEndingAsynsSharedPreferences();
                            logicBinessMainActivity_from_face_start.  metoEndingAsynsRetryBroadCastResiver();
                            logicBinessMainActivity_from_face_start.metodVisiblePrograssbar();
                            logicBinessMainActivity_from_face_start.metoEndingAsynsDashboard();
                        } else {
                            logicBinessMainActivity_from_face_start.     МетодСообщениеПользоватлюЧтоНЕтИнтренета("Режим: (пользователь заблок.)");

                            // TODO: 28.04.2023 НЕт Анутифтикации Пароль
                            new ClassNotPassword(). методПереходНаActivityPassword(СтатусРаботыСервера );
                        }


                        // TODO: 03.10.2023
                        Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" +
                                " ФинальныйРезультатAsyncBackgroud  Запуск Синхронизации "+ФинальныйРезультатAsyncBackgroud);
                    }




                }else {
                    logicBinessMainActivity_from_face_start.     МетодСообщениеПользоватлюЧтоНЕтИнтренета("Режим: (офлайн)");

                    // TODO: 03.10.2023 КОНЕЦ
                    logicBinessMainActivity_from_face_start.   metoEndingAsynsSharedPreferences();
                    logicBinessMainActivity_from_face_start.  metoEndingAsynsRetryBroadCastResiver();
                    logicBinessMainActivity_from_face_start.metodVisiblePrograssbar();
                    logicBinessMainActivity_from_face_start.metoEndingAsynsDashboard();
                }







                Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                        " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                        " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" +
                        " localBinderAsync ");
            } catch (Exception e) {
                e.printStackTrace();
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :"
                        + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                        + Thread.currentThread().getStackTrace()[2].getLineNumber());
                new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                        Thread.currentThread().getStackTrace()[2].getLineNumber());
            }
        }


    }//TODO  end SuccessAsynsStartingUpdatrPO



    private void методПереходНаActivityPassword(@NonNull boolean СтатусРаботыСервера ) {
        try {
            Intent Интент_ЗапускаетFaceApp=new Intent();
            Интент_ЗапускаетFaceApp.setClass(c, MainActivityPasswords.class);
            Интент_ЗапускаетFaceApp.setAction("MainActivityPasswords.class");
            startActivity(Интент_ЗапускаетFaceApp);//tso
            finishAfterTransition();


            Log.d(context.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber());

        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }

    }


























































    // TODO: 19.01.2024   /////// МЕТОД КОГДА ЗАХОДИЛ ПОСЛЬДНИЙ РАЗ ПОЛЬЗОВАТЛЬ

    public void МетодОпределениеКогдаПоследнийРазЗаходилПользователь() {
        Cursor Курсор_7ДнейЗаходаПользователя = null;
        try {
            Uri uri = Uri.parse("content://com.dsy.dsu.providerdatabasecurrentoperations/" + "successlogin" + "");
            ContentResolver contentResolver=context. getContentResolver();
            Курсор_7ДнейЗаходаПользователя =      contentResolver.query(uri,new String[]{},
                    new String(" SELECT *  FROM    successlogin   ORDER BY id  LIMIT   1  "),
                    new String[]{},null);///   "  //// SELECT * FROM  viewtabel WHERE year_tabels=?  AND month_tabels=?  AND cfo=?  AND status_send!=?
            Log.d(this.getClass().getName(), "  Курсор_7ДнейЗаходаПользователя " +  Курсор_7ДнейЗаходаПользователя);


            if (Курсор_7ДнейЗаходаПользователя.getCount() > 0) {/////ПРОВЕРЯЕМ ЕСЛИ ПО ДАННОМУ ID UUID ЗАПОЛНЕ ЛИ ОН
                Курсор_7ДнейЗаходаПользователя.moveToFirst();
                success_users =
                        Курсор_7ДнейЗаходаПользователя.getString(Курсор_7ДнейЗаходаПользователя.getColumnIndex("success_users")).trim();
                success_login =
                        Курсор_7ДнейЗаходаПользователя.getString(Курсор_7ДнейЗаходаПользователя.getColumnIndex("success_login")).trim();
                date_update =
                        Курсор_7ДнейЗаходаПользователя.getString(Курсор_7ДнейЗаходаПользователя.getColumnIndex("date_update")).trim();

                Integer   ПолученныйПубличныйID= Курсор_7ДнейЗаходаПользователя.getInt(Курсор_7ДнейЗаходаПользователя.getColumnIndex("id"));

                Log.d(this.getClass().getName(), "  success_users  " + success_users + "  " +
                        "    success_login  " + success_login + " date_update " + date_update);

                // TODO: 13.08.2023 дата из табции
                Date ДатаSucceslogin =
                        new android.icu.text.SimpleDateFormat("yyyy-MM-dd",
                                new Locale("ru")).parse(date_update);//TODO "2023-08-01 19:00:59.781"

                Log.d(this.getClass().getName(), "  ДатаSucceslogin  " + ДатаSucceslogin);


                // TODO: 13.08.2023 Дата NOW !!!!!
                Date ДатаNOW = Calendar.getInstance().getTime();
                DateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd", new Locale("ru"));//"yyyy-MM-dd'T'HH:mm:ss'Z'
                String ДатСегодняДатаNOW = dateFormat.format(ДатаNOW);
                ДатаNOW = dateFormat.parse(ДатСегодняДатаNOW);
                Log.d(this.getClass().getName(), "  ДатаNOW  " + ДатаNOW);


                ////TODO само сравнивание дат на 7 дней назад
                long РазницаМеждуДатамиNowИДатыИзБазы =
                        ДатаNOW.getTime()
                                - ДатаSucceslogin.getTime(); //локальное сравнение дата из базы андройда и дат сегодня
                ///////////
                ФиналПолучаемРазницуМеждуДатами = Integer.parseInt("" + (TimeUnit.DAYS.convert(РазницаМеждуДатамиNowИДатыИзБазы, TimeUnit.MILLISECONDS)));

                Log.d(this.getClass().getName(), "  ФиналПолучаемРазницуМеждуДатами  " + ФиналПолучаемРазницуМеждуДатами);

            }
            // TODO: 13.08.2023
            if (Курсор_7ДнейЗаходаПользователя != null) {
                Курсор_7ДнейЗаходаПользователя.close();///
            }
            Log.d(this.getClass().getName(), "  ФиналПолучаемРазницуМеждуДатами  " + ФиналПолучаемРазницуМеждуДатами);

        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
        }


    }

    ///////todo ФИНАЛЬНЫЙ МЕТОД КТО ВХОДИЛ ДО 7 ДНЕЙ ИЛИ ПОСЫЛАЕМ НА АУНТИФИКАЦИЮ
    Boolean metodAsyncUpdatePO() {
        Boolean ФлагЗапускаAsyncБезUpdatePO=false;
        try {//////FLAG_ACTIVITY_SINGLE_TOP


            ФлагЗапускаAsyncБезUpdatePO =
                    localBinderОбновлениеПО.getService().МетодГлавныйОбновленияПОДоAsync(true, activity, handlerUpdatePO);
            Log.i(this.getClass().getName(), " Атоманически установкаОбновление ПО " +
                    Thread.currentThread().getStackTrace()[2].getMethodName() + " время " + new Date().toLocaleString());
            Log.i(this.getClass().getName(), "R.id.item_async_updatepo  "
                    + Thread.currentThread().getStackTrace()[2].getMethodName() + " время " + new Date().toLocaleString() +
                    "ФлагЗапускаAsyncБезUpdatePO " + ФлагЗапускаAsyncБезUpdatePO);



            Log.d(getApplicationContext().getClass().getName(), "\n"
                    + " время: " + new Date() + "\n+" +
                    " Класс в процессе... " + this.getClass().getName() + "\n" +
                    " метод в процессе... " + Thread.currentThread().getStackTrace()[2].getMethodName()
                    + " localBinderОбновлениеПО.isBinderAlive() " + localBinderОбновлениеПО.isBinderAlive() +
                    " date_update " + date_update + " success_users "+success_users + " success_login " +success_login  +
                    " ФиналПолучаемРазницуМеждуДатами "+ФиналПолучаемРазницуМеждуДатами  +
                    "  СтатусРаботыСервера "+СтатусРаботыСервера);

        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }

        return  ФлагЗапускаAsyncБезUpdatePO;
    }

    @SuppressLint("SuspiciousIndentation")
    public void МетодПингаКСереруЗапущенЛиСерерИлиНет() {
        try {
            // TODO: 16.12.2021 НЕПОСРЕДСТВЕННЫЙ ПИНГ СИСТЕНМ ИНТРЕНАТ НА НАЛИЧЕНИ СВАЗИ С БАЗОЙ SQL SERVER
            СтатусРаботыСервера =
                    new Class_Connections_Server(getApplicationContext()).
                            МетодПингаСервераРаботаетИлиНет(getApplicationContext(),getsslSocketFactory2);
            Log.d(this.getClass().getName(), "  СтатусРаботыСервера " + СтатусРаботыСервера);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }

    public void medodVisiblePrograssbar(@NonNull Boolean ФлагПрограсБАр) {


        try {
            if (СтатусРаботыСервера == true) {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressbarbootandasync.setIndeterminate(ФлагПрограсБАр);
                        progressbarbootandasync.requestLayout();
                        progressbarbootandasync.refreshDrawableState();
                    }
                });

            }

            Log.d(getApplicationContext().getClass().getName(), "\n"
                    + " время: " + new Date() + "\n+" +
                    " Класс в процессе... " + this.getClass().getName() + "\n" +
                    " метод в процессе... " + Thread.currentThread().getStackTrace()[2].getMethodName()
                    + " localBinderОбновлениеПО.isBinderAlive() " + localBinderОбновлениеПО.isBinderAlive() +
                    "  СтатусРаботыСервера " + СтатусРаботыСервера);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }
    void metodVisiblePrograssbar() {
        try {//////FLAG_ACTIVITY_SINGLE_TOP
            logicBinessMainActivity_from_face_start.   medodVisiblePrograssbar(false);

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











    void metoEndingAsynsDashboard() {
        try {
            Intent Интент_ЗапускаетBootAndAsync = new Intent();
            Интент_ЗапускаетBootAndAsync.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            Интент_ЗапускаетBootAndAsync.setAction("MainActivity_Dashboard.class");
            Интент_ЗапускаетBootAndAsync.setClass(getApplicationContext(), MainActivity_Dashboard.class);

            Bundle bundleBinderUpdate=new Bundle();
            bundleBinderUpdate.putBinder("callbackbinderdashbord", localBinderОбновлениеПО);
            Интент_ЗапускаетBootAndAsync.putExtras(bundleBinderUpdate);


            startActivity(Интент_ЗапускаетBootAndAsync);//tso
            finishAfterTransition();
            Log.d(this.getClass().getName(), "  ФиналПолучаемРазницуМеждуДатами  " + ФиналПолучаемРазницуМеждуДатами
                    + " date_update " + date_update + " СтатусРаботыСервера " + СтатусРаботыСервера);


        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }







    void metoEndingAsynsSharedPreferences() {
        try {

            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("PublicId", ПолученныйПубличныйID);
            editor.apply();

            Log.d(this.getClass().getName(), "  ФиналПолучаемРазницуМеждуДатами  " + ФиналПолучаемРазницуМеждуДатами
                    + " date_update " + date_update + " СтатусРаботыСервера " + СтатусРаботыСервера);

        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }


    void metoEndingAsynsRetryBroadCastResiver() {
        try {
            // TODO: 07.10.2023
            ClassRegistraAsyncBroadcast classRegistraAsyncBroadcast =new ClassRegistraAsyncBroadcast();;
            classRegistraAsyncBroadcast.metodSendBroadCastFroAsyns(getApplicationContext(),"KEEP");
            Log.d(getApplicationContext().getClass().getName(), "\n"
                    + " время: " + new Date()+"\n+" +
                    " Класс в процессе... " +  this.getClass().getName()+"\n"+
                    " метод в процессе... " + Thread.currentThread().getStackTrace()[2].getMethodName());


        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }






    private void МетодСообщениеПользоватлюЧтоНЕтИнтренета(String КакойРежимОтоброжать) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast toast = Toast.makeText(getApplicationContext(), КакойРежимОтоброжать, Toast.LENGTH_LONG);
                toast.setGravity(Gravity.BOTTOM, 0, 40);
                toast.show();
            }
        });
    }


























    @SuppressLint("Range")
    Boolean getBlockCurrentUser() {
        Boolean СтатусБлокировкиПользотеляТекущего = true;
        try {

            Uri uri = Uri.parse("content://com.dsy.dsu.providerdatabasecurrentoperations/" + "chat_users" + "");
            ContentResolver contentResolver= getContentResolver();
            Cursor  суксорЗаблокированыхПользотель =      contentResolver.query(uri,new String[]{},
                    new String(" SELECT locked  FROM chat_users  WHERE _id= ?  ORDER BY date_update DESC "),
                    new String[]{String.valueOf(ПолученныйПубличныйID)},null);///   "  //// SELECT * FROM  viewtabel WHERE year_tabels=?  AND month_tabels=?  AND cfo=?  AND status_send!=?
            Log.d(this.getClass().getName(), "  суксорЗаблокированыхПользотель " +  суксорЗаблокированыхПользотель);


            Log.d(this.getClass().getName(), "суксорЗаблокированыхПользотель " + суксорЗаблокированыхПользотель);



            if (суксорЗаблокированыхПользотель.getCount() > 0) {
                суксорЗаблокированыхПользотель.moveToFirst();
                String СтатусБлокировки = суксорЗаблокированыхПользотель.getString(суксорЗаблокированыхПользотель.getColumnIndex("locked"));
                СтатусБлокировкиПользотеляТекущего = Boolean.parseBoolean(СтатусБлокировки.toString());

            }
            if (суксорЗаблокированыхПользотель != null) {
                суксорЗаблокированыхПользотель.close();
            }
            // TODO: 28.07.2022
            Log.d(this.getClass().getName(), " СтатусБлокировкиПользотеляТекущего " + СтатусБлокировкиПользотеляТекущего);

        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
        return  СтатусБлокировкиПользотеляТекущего;
    }









    public void МетодБиндингаRemoteAsync() {
        try {
            // TODO: 28.04.2023  запускаем Гланвную Синхрониазцию

            if (ФлагБылиИлиНЕбылПоворотЭкрана == false) {
                //  Intent intentОбноразоваяСинхронизациия = new Intent(getApplicationContext(), Service_For_Remote_Async.class);
                Intent intentAsync = new Intent(getApplicationContext(), Service_For_Remote_Async_Binary.class);
                intentAsync.setAction("com.StartingAsyncMainBackgroud");
                connectionAsync = new ServiceConnection() {
                    @Override
                    public void onServiceConnected(ComponentName name, IBinder service) {
                        try {
                            if (service.isBinderAlive()) {
                                // TODO: 29.09.2023
                                localBinderAsync = (Service_For_Remote_Async_Binary.LocalBinderAsync) service;

                                // notify the Observable that the value just change
                                AsyncPublish.onNext(localBinderAsync);


                                // TODO: 25.03.2023
                                Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                        " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                        " line " + Thread.currentThread().getStackTrace()[2].getLineNumber());

                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
                            new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                                    Thread.currentThread().getStackTrace()[2].getLineNumber());
                        }
                    }


                    @Override
                    public void onServiceDisconnected(ComponentName name) {
                        localBinderAsync = null;
                        Log.d(getApplicationContext().getClass().getName().toString(), "\n"
                                + "onServiceConnected  одноразовая  messengerActivity  ");
                    }

                    @Override
                    public void onBindingDied(ComponentName name) {
                        ServiceConnection.super.onBindingDied(name);
                    }

                    @Override
                    public void onNullBinding(ComponentName name) {
                        ServiceConnection.super.onNullBinding(name);
                    }
                };


                Boolean asBoolenCbyСинхронная = bindService(intentAsync,
                        connectionAsync, Context.BIND_AUTO_CREATE);

            }
            // TODO: 28.04.2023
            Log.d(this.getClass().getName(), "\n" + " class " +
                    Thread.currentThread().getStackTrace()[2].getClassName()
                    + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"  );
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
            Log.d(this.getClass().getName(), "  Полусаем Ошибку e.toString() " + e.toString());
        }

    }

    private void методЗапускаОбновлениеПо(@NonNull Boolean ФлагПОказыватьИлиНЕт) {
        try {
            localBinderОбновлениеПО.getService().МетодГлавныйОбновленияПО(ФлагПОказыватьИлиНЕт, activity, handlerUpdatePO);

            Log.i(this.getClass().getName(), " Атоманически установкаОбновление ПО " +
                    Thread.currentThread().getStackTrace()[2].getMethodName() + " время " + new Date().toLocaleString());
            Log.i(this.getClass().getName(), "R.id.item_async_updatepo  "
                    + Thread.currentThread().getStackTrace()[2].getMethodName() + " время " + new Date().toLocaleString());

        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }














    // TODO: 02.09.2021  метод Визуализация
    public void МетодИнициализацияMessager() {
        try {

            handlerAsync = new Handler(Looper.getMainLooper()) {


                @Override
                public void handleMessage(@NonNull Message msg) {
                    super.handleMessage(msg);
                }

                @Override
                public void dispatchMessage(@NonNull Message msg) {
                    super.dispatchMessage(msg);

                    try {
                        Bundle bundleCallsBackAsynsService = msg.getData();
                        switch (msg.what) {
                            case 2:// процеессе
                                МетодВизуализацииСинхронизации(bundleCallsBackAsynsService);
                                break;


                        }
                        progressbarbootandasync.requestLayout();
                        progressbarbootandasync.refreshDrawableState();
                        Log.d(this.getClass().getName(), "\n" + " class " +
                                Thread.currentThread().getStackTrace()[2].getClassName()
                                + "\n" +
                                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"
                                + " msg.what " + msg.what + "bundleCallsBackAsynsService " + bundleCallsBackAsynsService);
                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                                + Thread.currentThread().getStackTrace()[2].getLineNumber());
                        new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                                this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                                Thread.currentThread().getStackTrace()[2].getLineNumber());
                    }


                }
            };
            Log.i(getApplicationContext().getClass().getName(), " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n");
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }
    // TODO: 04.10.2023
    public void МетодДляСлушательБоковойПанелиAsyncApp() {
        // TODO: 06.04.2022
        try {
            drawerLayoutAsync.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
                @Override
                public void onDrawerOpened(View drawerView) {
                    Drawable drawable = getResources().getDrawable(R.mipmap.icon_dsu1_for_asyncapp_close_naviga);///
                    navigationViewAsyncApp.setVisibility(View.VISIBLE);
                    super.onDrawerOpened(drawerView);
                }
                @Override
                public void onDrawerClosed(View drawerView) {
                    Drawable drawable = getResources().getDrawable(R.drawable.icon_dsu1_async_asynprograssbar);///
                    navigationViewAsyncApp.setVisibility(View.GONE);
                    super.onDrawerClosed(drawerView);
                }
            });
            navigationViewAsyncApp.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        // TODO: 06.04.2022 Запускаем ОШибки
                        case R.id.one:
                            item.setChecked(true);
                            Log.w(getPackageName().getClass().getName(), "item.getItemId() Посмотреть ошибки   " + item.getItemId() + "\n");//////////
                            try {
                                Intent Интент_Меню = new Intent(activity, MainActivity_Errors.class);
                                Интент_Меню.setAction("com.CallBackBootAndAsync");
                                Интент_Меню.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);//////FLAG_ACTIVITY_SINGLE_TOP

                                startActivity(Интент_Меню);

                                Log.i(this.getClass().getName(),  "R.id.one "+Thread.currentThread().getStackTrace()[2].getMethodName()+
                                        " время " +new Date().toLocaleString() );
                            } catch (Exception e) {
                                e.printStackTrace();
                                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :"
                                        + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                                        + Thread.currentThread().getStackTrace()[2].getLineNumber());
                                new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                                        this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                                        Thread.currentThread().getStackTrace()[2].getLineNumber());
                            }

                            break;
                        // TODO: 06.04.2022 ЗапускаемОбновление ПО
                        case R.id.item_async_updatepo:
                            item.setChecked(true);
                            try {
// TODO: 10.07.2023  запуск обновление ПО
                                методЗапускаОбновлениеПо(false);
                                Log.i(this.getClass().getName(),  " Атоманически установкаОбновление ПО "+ Thread.currentThread().getStackTrace()[2].getMethodName()+ " время " +new Date().toLocaleString() );
                                Log.w(getPackageName().getClass().getName(), "item.getItemId() Посмотреть ошибки   " + item.getItemId() + "\n");//////////
                                Log.i(this.getClass().getName(),  "R.id.item_async_updatepo  "+Thread.currentThread().getStackTrace()[2].getMethodName()+ " время " +new Date().toLocaleString() );
                            } catch (Exception e) {
                                e.printStackTrace();
                                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                                        + Thread.currentThread().getStackTrace()[2].getLineNumber());
                                new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                                        Thread.currentThread().getStackTrace()[2].getLineNumber());
                            }
                            break;

                    }
                    if (drawerLayoutAsync.isDrawerOpen(Gravity.LEFT)) {
                        drawerLayoutAsync.closeDrawer(Gravity.LEFT);
                    }
                    return true;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
        // TODO: 04.04.2022
    }


    // TODO: 02.09.2021  метод Визуализация
    public void МетодИнициализацияОбновленеиПО() {
        try {

            handlerUpdatePO = new Handler(Looper.getMainLooper()) {


                @Override
                public void handleMessage(@NonNull Message msg) {
                    super.handleMessage(msg);
                }

                @Override
                public void dispatchMessage(@NonNull Message msg) {
                    super.dispatchMessage(msg);

                    try {
                        Bundle bundleCallsBackAsynsService = msg.getData();
                        if (msg.what==40){
                            Integer ЛокальнаяВерсияПОСравнение = msg.arg1;
                            Toast toast = Toast.makeText(getApplicationContext(), "Последняя версия ПО !!! " +"("+ЛокальнаяВерсияПОСравнение.toString()+")", Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.BOTTOM |Gravity.CENTER_HORIZONTAL, 50, 0);
                            toast.show();
                        }

                        Log.d(this.getClass().getName(), "\n" + " class " +
                                Thread.currentThread().getStackTrace()[2].getClassName()
                                + "\n" +
                                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"
                                + " msg.what " + msg.what + "bundleCallsBackAsynsService " + bundleCallsBackAsynsService);
                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                                + Thread.currentThread().getStackTrace()[2].getLineNumber());
                        new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                                this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                                Thread.currentThread().getStackTrace()[2].getLineNumber());
                    }


                }
            };
            Log.i(getApplicationContext().getClass().getName(), " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n");
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }

    private void МетодВизуализацииСинхронизации(@NonNull Bundle bundleCallsBackAsynsService) {
        try {
            if (progressbarbootandasync.isAttachedToWindow()) {

                Integer ПроцентыNew = bundleCallsBackAsynsService.getInt("Проценны", 0);
                String ИмяТаблица = bundleCallsBackAsynsService.getString("имятаблицы", "");
                Integer MaxКоличествоСТрочеек = bundleCallsBackAsynsService.getInt("maxtables", 0);
                Integer CurrentPotionСТрочеек = bundleCallsBackAsynsService.getInt("currentposition", 0);

                if (CurrentPotionСТрочеек > 0) {
                    progressbarbootandasync.setIndeterminate(false);
                }

                progressbarbootandasync.setMax(MaxКоличествоСТрочеек);
                CurrentPotionСТрочеек = CurrentPotionСТрочеек + 1;
                if (CurrentPotionСТрочеек >= progressbarbootandasync.getProgress()) {
                    progressbarbootandasync.setProgress(CurrentPotionСТрочеек, true);
                    progressbarbootandasync.setProgressTintMode(PorterDuff.Mode.DARKEN);
                    // TODO: 14.08.2023
                    Integer secondaryProgres = CurrentPotionСТрочеек;
                    secondaryProgres++;
                    secondaryProgres++;
                    progressbarbootandasync.setSecondaryProgress(secondaryProgres);
                    progressbarbootandasync.setSecondaryProgressTintMode(PorterDuff.Mode.DARKEN);


                }
                Log.d(this.getClass().getName(), "\n" + " class " +
                        Thread.currentThread().getStackTrace()[2].getClassName()
                        + "\n" +
                        " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                        " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"
                        + " progressbarbootandasync" + progressbarbootandasync.getProgress());

            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
        }

    }





    public void МетодБиндингаОбновлениеПО() {
        try {
            connectionОбновлениеПО = new ServiceConnection() {
                @Override
                public void onServiceConnected(ComponentName name, IBinder service) {
                    try {
                        if (service.isBinderAlive()) {
                            // TODO: 28.07.2023  Update
                            localBinderОбновлениеПО = (ServiceUpdatePoОбновлениеПО.localBinderОбновлениеПО) service;

                            // notify the Observable that the value just change
                            UpdatePublish.onNext(localBinderОбновлениеПО);

                        }

                        Log.d(getApplicationContext().getClass().getName(), "\n"
                                + " время: " + new Date() + "\n+" +
                                " Класс в процессе... " + this.getClass().getName() + "\n" +
                                " метод в процессе... " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n"
                                + "localBinderОбновлениеПО " + localBinderОбновлениеПО);

                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                        new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                                this.getClass().getName(),
                                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                    }
                }


                @Override
                public void onServiceDisconnected(ComponentName name) {
                    try {
                        localBinderОбновлениеПО = null;
                        Log.i(getApplicationContext().getClass().getName(), "    onServiceDisconnected  binder.isBinderAlive()");
                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                        new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                                this.getClass().getName(),
                                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                    }
                }
            };
            Intent intentЗапускСлужбыОбновлениеПО = new Intent(getApplicationContext(), ServiceUpdatePoОбновлениеПО.class);
            intentЗапускСлужбыОбновлениеПО.setAction("com.ServiceUpdatePoОбновлениеПО");
            Boolean asBoolenОбновлениеПО = bindService(intentЗапускСлужбыОбновлениеПО, connectionОбновлениеПО, Context.BIND_AUTO_CREATE);

            // TODO: 28.04.2023
            Log.d(this.getClass().getName(), "\n" + " class " +
                    Thread.currentThread().getStackTrace()[2].getClassName()
                    + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" + " asBoolenОбновлениеПО " + asBoolenОбновлениеПО);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
            Log.d(this.getClass().getName(), "  Полусаем Ошибку e.toString() " + e.toString());
        }

    }


    public void boundserviceexit() {
        try {
            if (connectionОбновлениеПО!=null) {
                unbindService(connectionОбновлениеПО);
            }

            if (connectionAsync!=null) {
                unbindService(connectionAsync);
            }

            Log.d(this.getClass().getName(), "  ФиналПолучаемРазницуМеждуДатами  " + ФиналПолучаемРазницуМеждуДатами
                    + " date_update " + date_update + " СтатусРаботыСервера " + СтатусРаботыСервера);

        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(getApplicationContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }
    // TODO: 29.09.2023  метод зарцска синхронизации ВИЗУАЛЬНОЙ







































    // TODO: 19.01.2024 END CLASS
}
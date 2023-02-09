package com.sous.server.MODEL;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;


import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.functions.Action;


public class ContentProviderServer extends android.content.ContentProvider {
    private   UriMatcher uriMatcherДЛяПровайдераКонтентБазаДанных;
    private SQLiteDatabase Create_Database_СамаБАзаSQLite;
    private AsyncTaskLoader<?> asyncTaskLoader;
    private Handler handler;
    private Integer ТекущаяСтрокаПриДОбавлениииURL=0;
    private  CopyOnWriteArrayList<String> ИменаТаблицыОтАндройда;
    private Long version=0l;
    public ContentProviderServer() throws InterruptedException {
        try{
            ИменаТаблицыОтАндройда=new CopyOnWriteArrayList<>();
            ИменаТаблицыОтАндройда.add("errordsu1");
            ИменаТаблицыОтАндройда.add("tablescannerandroid");
            ИменаТаблицыОтАндройда.add("tablescannerpublic");
            Log.d(this.getClass().getName(),  " ContentProviderServer" +uriMatcherДЛяПровайдераКонтентБазаДанных );
            Log.d(this.getClass().getName(), " ИменаТаблицыОтАндройда "+ИменаТаблицыОтАндройда );
            uriMatcherДЛяПровайдераКонтентБазаДанных=new UriMatcher(ИменаТаблицыОтАндройда.size());
            ИменаТаблицыОтАндройда.forEach(new Consumer<String>() {
                @Override
                public void accept(String ЭлементТаблица) {
                    uriMatcherДЛяПровайдераКонтентБазаДанных.addURI("com.sous.server.providerserver",ЭлементТаблица.toString(),ТекущаяСтрокаПриДОбавлениииURL);
                    Log.d(this.getClass().getName(), " ЭлементТаблица "+ЭлементТаблица + " ТекущаяСтрокаПриДОбавлениииURL " +ТекущаяСтрокаПриДОбавлениииURL);
                    ТекущаяСтрокаПриДОбавлениииURL++;
                }
            });
            PackageInfo pInfo = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0);
            version = pInfo.getLongVersionCode();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            ContentValues valuesЗаписываемОшибки=new ContentValues();
            valuesЗаписываемОшибки.put("Error",e.toString().toLowerCase());
            valuesЗаписываемОшибки.put("Klass",this.getClass().getName());
            valuesЗаписываемОшибки.put("Metod",Thread.currentThread().getStackTrace()[2].getMethodName());
            valuesЗаписываемОшибки.put("LineError",   Thread.currentThread().getStackTrace()[2].getLineNumber());
            final Object ТекущаяВерсияПрограммы =version;
            Integer   ЛокальнаяВерсияПОСравнение = Integer.parseInt(ТекущаяВерсияПрограммы.toString());
            valuesЗаписываемОшибки.put("whose_error",ЛокальнаяВерсияПОСравнение);
            new SubClassErrors(getContext()).МетодЗаписиОшибок(valuesЗаписываемОшибки);
        }
    }
    @Override
    public boolean onCreate() {
        try{
            if (Create_Database_СамаБАзаSQLite==null) {
                Log.w(this.getClass().getName(), "Create_Database_СамаБАзаSQLite " + Create_Database_СамаБАзаSQLite);
                Create_Database_СамаБАзаSQLite=new CREATE_DATABASEServer(getContext()).getССылкаНаСозданнуюБазу();
                Log.w(this.getClass().getName(), "Create_Database_СамаБАзаSQLite " + Create_Database_СамаБАзаSQLite + " getContext()) " +getContext());
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            ContentValues valuesЗаписываемОшибки=new ContentValues();
            valuesЗаписываемОшибки.put("Error",e.toString().toLowerCase());
            valuesЗаписываемОшибки.put("Klass",this.getClass().getName());
            valuesЗаписываемОшибки.put("Metod",Thread.currentThread().getStackTrace()[2].getMethodName());
            valuesЗаписываемОшибки.put("LineError",   Thread.currentThread().getStackTrace()[2].getLineNumber());
            final Object ТекущаяВерсияПрограммы =version;
            Integer   ЛокальнаяВерсияПОСравнение = Integer.parseInt(ТекущаяВерсияПрограммы.toString());
            valuesЗаписываемОшибки.put("whose_error",ЛокальнаяВерсияПОСравнение);
            new SubClassErrors(getContext()).МетодЗаписиОшибок(valuesЗаписываемОшибки);
        }
        if (Create_Database_СамаБАзаSQLite!=null) {
            return true;
        } else {
            return false;
        }

    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }


    @NonNull
    private String МетодОпределяемТаблицу(Uri uri) {
        String table = new String();
        try{
            Log.d(this.getClass().getName(), " uri"+ uri);
            switch (uriMatcherДЛяПровайдераКонтентБазаДанных.match(uri)) {
                case 0:
                    table = "errordsu1";
                    break;
                case 1:
                    table = "tablescannerandroid";
                    break;
                case 2:
                    table = "tablescannerpublic";
                    break;
                default:
                    table=    Optional.ofNullable(uri).map(Emmeter->Emmeter.toString().replace("content://com.dsy.dsu.providerdatabase/","")).get();
                    Log.w(getContext().getClass().getName(),
                            " defaluit table  " + table  + " uri " + uri);/////
                    break;
            }
            Log.d(this.getClass().getName(), " table"+ table);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            ContentValues valuesЗаписываемОшибки=new ContentValues();
            valuesЗаписываемОшибки.put("Error",e.toString().toLowerCase());
            valuesЗаписываемОшибки.put("Klass",this.getClass().getName());
            valuesЗаписываемОшибки.put("Metod",Thread.currentThread().getStackTrace()[2].getMethodName());
            valuesЗаписываемОшибки.put("LineError",   Thread.currentThread().getStackTrace()[2].getLineNumber());
            final Object ТекущаяВерсияПрограммы =version;
            Integer   ЛокальнаяВерсияПОСравнение = Integer.parseInt(ТекущаяВерсияПрограммы.toString());
            valuesЗаписываемОшибки.put("whose_error",ЛокальнаяВерсияПОСравнение);
            new SubClassErrors(getContext()).МетодЗаписиОшибок(valuesЗаписываемОшибки);
        }
        return table;
    }


    @Override
    public int bulkInsert(@NonNull Uri uri, @NonNull ContentValues[] values) {
        // TODO: Implement this to handle requests to insert a new row.
        Integer  ОтветВставкиДанных = null;
        try {
            if (!Create_Database_СамаБАзаSQLite.inTransaction()) {
                Create_Database_СамаБАзаSQLite.beginTransaction();
            }
            Log.d(this.getClass().getName(), " uri"+uri );
            // TODO: 14.10.2022 метод определения текущней таблицы
            String table = МетодОпределяемТаблицу(uri);

            Flowable.fromArray(values)
                    .onBackpressureBuffer(true)
                    .buffer(50)
                    .doOnNext(new io.reactivex.rxjava3.functions.Consumer<List<ContentValues>>() {
                        @Override
                        public void accept(List<ContentValues> contentValues) throws Throwable {
                            Flowable.fromIterable(contentValues)
                                    .onBackpressureBuffer(true)
                                    .doOnNext(new io.reactivex.rxjava3.functions.Consumer<ContentValues>() {
                                        @Override
                                        public void accept(ContentValues contentValues) throws Throwable {
                                            Long   РезультатВставкиДанныхСканирование  = Create_Database_СамаБАзаSQLite.insertOrThrow(table, null, contentValues);
                                            // TODO: 30.10.2021
                                            Log.w(getContext().getClass().getName(), " РезультатВставкиДанных  " + РезультатВставкиДанныхСканирование);/////
                                            if (РезультатВставкиДанныхСканирование> 0) {
                                                if (Create_Database_СамаБАзаSQLite.inTransaction()) {
                                                    Create_Database_СамаБАзаSQLite.setTransactionSuccessful();
                                                    // TODO: 22.09.2022 увеличивает версию данных
                                                }
                                            }
                                            if (Create_Database_СамаБАзаSQLite.inTransaction()) {
                                                Create_Database_СамаБАзаSQLite.endTransaction();
                                            }
                                        }
                                    })
                                    .doOnError(new io.reactivex.rxjava3.functions.Consumer<Throwable>() {
                                        @Override
                                        public void accept(Throwable throwable) throws Throwable {
                                            Log.e(this.getClass().getName(), "Ошибка " + throwable + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                                                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
                                            ContentValues valuesЗаписываемОшибки=new ContentValues();
                                            valuesЗаписываемОшибки.put("Error",throwable.toString().toLowerCase());
                                            valuesЗаписываемОшибки.put("Klass",this.getClass().getName());
                                            valuesЗаписываемОшибки.put("Metod",Thread.currentThread().getStackTrace()[2].getMethodName());
                                            valuesЗаписываемОшибки.put("LineError",   Thread.currentThread().getStackTrace()[2].getLineNumber());
                                            final Object ТекущаяВерсияПрограммы =version;
                                            Integer   ЛокальнаяВерсияПОСравнение = Integer.parseInt(ТекущаяВерсияПрограммы.toString());
                                            valuesЗаписываемОшибки.put("whose_error",ЛокальнаяВерсияПОСравнение);
                                            new SubClassErrors(getContext()).МетодЗаписиОшибок(valuesЗаписываемОшибки);
                                        }
                                    })
                                    .doOnComplete(new Action() {
                                        @Override
                                        public void run() throws Throwable {
                                            // TODO: 30.10.2021
                                            getContext().getContentResolver().notifyChange(uri, null);
                                            Log.w(getContext().getClass().getName(), " doOnComplete   " );/////
                                        }
                                    })
                                    .blockingSubscribe();
                        }
                    }).blockingSubscribe();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            ContentValues valuesЗаписываемОшибки=new ContentValues();
            valuesЗаписываемОшибки.put("Error",e.toString().toLowerCase());
            valuesЗаписываемОшибки.put("Klass",this.getClass().getName());
            valuesЗаписываемОшибки.put("Metod",Thread.currentThread().getStackTrace()[2].getMethodName());
            valuesЗаписываемОшибки.put("LineError",   Thread.currentThread().getStackTrace()[2].getLineNumber());
            final Object ТекущаяВерсияПрограммы =version;
            Integer   ЛокальнаяВерсияПОСравнение = Integer.parseInt(ТекущаяВерсияПрограммы.toString());
            valuesЗаписываемОшибки.put("whose_error",ЛокальнаяВерсияПОСравнение);
            new SubClassErrors(getContext()).МетодЗаписиОшибок(valuesЗаписываемОшибки);
        }
        return ОтветВставкиДанных;
    }



    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }


}


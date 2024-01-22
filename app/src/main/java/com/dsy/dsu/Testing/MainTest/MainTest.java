package com.dsy.dsu.Testing.MainTest;

// TODO: 25.10.2023 test code start


import android.content.Context;
import android.util.Log;

import com.dsy.dsu.AllTestsBusinessLogic.AllTestsBusinessLogic;

import java.net.HttpURLConnection;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.schedulers.Schedulers;

class MainTest extends AllTestsBusinessLogic {

    //todo #1
    class TEstHttpSimpleConnection extends  TestServer{


        public TEstHttpSimpleConnection(Context context) {
            super(context);
        }

        @Override
        public void metodTest() {


            Completable.fromAction(new Action() {
                                       @Override
                                       public void run() throws Throwable {

                                           connection = (HttpURLConnection) (urltest).openConnection();/////САМ ФАЙЛ JSON C ДАННЫМИ
                                           connection.setRequestProperty("Content-Type", "application/txt ;charset=UTF-8");
                                           connection.setRequestProperty("Accept-Encoding", "gzip,deflate,sdch");
                                           connection.setRequestProperty("Connection", "Keep-Alive");
                                           connection.setRequestProperty("Accept-Language", "ru-RU");
                                           connection.setRequestMethod("GET"); ///   HEAD GET //ПРОВЕРЯЕМ ЕСЛИ ПОДКЛЮЧЕНИЕ К СЕВРЛЕТУ НА СЕРВЕР ВЫБРАСЫВАЕМ
                                           connection.setReadTimeout(10000); //todo САМ ТАЙМАУТ ПОДКЛЮЧЕНИЕ(30000);
                                           connection.setConnectTimeout(10000);//todo САМ ПОТОК ДАННЫХ(1000); САМ STREAM
                                           connection.setUseCaches(true);
                                           connection.connect(); /////////////ТОЛЬКО СОЕДИНЕНИЕ
                                           connection.getContent(); ////РЕАЛЬНОЕ ПОЛУЧЕНИЕ ДАННЫХ С ИНТРЕНЕТА
                                           // TODO: 11.08.2021 получениея версии чата версия данных CURRENT _CHAT
                                           Log.d(this.getClass().getName(), "ПодключениеПолученияДанныхсСервер.getHeaderField(current_chat_server) " + connection.getHeaderField("stream_current_chat_server"));
                                           // TODO: 11.08.2021 ВекрсияДанных с сервера на Сервера
                                           Long РезультатВерсииДанныхЧатаНаСервере=0l;
                                           РезультатВерсииДанныхЧатаНаСервере= Long.parseLong(connection.getHeaderField("stream_current_chat_server"));
                                           Log.d(this.getClass().getName(), "РезультатВерсииДанныхЧатаНаСервере " + РезультатВерсииДанныхЧатаНаСервере);
                                           ////TODO И ЕСЛИ ПРИШЕЛ ОТ СЕРВЕРА ОТВЕТ ПОЛОЖИТЕЛЬНО ТО ТОГДА ЗАПУСКАМ ПРОЧТЕНИЯ ПОТОКА ПРИШЕДШЕГО С СЕРВЕРА
                                           if (connection.getResponseCode() == 200 && РезультатВерсииДанныхЧатаНаСервере > 0) {
                                               //TODO шифровани
                                               Log.i(this.getClass().getName(), "ПОТОК ПРИШЕЛ НУЛОВОЙ ОТ СЕРВЕРА  " + connection.getInputStream().available());
                                           }    else {
                                               Log.i(this.getClass().getName(), "ПОТОК ПРИШЕЛ НУЛОВОЙ ОТ СЕРВЕРА  " + connection.getInputStream().available());
                                           }

                                           connection.disconnect();









                                           Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                                   " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                                   " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n");
                                       }
                                   }
                    )
                    .subscribeOn(Schedulers.single())
                    .blockingSubscribe(new CompletableObserver() {
                        @Override
                        public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {
                            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" );
                        }

                        @Override
                        public void onComplete() {
                            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" );
                        }

                        @Override
                        public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" );
                        }
                    });



            // super.metodTest();
            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" );
        }
    }

}  // TODO: 25.10.2023  end MainTest

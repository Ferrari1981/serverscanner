package com.dsy.dsu.PaysCommings.Model.Bl_Nested;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.dsy.dsu.PaysCommings.View.RecyreView.MyViewHolderPay;
import com.dsy.dsu.Errors.Class_Generation_Errors;
import com.fasterxml.jackson.databind.JsonNode;
import com.jakewharton.rxbinding4.view.RxView;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import kotlin.Unit;

public class BlrecyrceViewNestedPay implements  InBlrecyreviewNested{

    Context context;
    MyViewHolderPay holder;
    JsonNode jsonNode1сСогласованияRowNested;
    public BlrecyrceViewNestedPay(Context context, @NonNull MyViewHolderPay holder, @NonNull JsonNode jsonNode1сСогласованияRowNested) {
        try{
        this.context = context;
        this.holder = holder;
        this.jsonNode1сСогласованияRowNested = jsonNode1сСогласованияRowNested;
        Log.d(context.getClass().getName(), "\n"
                + " время: " + new Date()+"\n+" +
                " Класс в процессе... " +  this.getClass().getName()+"\n"+
                " метод в процессе... " + Thread.currentThread().getStackTrace()[2].getMethodName());
    } catch (Exception e) {
        e.printStackTrace();
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
        new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
    }
    }


    @Override
    public void getvisibleOrHideNestedRecyreView(@NonNull MyViewHolderPay holder) {
            try {
                Log.d(this.getClass().getName(), "   КнопкаУспешноеСогласования    Успехх Согласования 2 " );

                final Handler[] handler = {null};

                // TODO: 10.11.2023 клик по файлов
                RxView.clicks(   holder. arrowpay_nested_receriview_commitingpay)
                        .throttleFirst(1, TimeUnit.SECONDS)
                        .filter(s -> !s.toString().isEmpty())
                        .map(new Function<Unit, Object>() {
                            @Override
                            public Object apply(Unit unit) throws Throwable {
                                Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                        " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                        " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" );
                                handler[0] =holder. arrowpay_nested_receriview_commitingpay.getHandler();
                                return    holder. arrowpay_nested_receriview_commitingpay;
                            }
                        })
                        .doOnError(new io.reactivex.rxjava3.functions.Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Throwable {
                                throwable.printStackTrace();
                                Log.e(context.getClass().getName(),
                                        "Ошибка " + throwable + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                                                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                                new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(throwable.toString(),
                                        this.getClass().getName().toString(), Thread.currentThread().getStackTrace()[2].getMethodName().toString(),
                                        Thread.currentThread().getStackTrace()[2].getLineNumber());
                            }
                        })
                        .onErrorComplete(new Predicate<Throwable>() {
                            @Override
                            public boolean test(Throwable throwable) throws Throwable {
                                throwable.printStackTrace();
                                Log.e(context.getClass().getName(),
                                        "Ошибка " + throwable + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                                                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                                new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(throwable.toString(),
                                        this.getClass().getName().toString(), Thread.currentThread().getStackTrace()[2].getMethodName().toString(),
                                        Thread.currentThread().getStackTrace()[2].getLineNumber());
                                return false;
                            }
                        })
                        .subscribe( Getarrow_nested_receriview_commitingpay-> {

                            subcrabeClikcVisibleNestedRecyreView(handler[0],holder);

                            // proccerClickSucceesPay(holder, handler, (MaterialButton) GetNameSingleNewFile1c);


                            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" + " Getarrow_nested_receriview_commitingpay " +Getarrow_nested_receriview_commitingpay);


                        });



            } catch (Exception e) {
                e.printStackTrace();
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                        " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                        Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            }



    }

    private void subcrabeClikcVisibleNestedRecyreView(Handler handlerNestedArrowClick,@NonNull MyViewHolderPay holder) {
        try{
            handlerNestedArrowClick.postDelayed(new Runnable() {
            @Override
            public void run() {
                try{
                    if (holder.    recycleview_nesters_commininggpay.getVisibility()== View.VISIBLE) {
                        holder.    recycleview_nesters_commininggpay.setVisibility(View.GONE);
                      /*  ViewGroup.LayoutParams params= holder.    recycleview_nesters_commininggpay.getLayoutParams();
                        params.height=0;*/
                       // holder.    recycleview_nesters_commininggpay.setLayoutParams(params);
                    } else {
                        holder.    recycleview_nesters_commininggpay.setVisibility(View.VISIBLE);
                       /* ViewGroup.LayoutParams params= holder.    recycleview_nesters_commininggpay.getLayoutParams();
                        params.height=200;*/
                       // holder.    recycleview_nesters_commininggpay.setLayoutParams(params);

                    }
                    holder.    recycleview_nesters_commininggpay.requestLayout();
                    holder.recycleview_nesters_commininggpay.refreshDrawableState();

                    Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                            " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                            " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" );

            } catch (Exception e) {
                e.printStackTrace();
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                        " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                        Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            }
            }
        },100);

    } catch (Exception e) {
        e.printStackTrace();
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
        new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
    }
    }
}

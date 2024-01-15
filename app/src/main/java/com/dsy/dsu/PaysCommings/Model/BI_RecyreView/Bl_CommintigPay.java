package com.dsy.dsu.PaysCommings.Model.BI_RecyreView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dsy.dsu.BusinessLogicAll.Class_Get_Json_1C;
import com.dsy.dsu.PaysCommings.View.RecyreView.MyRecycleViewAdapterPay;
import com.dsy.dsu.PaysCommings.View.RecyreViewIsNull.MyRecycleViewIsNullAdapterPay;
import com.dsy.dsu.Dashboard.MainActivity_Dashboard;
import com.dsy.dsu.Errors.Class_Generation_Errors;
import com.dsy.dsu.R;
import com.dsy.dsu.Services.Service_Notificatios_Для_Согласования;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.jakewharton.rxbinding4.view.RxView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import kotlin.Unit;

// TODO: 10.03.2022 БИЗНЕС-КОД ПЕРЕНЕСЕН ИЗ АКТИВТИ

 
public class Bl_CommintigPay {
    Context context;

    public    Bl_CommintigPay(Context context   ) {
        this.context = context;
        Log.d(context.getClass().getName(), "\n"
                + " время: " + new Date()+"\n+" +
                " Класс в процессе... " +  this.getClass().getName()+"\n"+
                " метод в процессе... " + Thread.currentThread().getStackTrace()[2].getMethodName());
    }


    public void МетодСлушательObserverДляRecycleView(@NonNull    MyRecycleViewAdapterPay myRecycleViewAdapterPay) {  // TODO: 04.03.2022  класс в котором находяться слушатели
        try {
            if (myRecycleViewAdapterPay!=null) {
                myRecycleViewAdapterPay.registerAdapterDataObserver(      new RecyclerView.AdapterDataObserver() {
                    @Override
                    public void onChanged() {
                        super.onChanged();
                        try {
                            Log.d(context.getClass().getName(), "\n"
                                    + " время: " + new Date()+"\n+" +
                                    " Класс в процессе... " +  this.getClass().getName()+"\n"+
                                    " метод в процессе... " + Thread.currentThread().getStackTrace()[2].getMethodName());
                        } catch (Exception e) {
                            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                        }
                    }
                    @Override
                    public void onItemRangeChanged(int positionStart, int itemCount) {
                        super.onItemRangeChanged(positionStart, itemCount);
                        // TODO: 05.03.2022  СТАТУС ЗНАЧКА С ДОПОЛНИТЕЛЬНЫЙ СТАТУСОМ
                        try {
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
                    public void onItemRangeChanged(int positionStart, int itemCount, @Nullable Object payload) {
                        super.onItemRangeChanged(positionStart, itemCount, payload);
                        try{
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
                    public void onItemRangeInserted(int positionStart, int itemCount) {
                        super.onItemRangeInserted(positionStart, itemCount);
                        try{
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
                    public void onItemRangeRemoved(int positionStart, int itemCount) {
                        super.onItemRangeRemoved(positionStart, itemCount);
                        try{
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
                    public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
                        super.onItemRangeMoved(fromPosition, toPosition, itemCount);
                        try{
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
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            // TODO: 01.09.2021 метод вызова
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }

    // TODO: 02.03.2022 выход

    public void МетодКпопкаВозвращениеНазадИзСогласованиии(@NonNull BottomNavigationItemView bottomNavigationBack)
            throws ExecutionException, InterruptedException {
        try {
            Log.d(this.getClass().getName(), "  выходим из задания МетодКпопкаВозвращениеНазадИзСогласованиии" );
            bottomNavigationBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Handler handler=    v.getHandler();
                    handler.post(()->{
                        Intent Интент_BackВозвращаемАктивти = new Intent();
                        Bundle data1C = new Bundle();
                        Интент_BackВозвращаемАктивти.putExtras(data1C);
                        Интент_BackВозвращаемАктивти.setClass(context, MainActivity_Dashboard.class); // Т
                        Интент_BackВозвращаемАктивти.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        Log.d(this.getClass().getName(), "  выходим из задания МетодКпопкаВозвращениеНазадИзСогласованиии" );
                      context.  startActivity( Интент_BackВозвращаемАктивти);

                        // TODO: 17.04.2023 LOG
                        Log.d(this.getClass().getName(),"\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber());

                    });





              /*          // TODO Запусукаем Фргамент НАстройки  dashbord
                        DashboardFragmentSettings dashboardFragmentSettings = DashboardFragmentSettings.newInstance();
                        Bundle data=new Bundle();
                        dashboardFragmentSettings.setArguments(data);
                        fragmentTransaction.remove(dashboardFragmentSettings);
                        String fragmentNewImageNameaddToBackStack=   dashboardFragmentSettings.getClass().getName();
                        fragmentTransaction.addToBackStack(fragmentNewImageNameaddToBackStack);
                        Fragment FragmentУжеЕСтьИлиНЕт=     fragmentManager.findFragmentByTag(fragmentNewImageNameaddToBackStack);
                        if (FragmentУжеЕСтьИлиНЕт==null) {
                            dashboardFragmentSettings.show(fragmentManager, "DashboardFragmentSettings");
                            // TODO: 01.08.2023

                        }*/






                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }
    // TODO: 02.03.2022  принудительный обмен с 1с
    public void МетодКпопкаПринидительноОбмена(@NonNull BottomNavigationItemView bottomNavigationAsync,
                                               @NonNull JsonNode jsonNode1сСогласованияAllRows,
                                               @NonNull AsyncTaskLoader <JsonNode> asyncTaskLoader,
                                               @NonNull ProgressBar progressBarCommitPay,
                                               @NonNull ObjectMapper objectMapper,
                                               @NonNull Integer ПубличныйidPay,
                                               @NonNull MyRecycleViewAdapterPay myRecycleViewAdapter,
                                               @NonNull RecyclerView recyclerViewСогласование1С,
                                               @NonNull  MyRecycleViewIsNullAdapterPay myRecycleViewIsNullAdapter)
            throws ExecutionException, InterruptedException {
        try {
            // TODO: 02.03.2022
            Log.d(this.getClass().getName(), "  принудительный обмен  МетодКпопкаВозвращениеНазадИзСогласованиии" );
            RxView.clicks(  bottomNavigationAsync)
                    .throttleFirst(2, TimeUnit.SECONDS)
                    .filter(s -> !s.toString().isEmpty())
                    .map(new Function<Unit, Object>() {
                        @Override
                        public Object apply(Unit unit) throws Throwable {
                            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" );
                            return    bottomNavigationAsync;
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
                    .subscribe( GetAsyncCommitPays-> {
                        ///todo revboot

                        // TODO: 08.11.2023
                        metodEndingRecyreViewElseData1C(jsonNode1сСогласованияAllRows,myRecycleViewAdapter,recyclerViewСогласование1С,myRecycleViewIsNullAdapter);
                        //onResume();

                       МетодISNUllПолучениеДанныхОт1сДляСогласования(asyncTaskLoader,progressBarCommitPay,
                               objectMapper,ПубличныйidPay,
                               myRecycleViewAdapter,
                               recyclerViewСогласование1С,
                               myRecycleViewIsNullAdapter);


                        Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"
                                + " jsonNode1сСогласованияAllRows " +jsonNode1сСогласованияAllRows);


                        Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"+ " GetAsyncCommitPays " +GetAsyncCommitPays );

                    });

        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }


    public void МетодКликПоПоиску(@NonNull BottomNavigationItemView bottomNavigationSearch,
                                  @NonNull JsonNode jsonNode1сСогласованияAllRows,
                                  @NonNull androidx.appcompat.widget.SearchView searchview_commitpay,
                                  @NonNull RecyclerView recyclerViewСогласование1С,
                                  @NonNull RelativeLayout relativeLayout_recyreview,
                                  @NonNull Animation animation1,
                                  @NonNull Activity activity,
                                  @NonNull MyRecycleViewAdapterPay myRecycleViewAdapter)
            throws ExecutionException, InterruptedException {
        // TODO: 02.03.2022
        try {


            RxView.clicks(  bottomNavigationSearch)
                    .throttleFirst(1,TimeUnit.SECONDS)
                    .filter(s -> !s.toString().isEmpty())
                    .map(new Function<Unit, Object>() {
                        @Override
                        public Object apply(Unit unit) throws Throwable {
                            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" );
                            return    bottomNavigationSearch;
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
                    .subscribe( GetNameSingleNewFile1c-> {

                        if (jsonNode1сСогласованияAllRows!=null) {
                            if (searchview_commitpay.getVisibility()==View.VISIBLE) {
                                searchview_commitpay.setVisibility(View.GONE);
                                searchview_commitpay.setEnabled(false);
                                ViewGroup.LayoutParams params= searchview_commitpay.getLayoutParams();
                                params.height=0;
                                searchview_commitpay.setLayoutParams(params);

                                Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                        " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                        " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n");
                            }else {
                                searchview_commitpay.setVisibility(View.VISIBLE);
                                searchview_commitpay.setEnabled(true);
                                ViewGroup.LayoutParams params= searchview_commitpay.getLayoutParams();
                                params.height=80;
                                searchview_commitpay.setLayoutParams(params);

                                // TODO: 21.11.2023 Enadble Filter

                              new AdapterSerachViewPay(searchview_commitpay,context,jsonNode1сСогласованияAllRows,activity,
                                      myRecycleViewAdapter,recyclerViewСогласование1С).setAdapterSerachViewPay();

                                Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                        " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                        " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n");
                            }

                            searchview_commitpay.startAnimation(animation1);
                            searchview_commitpay.requestLayout();
                            searchview_commitpay.refreshDrawableState();

                            recyclerViewСогласование1С.requestLayout();
                            recyclerViewСогласование1С.refreshDrawableState();

                            relativeLayout_recyreview.requestLayout();
                            relativeLayout_recyreview.refreshDrawableState();


                        }


                        Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"+ " bottomNavigationSearch " +bottomNavigationSearch );

                    });
            // TODO: 09.03.2022
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }




    // TODO: 04.03.2022 прозвомжность Заполения RecycleView
  public   void МетодЗаполенияRecycleViewДляЗадач(@NonNull MyRecycleViewAdapterPay myRecycleViewAdapter,
                                           @NonNull JsonNode jsonNode1сСогласованияAllRows,
                                           @NonNull RecyclerView recyclerViewСогласование1С,
                                           @NonNull   AsyncTaskLoader <JsonNode> asyncTaskLoader,
                                          @NonNull   Service_Notificatios_Для_Согласования.LocalBinderДляСогласования binderСогласования1C,
                                          @NotNull Animation animation1,
                                                  @NonNull Integer ПубличныйidPay,
                                                  @NonNull ObjectMapper objectMapper,
                                                  @NonNull   BottomNavigationView bottomNavigationViewParent) {
        try {
            if (myRecycleViewAdapter==null) {
                myRecycleViewAdapter = new MyRecycleViewAdapterPay(jsonNode1сСогласованияAllRows,context,
                        asyncTaskLoader,binderСогласования1C,animation1,ПубличныйidPay,objectMapper,bottomNavigationViewParent);
                myRecycleViewAdapter.notifyDataSetChanged();
                recyclerViewСогласование1С.setAdapter(myRecycleViewAdapter);
                recyclerViewСогласование1С.getAdapter().notifyDataSetChanged();
            }

            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" +"jsonNode1сСогласованияAllRows  "
                    + jsonNode1сСогласованияAllRows);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }

  public   void МетодЗаполенияRecycleViewIsNUllДляЗадач(@NonNull MyRecycleViewIsNullAdapterPay myRecycleViewIsNullAdapter,
                                                 @NonNull   AsyncTaskLoader <JsonNode> asyncTaskLoader,
                                                 @NonNull RecyclerView recyclerViewСогласование1С) {
        try {
            if (myRecycleViewIsNullAdapter==null) {
                ArrayList<String> arrayListIsNull1cData=new ArrayList<>();
                arrayListIsNull1cData.add("IsNull1cPayCommit");
                myRecycleViewIsNullAdapter = new MyRecycleViewIsNullAdapterPay(arrayListIsNull1cData,context,asyncTaskLoader );
                myRecycleViewIsNullAdapter.notifyDataSetChanged();
                recyclerViewСогласование1С.setAdapter(myRecycleViewIsNullAdapter);
                recyclerViewСогласование1С.getAdapter().notifyDataSetChanged();
            }
            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" +"asyncTaskLoader  "
                    + asyncTaskLoader);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }



    // TODO: 04.03.2022 прозвомжность инициализации RecycleView
    public void МетодИнициализацииRecycleViewДляЗадач(@NonNull Context context,
                                                      @NonNull RecyclerView recyclerViewСогласование1С,
                                                      @NonNull Animation animation) {
        try {

              /*  DividerItemDecoration dividerItemDecorationHor=
                        new DividerItemDecoration(context, LinearLayoutManager.VERTICAL);*/
            DividerItemDecoration itemDecoration = new DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL);
            GradientDrawable drawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{0xfff7f7f7, 0xfff7f7f7});
            drawable.setSize(1,1);
            itemDecoration.setDrawable(drawable);
            /*            dividerItemDecorationHor.setDrawable(context.getDrawable(R.drawable.divider_for_order_transport1));///R.dimen.activity_horizontal_margin*/
            recyclerViewСогласование1С.addItemDecoration(itemDecoration);

            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerViewСогласование1С.setLayoutManager(linearLayoutManager);
            //TODO new LinearLayoutManager(context) // TODO: 28.02.2022 создаем наш первый RecyclerView recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerViewСогласование1С.startAnimation(animation);
            // TODO: 28.02.2022
            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" + " animation " +animation);

        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }

    }

    private void metodEndingRecyreViewElseData1C(@NonNull JsonNode jsonNode1сСогласованияAllRows,
                                                 @NonNull MyRecycleViewAdapterPay myRecycleViewAdapter,
                                                 @NonNull RecyclerView recyclerViewСогласование1С,
                                                 @NonNull  MyRecycleViewIsNullAdapterPay myRecycleViewIsNullAdapter) {

        try{
            if (jsonNode1сСогласованияAllRows!=null) {

                  методRebootDisaynRecyreViewonStopOrAsync(jsonNode1сСогласованияAllRows,myRecycleViewAdapter,recyclerViewСогласование1С);
            } else {

                   методRebootRecyreviewDontJsonNULL(myRecycleViewIsNullAdapter,recyclerViewСогласование1С);
            }
            Log.d(this.getClass().getName(),"\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + " jsonNode1сСогласованияAllRows " +jsonNode1сСогласованияAllRows);

        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }

    // TODO: 14.03.2022

    public void МетодКпопкаСоЗачкомКраснымДополнительныйСтатус(@NonNull JsonNode jsonNode1сСогласованияRow,
                                                               @NonNull BottomNavigationView bottomNavigationViewParent)
    {
        try {
            // TODO: 09.03.2022
            if (jsonNode1сСогласованияRow!=null) {
                if (  jsonNode1сСогласованияRow.size()>0) {
                    bottomNavigationViewParent.getOrCreateBadge(R.id.bottomNavigationAsync).setBackgroundColor(Color.parseColor("#008080"));
                    bottomNavigationViewParent.getOrCreateBadge(R.id.bottomNavigationAsync).setNumber(jsonNode1сСогласованияRow.size());//.getOrCreateBadge(R.id.id_taskHome).setVisible(true);
                } else {
                    bottomNavigationViewParent.getOrCreateBadge(R.id.bottomNavigationAsync).setBackgroundColor(Color.RED)        ;
                    bottomNavigationViewParent.getOrCreateBadge(R.id.bottomNavigationAsync).setNumber(0);//.getOrCreateBadge(R.id.id_taskHome).setVisible(true);
                }
            }else {
                bottomNavigationViewParent.getOrCreateBadge(R.id.bottomNavigationAsync).setBackgroundColor(Color.RED)        ;
                bottomNavigationViewParent.getOrCreateBadge(R.id.bottomNavigationAsync).setNumber(0);//.getOrCreateBadge(R.id.id_taskHome).setVisible(true);
            }
            bottomNavigationViewParent.requestLayout();
            bottomNavigationViewParent.refreshDrawableState();

            // TODO: 15.01.2024
            Log.d(context.getClass().getName(), "\n"
                    + " время: " + new Date()+"\n+" +
                    " Класс в процессе... " +  this.getClass().getName()+"\n"+
                    " метод в процессе... " + Thread.currentThread().getStackTrace());
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }
    @SuppressLint("RestrictedApi")
    public void setEnableSearchMechi(@NonNull JsonNode jsonNode1сСогласованияRow,@NonNull BottomNavigationView bottomNavigationViewParent )
    {
        try {
            // TODO: 09.03.2022
            if (jsonNode1сСогласованияRow.size()>0) {

                BottomNavigationView    bottomNavigationSearch = bottomNavigationViewParent.findViewById(R.id.bottomNavigationSearch);

                bottomNavigationSearch.setEnabled(true);
                bottomNavigationSearch.setClickable(true);
            }
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





























    // TODO: 12.07.2022  метод получение данных от 1С для согласования
    public void metodGetDataOt1cCommitPay(@NonNull AsyncTaskLoader <JsonNode> asyncTaskLoader,
                                          @NonNull ProgressBar progressBarCommitPay,
                                          @NonNull ObjectMapper objectMapper,
                                          @NonNull Integer ПубличныйidPay,
                                          @NonNull MyRecycleViewAdapterPay myRecycleViewAdapter,
                                          @NonNull RecyclerView recyclerViewСогласование1С,
                                          @NonNull  MyRecycleViewIsNullAdapterPay myRecycleViewIsNullAdapter) {
        try {
            asyncTaskLoader=new AsyncTaskLoader<JsonNode>(context) {
                @Override
                protected void onStartLoading() {
                    super.onStartLoading();
                    try{
                        progressBarCommitPay.setVisibility(View.VISIBLE);
                        Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" );
                        // TODO: 28.02.2022*/
                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                        new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                    }
                }

                @Nullable
                @Override
                public JsonNode loadInBackground() {
                    JsonNode jsonNode1сСогласования = null;
                    try{
                      /// Integer ПубличныйidPay=247;
                        //TODO получаем данные для соглачования
                        //TODO ПЫТИАЕМСЯ ПОПОЛУЧИТЬ ДАННЫЕ С 1С
                        jsonNode1сСогласования =
                                new Class_Get_Json_1C(context ,"http://uat.dsu1.ru:55080/dds/hs/jsonto1c/listofdocuments")
                                        .МетодПингаИПОлучениеДанныхОт1сДляСогласования(context,ПубличныйidPay,objectMapper);//ПубличныйidPay*/



/*
[{"Ndoc":"000021992","CFO":"База (Управление ул. Проездная, 18/27)","organization":"СОЮЗ АВТОДОР ООО","counterparty":"СИТИЛИНК ООО","sum":6,"articleDDS":"2.2.04. Оргтехника","nomenclature":[{"nomen":"Тест 1"},{"nomen":"Тест 2"},{"nomen":"Тест 3"}],"filenames":[{"ВinNameFile":"Текстовый документ","expansion":"txt"}]},
                            {"Ndoc":"000021993","CFO":"База (Управление ул. Проездная, 18/27)","organization":"СОЮЗ АВТОДОР ООО","counterparty":"ИП Пряслов Алексей Александрович","sum":50,"articleDDS":"2.2.05. Прочие (инвестиционная деятельность)","nomenclature":[{"nomen":"Тест картридж"}],"filenames":[{"ВinNameFile":"Справочник","expansion":"xlsx"}]}]*/



                        Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"+ "  jsonNode1сСогласования  " + jsonNode1сСогласования);




                        Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" + " jsonNode1сСогласования " +jsonNode1сСогласования);
                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                        new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                    }
                    return jsonNode1сСогласования;
                }
            };
            asyncTaskLoader.startLoading();
            asyncTaskLoader.forceLoad();
            asyncTaskLoader.registerListener(new Random().nextInt(), new Loader.OnLoadCompleteListener<JsonNode>() {
                @Override
                public void onLoadComplete(@NonNull Loader<JsonNode> loader, @Nullable JsonNode jsonNode1сСогласования) {
                    try{

                            // TODO: 08.11.2023  данные есть
                            metodEndingRecyreViewElseData1C(jsonNode1сСогласования,
                                    myRecycleViewAdapter,
                                    recyclerViewСогласование1С,
                                      myRecycleViewIsNullAdapter);

                        Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" + " jsonNode1сСогласования " +jsonNode1сСогласования);

                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" +
                                Thread.currentThread().getStackTrace()[2].getMethodName() +
                                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                        new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                                this.getClass().getName(),
                                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                    }
                }


            });

        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }

    }





    // TODO: 21.11.2023  метод получение данныых Синхронно
    private void МетодISNUllПолучениеДанныхОт1сДляСогласования(@NonNull AsyncTaskLoader <JsonNode> asyncTaskLoader,
                                                               @NonNull ProgressBar progressBarCommitPay,
                                                               @NonNull ObjectMapper objectMapper,
                                                               @NonNull Integer ПубличныйidPay,
                                                               @NonNull MyRecycleViewAdapterPay myRecycleViewAdapter,
                                                               @NonNull RecyclerView recyclerViewСогласование1С,
                                                               @NonNull  MyRecycleViewIsNullAdapterPay myRecycleViewIsNullAdapter) {
        try {
            asyncTaskLoader=new AsyncTaskLoader<JsonNode>(context) {
                @Override
                protected void onStartLoading() {
                    super.onStartLoading();
                    try{
                        progressBarCommitPay.setVisibility(View.VISIBLE);
                        Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" );
                        // TODO: 28.02.2022*/
                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                        new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                    }
                }

                @Nullable
                @Override
                public JsonNode loadInBackground() {
                    JsonNode jsonNode1сСогласования = null;
                    try{
                        //TODO получаем данные для соглачования
                        //TODO ПЫТИАЕМСЯ ПОПОЛУЧИТЬ ДАННЫЕ С 1С
                        jsonNode1сСогласования =
                                new Class_Get_Json_1C(context ,"http://uat.dsu1.ru:55080/dds/hs/jsonto1c/listofdocuments")
                                        .МетодПингаИПОлучениеДанныхОт1сДляСогласования(context,ПубличныйidPay,objectMapper);//ПубличныйidPay*/


                        Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"+ "  jsonNode1сСогласования  " + jsonNode1сСогласования);


/*
[{"Ndoc":"000021992","CFO":"База (Управление ул. Проездная, 18/27)","organization":"СОЮЗ АВТОДОР ООО","counterparty":"СИТИЛИНК ООО","sum":6,"articleDDS":"2.2.04. Оргтехника","nomenclature":[{"nomen":"Тест 1"},{"nomen":"Тест 2"},{"nomen":"Тест 3"}],"filenames":[{"ВinNameFile":"Текстовый документ","expansion":"txt"}]},
                            {"Ndoc":"000021993","CFO":"База (Управление ул. Проездная, 18/27)","organization":"СОЮЗ АВТОДОР ООО","counterparty":"ИП Пряслов Алексей Александрович","sum":50,"articleDDS":"2.2.05. Прочие (инвестиционная деятельность)","nomenclature":[{"nomen":"Тест картридж"}],"filenames":[{"ВinNameFile":"Справочник","expansion":"xlsx"}]}]*/

                        Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" + " jsonNode1сСогласования " +jsonNode1сСогласования);
                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                        new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                    }
                    return jsonNode1сСогласования;
                }
            };
            asyncTaskLoader.startLoading();
            asyncTaskLoader.forceLoad();
            asyncTaskLoader.registerListener(new Random().nextInt(), new Loader.OnLoadCompleteListener<JsonNode>() {
                @Override
                public void onLoadComplete(@NonNull Loader<JsonNode> loader, @Nullable JsonNode jsonNode1сСогласованияISNull) {
                    try{

// TODO: 21.11.2023 получаем данные сихронно для Async
                        // TODO: 08.11.2023  данные есть
                        metodEndingRecyreViewElseData1C(jsonNode1сСогласованияISNull,myRecycleViewAdapter,recyclerViewСогласование1С,myRecycleViewIsNullAdapter);


                        Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"
                                + " jsonNode1сСогласованияISNull " +jsonNode1сСогласованияISNull);

                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" +
                                Thread.currentThread().getStackTrace()[2].getMethodName() +
                                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                        new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                                this.getClass().getName(),
                                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                    }
                }


            });

        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }

    }














    public void методЗакрываемКлавитатуру(@NonNull androidx.appcompat.widget.SearchView searchview_commitpay,
                                          @NonNull Activity activity) {
        try{

            searchview_commitpay.clearFocus();
            activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

            Log.d(this.getClass().getName(),"\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"  );
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(context.getClass().getName(),
                    "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                            " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new   Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName().toString(), Thread.currentThread().getStackTrace()[2].getMethodName().toString(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }





    public void методRebootDisaynRecyreViewonStopOrAsync(@NonNull JsonNode jsonNode1сСогласованияAllRows,
                                                         @NonNull MyRecycleViewAdapterPay myRecycleViewAdapter,
                                                         @NonNull RecyclerView recyclerViewСогласование1С) {
        try{
            if (jsonNode1сСогласованияAllRows!=null) {
                if (myRecycleViewAdapter!=null) {
                    myRecycleViewAdapter.jsonNode1сСогласования=jsonNode1сСогласованияAllRows;
                    myRecycleViewAdapter.notifyDataSetChanged();
                    RecyclerView.Adapter recyclerViewAdapter=         recyclerViewСогласование1С.getAdapter();
                    recyclerViewСогласование1С.swapAdapter(recyclerViewAdapter,true);
                    recyclerViewСогласование1С.getAdapter().notifyDataSetChanged();
                }
            }
            Log.d(this.getClass().getName(), "\n" + " class " +
                    Thread.currentThread().getStackTrace()[2].getClassName()
                    + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"  + " jsonNode1сСогласованияAllRows " +jsonNode1сСогласованияAllRows);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(context.getClass().getName(),
                    "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                            " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new   Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName().toString(), Thread.currentThread().getStackTrace()[2].getMethodName().toString(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
        }

    }

    public void методClearRecyreView(  @NonNull RecyclerView recyclerViewСогласование1С) {

        try{
            if (recyclerViewСогласование1С!=null) {
                recyclerViewСогласование1С.getRecycledViewPool().clear();
                recyclerViewСогласование1С.removeAllViews();
            }
            Log.d(this.getClass().getName(), "\n" + " class " +
                    Thread.currentThread().getStackTrace()[2].getClassName()
                    + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"
                    + " recyclerViewСогласование1С " +recyclerViewСогласование1С);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(context.getClass().getName(),
                    "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                            " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new   Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName().toString(), Thread.currentThread().getStackTrace()[2].getMethodName().toString(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
        }

    }


    private void методRebootRecyreviewDontJsonNULL(@NonNull MyRecycleViewIsNullAdapterPay myRecycleViewIsNullAdapter,
                                                   @NonNull RecyclerView recyclerViewСогласование1С) {
        try{
            if (myRecycleViewIsNullAdapter!=null) {
                myRecycleViewIsNullAdapter.notifyDataSetChanged();
                RecyclerView.Adapter recyclerViewAdapter=         recyclerViewСогласование1С.getAdapter();
                recyclerViewСогласование1С.swapAdapter(recyclerViewAdapter,true);
                recyclerViewСогласование1С.getAdapter().notifyDataSetChanged();
            }
            Log.d(this.getClass().getName(), "\n" + " class " +
                    Thread.currentThread().getStackTrace()[2].getClassName()
                    + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"
                    + " recyclerViewСогласование1С " +recyclerViewСогласование1С);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(context.getClass().getName(),
                    "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                            " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new   Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName().toString(), Thread.currentThread().getStackTrace()[2].getMethodName().toString(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
        }

    }







    public void metodSetNameCommitHeaders(@NonNull TextView textViewТекущаяЗадача,@NonNull Animation animation) {
        try{
            textViewТекущаяЗадача.setText("Список согласований".toUpperCase());
            textViewТекущаяЗадача.startAnimation(animation);
            textViewТекущаяЗадача.requestLayout();
            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() );


        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }











}
package com.dsy.dsu.PaysCommings.Model.BI_RecyreView;

//TODO класс SerachView поски по Соглоаваниям

import android.app.Activity;
import android.content.Context;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;

import com.dsy.dsu.PaysCommings.View.RecyreView.MyRecycleViewAdapterPay;
import com.dsy.dsu.Errors.Class_Generation_Errors;
import com.fasterxml.jackson.databind.JsonNode;

import org.jetbrains.annotations.NotNull;

class AdapterSerachViewPay{
    private     androidx.appcompat.widget.SearchView searchview_commitpay;

    Context context;
    Bl_CommintigPay bl_commintigPay;
    JsonNode jsonNode1сСогласованияAllRows;
    Activity activity;
    MyRecycleViewAdapterPay  myRecycleViewAdapter;
    RecyclerView recyclerViewСогласование1С;
    public AdapterSerachViewPay(@NotNull SearchView searchview_commitpay,
                                @NotNull  Context context,
                                @NotNull JsonNode jsonNode1сСогласованияAllRows,
                                @NonNull Activity activity,
                                @NonNull MyRecycleViewAdapterPay  myRecycleViewAdapter,
                                @NonNull RecyclerView recyclerViewСогласование1С) {
        this.searchview_commitpay = searchview_commitpay;
        this.context = context;
        this.jsonNode1сСогласованияAllRows = jsonNode1сСогласованияAllRows;
        this.activity = activity;
        this.recyclerViewСогласование1С = recyclerViewСогласование1С;
        this.myRecycleViewAdapter = myRecycleViewAdapter;
          bl_commintigPay=new Bl_CommintigPay(context );
    }


    void  setAdapterSerachViewPay (){
        // TODO: 21.11.2023 Посик
        try{
            if(searchview_commitpay.isEnabled()){
                searchview_commitpay.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        try{
                        if (hasFocus==true) {
                            ((androidx.appcompat.widget.SearchView) v).setQueryHint("Поиск...");
                        }else {
                            ((androidx.appcompat.widget.SearchView) v).setQueryHint(null);

                            bl_commintigPay.методRebootDisaynRecyreViewonStopOrAsync(jsonNode1сСогласованияAllRows,myRecycleViewAdapter,recyclerViewСогласование1С);

                            // TODO: 24.11.2023
                            bl_commintigPay.  методЗакрываемКлавитатуру( searchview_commitpay,activity);
                        }
                        // TODO: 26.12.2022  конец основгого кода
                        Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" +
                                " searchview_commitpay " + searchview_commitpay);
                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.e(context.getClass().getName(),
                                "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                                        " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                        new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                                this.getClass().getName().toString(), Thread.currentThread().getStackTrace()[2].getMethodName().toString(),
                                Thread.currentThread().getStackTrace()[2].getLineNumber());
                    }
                    }
                });
// TODO: 21.11.2023
                searchview_commitpay.setOnQueryTextListener(new androidx.appcompat.widget.SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        try{
                            // TODO: 24.11.2023
                            Vibrator v2 = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
                            v2.vibrate(VibrationEffect.createOneShot(60, VibrationEffect.EFFECT_HEAVY_CLICK));

                           RunningSearchView runningSearchView=
                                   new  RunningSearchView( jsonNode1сСогласованияAllRows,query,context,searchview_commitpay
                                           ,myRecycleViewAdapter,recyclerViewСогласование1С);

                            runningSearchView.   registerBroadCastRexiver ( );

                            runningSearchView.startrunningSearchView();

                            // TODO: 26.12.2022  конец основгого кода
                            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" +
                                    " searchview_commitpay " + searchview_commitpay);
                        } catch (Exception e) {
                            e.printStackTrace();
                            Log.e(context.getClass().getName(),
                                    "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                                            " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                                    this.getClass().getName().toString(), Thread.currentThread().getStackTrace()[2].getMethodName().toString(),
                                    Thread.currentThread().getStackTrace()[2].getLineNumber());
                        }
                        return true;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        try{
                            if (newText!=null && newText.length()>0) {
                                onQueryTextSubmit(newText);
                                // TODO: 26.12.2022  конец основгого кода
                                Log.d(this.getClass().getName(), "\n" + " class " +
                                        Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                        " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                        " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" +
                                        " searchview_commitpay " + searchview_commitpay);
                                return true;
                            }else {
                                // TODO: 26.12.2022  конец основгого кода
                                Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                        " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                        " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" +
                                        " searchview_commitpay " + searchview_commitpay);
                                return false;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            Log.e(context.getClass().getName(),
                                    "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                                            " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                                    this.getClass().getName().toString(), Thread.currentThread().getStackTrace()[2].getMethodName().toString(),
                                    Thread.currentThread().getStackTrace()[2].getLineNumber());
                        }
                        return false;
                    }
                });

            }
            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" +
                    " searchview_commitpay " + searchview_commitpay);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(context.getClass().getName(),
                    "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                            " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName().toString(), Thread.currentThread().getStackTrace()[2].getMethodName().toString(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
        }






    }//TODO end onSubscribe


}
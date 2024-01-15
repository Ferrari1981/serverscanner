package com.dsy.dsu.PaysCommings.Model.BI_RecyreView;

// TODO: 21.11.2023  Класа Бизнес ЛОгики  ПОсика При НАжатии

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dsy.dsu.PaysCommings.View.RecyreView.MyRecycleViewAdapterPay;
import com.dsy.dsu.Errors.Class_Generation_Errors;
import com.dsy.dsu.Services.ServiceForCommitPay;
import com.fasterxml.jackson.databind.JsonNode;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

public class RunningSearchView {
    JsonNode jsonNode1сСогласованияAllRows;
    String query;

    Context context;
    androidx.appcompat.widget.SearchView searchview_commitpay;

  MyRecycleViewAdapterPay myRecycleViewAdapter;
    RecyclerView recyclerViewСогласование1С;

    public RunningSearchView( @NonNull JsonNode jsonNode1сСогласованияAllRows,
                              @NonNull    String query,
                              @NonNull    Context context,
                              @NonNull   SearchView searchview_commitpay,
                              @NonNull MyRecycleViewAdapterPay myRecycleViewAdapter,
                              @NonNull RecyclerView recyclerViewСогласование1С) {
        this.jsonNode1сСогласованияAllRows = jsonNode1сСогласованияAllRows;
        this.query = query;
        this.context = context;
        this.searchview_commitpay = searchview_commitpay;
        this.myRecycleViewAdapter = myRecycleViewAdapter;
        this.recyclerViewСогласование1С = recyclerViewСогласование1С;
    }


    public void   startrunningSearchView (){
        Intent   intentsendJsonNodeToService=null;
        try{
        if (jsonNode1сСогласованияAllRows!=null) {

          intentsendJsonNodeToService = new Intent("GetSerachJsonCommitPay");

            intentsendJsonNodeToService.setClass(context, ServiceForCommitPay.class);
            Bundle bundle=new Bundle();
            bundle.putSerializable("JsonNode",(Serializable) jsonNode1сСогласованияAllRows);
            bundle.putString("query",  query);
            intentsendJsonNodeToService.putExtras(bundle);
        }
       context. startService(intentsendJsonNodeToService);
        // TODO: 26.12.2022  конец основгого кода
        Log.d(this.getClass().getName(), "\n" + " class " +
                Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" );
    } catch (Exception e) {
        e.printStackTrace();
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" +
                Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                + Thread.currentThread().getStackTrace()[2].getLineNumber());
        new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                Thread.currentThread().getStackTrace()[2].getLineNumber());
    }

    }

    // TODO: 23.11.2023 BroadCast
    public void  registerBroadCastRexiver ( ){
        try{
            BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    // Get Пришли ДАнные из службы после посика
                    Bundle bundleGetOtService=         intent.getExtras();
                    Integer КоличествоСтрокПослеПосика=   bundleGetOtService.getInt("message");
                    if (КоличествоСтрокПослеПосика>0) {
                        // TODO: 24.11.2023
                        JsonNode  jsonNode1сСогласованияCallBackService=
                                (JsonNode)       bundleGetOtService.getSerializable("callbacksearchjsonnode");

                        // TODO: 24.11.2023 reboot Recyreview
                        metodCallBackRebootRecyreView(jsonNode1сСогласованияCallBackService);

                     /*       // TODO: 24.11.2023
                            bl_commintigPay.   методЗакрываемКлавитатуру( );*/


                        Log.d(this.getClass().getName(), "\n" + " class " +
                                Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"
                                +"КоличествоСтрокПослеПосика " +КоличествоСтрокПослеПосика);

                    }else {
// TODO: 24.11.2023  меняем дизайн посика когда нет данных
                        metodDontSearchChangeDisaySearch(searchview_commitpay);

                        Log.d(this.getClass().getName(), "\n" + " class " +
                                Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"
                                +"КоличествоСтрокПослеПосика " +КоличествоСтрокПослеПосика + " searchview_commitpay " +searchview_commitpay);

                    }
                    // TODO: 24.11.2023 закрывам Служба
                    metodCloseLocalBroastCast(intent  );
                    // TODO: 26.12.2022  конец основгого кода
                    Log.d(context.getClass().getName(), "\n" + " class "
                            + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                            " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                            " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n");
                }
            };
            LocalBroadcastManager.getInstance(context).registerReceiver(mMessageReceiver,
                    new IntentFilter("custom-event-name"));

            // TODO: 26.12.2022  конец основгого кода
            Log.d(this.getClass().getName(), "\n" + " class " +
                    Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" );
            // TODO: 26.12.2022  конец основгого кода
            Log.d(this.getClass().getName(), "\n" + " class " +
                    Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" );
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

    public void metodCloseLocalBroastCast(@NonNull Intent intent) {
        try{

           Intent    intentsendJsonNodeToService = new Intent("GetSerachJsonCommitPay");
            intentsendJsonNodeToService.setClass(context, ServiceForCommitPay.class);
            context.stopService(intentsendJsonNodeToService);
            LocalBroadcastManager.getInstance(context).unregisterReceiver(null);
            // TODO: 26.12.2022  конец основгого кода
            Log.d(this.getClass().getName(), "\n" + " class " +
                    Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" );

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


    public void metodDontSearchChangeDisaySearch(@NotNull androidx.appcompat.widget.SearchView searchview_commitpay ) {
        try{
            int id =  searchview_commitpay.getContext()
                    .getResources()
                    .getIdentifier("android:id/search_src_text", null, null);
            final TextView[] textView = {(TextView) searchview_commitpay.findViewById(id)};
            textView[0].setTextColor(Color.RED);
            textView[0].setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));

            Handler handler=   searchview_commitpay.getHandler();

            handler.postDelayed(() -> {

                searchview_commitpay.getContext()
                        .getResources()
                        .getIdentifier("android:id/search_src_text", null, null);
                textView[0] = (TextView) searchview_commitpay.findViewById(id);
                textView[0].setTextColor(Color.BLACK);
                textView[0].setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                // TODO: 24.11.2023
            }, 500);

            // TODO: 26.12.2022  конец основгого кода
            Log.d(this.getClass().getName(), "\n" + " class " +
                    Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" );

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






    // TODO: 24.11.2023 callback
    public void metodCallBackRebootRecyreView(@NonNull    JsonNode  jsonNode1сСогласованияCallBackService) {
        try{
            if(jsonNode1сСогласованияCallBackService.size()>0 &&
                    jsonNode1сСогласованияCallBackService.size()<jsonNode1сСогласованияAllRows.size()){
                // TODO: 24.11.2023
                Bl_CommintigPay     bl_commintigPay=new Bl_CommintigPay(context);

                bl_commintigPay.   методClearRecyreView(recyclerViewСогласование1С);

                bl_commintigPay.методRebootDisaynRecyreViewonStopOrAsync(jsonNode1сСогласованияCallBackService,myRecycleViewAdapter,recyclerViewСогласование1С);
            }
            // TODO: 26.12.2022  конец основгого кода
            Log.d(this.getClass().getName(), "\n" + " class " +
                    Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"+
                    " jsonNode1сСогласованияCallBackService " +jsonNode1сСогласованияCallBackService);
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




}
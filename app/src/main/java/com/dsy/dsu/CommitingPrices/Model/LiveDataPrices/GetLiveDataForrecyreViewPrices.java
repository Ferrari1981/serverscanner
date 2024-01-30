package com.dsy.dsu.CommitingPrices.Model.LiveDataPrices;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.dsy.dsu.Errors.Class_Generation_Errors;
import com.dsy.dsu.PaysCommings.Model.BI_RecyreView.Bl_CommintigPay;
import com.dsy.dsu.PaysCommings.Model.BI_RecyreView.LiveData.QualifierGetLiveDataForrecyreViewPay;
import com.dsy.dsu.PaysCommings.Model.Bl_Nested.ComponensForRecyreviewNestedPay;
import com.dsy.dsu.PaysCommings.View.RecyreView.MyRecycleViewAdapterCommingPay;
import com.dsy.dsu.PaysCommings.View.RecyreView.MyViewHolderPayCommingPay;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.android.material.card.MaterialCardView;

import javax.inject.Inject;

import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@QualifierGetLiveDataForrecyreViewPay
@Module
@InstallIn(SingletonComponent.class)
public class GetLiveDataForrecyreViewPrices {

    public @Inject GetLiveDataForrecyreViewPrices() {
        System.out.println("GetLiveDataForrecyreViewPrices");
    }

    public void setObservableLiveDataRecyreViewPrices(@NonNull  LifecycleOwner lifecycleOwner ,
                                                      @NonNull Context context,
                                                      @NonNull  MutableLiveData<Intent> getHiltMutableLiveDataPayForRecyreView,
                                                      @NonNull MyRecycleViewAdapterCommingPay myRecycleViewAdapterCommingPay,
                                                      @NonNull Bl_CommintigPay bl_commintigPay,
                                                      @NonNull JsonNode jsonNode1сСогласования,
                                                      @NonNull MyViewHolderPayCommingPay holder,
                                                      @NonNull MaterialCardView cardview_commingpay,
                                                      @NonNull int position,
                                                      @NonNull RecyclerView recycleviewcommitpays) {
        try{
            if (!getHiltMutableLiveDataPayForRecyreView.hasObservers()) {
                // TODO: 16.01.2024
                getHiltMutableLiveDataPayForRecyreView.observe(lifecycleOwner, new Observer<Intent>() {
                    @Override
                    public void onChanged(Intent intent) {
                        try{
                            switch (intent.getAction())  {
                                case           "CallBackRecyreViewPays":
                                    // TODO: 16.01.2024  пришли данные
                                    Bundle bundleFirst =      intent.getExtras();
                                    String   ОТветОт1СОперациисДанными=     (String )      bundleFirst.getString("recyreViewPays");
                                    StringBuffer stringBufferОт1СОперациисДанными=new StringBuffer(ОТветОт1СОперациисДанными);


// TODO: 30.01.2024  метод ответа от 1с pay согласовано или нет
                                    procesingCallBackOt1cPays( stringBufferОт1СОперациисДанными,
                                            myRecycleViewAdapterCommingPay, holder, cardview_commingpay, position,
                                            context, jsonNode1сСогласования, recycleviewcommitpays, bl_commintigPay);

                                    Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                            " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                            " line " + Thread.currentThread().getStackTrace()[2].getLineNumber()
                                            + "\n"+ " recycleviewcommitpays "+recycleviewcommitpays);
                                    break;

                            }

                            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n");

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


            }

            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n");

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

    void procesingCallBackOt1cPays(     @NonNull StringBuffer ОТветОт1СОперациисДанными,
                                        @NonNull MyRecycleViewAdapterCommingPay myRecycleViewAdapterCommingPay,
                                        @NonNull MyViewHolderPayCommingPay holder,
                                        @NonNull MaterialCardView cardview_commingpay,
                                        @NonNull int position,
                                        @NonNull Context context,
                                        @NonNull JsonNode jsonNode1сСогласования,
                                        @NonNull RecyclerView recycleviewcommitpays,
                                        @NonNull Bl_CommintigPay bl_commintigPay) {

        try {
            if (ОТветОт1СОперациисДанными.toString().trim().matches("(.*)Операция успешна(.*)")) {
                // TODO: 23.01.2024  удаление строчки

                // TODO: 23.01.2024  удаление строчки
                myRecycleViewAdapterCommingPay. notifynotifyDataSetChanged(ОТветОт1СОперациисДанными, holder, cardview_commingpay, position);

                // TODO: 24.01.2024   после удаление перегуражаем экран PAY
                ComponensForRecyreviewNestedPay componensForRecyreviewNestedPay=new ComponensForRecyreviewNestedPay(context);


                // TODO: 24.01.2024  ;
                if (jsonNode1сСогласования.size()>0) {
                    componensForRecyreviewNestedPay.методRebootRecyreViewCommingPays(jsonNode1сСогласования,
                            myRecycleViewAdapterCommingPay, recycleviewcommitpays, ОТветОт1СОперациисДанными.toString());
                } else {
                    componensForRecyreviewNestedPay.методRebootRecyreViewCommingPaysDontRow(jsonNode1сСогласования,
                            recycleviewcommitpays, ОТветОт1СОперациисДанными.toString());
                }
                // TODO: 24.01.2024
                bl_commintigPay.МетодКпопкаСоЗачкомКраснымДополнительныйСтатус(jsonNode1сСогласования);
            }else {
                Toast.makeText(context, "Операция  не прошла !!! ", Toast.LENGTH_SHORT).show();
                Vibrator v2 = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
                v2.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE));

            }

            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"+" ОТветОт1СОперациисДанными " +ОТветОт1СОперациисДанными);

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

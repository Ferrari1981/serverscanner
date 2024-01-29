package com.dsy.dsu.PaysCommings.Model.Bl_Nested;

import android.content.Context;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dsy.dsu.CommitingPrices.View.MyRecycleViewIsNull.MyRecycleViewIsNullAdapters;
import com.dsy.dsu.Errors.Class_Generation_Errors;
import com.dsy.dsu.PaysCommings.View.RecyreView.MyRecycleViewAdapterCommingPay;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;

public class ComponensForRecyreviewNestedPay {
Context context;

    public ComponensForRecyreviewNestedPay(Context context) {
        this.context = context;
    }


   public void методRebootRecyreViewCommingPays(@NonNull JsonNode jsonNode1сСогласования
            ,@NonNull MyRecycleViewAdapterCommingPay myRecycleViewAdapterCommingPay,
                                             @NonNull RecyclerView recyclerViewPays,
                                                @NonNull String ОТветОт1СОперациисДанными) {

        try{
            if (ОТветОт1СОперациисДанными.toString().trim().matches("(.*)Операция успешна(.*)")) {
                myRecycleViewAdapterCommingPay.jsonNode1сСогласования=jsonNode1сСогласования;
                myRecycleViewAdapterCommingPay.notifyDataSetChanged();
                RecyclerView.Adapter recyclerViewОбновление=         recyclerViewPays.getAdapter();
                recyclerViewPays.swapAdapter(recyclerViewОбновление,true);
                recyclerViewPays.getAdapter().notifyDataSetChanged();
                // TODO: 24.01.2024
                recyclerViewPays.scrollToPosition(View.FOCUS_UP);

                recyclerViewPays.requestLayout();
            }
            Log.d(this.getClass().getName(), "\n" + " class " +
                    Thread.currentThread().getStackTrace()[2].getClassName()
                    + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"  + " jsonNode1сСогласования " +jsonNode1сСогласования);
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

    public void методRebootRecyreViewCommingPaysDontRow(@NonNull JsonNode jsonNode1сСогласования,
                                                 @NonNull RecyclerView recyclerViewPays,
                                                 @NonNull String ОТветОт1СОперациисДанными) {

        try{
            if (ОТветОт1СОперациисДанными.toString().trim().matches("(.*)Операция успешна(.*)")) {

                ArrayList<Boolean> arrayListIsNull1cData = new ArrayList<>();
                arrayListIsNull1cData.add(false);
                MyRecycleViewIsNullAdapters   myRecycleViewIsNullAdapters = new MyRecycleViewIsNullAdapters(arrayListIsNull1cData, context  );
                myRecycleViewIsNullAdapters.notifyDataSetChanged();
                recyclerViewPays.setAdapter(myRecycleViewIsNullAdapters);
                recyclerViewPays.getAdapter().notifyDataSetChanged();

                recyclerViewPays.scrollToPosition(View.FOCUS_UP);

                recyclerViewPays.requestLayout();
            }
            Log.d(this.getClass().getName(), "\n" + " class " +
                    Thread.currentThread().getStackTrace()[2].getClassName()
                    + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"  + " jsonNode1сСогласования " +jsonNode1сСогласования);
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

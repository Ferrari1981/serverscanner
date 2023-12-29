package com.dsy.dsu.CommitingPrices.Model.BiccessLogicaFragmentCommitPrices;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.dsy.dsu.CommitingPrices.View.MyRecycleView.MyRecycleViewIsAdapters;
import com.dsy.dsu.CommitingPrices.View.MyRecycleViewIsNull.MyRecycleViewIsNullAdapters;
import com.dsy.dsu.CommitingPrices.ViewModel.ModelComminingPrisesByte;
import com.dsy.dsu.CommitingPrices.ViewModel.ModelComminingPrisesString;
import com.dsy.dsu.Errors.Class_Generation_Errors;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import javax.inject.Inject;


public class BiznesLogicainnerFragment{

  private   Activity activity;
    private  Context context;
    private  ObjectMapper objectMapper;
    private ModelComminingPrisesString modelComminingPrisesString;
    private ModelComminingPrisesByte modelComminingPrisesByte;

    private  MyRecycleViewIsNullAdapters myRecycleViewIsNullAdapters;

    private MyRecycleViewIsAdapters myRecycleViewIsAdapters;
    private RecyclerView recycleview_comminingpprices;

    private ProgressBar prograessbar_commintingprices ;
    private  LifecycleOwner lifecycleOwner;

    public @Inject  BiznesLogicainnerFragment(@NotNull  Activity activity,
                                             @NotNull  Context context,
                                             @NotNull   ObjectMapper objectMapper,
                                             @NotNull   ModelComminingPrisesString modelComminingPrisesString,
                                             @NotNull    ModelComminingPrisesByte modelComminingPrisesByte,
                                             @NotNull   RecyclerView recycleview_comminingpprices,
                                             @NotNull    ProgressBar prograessbar_commintingprices,
                                             @NotNull  LifecycleOwner lifecycleOwner) {
        this.activity = activity;
        this.context = context;
        this.objectMapper = objectMapper;
        this.modelComminingPrisesString = modelComminingPrisesString;
        this.modelComminingPrisesByte = modelComminingPrisesByte;
        this.recycleview_comminingpprices = recycleview_comminingpprices;
        this.prograessbar_commintingprices = prograessbar_commintingprices;
        this. lifecycleOwner = lifecycleOwner;
    }

    // TODO: 26.12.2023 получение данных в виде String
 
    private void getmodelString() {
        try{
            // TODO: 25.12.2023  предварительный код  получение данныз от 1с
            // TODO: 25.12.2023 запуска callback
            getLiveDataCallBacks(lifecycleOwner);

            // TODO: 25.12.2023  запускаем получение Данных
            modelComminingPrisesString.livedatastartSetJsonSting("http://192.168.254.218/dds_copy/hs/jsonto1ccena/listofdocuments"
                    ,objectMapper);

            Log.d(this.getClass().getName(),"\n"
                    + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber());
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }


    // TODO: 26.12.2023 получение данных в виде String
 
    public void getmodelByte() {
        try{

            // TODO: 25.12.2023  предварительный код  получение данныз от 1с
            // TODO: 25.12.2023 запуска callback
            getLiveDataCallBacks(lifecycleOwner);

            // TODO: 25.12.2023  запускаем получение Данных
            modelComminingPrisesByte.livedatastartSetJsonByte("http://192.168.254.218/dds_copy/hs/jsonto1ccena/listofdocuments"
                    ,objectMapper);

            Log.d(this.getClass().getName(),"\n"
                    + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber());
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }

    public void getLiveDataCallBacks(@NotNull  LifecycleOwner lifecycleOwner){
        try{
            LiveData<Bundle> liveData1 = modelComminingPrisesByte.livedatastartGetJsonByte();
            liveData1.observe(lifecycleOwner, new Observer<Bundle>() {
                @Override
                public void onChanged(Bundle bundle) {


                  new  CallBacksLiveData(context,prograessbar_commintingprices,
                          recycleview_comminingpprices,  objectMapper).callbackLiveData(bundle);


                    Log.d(this.getClass().getName(),"\n"
                            + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                            " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                            " line " + Thread.currentThread().getStackTrace()[2].getLineNumber());
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





// TODO: 26.12.2023 download one NULL data from 1c  Согласование Цен

 
    public void startIsNullRecyreView( ) {
        try {
            if (myRecycleViewIsNullAdapters==null) {
                ArrayList<Boolean> arrayListIsNull1cData = new ArrayList<>();
                arrayListIsNull1cData.add(true);
                myRecycleViewIsNullAdapters = new MyRecycleViewIsNullAdapters(arrayListIsNull1cData, context  );
                myRecycleViewIsNullAdapters.notifyDataSetChanged();
                recycleview_comminingpprices.setAdapter(myRecycleViewIsNullAdapters);
                recycleview_comminingpprices.getAdapter().notifyDataSetChanged();

                Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                        " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                        " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" + "myRecycleViewIsNullAdapters  "
                        + myRecycleViewIsNullAdapters);
            }

            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" +"recycleview_comminingpprices  "
                    + recycleview_comminingpprices);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }

 

 


 

}///TODO  class BiznesLogicainnerFragment
package com.dsy.dsu.CommitingPrices.Model.BiccessLogicaFragmentCommitPrices;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ProgressBar;

import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dsy.dsu.CommitingPrices.Model.startingViewModels.StartingLiveDataJsonByte;
import com.dsy.dsu.CommitingPrices.Model.startingViewModels.StartingLiveDataJsonString;
import com.dsy.dsu.CommitingPrices.View.MainActivityCommitingPrices;
import com.dsy.dsu.CommitingPrices.View.MyRecycleViewIsNullAdapters;
import com.dsy.dsu.CommitingPrices.ViewModel.ModelComminingPrisesByte;
import com.dsy.dsu.CommitingPrices.ViewModel.ModelComminingPrisesString;
import com.dsy.dsu.Errors.Class_Generation_Errors;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

public class BiznesLogicainnerFragment{

  private   Activity activity;
    private  Context context;
    private  ObjectMapper getHiltJaksonObjectMapper;

    private ModelComminingPrisesString modelComminingPrisesString;
    private ModelComminingPrisesByte modelComminingPrisesByte;
    private  BiznesLogicainnerFragment biznesLogicainnerFragment;

    private  MyRecycleViewIsNullAdapters myRecycleViewIsNullAdapters;
    private RecyclerView recycleview_comminingpprices;
    private Animation animationДляСогласования;
    private ProgressBar prograessbar_commintingprices ;

    public BiznesLogicainnerFragment(Activity activity, Context context,
                                     ObjectMapper getHiltJaksonObjectMapper,
                                     ModelComminingPrisesString modelComminingPrisesString,
                                     ModelComminingPrisesByte modelComminingPrisesByte,
                                     BiznesLogicainnerFragment biznesLogicainnerFragment,
                                     MyRecycleViewIsNullAdapters myRecycleViewIsNullAdapters,
                                     RecyclerView recycleview_comminingpprices,
                                     Animation animationДляСогласования,
                                     ProgressBar prograessbar_commintingprices) {
        this.activity = activity;
        this.context = context;
        this.getHiltJaksonObjectMapper = getHiltJaksonObjectMapper;
        this.modelComminingPrisesString = modelComminingPrisesString;
        this.modelComminingPrisesByte = modelComminingPrisesByte;
        this.biznesLogicainnerFragment = biznesLogicainnerFragment;
        this.myRecycleViewIsNullAdapters = myRecycleViewIsNullAdapters;
        this.recycleview_comminingpprices = recycleview_comminingpprices;
        this.animationДляСогласования = animationДляСогласования;
        this.prograessbar_commintingprices = prograessbar_commintingprices;
    }

    // TODO: 26.12.2023 получение данных в виде String
    private void getmodelString() {
        try{

            // TODO: 25.12.2023  предварительный код  получение данныз от 1с
            // TODO: 25.12.2023  получение данныз от 1с согласования цен String
            StartingLiveDataJsonString startingLiveDataJsonString =new StartingLiveDataJsonString(modelComminingPrisesString,context);
            // TODO: 25.12.2023 запуска callback
            startingLiveDataJsonString.getLiveDataCallBacks((LifecycleOwner) activity);

            // TODO: 25.12.2023  запускаем получение Данных
            modelComminingPrisesString.livedatastartSetJsonSting("http://192.168.254.218/dds_copy/hs/jsonto1ccena/listofdocuments"
                    ,getHiltJaksonObjectMapper);

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
            // TODO: 25.12.2023  получение данныз от 1с согласования цен String
            StartingLiveDataJsonByte startingLiveDataJsonByte =new StartingLiveDataJsonByte(modelComminingPrisesByte,context,
                    biznesLogicainnerFragment);
            // TODO: 25.12.2023 запуска callback
            startingLiveDataJsonByte.getLiveDataCallBacks((LifecycleOwner) activity);


            // TODO: 25.12.2023  запускаем получение Данных
            modelComminingPrisesByte.livedatastartSetJsonByte("http://192.168.254.218/dds_copy/hs/jsonto1ccena/listofdocuments"
                    ,getHiltJaksonObjectMapper);

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


// TODO: 26.12.2023 download one NULL data from 1c  Согласование Цен


    public void startIsNullRecyreView( ) {
        try {
            if (myRecycleViewIsNullAdapters==null) {
                ArrayList<Boolean> arrayListIsNull1cData = new ArrayList<>();
                arrayListIsNull1cData.add(true);
                myRecycleViewIsNullAdapters = new MyRecycleViewIsNullAdapters(arrayListIsNull1cData, context,biznesLogicainnerFragment);
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


    public void completeIsNullRecyreView() {
        try{
            if (myRecycleViewIsNullAdapters!=null) {
                ArrayList<Boolean> arrayListIsNull1cData=new ArrayList<>();
                arrayListIsNull1cData.add(false);
                myRecycleViewIsNullAdapters.arrayListIsNull1cData=arrayListIsNull1cData;
                myRecycleViewIsNullAdapters.notifyDataSetChanged();
                RecyclerView.Adapter recyclerViewAdapter=         recycleview_comminingpprices.getAdapter();
                recycleview_comminingpprices.swapAdapter(recyclerViewAdapter,true);
                recycleview_comminingpprices.getAdapter().notifyDataSetChanged();
            }

            Log.d(this.getClass().getName(), "\n" + " class " +
                    Thread.currentThread().getStackTrace()[2].getClassName()
                    + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"
                    + " myRecycleViewIsNullAdapters " +myRecycleViewIsNullAdapters);
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

    public void dontvissiblePrograssBar() {
        // TODO: 27.12.2023
        try{
            prograessbar_commintingprices.setVisibility(View.INVISIBLE);
            prograessbar_commintingprices.requestLayout();
            prograessbar_commintingprices.refreshDrawableState();

            Log.d(this.getClass().getName(), "\n" + " class " +
                    Thread.currentThread().getStackTrace()[2].getClassName()
                    + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"
                    + " myRecycleViewIsNullAdapters " +myRecycleViewIsNullAdapters);
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


    public void МетодИнициализацииRecycleViewДляЗадач() {
        try {

            DividerItemDecoration itemDecoration =
                    new DividerItemDecoration(recycleview_comminingpprices.getContext(), DividerItemDecoration.HORIZONTAL);
            GradientDrawable drawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{0xfff7f7f7, 0xfff7f7f7});
            drawable.setSize(1,1);
            itemDecoration.setDrawable(drawable);
            recycleview_comminingpprices.addItemDecoration(itemDecoration);
            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(activity);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recycleview_comminingpprices.setLayoutManager(linearLayoutManager);
            recycleview_comminingpprices.startAnimation(animationДляСогласования);
            recycleview_comminingpprices.requestLayout();
            recycleview_comminingpprices.refreshDrawableState();
            // TODO: 28.02.2022
            Log.d(this.getClass().getName(), "\n" + " class "
                    + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n");

        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :"
                    + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }

    }
}///TODO  class BiznesLogicainnerFragment
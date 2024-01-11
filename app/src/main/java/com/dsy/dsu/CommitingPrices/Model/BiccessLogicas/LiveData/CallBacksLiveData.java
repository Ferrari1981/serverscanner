package com.dsy.dsu.CommitingPrices.Model.BiccessLogicas.LiveData;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.recyclerview.widget.RecyclerView;

import com.dsy.dsu.CommitingPrices.Model.BiccessLogicas.ByteGenetarorJsonNode;
import com.dsy.dsu.CommitingPrices.Model.BiccessLogicas.EventsBackAndAsyncAndSearchCommintPrices;
import com.dsy.dsu.CommitingPrices.Model.BiccessLogicas.InitRecyreviews.InizializayRecyreViews;
import com.dsy.dsu.CommitingPrices.View.MyRecycleView.MyRecycleViewIsAdapters;
import com.dsy.dsu.CommitingPrices.View.MyRecycleViewIsNull.MyRecycleViewIsNullAdapters;
import com.dsy.dsu.Errors.Class_Generation_Errors;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Objects;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;

public class CallBacksLiveData {

 private Context context;
    private ProgressBar prograessbar_commintingprices ;
    private RecyclerView recycleview_comminingpprices;

    private  MyRecycleViewIsNullAdapters myRecycleViewIsNullAdapters;
    private  MyRecycleViewIsAdapters myRecycleViewIsAdapters;
    private  ObjectMapper objectMapper;
    private EventsBackAndAsyncAndSearchCommintPrices eventsBackAndAsyncAndSearchCommintPrices;

    private Integer getHiltPublicId;
    public CallBacksLiveData( @NotNull  Context context,
                              @NotNull   ProgressBar prograessbar_commintingprices,
                              @NotNull   RecyclerView  recycleview_comminingpprices,
                              @NotNull MyRecycleViewIsNullAdapters myRecycleViewIsNullAdapters,
                              @NotNull ObjectMapper objectMapper,
                              @NotNull      EventsBackAndAsyncAndSearchCommintPrices eventsBackAndAsyncAndSearchCommintPrices,
                              @NotNull Integer getHiltPublicId) {
        this.context = context;
        this.prograessbar_commintingprices = prograessbar_commintingprices;
        this.recycleview_comminingpprices = recycleview_comminingpprices;
        this.myRecycleViewIsNullAdapters = myRecycleViewIsNullAdapters;
        this.objectMapper = objectMapper;
        this.eventsBackAndAsyncAndSearchCommintPrices = eventsBackAndAsyncAndSearchCommintPrices;
        this.getHiltPublicId = getHiltPublicId;
    }

    public  void callbackLiveData(Bundle bundle) {
        Completable.complete().subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                // TODO: 25.12.2023
                Bundle validadress=   Objects.requireNonNullElse(bundle,new Bundle());

                // TODO: 25.12.2023  пришел ответ в livedata от VieModel
                byte[] getbyteComminhgPrices=  validadress.getByteArray("getbyteComminhgPrices");

                // TODO: 26.12.2023  когда данные пришли от 1с согласования цен
                if (getbyteComminhgPrices!=null && getbyteComminhgPrices.length>0){

                    // TODO: 26.12.2023 пришли байты  из байт в обьект  json node

                    JsonNode     jsonNode1сСогласованиеЦен=    new ByteGenetarorJsonNode().genetarorJsonnode(context,objectMapper,getbyteComminhgPrices);

                    if (jsonNode1сСогласованиеЦен.isArray()&& jsonNode1сСогласованиеЦен.size()>0) {
                        // TODO: 28.12.2023 Запускам настрощий recyreview при получение ииз байт обьект JsonNode
                     startGetRecyreView( jsonNode1сСогласованиеЦен );

                        // TODO: 28.12.2023 инизилащитция recyreview

                        new InizializayRecyreViews(recycleview_comminingpprices,context).startInitRecyreview();


// TODO: 30.12.2023 запускаем первоночальную оценку количество записей
                        eventsBackAndAsyncAndSearchCommintPrices.new EventsAsync().eventsSearchsetNumber(jsonNode1сСогласованиеЦен);




                        // TODO: 26.12.2023 На текущего пользователя нет данных  !!!!!
                    } else {
                        // TODO: 26.12.2023 На текущего пользователя нет данных  !!!!!
                        completeIsNullRecyreView();

                        Log.d(this.getClass().getName(),"\n"
                                + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber()+ " getbyteComminhgPrices " + getbyteComminhgPrices);
                    }


                    Log.d(this.getClass().getName(),"\n"
                            + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                            " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                            " line " + Thread.currentThread().getStackTrace()[2].getLineNumber()+ " getbyteComminhgPrices " + getbyteComminhgPrices);
                }else {

                    // TODO: 26.12.2023 нет  байты
                    completeIsNullRecyreView();

                    Log.d(this.getClass().getName(),"\n"
                            + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                            " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                            " line " + Thread.currentThread().getStackTrace()[2].getLineNumber()+ " getbyteComminhgPrices " + getbyteComminhgPrices);
                }
            }

            @Override
            public void onComplete() {
                // TODO: 28.12.2023 prograsbar

                dontvissiblePrograssBar();

                Log.d(this.getClass().getName(),"\n"
                        + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                        " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                        " line " + Thread.currentThread().getStackTrace()[2].getLineNumber());
            }

            @Override
            public void onError(@NonNull Throwable e) {
                e.printStackTrace();
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                        " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                        Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            }
        });
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

                // TODO: 09.01.2024
                recyreViewReboot();
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


    // TODO: 28.12.2023 метод запуска уже настоящегно rcyreview когда первый is null прошел ага

    public void startGetRecyreView( JsonNode     jsonNode1сСогласованиеЦен ) {
        try {
            if (myRecycleViewIsAdapters==null) {
                myRecycleViewIsAdapters = new MyRecycleViewIsAdapters(jsonNode1сСогласованиеЦен, context,objectMapper ,getHiltPublicId );
                myRecycleViewIsAdapters.notifyDataSetChanged();
                recycleview_comminingpprices.setAdapter(myRecycleViewIsAdapters);
                recycleview_comminingpprices.getAdapter().notifyDataSetChanged();
                // TODO: 09.01.2024
                recyreViewReboot();

                Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                        " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                        " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" + "myRecycleViewIsAdapters  "
                        + myRecycleViewIsAdapters  + " jsonNode1сСогласованиеЦен " +jsonNode1сСогласованиеЦен);
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

    private void recyreViewReboot() {
        recycleview_comminingpprices.requestLayout();
        recycleview_comminingpprices.refreshDrawableState();
    }


    public void completeRecyreView(@NotNull  JsonNode     jsonNode1сСогласованиеЦен) {
        try{
            if (myRecycleViewIsAdapters!=null) {
                myRecycleViewIsAdapters.jsonNodeParent=jsonNode1сСогласованиеЦен;
                myRecycleViewIsAdapters.notifyDataSetChanged();
                RecyclerView.Adapter recyclerViewAdapter=         recycleview_comminingpprices.getAdapter();
                recycleview_comminingpprices.swapAdapter(recyclerViewAdapter,true);
                recycleview_comminingpprices.getAdapter().notifyDataSetChanged();

                // TODO: 09.01.2024
                recyreViewReboot();
            }

            Log.d(this.getClass().getName(), "\n" + " class " +
                    Thread.currentThread().getStackTrace()[2].getClassName()
                    + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"
                    + " jsonNode1сСогласованиеЦен " +jsonNode1сСогласованиеЦен);
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





}

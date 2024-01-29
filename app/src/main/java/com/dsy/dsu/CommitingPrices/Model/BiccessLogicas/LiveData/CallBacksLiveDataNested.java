package com.dsy.dsu.CommitingPrices.Model.BiccessLogicas.LiveData;

import android.content.Context;
import android.util.Log;

import androidx.recyclerview.widget.RecyclerView;

import com.dsy.dsu.CommitingPrices.Model.BiccessLogicas.InitRecyreviews.InizializayRecyreViewsNested;
import com.dsy.dsu.CommitingPrices.Model.NestedDataGetAll.GetArrayNodeForNestedChildern;
import com.dsy.dsu.CommitingPrices.View.MyRecycleView.MyViewHoldersCommintPrices;
import com.dsy.dsu.CommitingPrices.View.MyRecycleViewNested.MyRecycleViewIsAdaptersNested;
import com.dsy.dsu.Errors.Class_Generation_Errors;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import org.jetbrains.annotations.NotNull;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;

public class CallBacksLiveDataNested {

 private Context context;


    private RecyclerView recycleview_comminingppricesNesteds;
    private  JsonNode  jsonNodeNested;
    private MyViewHoldersCommintPrices holder;
    private  MyRecycleViewIsAdaptersNested myRecycleViewIsAdaptersNested;
    private  int postion;
    private ObjectMapper objectMapper;

    private Integer getHiltPublicId;
    private    String getHiltCommintgPrices;

    public CallBacksLiveDataNested(@NotNull MyViewHoldersCommintPrices holder,
                                   @NotNull  Context context,
                                   @NotNull   RecyclerView  recycleview_comminingpricesNested,
                                   @NotNull JsonNode  jsonNodeNested,
                                   @NotNull int postion,
                                   @NotNull ObjectMapper objectMapper,
                                   @NotNull Integer getHiltPublicId,
                                   @NotNull   String getHiltCommintgPrices) {
        this.context = context;
        this.recycleview_comminingppricesNesteds = recycleview_comminingpricesNested;
        this.jsonNodeNested = jsonNodeNested;
        this.holder = holder;
        this.postion = postion;
        this.objectMapper = objectMapper;
        this.getHiltPublicId = getHiltPublicId;
        this.getHiltCommintgPrices = getHiltCommintgPrices;
        Log.d(this.getClass().getName(),"\n"
                + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber()+ " jsonNodeNested " + jsonNodeNested);

    }

    public  void callbackLiveData( ) {
        Completable.complete().subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                // TODO: 25.12.2023
                // TODO: 26.12.2023  когда данные пришли от 1с согласования цен

                if (jsonNodeNested!=null && jsonNodeNested.size()>0){

                    // TODO: 28.12.2023 инизилащитция recyreview
                    new InizializayRecyreViewsNested(recycleview_comminingppricesNesteds,context).startInitRecyreview();

                    // TODO: 28.12.2023 Запускам настрощий recyreview при получение ииз байт обьект JsonNode
                    if (myRecycleViewIsAdaptersNested==null) {
                        startGetRecyreViewNested(   );
                    }else{
                        // TODO: 26.12.2023 нет  байты
                        completeRecyreViewNested(jsonNodeNested);
                    }



                    Log.d(this.getClass().getName(),"\n"
                            + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                            " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                            " line " + Thread.currentThread().getStackTrace()[2].getLineNumber()+ " jsonNodeNested " + jsonNodeNested);
                }
            }

            @Override
            public void onComplete() {
                // TODO: 28.12.2023 prograsbar

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


    // TODO: 28.12.2023 метод запуска уже настоящегно rcyreview когда первый is null прошел ага

    public void startGetRecyreViewNested(  ) {
        try {


                myRecycleViewIsAdaptersNested = new MyRecycleViewIsAdaptersNested(holder.itemView, context
                        ,jsonNodeNested, postion,objectMapper,getHiltPublicId,getHiltCommintgPrices);
                myRecycleViewIsAdaptersNested.notifyDataSetChanged();
                recycleview_comminingppricesNesteds.setAdapter(myRecycleViewIsAdaptersNested);
                recycleview_comminingppricesNesteds.getAdapter().notifyDataSetChanged();
                

            // TODO: 10.01.2024  reebott dizayn recyreview nested

            rebbotdizaynRecyreViewNested();

                Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                        " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                        " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" + "myRecycleViewIsAdaptersNested  "
                        + myRecycleViewIsAdaptersNested  + " jsonNodeNested " +jsonNodeNested);

        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }







    public void completeRecyreViewNested(@NotNull  JsonNode     jsonNodeNested) {
        try{


                // TODO: 09.01.2024  класс получаем все дочерние элементы ArrayNoide
                GetArrayNodeForNestedChildern getArrayNodeForNestedChildern=new GetArrayNodeForNestedChildern(context,  jsonNodeNested );
               ArrayNode arrayNodeNested=   getArrayNodeForNestedChildern.arrayNodeNested();



                // TODO: 09.01.2024
                myRecycleViewIsAdaptersNested.ArrayNodeNested=arrayNodeNested;
                myRecycleViewIsAdaptersNested.notifyDataSetChanged();
                RecyclerView.Adapter recyclerViewAdapter=         recycleview_comminingppricesNesteds.getAdapter();
                recycleview_comminingppricesNesteds.swapAdapter(recyclerViewAdapter,true);
                recycleview_comminingppricesNesteds.getAdapter().notifyDataSetChanged();

                // TODO: 10.01.2024  reebott dizayn recyreview nested

                rebbotdizaynRecyreViewNested();


            Log.d(this.getClass().getName(), "\n" + " class " +
                    Thread.currentThread().getStackTrace()[2].getClassName()
                    + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"
                    + " jsonNodeNested " +jsonNodeNested);
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

    private void rebbotdizaynRecyreViewNested() {
        recycleview_comminingppricesNesteds.requestLayout();
        recycleview_comminingppricesNesteds.refreshDrawableState();
    }


}

package com.dsy.dsu.PaysCommings.View.RecyreView;

// TODO: 28.02.2022 ViewHolder

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.loader.content.AsyncTaskLoader;
import androidx.recyclerview.widget.RecyclerView;

import com.dsy.dsu.PaysCommings.Model.BI_RecyreView.Bl_CommintigPay;
import com.dsy.dsu.PaysCommings.Model.BI_RecyreView.FileFrom1CCommitPay;
import com.dsy.dsu.PaysCommings.Model.BI_RecyreView.ProccesingCancelOrOKPay;
import com.dsy.dsu.PaysCommings.Model.Bl_Nested.BlrecyrceViewNestedPay;
import com.dsy.dsu.Errors.Class_Generation_Errors;
import com.dsy.dsu.R;
import com.dsy.dsu.Services.Service_Notificatios_Для_Согласования;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.TextNode;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;
import com.jakewharton.rxbinding4.view.RxView;

import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import kotlin.Unit;

@SuppressLint("SuspiciousIndentation")
public class MyRecycleViewAdapterPay extends RecyclerView.Adapter<MyViewHolderPay> {
 public    JsonNode jsonNode1сСогласования;
  JsonNode jsonNode1сСогласованияRow;
    
    Context context;

    MyViewHolderPay myViewHolderPay;

    Bl_CommintigPay bl_commintigPay;


    AsyncTaskLoader<JsonNode> asyncTaskLoader;

    Service_Notificatios_Для_Согласования.LocalBinderДляСогласования binderСогласования1C;
    Animation animation1;
    Integer ПубличныйidPay;
    ObjectMapper objectMapper;
    BottomNavigationView bottomNavigationViewParent;
    public MyRecycleViewAdapterPay(@NotNull JsonNode jsonNode1сСогласования,
                                   @NonNull Context context,
                                   @NonNull AsyncTaskLoader<JsonNode> asyncTaskLoader,
                                   @NonNull Service_Notificatios_Для_Согласования.LocalBinderДляСогласования binderСогласования1C,
                                   @NotNull Animation animation1,
                                   @NonNull Integer ПубличныйidPay,
                                   @NonNull ObjectMapper objectMapper,
                                   @NonNull BottomNavigationView bottomNavigationViewParent) {
        // super();
        if (jsonNode1сСогласования!=null) {
            this.jsonNode1сСогласования = jsonNode1сСогласования;
            this.context = context;
            this.asyncTaskLoader = asyncTaskLoader;
            this.binderСогласования1C = binderСогласования1C;
            this.animation1 = animation1;
            this.ПубличныйidPay = ПубличныйidPay;
            this.objectMapper = objectMapper;
            this.bottomNavigationViewParent = bottomNavigationViewParent;
        }

        bl_commintigPay=new Bl_CommintigPay(context);

        Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber()  );

    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolderPay holder, @NonNull int position, @NonNull List<Object> payloads) {
        Log.i(this.getClass().getName(), "   onBindViewHolder  position" + position);
        try {
            if (  jsonNode1сСогласования.size()>0) {

                jsonNode1сСогласованияRow = jsonNode1сСогласования.get(position); // Here's

                Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                        " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                        " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" +"JsonRowДанныеСогласование1С "
                        + jsonNode1сСогласованияRow +
                        " jsonNode1сСогласованияRow " + jsonNode1сСогласованияRow     + " position " +position);
            }
            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" +"jsonNode1сСогласования "
                    + jsonNode1сСогласования + " position " +position);
            // TODO: 30.03.2022
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
        super.onBindViewHolder(holder, position, payloads);
    }







    @Override
    public void setHasStableIds(boolean hasStableIds) {
        super.setHasStableIds(hasStableIds);
    }

    @Override
    public void onViewRecycled(@NonNull MyViewHolderPay holder) {
        super.onViewRecycled(holder);
    }

    @Override
    public boolean onFailedToRecycleView(@NonNull MyViewHolderPay holder) {
        // TODO: 03.11.2023 Parent
        return super.onFailedToRecycleView(holder);

    }

    @Override
    public void onViewAttachedToWindow(@NonNull MyViewHolderPay holder) {
        super.onViewAttachedToWindow(holder);

    }

    @Override
    public void onViewDetachedFromWindow(@NonNull MyViewHolderPay holder) {
        super.onViewDetachedFromWindow(holder);
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {

        recyclerView.removeAllViews();

        recyclerView.getRecycledViewPool().clear();
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
    }

    @Override
    public int getItemViewType(int position) {
        Log.i(this.getClass().getName(), "      holder.textView1  position " + position);
        try {
            // TODO: 30.03.2022
            Log.d(context.getClass().getName(), "\n"
                    + " время: " + new Date()+"\n+" +
                    " Класс в процессе... " +  this.getClass().getName()+"\n"+
                    " метод в процессе... " + Thread.currentThread().getStackTrace()[2].getMethodName()+" position" + position);
            // TODO: 30.03.2022
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }

        return super.getItemViewType(position);
    }


    @NonNull
    @Override
    public MyViewHolderPay onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewГлавныйВидДляRecyclleViewДляСогласования = null;
        try {
            if (jsonNode1сСогласования!=null) {
                if (jsonNode1сСогласования.size()>0) {
                             /*   viewГлавныйВидДляRecyclleViewДляСогласования = LayoutInflater.from(parent.context)
                                        .inflate(R.layout.simple_for_commitpay_cardview1, parent, false);//todo old simple_for_takst_cardview1*/
                             /*   viewГлавныйВидДляRecyclleViewДляСогласования = LayoutInflater.from(parent.context)
                                        .inflate(R.layout.simple_for_commitpay_cardview_file, parent, false);//todo old simple_for_takst_cardview1*/
                              /*  viewГлавныйВидДляRecyclleViewДляСогласования = LayoutInflater.from(parent.context)
                                        .inflate(R.layout.simple_for_commitpay_cardview_grid_file, parent, false);//todo old simple_for_takst_cardview1*/
                       /*         viewГлавныйВидДляRecyclleViewДляСогласования = LayoutInflater.from(parent.context)
                                        .inflate(R.layout.simple_for_commitpay_cardview_grid_file, parent, false);//todo old simple_for_takst_cardview1*/

                    viewГлавныйВидДляRecyclleViewДляСогласования = LayoutInflater.from(parent.getContext())
                            .inflate(R.layout.    simple_for_commitpay_cardview_withnested2, parent, false);//todo old simple_for_takst_cardview1
                } else {
                    viewГлавныйВидДляRecyclleViewДляСогласования = LayoutInflater.from(parent.getContext())
                            .inflate(R.layout.simple_for_commitpay_cardview1empty, parent, false);//todo old simple_for_takst_cardview1
                }

            }else{
                if (asyncTaskLoader.isStarted()) {
                    viewГлавныйВидДляRecyclleViewДляСогласования = LayoutInflater.from(parent.getContext())
                            .inflate(R.layout.simple_for_commitpay_cardview1empty_in_prossering, parent, false);
                } else {
                    viewГлавныйВидДляRecyclleViewДляСогласования = LayoutInflater.from(parent.getContext())
                            .inflate(R.layout.simple_for_commitpay_dont_jsonot1c, parent, false);
                }
            }

            // TODO: 22.03.2022
            myViewHolderPay = new MyViewHolderPay(viewГлавныйВидДляRecyclleViewДляСогласования,context,asyncTaskLoader,jsonNode1сСогласованияRow);
            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" + "   myViewHolderPay" + myViewHolderPay);

        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
        return myViewHolderPay;

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderPay holder, int position) {
        try {
            Log.i(this.getClass().getName(), "   создание согласования"
                    + myViewHolderPay
                    + " jsonNode1сСогласования " + jsonNode1сСогласования);
            // TODO: 03.11.2023  работает приналичии Данных с 1С
            if (jsonNode1сСогласования.size()>0 &&  asyncTaskLoader.isReset()) {

                // TODO: 12.01.2024 Заполняем Данными Компоненты

                МетодБиндингаСозданиеНомерДокумента(holder, jsonNode1сСогласованияRow);
                МетодБиндингаСозданиеСФО(holder, jsonNode1сСогласованияRow);
                МетодБиндингаСозданиеОрганизация(holder, jsonNode1сСогласованияRow);
                МетодБиндингаСозданиеКонтрагент(holder, jsonNode1сСогласованияRow);
                МетодБиндингаСозданиеСумма(holder, jsonNode1сСогласованияRow);
                МетодБиндингаСозданиеДДС(holder, jsonNode1сСогласованияRow);
                МетодБиндингаСозданиеНомелклатура(holder, jsonNode1сСогласованияRow);





                // TODO: 12.01.2024 кнопки
                МетодКпопкаОтказаСогласования(holder);

                МетодКпопкаСогласованияУспешное(holder, ПубличныйidPay);

                // TODO: 12.01.2024 обработка видимости Prograssbar 
                МетодForPrograBarInner(holder);






                // TODO: 12.01.2024 Клик Чтобы Открыть Скрытий recyreview
                МетодКпопкаРаскрытияСкрытогоReCyreViewNested(holder);





                // TODO: 12.01.2024 код для Внутренего recyreView nested Pay Дополнительный Внтерний в Будущем RecyreView Nested Для Дополнительной ИНформацией
                BlrecyrceViewNestedPay blrecyrceViewNestedPay=new BlrecyrceViewNestedPay(context,holder,jsonNode1сСогласованияRow);




                // TODO: 03.11.2023 дополнитешльный механизм добаляем файлы с 1С
                downloadFileFrom1C(holder, jsonNode1сСогласованияRow,objectMapper);



                // TODO: 03.11.2023  метод повторгого переопределения Кнопок снизу
           bl_commintigPay.    МетодКпопкаСоЗачкомКраснымДополнительныйСтатус( jsonNode1сСогласования,bottomNavigationViewParent);

            }else{
                // TODO: 01.03.2022
                Log.i(this.getClass().getName(), "  Нет данных для занрузки   subClassBuccessLogin_главныйКлассБизнесЛогикиФрагмент1Согласование. " +
                        " МетодРелистарцииЛокальногоБродкастераПослеСменыСтатусаСогласования(holder);  holder " +holder);
            }

            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"
                    + " jsonNode1сСогласования " +jsonNode1сСогласования);

        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }



    // TODO: 03.11.2023  метод загрузки файлов с 1с
    void  downloadFileFrom1C(@NonNull MyViewHolderPay holder, @NotNull JsonNode jsonNode1сСогласованияRow,@NonNull ObjectMapper objectMapper){
        try {
        // TODO: 03.11.2023 advanset code Downloaf Image rom Commit Pay
        // TODO: 03.11.2023  запускаем получние отображения File from 1c
        FileFrom1CCommitPay fileFrom1CCommitPay1=new FileFrom1CCommitPay(holder ,context) ;
        // TODO: 08.11.2023 строчка добавление файлов FILE  от 1С
        fileFrom1CCommitPay1.startFileFrom1CCommitPay(jsonNode1сСогласованияRow,holder,binderСогласования1C,animation1, ПубличныйidPay,objectMapper);



        Log.d(this.getClass().getName(),"\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"+"   holder.tableLayoutcommitpayfiles "
                +   holder.tableLayoutcommitpayfiles
                + " jsonNode1сСогласованияRow " +jsonNode1сСогласованияRow );
    } catch (Exception e) {
        e.printStackTrace();
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
        new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
    }

    }



    ///todo первый метод #1

    private void МетодБиндингаСозданиеНомерДокумента(@NonNull MyViewHolderPay holder, @NonNull JsonNode jsonNode1сСогласованияRow) {
        try {
            if (jsonNode1сСогласованияRow!=null && holder.tx_nomer!=null ) {///"Ndoc"

                String    ПерваяСтрочкаЗначения=    jsonNode1сСогласованияRow.get("Ndoc").asText().trim();

                holder.tx_nomer.setText(ПерваяСтрочкаЗначения);
                holder.butt_successcommit.setTag(ПерваяСтрочкаЗначения);

                holder.butt_cancel.setTag(ПерваяСтрочкаЗначения);
                holder.tx_nomer.setTag(ПерваяСтрочкаЗначения);

                holder.tx_nomer .requestLayout();
                holder.tx_nomer .refreshDrawableState();

                Log.i(this.getClass().getName(), "  Ndoc   holder.butt_successcommit " +  holder.butt_successcommit.getTag()+
                        "     holder.butt_cancel " +    holder.butt_cancel.getTag() );

            }
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

    ///todo первый метод #2

    private void МетодБиндингаСозданиеДДС(@NonNull MyViewHolderPay holder, @NonNull JsonNode jsonNode1сСогласованияRow) {

        try {
            // TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1

            if (jsonNode1сСогласованияRow!=null &&   holder.tx_statiy!=null ) {

                String ПерваяСтрочкаЗначения = jsonNode1сСогласованияRow.get("articleDDS").asText();
                // TODO: 02.03.2022
                Log.i(this.getClass().getName(), "  articleDDS ПерваяСтрочкаЗначения " + ПерваяСтрочкаЗначения);
                // TODO: 28.02.2022
                holder.tx_statiy.setText(ПерваяСтрочкаЗначения);
                holder.tx_statiy.setTag(ПерваяСтрочкаЗначения);

                holder.tx_statiy .requestLayout();
                holder.tx_statiy .refreshDrawableState();

            }
            Log.d(context.getClass().getName(), "\n"
                    + " время: " + new Date()+"\n+" +
                    " Класс в процессе... " +  this.getClass().getName()+"\n"+
                    " метод в процессе... " + Thread.currentThread().getStackTrace()[2].getMethodName());
            // TODO: 28.02.2022*/
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }

    }
    ///todo первый метод #3

    private void МетодБиндингаСозданиеКонтрагент(@NonNull MyViewHolderPay holder, @NonNull JsonNode jsonNode1сСогласованияRow) {

        try {
            // TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1

            if (jsonNode1сСогласования!=null &&  holder.tx_kontragent!=null ) {
                //TODO
                String ПерваяСтрочкаЗначения = jsonNode1сСогласованияRow.get("counterparty").asText();
                // TODO: 02.03.2022

                // TODO: 02.03.2022
                Log.i(this.getClass().getName(), " organization ПерваяСтрочкаЗначения " + ПерваяСтрочкаЗначения);
                // TODO: 28.02.2022
                holder.tx_kontragent.setText(ПерваяСтрочкаЗначения);
                holder.tx_kontragent.setTag(ПерваяСтрочкаЗначения);

                holder.tx_kontragent .requestLayout();
                holder.tx_kontragent.refreshDrawableState();

            }
            Log.d(context.getClass().getName(), "\n"
                    + " время: " + new Date()+"\n+" +
                    " Класс в процессе... " +  this.getClass().getName()+"\n"+
                    " метод в процессе... " + Thread.currentThread().getStackTrace()[2].getMethodName());
            // TODO: 28.02.2022*/
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            //   mNotificationManagerДляЧАТА.cancel(1);///.cancelAll();
        }

    }




    ///todo первый метод #4

    private void МетодБиндингаСозданиеСФО(@NonNull MyViewHolderPay holder, @NonNull JsonNode jsonNode1сСогласованияRow) {

        try {
            // TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1
            if (holder.tx_zfo !=null && jsonNode1сСогласованияRow!=null ) {
                //todo
                String ПерваяСтрочкаЗначения = jsonNode1сСогласованияRow.get("CFO").asText();
                // TODO: 02.03.2022

                Log.i(this.getClass().getName(), " CFO ПерваяСтрочкаЗначения " + ПерваяСтрочкаЗначения);
                // TODO: 28.02.2022
                //TODo
                holder.tx_zfo .setText(ПерваяСтрочкаЗначения);

                holder.tx_zfo .requestLayout();
                holder.tx_zfo .refreshDrawableState();

            }
            Log.d(context.getClass().getName(), "\n"
                    + " время: " + new Date()+"\n+" +
                    " Класс в процессе... " +  this.getClass().getName()+"\n"+
                    " метод в процессе... " + Thread.currentThread().getStackTrace()[2].getMethodName());
            // TODO: 28.02.2022*/
        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            //   mNotificationManagerДляЧАТА.cancel(1);///.cancelAll();
        }

    }


    ///todo первый метод #7

    private void МетодБиндингаСозданиеНомелклатура(@NonNull MyViewHolderPay holder, @NonNull JsonNode jsonNode1сСогласованияRow) {
        try {
            // TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1
            if (jsonNode1сСогласованияRow!=null) {
                StringBuffer stringBufferArrayNamelk=new StringBuffer();
                final Integer[] ИНдексТекущий = {1};
                // String ПерваяСтрочкаЗначения = jsonNode1сСогласованияRow.get("nomenclature").asText()

                jsonNode1сСогласованияRow.get("nomenclature")
                        .elements()
                        .forEachRemaining(new Consumer<JsonNode>() {
                            @Override
                            public void accept(JsonNode jsonNode) {
                                JsonNode jsonNodesArrayНамелклатура= jsonNode.deepCopy();
                                jsonNodesArrayНамелклатура.forEach(new Consumer<JsonNode>() {
                                    @Override
                                    public void accept(JsonNode jsonNode) {
                                        TextNode textNode=  jsonNode.deepCopy();
                                        if (!textNode.isNull()) {
                                            stringBufferArrayNamelk.append(textNode.asText());
                                            if(ИНдексТекущий[0]< jsonNode1сСогласованияRow.get("nomenclature").size()){
                                                // TODO: 24.11.2023
                                                ИНдексТекущий[0]++;
                                                stringBufferArrayNamelk.append("\n");
                                            }

                                            Log.d(context.getClass().getName(), "\n"
                                                    + " время: " + new Date()+"\n+" +
                                                    " Класс в процессе... " +  this.getClass().getName()+"\n"+
                                                    " метод в процессе... " + Thread.currentThread().getStackTrace()[2].getMethodName());
                                        }
                                        // TODO: 24.11.2023
                                    }
                                });


                            }
                        });

                // TODO: 24.11.2023 слашателя

                listerDizayinNamelklatyra(holder.tx_namelklatura, holder.TextViewНамелклатура);

                holder.tx_namelklatura.setText(stringBufferArrayNamelk);
                holder.tx_namelklatura.setTag(stringBufferArrayNamelk);

                holder.tx_namelklatura .requestLayout();
                holder.tx_namelklatura .refreshDrawableState();

                Log.d(context.getClass().getName(), "\n"
                        + " время: " + new Date()+"\n+" +
                        " Класс в процессе... " +  this.getClass().getName()+"\n"+
                        " метод в процессе... " + Thread.currentThread().getStackTrace()[2].getMethodName()+
                        "  nomenclature stringBufferArrayNamelk " + stringBufferArrayNamelk);

            }


        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }

    }

    private void listerDizayinNamelklatyra(TextView holder, TextView holder1) {
        holder.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                holder.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                int height =  holder.getHeight();
                int width =  holder.getWidth();
                holder1.setHeight( height);
                holder1.requestLayout();
                holder1.forceLayout();
            }
        });
    }
    // TODO: 14.03.2022  Успешное Согласования

    private void МетодКпопкаСогласованияУспешное(@NonNull MyViewHolderPay holder ,@NonNull Integer ПубличныйidPay)
            throws ExecutionException, InterruptedException {
        try {
            Log.d(this.getClass().getName(), "   КнопкаУспешноеСогласования    Успехх Согласования 2 " );

            final Handler[] handler = {null};

            // TODO: 10.11.2023 клик по файлов
            RxView.clicks(   holder. butt_successcommit)
                    .throttleFirst(2, TimeUnit.SECONDS)
                    .filter(s -> !s.toString().isEmpty())
                    .map(new Function<Unit, Object>() {
                        @Override
                        public Object apply(Unit unit) throws Throwable {
                            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" );
                            handler[0] =holder. butt_successcommit.getHandler();
                            return    holder. butt_successcommit;
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

                        proccerClickSucceesPay(holder, handler, (MaterialButton) GetNameSingleNewFile1c,  ПубличныйidPay);


                        Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" );


                    });



        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }

    // TODO: 12.01.2024  метод срабоатывает когда нажали Согласовать Succeeess
    private void proccerClickSucceesPay(@NonNull MyViewHolderPay holder,
                                        Handler[] handler,
                                        MaterialButton materialButtonКнопкаУспешноеСогласования,@NonNull Integer ПубличныйidPay) {
        try{

            materialButtonКнопкаУспешноеСогласования.animate().rotationX(40l);

            handler[0].postDelayed(new Runnable() {
                @Override
                public void run() {
                    try{
                        String ПолученыйНомерДокусментаДляОтправки=      materialButtonКнопкаУспешноеСогласования.getTag().toString().trim()   ;

                        Intent заданиеНаВыполение=new Intent();
                        заданиеНаВыполение.setAction( "ЗапускаемСогласованиеОтказИлилУспешное");
                        Bundle bundleДляПередачиВСлужбуСогласования=new Bundle();
                        bundleДляПередачиВСлужбуСогласования.putInt("PROCESS_IDСогласования", Integer.parseInt("28"));
                        bundleДляПередачиВСлужбуСогласования.putString("ПолученныйНомерДокументаСогласования", ПолученыйНомерДокусментаДляОтправки);
                        bundleДляПередачиВСлужбуСогласования.putInt("ПередаемСтатусСогласования", 2);///TODO выполнил Согласования
                        bundleДляПередачиВСлужбуСогласования.putInt("ПубличныйidPay", ПубличныйidPay);///TODO выполнил Согласования
                        заданиеНаВыполение.putExtras(bundleДляПередачиВСлужбуСогласования);

                        holder.  butt_successcommit.setTag(bundleДляПередачиВСлужбуСогласования);

                        Log.d(context.getClass().getName(), "заданиеНаВыполение "
                                + заданиеНаВыполение+ "bundleДляПередачиВСлужбуСогласования "+bundleДляПередачиВСлужбуСогласования);

                        ///TODO выполнил Согласования
                       ProccesingCancelOrOKPay proccesingCancelOrOKPay=new  ProccesingCancelOrOKPay(context,binderСогласования1C,jsonNode1сСогласования,animation1,objectMapper);
                        proccesingCancelOrOKPay.proccerCancelOrOKPay(заданиеНаВыполение,  materialButtonКнопкаУспешноеСогласования);



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


    // TODO: 12.01.2024 Кнопка РАскрытие Скрытого recyreview


    private void МетодКпопкаРаскрытияСкрытогоReCyreViewNested(@NonNull MyViewHolderPay holder)
            throws ExecutionException, InterruptedException {
        try {
            Log.d(this.getClass().getName(), "   КнопкаУспешноеСогласования    Успехх Согласования 2 " );

            final Handler[] handler = {null};

            // TODO: 10.11.2023 клик по файлов
            RxView.clicks(   holder. arrowpay_nested_receriview_commitingpay)
                    .throttleFirst(2,TimeUnit.SECONDS)
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





    private void МетодForPrograBarInner(@NonNull MyViewHolderPay holder)
    {
        try {
            holder.progressbar_commingpay.setVisibility(View.INVISIBLE);

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
    // TODO: 01.08.2022





    //TODO вторая кнопка
    // TODO: 14.03.2022  отказа Согласования
    private void МетодКпопкаОтказаСогласования(@NonNull MyViewHolderPay holder)
            throws ExecutionException, InterruptedException {
        try {
            // TODO: 02.03.2022
            Log.d(this.getClass().getName(), "  КнопкаСогласованиеОтказ    отказ 1  " );


            final Handler[] handler = {null};

            RxView.clicks(   holder. butt_cancel)
                    .throttleFirst(2,TimeUnit.SECONDS)
                    .filter(s -> !s.toString().isEmpty())
                    .map(new Function<Unit, Object>() {
                        @Override
                        public Object apply(Unit unit) throws Throwable {
                            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" );
                            handler[0] =      holder. butt_cancel.getHandler();
                            return    holder. butt_cancel;
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
                        Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" );


                        procceringCancelButtonClick(holder, handler[0], (MaterialButton) GetNameSingleNewFile1c);


                        Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"  );

                    });

        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }


    // TODO: 12.01.2024  Дейставия по кнопек ОТКАЗ
    private void procceringCancelButtonClick(@NonNull MyViewHolderPay holder, Handler handler, MaterialButton materialButtonКнопкаCancel) {
        try{

            materialButtonКнопкаCancel.animate().rotationX(40l);

            String ПолученыйНомерДокусментаДляОтправки=  materialButtonКнопкаCancel.getTag().toString().trim()    ;


            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    try{
                        Intent заданиеНаВыполение=new Intent();
                        // TODO: 17.11.2021
                        заданиеНаВыполение.setAction( "ЗапускаемСогласованиеОтказИлилУспешное");
                        Bundle bundleДляПередачиВСлужбуСогласования=new Bundle();
                        bundleДляПередачиВСлужбуСогласования.putInt("PROCESS_IDСогласования", Integer.parseInt("28"));
                        bundleДляПередачиВСлужбуСогласования.putString("ПолученныйНомерДокументаСогласования",ПолученыйНомерДокусментаДляОтправки );
                        bundleДляПередачиВСлужбуСогласования.putInt("ПередаемСтатусСогласования", 1);///TODO выполнил Согласования
                        bundleДляПередачиВСлужбуСогласования.putInt("ПубличныйidPay", ПубличныйidPay);//ПубличныйidPay

                        заданиеНаВыполение.putExtras(bundleДляПередачиВСлужбуСогласования);

                        holder.  butt_cancel.setTag(bundleДляПередачиВСлужбуСогласования);

                        ///TODO выполнил ОТКАЗ Cancel
                        ProccesingCancelOrOKPay proccesingCancelOrOKPay=new  ProccesingCancelOrOKPay(context,binderСогласования1C,jsonNode1сСогласования,animation1,objectMapper);
                        proccesingCancelOrOKPay.proccerCancelOrOKPay(заданиеНаВыполение,  materialButtonКнопкаCancel);



                        Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"  );
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


    ///todo первый метод #3

    private void МетодБиндингаСозданиеОрганизация(@NonNull MyViewHolderPay holder, @NonNull JsonNode jsonNode1сСогласованияRow) {

        try {
            // TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1

            if (jsonNode1сСогласованияRow!=null &&   holder.tx_organizations !=null ) {
                //TODO
                String ПерваяСтрочкаЗначения = jsonNode1сСогласованияRow.get("organization").asText();
                // TODO: 02.03.2022

                // TODO: 02.03.2022
                Log.i(this.getClass().getName(), " organization ПерваяСтрочкаЗначения " + ПерваяСтрочкаЗначения);
                // TODO: 28.02.2022
                holder.tx_organizations.setText(ПерваяСтрочкаЗначения);
                holder.tx_organizations.setTag(ПерваяСтрочкаЗначения);

                holder.tx_organizations .requestLayout();
                holder.tx_organizations .refreshDrawableState();
            }

            // TODO: 28.02.2022*/
        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            //   mNotificationManagerДляЧАТА.cancel(1);///.cancelAll();
        }

    }

    ///todo первый метод #5








    private void МетодБиндингаСозданиеСумма(@NonNull MyViewHolderPay holder, @NonNull JsonNode jsonNode1сСогласованияRow) {

        try {
            // TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1

            if (jsonNode1сСогласованияRow!=null &&  holder.tx_sum !=null ) {
                //TODO
                String ПерваяСтрочкаЗначения = jsonNode1сСогласованияRow.get("sum").asText();
                // TODO: 02.03.2022

                // TODO: 02.03.2022
                Log.i(this.getClass().getName(), "  sum ПерваяСтрочкаЗначения " + ПерваяСтрочкаЗначения);
                // TODO: 28.02.2022
                holder.tx_sum.setText(ПерваяСтрочкаЗначения.toString()+ " руб");
                holder.tx_sum.setTag(ПерваяСтрочкаЗначения);

                holder.tx_sum .requestLayout();
                holder.tx_sum .refreshDrawableState();

            }

            // TODO: 28.02.2022*/
        } catch (Exception e) {
            e.printStackTrace();
            ///метод запись ошибок в таблицу
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            //   mNotificationManagerДляЧАТА.cancel(1);///.cancelAll();
        }

    }

























    // TODO: 29.03.2022  слутаеть смены статуса







    @Override
    public long getItemId(int position) {
        // TODO: 04.03.2022

        Log.i(this.getClass().getName(), "     getItemId holder.position " + position);

        return super.getItemId(position);

    }




    @Override
    public int getItemCount() {
        // TODO: 02.03.2022
        int КоличесвоСтрок;
        if (jsonNode1сСогласования.size()>0) {
            КоличесвоСтрок = jsonNode1сСогласования.size();
            Log.d(this.getClass().getName(), "jsonNode1сСогласования.size() " + jsonNode1сСогласования.size() + " КоличесвоСтрок " +КоличесвоСтрок);
        } else {
            КоличесвоСтрок=1;
            Log.d(this.getClass().getName(), "jsonNode1сСогласования.size() " + jsonNode1сСогласования.size() + " холостой ход КоличесвоСтрок " +КоличесвоСтрок);
        }
        Log.d(this.getClass().getName(), "jsonNode1сСогласования.size() " + jsonNode1сСогласования.size() + " КоличесвоСтрок " +КоличесвоСтрок);

        // TODO: 28.02.2022
        return КоличесвоСтрок ;
    }
}//TODO  конец два11
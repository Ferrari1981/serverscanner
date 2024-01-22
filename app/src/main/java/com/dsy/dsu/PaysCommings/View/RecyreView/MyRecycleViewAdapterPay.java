package com.dsy.dsu.PaysCommings.View.RecyreView;

// TODO: 28.02.2022 ViewHolder

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dsy.dsu.PaysCommings.Model.BI_RecyreView.Bl_CommintigPay;
import com.dsy.dsu.PaysCommings.Model.BI_RecyreView.FileFrom1CCommitPay;
import com.dsy.dsu.PaysCommings.Model.BI_RecyreView.ProccesingCancelOrOKPay;
import com.dsy.dsu.Errors.Class_Generation_Errors;
import com.dsy.dsu.R;
import com.dsy.dsu.Services.Service_Notificatios_Для_Согласования;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.TextNode;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.card.MaterialCardView;
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


  public   JsonNode jsonNode1сСогласования;
    JsonNode jsonNode1сСогласованияSingleRow;

    Context context;

    MyViewHolderPay myViewHolderPay;

    Bl_CommintigPay bl_commintigPay;

    Service_Notificatios_Для_Согласования.LocalBinderДляСогласования binderСогласования1C;
    Animation animation1;
    Integer ПубличныйidPay;
    ObjectMapper objectMapper;
    BottomNavigationView bottomNavigationViewParent;
    RecyclerView recycleviewcommitpays;

    // TODO: 17.01.2024 nested
    String getHiltCommintgPays;

    public MyRecycleViewAdapterPay(@NotNull JsonNode jsonNode1сСогласования,
                                   @NonNull Context context,
                                   @NonNull Service_Notificatios_Для_Согласования.LocalBinderДляСогласования binderСогласования1C,
                                   @NotNull Animation animation1,
                                   @NonNull Integer ПубличныйidPay,
                                   @NonNull ObjectMapper objectMapper,
                                   @NonNull BottomNavigationView bottomNavigationViewParent,
                                   @NonNull RecyclerView recycleviewcommitpays,
                                   @NonNull String getHiltCommintgPays) {
        try {
            this.jsonNode1сСогласования = jsonNode1сСогласования;
            this.context = context;
            this.binderСогласования1C = binderСогласования1C;
            this.animation1 = animation1;
            this.ПубличныйidPay = ПубличныйidPay;
            this.objectMapper = objectMapper;
            this.bottomNavigationViewParent = bottomNavigationViewParent;
            this.recycleviewcommitpays = recycleviewcommitpays;
            this.getHiltCommintgPays = getHiltCommintgPays;



            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber());
            // TODO: 30.03.2022
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }

    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolderPay holder, @NonNull int position, @NonNull List<Object> payloads) {
        Log.i(this.getClass().getName(), "   onBindViewHolder  position" + position);
        try {
            // TODO: 19.01.2024  данные
            jsonNode1сСогласованияSingleRow = holder.jsonNode1сСогласования .get(position); // Here's

            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" + "JsonRowДанныеСогласование1С "
                    + jsonNode1сСогласованияSingleRow + " position " + position);


            super.onBindViewHolder(holder, position, payloads);


                Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                        " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                        " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" + "jsonNode1сСогласования "
                        + jsonNode1сСогласования + " position " + position);



            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" + "jsonNode1сСогласования "
                    + jsonNode1сСогласования + " position " + position);
            // TODO: 30.03.2022
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }

    }




    // TODO: 18.01.2024  заполенеия Bungle
    private void setBungleCardView(@NonNull MyViewHolderPay holder, @NonNull JsonNode jsonNode1сСогласованияSingleRow) {
        try{
            Bundle bundleCacdView=new Bundle();

            bundleCacdView.putString("Ndoc",jsonNode1сСогласованияSingleRow.get("Ndoc").asText());
            bundleCacdView.putString("Ddoc",jsonNode1сСогласованияSingleRow.get("Ddoc").asText());
            bundleCacdView.putString("CFO",jsonNode1сСогласованияSingleRow.get("CFO").asText());
            bundleCacdView.putString("NomerScheta",String.valueOf(jsonNode1сСогласованияSingleRow.get("NomerScheta").asInt()));
            bundleCacdView.putString("Otvetstvenniy",jsonNode1сСогласованияSingleRow.get("Otvetstvenniy").asText());
            bundleCacdView.putString("articleDDS",jsonNode1сСогласованияSingleRow.get("articleDDS").asText());

        holder.cardview_commingpay.setTag(bundleCacdView);


        Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" + "jsonNode1сСогласования "
                + jsonNode1сСогласования );
        // TODO: 30.03.2022
    } catch (Exception e) {
        e.printStackTrace();
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
        new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
    }
    }


    private void setеVisibleTablerow_nesters(MyViewHolderPay holder,@NonNull Handler handler) {
        try{

            handler.postDelayed(()->{
                try{
                TableRow tablerow_nesters_commininggpay = holder.tablerow_nesters_commininggpay;

                if (tablerow_nesters_commininggpay.getVisibility()==View.GONE) {
                    tablerow_nesters_commininggpay.setVisibility(View.VISIBLE);

                    Drawable drawableup=context.getDrawable(R.drawable.icon_for_commingpricesup);
                    holder. arrowpay_nested_receriview_commitingpay.setIcon(drawableup);


                    ViewGroup.LayoutParams params = tablerow_nesters_commininggpay.getLayoutParams();
                    params.height = 400;
                    tablerow_nesters_commininggpay.setLayoutParams(params);



                }else {


                    Drawable drawabledown=context.getDrawable(R.drawable.icon_for_commingpricesdown2);
                    holder. arrowpay_nested_receriview_commitingpay.setIcon(drawabledown);



                    tablerow_nesters_commininggpay.setVisibility(View.GONE);
                    ViewGroup.LayoutParams params = tablerow_nesters_commininggpay.getLayoutParams();
                    params.height = 0;
                    tablerow_nesters_commininggpay.setLayoutParams(params);


                }

                    Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                            " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                            " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" + "tablerow_nesters_commininggpay.getVisibility() "
                            + tablerow_nesters_commininggpay.getVisibility() );

                    tablerow_nesters_commininggpay.requestLayout();
                    tablerow_nesters_commininggpay.refreshDrawableState();
            } catch (Exception e) {
                e.printStackTrace();
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                        " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                        Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            }

            },100);


            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n");

        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }




    private void setеHideTablerow_nesters(MyViewHolderPay holder ) {
        try{
                    TableRow tablerow_nesters_commininggpay = holder.tablerow_nesters_commininggpay;
                        tablerow_nesters_commininggpay.setVisibility(View.GONE);
                        tablerow_nesters_commininggpay.setEnabled(false);
                        ViewGroup.LayoutParams params = tablerow_nesters_commininggpay.getLayoutParams();
                        params.height = 0;
                        tablerow_nesters_commininggpay.setLayoutParams(params);

                        tablerow_nesters_commininggpay.requestLayout();
                        tablerow_nesters_commininggpay.refreshDrawableState();
            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n");

        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
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
                    + " время: " + new Date() + "\n+" +
                    " Класс в процессе... " + this.getClass().getName() + "\n" +
                    " метод в процессе... " + Thread.currentThread().getStackTrace()[2].getMethodName() + " position" + position);
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


                             /*   viewГлавныйВидДляRecyclleViewДляСогласования = LayoutInflater.from(parent.context)
                                        .inflate(R.layout.simple_for_commitpay_cardview1, parent, false);//todo old simple_for_takst_cardview1*/
                             /*   viewГлавныйВидДляRecyclleViewДляСогласования = LayoutInflater.from(parent.context)
                                        .inflate(R.layout.simple_for_commitpay_cardview_file, parent, false);//todo old simple_for_takst_cardview1*/
                              /*  viewГлавныйВидДляRecyclleViewДляСогласования = LayoutInflater.from(parent.context)
                                        .inflate(R.layout.simple_for_commitpay_cardview_grid_file, parent, false);//todo old simple_for_takst_cardview1*/
                       /*         viewГлавныйВидДляRecyclleViewДляСогласования = LayoutInflater.from(parent.context)
                                        .inflate(R.layout.simple_for_commitpay_cardview_grid_file, parent, false);//todo old simple_for_takst_cardview1*/

                    viewГлавныйВидДляRecyclleViewДляСогласования = LayoutInflater.from(parent.getContext())
                            .inflate(R.layout.simple_for_commitpay_cardview_withnested3, parent, false);//todo old simple_for_takst_cardview1


            // TODO: 22.03.2022
            myViewHolderPay = new MyViewHolderPay(viewГлавныйВидДляRecyclleViewДляСогласования, context, jsonNode1сСогласования);

            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" );

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



                // TODO: 12.01.2024 Заполняем Данными Компоненты

                МетодБиндингаСозданиеНомерДокумента(holder, jsonNode1сСогласованияSingleRow);

                МетодБиндингаСозданиеСФО(holder, jsonNode1сСогласованияSingleRow);

                МетодБиндингаСозданиеКонтрагент(holder, jsonNode1сСогласованияSingleRow);

                МетодБиндингаСозданиеОрганизация(holder, jsonNode1сСогласованияSingleRow);

                МетодБиндингаСозданиеНомелклатура(holder, jsonNode1сСогласованияSingleRow);


                МетодБиндингаСозданиеСумма(holder, jsonNode1сСогласованияSingleRow);

                МетодБиндингаСозданиеДДС(holder, jsonNode1сСогласованияSingleRow);


                // TODO: 12.01.2024 кнопки
                МетодКпопкаОтказаСогласования(holder);

                МетодКпопкаСогласованияУспешное(holder, ПубличныйidPay,getHiltCommintgPays);

                // TODO: 12.01.2024 обработка видимости Prograssbar
                МетодForPrograBarInner(holder);


                // TODO: 03.11.2023 дополнитешльный механизм добаляем файлы с 1С
                AddFileOt1c(holder, jsonNode1сСогласованияSingleRow, objectMapper);


                // TODO: 17.01.2024  КЛИК ПО ОТКРЫТИЕ NESTED REcyrecireView
                ClickvisibleOrHideNestedRecyreView(holder, jsonNode1сСогласованияSingleRow);


                // TODO: 17.01.2024 методы для заполения NESTD RECYREVIEW


                metodNestdobiyectRaskhoda(holder, jsonNode1сСогласованияSingleRow);
                metodnestedAvans(holder, jsonNode1сСогласованияSingleRow);
                metodNestdPoDogovoruSMP(holder, jsonNode1сСогласованияSingleRow);
                metodNestdPredelnayaData(holder, jsonNode1сСогласованияSingleRow);
                metodNestdNomerScheta(holder, jsonNode1сСогласованияSingleRow);
                metodNestdDataScheta(holder, jsonNode1сСогласованияSingleRow);
                metodNestdOtvetstvenniy(holder, jsonNode1сСогласованияSingleRow);
                metodNestdCommentariy(holder, jsonNode1сСогласованияSingleRow);


                // TODO: 17.01.2024


                setBungleCardView(holder, jsonNode1сСогласованияSingleRow);


                // TODO: 17.01.2024 метод идет последним
                setеHideTablerow_nesters(holder);


                myViewHolderPay.setIsRecyclable(false);


        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }


    // TODO: 03.11.2023  метод загрузки файлов с 1с
    void AddFileOt1c(@NonNull MyViewHolderPay holder, @NotNull JsonNode jsonNode1сСогласованияSingleRow, @NonNull ObjectMapper objectMapper) {
        try {
            // TODO: 03.11.2023 advanset code Downloaf Image rom Commit Pay


                // TODO: 03.11.2023  запускаем получние отображения File from 1c
                FileFrom1CCommitPay fileFrom1CCommitPay1 = new FileFrom1CCommitPay(holder, context, binderСогласования1C);
                // TODO: 08.11.2023 строчка добавление файлов FILE  от 1С
                fileFrom1CCommitPay1.startFileFrom1CCommitPay(jsonNode1сСогласованияSingleRow, holder,   ПубличныйidPay,  getHiltCommintgPays);



            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" + "   holder.tableLayoutcommitpayfiles "
                    + holder.tableLayoutpayfilescommitingpays
                    + " jsonNode1сСогласованияSingleRow " + jsonNode1сСогласованияSingleRow);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }

    }


    ///todo первый метод #1

    private void МетодБиндингаСозданиеНомерДокумента(@NonNull MyViewHolderPay holder, @NonNull JsonNode jsonNode1сСогласованияSingleRow) {
        try {
            if (jsonNode1сСогласованияSingleRow != null && holder.tx_nomer != null) {///"Ndoc"

                String ПерваяСтрочкаЗначения = jsonNode1сСогласованияSingleRow.get("Ndoc").asText().trim();

                holder.tx_nomer.setText(ПерваяСтрочкаЗначения);
                holder.butt_successcommit.setTag(ПерваяСтрочкаЗначения);

                holder.butt_cancel.setTag(ПерваяСтрочкаЗначения);
                holder.tx_nomer.setTag(ПерваяСтрочкаЗначения);

                holder.tx_nomer.requestLayout();
                holder.tx_nomer.refreshDrawableState();

                Log.i(this.getClass().getName(), "  Ndoc   holder.butt_successcommit " + holder.butt_successcommit.getTag() +
                        "     holder.butt_cancel " + holder.butt_cancel.getTag());

            }
            Log.d(context.getClass().getName(), "\n"
                    + " время: " + new Date() + "\n+" +
                    " Класс в процессе... " + this.getClass().getName() + "\n" +
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

    private void МетодБиндингаСозданиеДДС(@NonNull MyViewHolderPay holder, @NonNull JsonNode jsonNode1сСогласованияSingleRow) {

        try {
            // TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1

            if (jsonNode1сСогласованияSingleRow != null && holder.tx_statiy != null) {

                String ПерваяСтрочкаЗначения = jsonNode1сСогласованияSingleRow.get("articleDDS").asText();
                // TODO: 02.03.2022
                Log.i(this.getClass().getName(), "  articleDDS ПерваяСтрочкаЗначения " + ПерваяСтрочкаЗначения);
                // TODO: 28.02.2022
                holder.tx_statiy.setText(ПерваяСтрочкаЗначения);
                holder.tx_statiy.setTag(ПерваяСтрочкаЗначения);

                holder.tx_statiy.requestLayout();
                holder.tx_statiy.refreshDrawableState();

            }
            Log.d(context.getClass().getName(), "\n"
                    + " время: " + new Date() + "\n+" +
                    " Класс в процессе... " + this.getClass().getName() + "\n" +
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

    private void МетодБиндингаСозданиеКонтрагент(@NonNull MyViewHolderPay holder, @NonNull JsonNode jsonNode1сСогласованияSingleRow) {

        try {
            // TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1

            if (jsonNode1сСогласованияSingleRow != null && holder.tx_kontragent != null) {
                //TODO
                String ПерваяСтрочкаЗначения = jsonNode1сСогласованияSingleRow.get("counterparty").asText();
                // TODO: 02.03.2022

                // TODO: 02.03.2022
                Log.i(this.getClass().getName(), " organization ПерваяСтрочкаЗначения " + ПерваяСтрочкаЗначения);
                // TODO: 28.02.2022
                holder.tx_kontragent.setText(ПерваяСтрочкаЗначения);
                holder.tx_kontragent.setTag(ПерваяСтрочкаЗначения);

                holder.tx_kontragent.requestLayout();
                holder.tx_kontragent.refreshDrawableState();

            }
            Log.d(context.getClass().getName(), "\n"
                    + " время: " + new Date() + "\n+" +
                    " Класс в процессе... " + this.getClass().getName() + "\n" +
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

    private void МетодБиндингаСозданиеСФО(@NonNull MyViewHolderPay holder, @NonNull JsonNode jsonNode1сСогласованияSingleRow) {

        try {
            // TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1
            if (holder.tx_zfo != null && jsonNode1сСогласованияSingleRow != null) {
                //todo
                String ПерваяСтрочкаЗначения = jsonNode1сСогласованияSingleRow.get("CFO").asText();
                // TODO: 02.03.2022

                Log.i(this.getClass().getName(), " CFO ПерваяСтрочкаЗначения " + ПерваяСтрочкаЗначения);
                // TODO: 28.02.2022
                //TODo
                holder.tx_zfo.setText(ПерваяСтрочкаЗначения);

                holder.tx_zfo.requestLayout();
                holder.tx_zfo.refreshDrawableState();

            }
            Log.d(context.getClass().getName(), "\n"
                    + " время: " + new Date() + "\n+" +
                    " Класс в процессе... " + this.getClass().getName() + "\n" +
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

    private void МетодБиндингаСозданиеНомелклатура(@NonNull MyViewHolderPay holder, @NonNull JsonNode jsonNode1сСогласованияSingleRow) {
        try {
            // TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1
            if (jsonNode1сСогласованияSingleRow != null) {
                StringBuffer stringBufferArrayNamelk = new StringBuffer();
                final Integer[] ИНдексТекущий = {1};
                // String ПерваяСтрочкаЗначения = jsonNode1сСогласованияSingleRow.get("nomenclature").asText()

                jsonNode1сСогласованияSingleRow.get("nomenclature")
                        .elements()
                        .forEachRemaining(new Consumer<JsonNode>() {
                            @Override
                            public void accept(JsonNode jsonNode) {
                                JsonNode jsonNodesArrayНамелклатура = jsonNode.deepCopy();


                                jsonNodesArrayНамелклатура.elements().forEachRemaining(new Consumer<JsonNode>() {
                                    @Override
                                    public void accept(JsonNode jsonNode) {
                                        TextNode textNode = jsonNode.deepCopy();
                                        if (!textNode.isNull()) {
                                            stringBufferArrayNamelk.append(textNode.asText());
                                            if (ИНдексТекущий[0] < jsonNode1сСогласованияSingleRow.get("nomenclature").size()) {
                                                // TODO: 24.11.2023
                                                ИНдексТекущий[0]++;
                                                stringBufferArrayNamelk.append("\n");
                                            }

                                            Log.d(context.getClass().getName(), "\n"
                                                    + " время: " + new Date() + "\n+" +
                                                    " Класс в процессе... " + this.getClass().getName() + "\n" +
                                                    " метод в процессе... " + Thread.currentThread().getStackTrace()[2].getMethodName());
                                        }
                                    }
                                });


                            }
                        });

                // TODO: 24.11.2023 слашателя
                holder.tx_namelklatura.setText(stringBufferArrayNamelk);
                holder.tx_namelklatura.setTag(stringBufferArrayNamelk);

                holder.tx_namelklatura.requestLayout();
                holder.tx_namelklatura.refreshDrawableState();

                Log.d(context.getClass().getName(), "\n"
                        + " время: " + new Date() + "\n+" +
                        " Класс в процессе... " + this.getClass().getName() + "\n" +
                        " метод в процессе... " + Thread.currentThread().getStackTrace()[2].getMethodName() +
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


    // TODO: 14.03.2022  Успешное Согласования

    private void МетодКпопкаСогласованияУспешное(@NonNull MyViewHolderPay holder, @NonNull Integer ПубличныйidPay,@NonNull  String getHiltCommintgPays)
            throws ExecutionException, InterruptedException {
        try {
            Log.d(this.getClass().getName(), "   КнопкаУспешноеСогласования    Успехх Согласования 2 ");

            final Handler[] handler = {null};

            // TODO: 10.11.2023 клик по файлов
            RxView.clicks(holder.butt_successcommit)
                    .throttleFirst(2, TimeUnit.SECONDS)
                    .filter(s -> !s.toString().isEmpty())
                    .map(new Function<Unit, Object>() {
                        @Override
                        public Object apply(Unit unit) throws Throwable {
                            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n");
                            handler[0] = holder.butt_successcommit.getHandler();
                            return holder.butt_successcommit;
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
                    .subscribe(Getbutt_successcommit -> {

                        // TODO: 18.01.2024  метод успешного соглавования
                                    proccerClickSucceesPay(holder, handler, holder.cardview_commingpay, ПубличныйidPay,getHiltCommintgPays);

                                    Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                            " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                            " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n");

                        Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n");


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
                                        MaterialCardView cardview_commingpay,
                                        @NonNull Integer ПубличныйidPay,
                                        @NonNull  String getHiltCommintgPays) {
        try {
            handler[0].postDelayed(new Runnable() {
                @Override
                public void run() {
                    try {
                     Bundle bundlegetCardViewPay=(Bundle)   cardview_commingpay.getTag();


                      String  NumberDoc =bundlegetCardViewPay.getString("Ndoc");
                      String  DataDoc =bundlegetCardViewPay.getString("Ddoc");

                        Intent intentзаданиеНаВыполениеSuccess = new Intent();
                        intentзаданиеНаВыполениеSuccess.setAction("ЗапускаемСогласованиеОтказИлилУспешное");
                        Bundle bundleДляПередачиВСлужбуСогласования = new Bundle();
                        bundleДляПередачиВСлужбуСогласования.putInt("PROCESS_IDСогласования", Integer.parseInt("28"));
                        bundleДляПередачиВСлужбуСогласования.putString("NumberDoc", NumberDoc);
                        bundleДляПередачиВСлужбуСогласования.putString("DataDoc", DataDoc);
                        bundleДляПередачиВСлужбуСогласования.putInt("ПередаемСтатусСогласования", 2);///TODO выполнил Согласования
                        bundleДляПередачиВСлужбуСогласования.putInt("ПубличныйidPay", ПубличныйidPay);///TODO выполнил Согласования
                        intentзаданиеНаВыполениеSuccess.putExtras(bundleДляПередачиВСлужбуСогласования);



                        ///TODO выполнил Согласования
                        ProccesingCancelOrOKPay proccesingCancelOrOKPay = new ProccesingCancelOrOKPay(context,binderСогласования1C);

                   StringBuffer ОТветОт1СОперациисДанными=
                           proccesingCancelOrOKPay.proccerCancelOrOKPay(context,  intentзаданиеНаВыполениеSuccess,getHiltCommintgPays);


                        if (ОТветОт1СОперациисДанными.toString().matches("(.*)Операция успешна(.*)")) {
                            // TODO: 08.11.2023 после успешно операции перепоудчаем даные  1с Сограсование
                           notifyItemRemoved(myViewHolderPay.getLayoutPosition());
                            notifyItemMoved(myViewHolderPay.getLayoutPosition(),jsonNode1сСогласованияSingleRow.size());
                           notifyDataSetChanged();


                        }else{
                            Toast.makeText(context, "Операция  не прошла !!! "    , Toast.LENGTH_SHORT).show();
                            Vibrator v2 = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
                            v2.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE));
                        }







                        Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"
                                + " intentзаданиеНаВыполениеSuccess " +intentзаданиеНаВыполениеSuccess);


                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                        new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                    }
                }
            }, 100);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }


    // TODO: 12.01.2024 Кнопка РАскрытие Скрытого recyreview


    private void МетодForPrograBarInner(@NonNull MyViewHolderPay holder) {
        try {
            holder.progressbar_commingpay.setVisibility(View.INVISIBLE);

            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n");

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
            Log.d(this.getClass().getName(), "  КнопкаСогласованиеОтказ    отказ 1  ");


            final Handler[] handler = {null};

            RxView.clicks(holder.butt_cancel)
                    .throttleFirst(2, TimeUnit.SECONDS)
                    .filter(s -> !s.toString().isEmpty())
                    .map(new Function<Unit, Object>() {
                        @Override
                        public Object apply(Unit unit) throws Throwable {
                            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n");
                            handler[0] = holder.butt_cancel.getHandler();
                            return holder.butt_cancel;
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
                    .subscribe(Getbutt_cancel -> {
                        Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n");


                        procceringCancelButtonClick(holder, handler[0], holder.cardview_commingpay);


                        Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n");

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
    private void procceringCancelButtonClick(@NonNull MyViewHolderPay holder,
                                             Handler handler, MaterialCardView cardview_commingpay) {
        try {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    try {
                        Bundle bundlegetCardViewPay=(Bundle)   cardview_commingpay.getTag();

                        String  NumberDoc =bundlegetCardViewPay.getString("Ndoc");
                        String  DataDoc =bundlegetCardViewPay.getString("Ddoc");

                        Intent intentзаданиеНаВыполениеCancel = new Intent();
                        intentзаданиеНаВыполениеCancel.setAction("ЗапускаемСогласованиеОтказИлилУспешное");
                        Bundle bundleДляПередачиВСлужбуCancel = new Bundle();
                        bundleДляПередачиВСлужбуCancel.putInt("PROCESS_IDСогласования", Integer.parseInt("28"));
                        bundleДляПередачиВСлужбуCancel.putString("NumberDoc", NumberDoc);
                        bundleДляПередачиВСлужбуCancel.putString("DataDoc", DataDoc);
                        bundleДляПередачиВСлужбуCancel.putInt("ПередаемСтатусСогласования", 1);///TODO выполнил ОТКАЗ
                        bundleДляПередачиВСлужбуCancel.putInt("ПубличныйidPay", ПубличныйidPay);

                        intentзаданиеНаВыполениеCancel.putExtras(bundleДляПередачиВСлужбуCancel);

                        intentзаданиеНаВыполениеCancel.putExtras(bundleДляПередачиВСлужбуCancel);
                        ///TODO выполнил ОТКАЗ
                        ProccesingCancelOrOKPay proccesingCancelOrOKPay = new ProccesingCancelOrOKPay(context,binderСогласования1C);

                        StringBuffer ОТветОт1СОперациисДанными=         proccesingCancelOrOKPay.proccerCancelOrOKPay(context, intentзаданиеНаВыполениеCancel,getHiltCommintgPays );


                        if (ОТветОт1СОперациисДанными.toString().matches("(.*)Операция успешна(.*)")) {
                            // TODO: 08.11.2023 после успешно операции перепоудчаем даные  1с Сограсование
                            notifyItemRemoved(myViewHolderPay.getLayoutPosition());
                            notifyItemMoved(myViewHolderPay.getLayoutPosition(),jsonNode1сСогласованияSingleRow.size());
                            notifyDataSetChanged();


                        }else{
                            Toast.makeText(context, "Операция  не прошла !!! "    , Toast.LENGTH_SHORT).show();
                            Vibrator v2 = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
                            v2.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE));
                        }


                        Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n");
                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                        new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
                    }
                }
            }, 100);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }


    ///todo первый метод #3

    private void МетодБиндингаСозданиеОрганизация(@NonNull MyViewHolderPay holder, @NonNull JsonNode jsonNode1сСогласованияSingleRow) {

        try {
            // TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1

            if (jsonNode1сСогласованияSingleRow != null && holder.tx_organizations != null) {
                //TODO
                String ПерваяСтрочкаЗначения = jsonNode1сСогласованияSingleRow.get("organization").asText();
                // TODO: 02.03.2022

                // TODO: 02.03.2022
                Log.i(this.getClass().getName(), " organization ПерваяСтрочкаЗначения " + ПерваяСтрочкаЗначения);
                // TODO: 28.02.2022
                holder.tx_organizations.setText(ПерваяСтрочкаЗначения);
                holder.tx_organizations.setTag(ПерваяСтрочкаЗначения);

                holder.tx_organizations.requestLayout();
                holder.tx_organizations.refreshDrawableState();
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


    private void МетодБиндингаСозданиеСумма(@NonNull MyViewHolderPay holder, @NonNull JsonNode jsonNode1сСогласованияSingleRow) {

        try {
            // TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1

            if (jsonNode1сСогласованияSingleRow != null && holder.tx_sum != null) {
                //TODO
                String ПерваяСтрочкаЗначения = jsonNode1сСогласованияSingleRow.get("sum").asText();
                // TODO: 02.03.2022

                // TODO: 02.03.2022
                Log.i(this.getClass().getName(), "  sum ПерваяСтрочкаЗначения " + ПерваяСтрочкаЗначения);
                // TODO: 28.02.2022
                holder.tx_sum.setText(ПерваяСтрочкаЗначения.toString() + " руб");
                holder.tx_sum.setTag(ПерваяСтрочкаЗначения);

                holder.tx_sum.requestLayout();
                holder.tx_sum.refreshDrawableState();

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




    public void ClickvisibleOrHideNestedRecyreView(@NonNull MyViewHolderPay holder,@NonNull JsonNode jsonNode1сСогласованияSingleRow ) {
        try {
            Log.d(this.getClass().getName(), "   КнопкаУспешноеСогласования    Успехх Согласования 2 " );

            final Handler[] handler = {null};

            // TODO: 10.11.2023 клик по файлов
            RxView.clicks(   holder. arrowpay_nested_receriview_commitingpay)
                    .throttleFirst(500, TimeUnit.MILLISECONDS)
                    .filter(s -> !s.toString().isEmpty())
                    .filter(jsonnester->jsonNode1сСогласованияSingleRow.has("obiyectRaskhoda")==true)
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
// TODO: 18.01.2024 код показываем или скрываем Nested RecyreView 

                       setеVisibleTablerow_nesters(holder, handler[0]);
                        
                        Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" + " Getarrow_nested_receriview_commitingpay "
                                +Getarrow_nested_receriview_commitingpay);


                    });



        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }



    }









// TODO: 17.01.2024 методы Hide Nested RecyreView Or Visible
    ///todo первый метод #1
    private void metodNestdobiyectRaskhoda(@NonNull MyViewHolderPay holder, @NonNull JsonNode jsonNode1сСогласованияSingleRow) {
        try {
            if (jsonNode1сСогласованияSingleRow!=null && holder.obiyectRaskhoda!=null ) {///"Ndoc"

                String    obiyectRaskhoda=    jsonNode1сСогласованияSingleRow.get("obiyectRaskhoda").asText().trim();

                if (!obiyectRaskhoda.isEmpty()) {
                    holder.obiyectRaskhoda.setText(obiyectRaskhoda);
                    holder.obiyectRaskhoda.setTag(obiyectRaskhoda);


                    holder.obiyectRaskhoda.requestLayout();
                    holder.obiyectRaskhoda.refreshDrawableState();
                }

                Log.i(this.getClass().getName(), "  mTV_1value" +  holder.obiyectRaskhoda.getTag()+
                        "     holder.butt_cancel " +    holder.obiyectRaskhoda.getTag() );

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


    ///todo первый метод #3






    ///todo первый метод #4

    private void metodnestedAvans(@NonNull MyViewHolderPay holder, @NonNull JsonNode jsonNode1сСогласованияSingleRow ) {

        try {
            // TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1
            if (holder.Avans !=null && jsonNode1сСогласованияSingleRow!=null ) {
                //todo
                String Avans = jsonNode1сСогласованияSingleRow.get("Avans").asText();
                // TODO: 02.03.2022

                Log.i(this.getClass().getName(), "   Avans " + Avans);
                if (!Avans.isEmpty()) {
                    // TODO: 28.02.2022
                    //TODo
                    holder.Avans.setText(Avans);
                    holder.Avans.setTag(Avans);

                    holder.Avans.requestLayout();
                    holder.Avans.refreshDrawableState();
                }

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


    private void metodNestdPoDogovoruSMP(@NonNull MyViewHolderPay holder, @NonNull JsonNode jsonNode1сСогласованияSingleRow ) {

        try {
            // TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1

            if (jsonNode1сСогласованияSingleRow !=null &&  holder.PoDogovoruSMP !=null ) {
                //TODO
                String PoDogovoruSMP = jsonNode1сСогласованияSingleRow.get("PoDogovoruSMP").asText();
                // TODO: 02.03.2022
                if (!PoDogovoruSMP.isEmpty()) {
                    holder.PoDogovoruSMP.setText(PoDogovoruSMP);
                    holder.PoDogovoruSMP.setTag(PoDogovoruSMP);

                    holder.PoDogovoruSMP.requestLayout();
                    holder.PoDogovoruSMP.refreshDrawableState();
                }

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




    ///todo первый метод #3
    private void metodNestdPredelnayaData(@NonNull MyViewHolderPay holder, @NonNull JsonNode jsonNode1сСогласованияSingleRow) {

        try {
            // TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1

            if (jsonNode1сСогласованияSingleRow!=null &&   holder.PredelnayaData !=null ) {
                //TODO
                String PredelnayaData = jsonNode1сСогласованияSingleRow.get("PredelnayaData").asText();
                // TODO: 02.03.2022
                if (!PredelnayaData.isEmpty()) {
                    holder.PredelnayaData.setText(PredelnayaData);
                    holder.PredelnayaData.setTag(PredelnayaData);

                    holder.PredelnayaData.requestLayout();
                    holder.PredelnayaData.refreshDrawableState();
                }

                // TODO: 02.03.2022
                Log.i(this.getClass().getName(), " organization PredelnayaData " + PredelnayaData);
            }

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

    ///todo первый метод #5

    ///todo первый метод #7

    private void metodNestdNomerScheta(@NonNull MyViewHolderPay holder, @NonNull JsonNode jsonNode1сСогласованияSingleRow) {
        try {
            // TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1
            if (jsonNode1сСогласованияSingleRow!=null &&   holder.NomerScheta !=null ) {
                //TODO
                Integer NomerScheta = jsonNode1сСогласованияSingleRow.get("NomerScheta").asInt();
                // TODO: 02.03.2022
                if (NomerScheta>0) {
                    holder.NomerScheta.setText(NomerScheta.toString());
                    holder.NomerScheta.setTag(NomerScheta.toString());

                    holder.NomerScheta.requestLayout();
                    holder.NomerScheta.refreshDrawableState();
                }

                // TODO: 02.03.2022
                Log.i(this.getClass().getName(), " organization NomerScheta " + NomerScheta);
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







    private void metodNestdDataScheta( @NonNull MyViewHolderPay holder,@NonNull JsonNode jsonNode1сСогласованияSingleRow) {

        try {
            // TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1
            if (jsonNode1сСогласованияSingleRow!=null &&  holder.DataScheta !=null ) {
                //TODO
                String DataScheta = jsonNode1сСогласованияSingleRow.get("DataScheta").asText();
                // TODO: 02.03.2022
                // TODO: 28.02.2022
                if (!DataScheta.isEmpty()) {
                    holder.DataScheta.setText(DataScheta );
                    holder.DataScheta.setTag(DataScheta);

                    holder.DataScheta.requestLayout();
                    holder.DataScheta.refreshDrawableState();
                }

                // TODO: 02.03.2022
                Log.i(this.getClass().getName(), "  sum DataScheta " + DataScheta);

            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            //   mNotificationManagerДляЧАТА.cancel(1);///.cancelAll();
        }

    }


    private void metodNestdOtvetstvenniy(@NonNull MyViewHolderPay holder,@NonNull JsonNode jsonNode1сСогласованияSingleRow ) {

        try {
            // TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1// TODO: 02.03.2022#1

            if (jsonNode1сСогласованияSingleRow!=null &&   holder.Otvetstvenniy !=null ) {

                String Otvetstvenniy = jsonNode1сСогласованияSingleRow.get("Otvetstvenniy").asText();
                // TODO: 02.03.2022

                if (!Otvetstvenniy.isEmpty()) {
                    // TODO: 28.02.2022
                    holder.Otvetstvenniy.setText(Otvetstvenniy);
                    holder.Otvetstvenniy.setTag(Otvetstvenniy);

                    holder.Otvetstvenniy.requestLayout();
                    holder.Otvetstvenniy.refreshDrawableState();
                }
                Log.i(this.getClass().getName(), "  articleDDS Otvetstvenniy " + Otvetstvenniy);
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



    private void metodNestdCommentariy(@NonNull MyViewHolderPay holder, @NonNull JsonNode jsonNode1сСогласованияSingleRow ) {
        try {
            if (jsonNode1сСогласованияSingleRow!=null &&   holder.Commentariy !=null ) {

                String Commentariy = jsonNode1сСогласованияSingleRow.get("Commentariy").asText();
                // TODO: 02.03.2022

                // TODO: 28.02.2022
                if (!Commentariy.isEmpty()) {
                    holder.Commentariy.setText(Commentariy);
                    holder.Commentariy.setTag(Commentariy);

                    holder.Commentariy.requestLayout();
                    holder.Commentariy.refreshDrawableState();
                }
                Log.i(this.getClass().getName(), "  articleDDS Commentariy " + Commentariy);
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
        int КоличесвоСтрок = jsonNode1сСогласования.size();
        Log.d(context.getClass().getName(), "\n"
                + " время: " + new Date()+"\n+" +
                " Класс в процессе... " +  this.getClass().getName()+"\n"+
                " метод в процессе... " + Thread.currentThread().getStackTrace()[2].getMethodName()
                +"jsonNode1сСогласования.size() " + jsonNode1сСогласования.size() + " КоличесвоСтрок " + КоличесвоСтрок);
        // TODO: 28.02.2022
        return КоличесвоСтрок;
    }


}//TODO  END MyRecycleAdapter
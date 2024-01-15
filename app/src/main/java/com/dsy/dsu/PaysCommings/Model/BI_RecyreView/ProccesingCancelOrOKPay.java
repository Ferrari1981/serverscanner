package com.dsy.dsu.PaysCommings.Model.BI_RecyreView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;

import com.dsy.dsu.PaysCommings.View.RecyreView.MyViewHolderPay;
import com.dsy.dsu.Errors.Class_Generation_Errors;
import com.dsy.dsu.R;
import com.dsy.dsu.Services.Service_Notificatios_Для_Согласования;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.android.material.card.MaterialCardView;
import com.jakewharton.rxbinding4.view.RxView;

import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.schedulers.Schedulers;
import kotlin.Unit;

// TODO: 08.11.2023  класс не посредственого выоления операции cancel или  OK 
@SuppressLint("SuspiciousIndentation")
public
class ProccesingCancelOrOKPay {
    // TODO: 08.11.2023 метод
    Context context;
    Service_Notificatios_Для_Согласования.LocalBinderДляСогласования binderСогласования1C;

    JsonNode jsonNode1сСогласованияAllRows;
    Animation animation1;
    ObjectMapper objectMapper;
    public ProccesingCancelOrOKPay(@NonNull  Context context,
                                   @NonNull Service_Notificatios_Для_Согласования.LocalBinderДляСогласования binderСогласования1C,
                                   @NonNull JsonNode jsonNode1сСогласованияAllRows,
                                   @NonNull Animation animation1,
                                   @NonNull ObjectMapper objectMapper) {
        this.context = context;
        this.binderСогласования1C = binderСогласования1C;
        this.jsonNode1сСогласованияAllRows = jsonNode1сСогласованияAllRows;
        this.animation1 = animation1;
        this.objectMapper = objectMapper;
        Log.d(context.getClass().getName(), "\n"
                + " время: " + new Date()+"\n+" +
                " Класс в процессе... " +  this.getClass().getName()+"\n"+
                " метод в процессе... " + Thread.currentThread().getStackTrace()[2].getMethodName());
    }


    public void proccerCancelOrOKPay(@NonNull Intent заданиеНаВыполение, @NonNull View v) {
        try{
            final StringBuffer[] ОТветОт1СОперациисДанными = {new StringBuffer()};
            // TODO: 14.11.2023  ОПРАВЛЯЕМ ОТКАЗ иилиОК  в сошгоасованиеию СОГЛАСОВПНИЕ ИЛИ ОТКАЗ
            Maybe. fromAction(new Action() {
                        @Override
                        public void run() throws Throwable {
                            ОТветОт1СОперациисДанными[0] =
                                    binderСогласования1C.getService().
                                            МетодЗапускаСогласованияВнутриСлужбы(заданиеНаВыполение, context);


                            Log.d(this.getClass().getName(), "\n" + " class "
                                    + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"
                                    + " ОТветОт1СОперациисДанными " + ОТветОт1СОперациисДанными[0]);

                            Log.d(this.getClass().getName(), "\n" + " class "
                                    + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n"
                                    +
                                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"
                                    + " ОТветОт1СОперациисДанными " + ОТветОт1СОперациисДанными[0]);


                        }
                    }).subscribeOn(Schedulers.single())
                    .observeOn(AndroidSchedulers.mainThread()).subscribe(new MaybeObserver<Object>() {
                        @Override
                        public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

                            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" + " ОТветОт1СОперациисДанными " + ОТветОт1СОперациисДанными[0]);

                        }

                        @Override
                        public void onSuccess(@io.reactivex.rxjava3.annotations.NonNull Object o) {
                            onComplete();
                            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" + " ОТветОт1СОперациисДанными " + ОТветОт1СОперациисДанными[0]);

                        }

                        @Override
                        public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {

                            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" + " ОТветОт1СОперациисДанными " + ОТветОт1СОперациисДанными[0]);

                        }

                        @Override
                        public void onComplete() {

                            if (ОТветОт1СОперациисДанными[0].length()>0) {
                                // TODO: 08.11.2023 после успешно операции перепоудчаем даные  1с Сограсование
                            //   onStart();

                            }else{
                                Toast.makeText(context, "Операция  не прошла !!! "    , Toast.LENGTH_SHORT).show();
                                Vibrator v2 = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
                                v2.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE));
                            }
                            // TODO: 26.12.2022  конец основгого кода
                            v.animate().rotationX(0);

                            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"
                                    + " ОТветОт1СОперациисДанными[0] " + ОТветОт1СОперациисДанными[0]);
                        }
                    });

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


    // TODO: 10.11.2023 get Binary
    @CheckResult
    byte[] proccerGetBinaty1c(@NonNull Intent заданиеНаВыполение,@NonNull View v) {
        byte[] getFileNewOt1cPayCommit = null;
        try{
            // TODO: 10.11.2023 получаем файл от 1с Соглосования Binaty
            getFileNewOt1cPayCommit =
                    binderСогласования1C.getService().
                            МетодПолучаемNewFile1CСогласованияЧерезСлужбу(заданиеНаВыполение, context,objectMapper);


            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber()
                    + "\n" + "   getFileNewOt1cPayCommit " +   getFileNewOt1cPayCommit);

            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"
                    + " ОgetFileNewOt1cPayCommit[0] " + getFileNewOt1cPayCommit);

        } catch (Exception e) {
            e.printStackTrace();
            Log.e(context.getClass().getName(),
                    "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                            " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName().toString(), Thread.currentThread().getStackTrace()[2].getMethodName().toString(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
        return    getFileNewOt1cPayCommit ;
    }

















    // TODO: 10.11.2023  класс Самой вставки файлов от 1с
    class AddFilesot1CPaycommitting{

        void addfilessot1CPaycommitting(@NotNull TableLayout tableLayoutcommitpayfiles, @NonNull JsonNode jsonNode1сСогласованияRow,
                                        @NonNull MyViewHolderPay holder,@NonNull Integer ПубличныйidPay){
            try{
                if (tableLayoutcommitpayfiles.getChildCount() == 0) {

                    // TODO: 10.11.2023  Заполняем ДАнные Из Массива Файлов
                    ArrayNode datasetArray = (ArrayNode)jsonNode1сСогласованияRow.get("filenames");

                    datasetArray.forEach(new Consumer<JsonNode>() {
                        @Override
                        public void accept(JsonNode jsonNodeМассивФайлы1cBinaty) {


                            // TODO: 10.11.2023 ццикл массив  крутим файцлы вставки
                            ArrayFileNewPay1c(      jsonNodeМассивФайлы1cBinaty,  tableLayoutcommitpayfiles,holder, ПубличныйidPay);

                            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"+
                                    " jsonNode1сСогласованияAllRows " +jsonNode1сСогласованияAllRows);
                        }
                    });

                    Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                            " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                            " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"+
                            " jsonNode1сСогласованияAllRows " +jsonNode1сСогласованияAllRows);

                } else {

                    tableLayoutcommitpayfiles.refreshDrawableState();
                    tableLayoutcommitpayfiles.requestLayout();

                }
                Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                        " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                        " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"+
                        " jsonNode1сСогласования " +jsonNode1сСогласованияAllRows);
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


        // TODO: 10.11.2023  класс крутим файлы от 1с
        void  ArrayFileNewPay1c(@NotNull  JsonNode      МассивИменСограсований,
                                @NonNull TableLayout tableLayoutcommitpayfiles,
                                @NonNull MyViewHolderPay holder,
                                @NonNull Integer ПубличныйidPay){
            try{


                String НазваниеТекущегот1С    = МассивИменСограсований.get("ВinNameFile").asText().trim();
                String РасширенияФайла=   МассивИменСограсований.get("expansion").asText().trim();

                // TODO: 10.11.2023  добалвем новую строчку
                AddFileFromPayCommiting addFileFromPayCommiting=new AddFileFromPayCommiting();

                addFileFromPayCommiting.addingNewFilePay(tableLayoutcommitpayfiles,context,НазваниеТекущегот1С,РасширенияФайла,holder,ПубличныйidPay);

                Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                        " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                        " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"+
                        " jsonNode1сСогласованияAllRows " +jsonNode1сСогласованияAllRows+ " НазваниеТекущегот1С " +НазваниеТекущегот1С+" РасширенияФайла " +РасширенияФайла);
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








/////todo END CLASS  class AddFilesot1CPaycommitting
    }/////todo END CLASS  class AddFilesot1CPaycommitting


    // TODO: 08.11.2023 ЗАПОЛЕНИЕ ФАЛОМИ


    class AddFileFromPayCommiting{
        // TODO: 08.11.2023 метод додабвление файлов от 1с
        void   addingNewFilePay(@NotNull  TableLayout tableLayoutcommitpayfiles,
                                @NotNull Context context,
                                @NotNull String НазваниеТекущегот1С,
                                @NotNull String РасширенияФайла,
                                @NonNull MyViewHolderPay holder,
                                @NonNull Integer ПубличныйidPay){
            try{
                // TODO: 03.11.2023 Childern
                MaterialCardView materialCardViewRowpaycommit = (MaterialCardView) LayoutInflater.from(context).inflate(R.layout.simpleforfileaycommit3, null);

                // TODO: 03.11.2023 Childern
                TableLayout tablelayoutRowpaycommit = materialCardViewRowpaycommit.findViewById(R.id.tablelayoutRowpaycommit);


                TableRow tableRowpaycommit = (TableRow) tablelayoutRowpaycommit.findViewById(R.id.tableRowpaycommit);



                // TODO: 03.11.2023 Set Datas NEW
                metodAddTExtView1cPayCommit(НазваниеТекущегот1С, tablelayoutRowpaycommit, tableRowpaycommit,РасширенияФайла);

                Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                        " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                        " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"+
                        " НазваниеТекущегот1С " +НазваниеТекущегот1С+" РасширенияФайла " +РасширенияФайла);

                // TODO: 10.11.2023  меняем Дизан textview FILE
                metodAddTExtViewChengeDisainPayCommit(tableRowpaycommit);


                // TODO: 10.11.2023  Клик по TExtView  FIle
                metodClicksForTextViewPayCommit(tableRowpaycommit,holder,ПубличныйidPay);



                // TODO: 03.11.2023 Delete Datas
                tablelayoutRowpaycommit.recomputeViewAttributes(tableRowpaycommit);
                tablelayoutRowpaycommit.removeViewInLayout(tableRowpaycommit);
                tablelayoutRowpaycommit.removeView(tableRowpaycommit);
                tableRowpaycommit.setId(new Random().nextInt());
                tablelayoutRowpaycommit.recomputeViewAttributes(tableRowpaycommit);

                // TODO: 03.11.2023 Set Animaziy
                tableRowpaycommit.startAnimation(animation1);

                // TODO: 03.11.2023 Final Add Row in Parent Tableyout
                metodParentAddRowFinal(tableRowpaycommit, tableLayoutcommitpayfiles);



                Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                        " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                        " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"+
                        " НазваниеТекущегот1С " +НазваниеТекущегот1С);

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

        private void metodParentAddRowFinal(TableRow rowПервыеДанные,
                                            @NonNull TableLayout tableLayoutРодительская) {
            try {
                tableLayoutРодительская.removeView(rowПервыеДанные);
                tableLayoutРодительская.removeViewInLayout(rowПервыеДанные);
                tableLayoutРодительская.addView(rowПервыеДанные);
                tableLayoutРодительская.requestLayout();
                tableLayoutРодительская.refreshDrawableState();

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
    }//todo end classs class AddFileFromPayCommiting

    private void metodAddTExtView1cPayCommit(@NonNull String НазваниеТекущегот1С,
                                             @NonNull TableLayout tablelayoutRowpaycommit,
                                             @NonNull TableRow tableRowpaycommit,
                                             @NotNull String РасширенияФайла) {
        try{
            TextView textnameRowpaycommit = tableRowpaycommit.findViewById(R.id.textnameRowpaycommit);
            TextView textvalueRowpaycommit = tableRowpaycommit.findViewById(R.id.textvalueRowpaycommit);

            // TODO: 10.11.2023 добалвем назваение файла
            textvalueRowpaycommit.setText(НазваниеТекущегот1С.trim());
            textvalueRowpaycommit.setTooltipText(НазваниеТекущегот1С.trim());
            // TODO: 13.11.2023 название расфирения
            textnameRowpaycommit.setHint("Файл "+"("+РасширенияФайла+")");
            textnameRowpaycommit.setTooltipText(РасширенияФайла.trim());

            // TODO: 03.11.2023 Tag
            Bundle bundleChildreRow = new Bundle();
            bundleChildreRow.putString("ВinNameFile", НазваниеТекущегот1С.trim());
            bundleChildreRow.putString("expansion", РасширенияФайла.trim());

            tablelayoutRowpaycommit.setTag(bundleChildreRow);
            textvalueRowpaycommit.setTag(bundleChildreRow);
            textnameRowpaycommit.setTag(bundleChildreRow);

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
    // TODO: 10.11.2023 меняем дизацйн ноых файлов

    private void metodAddTExtViewChengeDisainPayCommit(@NonNull TableRow tableRowpaycommit) {
        try{
            TextView textnameRowpaycommit = tableRowpaycommit.findViewById(R.id.textnameRowpaycommit);
            TextView textvalueRowpaycommit = tableRowpaycommit.findViewById(R.id.textvalueRowpaycommit);

            //    textvalueRowpaycommit.setTextColor(Color.parseColor("#787070"));

            textvalueRowpaycommit.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    textvalueRowpaycommit.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    int height =  textvalueRowpaycommit.getHeight();
                    int width =  textvalueRowpaycommit.getWidth();
                    textnameRowpaycommit.setHeight( height);
                    textnameRowpaycommit.requestLayout();
                    textnameRowpaycommit.forceLayout();



                    String s=textvalueRowpaycommit.getText().toString();
                    SpannableString ss=new SpannableString(s);
                    ss.setSpan(new UnderlineSpan(), 0, s.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    textvalueRowpaycommit.setText(ss);

                    textvalueRowpaycommit.startAnimation(animation1);


                }
            });




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


    // TODO: 11.11.2023  програсс бакр при загрузке файла 1с согооасования

    @UiThread
    private void metodPrograssbarDowloadFile1cPayCommit(@NonNull MyViewHolderPay holder,
                                                        @NotNull Boolean Flag ) {
        try{

            if (Flag) {
                holder.progressbar_commingpay.setVisibility(View.VISIBLE);
            } else {
                holder.progressbar_commingpay.setVisibility(View.INVISIBLE);
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

    // TODO: 10.11.2023  метод  клик по файлва Для Отправки

    private void metodClicksForTextViewPayCommit(@NonNull TableRow tableRowpaycommit,
                                                 @NonNull MyViewHolderPay holder,
                                                  @NonNull Integer ПубличныйidPay) {
        try{

            final Handler[] handler = new Handler[1];

            TextView textnameRowpaycommit = tableRowpaycommit.findViewById(R.id.textnameRowpaycommit);
            TextView textvalueRowpaycommit = tableRowpaycommit.findViewById(R.id.textvalueRowpaycommit);
            // TODO: 10.11.2023 клик по файлов
            RxView.clicks(textvalueRowpaycommit)
                    .throttleFirst(2, TimeUnit.SECONDS)
                    .filter(s -> !s.toString().isEmpty())
                    .map(new Function<Unit, Object>() {
                        @Override
                        public Object apply(Unit unit) throws Throwable {
                            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"
                                    +"  s.toString(); " + unit.toString());
                            handler[0] =   textnameRowpaycommit.getHandler();
                            return textvalueRowpaycommit.getText().toString();
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
                    .subscribe( GetNameSingleNewFile1c->{

                        metodPrograssbarDowloadFile1cPayCommit(holder,true );
                        tableRowpaycommit.startAnimation(animation1);

                        handler[0].postDelayed(()->{
                            try{

                                metodCompleteStartDownloadfILE1C(holder, textvalueRowpaycommit, GetNameSingleNewFile1c,ПубличныйidPay);

                                metodPrograssbarDowloadFile1cPayCommit(holder,false );
                                tableRowpaycommit.clearAnimation();
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
                        },250);




                        Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n");

                    });


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


    // TODO: 13.11.2023 метод Загрузки Старта Новго Файла От 1с Complete 
    private void metodCompleteStartDownloadfILE1C(@NonNull MyViewHolderPay holder,
                                                  @NonNull  TextView textvalueRowpaycommit,
                                                  @NonNull Object GetNameSingleNewFile1c,
                                                   @NonNull Integer ПубличныйidPay) {
        try{
            final byte[][] getFileNewOt1cPayCommit = {null};
            Completable.fromSupplier(new Supplier<byte[]>() {
                        @Override
                        public byte[] get() throws Throwable {

                            getFileNewOt1cPayCommit[0] =     metodSubscrionGets1cСограсование(textvalueRowpaycommit, GetNameSingleNewFile1c.toString(),holder,ПубличныйidPay);

                            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"
                                    +"  GetNameSingleNewFile1c " + GetNameSingleNewFile1c +" getFileNewOt1cPayCommit " + getFileNewOt1cPayCommit[0]);

                            return getFileNewOt1cPayCommit[0];
                        }
                    })
                    .blockingSubscribe(new CompletableObserver() {
                        @Override
                        public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

                            Vibrator v2 = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
                            v2.vibrate(VibrationEffect.createOneShot(80, VibrationEffect.EFFECT_HEAVY_CLICK));

                            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"
                                    +"  GetNameSingleNewFile1c " + GetNameSingleNewFile1c +" время " + new Date().toLocaleString());
                        }

                        @Override
                        public void onComplete() {
                            // TODO: 13.11.2023  после получениеоперацйии получение файла показыаем програсс баром



                            // TODO: 13.11.2023 МетодЗапускает Если Файл Есть Пднимаем Его Птом
                            reakziyHaSizeFile1cPayCommi(getFileNewOt1cPayCommit[0]);

                            // TODO: 13.11.2023 ЗАгружаем ФАйл Н адИСк
                        SuccessGet1CpayCommitProccesing successGet1CpayCommitProccesing = new SuccessGet1CpayCommitProccesing(context);

                            String НазваниеТекущегОт1С=       successGet1CpayCommitProccesing.
                                    filesuccessDownDisk1CpayCommitProccesing(getFileNewOt1cPayCommit[0],textvalueRowpaycommit);


                            // TODO: 14.11.2023 Поднимаем Файл с Диска И Показываем Его Пользователю
                            metodUpsAllsFileOt1cUserS(НазваниеТекущегОт1С,(Bundle) textvalueRowpaycommit.getTag());


                            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"
                                    +"  GetNameSingleNewFile1c " + GetNameSingleNewFile1c +" getFileNewOt1cPayCommit " + getFileNewOt1cPayCommit[0]+
                                    " НазваниеТекущегОт1С " +НазваниеТекущегОт1С);
                        }

                        @Override
                        public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"
                                    +"  GetNameSingleNewFile1c " + GetNameSingleNewFile1c +" время " + new Date().toLocaleString());
                        }
                    });

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




    private void metodUpsAllsFileOt1cUserS(@NonNull  String NameNewDownloadFileOt1c,@NonNull   Bundle bundleChildreRow) {
        // TODO: 14.11.2023 ПОказываем файл пользоватолю
        try {
            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"
                    +"  NameNewDownloadFileOt1c " + NameNewDownloadFileOt1c );

            if (NameNewDownloadFileOt1c !=null) {

                String РасширенияФайлаОт1С = bundleChildreRow.getString("expansion", "");
                switch (РасширенияФайлаОт1С.trim()){
                    case "xlsx":
                    case "xltx":
                    case "xlsm":
                        class UpFileXlsx extends SuccessGet1CpayCommitProccesing {
                            public UpFileXlsx(Context context) {
                                super(context);
                            }

                            @Override
                            void UpFileSuccessOt1cPayCommit(@NonNull String НазваниеТекущегОт1С) {
                                //ТекущийФорматДокумента="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
                                ТекущийФорматДокумента="application/vnd.ms-excel";
                                super.UpFileSuccessOt1cPayCommit(НазваниеТекущегОт1С);
                            }
                        }
                        // TODO: 14.11.2023 staring childer class up file
                        new UpFileXlsx(context).UpFileSuccessOt1cPayCommit(NameNewDownloadFileOt1c);
                        break;

                    case "xls":
                    case "xla":
                    case "xlt":
                        class UpFileXlsxSimple extends SuccessGet1CpayCommitProccesing {
                            public UpFileXlsxSimple(Context context) {
                                super(context);
                            }

                            @Override
                            void UpFileSuccessOt1cPayCommit(@NonNull String НазваниеТекущегОт1С) {
                                ТекущийФорматДокумента="application/vnd.ms-excel";
                                super.UpFileSuccessOt1cPayCommit(НазваниеТекущегОт1С);
                            }
                        }
                        // TODO: 14.11.2023 staring childer class up file
                        new UpFileXlsxSimple(context).UpFileSuccessOt1cPayCommit(NameNewDownloadFileOt1c);
                        break;
                    case "mdb":
                    case "accdb":
                        class UpFileAccess extends  SuccessGet1CpayCommitProccesing {
                            public UpFileAccess(Context context) {
                                super(context);
                            }

                            @Override
                            void UpFileSuccessOt1cPayCommit(@NonNull String НазваниеТекущегОт1С) {
                                ТекущийФорматДокумента="application/vnd.ms-access";
                                super.UpFileSuccessOt1cPayCommit(НазваниеТекущегОт1С);
                            }
                        }
                        // TODO: 14.11.2023 staring childer class up file
                        new UpFileAccess(context).UpFileSuccessOt1cPayCommit(NameNewDownloadFileOt1c);
                        break;
                    case "ppt":
                    case "pot":
                    case "pps":
                        class UpFilePowerPoint extends  SuccessGet1CpayCommitProccesing {
                            public UpFilePowerPoint(Context context) {
                                super(context);
                            }

                            @Override
                            void UpFileSuccessOt1cPayCommit(@NonNull String НазваниеТекущегОт1С) {
                                ТекущийФорматДокумента="application/vnd.ms-powerpoint";
                                super.UpFileSuccessOt1cPayCommit(НазваниеТекущегОт1С);
                            }
                        }
                        // TODO: 14.11.2023 staring childer class up file
                        new UpFilePowerPoint(context).UpFileSuccessOt1cPayCommit(NameNewDownloadFileOt1c);
                        break;

                    case "docx":
                    case "dotx":
                    case "docm":
                        class UpFileWord extends  SuccessGet1CpayCommitProccesing {
                            public UpFileWord(Context context) {
                                super(context);
                            }

                            @Override
                            void UpFileSuccessOt1cPayCommit(@NonNull String НазваниеТекущегОт1С) {
                                ТекущийФорматДокумента="application/vnd.openxmlformats-officedocument.wordprocessingml.document";
                                super.UpFileSuccessOt1cPayCommit(НазваниеТекущегОт1С);
                            }
                        }
                        // TODO: 14.11.2023 staring childer class up file
                        new UpFileWord(context).UpFileSuccessOt1cPayCommit(NameNewDownloadFileOt1c);
                        break;
                    case "doc":
                    case "dot":
                        class UpFileWordSimple extends  SuccessGet1CpayCommitProccesing {
                            public UpFileWordSimple(Context context) {
                                super(context);
                            }

                            @Override
                            void UpFileSuccessOt1cPayCommit(@NonNull String НазваниеТекущегОт1С) {
                                ТекущийФорматДокумента="application/msword";
                                super.UpFileSuccessOt1cPayCommit(НазваниеТекущегОт1С);
                            }
                        }
                        // TODO: 14.11.2023 staring childer class up file
                        new UpFileWordSimple(context).UpFileSuccessOt1cPayCommit(NameNewDownloadFileOt1c);
                        break;
                    case "jpg":
                        class UpFileJPG extends  SuccessGet1CpayCommitProccesing {
                            public UpFileJPG(Context context) {
                                super(context);
                            }

                            @Override
                            void UpFileSuccessOt1cPayCommit(@NonNull String НазваниеТекущегОт1С) {
                                ТекущийФорматДокумента="image/jpg";
                                super.UpFileSuccessOt1cPayCommit(НазваниеТекущегОт1С);
                            }
                        }
                        // TODO: 14.11.2023 staring childer class up file
                        new UpFileJPG(context).UpFileSuccessOt1cPayCommit(NameNewDownloadFileOt1c);
                        break;
                    case "jpeg":
                        class UpFileJPEG extends  SuccessGet1CpayCommitProccesing {
                            public UpFileJPEG(Context context) {
                                super(context);
                            }

                            @Override
                            void UpFileSuccessOt1cPayCommit(@NonNull String НазваниеТекущегОт1С) {
                                ТекущийФорматДокумента="image/jpeg";
                                super.UpFileSuccessOt1cPayCommit(НазваниеТекущегОт1С);
                            }
                        }
                        // TODO: 14.11.2023 staring childer class up file
                        new UpFileJPEG(context).UpFileSuccessOt1cPayCommit(NameNewDownloadFileOt1c);
                        break;
                    case "png":
                        class UpFilePNG extends  SuccessGet1CpayCommitProccesing {
                            public UpFilePNG(Context context) {
                                super(context);
                            }

                            @Override
                            void UpFileSuccessOt1cPayCommit(@NonNull String НазваниеТекущегОт1С) {
                                ТекущийФорматДокумента="image/png";
                                super.UpFileSuccessOt1cPayCommit(НазваниеТекущегОт1С);
                            }
                        }
                        // TODO: 14.11.2023 staring childer class up file
                        new UpFilePNG(context).UpFileSuccessOt1cPayCommit(NameNewDownloadFileOt1c);
                        break;
                    case "pdf":
                        class UpFilePDF extends  SuccessGet1CpayCommitProccesing {
                            public UpFilePDF(Context context) {
                                super(context);
                            }

                            @Override
                            void UpFileSuccessOt1cPayCommit(@NonNull String НазваниеТекущегОт1С) {
                                ТекущийФорматДокумента="application/pdf";
                                super.UpFileSuccessOt1cPayCommit(НазваниеТекущегОт1С);
                            }
                        }
                        // TODO: 14.11.2023 staring childer class up file
                        new UpFilePDF(context).UpFileSuccessOt1cPayCommit(NameNewDownloadFileOt1c);
                        break;
                    case "zip":
                        class UpFileZIP extends  SuccessGet1CpayCommitProccesing {
                            public UpFileZIP(Context context) {
                                super(context);
                            }

                            @Override
                            void UpFileSuccessOt1cPayCommit(@NonNull String НазваниеТекущегОт1С) {
                                ТекущийФорматДокумента="application/zip";
                                super.UpFileSuccessOt1cPayCommit(НазваниеТекущегОт1С);
                            }
                        }
                        // TODO: 14.11.2023 staring childer class up file
                        new UpFileZIP(context).UpFileSuccessOt1cPayCommit(NameNewDownloadFileOt1c);
                        break;
                    case "rar":
                        class UpFileRAR extends  SuccessGet1CpayCommitProccesing {
                            public UpFileRAR(Context context) {
                                super(context);
                            }

                            @Override
                            void UpFileSuccessOt1cPayCommit(@NonNull String НазваниеТекущегОт1С) {
                                ТекущийФорматДокумента="application/vnd.rar";
                                super.UpFileSuccessOt1cPayCommit(НазваниеТекущегОт1С);
                            }
                        }
                        // TODO: 14.11.2023 staring childer class up file
                        new UpFileRAR(context).UpFileSuccessOt1cPayCommit(NameNewDownloadFileOt1c);
                        break;
                    case "txt":
                        class UpFileTXT extends  SuccessGet1CpayCommitProccesing {
                            public UpFileTXT(Context context) {
                                super(context);
                            }

                            @Override
                            void UpFileSuccessOt1cPayCommit(@NonNull String НазваниеТекущегОт1С) {
                                ТекущийФорматДокумента="text/*";
                                super.UpFileSuccessOt1cPayCommit(НазваниеТекущегОт1С);
                            }
                        }
                        // TODO: 14.11.2023 staring childer class up file
                        new UpFileTXT(context).UpFileSuccessOt1cPayCommit(NameNewDownloadFileOt1c);
                        break;
                }

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
    }





    // TODO: 10.11.2023 Метод Подписка Subcrion Получение файла от 1с Сограсование
    private byte[] metodSubscrionGets1cСограсование(@NotNull TextView textvalueRowpaycommit,
                                                    @NotNull Object GetNameSingleNewFile1c,
                                                    @NonNull MyViewHolderPay holder
                                                   ,@NonNull Integer ПубличныйidPay) {
        byte[] getFileNewOt1cPayCommit=null;
        try{
            // TODO: 26.12.2022  конец основгого кода
            Intent заданиеGetNewFile1C=new Intent();
            // TODO: 17.11.2021
            заданиеGetNewFile1C.setAction( "ЗапускаемПолучениеBinatyОт1с");
            Bundle bundleДляПередачиВСлужбуСогласования=(Bundle)   textvalueRowpaycommit.getTag();

            bundleДляПередачиВСлужбуСогласования.putInt("PROCESS_IDСогласования", Integer.parseInt("28"));
            bundleДляПередачиВСлужбуСогласования.putString("backfile", GetNameSingleNewFile1c.toString().trim() );
            bundleДляПередачиВСлужбуСогласования.putInt("ПередаемСтатусСогласования", 4);///TODO выполнил Согласования
            bundleДляПередачиВСлужбуСогласования.putInt("ПубличныйidPay", ПубличныйidPay);//ПубличныйidPay

            // TODO: 13.11.2023  номер документа
            String dsu1number=      holder.tx_nomer.getTag().toString().trim();


            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"
                    +"  dsu1number " + dsu1number+" время " + new Date().toLocaleString());



            bundleДляПередачиВСлужбуСогласования.putString("dsu1number",  dsu1number);//ПубличныйidPay

            заданиеGetNewFile1C.putExtras(bundleДляПередачиВСлужбуСогласования);

            textvalueRowpaycommit.setTag(bundleДляПередачиВСлужбуСогласования);

            ///TODO выполнил ОТКАЗ CANCEL
            getFileNewOt1cPayCommit =proccerGetBinaty1c(заданиеGetNewFile1C, textvalueRowpaycommit);

            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"
                    +"  getFileNewOt1cPayCommit " + getFileNewOt1cPayCommit+" время " + new Date().toLocaleString());
            // TODO: 26.12.2022  конец основгого кода
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
        return  getFileNewOt1cPayCommit;
    }



    void reakziyHaSizeFile1cPayCommi(@NotNull byte[] getFileNewOt1cPayCommit){
        try{
            if (getFileNewOt1cPayCommit!=null) {
                if (getFileNewOt1cPayCommit.length>0) {
                    // TODO: 08.11.2023 после успешно операции перепоудчаем даные  1с Сограсование


                }else{
                    Toast.makeText(context, "Нет файла 1С !!!"    , Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(context, "Нет файла 1С !!!"    , Toast.LENGTH_SHORT).show();
            }

            // TODO: 26.12.2022  конец основгого кода
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




}
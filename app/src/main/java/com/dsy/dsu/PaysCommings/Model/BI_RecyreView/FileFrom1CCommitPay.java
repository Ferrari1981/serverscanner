package com.dsy.dsu.PaysCommings.Model.BI_RecyreView;

import android.content.Context;
import android.util.Log;
import android.view.animation.Animation;
import android.widget.TableLayout;

import com.dsy.dsu.PaysCommings.View.RecyreView.MyViewHolderPay;
import com.dsy.dsu.Errors.Class_Generation_Errors;
import com.dsy.dsu.Services.Service_Notificatios_Для_Согласования;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.jetbrains.annotations.NotNull;

import io.reactivex.rxjava3.annotations.NonNull;

// TODO: 03.11.2023  класс добпдонительного добвления поля Файлыв Более Онлгого
public class FileFrom1CCommitPay {
    private  MyViewHolderPay holder;
    private Context context;

    private  Service_Notificatios_Для_Согласования.LocalBinderДляСогласования binderСогласования1C;
    public FileFrom1CCommitPay(@NonNull MyViewHolderPay holder,
                               @NonNull Context context,
                               @NonNull Service_Notificatios_Для_Согласования.LocalBinderДляСогласования binderСогласования1C) {
        this.holder = holder;
        this.context = context;
        this.binderСогласования1C = binderСогласования1C;

    }

    public void startFileFrom1CCommitPay(@NotNull JsonNode jsonNode1сСогласованияRow,
                                         @NonNull MyViewHolderPay holder,
                                         @NonNull Integer ПубличныйidPay,
                                         @NonNull  String getHiltCommintgPays) {
        try{
            // TODO: 03.11.2023 Parent
            TableLayout tableLayoutpayfilescommitingpays = (TableLayout) holder.tableLayoutpayfilescommitingpays;
                // TODO: 10.11.2023  Сама Вставка Данных Файлов От 1с Согласование

                AddFilesot1CPaycommitting addFilesot1CPaycommitting = new AddFilesot1CPaycommitting(context, binderСогласования1C);

                addFilesot1CPaycommitting.addfilessot1CPaycommitting(tableLayoutpayfilescommitingpays,
                        jsonNode1сСогласованияRow, holder, ПубличныйidPay,getHiltCommintgPays);

            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"+
                    " jsonNode1сСогласованияRow " +jsonNode1сСогласованияRow
                    + " tableLayoutcommitpayfiles.getChildCount() " +tableLayoutpayfilescommitingpays.getChildCount());

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


    // TODO: 09.11.2023  insert from Paren Row





    //todo end class FileFrom1CCommitPay
}//todo end class FileFrom1CCommitPay

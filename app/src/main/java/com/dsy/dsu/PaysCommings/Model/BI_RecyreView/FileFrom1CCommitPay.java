package com.dsy.dsu.PaysCommings.Model.BI_RecyreView;

import android.content.Context;
import android.util.Log;
import android.view.View;
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

    public FileFrom1CCommitPay(@NonNull MyViewHolderPay holder,
                               @NonNull Context context) {
        this.holder = holder;
        this.context = context;

    }

    public void startFileFrom1CCommitPay(@NotNull JsonNode jsonNode1сСогласованияRow,
                                         @NonNull MyViewHolderPay holder,
                                         @NonNull Service_Notificatios_Для_Согласования.LocalBinderДляСогласования binderСогласования1C,
                                         @NotNull Animation animation1,
                                         @NonNull Integer ПубличныйidPay,
                                          @NonNull ObjectMapper objectMapper) {
        try{
            // TODO: 03.11.2023 Parent
            TableLayout tableLayoutcommitpayfiles = (TableLayout) holder.tableLayoutcommitpayfiles;
            // TODO: 10.11.2023  Сама Вставка Данных Файлов От 1с Согласование
            ProccesingCancelOrOKPay  proccesingCancelOrOKPay
                    =new ProccesingCancelOrOKPay(context,binderСогласования1C,jsonNode1сСогласованияRow,animation1,objectMapper) ;

            proccesingCancelOrOKPay.new AddFilesot1CPaycommitting()
                    .addfilessot1CPaycommitting(  tableLayoutcommitpayfiles,  jsonNode1сСогласованияRow,holder, ПубличныйidPay);

            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"+
                    " jsonNode1сСогласованияRow " +jsonNode1сСогласованияRow);

            // TODO: 10.11.2023  после всего добавлени выкобчаем програсс бар
            holder.progressbar_commingpay .setVisibility(View.INVISIBLE);

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

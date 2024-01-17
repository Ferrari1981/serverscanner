package com.dsy.dsu.PaysCommings.View.RecyreViewNested;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TableLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dsy.dsu.Errors.Class_Generation_Errors;
import com.dsy.dsu.R;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textview.MaterialTextView;

// TODO: 15.03.2022  перенесееный код
// TODO: 28.02.2022 начало  MyViewHolderДляЧата
public class MyViewHolderPayNested extends RecyclerView.ViewHolder {// TODO: 28.02.2022 начало  MyViewHolderДляЧата
    // TODO: 28.02.2022
    public MaterialTextView tx_sum, tx_nomer, tx_zfo,
            tx_kontragent, tx_statiy,
            tx_namelklatura,
            tx_organizations;
    public MaterialButton     arrowpay_nested_receriview_commitingpay;
    public      MaterialTextView textViewКонтрагент,textViewЦФО,textViewДДС,TextViewНамелклатура;
    public MaterialCardView cardview_commingpay;
    public MaterialButton butt_cancel,butt_successcommit;
    public TableLayout tableLayoutcommitpayfiles ;

    public ProgressBar progressbar_commingpay;

    public RecyclerView recycleview_nesters_commininggpay;

    public Context context;

    public   JsonNode jsonNode1сСогласованияAllRows;


    // TODO: 02.03.2022
    public MyViewHolderPayNested(@NonNull View itemView,
                                 @NonNull Context context,
                                 @NonNull JsonNode jsonNode1сСогласованияAllRows ) {
        super(itemView);
        try{
            this.context=context;
            this.jsonNode1сСогласованияAllRows=jsonNode1сСогласованияAllRows;
            // TODO: 02.03.2022
            МетодИнициализацииКомпонетовЗаданияCardView(itemView);
            // TODO: 01.03.2022
            Log.d(this.getClass().getName(), "  private class MyViewHolderДляЧата extends RecyclerView.ViewHolder  itemView   " + itemView);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            // TODO: 01.09.2021 метод вызова
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }

    // TODO: 14.03.2022
    private void МетодИнициализацииКомпонетовЗаданияCardView(@NonNull View itemView) {
        try {

                Log.d(this.getClass().getName(), " отработоатл new SubClassBuccessLogin_ГлавныйКлассБизнесЛогикиФрагмент1 itemView   " + itemView);

                tx_sum = itemView.findViewById(R.id.tx_sum);
                tx_nomer = itemView.findViewById(R.id.tx_nomer);
                tx_zfo = itemView.findViewById(R.id.tx_zfo);
                tx_kontragent = itemView.findViewById(R.id.tx_kontragent);
                tx_statiy = itemView.findViewById(R.id.tx_statiy);
                tx_namelklatura = itemView.findViewById(R.id. tx_namelklatura);
                tx_organizations = itemView.findViewById(R.id.tx_organizations);


                 cardview_commingpay = itemView.findViewById(R.id.cardview_commingpay);

                butt_successcommit = itemView.findViewById(R.id.butt_successcommit);
                butt_cancel = itemView.findViewById(R.id.butt_cancel);

               tableLayoutcommitpayfiles = itemView.findViewById(R.id.tableLayoutcommitpayfiles);

             progressbar_commingpay = itemView.findViewById(R.id.progressbar_commingpay);

                // TODO: 12.01.2024 Click Arrow Nestesd
            arrowpay_nested_receriview_commitingpay= itemView.findViewById(R.id.arrowpay_nested_receriview_commitingpay);

            recycleview_nesters_commininggpay = itemView.findViewById(R.id.recycleview_nesters_commininggpay);




            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber()  );
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            // TODO: 01.09.2021 метод вызова
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
        /////
    }
} // TODO: 28.02.2022 конец  MyViewHolderДляЧата
// TODO: 28.02.2022 конец  MyViewHolderДляЧата
package com.dsy.dsu.CommitingPrices.Model.SendDataTo1C;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.dsy.dsu.CommitingPrices.View.MyRecycleViewNested.MyRecycleViewIsAdaptersNested;
import com.dsy.dsu.Errors.Class_Generation_Errors;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textview.MaterialTextView;

import org.jetbrains.annotations.NotNull;


// TODO: 11.01.2024  класс финально после получение ответ  переропределяем внезний вид  recyreview удаля теьбкущю плитку
public class ProcceroingResultatOtveta1CPost {
Context context;

    public ProcceroingResultatOtveta1CPost(@NonNull Context context) {
        this.context = context;
    }


   public void startingResultatOtveta1CPost(@NotNull StringBuffer  BufferOt1cCommintPricePost,
                                            @NotNull MaterialTextView mTV_commitingprices_count,
                                            @NotNull MyRecycleViewIsAdaptersNested myRecycleViewIsAdaptersNested,
                                            @NotNull Integer getAbsoluteAdapterPosition,
                                            @NotNull MaterialCardView cardview_commingprices_neasted,
                                            @NotNull ArrayNode ArrayNodeNested){
        try{
// TODO: 11.01.2024

            String ОтветОтСервера1сCommitnPricesPost=BufferOt1cCommintPricePost.toString().replaceAll("\"","\"\"");

            ОтветОтСервера1сCommitnPricesPost=ОтветОтСервера1сCommitnPricesPost.replaceAll("\"", "");



            if ( ОтветОтСервера1сCommitnPricesPost.length()>0 &&  ОтветОтСервера1сCommitnPricesPost.equalsIgnoreCase("Согласование внесено в базу!")) {

                // TODO: 11.01.2024

               // myRecycleViewIsAdaptersNested.itemView.startAnimation(animation);

      /*      Handler handler= myRecycleViewIsAdaptersNested.itemView.getHandler();

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                    }
                },250);*/

                myRecycleViewIsAdaptersNested.notifyItemRangeRemoved(getAbsoluteAdapterPosition,ArrayNodeNested.size());
                myRecycleViewIsAdaptersNested.notifyItemMoved(getAbsoluteAdapterPosition,ArrayNodeNested.size());

                cardview_commingprices_neasted.setVisibility(View.GONE);
                cardview_commingprices_neasted.refreshDrawableState();
                cardview_commingprices_neasted.requestLayout();

                ArrayNodeNested.remove(getAbsoluteAdapterPosition);

                Log.d(this.getClass().getName(), "\n"
                        + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                        " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                        " line " + Thread.currentThread().getStackTrace()[2].getLineNumber());

            } else {
                Toast.makeText(context, "Не прошла операция !!!"
                        +"\n"+mTV_commitingprices_count.getText().toString(), Toast.LENGTH_LONG).show();
            }


            Log.d(this.getClass().getName(), "\n"
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



}

package com.dsy.dsu.CommitingPrices.Model.BiccessLogicaFragmentCommitPrices;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dsy.dsu.Errors.Class_Generation_Errors;
import com.dsy.dsu.R;

public class InizializayRecyreViews {

    private RecyclerView recycleview_comminingpprices;
    private Context context;
    private Animation animationДляСогласования;

    public InizializayRecyreViews(RecyclerView recycleview_comminingpprices, Context context ) {
        this.recycleview_comminingpprices = recycleview_comminingpprices;
        this.context = context;
    }

    public void startInitRecyreview() {
        try {
            animationДляСогласования= AnimationUtils.loadAnimation(context, R.anim.slide_in_row);//R.anim.layout_animal_commit
            DividerItemDecoration itemDecoration =
                    new DividerItemDecoration(recycleview_comminingpprices.getContext(), DividerItemDecoration.HORIZONTAL);
            GradientDrawable drawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{0xfff7f7f7, 0xfff7f7f7});
            drawable.setSize(1,1);
            itemDecoration.setDrawable(drawable);
            recycleview_comminingpprices.addItemDecoration(itemDecoration);
            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(context);
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

}

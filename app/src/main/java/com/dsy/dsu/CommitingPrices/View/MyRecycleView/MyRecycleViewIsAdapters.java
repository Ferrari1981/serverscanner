package com.dsy.dsu.CommitingPrices.View.MyRecycleView;// TODO: 27.12.2023 Recyreview is null

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dsy.dsu.CommitingPrices.View.Window.ComponentsForRecyreView;
import com.dsy.dsu.Errors.Class_Generation_Errors;
import com.dsy.dsu.R;
import com.fasterxml.jackson.databind.JsonNode;

import org.jetbrains.annotations.NotNull;

import java.util.List;

// TODO: 09.11.2023 ВТОРОЯ Rereview
public  class MyRecycleViewIsAdapters extends RecyclerView.Adapter<MyViewHolders> {

    public JsonNode jsonNodeParent;
    private Context context;
    private MyViewHolders viewHolders;
    public MyRecycleViewIsAdapters(@NotNull JsonNode jsonNodeParent, @NotNull Context context) {
        // super();
        try{
        this.jsonNodeParent = jsonNodeParent;
        this.context = context;
        Log.d(this.getClass().getName(),"\n"
                + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber()+
                " jsonNodeParent.size() " + jsonNodeParent.size());
    } catch (Exception e) {
        e.printStackTrace();
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
        new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
    }


}


    @Override
    public void onBindViewHolder(@NonNull MyViewHolders holder, @NonNull int position, @NonNull List<Object> payloads) {
        try {
            // TODO: 02.03.2022
            ComponentsForRecyreView componentsForRecyreView=  new ComponentsForRecyreView(holder,context,position);

            componentsForRecyreView.getCardviewmatireacommitpay();

            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" +"jsonNode "
                    + jsonNodeParent + " position " +position);
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
    public void onViewRecycled(@NonNull MyViewHolders holder) {
        super.onViewRecycled(holder);
    }

    @Override
    public boolean onFailedToRecycleView(@NonNull MyViewHolders holder) {
        // TODO: 03.11.2023 Parent
        return super.onFailedToRecycleView(holder);

    }

    @Override
    public void onViewAttachedToWindow(@NonNull MyViewHolders holder) {
        super.onViewAttachedToWindow(holder);

    }

    @Override
    public void onViewDetachedFromWindow(@NonNull MyViewHolders holder) {
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
            Log.i(this.getClass().getName(), "   getItemViewType  position" + position);
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
    public MyViewHolders onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewComminigPrices = null;
        try {

            if (jsonNodeParent.size()>0) {
                viewComminigPrices = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.simple_for_commintgprices1, parent, false);
            } else {
                viewComminigPrices = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.simple_for_dont_commingprices, parent, false);
            }
            // TODO: 28.12.2023 получаем позицию в recyreview
            int  getPostionViewHolder=  getPostions();


            // TODO: 29.12.2023  получаем Single Row
            JsonNode jsonNodeSingleRow = getRowJsonNode(getPostionViewHolder);


            // TODO: 22.03.2022
            viewHolders = new MyViewHolders(viewComminigPrices,context,jsonNodeSingleRow,getPostionViewHolder);
            // TODO: 27.12.2023
            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"
                    + "   viewComminigPrices" + viewComminigPrices
                    + " getPostionViewHolder " +getPostionViewHolder  + "  jsonNodeParent.size() " +jsonNodeParent.size() +
                    " jsonNodeSingleRow " +jsonNodeSingleRow);

        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
        return viewHolders;

    }


    private JsonNode getRowJsonNode(int getPostionViewHolder) {
        JsonNode jsonNodeSingleRow=null;
        try{
          jsonNodeSingleRow=jsonNodeParent.get(getPostionViewHolder);
        // TODO: 27.12.2023
        Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"
                + "   jsonNodeSingleRow" + jsonNodeSingleRow
                + " getPostionViewHolder " +getPostionViewHolder  + "  jsonNodeParent.size() " +jsonNodeParent.size());

    } catch (Exception e) {
        e.printStackTrace();
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
        new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
    }
        return jsonNodeSingleRow;
    }

    private int getPostions() {
        int getPostionViewHolder = 0;
        try{
        if (viewHolders!=null) {
            getPostionViewHolder=   viewHolders.getAbsoluteAdapterPosition();
        }
        Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"
                + "   getPostionViewHolder" + getPostionViewHolder);

    } catch (Exception e) {
        e.printStackTrace();
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
        new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
    }
        return  getPostionViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolders holder, int position) {
        try {

            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"
                    + " position " +position);

        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }

    @Override
    public long getItemId(int position) {
        // TODO: 04.03.2022

        Log.i(this.getClass().getName(), "     getItemId holder.position " + position);

        return super.getItemId(position);

    }




    @Override
    public int getItemCount() {
        // TODO: 02.03.2022
        int КоличесвоСтрок = 0;
        try{
        if (jsonNodeParent!=null && jsonNodeParent.size()>0) {
            КоличесвоСтрок = jsonNodeParent.size();
            Log.d(this.getClass().getName(), "jsonNode.size() " + jsonNodeParent.size() + " КоличесвоСтрок " +КоличесвоСтрок);
        } else {
            КоличесвоСтрок=1;
            Log.d(this.getClass().getName(), "jsonNode.size() " + jsonNodeParent.size() + " холостой ход КоличесвоСтрок " +КоличесвоСтрок);
        }
        Log.d(this.getClass().getName(),"\n"
                + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber()+
                " jsonNodeParent.size() " + jsonNodeParent.size());
    } catch (Exception e) {
        e.printStackTrace();
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
        new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
    }
        // TODO: 28.02.2022
        return КоличесвоСтрок ;
    }
}//TODO  конец два22
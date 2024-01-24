package com.dsy.dsu.CommitingPrices.View.MyRecycleViewNested;// TODO: 27.12.2023 Recyreview is null

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dsy.dsu.CommitingPrices.Model.NestedDataGetAll.GetArrayNodeForNestedChildern;
import com.dsy.dsu.CommitingPrices.View.Window.ComponentsForRecyreViewNesteds;
import com.dsy.dsu.Errors.Class_Generation_Errors;
import com.dsy.dsu.Hilt.Jakson.HiltInterfaceJakson;
import com.dsy.dsu.Hilt.Sqlitehilt.HiltInterfacesqlite;
import com.dsy.dsu.R;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.android.material.card.MaterialCardView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.EntryPoints;

// TODO: 09.11.2023 ВТОРОЯ Rereview

public  class MyRecycleViewIsAdaptersNested extends RecyclerView.Adapter<MyViewHoldersNested> {

    public Context context;
    public View itemView;
    public  ArrayNode ArrayNodeNested;
    public  int getAbsoluteAdapterPosition;
    private MyViewHoldersNested viewHoldersNested;

    private Animation animation;

    private ObjectMapper objectMapper;

    private Integer getHiltPublicId;
    private String getHiltCommintgPrices;


    public MyRecycleViewIsAdaptersNested(@NonNull View itemView,
                                         @NotNull Context context,
                                         @NotNull JsonNode jsonNode,
                                         @NotNull int getAbsoluteAdapterPosition,
                                         @NotNull ObjectMapper objectMapper,
                                         @NotNull Integer getHiltPublicId,
                                         @NotNull String getHiltCommintgPrices) {
        // super();
        try{
            this.itemView=itemView;
            this.context=context;
            this.getAbsoluteAdapterPosition=getAbsoluteAdapterPosition;
            this.objectMapper=objectMapper;
            this.getHiltPublicId=getHiltPublicId;
            this.getHiltCommintgPrices=getHiltCommintgPrices;

            animation = AnimationUtils.loadAnimation(context,R.anim.slide_in_row8);

            // TODO: 09.01.2024  класс получаем все дочерние элементы ArrayNoide
            GetArrayNodeForNestedChildern getArrayNodeForNestedChildern=new GetArrayNodeForNestedChildern(context,  jsonNode );

            ArrayNodeNested=   getArrayNodeForNestedChildern.arrayNodeNested();



            // TODO: 02.03.2022
            Log.d(this.getClass().getName(),"\n"
                    + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber()+ "  ArrayNodeNested " + ArrayNodeNested.size());
        Log.d(this.getClass().getName(),"\n"
                + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber()+
                " jsonNode.size() " + jsonNode.size());
    } catch (Exception e) {
        e.printStackTrace();
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
        new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
    }


}


    @Override
    public void onBindViewHolder(@NonNull MyViewHoldersNested holder, @NonNull int position, @NonNull List<Object> payloads) {
        try {

            // TODO: 28.12.2023 получаем позицию в recyreview

            holder.ArrayNode=ArrayNodeNested.get(position);


            super.onBindViewHolder(holder, position, payloads);

            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" +"jsonNode "
                    + ArrayNodeNested+ " position " +position);
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
    public void setHasStableIds(boolean hasStableIds) {
        super.setHasStableIds(hasStableIds);
    }

    @Override
    public void onViewRecycled(@NonNull MyViewHoldersNested holder) {
        super.onViewRecycled(holder);
    }

    @Override
    public boolean onFailedToRecycleView(@NonNull MyViewHoldersNested holder) {
        // TODO: 03.11.2023 Parent
        return super.onFailedToRecycleView(holder);

    }

    @Override
    public void onViewAttachedToWindow(@NonNull MyViewHoldersNested holder) {
        super.onViewAttachedToWindow(holder);

    }

    @Override
    public void onViewDetachedFromWindow(@NonNull MyViewHoldersNested holder) {
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
    public MyViewHoldersNested onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewComminigPrices = null;
        try {

            if (ArrayNodeNested.size()>0) {
       /*         viewComminigPrices = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.simple_for_commintgprices1, parent, false);*/
                viewComminigPrices = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.simple_for_complitingprices_grid1, parent, false);
            } else {
                viewComminigPrices = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.simple_for_dont_commingprices, parent, false);
            }
            // TODO: 28.12.2023 получаем позицию в recyreview
            int  getPostionViewHolder=  getPostions();
            // TODO: 22.03.2022
            viewHoldersNested = new MyViewHoldersNested(viewComminigPrices,context,getPostionViewHolder);
            // TODO: 27.12.2023
            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"
                    + "   viewComminigPrices" + viewComminigPrices
                    + " getPostionViewHolder " +getPostionViewHolder  + " ArrayNodeNested.size() " +ArrayNodeNested.size());

        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
        return viewHoldersNested;

    }

    private int getPostions() {
        int getPostionViewHolder = 0;
        try{
        if (viewHoldersNested!=null) {
            getPostionViewHolder=   viewHoldersNested.getAbsoluteAdapterPosition();
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
    public void onBindViewHolder(@NonNull MyViewHoldersNested holder, int position) {
        try {
            MaterialCardView materialCardView=holder.itemView.findViewById(R.id.cardview_commingprices_neasted);

            ComponentsForRecyreViewNesteds componentsForRecyreViewNesteds=
                    new ComponentsForRecyreViewNesteds(holder,context,
                            position,materialCardView,animation,objectMapper,getHiltPublicId,
                            this,ArrayNodeNested,getHiltCommintgPrices);

// TODO: 30.12.2023  запуск метода Сверху Сумма согласования цены
            if (ArrayNodeNested.size()>0) {

                componentsForRecyreViewNesteds.getmTV_commitingprices_count();

                // TODO: 30.12.2023 кнопка подтверждения  согласования цены указонной
                componentsForRecyreViewNesteds.getArrow_nested_receriview();

                // TODO: 30.12.2023 кнопка Номелклатура
                componentsForRecyreViewNesteds.getmTV_Nomenklatura();

                // TODO: 30.12.2023 кнопка ДДС
                componentsForRecyreViewNesteds.getmTV_StatyaDDS_value();

                // TODO: 30.12.2023 кнопка Единица измериния
                componentsForRecyreViewNesteds.getmTV_EdIzm_value();

                // TODO: 30.12.2023 кнопка Дата
                componentsForRecyreViewNesteds.getmTV_Data_value();

                // TODO: 30.12.2023 кнопка Количество
                componentsForRecyreViewNesteds.getmTV_Kolichestvo_value();

                // TODO: 30.12.2023 кнопка ЦФО Расчет
                componentsForRecyreViewNesteds.getmTV_CFORaskhoda_value();


                // TODO: 30.12.2023  rebbot Sxreen Recyreview
                componentsForRecyreViewNesteds.setagMaterialCardViewNestad();
                // TODO: 23.01.2024 кожа нет данных
            }

            Log.d(this.getClass().getName(), "\n"
                    + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber());

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
        if (ArrayNodeNested!=null && ArrayNodeNested.size()>0) {
           КоличесвоСтрок = ArrayNodeNested.size();
            Log.d(this.getClass().getName(), "jsonNodeNested.size() " + ArrayNodeNested.size() + " КоличесвоСтрок " +КоличесвоСтрок);
        }
        Log.d(this.getClass().getName(),"\n"
                + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber()+
                " ArrayNodeNested.size() " + ArrayNodeNested.size());
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
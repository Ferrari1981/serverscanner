package com.dsy.dsu.CommitingPrices.View.Window;

import android.content.Context;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.dsy.dsu.CommitingPrices.View.MyRecycleView.MyViewHolders;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

import org.jetbrains.annotations.NotNull;

public class ComponentsForRecyreViewNesteds {

    private MyViewHolders holder;
    private Context context;

    private  int getAbsoluteAdapterPosition;


    private TextView textView1, textView2, textView3, textView4, textView5Намеклатура, textorganizationvalue, textvalueSUM;
    private      TextView textViewКонтрагент,textViewЦФО,textViewДДС,textViewНамелклатура;
    private MaterialCardView cardviewmatireacommitpay;
    private MaterialButton kнопкаСогласованиеОтказ,kнопкаУспешноеСогласования;
    private TableLayout tableLayoutcommitpayfiles,tableLayoutcommitpay;
    private ProgressBar progressbarfilepay;

    RecyclerView recycleview_comminingppricesNested;



    public ComponentsForRecyreViewNesteds(@NotNull MyViewHolders holder,
                                          @NotNull  Context context,
                                          @NotNull int getAbsoluteAdapterPosition,
                                          @NotNull RecyclerView recycleview_comminingppricesNested) {
        this.holder = holder;
        this.context = context;
        this.getAbsoluteAdapterPosition = getAbsoluteAdapterPosition;
        this.recycleview_comminingppricesNested = recycleview_comminingppricesNested;
    }

    public TextView getTextView1() {
        return textView1;
    }

    public void setTextView1(TextView textView1) {
        this.textView1 = textView1;
    }

    public TextView getTextView2() {
        return textView2;
    }

    public void setTextView2(TextView textView2) {
        this.textView2 = textView2;
    }

    public TextView getTextView3() {
        return textView3;
    }

    public void setTextView3(TextView textView3) {
        this.textView3 = textView3;
    }

    public TextView getTextView4() {
        return textView4;
    }

    public void setTextView4(TextView textView4) {
        this.textView4 = textView4;
    }

    public TextView getTextView5Намеклатура() {
        return textView5Намеклатура;
    }

    public void setTextView5Намеклатура(TextView textView5Намеклатура) {
        this.textView5Намеклатура = textView5Намеклатура;
    }

    public TextView getTextorganizationvalue() {
        return textorganizationvalue;
    }

    public void setTextorganizationvalue(TextView textorganizationvalue) {
        this.textorganizationvalue = textorganizationvalue;
    }

    public TextView getTextvalueSUM() {
        return textvalueSUM;
    }

    public void setTextvalueSUM(TextView textvalueSUM) {
        this.textvalueSUM = textvalueSUM;
    }

    public TextView getTextViewКонтрагент() {
        return textViewКонтрагент;
    }

    public void setTextViewКонтрагент(TextView textViewКонтрагент) {
        this.textViewКонтрагент = textViewКонтрагент;
    }

    public TextView getTextViewЦФО() {
        return textViewЦФО;
    }

    public void setTextViewЦФО(TextView textViewЦФО) {
        this.textViewЦФО = textViewЦФО;
    }

    public TextView getTextViewДДС() {
        return textViewДДС;
    }

    public void setTextViewДДС(TextView textViewДДС) {
        this.textViewДДС = textViewДДС;
    }

    public TextView getTextViewНамелклатура() {
        return textViewНамелклатура;
    }

    public void setTextViewНамелклатура(TextView textViewНамелклатура) {
        this.textViewНамелклатура = textViewНамелклатура;
    }

    public MaterialCardView getCardviewmatireacommitpay() {

        Log.d(this.getClass().getName(), "\n"
                + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber()
                +" holder.jsonNode " +  holder.jsonNode +  " holder.itemView  " +  holder.itemView);
        return cardviewmatireacommitpay;
    }

    public void setCardviewmatireacommitpay(MaterialCardView cardviewmatireacommitpay) {
        this.cardviewmatireacommitpay = cardviewmatireacommitpay;
    }

    public MaterialButton getKнопкаСогласованиеОтказ() {
        return kнопкаСогласованиеОтказ;
    }

    public void setKнопкаСогласованиеОтказ(MaterialButton kнопкаСогласованиеОтказ) {
        this.kнопкаСогласованиеОтказ = kнопкаСогласованиеОтказ;
    }

    public MaterialButton getKнопкаУспешноеСогласования() {
        return kнопкаУспешноеСогласования;
    }

    public void setKнопкаУспешноеСогласования(MaterialButton kнопкаУспешноеСогласования) {
        this.kнопкаУспешноеСогласования = kнопкаУспешноеСогласования;
    }

    public TableLayout getTableLayoutcommitpayfiles() {
        return tableLayoutcommitpayfiles;
    }

    public void setTableLayoutcommitpayfiles(TableLayout tableLayoutcommitpayfiles) {
        this.tableLayoutcommitpayfiles = tableLayoutcommitpayfiles;
    }

    public TableLayout getTableLayoutcommitpay() {
        return tableLayoutcommitpay;
    }

    public void setTableLayoutcommitpay(TableLayout tableLayoutcommitpay) {
        this.tableLayoutcommitpay = tableLayoutcommitpay;
    }

    public ProgressBar getProgressbarfilepay() {
        return progressbarfilepay;
    }

    public void setProgressbarfilepay(ProgressBar progressbarfilepay) {
        this.progressbarfilepay = progressbarfilepay;
    }

    public RecyclerView getRecycleview_comminingppricesNested() {
        return recycleview_comminingppricesNested;
    }

    public void setRecycleview_comminingppricesNested(RecyclerView recycleview_comminingppricesNested) {
        this.recycleview_comminingppricesNested = recycleview_comminingppricesNested;
    }



}







package com.dsy.dsu.CommitingPrices.View.Window;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.dsy.dsu.CommitingPrices.Model.BiccessLogicaFragmentCommitPrices.BiznesLogicainnerFragment;
import com.dsy.dsu.CommitingPrices.Model.BiccessLogicaFragmentCommitPrices.InizializayRecyreViews;
import com.dsy.dsu.CommitingPrices.ViewModel.ModelComminingPrisesByte;
import com.dsy.dsu.CommitingPrices.ViewModel.ModelComminingPrisesString;
import com.dsy.dsu.Errors.Class_Generation_Errors;
import com.dsy.dsu.R;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class FragmentCommingPrices extends Fragment {

    @Inject
    ObjectMapper getHiltJaksonObjectMapper;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private LifecycleOwner lifecycleOwner;
    private RecyclerView recycleview_comminingpprices;


    private ProgressBar prograessbar_commintingprices ;

    private  ModelComminingPrisesString modelComminingPrisesString;
    private  ModelComminingPrisesByte modelComminingPrisesByte;


    private   BiznesLogicainnerFragment biznesLogicainnerFragment;

    public FragmentCommingPrices() {
        // Required empty public constructor
        Log.d(this.getClass().getName(),"\n"
                + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber());
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try{

           modelComminingPrisesString =((MainActivityCommitingPrices)getActivity()).modelComminingPrisesString;
           modelComminingPrisesByte =((MainActivityCommitingPrices)getActivity()).modelComminingPrisesByte;

            Bundle data=      getArguments();
            fragmentManager = getActivity(). getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            lifecycleOwner=this;
            Log.d(this.getClass().getName(),"\n"
                + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber());

    } catch (Exception e) {
        e.printStackTrace();
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
        new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
    }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View viewCommintPrices=null;
        try{
                viewCommintPrices = inflater.inflate(R.layout.activity_main_fragmentcommitprices, container, false);

        Log.d(this.getClass().getName(),"\n"
                + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber());
    } catch (Exception e) {
        e.printStackTrace();
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
        new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
    }
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_comming_prices, container, false);
        return viewCommintPrices;
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        try{
            recycleview_comminingpprices = view.findViewById(R.id.recycleview_comminingpprices);
            prograessbar_commintingprices= view.findViewById(R.id.prograessbar_commintingprices);


            // TODO: 28.12.2023  запускаем класс бизнес логики для Фрагметна Commint Prices
            biznesLogicainnerFragment=new BiznesLogicainnerFragment(getActivity(),getContext()
                    ,getHiltJaksonObjectMapper,modelComminingPrisesString,
                    modelComminingPrisesByte ,recycleview_comminingpprices
                    ,prograessbar_commintingprices,lifecycleOwner );


              // TODO: 27.12.2023  начинаем запуск is null
            biznesLogicainnerFragment.startIsNullRecyreView( );

            // TODO: 28.12.2023 инизилащитция recyreview

             new InizializayRecyreViews(recycleview_comminingpprices,getContext()).startInitRecyreview();

         // TODO: 26.12.2023 запускаем получение данных при NULL
            biznesLogicainnerFragment.getmodelByte();

            Log.d(this.getClass().getName(),"\n"
                    + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber()+
                    " recycleview_comminingpprices " +recycleview_comminingpprices);


    } catch (Exception e) {
        e.printStackTrace();
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
        new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
    }
    }


    @Override
    public void onStart() {
        super.onStart();
 try{

/*     // TODO: 26.12.2023
     biznesLogicainnerFragment.getmodelByte();*/

        Log.d(this.getClass().getName(),"\n"
                + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber()+
                " recycleview_comminingpprices " +recycleview_comminingpprices);
    } catch (Exception e) {
        e.printStackTrace();
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
        new Class_Generation_Errors(getContext()).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
    }
    }

    // TODO: 26.12.2023  бизнес логика самого Фрагмента CommintPrices


}
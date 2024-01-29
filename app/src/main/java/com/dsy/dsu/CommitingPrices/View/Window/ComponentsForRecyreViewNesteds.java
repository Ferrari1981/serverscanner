package com.dsy.dsu.CommitingPrices.View.Window;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.animation.Animation;
import android.widget.Toast;

import com.dsy.dsu.CommitingPrices.Model.SendDataTo1C.CommintPricesSendJsonTo1C;
import com.dsy.dsu.CommitingPrices.Model.SendDataTo1C.ProcceroingResultatOtveta1CPost;
import com.dsy.dsu.CommitingPrices.Model.SendDataTo1C.StartSendJsonToCOmmintPrices;
import com.dsy.dsu.CommitingPrices.View.MyRecycleViewNested.MyRecycleViewIsAdaptersNested;
import com.dsy.dsu.CommitingPrices.View.MyRecycleViewNested.MyViewHoldersNested;
import com.dsy.dsu.Errors.Class_Generation_Errors;
import com.dsy.dsu.R;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textview.MaterialTextView;
import com.jakewharton.rxbinding4.view.RxView;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import kotlin.Unit;

public class ComponentsForRecyreViewNesteds {

    private MyViewHoldersNested holder;
    private Context context;
    private  int getAbsoluteAdapterPosition;

    private  MaterialCardView cardview_commingprices_neasted;

    // TODO: 30.12.2023 компоненты для запоелния
    private MaterialTextView mTV_commitingprices_count;

    private     MaterialButton arrow_nested_receriview;

    private     MaterialTextView mTV_Nomenklatura,mTV_StatyaDDS_value
            ,mTV_EdIzm_value,mTV_Data_value,
            mTV_Kolichestvo_value,mTV_CFORaskhoda_value;


    private Animation animation;

    private ObjectMapper objectMapper;

    private Integer getHiltPublicId;

    private MyRecycleViewIsAdaptersNested myRecycleViewIsAdaptersNested;
    private ArrayNode ArrayNodeNested;

    private   String getHiltCommintgPrices;



    public ComponentsForRecyreViewNesteds(@NotNull MyViewHoldersNested holder,
                                          @NotNull  Context context,
                                          @NotNull int getAbsoluteAdapterPosition,
                                          @NotNull MaterialCardView cardview_commingprices_neasted,
                                          @NotNull Animation animation,
                                          @NotNull ObjectMapper objectMapper,
                                          @NotNull Integer getHiltPublicId,
                                          @NotNull MyRecycleViewIsAdaptersNested myRecycleViewIsAdaptersNested,
                                          @NotNull ArrayNode ArrayNodeNested,
                                          @NotNull String getHiltCommintgPrices) {
        this.holder = holder;
        this.context = context;
        this.getAbsoluteAdapterPosition = getAbsoluteAdapterPosition;
        this.cardview_commingprices_neasted = cardview_commingprices_neasted;
        this.animation = animation;
        this.objectMapper = objectMapper;
        this.getHiltPublicId = getHiltPublicId;
        this.myRecycleViewIsAdaptersNested = myRecycleViewIsAdaptersNested;
        this.ArrayNodeNested = ArrayNodeNested;
        this.getHiltCommintgPrices = getHiltCommintgPrices;
    }




    public MaterialTextView getmTV_commitingprices_count() {
  try{
      mTV_commitingprices_count=    holder.itemView.findViewById(R.id.mTV_commitingprices_count) ;
      JsonNode jsonNode=    holder.ArrayNode.deepCopy();
      TextNode textNodeCena=( TextNode)   jsonNode.findValue("Cena").deepCopy();
      String cena=  textNodeCena.asText().trim();
      if (! cena.isEmpty()) {
          mTV_commitingprices_count.setText(cena+" (руб)");
          mTV_commitingprices_count.startAnimation(animation);
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

        return mTV_commitingprices_count;
    }

    public MaterialButton getArrow_nested_receriview() {
        try{
            arrow_nested_receriview=    holder.itemView.findViewById(R.id.arrow_nested_receriview) ;

            RxView.clicks(  arrow_nested_receriview)
                    .throttleFirst(2, TimeUnit.SECONDS)
                    .filter(s -> !s.toString().isEmpty())
                    .map(new Function<Unit, MaterialButton>() {
                        @Override
                        public MaterialButton apply(Unit unit) throws Throwable {

                            // TODO: 30.12.2023 вибрация
                            Vibrator v2 = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
                            v2.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));

                            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" );
                            return    arrow_nested_receriview;
                        }
                    })
                    .doOnError(new Consumer<Throwable>() {
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
                    .subscribe( MaterialButtonNested-> {


                        ///todo revboot нажимаем для подтвердить
                        eventButtonArrow(MaterialButtonNested);


                        Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"  );

                    });

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
        return arrow_nested_receriview;
    }

    private void eventButtonArrow(MaterialButton MaterialButtonNested) {
        Handler handler=     arrow_nested_receriview.getHandler();
        handler.postDelayed(()->{
            // TODO: 11.01.2024
            try{
                // TODO: 10.01.2024  запускаем Генерацию JSON  согласование 1с
                Bundle bundleДанныеДляPost=(Bundle)          cardview_commingprices_neasted.getTag();
                StartSendJsonToCOmmintPrices startSendJsonToCOmmintPrices=new StartSendJsonToCOmmintPrices(context,objectMapper,getHiltPublicId);
                byte[] ByteFor1CCommintPrices=   startSendJsonToCOmmintPrices.startSendJson1c(bundleДанныеДляPost);

                if (ByteFor1CCommintPrices!=null) {
                    // TODO: 10.01.2024  Отправляем Сгенерированый JSON
                    String UUID=   bundleДанныеДляPost.getString("UUID").trim();
                    CommintPricesSendJsonTo1C generatorJsonForPostComminhgPrices=new CommintPricesSendJsonTo1C();

                    // TODO: 10.01.2024 RELUS
                    StringBuffer  BufferOt1cCommintPricePost=   generatorJsonForPostComminhgPrices.SendJsonForPostComminhgPrices(context,
                            ByteFor1CCommintPrices,getHiltPublicId,getHiltCommintgPrices, UUID);




                    // TODO: 10.01.2024 Скрываем Текущий Платеж По Которому был Клик http://192.168.254.218/dds_copy/hs/jsonto1ccena/listofdocuments
                    // TODO: 11.01.2024 терперь третьй вариант пользователюю  прячем указвнный текущий Плитку с соглдосваниием
                    ProcceroingResultatOtveta1CPost procceroingResultatOtveta1CPost=new ProcceroingResultatOtveta1CPost(context);
                    procceroingResultatOtveta1CPost.startingResultatOtveta1CPost(  BufferOt1cCommintPricePost,
                            mTV_commitingprices_count,
                            myRecycleViewIsAdaptersNested,
                            getAbsoluteAdapterPosition
                            ,cardview_commingprices_neasted,ArrayNodeNested,holder);


                    Log.d(this.getClass().getName(),"\n"
                            + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                            " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                            " line " + Thread.currentThread().getStackTrace()[2].getLineNumber()
                            +  " MaterialButtonNested " + MaterialButtonNested
                            + " BufferOt1cCommintPricePost " +BufferOt1cCommintPricePost);

                }else {

                    Toast.makeText(context, "Не прошла операция !!!"
                            +"\n"+mTV_commitingprices_count.getText().toString(), Toast.LENGTH_LONG).show();
                }

                Log.d(this.getClass().getName(),"\n"
                        + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                        " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                        " line " + Thread.currentThread().getStackTrace()[2].getLineNumber()
                        +  " MaterialButtonNested " + MaterialButtonNested
                        + " bundleДанныеДляPost " +bundleДанныеДляPost);
            } catch (Exception e) {
                e.printStackTrace();
                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                        " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                        Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
            }

        },100);
    }


    public MaterialTextView getmTV_Nomenklatura() {
        try{
            mTV_Nomenklatura=    holder.itemView.findViewById(R.id.mTV_Nomenklatura) ;
            JsonNode jsonNode=    holder.ArrayNode.deepCopy();
            TextNode textNodeNomenklatura=( TextNode)   jsonNode.findValue("Nomenklatura").deepCopy();
            // TODO: 30.12.2023  
            if ( !textNodeNomenklatura.asText().isEmpty()) {
                // TODO: 30.12.2023  set
                mTV_Nomenklatura.setText(textNodeNomenklatura.asText().trim());
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
        return mTV_Nomenklatura;
    }

    public MaterialTextView getmTV_StatyaDDS_value() {
        try{
            mTV_StatyaDDS_value=    holder.itemView.findViewById(R.id.mTV_StatyaDDS_value) ;
            JsonNode jsonNode=    holder.ArrayNode.deepCopy();
            TextNode textNodeStatyaDDS=( TextNode)   jsonNode.findValue("StatyaDDS").deepCopy();
                // TODO: 30.12.2023  
            if (!textNodeStatyaDDS.asText().isEmpty()) {
                // TODO: 30.12.2023 set
                mTV_StatyaDDS_value.setText(textNodeStatyaDDS.asText().trim());
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
        return mTV_StatyaDDS_value;
    }

    public MaterialTextView getmTV_EdIzm_value() {
        try{
            mTV_EdIzm_value=    holder.itemView.findViewById(R.id.mTV_EdIzm_value) ;
            JsonNode jsonNode=    holder.ArrayNode.deepCopy();
            TextNode textNodeEdIzm=( TextNode)   jsonNode.findValue("EdIzm").deepCopy();
            // TODO: 30.12.2023  
            if ( !textNodeEdIzm.asText().isEmpty()) {
                // TODO: 30.12.2023  set
                mTV_EdIzm_value.setText(textNodeEdIzm.asText().trim());
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
        return mTV_EdIzm_value;
    }



    public MaterialTextView getmTV_Data_value() {
        try{
            mTV_Data_value=    holder.itemView.findViewById(R.id.mTV_Data_value) ;
            JsonNode jsonNode=    holder.ArrayNode.deepCopy();
            TextNode textNodeData=( TextNode)   jsonNode.findValue("Data").deepCopy();
            if ( !textNodeData.asText().isEmpty()) {
                String data=  textNodeData.asText().trim();
            Date датаEdIzm =
                    new  SimpleDateFormat("dd.MM.yyyy HH:mm:ss", new Locale("ru")).parse(data);//TODO "2023-08-01 19:00:59.781"

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss",new Locale("ru"));
            LocalDate dateTime = LocalDate.parse(textNodeData.asText().trim(), formatter);

         SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd.MM.yyyy");
            String ДатаEdIzm=simpleDateFormat.format(датаEdIzm);
            // TODO: 30.12.2023  

                // TODO: 30.12.2023 set
                mTV_Data_value.setText(ДатаEdIzm);
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
        return mTV_Data_value;
    }

    public MaterialTextView getmTV_Kolichestvo_value() {
        try{
            mTV_Kolichestvo_value=    holder.itemView.findViewById(R.id.mTV_Kolichestvo_value) ;
            JsonNode jsonNode=    holder.ArrayNode.deepCopy();
            TextNode textNodeKolichestvo=( TextNode)   jsonNode.findValue("Kolichestvo").deepCopy();

            if ( !textNodeKolichestvo.asText().isEmpty()) {
                // TODO: 30.12.2023 set
                mTV_Kolichestvo_value.setText(textNodeKolichestvo.asText().trim());
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
        return mTV_Kolichestvo_value;
    }

    public MaterialTextView getmTV_CFORaskhoda_value() {
        try{
            mTV_CFORaskhoda_value=    holder.itemView.findViewById(R.id.mTV_CFORaskhoda_value) ;
            JsonNode jsonNode=    holder.ArrayNode.deepCopy();
            TextNode textNodeCFORaskhoda=( TextNode)   jsonNode.findValue("CFORaskhoda").deepCopy();
            // TODO: 30.12.2023
            if (! textNodeCFORaskhoda.asText().isEmpty()) {
                mTV_CFORaskhoda_value.setText(textNodeCFORaskhoda.asText().trim());
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
        return mTV_CFORaskhoda_value;
    }


    public MaterialCardView setagMaterialCardViewNestad() {

        try{
            JsonNode jsonNode=    holder.ArrayNode.deepCopy();
            TextNode textNodeUUID=( TextNode)   jsonNode.findValue("UUID").deepCopy();
            TextNode textNodeCena=( TextNode)   jsonNode.findValue("Cena").deepCopy();
            if(!textNodeUUID.asText().isEmpty()){
                String  UUID= textNodeUUID.asText();
                Long  UUIDlong= textNodeUUID.asLong();
                // TODO: 10.01.2024 цена
                String  Цена= textNodeCena.asText();
                // TODO: 10.01.2024 цена

                Bundle bundleuuid=new Bundle();
                bundleuuid.putString("UUID",UUID);
                bundleuuid.putString("Цена",Цена);
                bundleuuid.putLong("UUIDlong",UUIDlong);
                // TODO: 30.12.2023 uuid get
                cardview_commingprices_neasted.setTag(bundleuuid);
            }
            cardview_commingprices_neasted.forceLayout();

            Log.d(this.getClass().getName(), "\n"
                    + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() );

        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }

        return cardview_commingprices_neasted;
    }







}







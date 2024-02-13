package businesslogic;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.istack.NotNull;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.*;
import io.reactivex.rxjava3.disposables.Disposable;

import io.reactivex.rxjava3.functions.Action;
import org.hibernate.procedure.ProcedureOutputs;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.*;
import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Map.Entry;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;

import org.hibernate.Session;


//TODO
@Named("operasionsInsertAndUpdates")
public class OperasionsInsertAndUpdates {
    private   ServletContext ЛОГ;
    @Inject
    private   SubClassWriterErros subClassWriterErros;
    @Inject
    private  ObjectMapper getGeneratorJackson;
   private Session session;
    @Inject
    private TransationCompleteSession transationCompleteSession;
    private  StringBuffer bufferCallsBackToAndroid=new StringBuffer();
    private  JsonNode  jsonNodeParent;

    @Resource
   javax.transaction.UserTransaction userTransaction;


    // TODO: 09.03.2023
    StringBuffer методCompleteInsertorUpdateData(
            @NotNull ServletContext ЛОГ,
            @NotNull InputStream requestInputStream
            , @NotNull String ТаблицаPOST,
            @NotNull Session session) throws SQLException {
        try {
            this.ЛОГ=ЛОГ;
            this.session=session;
            // TODO: 13.02.2024 операции вставки и обновление данными клиента тоесть Андродай
            Maybe.just("ProccesingOperUpdateOrInsert").blockingSubscribe(new MaybeObserver<Object>() {
                @Override
                public void onSubscribe(@NonNull Disposable d) {
                    // TODO: 16.11.2023 ПолУЧАЕМ ДАННЫЕ ИЗ ПОТОКА ОТ КЛИЕНТА
                    try {
                      jsonNodeParent = metodGetDataFromSreamByte(ЛОГ, requestInputStream);

                        ЛОГ.log("\n"+" class "+Thread.currentThread().getStackTrace()[2].getClassName() +"\n"+
                                " metod "+Thread.currentThread().getStackTrace()[2].getMethodName() +"\n"+
                                " line "+  Thread.currentThread().getStackTrace()[2].getLineNumber()+"\n" + " jsonNodeParent " +jsonNodeParent);
                    } catch (IOException e) {
                        ЛОГ.log( "ERROR class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber()  + " e " +e.getMessage() );
                        subClassWriterErros.МетодаЗаписиОшибкиВЛог(e,
                                Thread.currentThread().
                                        getStackTrace(),
                                ЛОГ,"ErrorsLogs/ErrorJbossServletDSU1.txt");
                    }
                }

                @Override
                public void onSuccess(@NonNull Object o) {

// TODO: 13.02.2024  результат получаем опеарций Post
                    CopyOnWriteArrayList<Long> arrayListMaxBackOperation= (CopyOnWriteArrayList<Long>) o;

                    clossingImputSreatm(requestInputStream);

// TODO: 29.11.2023 закрывам Сесиою HIbernate
                    transationCompleteSession.commitingTransastion(  session);

                    bufferCallsBackToAndroid=    resultatcomplitenigfromAndroid(arrayListMaxBackOperation );


                    ЛОГ.log("\n"+" class "+Thread.currentThread().getStackTrace()[2].getClassName() +"\n"+
                            " metod "+Thread.currentThread().getStackTrace()[2].getMethodName() +"\n"+
                            " line "+  Thread.currentThread().getStackTrace()[2].getLineNumber()+"\n"+
                            " bufferCallsBackToAndroid "+ bufferCallsBackToAndroid);
                }

                @Override
                public void onError(@NonNull Throwable e) {
                    // TODO: 17.11.2023 ERROR transaction
                    transationCompleteSession.erroringTransastion(ЛОГ,session);
                    ЛОГ.log( "ERROR class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                            " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                            " line " + Thread.currentThread().getStackTrace()[2].getLineNumber()  + " e " +e.getMessage() );
                    Exception ex = new Exception(e);
                    subClassWriterErros.МетодаЗаписиОшибкиВЛог(ex,
                            Thread.currentThread().
                                    getStackTrace(),
                            ЛОГ,"ErrorsLogs/ErrorJbossServletDSU1.txt");
                }

                @Override
                public void onComplete() {
                    // TODO: 16.11.2023 ГЛАЫНЫЙ МЕТОД ВСТАВКИ И ОБНОВЛЕНИЯ SQL SERVER
                    CopyOnWriteArrayList<Long> arrayListMaxBackOperation=   ProccesingOpersionUpdateOrInsert(ЛОГ, ТаблицаPOST,  jsonNodeParent );
                    // TODO: 13.02.2024
                    onSuccess(arrayListMaxBackOperation);
                    ЛОГ.log("\n"+" class "+Thread.currentThread().getStackTrace()[2].getClassName() +"\n"+
                            " metod "+Thread.currentThread().getStackTrace()[2].getMethodName() +"\n"+
                            " line "+  Thread.currentThread().getStackTrace()[2].getLineNumber()+"\n"+
                            " arrayListMaxBackOperation "+ arrayListMaxBackOperation);
                }
            });


        } catch (Exception   e) {
            ЛОГ.log( "ERROR class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber()  + " e " +e.getMessage() );
            subClassWriterErros.МетодаЗаписиОшибкиВЛог(e,
                            Thread.currentThread().
                                    getStackTrace(),
                            ЛОГ,"ErrorsLogs/ErrorJbossServletDSU1.txt");
        }
        return bufferCallsBackToAndroid;
    }








    private StringBuffer resultatcomplitenigfromAndroid(CopyOnWriteArrayList<Long> arrayListMaxBackOperation) {
        StringBuffer bufferCallsBackToAndroid = new StringBuffer();
        try{
        // TODO: 22.04.2023
        Long  MaxВсеОперации = arrayListMaxBackOperation
                .stream()
                .filter(filt->filt!=null)
                .mapToLong(v -> v)
                .max().orElse(0l);
        // TODO: 22.04.2023 ОТВЕТ
        bufferCallsBackToAndroid.append(MaxВсеОперации.toString());

    } catch (Exception   e) {
        ЛОГ.log( "ERROR class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber()  + " e " +e.getMessage() );
        subClassWriterErros.МетодаЗаписиОшибкиВЛог(e,
                Thread.currentThread().
                        getStackTrace(),
                ЛОГ,"ErrorsLogs/ErrorJbossServletDSU1.txt");
    }
        return  bufferCallsBackToAndroid;
    }


    private void clossingImputSreatm(InputStream requestInputStream) {
        try {
            requestInputStream.close();
            ЛОГ.log("\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n");
        } catch (Exception e) {
            ЛОГ.log("ERROR class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + " e " + e.getMessage());
            subClassWriterErros.МетодаЗаписиОшибкиВЛог(e,
                    Thread.currentThread().
                            getStackTrace(),
                    ЛОГ, "ErrorsLogs/ErrorJbossServletDSU1.txt");
        }

    }
        
        
        
        
        
        
    // TODO: 16.11.2023 ГЛАВНЫЙ МЕТОД ВСТАВКИ И ОБНОВЛНИЕ ДАННЫХ от КЛИЕНТА
    private CopyOnWriteArrayList<Long> ProccesingOpersionUpdateOrInsert(@NotNull ServletContext ЛОГ,
                                                                        @NotNull String ТаблицаPOST,
                                                                        @NotNull   JsonNode jsonNodeParent) {

        CopyOnWriteArrayList<Long> arrayListMaxBackOperation = new CopyOnWriteArrayList<>();
        try{
        jsonNodeParent.elements().forEachRemaining(new Consumer<JsonNode>() {
            @Override
            public void accept(JsonNode jsonNodeInner) {
                // TODO: 17.11.2023 set procedure
                // TODO: 16.11.2023 УСТАНАВЛИВАЕМ КАКАЯ ПРОЦЕДУРА БУДЕТ ВЫПОЛЯТЬСЯ НА SQL SERVER
                final StoredProcedureQuery queryprocedure = metodSelectingProcedureSQlServer(ЛОГ, ТаблицаPOST);
                // TODO: 17.11.2023 get key
                final long Key = jsonNodeInner.get("uuid").asLong();
                // TODO: 17.11.2023 ROW
                jsonNodeInner.fields().forEachRemaining(new Consumer<Entry<String, JsonNode>>() {
                    @Override
                    public void accept(Entry<String, JsonNode> stringJsonNodeEntryTwo) {
                        // TODO: 22.04.2023  Парсинг Rows JSON
                        ЛОГ.log("stringJsonNodeEntryTwo.getKey() " + stringJsonNodeEntryTwo.getKey() + " stringJsonNodeEntryTwo.getValue() "
                                + stringJsonNodeEntryTwo.getValue() +
                                "   queryprocedure  " + queryprocedure + " ТаблицаPOST " + ТаблицаPOST);
                        switch (ТаблицаPOST.trim()) {
                            case "materials_databinary":
                                методFillingMaterialBinaryValuRows(stringJsonNodeEntryTwo, queryprocedure, "image");
                                break;
                            case "data_chat":
                                методFillingChatBinaryValuRows(stringJsonNodeEntryTwo, queryprocedure, "image_chat");
                                break;
                            default:
                                методFillingValuesRows(stringJsonNodeEntryTwo, queryprocedure, ТаблицаPOST);
                                break;

                        }
                        ЛОГ.log("stringJsonNodeEntryTwo.getKey() " + stringJsonNodeEntryTwo.getKey() + " stringJsonNodeEntryTwo.getValue() "
                                + stringJsonNodeEntryTwo.getValue() +
                                "   queryprocedure[0]  " + queryprocedure + " ТаблицаPOST " + ТаблицаPOST);
                    }
                });
                // TODO: 16.11.2023  key

                // TODO: 22.04.2023  После Запоеление ПОЛНОЙ СТРОЧКИ ROW JSON
                queryprocedure.registerStoredProcedureParameter("SrabnitUUIDOrID", String.class, ParameterMode.IN)
                        .setParameter("SrabnitUUIDOrID", String.valueOf(Key));
                queryprocedure.registerStoredProcedureParameter("ResultatMERGE", String.class, ParameterMode.INOUT)
                        .setParameter("ResultatMERGE", "complete merge");

                // TODO: 22.04.2023 ВЫПОЛЕНИЕ САМОЙ ОПЕРАЦИИ MERGE
                Integer РезультатОперацииВставкииОбновлениея = МетодВыполениеУдаленнойПроцедуры(queryprocedure, ЛОГ);

                if (РезультатОперацииВставкииОбновлениея > 0) {
                    // TODO: 25.09.2023 Результат работы
                    String РезультатСовершнойОперации = (String) queryprocedure.getOutputParameterValue("ResultatMERGE");
                    // TODO: 25.09.2023
                    Boolean РезультатЕслиЦыфры = РезультатСовершнойОперации.chars().allMatch(Character::isDigit);

                    // TODO: 22.04.2023 clear
                    if (РезультатСовершнойОперации != null && РезультатЕслиЦыфры == true) {
                        // TODO: 21.07.2023 после успешно обнолвние вставки
                        Long РезультатСовершнойОперацииФинал = Long.parseLong(РезультатСовершнойОперации);

                        // TODO: 22.04.2023 записываем новую версию после успешной вставки
                        arrayListMaxBackOperation.add(РезультатСовершнойОперацииФинал);

                        // TODO: 17.11.2023 clear
                        // queryprocedure.unwrap(ProcedureOutputsImpl.class).release();
                        queryprocedure.unwrap(ProcedureOutputs.class).release();

                        ЛОГ.log("\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"
                                + " arrayListMaxBackOperation" + arrayListMaxBackOperation.size());

                    }
                }

            }

        });
    } catch (Exception   e) {
        ЛОГ.log( "ERROR class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber()  + " e " +e.getMessage() );
        subClassWriterErros.МетодаЗаписиОшибкиВЛог(e,
                Thread.currentThread().
                        getStackTrace(),
                ЛОГ,"ErrorsLogs/ErrorJbossServletDSU1.txt");
    }
        return  arrayListMaxBackOperation;
    }
    

    private  StoredProcedureQuery    metodSelectingProcedureSQlServer(ServletContext ЛОГ, String ТаблицаPOST) {
        StoredProcedureQuery   queryprocedure=null;
        try{
        // TODO: 22.04.2023 КАКАЯ ТАБЛИЦА
        queryprocedure = методgetStoredProcedure(ЛОГ, ТаблицаPOST);
        // TODO: 22.04.2023 LOCK TIMEOUT
        queryprocedure.setFlushMode(FlushModeType.AUTO);
        
        ЛОГ.log("\n"+" class "+Thread.currentThread().getStackTrace()[2].getClassName() +"\n"+
                " metod "+Thread.currentThread().getStackTrace()[2].getMethodName() +"\n"+
                " line "+  Thread.currentThread().getStackTrace()[2].getLineNumber()+"\n"+" queryprocedure.getFlushMode()   " + queryprocedure.getFlushMode());
    } catch (Exception   e) {
        ЛОГ.log( "ERROR class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber()  + " e " +e.getMessage() );
        subClassWriterErros.МетодаЗаписиОшибкиВЛог(e,
                Thread.currentThread().
                        getStackTrace(),
                ЛОГ,"ErrorsLogs/ErrorJbossServletDSU1.txt");
    }
        return     queryprocedure;
    }

    private JsonNode metodGetDataFromSreamByte(ServletContext ЛОГ, InputStream requestInputStream) throws IOException {
        JsonNode jsonNodeParen=null;
        try{
        // TODO: 22.04.2023 Новый ПАРСИНГ ОТ JAKSON JSON
            jsonNodeParen= getGeneratorJackson.readTree(requestInputStream);

        ЛОГ.log("\n"+" class "+Thread.currentThread().getStackTrace()[2].getClassName() +"\n"+
                " metod "+Thread.currentThread().getStackTrace()[2].getMethodName() +"\n"+
                " line "+  Thread.currentThread().getStackTrace()[2].getLineNumber()+"\n"+" jsonNodeParen   " + jsonNodeParen);

    } catch (Exception   e) {
        ЛОГ.log( "ERROR class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber()  + " e " +e.getMessage() );
        subClassWriterErros.МетодаЗаписиОшибкиВЛог(e,
                Thread.currentThread().
                        getStackTrace(),
                ЛОГ,"ErrorsLogs/ErrorJbossServletDSU1.txt");
    }
        return jsonNodeParen;
    }

    // TODO: 23.04.2023  запуск ТРАНЗАКЦИИ




    // TODO: 22.04.2023  парсинг ROWs
    private StoredProcedureQuery методFillingValuesRows(@NotNull Entry<String, JsonNode> stringJsonNodeEntryTwo
            ,@NotNull  StoredProcedureQuery       queryprocedure, @NotNull String ТаблицаPOST) {
        try{
            ЛОГ.log("stringJsonNodeEntryTwo.getKey() "  + stringJsonNodeEntryTwo.getKey()
                    + " stringJsonNodeEntryTwo.getValue() " +stringJsonNodeEntryTwo.getValue()  );
            String  getKey=   stringJsonNodeEntryTwo.getKey().trim();
            String  getvalue=     stringJsonNodeEntryTwo.getValue().asText().trim();
            // TODO заполенем JSonValue ДАННЫМИ
            queryprocedure.registerStoredProcedureParameter(getKey, String.class, ParameterMode.IN)
                    .setParameter(getKey,getvalue);

            ЛОГ.log("\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" +
                    " getvalue" + getvalue + " getKey " + getKey  );
        } catch (Exception   e) {
            ЛОГ.log( "ERROR class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber()  + " e " +e.getMessage() );
            subClassWriterErros.МетодаЗаписиОшибкиВЛог(e,
                    Thread.currentThread().
                            getStackTrace(),
                    ЛОГ,"ErrorsLogs/ErrorJbossServletDSU1.txt");
        }
        return queryprocedure;
    }


    // TODO: 05.08.2023 FOR METODONLY BINARY DATA
    private void методFillingMaterialBinaryValuRows(@NotNull Entry<String, JsonNode> stringJsonNodeEntryTwo
            ,@NotNull  StoredProcedureQuery       queryprocedure, @NotNull String Столбик) {
        try{
            ЛОГ.log("stringJsonNodeEntryTwo.getKey() "  + stringJsonNodeEntryTwo.getKey()
                    + " stringJsonNodeEntryTwo.getValue() " +stringJsonNodeEntryTwo.getValue()  );
            String  getKey=   stringJsonNodeEntryTwo.getKey().trim();

            // TODO заполенем JSonValue ДАННЫМИ


                if (getKey.equalsIgnoreCase(Столбик)) {
                       byte[]  getvalue=     stringJsonNodeEntryTwo.getValue().binaryValue();
                       /* byte[]  getvalue=     null;*/
                        queryprocedure.registerStoredProcedureParameter(getKey, byte[].class, ParameterMode.IN)
                                .setParameter(getKey,getvalue);
                        ЛОГ.log("\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" +
                                " getvalue" + getvalue + " getKey " + getKey  );
                    } else {
                        String  getvalue=     stringJsonNodeEntryTwo.getValue().asText().trim();
                        queryprocedure.registerStoredProcedureParameter(getKey, String.class, ParameterMode.IN)
                                .setParameter(getKey,getvalue);
                        ЛОГ.log("\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                                " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                                " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" +
                                " getvalue" + getvalue + " getKey " + getKey  );
                    }



            ЛОГ.log("\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" );
        } catch (Exception   e) {
            ЛОГ.log( "ERROR class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber()  + " e " +e.getMessage() );
            subClassWriterErros.МетодаЗаписиОшибкиВЛог(e,
                    Thread.currentThread().
                            getStackTrace(),
                    ЛОГ,"ErrorsLogs/ErrorJbossServletDSU1.txt");
        }

    }
    // TODO: 05.08.2023 FOR METODONLY BINARY DATA
    private void методFillingChatBinaryValuRows(@NotNull Entry<String, JsonNode> stringJsonNodeEntryTwo
            ,@NotNull  StoredProcedureQuery       queryprocedure, @NotNull String Столбик) {
        try{
            ЛОГ.log("stringJsonNodeEntryTwo.getKey() "  + stringJsonNodeEntryTwo.getKey()
                    + " stringJsonNodeEntryTwo.getValue() " +stringJsonNodeEntryTwo.getValue()  );
            String  getKey=   stringJsonNodeEntryTwo.getKey().trim();

            // TODO заполенем JSonValue ДАННЫМИ


            if (getKey.equalsIgnoreCase(Столбик)) {
                byte[]  getvalue=     stringJsonNodeEntryTwo.getValue().binaryValue();
                /* byte[]  getvalue=     null;*/
                queryprocedure.registerStoredProcedureParameter(getKey, byte[].class, ParameterMode.IN)
                        .setParameter(getKey,getvalue);
                ЛОГ.log("\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                        " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                        " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" +
                        " getvalue" + getvalue + " getKey " + getKey  );
            } else {
                String  getvalue=     stringJsonNodeEntryTwo.getValue().asText().trim();
                queryprocedure.registerStoredProcedureParameter(getKey, String.class, ParameterMode.IN)
                        .setParameter(getKey,getvalue);
                ЛОГ.log("\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                        " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                        " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" +
                        " getvalue" + getvalue + " getKey " + getKey  );
            }



            ЛОГ.log("\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" );
        } catch (Exception   e) {
            ЛОГ.log( "ERROR class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber()  + " e " +e.getMessage() );
            subClassWriterErros.МетодаЗаписиОшибкиВЛог(e,
                    Thread.currentThread().
                            getStackTrace(),
                    ЛОГ,"ErrorsLogs/ErrorJbossServletDSU1.txt");
        }

    }
    
    
    
    
    


    private StoredProcedureQuery методgetStoredProcedure(ServletContext ЛОГ, String ПараметрИмяТаблицыОтАндройдаPost) {
        //TODO ЗАПОЛЕНИЯ ТАБЛИЦ И  ОТПРАВКА ЗНАЧЕНИЙ В УДАЛЕННУЮ ПРОЦЕДУРУ
        StoredProcedureQuery	 queryprocedure = null;
        try{
        switch(ПараметрИмяТаблицыОтАндройдаPost) {
            case "settings_tabels":
                queryprocedure =  session.createStoredProcedureQuery("ProcedureExistsMERGEsettings_tabels#2");//TODO ProcedureExistsMERGE_fio
                break;
            case "fio":
                queryprocedure =  session.createStoredProcedureQuery( "ProcedureExistsMERGEfio#1");//TODO ProcedureExistsMERGE_fio
                break;
            case "data_tabels":
                queryprocedure =  session.createStoredProcedureQuery( "ProcedureExistsMERGEdata_tabels#3");//TODO ProcedureExistsMERGE_fio
                break;
            case "tabel":
                queryprocedure =  session.createStoredProcedureQuery( "ProcedureExistsMERGEtabel#4");//TODO ProcedureExistsMERGE_fio
                break;
            case "organization":
                queryprocedure =  session.createStoredProcedureQuery( "ProcedureExistsMERGEorganization#5");//TODO ProcedureExistsMERGE_fio
                break;
            case "depatment":
                queryprocedure =  session.createStoredProcedureQuery( "ProcedureExistsMERGEdepatment#6");//TODO ProcedureExistsMERGE_fio
                break;
            case "notifications":
                queryprocedure =  session.createStoredProcedureQuery( "ProcedureExistsMERGEnotifications#7");//TODO ProcedureExistsMERGE_fio
                break;
            case "data_notification":
                queryprocedure =  session.createStoredProcedureQuery( "ProcedureExistsMERGEdata_notification#8");//TODO ProcedureExistsMERGE_fio
                break;
            case "chats":
                queryprocedure =  session.createStoredProcedureQuery( "ProcedureExistsMERGEchats#9");//TODO ProcedureExistsMERGE_fio
                break;
            case "data_chat":
                queryprocedure =  session.createStoredProcedureQuery( "ProcedureExistsMERGEdata_chat#10");//TODO ProcedureExistsMERGE_fio
                break;
            case	"templates":
                queryprocedure =  session.createStoredProcedureQuery( "ProcedureExistsMERGEtemplates#11");//TODO ProcedureExistsMERGE_fio
                break;
            case	"fio_template":
                queryprocedure =  session.createStoredProcedureQuery( "ProcedureExistsMERGEfio_template#12");//TODO ProcedureExistsMERGE_fio
                break;
            case	"region":
                queryprocedure =  session.createStoredProcedureQuery( "ProcedureExistsMERGEregion#13");//TODO ProcedureExistsMERGE_fio
                break;
            case	"cfo":
                queryprocedure =  session.createStoredProcedureQuery( "ProcedureExistsMERGEcfo#14");//TODO ProcedureExistsMERGE_fio
                break;
            case	"get_materials_data":
                queryprocedure =  session.createStoredProcedureQuery( "ProcedureExistsMERGEget_materials_data#17");//TODO ProcedureExistsMERGE_fio
                break;
            case	"order_tc":
                queryprocedure =  session.createStoredProcedureQuery( "ProcedureExistsMERGEorder_tc#31");//TODO ProcedureExistsMERGE_fio
                break;
            case	"errordsu1":
                queryprocedure =  session.createStoredProcedureQuery( "ProcedureExistsMERGEerrordsu1#37");//TODO ProcedureExistsMERGE_fio
                break;
            case	"materials_databinary":
                queryprocedure =  session.createStoredProcedureQuery( "ProcedureMaterials_databinary#38");//TODO ProcedureMaterials_databinary#38
                break;
            default:
                ЛОГ.log("\n"+" class "+Thread.currentThread().getStackTrace()[2].getClassName() +"\n"+
                        " metod "+Thread.currentThread().getStackTrace()[2].getMethodName() +"\n"+
                        " line "+  Thread.currentThread().getStackTrace()[2].getLineNumber()+
                        " ПараметрИмяТаблицыОтАндройдаPost " + ПараметрИмяТаблицыОтАндройдаPost);
                break;
            ///TODO конец всех таблиц
        }
        ЛОГ.log("\n"+" class "+Thread.currentThread().getStackTrace()[2].getClassName() +"\n"+
                " metod "+Thread.currentThread().getStackTrace()[2].getMethodName() +"\n"+
                " line "+  Thread.currentThread().getStackTrace()[2].getLineNumber()+
                " ПараметрИмяТаблицыОтАндройдаPost " + ПараметрИмяТаблицыОтАндройдаPost);
    } catch (Exception e) {
        subClassWriterErros.
                МетодаЗаписиОшибкиВЛог(e,
                        Thread.currentThread().
                                getStackTrace(),
                        ЛОГ,"ErrorsLogs/ErrorJbossServletDSU1.txt");
    }
        return queryprocedure;
    }




    // TODO: 14.03.2023  Метод Самого Выполениея Операции POST EXE
    private Integer МетодВыполениеУдаленнойПроцедуры(@NotNull  StoredProcedureQuery queryprocedure,
                                                     @NotNull  ServletContext ЛОГ) {
        Integer КоличестоУспешныхОперацийНаСервере=0;
        try {
            ЛОГ.log(" queryprocedure " +queryprocedure );
            ////todo выполения .EXE
            queryprocedure.execute();
            // TODO: 14.03.2023  Подсчитиваем КОличество спрешных Операций 
        КоличестоУспешныхОперацийНаСервере=   queryprocedure.getUpdateCount();
            ЛОГ.log("\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n"
                    + " queryprocedure "+queryprocedure  + " КоличестоУспешныхОперацийНаСервере " +КоличестоУспешныхОперацийНаСервере);
        } catch (Exception   e) {
            ЛОГ.log( "ERROR class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber()  + " e " +e.getMessage() );
            subClassWriterErros.
                    МетодаЗаписиОшибкиВЛог(e,
                            Thread.currentThread().
                                    getStackTrace(),
                            ЛОГ,"ErrorsLogs/ErrorJbossServletDSU1.txt");
        }
        return  КоличестоУспешныхОперацийНаСервере;
        //TODO
    }


}


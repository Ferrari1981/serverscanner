package com.dsy.dsu.CommitingPrices.Model.NestedDataGetAll;

import android.content.Context;
import android.util.Log;

import com.dsy.dsu.Errors.Class_Generation_Errors;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


// TODO: 09.01.2024  данные класс оплучаеем все дочерниуе едементы для ArrayNode от Согласование Цены
public class GetArrayNodeForNestedChildern implements  InForChilderArrayJSon  {
   private Context context;
    private JsonNode jsonNodeNested;



    public GetArrayNodeForNestedChildern(Context context,@NotNull JsonNode jsonNodeNested) {
        this.context = context;
        this.jsonNodeNested = jsonNodeNested;
    }

    @Override
    public ArrayNode arrayNodeNested() {
        ArrayNode arrayNode=null;
        try{
            Iterator<String> iterator = jsonNodeNested.fieldNames();
            while (iterator.hasNext()) {
                String ВерхнийКлюч=  iterator.next();
                arrayNode = (ArrayNode) jsonNodeNested.get(ВерхнийКлюч);
                // TODO: 23.01.2024
                break;
            }
            Log.d(this.getClass().getName(),"\n"
                    + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber()+
                    " arrayNode.size() " + arrayNode.size());
            //iterator.forEachRemaining(e -> keys.add(e));
          //  ObjectNode objectNodeRow = jsonNodeNested.deepCopy();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                    " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(), this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[2].getMethodName(), Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
        return arrayNode;
    }
}

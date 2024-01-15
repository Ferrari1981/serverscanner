package com.dsy.dsu.PaysCommings.Model.BI_RecyreView;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;

import com.dsy.dsu.Errors.Class_Generation_Errors;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.OutputStream;

//TODO класс работает когда файл от 1 с пришел
public  class  SuccessGet1CpayCommitProccesing{
    
    Context context;
    
    
    
    protected String ТекущийФорматДокумента=null;

    public SuccessGet1CpayCommitProccesing(Context context) {
        this.context = context;
    }

    String filesuccessDownDisk1CpayCommitProccesing(@NotNull byte[] getFileNewOt1cPayCommit, @NotNull TextView textvalueRowpaycommit){
        String NameNewDownloadFileOt1c=null;
        try{
            if (getFileNewOt1cPayCommit!=null) {
                if (getFileNewOt1cPayCommit.length > 0) {

                    // TODO: 03.11.2023 Tag
                    Bundle bundleChildreRow = (Bundle) textvalueRowpaycommit.getTag();
                    String    НазваниеТекущегОт1С = bundleChildreRow.getString("ВinNameFile", "");
                    String РасширенияФайлаОт1С = bundleChildreRow.getString("expansion", "");


                    if (! НазваниеТекущегОт1С.isEmpty() &&
                            ! РасширенияФайлаОт1С.isEmpty()) {
                        String patchFileName = "SousAvtoFile/AppCommitPays1C/Photos";
                        NameNewDownloadFileOt1c= НазваниеТекущегОт1С.toString() + "." + РасширенияФайлаОт1С;

                        File fileNewPhotoDirectory = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                                + File.separator + patchFileName);

                        File fileNewPhotoFromCameraX = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                                + File.separator + patchFileName + File.separator + NameNewDownloadFileOt1c);

                        if (fileNewPhotoDirectory.isDirectory() && !fileNewPhotoFromCameraX.exists()) {
                            Uri address = FileProvider.getUriForFile(context, "com.dsy.dsu.provider", fileNewPhotoFromCameraX);
                            ContentResolver contentResolver = context.getContentResolver();
                            OutputStream out = contentResolver.openOutputStream(address);
                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(out, 2048);//4096//2048
                            bufferedOutputStream.write(getFileNewOt1cPayCommit);
                            // TODO: 03.10.2023
                            bufferedOutputStream.flush();
                            bufferedOutputStream.close();
                            out.flush();
                            out.close();
                        }

                        // TODO: 14.11.2023
                        if ( !fileNewPhotoFromCameraX.exists()) {
                            NameNewDownloadFileOt1c=null;
                        }
                    }



                    // TODO: 26.12.2022  конец основгого кода
                    Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                            " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                            " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" + "getFileNewOt1cPayCommit" +
                            getFileNewOt1cPayCommit + "  textvalueRowpaycommit" + textvalueRowpaycommit);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(context.getClass().getName(),
                    "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                            " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName().toString(), Thread.currentThread().getStackTrace()[2].getMethodName().toString(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
        return  NameNewDownloadFileOt1c;
    }

    void UpFileSuccessOt1cPayCommit(@NonNull String НазваниеТекущегОт1С){
        try{
            String patchFileName = "SousAvtoFile/AppCommitPays1C/Photos";
            File UpFileOt1cPay = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                    + File.separator + patchFileName + File.separator + НазваниеТекущегОт1С);
            // TODO: 03.11.2023 Tag
            if (UpFileOt1cPay.exists()) {

                Uri address = FileProvider.getUriForFile(context, "com.dsy.dsu.provider", UpFileOt1cPay);

                Intent intent = new Intent(Intent.ACTION_VIEW);
                // intent.setDataAndType(address, "text/*");
                intent.setDataAndType(address, ТекущийФорматДокумента);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
               context. startActivity(intent); // Crashes on this line





                //  File outputFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), НазваниеТекущегОт1С);
                   /* Uri uri = Uri.fromFile(UpFileOt1cPay);
                    Intent intentOpenFile = new Intent(Intent.ACTION_VIEW);
                    intentOpenFile.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intentOpenFile.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    //  intentOpenFile.setType("application/pdf");
                    // intentOpenFile.setDataAndType(uri, "application/vnd.ms-excel");
                    //intentOpenFile.setType( ТекущийФорматДокумента);
                    intentOpenFile.setDataAndType( uri,ТекущийФорматДокумента);
                    intentOpenFile.putExtra(Intent.EXTRA_STREAM, uri);
                    intentOpenFile.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                    intentOpenFile.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(intentOpenFile);*/
            }

            // TODO: 26.12.2022  конец основгого кода
            Log.d(this.getClass().getName(), "\n" + " class " + Thread.currentThread().getStackTrace()[2].getClassName() + "\n" +
                    " metod " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n" +
                    " line " + Thread.currentThread().getStackTrace()[2].getLineNumber() + "\n" +
                    " НазваниеТекущегОт1С " + НазваниеТекущегОт1С);

        } catch (Exception e) {
            e.printStackTrace();
            Log.e(context.getClass().getName(),
                    "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() +
                            " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
            new Class_Generation_Errors(context).МетодЗаписиВЖурналНовойОшибки(e.toString(),
                    this.getClass().getName().toString(), Thread.currentThread().getStackTrace()[2].getMethodName().toString(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }



//TODO  END    class  SuccessGet1CpayCommitProccesing{
}//TODO  END    class  SuccessGet1CpayCommitProccesing{
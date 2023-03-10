package com.sous.server.VIEW;

import android.Manifest;
import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.loader.content.AsyncTaskLoader;
import androidx.loader.content.Loader;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.textview.MaterialTextView;
import com.sous.server.CONTROL.BroadcastReceiverWorkManagerScannersServer;
import com.sous.server.CONTROL.ServiceControllerServer;
import com.sous.server.MODEL.SubClassErrors;
import com.sous.server.R;


import org.jetbrains.annotations.NotNull;

import java.util.Random;


public class MainActivityNewServerScanner extends AppCompatActivity  {
    private ServiceControllerServer.LocalBinderСканнер binderСканнер;
    private ServiceConnection connectionСканирование;
    private String TAG;
    private Handler handler;
    private NavigationBarView bottomNavigationView;
    private BottomNavigationItemView bottomNavigationItemViewВыход;
    private BottomNavigationItemView bottomNavigationItemViewИстория;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private Fragment fragment;
    private LinearLayout linearLayou;
    private  Long version;
    private MaterialTextView materialTextViewToolBar;
    private  String КлючДляServerFibaseOneSingnal="220d6edf-2b29-453e-97a8-d2aefe4a9eb0";
    private    AsyncTaskLoader asyncTaskLoader;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main_newscanner);
            TAG = getClass().getName().toString();
            getSupportActionBar().hide(); ///скрывать тул бар
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD
                    | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON
                    | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
            // TODO: 08.12.2022
            bottomNavigationView = (NavigationBarView) findViewById(R.id.BottomNavigationViewScanner);
            bottomNavigationView.setLabelVisibilityMode(NavigationBarView.LABEL_VISIBILITY_UNLABELED);
            materialTextViewToolBar=( MaterialTextView)  findViewById(R.id.text_scanner_work);
            // TODO: 05.12.2022 строчлочки
            bottomNavigationItemViewВыход = bottomNavigationView.findViewById(R.id.id_lback);
            bottomNavigationItemViewИстория = bottomNavigationView.findViewById(R.id.id_scanner_history);
            bottomNavigationItemViewВыход.setItemRippleColor(ColorStateList.valueOf(Color.RED));
            bottomNavigationItemViewИстория.setItemRippleColor(ColorStateList.valueOf(Color.RED));
            linearLayou = (LinearLayout) findViewById(R.id.activity_main_newscanner);
            Log.w(getApplicationContext().getClass().getName(), " MainActivityNewServerScanner onCreate  ");
            fragmentManager = getSupportFragmentManager();

            bottomNavigationView.setVisibility(View.INVISIBLE);
            materialTextViewToolBar.setText("");
            materialTextViewToolBar.setVisibility(View.INVISIBLE);
            Log.w(getApplicationContext().getClass().getName(), " MainActivityNewServerScanner onCreate  ");
            PackageInfo pInfo =getApplicationContext().getPackageManager().getPackageInfo(getApplicationContext().getPackageName(), 0);
            version = pInfo.getLongVersionCode();
            // TODO: 07.02.2023 дополнительное разрещения blutoon
            МетодРАзрешенияBlurtooTКлиент();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" +
                    Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            ContentValues valuesЗаписываемОшибки = new ContentValues();
            valuesЗаписываемОшибки.put("Error", e.toString().toLowerCase());
            valuesЗаписываемОшибки.put("Klass", this.getClass().getName());
            valuesЗаписываемОшибки.put("Metod", Thread.currentThread().getStackTrace()[2].getMethodName());
            valuesЗаписываемОшибки.put("LineError", Thread.currentThread().getStackTrace()[2].getLineNumber());
            final Object ТекущаяВерсияПрограммы = version;
            Integer ЛокальнаяВерсияПОСравнение = Integer.parseInt(ТекущаяВерсияПрограммы.toString());
            valuesЗаписываемОшибки.put("whose_error", ЛокальнаяВерсияПОСравнение);
            new SubClassErrors(getApplicationContext()).МетодЗаписиОшибок(valuesЗаписываемОшибки);
        }

    }
    @SuppressLint("RestrictedApi")
    @Override
    protected void onStart() {
        super.onStart();
        try {
            ОтветныйHendlerОтСлужбы();
            МетодПервыйЗапускПервогоФрагментаBoot();
            МетодСобыытиеКнопокСканирования(new Intent("activity"));
            МетодЗапускаетBroadcastReceiverWorkManagerScannersServer();
            asyncTaskLoader=new AsyncTaskLoader(getApplicationContext()) {
                @Nullable
                @Override
                public Object loadInBackground() {
                    try {
                    МетодБиндингаСканирование();
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                            + Thread.currentThread().getStackTrace()[2].getLineNumber());
                    ContentValues valuesЗаписываемОшибки = new ContentValues();
                    valuesЗаписываемОшибки.put("Error", e.toString().toLowerCase());
                    valuesЗаписываемОшибки.put("Klass", this.getClass().getName());
                    valuesЗаписываемОшибки.put("Metod", Thread.currentThread().getStackTrace()[2].getMethodName());
                    valuesЗаписываемОшибки.put("LineError", Thread.currentThread().getStackTrace()[2].getLineNumber());
                    final Object ТекущаяВерсияПрограммы = version;
                    Integer ЛокальнаяВерсияПОСравнение = Integer.parseInt(ТекущаяВерсияПрограммы.toString());
                    valuesЗаписываемОшибки.put("whose_error", ЛокальнаяВерсияПОСравнение);
                    new SubClassErrors(getApplicationContext()).МетодЗаписиОшибок(valuesЗаписываемОшибки);
                }
                    return null;
                }
            };

            asyncTaskLoader.startLoading();
            asyncTaskLoader.forceLoad();
            asyncTaskLoader.registerListener(new Random().nextInt(), new Loader.OnLoadCompleteListener() {
                @Override
                public void onLoadComplete(@NonNull Loader loader, @Nullable Object data) {
                    Log.d(this.getClass().getName(), " binderСканнер " + binderСканнер);
                }
            });
            Log.d(this.getClass().getName(), " binderСканнер " + binderСканнер);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            ContentValues valuesЗаписываемОшибки = new ContentValues();
            valuesЗаписываемОшибки.put("Error", e.toString().toLowerCase());
            valuesЗаписываемОшибки.put("Klass", this.getClass().getName());
            valuesЗаписываемОшибки.put("Metod", Thread.currentThread().getStackTrace()[2].getMethodName());
            valuesЗаписываемОшибки.put("LineError", Thread.currentThread().getStackTrace()[2].getLineNumber());
            final Object ТекущаяВерсияПрограммы = version;
            Integer ЛокальнаяВерсияПОСравнение = Integer.parseInt(ТекущаяВерсияПрограммы.toString());
            valuesЗаписываемОшибки.put("whose_error", ЛокальнаяВерсияПОСравнение);
            new SubClassErrors(getApplicationContext()).МетодЗаписиОшибок(valuesЗаписываемОшибки);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        try {

        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            ContentValues valuesЗаписываемОшибки = new ContentValues();
            valuesЗаписываемОшибки.put("Error", e.toString().toLowerCase());
            valuesЗаписываемОшибки.put("Klass", this.getClass().getName());
            valuesЗаписываемОшибки.put("Metod", Thread.currentThread().getStackTrace()[2].getMethodName());
            valuesЗаписываемОшибки.put("LineError", Thread.currentThread().getStackTrace()[2].getLineNumber());
            final Object ТекущаяВерсияПрограммы = version;
            Integer ЛокальнаяВерсияПОСравнение = Integer.parseInt(ТекущаяВерсияПрограммы.toString());
            valuesЗаписываемОшибки.put("whose_error", ЛокальнаяВерсияПОСравнение);
            new SubClassErrors(getApplicationContext()).МетодЗаписиОшибок(valuesЗаписываемОшибки);
        }

    }

    private void МетодПервыйЗапускПервогоФрагментаBoot() {
        // TODO: 24.01.2023 методы для блютусаа
        try{
        fragment=      new FragmentBootServer();
        // TODO: 07.02.2023 запус самого СЕРВЕРА СКАНРРОВНИЕ..
        МетодЗапускКлиентаИлиСервера(fragment);//todo Запускам клиента или сервер фрагмент
    } catch (Exception e) {
        e.printStackTrace();
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                + Thread.currentThread().getStackTrace()[2].getLineNumber());
        ContentValues valuesЗаписываемОшибки = new ContentValues();
        valuesЗаписываемОшибки.put("Error", e.toString().toLowerCase());
        valuesЗаписываемОшибки.put("Klass", this.getClass().getName());
        valuesЗаписываемОшибки.put("Metod", Thread.currentThread().getStackTrace()[2].getMethodName());
        valuesЗаписываемОшибки.put("LineError", Thread.currentThread().getStackTrace()[2].getLineNumber());
        final Object ТекущаяВерсияПрограммы = version;
        Integer ЛокальнаяВерсияПОСравнение = Integer.parseInt(ТекущаяВерсияПрограммы.toString());
        valuesЗаписываемОшибки.put("whose_error", ЛокальнаяВерсияПОСравнение);
        new SubClassErrors(getApplicationContext()).МетодЗаписиОшибок(valuesЗаписываемОшибки);
    }
    }

    private void МетодЗапускаВторогоФрагментаСканирование() {
        try {
            // TODO: 24.01.2023  переходят после получение binder
            bottomNavigationView.setVisibility(View.VISIBLE);
            materialTextViewToolBar.setVisibility(View.VISIBLE);
            materialTextViewToolBar.setText("Сервер");
            // TODO: 25.01.2023  подключение после получение BINDER
            // TODO: 07.02.2023  первый запуск сервер  ВТОРОЙ
            if (fragment!=null) {
                fragment.onDetach();
                fragmentTransaction.remove(fragment);
            }
        fragment=      new FragmentServerUser();
        МетодЗапускКлиентаИлиСервера(fragment);//todo Запускам клиента или сервер фрагмент
    } catch (Exception e) {
        e.printStackTrace();
        Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                + Thread.currentThread().getStackTrace()[2].getLineNumber());
        ContentValues valuesЗаписываемОшибки = new ContentValues();
        valuesЗаписываемОшибки.put("Error", e.toString().toLowerCase());
        valuesЗаписываемОшибки.put("Klass", this.getClass().getName());
        valuesЗаписываемОшибки.put("Metod", Thread.currentThread().getStackTrace()[2].getMethodName());
        valuesЗаписываемОшибки.put("LineError", Thread.currentThread().getStackTrace()[2].getLineNumber());
        final Object ТекущаяВерсияПрограммы = version;
        Integer ЛокальнаяВерсияПОСравнение = Integer.parseInt(ТекущаяВерсияПрограммы.toString());
        valuesЗаписываемОшибки.put("whose_error", ЛокальнаяВерсияПОСравнение);
        new SubClassErrors(getApplicationContext()).МетодЗаписиОшибок(valuesЗаписываемОшибки);
    }
    }
    private void МетодЗапускаемПолучениеServerКлючаOndeSignalFirebase(@NonNull String КлючДляServerFibaseOneSingnal) {
        try {
            binderСканнер.getService().МетодПолучениеServerСканеарКлюча_OndeSignal(КлючДляServerFibaseOneSingnal);
            Log.i(this.getClass().getName(), "   создание МетодЗаполенияФрагмента1 mediatorLiveDataGATT "+КлючДляServerFibaseOneSingnal );
            //TODO
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            ContentValues valuesЗаписываемОшибки = new ContentValues();
            valuesЗаписываемОшибки.put("Error", e.toString().toLowerCase());
            valuesЗаписываемОшибки.put("Klass", this.getClass().getName());
            valuesЗаписываемОшибки.put("Metod", Thread.currentThread().getStackTrace()[2].getMethodName());
            valuesЗаписываемОшибки.put("LineError", Thread.currentThread().getStackTrace()[2].getLineNumber());
            final Object ТекущаяВерсияПрограммы = version;
            Integer ЛокальнаяВерсияПОСравнение = Integer.parseInt(ТекущаяВерсияПрограммы.toString());
            valuesЗаписываемОшибки.put("whose_error", ЛокальнаяВерсияПОСравнение);
            new SubClassErrors(getApplicationContext()).МетодЗаписиОшибок(valuesЗаписываемОшибки);
        }
    }
    public void МетодСобыытиеКнопокСканирования(@NotNull Intent intent) {
        try {
            bottomNavigationItemViewВыход.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(this.getClass().getName(), " bottomNavigationView " + bottomNavigationView);
                    if (intent.getAction().equalsIgnoreCase("fragment")) {
                        finishAndRemoveTask();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            ContentValues valuesЗаписываемОшибки = new ContentValues();
            valuesЗаписываемОшибки.put("Error", e.toString().toLowerCase());
            valuesЗаписываемОшибки.put("Klass", this.getClass().getName());
            valuesЗаписываемОшибки.put("Metod", Thread.currentThread().getStackTrace()[2].getMethodName());
            valuesЗаписываемОшибки.put("LineError", Thread.currentThread().getStackTrace()[2].getLineNumber());
            final Object ТекущаяВерсияПрограммы = version;
            Integer ЛокальнаяВерсияПОСравнение = Integer.parseInt(ТекущаяВерсияПрограммы.toString());
            valuesЗаписываемОшибки.put("whose_error", ЛокальнаяВерсияПОСравнение);
            new SubClassErrors(getApplicationContext()).МетодЗаписиОшибок(valuesЗаписываемОшибки);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    // TODO: 05.12.2022  запуск клиента
    @SuppressLint("SuspiciousIndentation")
    protected void МетодЗапускКлиентаИлиСервера(@NonNull Fragment fragment) {
        try {
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.framelauoutScanner, fragment);//.layout.activity_for_fragemtb_history_tasks
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();
            if (binderСканнер!=null) {
                Bundle bundle=new Bundle();
                bundle.putBinder("binderСканнер",binderСканнер);
                fragment.setArguments(bundle);
            }
            fragmentTransaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            fragmentTransaction.show(fragment);
                Log.d(this.getClass().getName(), " fragment " + fragment+ " binderСканнер " +binderСканнер);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            ContentValues valuesЗаписываемОшибки = new ContentValues();
            valuesЗаписываемОшибки.put("Error", e.toString().toLowerCase());
            valuesЗаписываемОшибки.put("Klass", this.getClass().getName());
            valuesЗаписываемОшибки.put("Metod", Thread.currentThread().getStackTrace()[2].getMethodName());
            valuesЗаписываемОшибки.put("LineError", Thread.currentThread().getStackTrace()[2].getLineNumber());
            final Object ТекущаяВерсияПрограммы = version;
            Integer ЛокальнаяВерсияПОСравнение = Integer.parseInt(ТекущаяВерсияПрограммы.toString());
            valuesЗаписываемОшибки.put("whose_error", ЛокальнаяВерсияПОСравнение);
            new SubClassErrors(getApplicationContext()).МетодЗаписиОшибок(valuesЗаписываемОшибки);
        }
    }

    private void МетодРАзрешенияBlurtooTКлиент() {
        try{

            String[] PERMISSIONS_STORAGE = {
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_LOCATION_EXTRA_COMMANDS,
                    Manifest.permission.BLUETOOTH_SCAN,
                    Manifest.permission.BLUETOOTH_CONNECT,
                    Manifest.permission.BLUETOOTH_PRIVILEGED,
                    Manifest.permission.BLUETOOTH_ADVERTISE,
                    Manifest.permission.BLUETOOTH_ADMIN,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE
            };
            String[] PERMISSIONS_LOCATION = {
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_LOCATION_EXTRA_COMMANDS,
                    Manifest.permission.BLUETOOTH_SCAN,
                    Manifest.permission.BLUETOOTH_CONNECT,
                    Manifest.permission.BLUETOOTH_PRIVILEGED,
                    Manifest.permission.BLUETOOTH_ADVERTISE,
                    Manifest.permission.BLUETOOTH_ADMIN,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE
            };
            int permission1 = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
            int permission2 = ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_SCAN);
            if (permission1 != PackageManager.PERMISSION_GRANTED) {
                // We don't have permission so prompt the user
                ActivityCompat.requestPermissions(
                        this,
                        PERMISSIONS_STORAGE,
                        1
                );
            } else if (permission2 != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(
                        this,
                        PERMISSIONS_LOCATION,
                        1
                );
            }
            String provider = "com.sous.server.providerserver";
            Uri uri = Uri.parse("content://"+provider+"/" +"scannerserversuccess" + "");
            ContentResolver resolver = this.getContentResolver();
            this.grantUriPermission(provider, uri, Intent.FLAG_GRANT_WRITE_URI_PERMISSION | Intent.FLAG_GRANT_READ_URI_PERMISSION);

        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            ContentValues valuesЗаписываемОшибки = new ContentValues();
            valuesЗаписываемОшибки.put("Error", e.toString().toLowerCase());
            valuesЗаписываемОшибки.put("Klass", this.getClass().getName());
            valuesЗаписываемОшибки.put("Metod", Thread.currentThread().getStackTrace()[2].getMethodName());
            valuesЗаписываемОшибки.put("LineError", Thread.currentThread().getStackTrace()[2].getLineNumber());
            final Object ТекущаяВерсияПрограммы = version;
            Integer ЛокальнаяВерсияПОСравнение = Integer.parseInt(ТекущаяВерсияПрограммы.toString());
            valuesЗаписываемОшибки.put("whose_error", ЛокальнаяВерсияПОСравнение);
            new SubClassErrors(getApplicationContext()).МетодЗаписиОшибок(valuesЗаписываемОшибки);
        }
    }



    private void ОтветныйHendlerОтСлужбы() {
        try {
            handler = new Handler(getMainLooper(), new Handler.Callback() {
                @Override
                public boolean handleMessage(@NonNull Message msg) {
                    Log.d(TAG, "onCreate: msg " + msg);
                    return true;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            ContentValues valuesЗаписываемОшибки = new ContentValues();
            valuesЗаписываемОшибки.put("Error", e.toString().toLowerCase());
            valuesЗаписываемОшибки.put("Klass", this.getClass().getName());
            valuesЗаписываемОшибки.put("Metod", Thread.currentThread().getStackTrace()[2].getMethodName());
            valuesЗаписываемОшибки.put("LineError", Thread.currentThread().getStackTrace()[2].getLineNumber());
            final Object ТекущаяВерсияПрограммы = version;
            Integer ЛокальнаяВерсияПОСравнение = Integer.parseInt(ТекущаяВерсияПрограммы.toString());
            valuesЗаписываемОшибки.put("whose_error", ЛокальнаяВерсияПОСравнение);
            new SubClassErrors(getApplicationContext()).МетодЗаписиОшибок(valuesЗаписываемОшибки);
        }
    }
    // TODO: 29.11.2022 служба сканирования
    private    void   МетодБиндингаСканирование(){
        try {
                    connectionСканирование = new ServiceConnection() {
                        @Override
                        public void onServiceConnected(ComponentName name, IBinder service) {
                            try{
                                binderСканнер = ( ServiceControllerServer.LocalBinderСканнер) service;
                                if(binderСканнер.isBinderAlive()){
                                    Log.i(getApplicationContext().getClass().getName(), "  onServiceConnected  onServiceConnected  МетодБиндингаСканирование"
                                            + binderСканнер.isBinderAlive());
                                    МетодЗапускаемПолучениеServerКлючаOndeSignalFirebase(КлючДляServerFibaseOneSingnal);
                                    binderСканнер.linkToDeath(new IBinder.DeathRecipient() {
                                        @Override
                                        public void binderDied() {
                                            Log.i(getApplicationContext().getClass().getName(), "   binderDied  onServiceConnected  МетодБиндингаСканирование"
                                                    + binderСканнер.isBinderAlive());
                                            МетодЗапускаВторогоФрагментаСканирование();
                                        }
                                    });
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                                        + Thread.currentThread().getStackTrace()[2].getLineNumber());
                                ContentValues valuesЗаписываемОшибки=new ContentValues();
                                valuesЗаписываемОшибки.put("НазваниеОбрабоатываемойТаблицы","ErrorDSU1");
                                valuesЗаписываемОшибки.put("Error",e.toString().toLowerCase());
                                valuesЗаписываемОшибки.put("Klass",this.getClass().getName());
                                valuesЗаписываемОшибки.put("Metod",Thread.currentThread().getStackTrace()[2].getMethodName());
                                valuesЗаписываемОшибки.put("LineError",   Thread.currentThread().getStackTrace()[2].getLineNumber());
                                final Object ТекущаяВерсияПрограммы = version;
                                Integer   ЛокальнаяВерсияПОСравнение = Integer.parseInt(ТекущаяВерсияПрограммы.toString());
                                valuesЗаписываемОшибки.put("whose_error",ЛокальнаяВерсияПОСравнение);
                                new SubClassErrors(getApplicationContext()).МетодЗаписиОшибок(valuesЗаписываемОшибки);
                            }

                        }
                        @Override
                        public void onServiceDisconnected(ComponentName name) {
                            try{
                                Log.i(getApplicationContext().getClass().getName(), "    onServiceDisconnected  binderСканнер.isBinderAlive()" + binderСканнер.isBinderAlive());
                                binderСканнер =null;
                            } catch (Exception e) {
                                e.printStackTrace();
                                Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :"
                                        + Thread.currentThread().getStackTrace()[2].getMethodName() +
                                        " Линия  :" + Thread.currentThread().getStackTrace()[2].getLineNumber());
                            }
                        }
                    };
                    Intent intentБиндингсСлужбойСканирования =
                            new Intent(getApplicationContext(), ServiceControllerServer.class);
                    bindService(intentБиндингсСлужбойСканирования, connectionСканирование, Context.BIND_AUTO_CREATE);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            ContentValues valuesЗаписываемОшибки=new ContentValues();
            valuesЗаписываемОшибки.put("НазваниеОбрабоатываемойТаблицы","ErrorDSU1");
            valuesЗаписываемОшибки.put("Error",e.toString().toLowerCase());
            valuesЗаписываемОшибки.put("Klass",this.getClass().getName());
            valuesЗаписываемОшибки.put("Metod",Thread.currentThread().getStackTrace()[2].getMethodName());
            valuesЗаписываемОшибки.put("LineError",   Thread.currentThread().getStackTrace()[2].getLineNumber());
            final Object ТекущаяВерсияПрограммы = version;
            Integer   ЛокальнаяВерсияПОСравнение = Integer.parseInt(ТекущаяВерсияПрограммы.toString());
            valuesЗаписываемОшибки.put("whose_error",ЛокальнаяВерсияПОСравнение);
            new SubClassErrors(getApplicationContext()).МетодЗаписиОшибок(valuesЗаписываемОшибки);
        }

    }


    public void МетодЗапускаетBroadcastReceiverWorkManagerScannersServer() {
        try {
            BroadcastReceiverWorkManagerScannersServer broadcastReceiverWorkManagerScannersServer= new BroadcastReceiverWorkManagerScannersServer();
            Intent ИнтретПоЗапускуПовторноШироковещательногоСинхрониазции =
                    new Intent(getApplicationContext()
                    , BroadcastReceiverWorkManagerScannersServer.class);
            ИнтретПоЗапускуПовторноШироковещательногоСинхрониазции.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            ИнтретПоЗапускуПовторноШироковещательногоСинхрониазции.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
            getApplicationContext().sendBroadcast(ИнтретПоЗапускуПовторноШироковещательногоСинхрониазции);
            Log.d(getApplicationContext().getClass().getName(), " ПРОШЕЛ ЗАПУСК     " +
                    " BroadcastReceiver_Sous_Asyns_Glassfish  broadcastReceiver_sous_asyns_glassfish= new BroadcastReceiver_Sous_Asyns_Glassfish(); " );
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getName(), "Ошибка " + e + " Метод :" + Thread.currentThread().getStackTrace()[2].getMethodName() + " Линия  :"
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
            ContentValues valuesЗаписываемОшибки=new ContentValues();
            valuesЗаписываемОшибки.put("НазваниеОбрабоатываемойТаблицы","ErrorDSU1");
            valuesЗаписываемОшибки.put("Error",e.toString().toLowerCase());
            valuesЗаписываемОшибки.put("Klass",this.getClass().getName());
            valuesЗаписываемОшибки.put("Metod",Thread.currentThread().getStackTrace()[2].getMethodName());
            valuesЗаписываемОшибки.put("LineError",   Thread.currentThread().getStackTrace()[2].getLineNumber());
            final Object ТекущаяВерсияПрограммы = version;
            Integer   ЛокальнаяВерсияПОСравнение = Integer.parseInt(ТекущаяВерсияПрограммы.toString());
            valuesЗаписываемОшибки.put("whose_error",ЛокальнаяВерсияПОСравнение);
            new SubClassErrors(getApplicationContext()).МетодЗаписиОшибок(valuesЗаписываемОшибки);
        }
    }
}
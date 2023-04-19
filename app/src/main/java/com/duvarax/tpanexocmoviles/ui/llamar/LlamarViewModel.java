package com.duvarax.tpanexocmoviles.ui.llamar;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LlamarViewModel extends AndroidViewModel {
    private MutableLiveData<String> llamar;
    private Context context;

    public LlamarViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }


    public LiveData<String> getLlamar(){
        if(llamar == null){
            llamar = new MutableLiveData<>();
        }
        return llamar;
    }

    public void intentarLlamada(String numero){
        if(numero.length() > 0){
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + numero));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions((Activity) context, new String[]{android.Manifest.permission.CALL_PHONE}, 1);
                return;
            }
            context.startActivity(intent);
            llamar.setValue(numero);
        }else{
            Toast.makeText(context, "Numero invalido", Toast.LENGTH_SHORT).show();
        }
    }


}
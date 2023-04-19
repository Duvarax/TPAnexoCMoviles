package com.duvarax.tpanexocmoviles.ui.llamar;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
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

    public void iniciarLlamada(String numero){
        if(numero.length() > 0){
            llamar.setValue(numero);
        }else{
            Toast.makeText(context, "Numero invalido", Toast.LENGTH_SHORT).show();
        }
    }

}
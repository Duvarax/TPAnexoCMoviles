package com.duvarax.tpanexocmoviles.ui.mercados;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.duvarax.tpanexocmoviles.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MercadoViewModel extends AndroidViewModel {
    private MutableLiveData<miMapa> mapa;

    public MercadoViewModel(@NonNull Application application) {

        super(application);

    }

    public LiveData<miMapa> getMapa(){
        if(mapa == null){
            mapa = new MutableLiveData<>();
        }
        return mapa;
    }

    public void iniciarMapa(){
        mapa.setValue(new miMapa());
    }
    // TODO: Implement the ViewModel



    public class miMapa implements OnMapReadyCallback {

        @Override
        public void onMapReady(@NonNull GoogleMap googleMap) {
            googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            LatLng mercado1 = new LatLng(-33.268636, -66.3345104);
            LatLng mercado2 = new LatLng(-33.2679773, -66.3344353);
            LatLng hogar = new LatLng(-33.2677486, -66.3346391);
            googleMap.addMarker(new MarkerOptions().position(mercado1));
            googleMap.addMarker(new MarkerOptions().position(mercado2));

            CameraPosition camPos = new CameraPosition.Builder()
                    .target(hogar)
                    .zoom(19)
                    .bearing(45)
                    .tilt(60)
                    .build();
            CameraUpdate update = CameraUpdateFactory.newCameraPosition(camPos);

            googleMap.animateCamera(update);

        }
    }
}
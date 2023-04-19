package com.duvarax.tpanexocmoviles.ui.mercados;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.duvarax.tpanexocmoviles.R;
import com.duvarax.tpanexocmoviles.databinding.FragmentMercadoBinding;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MercadoFragment extends Fragment {

    private MercadoViewModel mViewModel;
    private FragmentMercadoBinding binding;


    public static MercadoFragment newInstance() {
        return new MercadoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentMercadoBinding.inflate(inflater, container, false);
        mViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(MercadoViewModel.class);
        View root = binding.getRoot();

        mViewModel.getMapa().observe(getActivity(), new Observer<MercadoViewModel.miMapa>() {
            @Override
            public void onChanged(MercadoViewModel.miMapa miMapa) {
                SupportMapFragment smf = (SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.map);
                smf.getMapAsync(miMapa);
            }
        });

        mViewModel.iniciarMapa();
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // TODO: Use the ViewModel
    }


}
package com.duvarax.tpanexocmoviles.ui.llamar;

import androidx.core.app.ActivityCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.duvarax.tpanexocmoviles.MainActivity;
import com.duvarax.tpanexocmoviles.R;
import com.duvarax.tpanexocmoviles.databinding.FragmentLlamarBinding;

public class LlamarFragment extends Fragment {

    private LlamarViewModel mViewModel;
    private FragmentLlamarBinding binding;


    public static LlamarFragment newInstance() {
        return new LlamarFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentLlamarBinding.inflate(inflater, container, false);
        mViewModel= ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(LlamarViewModel.class);
        View root = binding.getRoot();

        mViewModel.getLlamar().observe(getActivity(), new Observer<String>() {
            @Override
            public void onChanged(String numero) {
                Toast.makeText(getActivity(), "Llamando a " + numero, Toast.LENGTH_SHORT).show();
            }
        });

        binding.btnLlamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewModel.intentarLlamada(binding.etNumero.getText()+"");
            }
        });
        return root;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // TODO: Use the ViewModel
    }

}
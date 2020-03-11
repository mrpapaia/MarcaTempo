package com.example.marcatempo;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ToggleButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class Cronometro extends Fragment {
    Boolean execucao = false;
    Boolean criado = false;
    Integer segundos = 0;

    public Cronometro() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.tab_cronometro, container, false);
    }
    public void onResume() {
        super.onResume();
        runTime();
    }
    public void onClickStart(View view){
        switch (view.getId()) {
            case R.id.tbStartStop:
                if (((ToggleButton) view).isChecked()) {
                    if (!execucao) {
                        execucao = true;
                    }
                } else {
                    if (execucao) {
                        execucao = false;
                    }
                }
        }

    }
    public void onClickRestart(View view){
        segundos=0;
    }
    private void runTime() {

        // Drawable seg = getDrawable(R.drawable.circularsegundos);
        //Drawable min = getDrawable(R.drawable.circularminutos);
        //Drawable h = getDrawable(R.drawable.circularhoras);
        final TextView tvContador = (TextView) getView().findViewById(R.id.tvContador);
        final ProgressBar pbSegundos = (ProgressBar) getView().findViewById(R.id.pbSegundos);
        final ProgressBar pbMinutos = (ProgressBar) getView().findViewById(R.id.pbMinutos);
        final ProgressBar pbHoras = (ProgressBar) getView().findViewById(R.id.pbHoras);
       /* pbSegundos.setProgress(0);
        pbSegundos.setProgressDrawable(seg);
        pbMinutos.setProgress(0);
        pbMinutos.setProgressDrawable(min);
        pbHoras.setProgress(0);
        pbHoras.setProgressDrawable(h);*/
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                Integer horas = segundos / 3600;
                Integer minutos = (segundos % 3600) / 60;
                Integer secs = segundos % 60;
                String timer = String.format("%02d:%02d:%02d", horas, minutos, secs);
                tvContador.setText(timer);
                pbSegundos.setProgress(secs);
                pbMinutos.setProgress(minutos);
                pbHoras.setProgress(horas);
                if (execucao) {
                    segundos++;
                }
                handler.postDelayed(this, 1000);

            }
        });
    }
}

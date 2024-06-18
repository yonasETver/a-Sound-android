package com.yonastedela63.asound;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.yonastedela63.asound.R;

public class BotomBar extends Fragment {

    private Button bg_btn1, bg_btn2, bg_btn3, bg_btn4;
    private SharedPreferences sharedPref;
    private OnColorChangedListener colorChangedListener; // Interface instance

    // Interface definition for communication with the activity
    public interface OnColorChangedListener {
        void onColorChanged(int color);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            colorChangedListener = (OnColorChangedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnColorChangedListener");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        // Retrieve color from SharedPreferences and update TopBar immediately
        int defaultColor = ContextCompat.getColor(requireContext(), R.color.green);
        int bgColor = sharedPref.getInt("bg_color", defaultColor);
        colorChangedListener.onColorChanged(bgColor); // Notify TopBar immediately
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_botom_bar, container, false);
        bg_btn1 = view.findViewById(R.id.bg_btn1);
        bg_btn2 = view.findViewById(R.id.bg_btn2);
        bg_btn3 = view.findViewById(R.id.bg_btn3);
        bg_btn4 = view.findViewById(R.id.bg_btn4);

        sharedPref = requireContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        bg_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateBackgroundColor(ContextCompat.getColor(requireContext(), R.color.red));
            }
        });

        bg_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateBackgroundColor(ContextCompat.getColor(requireContext(), R.color.green));
            }
        });

        bg_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateBackgroundColor(ContextCompat.getColor(requireContext(), R.color.blue));
            }
        });

        bg_btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateBackgroundColor(ContextCompat.getColor(requireContext(), R.color.orange));
            }
        });
        return view;
    }

    private void updateBackgroundColor(int color) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("bg_color", color);
        editor.apply();
        colorChangedListener.onColorChanged(color);
    }
}

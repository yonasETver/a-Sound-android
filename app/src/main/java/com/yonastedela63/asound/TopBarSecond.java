package com.yonastedela63.asound;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.lang.reflect.Method;




public class TopBarSecond extends Fragment {

    @Override
    public void onResume() {
        super.onResume();
    }

    static View view;
    private ImageView back_arow_icon, menuIconSecond, settingIconSecond;
    private Intent intent;
    private static RelativeLayout topBarSecond;
    private OnLanguageChangedListener langChangedListener;
    private OnColorUpdateListener colorUpdateListener;
    private SharedPreferences sharedPref;

    // Interface definition for communication with BottomBar
    public interface OnColorUpdateListener {
        void updateTopBarColor(int color);
    }

    // Interface definition for communication with the activity
    public interface OnLanguageChangedListener {
        void onLangChanged(String lang_one);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            langChangedListener = (TopBarSecond.OnLanguageChangedListener) context;
            colorUpdateListener = (TopBarSecond.OnColorUpdateListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnColorChangedListener");
        }
    }

    // Updated method to apply background color change
    public static void applyBackgroundColor(int color) {
        if (view != null) {
            topBarSecond.setBackgroundColor(color);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        sharedPref = requireContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        // Check if a key exists before adding its value


        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_top_bar_second, container, false);

        topBarSecond = view.findViewById(R.id.topBarSecond);
        SharedPreferences sharedPref = requireContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        int defaultColorRed = ContextCompat.getColor(requireContext(), R.color.green);
        int bgcolor = sharedPref.getInt("bg_color", defaultColorRed);
        topBarSecond.setBackgroundColor(bgcolor);

        back_arow_icon = view.findViewById(R.id.back_arow_icon);

        back_arow_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent =  new Intent(view.getContext(), MainActivity.class);
                view.getContext().startActivity(intent);
                //overridePendingTransition(R.anim.slide_out_left, R.anim.slide_in_right);
                // Perform the fragment transaction within the onClick
                // Intent to start MainActivity (if needed)
                intent = new Intent(view.getContext(), MainActivity.class);
                view.getContext().startActivity(intent);
            }
        });

        menuIconSecond = view.findViewById(R.id.menuIconSecond);

        menuIconSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this, "Menu....", Toast.LENGTH_SHORT).show();

                PopupMenu popupMenu = new PopupMenu(getContext(), view);
                try {
                    Field[] fields = popupMenu.getClass().getDeclaredFields();
                    for (Field field : fields) {
                        if ("mPopup".equals(field.getName())) {
                            field.setAccessible(true);
                            Object menuPopupHelper = field.get(popupMenu);
                            Class<?> classPopupHelper = Class.forName(menuPopupHelper.getClass().getName());
                            Method setForceIcons = classPopupHelper.getMethod("setForceShowIcon", boolean.class);
                            setForceIcons.invoke(menuPopupHelper, true);
                            break;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //popupMenu = new PopupMenu(getActivity(), view);
                popupMenu.getMenuInflater().inflate(R.menu.nav_menu, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.numberScreen:
                                //Toast.makeText(MainActivity.this, "Number screen clicked", Toast.LENGTH_SHORT).show();
                                intent = new Intent(view.getContext(), MainActivityNumber.class);
                                view.getContext().startActivity(intent);

                                break;
                            case R.id.abcScreen:
                                //Toast.makeText(MainActivity.this, "Abc screen clicked", Toast.LENGTH_SHORT).show();
                                intent = new Intent(view.getContext(), MainActivityAlpha.class);
                                view.getContext().startActivity(intent);
                                break;
                            case R.id.wordScreen:
                                //Toast.makeText(MainActivity.this, "Word screen clicked", Toast.LENGTH_SHORT).show();
                                intent = new Intent(view.getContext(), MainActivityWord.class);
                                view.getContext().startActivity(intent);
                                break;
                            case R.id.colorScreen:
                                //Toast.makeText(MainActivity.this, "Color ccreen clicked", Toast.LENGTH_SHORT).show();
                                intent = new Intent(view.getContext(), MainActivityColor.class);
                                view.getContext().startActivity(intent);
                                break;
                        }

                        return true;
                    }
                });
                popupMenu.show();
            }
        });

        settingIconSecond = view.findViewById(R.id.settingIconSecond);

        settingIconSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getActivity(), "Setting.....", Toast.LENGTH_SHORT).show();
                PopupMenu popupMenu = new PopupMenu(getActivity(), view);
                popupMenu.getMenuInflater().inflate(R.menu.nav_menu_right, popupMenu.getMenu());




                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {

                        switch (menuItem.getItemId()){
                            case R.id.ukId:
                                //Toast.makeText(getActivity(), "UK Selected", Toast.LENGTH_SHORT).show();
                                editor.putString("lang_one", "GB");
                                editor.apply();
                                langChangedListener.onLangChanged("GB");
                                break;
                            case R.id.usId:
                                //Toast.makeText(getActivity(), "US Selected", Toast.LENGTH_SHORT).show();
                                editor.putString("lang_one", "US");
                                editor.apply();
                                langChangedListener.onLangChanged("US");
                                break;
                        }
                        return true;
                    }
                });

                popupMenu.show();
            }
        });
        return  view;
    }
}
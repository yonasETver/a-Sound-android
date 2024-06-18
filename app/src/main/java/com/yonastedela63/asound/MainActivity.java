package com.yonastedela63.asound;

import static androidx.core.content.ContentProviderCompat.requireContext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class MainActivity extends AppCompatActivity implements BotomBar.OnColorChangedListener {

    private Fragment fragment;
    private ImageView menuIcon, settingIcon;
    private ImageButton numberPage,alphatPage,wordPage,colorPage;
    private Intent intent;
    private RelativeLayout top;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        // Check if a key exists before adding its value
        int bgColor;
        if (!sharedPref.contains("bg_color") || !sharedPref.contains("lang_one")) {
            editor.putInt("bg_color", ContextCompat.getColor(this, R.color.green));
            editor.putString("lang_one", "US");
            editor.apply();
            int defaultColorGreen = ContextCompat.getColor(this, R.color.green);
            bgColor = sharedPref.getInt("bg_color", defaultColorGreen);
        }else{
            int defaultColorGreen = ContextCompat.getColor(this, R.color.green);
            bgColor = sharedPref.getInt("bg_color", defaultColorGreen);
        }

        fragment = new BotomBar(); // Assuming BotomBar is a Fragment subclass

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainFragmentBottom, fragment);
        fragmentTransaction.commit();

        menuIcon = findViewById(R.id.menuIcon);
        settingIcon = findViewById(R.id.settingIcon);

        numberPage = findViewById(R.id.numberPage);
        alphatPage = findViewById(R.id.alphatPage);
        wordPage = findViewById(R.id.wordPage);
        colorPage = findViewById(R.id.colorPage);
        top= findViewById(R.id.top);

        top.setBackgroundColor(bgColor);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            numberPage.setBackgroundTintList(ColorStateList.valueOf(bgColor));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            alphatPage.setBackgroundTintList(ColorStateList.valueOf(bgColor));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            wordPage.setBackgroundTintList(ColorStateList.valueOf(bgColor));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            colorPage.setBackgroundTintList(ColorStateList.valueOf(bgColor));
        }

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this, "Menu....", Toast.LENGTH_SHORT).show();

                PopupMenu popupMenu = new PopupMenu(MainActivity.this, view);
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

        settingIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Setting.....", Toast.LENGTH_SHORT).show();
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, view);
                popupMenu.getMenuInflater().inflate(R.menu.nav_menu_right, popupMenu.getMenu());




                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {

                        switch (menuItem.getItemId()){
                            case R.id.ukId:
                                Toast.makeText(MainActivity.this, "UK Selected", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.usId:
                                Toast.makeText(MainActivity.this, "US Selected", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return true;
                    }
                });

                popupMenu.show();
            }
        });

        numberPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(view.getContext(), MainActivityNumber.class);
                view.getContext().startActivity(intent);
            }
        });

        alphatPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(view.getContext(), MainActivityAlpha.class);
                view.getContext().startActivity(intent);
            }
        });

        wordPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(view.getContext(), MainActivityWord.class);
                view.getContext().startActivity(intent);
            }
        });

        colorPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(view.getContext(), MainActivityColor.class);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public void onColorChanged(int color) {
        top.setBackgroundColor(color);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            numberPage.setBackgroundTintList(ColorStateList.valueOf(color));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            alphatPage.setBackgroundTintList(ColorStateList.valueOf(color));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            wordPage.setBackgroundTintList(ColorStateList.valueOf(color));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            colorPage.setBackgroundTintList(ColorStateList.valueOf(color));
        }
    }
}



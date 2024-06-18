package com.yonastedela63.asound;

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
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivityColor extends AppCompatActivity implements TextToSpeech.OnInitListener, View.OnClickListener, BotomBar.OnColorChangedListener, TopBarSecond.OnLanguageChangedListener, TopBarSecond.OnColorUpdateListener{

    Fragment fragment, fragment2;
    private TextToSpeech textToSpeech;
    private RelativeLayout colorOne, colorTwo, colorThree, colorFour, colorFive, colorSix, colorSeven, colorEight, colorNine
            ,colorTen, colorEleven, colortwelve, colorThirteen, colorFourteen, colorFifteen, colorSixteen, colorSeventeen, colorEighteen, colorNineteen,
            colorTwenty, colorTwentyone, colorTwentytwo, colorTwentythree, colorTwentyfour;

    private Button c1btn1l1A1, c1btn1l1B2, c1btn1l1C3, c1btn1l1D4, c2btn1l1A5, c2btn1l1B6, c2btn1l1C7,c2btn1l1D8,c3btn1l1A9,c3btn1l1B10,
            c3btn1l1C11, c3btn1l1D12, c4btn1l1A13, c4btn1l1B14,c4btn1l1C15, c4btn1l1D16,c5btn1l1A17, c5btn1l1B18, c5btn1l1C19, c5btn1l1D20, c6btn1l1A21,
            c6btn1l1B22, c6btn1l1C23, c6btn1l1D24;
    ;
    private TextView c1txt1l1A1, c1txt1l1B2,c1txt1l1C3,c1txt1l1D4, c2txt1l1A5, c2txt1l1B6, c2txt1l1C7, c2txt1l1D8, c3txt1l1A9,
            c3txt1l1B10, c3txt1l1C11, c2txt1l1D12, c4txt1l1A13, c4txt1l1B14, c4txt1l1C15, c4txt1l1D16, c5txt1l1A17, c5txt1l1B18, c5txt1l1C19, c5txt1l1D20,
            c6txt1l1A21, c6txt1l1B22, c6txt1l1C23, c6txt1l1D24;
    private Button wordTxt;
    private ImageView btnWord;

    private final float fontSiz = 29.0F;
    private int coun = 0;
    private String colrName ="";
    private Boolean speakButton = false;
    private String lang_two;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_color);

        fragment = new TopBarSecond();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentAlpha, fragment);
        fragmentTransaction.commit();

        fragment2 = new BotomBar();

        FragmentManager fragmentManager2 = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
        fragmentTransaction2.replace(R.id.colorFragmentBottom, fragment2);
        fragmentTransaction2.commit();

        textToSpeech = new TextToSpeech(this, this);

        wordTxt = findViewById(R.id.wordTxt);

        btnWord = findViewById(R.id.btnWord);
        SharedPreferences sharedPref = this.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        int defaultColorRed = ContextCompat.getColor(this, R.color.green);
        int bgcolor = sharedPref.getInt("bg_color", defaultColorRed);
        lang_two = sharedPref.getString("lang_one", "US");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            btnWord.setBackgroundTintList(ColorStateList.valueOf(bgcolor));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            wordTxt.setBackgroundTintList(ColorStateList.valueOf(bgcolor));
        }
        btnWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                coun++;
                if(coun % 2 == 1){
                    btnWord.setImageResource(R.drawable.ic_volume_up);
                    speakButton = true;
                }else{
                    btnWord.setImageResource(R.drawable.ic_volume_off);
                    speakButton = false;
                    //texttoSpeak(colrName);
                }
            }
        });

        wordTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(speakButton){
                    texttoSpeak(colrName);
                }
            }
        });

        colorOne = findViewById(R.id.colorOne);
        colorTwo = findViewById(R.id.colorOne);
        colorThree = findViewById(R.id.colorThree);
        colorFour = findViewById(R.id.colorFour);
        colorFive = findViewById(R.id.colorFive);
        colorSix = findViewById(R.id.colorSix);
        colorSeven = findViewById(R.id.colorSeven);
        colorEight = findViewById(R.id.colorEight);
        colorNine = findViewById(R.id.colorNine);
        colorTen = findViewById(R.id.colorTen);
        colorEleven = findViewById(R.id.colorEleven);
        colortwelve = findViewById(R.id.colortwelve);
        colorThirteen = findViewById(R.id.colorThirteen);
        colorFourteen = findViewById(R.id.colorFourteen);
        colorFifteen = findViewById(R.id.colorFifteen);
        colorSixteen = findViewById(R.id.colorSixteen);
        colorSeventeen = findViewById(R.id.colorSeventeen);
        colorEighteen = findViewById(R.id.colorEighteen);
        colorNineteen = findViewById(R.id.colorNineteen);
        colorTwenty = findViewById(R.id.colorTwenty);
        colorTwentyone = findViewById(R.id.colorTwentyone);
        colorTwentytwo = findViewById(R.id.colorTwentytwo);
        colorTwentythree = findViewById(R.id.colorTwentythree);
        colorTwentyfour = findViewById(R.id.colorTwentyfour);


        c1btn1l1A1 = findViewById(R.id.c1btn1l1A1);
        c1btn1l1B2 = findViewById(R.id.c1btn1l1B2);
        c1btn1l1C3 = findViewById(R.id.c1btn1l1C3);
        c1btn1l1D4 = findViewById(R.id.c1btn1l1D4);
        c2btn1l1A5 = findViewById(R.id.c2btn1l1A5);
        c2btn1l1B6 = findViewById(R.id.c2btn1l1B6);
        c2btn1l1C7 = findViewById(R.id. c2btn1l1C7);
        c2btn1l1D8 = findViewById(R.id.c2btn1l1D8);
        c3btn1l1A9 = findViewById(R.id.c3btn1l1A9);
        c3btn1l1B10 = findViewById(R.id.c3btn1l1B10);
        c3btn1l1C11 = findViewById(R.id.c3btn1l1C11);
        c3btn1l1D12 = findViewById(R.id.c3btn1l1D12);
        c4btn1l1A13 = findViewById(R.id.c4btn1l1A13);
        c4btn1l1B14 = findViewById(R.id.c4btn1l1B14);
        c4btn1l1C15 = findViewById(R.id.c4btn1l1C15);
        c4btn1l1D16 = findViewById(R.id.c4btn1l1D16);
        c5btn1l1A17 = findViewById(R.id.c5btn1l1A17);
        c5btn1l1B18 = findViewById(R.id.c5btn1l1B18);
        c5btn1l1C19 = findViewById(R.id.c5btn1l1C19);
        c5btn1l1D20 = findViewById(R.id.c5btn1l1D20);
        c6btn1l1A21 = findViewById(R.id.c6btn1l1A21);
        c6btn1l1B22 = findViewById(R.id.c6btn1l1B22);
        c6btn1l1C23 = findViewById(R.id.c6btn1l1C23);
        c6btn1l1D24 = findViewById(R.id.c6btn1l1D24);

        c1txt1l1A1 = findViewById(R.id.c1txt1l1A1);
        c1txt1l1B2 = findViewById(R.id.c1txt1l1B2);
        c1txt1l1C3 = findViewById(R.id.c1txt1l1C3);
        c1txt1l1D4 = findViewById(R.id.c1txt1l1D4);
        c2txt1l1A5 = findViewById(R.id.c2txt1l1A5);
        c2txt1l1B6 = findViewById(R.id.c2txt1l1B6);
        c2txt1l1C7 = findViewById(R.id.c2txt1l1C7);
        c2txt1l1D8 = findViewById(R.id.c2txt1l1D8);
        c3txt1l1A9 = findViewById(R.id.c3txt1l1A9);
        c3txt1l1B10 = findViewById(R.id.c3txt1l1B10);
        c3txt1l1C11 = findViewById(R.id.c3txt1l1C11);
        c2txt1l1D12 = findViewById(R.id.c2txt1l1D12);
        c4txt1l1A13 = findViewById(R.id.c4txt1l1A13);
        c4txt1l1B14 = findViewById(R.id.c4txt1l1B14);
        c4txt1l1C15 = findViewById(R.id.c4txt1l1C15);
        c4txt1l1D16 = findViewById(R.id.c4txt1l1D16);
        c5txt1l1A17 = findViewById(R.id.c5txt1l1A17);
        c5txt1l1B18 = findViewById(R.id.c5txt1l1B18);
        c5txt1l1C19 = findViewById(R.id.c5txt1l1C19);
        c5txt1l1D20 = findViewById(R.id.c5txt1l1D20);
        c6txt1l1A21 = findViewById(R.id.c6txt1l1A21);
        c6txt1l1B22 = findViewById(R.id.c6txt1l1B22);
        c6txt1l1C23 = findViewById(R.id.c6txt1l1C23);
        c6txt1l1D24 = findViewById(R.id.c6txt1l1D24);

        colorOne.setOnClickListener(this);
        colorOne.setOnClickListener(this);
        colorTwo.setOnClickListener(this);
        colorThree.setOnClickListener(this);
        colorFour.setOnClickListener(this);
        colorFive.setOnClickListener(this);
        colorSix.setOnClickListener(this);
        colorSeven.setOnClickListener(this);
        colorEight.setOnClickListener(this);
        colorNine.setOnClickListener(this);
        colorTen.setOnClickListener(this);
        colorEleven.setOnClickListener(this);
        colortwelve.setOnClickListener(this);
        colorThirteen.setOnClickListener(this);
        colorFourteen.setOnClickListener(this);
        colorFifteen.setOnClickListener(this);
        colorSixteen.setOnClickListener(this);
        colorSeventeen.setOnClickListener(this);
        colorEighteen.setOnClickListener(this);
        colorNineteen.setOnClickListener(this);
        colorTwenty.setOnClickListener(this);
        colorTwentyone.setOnClickListener(this);
        colorTwentytwo.setOnClickListener(this);
        colorTwentythree.setOnClickListener(this);
        colorTwentyfour.setOnClickListener(this);

        c1btn1l1A1.setOnClickListener(this);
        c1btn1l1B2.setOnClickListener(this);
        c1btn1l1C3.setOnClickListener(this);
        c1btn1l1D4.setOnClickListener(this);
        c2btn1l1A5.setOnClickListener(this);
        c2btn1l1B6.setOnClickListener(this);
        c2btn1l1C7.setOnClickListener(this);
        c2btn1l1D8.setOnClickListener(this);
        c3btn1l1A9.setOnClickListener(this);
        c3btn1l1B10.setOnClickListener(this);
        c3btn1l1C11.setOnClickListener(this);
        c3btn1l1D12.setOnClickListener(this);
        c4btn1l1A13.setOnClickListener(this);
        c4btn1l1B14.setOnClickListener(this);
        c4btn1l1C15.setOnClickListener(this);
        c4btn1l1D16.setOnClickListener(this);
        c5btn1l1A17.setOnClickListener(this);
        c5btn1l1B18.setOnClickListener(this);
        c5btn1l1C19.setOnClickListener(this);
        c5btn1l1D20.setOnClickListener(this);
        c6btn1l1A21.setOnClickListener(this);
        c6btn1l1B22.setOnClickListener(this);
        c6btn1l1C23.setOnClickListener(this);
        c6btn1l1D24.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.colorOne: case R.id.c1btn1l1A1:
                colrName = c1txt1l1A1.getText().toString();
                wordTxt.setText(c1txt1l1A1.getText().toString());
                wordTxt.setGravity(Gravity.CENTER);
                wordTxt.setTextColor(Color.parseColor("#ed3833"));
                wordTxt.setTextSize(fontSiz);
                break;
            case R.id.colorTwo: case R.id.c1btn1l1B2:
                colrName = c1txt1l1B2.getText().toString();
                wordTxt.setText(c1txt1l1B2.getText().toString());
                wordTxt.setGravity(Gravity.CENTER);
                wordTxt.setTextColor(Color.parseColor("#4da957"));
                wordTxt.setTextSize(fontSiz);
                break;
            case R.id.colorThree: case R.id.c1btn1l1C3:
                colrName = c1txt1l1C3.getText().toString();
                wordTxt.setText(c1txt1l1C3.getText().toString());
                wordTxt.setGravity(Gravity.CENTER);
                wordTxt.setTextColor(Color.parseColor("#42abdf"));
                wordTxt.setTextSize(fontSiz);
                break;
            case R.id.colorFour: case R.id.c1btn1l1D4:
                colrName = c1txt1l1D4.getText().toString();
                wordTxt.setText(c1txt1l1D4.getText().toString());
                wordTxt.setGravity(Gravity.CENTER);
                wordTxt.setTextColor(Color.parseColor("#3a4b90"));
                wordTxt.setTextSize(fontSiz);
                break;
            case R.id.colorFive: case R.id.c2btn1l1A5:
                colrName = c2txt1l1A5.getText().toString();
                wordTxt.setText(c2txt1l1A5.getText().toString());
                wordTxt.setGravity(Gravity.CENTER);
                wordTxt.setTextColor(Color.parseColor("#f3b743"));
                wordTxt.setTextSize(fontSiz);
                break;
            case R.id.colorSix: case R.id.c2btn1l1B6:
                colrName = c2txt1l1B6.getText().toString();
                wordTxt.setText(c2txt1l1B6.getText().toString());
                wordTxt.setGravity(Gravity.CENTER);
                wordTxt.setTextColor(Color.parseColor("#fee84e"));
                wordTxt.setTextSize(fontSiz);
                break;
            case R.id.colorSeven: case R.id.c2btn1l1C7:
                colrName = c2txt1l1C7.getText().toString();
                wordTxt.setText(c2txt1l1C7.getText().toString());
                wordTxt.setGravity(Gravity.CENTER);
                wordTxt.setTextColor(Color.parseColor("#655091"));
                wordTxt.setTextSize(fontSiz);
                break;
            case R.id.colorEight: case R.id.c2btn1l1D8:
                colrName = c2txt1l1D8.getText().toString();
                wordTxt.setText(c2txt1l1D8.getText().toString());
                wordTxt.setGravity(Gravity.CENTER);
                wordTxt.setTextColor(Color.parseColor("#ffd701"));
                wordTxt.setTextSize(fontSiz);
                break;
            case R.id.colorNine: case R.id.c3btn1l1A9:
                colrName = c3txt1l1A9.getText().toString();
                wordTxt.setText(c3txt1l1A9.getText().toString());
                wordTxt.setGravity(Gravity.CENTER);
                wordTxt.setTextColor(Color.parseColor("#a44062"));
                wordTxt.setTextSize(fontSiz);
                break;
            case R.id.colorTen: case R.id.c3btn1l1B10:
                colrName = c3txt1l1B10.getText().toString();
                wordTxt.setText(c3txt1l1B10.getText().toString());
                wordTxt.setGravity(Gravity.CENTER);
                wordTxt.setTextColor(Color.parseColor("#000000"));
                wordTxt.setTextSize(fontSiz);
                break;
            case R.id.colorEleven: case R.id.c3btn1l1C11:
                colrName = c3txt1l1C11.getText().toString();
                wordTxt.setText(c3txt1l1C11.getText().toString());
                wordTxt.setGravity(Gravity.CENTER);
                wordTxt.setTextColor(Color.parseColor("#817c24"));
                wordTxt.setTextSize(fontSiz);
                break;
            case R.id.colortwelve: case R.id.c3btn1l1D12:
                colrName = c2txt1l1D12.getText().toString();
                wordTxt.setText(c2txt1l1D12.getText().toString());
                wordTxt.setGravity(Gravity.CENTER);
                wordTxt.setTextColor(Color.parseColor("#6dfbfb"));
                wordTxt.setTextSize(fontSiz);
                break;
            case R.id.colorThirteen: case R.id.c4btn1l1A13:
                colrName = c4txt1l1A13.getText().toString();
                wordTxt.setText(c4txt1l1A13.getText().toString());
                wordTxt.setGravity(Gravity.CENTER);
                wordTxt.setTextColor(Color.parseColor("#ee79c3"));
                wordTxt.setTextSize(fontSiz);
                break;
            case R.id.colorFourteen: case R.id.c4btn1l1B14:
                colrName = c4txt1l1B14.getText().toString();
                wordTxt.setText(c4txt1l1B14.getText().toString());
                wordTxt.setGravity(Gravity.CENTER);
                wordTxt.setTextColor(Color.parseColor("#eb58f9"));
                wordTxt.setTextSize(fontSiz);
                break;
            case R.id.colorFifteen: case R.id.c4btn1l1C15:
                colrName = c4txt1l1C15.getText().toString();
                wordTxt.setText(c4txt1l1C15.getText().toString());
                wordTxt.setGravity(Gravity.CENTER);
                wordTxt.setTextColor(Color.parseColor("#fadabe"));
                wordTxt.setTextSize(fontSiz);
                break;
            case R.id.colorSixteen: case R.id.c4btn1l1D16:
                colrName = c4txt1l1D16.getText().toString();
                wordTxt.setText(c4txt1l1D16.getText().toString());
                wordTxt.setGravity(Gravity.CENTER);
                wordTxt.setTextColor(Color.parseColor("#337e7e"));
                wordTxt.setTextSize(fontSiz);
                break;
            case R.id.colorSeventeen: case R.id.c5btn1l1A17:
                colrName = c5txt1l1A17.getText().toString();
                wordTxt.setText(c5txt1l1A17.getText().toString());
                wordTxt.setGravity(Gravity.CENTER);
                wordTxt.setTextColor(Color.parseColor("#03f4ce"));
                wordTxt.setTextSize(fontSiz);
                break;
            case R.id.colorEighteen: case R.id.c5btn1l1B18:
                colrName = c5txt1l1B18.getText().toString();
                wordTxt.setText(c5txt1l1B18.getText().toString());
                wordTxt.setGravity(Gravity.CENTER);
                wordTxt.setTextColor(Color.parseColor("#ffab91"));
                wordTxt.setTextSize(fontSiz);
                break;
            case R.id.colorNineteen: case R.id.c5btn1l1C19:
                colrName  = c5txt1l1C19.getText().toString();
                wordTxt.setText(c5txt1l1C19.getText().toString());
                wordTxt.setGravity(Gravity.CENTER);
                wordTxt.setTextColor(Color.parseColor("#ffffff"));
                wordTxt.setTextSize(fontSiz);
                break;
            case R.id.colorTwenty: case R.id.c5btn1l1D20:
                colrName = c5txt1l1D20.getText().toString();
                wordTxt.setText(c5txt1l1D20.getText().toString());
                wordTxt.setGravity(Gravity.CENTER);
                wordTxt.setTextColor(Color.parseColor("#fdc400"));
                wordTxt.setTextSize(fontSiz);
                break;
            case R.id.colorTwentyone: case R.id.c6btn1l1A21:
                colrName = c6txt1l1A21.getText().toString();
                wordTxt.setText(c6txt1l1A21.getText().toString());
                wordTxt.setGravity(Gravity.CENTER);
                wordTxt.setTextColor(Color.parseColor("#a7a7a7"));
                wordTxt.setTextSize(fontSiz);
                break;
            case R.id.colorTwentytwo: case R.id.c6btn1l1B22:
                colrName = c6txt1l1B22.getText().toString();
                wordTxt.setText(c6txt1l1B22.getText().toString());
                wordTxt.setGravity(Gravity.CENTER);
                wordTxt.setTextColor(Color.parseColor("#795548"));
                wordTxt.setTextSize(fontSiz);
                break;
            case R.id.colorTwentythree: case R.id.c6btn1l1C23:
                colrName = c6txt1l1C23.getText().toString();
                wordTxt.setText(c6txt1l1C23.getText().toString());
                wordTxt.setGravity(Gravity.CENTER);
                wordTxt.setTextColor(Color.parseColor("#77ff03"));
                wordTxt.setTextSize(fontSiz);
                break;
            case R.id.colorTwentyfour: case R.id.c6btn1l1D24:
                colrName = c6txt1l1D24.getText().toString();
                wordTxt.setText(c6txt1l1D24.getText().toString());
                wordTxt.setGravity(Gravity.CENTER);
                wordTxt.setTextColor(Color.parseColor("#5f7d8c"));
                wordTxt.setTextSize(fontSiz);
                break;

        }
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            // Set UK English locale using the current value of lang_two
            Locale localeUK = new Locale("en", lang_two);
            int result = textToSpeech.setLanguage(localeUK);

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("error", "This Language is not supported");
            } else {
                // Text-to-speech is initialized successfully with the updated language
            }
        } else {
            Log.e("error", "Failed to Initialize");
        }
    }

    private void texttoSpeak(String text) {

        //String text = "Veronica Rossi";
        if ("".equals(text)) {
            text = "Please enter some text to speak.";
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
        }
        else {
            textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null);
        }
    }

    @Override
    public void onColorChanged(int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            btnWord.setBackgroundTintList(ColorStateList.valueOf(color));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            wordTxt.setBackgroundTintList(ColorStateList.valueOf(color));
        }
        if (fragment != null) {
            TopBarSecond.applyBackgroundColor(color);
        }
    }

    @Override
    public void onLangChanged(String lang_one) {
        // Update lang_two immediately when onLangChanged is called
        lang_two = lang_one;

        // Reinitialize Text-to-Speech with the updated language
        Locale localeUpdated = new Locale("en", lang_two);
        int result = textToSpeech.setLanguage(localeUpdated);

        if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
            Log.e("error", "This Language is not supported");
        } else {
            // Text-to-speech is reinitialized successfully with the updated language
        }
    }

    @Override
    public void updateTopBarColor(int color) {
        if (fragment != null) {
            TopBarSecond.applyBackgroundColor(color);
        }
    }
}
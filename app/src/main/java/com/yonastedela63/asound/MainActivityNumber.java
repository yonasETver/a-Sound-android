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
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.Locale;

public class MainActivityNumber extends AppCompatActivity implements TextToSpeech.OnInitListener, BotomBar.OnColorChangedListener, TopBarSecond.OnLanguageChangedListener,TopBarSecond.OnColorUpdateListener {

    private TextToSpeech textToSpeech;
    Fragment fragment, fragment2;
    Button wordTxt, numberOne, numberTwo, numberThree, numberFour, numberFive, numberSix, numberSeven ,numberEight, numberNine, numberZero, multiNumber;
    ImageButton backSpace, btnWord;
    private boolean soundButton = false;
    private int countButton = 1;
    private boolean multipleNumber = false;
    private int countMultiNumber = 1;
    private String lang_two;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_number);

        fragment = new TopBarSecond();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentAlpha, fragment);
        fragmentTransaction.commit();

        fragment2 = new BotomBar();

        FragmentManager fragmentManager2 = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
        fragmentTransaction2.replace(R.id.numberFragmentBottom, fragment2);
        fragmentTransaction2.commit();

        //initialized text to speeak
        textToSpeech = new TextToSpeech(this, this);
        //sound
        btnWord =findViewById(R.id.btnWord);

        //keyboard buttons
        wordTxt = findViewById(R.id.wordTxt);

        numberOne = findViewById(R.id.numberOne);
        numberTwo = findViewById(R.id.numberTwo);
        numberThree = findViewById(R.id.numberThree);
        numberFour = findViewById(R.id.numberFour);
        numberFive = findViewById(R.id.numberFive);
        numberSix = findViewById(R.id.numberSix);
        numberSeven = findViewById(R.id.numberSeven);
        numberEight = findViewById(R.id.numberEight);
        numberNine = findViewById(R.id.numberNine);
        numberZero = findViewById(R.id.numberZero);
        multiNumber = findViewById(R.id.multiNumber);
        backSpace = findViewById(R.id.backSpace);

        wordTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivityNumber.this, "Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        SharedPreferences sharedPref = this.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        int defaultColorRed = ContextCompat.getColor(this, R.color.green);
        int bgcolor = sharedPref.getInt("bg_color", defaultColorRed);
        lang_two = sharedPref.getString("lang_one", "US  ");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            btnWord.setBackgroundTintList(ColorStateList.valueOf(bgcolor));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            wordTxt.setBackgroundTintList(ColorStateList.valueOf(bgcolor));
        }
        btnWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(countButton % 2 != 0){
                    soundButton = true;
                    btnWord.setImageResource(R.drawable.ic_volume_up);

                }else {
                    btnWord.setImageResource(R.drawable.ic_volume_off);
                    soundButton = false;
                }

                countButton++;

            }
        });

        //Is used to speak text
        wordTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(soundButton){
                    //TODO: call textTo Speach
                    if (soundButton) {
                        texttoSpeak(wordTxt.getText().toString());
                    }
                }
            }
        });

        //set to accept up to 4  number
        multiNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (countMultiNumber % 2 != 0){
                    multipleNumber = true;
                    multiNumber.setText("+1N");
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        multiNumber.setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));
                    }
                }else{
                    multipleNumber = false;
                    multiNumber.setText("1N");
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        multiNumber.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
                    }
                }

                countMultiNumber++;
            }
        });

        numberKeyboard();



    }

    //function for writing text on top
    void setTopText(String num){
        String str = (String) wordTxt.getText().toString();
        if(str.length() < 4 && multipleNumber){

            str += num;
            wordTxt.setText(str);

        }else if(!multipleNumber){
            wordTxt.setText(num);
        }
    }

    void numberKeyboard(){
        numberOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTopText("1");

            }
        });

        numberTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTopText("2");
            }
        });

        numberThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTopText("3");
            }
        });

        numberFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTopText("4");
            }
        });

        numberFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTopText("5");
            }
        });

        numberSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTopText("6");
            }
        });

        numberSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTopText("7");
            }
        });

        numberEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTopText("8");
            }
        });

        numberNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTopText("9");
            }
        });

        numberZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTopText("0");
            }
        });

        backSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = wordTxt.getText().toString();
                if(str.length() > 0) {
                    str = str.substring(0, str.length() - 1);
                    wordTxt.setText(str);
                }
            }
        });
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
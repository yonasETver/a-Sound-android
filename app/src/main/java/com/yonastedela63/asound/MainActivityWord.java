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
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivityWord extends AppCompatActivity implements TextToSpeech.OnInitListener,BotomBar.OnColorChangedListener, TopBarSecond.OnLanguageChangedListener, TopBarSecond.OnColorUpdateListener {

    private TextToSpeech textToSpeech;
    Fragment fragment, fragment2;
    Button wordTxt;

    private ImageButton btnWord,capitalLetter,backSpace,specerButton;
    private LinearLayout line1eng, line2eng, line3eng, line4eng;
    private LinearLayout line1amha, line2amha, line3amha,line4amha,line5amha;
    private Button alphaA, alphaB, alphaC,alphaD,alphaE,alphaF,alphaG,alphaH,alphaI,alphaJ,alphaK,alphaL,alphaM,alphaN,alphaO,alphaP,alphaQ,alphaR,alphaS,alphaT
            ,alphaU,alphaV,alphaW,alphaX,alphaY,alphaZ;
    private Button amharicSub1,amharicSub2,amharicSub3,amharicSub4,amharicSub5,amharicSub6,amharicSub7;
    private Button amharic1,amharic2,amharic3,amharic4,amharic5,amharic6,amharic7,amharic8,amharic9,amharic10,amharic11,amharic12,amharic13,amharic14,amharic15
            ,amharic16,amharic17,amharic18,amharic19,amharic20,amharic21,amharic22,amharic23,amharic24,amharic25,amharic26,amharic27,amharic28,amharic29
            ,amharic30,amharic31,amharic32,amharic33,amharic111;
    private Button alphaLang;
    private RelativeLayout alphaKeyboard;
    private String lang_two;

    //for handling language
    private  Boolean lang = false;
    private int langCount = 2;

    //handlingUpperCase english
    private int upperCounter = 2;
    private boolean upperBool = false;

    //for sound icon
    private int countButton = 1;
    private boolean soundButton = false;

    //to check if the sub amharic letter is clicked
    private int isSub = 0;
    private int isSub1 = 0;
    private int isSub2 = 0;
    private int isSub3 = 0;
    private int isSub4 = 0;
    private int isSub5 = 0;
    private int isSub6 = 0;
    private int isSub7 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_word);

        fragment = new TopBarSecond();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentAlpha, fragment);
        fragmentTransaction.commit();

        fragment2 = new BotomBar();

        FragmentManager fragmentManager2 = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
        fragmentTransaction2.replace(R.id.wordFragmentBottom, fragment2);
        fragmentTransaction2.commit();
        //initialized text to speeak

        textToSpeech = new TextToSpeech(this, this);

        alphaKeyboard = findViewById(R.id.alphaKeybord);
        //the linerlayout for visibility
        line1eng = findViewById(R.id.line1eng);
        line2eng = findViewById(R.id.line2eng);
        line3eng =  findViewById(R.id.line3eng);
        line4eng = findViewById(R.id.line4eng);
        line1amha = findViewById(R.id.line1amha);
        line2amha = findViewById(R.id.line2amha);
        line3amha = findViewById(R.id.line3amha);
        line4amha = findViewById(R.id.line4amha);
        line5amha = findViewById(R.id. line5amha);

        //top text button
        wordTxt = findViewById(R.id.wordTxt);

        //sound icon
        btnWord = findViewById(R.id.btnWord);
        //for capital letter
        capitalLetter = line3eng.findViewById(R.id.capitalLetter);
        //delete last
        backSpace = findViewById(R.id.backSpace);
        //space button
        specerButton = findViewById(R.id.specerButton);

        //English letter
        alphaA = line1eng.findViewById(R.id. alphaA);
        alphaB = line1eng.findViewById(R.id.alphaB);
        alphaC = line1eng.findViewById(R.id.alphaC);
        alphaD  = line1eng.findViewById(R.id.alphaD);
        alphaE = line1eng.findViewById(R.id.alphaE);
        alphaF = line1eng.findViewById(R.id.alphaF);
        alphaG = line1eng.findViewById(R.id.alphaG);
        alphaH = line1eng.findViewById(R.id.alphaH);
        alphaI = line1eng.findViewById(R.id.alphaI);
        alphaJ = line1eng.findViewById(R.id.alphaJ);
        alphaK = line2eng.findViewById(R.id.alphaK);
        alphaL = line2eng.findViewById(R.id.alphaL);
        alphaM = line2eng.findViewById(R.id.alphaM);
        alphaN = line2eng.findViewById(R.id.alphaN);
        alphaO = line2eng.findViewById(R.id.alphaO);
        alphaP = line2eng.findViewById(R.id.alphaP);
        alphaQ = line2eng.findViewById(R.id.alphaQ);
        alphaR = line2eng.findViewById(R.id.alphaR);
        alphaS = line2eng.findViewById(R.id.alphaS);
        alphaT = line3eng.findViewById(R.id.alphaT);
        alphaU = line3eng.findViewById(R.id.alphaU);
        alphaV = line3eng.findViewById(R.id.alphaV);
        alphaW = line3eng.findViewById(R.id.alphaW);
        alphaX = line3eng.findViewById(R.id.alphaX);
        alphaY = line3eng.findViewById(R.id.alphaY);
        alphaZ = line3eng.findViewById(R.id.alphaZ);


        //Amharic letter
        amharic1 = line2amha.findViewById(R.id.amharic1);
        amharic2 = line2amha.findViewById(R.id.amharic2);
        amharic3 = line2amha.findViewById(R.id.amharic3);
        amharic4 = line2amha.findViewById(R.id.amharic4);
        amharic5 = line2amha.findViewById(R.id.amharic5);
        amharic6 = line2amha.findViewById(R.id.amharic6);
        amharic7 = line2amha.findViewById(R.id.amharic7);
        amharic8 = line2amha.findViewById(R.id.amharic8);
        amharic9 = line2amha.findViewById(R.id.amharic9);
        amharic10 = line2amha.findViewById(R.id.amharic10);
        amharic11 = line3amha.findViewById(R.id.amharic11);
        amharic12 = line3amha.findViewById(R.id.amharic12);
        amharic13 = line3amha.findViewById(R.id.amharic13);
        amharic14 = line3amha.findViewById(R.id.amharic14);
        amharic15 = line3amha.findViewById(R.id.amharic15);
        amharic16 = line3amha.findViewById(R.id.amharic16);
        amharic17 = line3amha.findViewById(R.id.amharic17);
        amharic18 = line3amha.findViewById(R.id.amharic18);
        amharic19 = findViewById(R.id.amharic19);
        amharic20 = line4amha.findViewById(R.id.amharic20);
        amharic21 = line4amha.findViewById(R.id.amharic21);
        amharic22  = line4amha.findViewById(R.id.amharic22);
        amharic23 = line4amha.findViewById(R.id.amharic23);
        amharic24 = line4amha.findViewById(R.id.amharic24);
        amharic25 = line4amha.findViewById(R.id. amharic25);
        amharic26 = line4amha.findViewById(R.id.amharic26);
        amharic27 = line4amha.findViewById(R.id.amharic27);
        amharic28 = line5amha.findViewById(R.id.amharic28);
        amharic29 = line5amha.findViewById(R.id.amharic29);
        amharic30 = line5amha.findViewById(R.id.amharic30);
        amharic31 = line5amha.findViewById(R.id.amharic31);
        amharic32 = line5amha.findViewById(R.id.amharic32);
        amharic33 = line5amha.findViewById(R.id.amharic33);
        amharic111 = findViewById(R.id.amharic111);

        //sub amharic letter
        amharicSub1 = line1amha.findViewById(R.id.amharicSub1);
        amharicSub2 = line1amha.findViewById(R.id.amharicSub2);
        amharicSub3 = line1amha.findViewById(R.id.amharicSub3);
        amharicSub4 = line1amha.findViewById(R.id.amharicSub4);
        amharicSub5 = line1amha.findViewById(R.id.amharicSub5);
        amharicSub6 = line1amha.findViewById(R.id.amharicSub6);
        amharicSub7 = line1amha.findViewById(R.id.amharicSub7);

        //for language hadling
        alphaLang = line4eng.findViewById(R.id.alphaLang);


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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            alphaKeyboard.setBackgroundTintList(ColorStateList.valueOf(bgcolor));
        }
        //handling the sound icon
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

        /**
         * when click english letters
         * */
        alphaA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetters(alphaA.getText().toString());
            }
        });

        alphaB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetters(alphaB.getText().toString());
            }
        });

        alphaC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetters(alphaC.getText().toString());
            }
        });

        alphaD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetters(alphaD.getText().toString());
            }
        });

        alphaE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetters(alphaE.getText().toString());
            }
        });

        alphaF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetters(alphaF.getText().toString());
            }
        });

        alphaG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetters(alphaG.getText().toString());
            }
        });

        alphaH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetters(alphaH.getText().toString());
            }
        });

        alphaI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetters(alphaI.getText().toString());
            }
        });

        alphaJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetters(alphaJ.getText().toString());
            }
        });

        alphaK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetters(alphaK.getText().toString());
            }
        });

        alphaL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetters(alphaL.getText().toString());
            }
        });
        alphaM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetters(alphaM.getText().toString());
            }
        });

        alphaN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetters(alphaN.getText().toString());
            }
        });

        alphaO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetters(alphaO.getText().toString());
            }
        });

        alphaP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetters(alphaP.getText().toString());
            }
        });

        alphaQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetters(alphaQ.getText().toString());
            }
        });

        alphaR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetters(alphaR.getText().toString());
            }
        });

        alphaS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetters(alphaS.getText().toString());
            }
        });

        alphaT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetters(alphaT.getText().toString());
            }
        });

        alphaU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetters(alphaU.getText().toString());
            }
        });

        alphaV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetters(alphaV.getText().toString());
            }
        });

        alphaW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetters(alphaW.getText().toString());
            }
        });
        alphaX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetters(alphaX.getText().toString());
            }
        });

        alphaY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetters(alphaY.getText().toString());
            }
        });

        //give space
        specerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetters(" ");
            }
        });

        alphaZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetters(alphaZ.getText().toString());
            }
        });

        //handle last delete
        backSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteLast();
            }
        });


        /**
         * Change Amharic letter
         *
         * */
        //sub amharic letter
        amharicSub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteLast();
                changeLetterAmharic(amharicSub1.getText().toString());
            }
        });
        amharicSub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteLast();
                changeLetterAmharic(amharicSub2.getText().toString());
            }
        });
        amharicSub3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteLast();
                changeLetterAmharic(amharicSub3.getText().toString());
            }
        });
        amharicSub4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteLast();
                changeLetterAmharic(amharicSub4.getText().toString());
            }
        });
        amharicSub5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteLast();
                changeLetterAmharic(amharicSub5.getText().toString());
            }
        });
        amharicSub6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteLast();
                changeLetterAmharic(amharicSub6.getText().toString());
            }
        });
        amharicSub7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteLast();
                changeLetterAmharic(amharicSub7.getText().toString());
            }
        });

        //main amharic letter
        amharic1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetterAmharic(amharic1.getText().toString());
                amharicSub1.setText("ሀ");
                amharicSub2.setText("ሁ");
                amharicSub3.setText("ሂ");
                amharicSub4.setText("ሃ");
                amharicSub5.setText("ሄ");
                amharicSub6.setText("ህ");
                amharicSub7.setText("ሆ");
            }
        });
        // Create LayoutParams to set the margins
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        amharic2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetterAmharic(amharic2.getText().toString());
                amharicSub1.setText("ለ");
                amharicSub2.setText("ሉ");
                amharicSub3.setText("ሊ");
                amharicSub4.setText("ላ");
                amharicSub5.setText("ሌ");
                amharicSub6.setText("ል");
                amharicSub7.setText("ሎ");
            }
        });
        amharic3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetterAmharic(amharic3.getText().toString());
                amharicSub1.setText("ሐ");
                amharicSub2.setText("ሑ");
                amharicSub3.setText("ሒ");
                amharicSub4.setText("ሓ");
                amharicSub5.setText("ሔ");
                amharicSub6.setText("ሕ");
                amharicSub7.setText("ሖ");
            }
        });
        amharic4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetterAmharic(amharic4.getText().toString());
                amharicSub1.setText("መ");
                amharicSub2.setText("ሙ");
                amharicSub3.setText("ሚ");
                amharicSub4.setText("ማ");
                amharicSub5.setText("ሜ");
                amharicSub6.setText("ም");
                amharicSub7.setText("ሞ");
            }
        });
        amharic5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetterAmharic(amharic5.getText().toString());
                amharicSub1.setText("ሠ");
                amharicSub2.setText("ሡ");
                amharicSub3.setText("ሢ");
                amharicSub4.setText("ሣ");
                amharicSub5.setText("ሤ");
                amharicSub6.setText("ሥ");
                amharicSub7.setText("ሦ");
            }
        });
        amharic6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetterAmharic(amharic6.getText().toString());
                amharicSub1.setText("ረ");
                amharicSub2.setText("ሩ");
                amharicSub3.setText("ሪ");
                amharicSub4.setText("ራ");
                amharicSub5.setText("ሬ");
                amharicSub6.setText("ር");
                amharicSub7.setText("ሮ");
            }
        });
        amharic7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetterAmharic(amharic7.getText().toString());
                amharicSub1.setText("ሰ");
                amharicSub2.setText("ሱ");
                amharicSub3.setText("ሲ");
                amharicSub4.setText("ሳ");
                amharicSub5.setText("ሴ");
                amharicSub6.setText("ስ");
                amharicSub7.setText("ሶ");
            }
        });
        amharic8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetterAmharic(amharic8.getText().toString());
                amharicSub1.setText("ሸ");
                amharicSub2.setText("ሹ");
                amharicSub3.setText("ሺ");
                amharicSub4.setText("ሻ");
                amharicSub5.setText("ሼ");
                amharicSub6.setText("ሽ");
                amharicSub7.setText("ሾ");
            }
        });
        amharic9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetterAmharic(amharic9.getText().toString());
                amharicSub1.setText("ቀ");
                amharicSub2.setText("ቁ");
                amharicSub3.setText("ቂ");
                amharicSub4.setText("ቃ");
                amharicSub5.setText("ቄ");
                amharicSub6.setText("ቅ");
                amharicSub7.setText("ቆ");
            }
        });
        amharic10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetterAmharic(amharic10.getText().toString());
                amharicSub1.setText("በ");
                amharicSub2.setText("ቡ");
                amharicSub3.setText("ቢ");
                amharicSub4.setText("ባ");
                amharicSub5.setText("ቤ");
                amharicSub6.setText("ብ");
                amharicSub7.setText("ቦ");
            }
        });
        amharic11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetterAmharic(amharic11.getText().toString());
                amharicSub1.setText("ተ");
                amharicSub2.setText("ቱ");
                amharicSub3.setText("ቲ");
                amharicSub4.setText("ታ");
                amharicSub5.setText("ቴ");
                amharicSub6.setText("ት");
                amharicSub7.setText("ቶ");
            }
        });
        amharic12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetterAmharic(amharic12.getText().toString());
                amharicSub1.setText("ቸ");
                amharicSub2.setText("ቹ");
                amharicSub3.setText("ቺ");
                amharicSub4.setText("ቻ");
                amharicSub5.setText("ቼ");
                amharicSub6.setText("ች");
                amharicSub7.setText("ቾ");
            }
        });
        amharic13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetterAmharic(amharic13.getText().toString());
                amharicSub1.setText("ኀ");
                amharicSub2.setText("ኁ");
                amharicSub3.setText("ኂ");
                amharicSub4.setText("ኃ");
                amharicSub5.setText("ኄ");
                amharicSub6.setText("ኅ");
                amharicSub7.setText("ኆ");
            }
        });
        amharic14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetterAmharic(amharic14.getText().toString());
                amharicSub1.setText("ነ");
                amharicSub2.setText("ኑ");
                amharicSub3.setText("ኒ");
                amharicSub4.setText("ና");
                amharicSub5.setText("ኔ");
                amharicSub6.setText("ን");
                amharicSub7.setText("ኖ");
            }
        });
        amharic15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetterAmharic(amharic15.getText().toString());
                amharicSub1.setText("ኘ");
                amharicSub2.setText("ኙ");
                amharicSub3.setText("ኚ");
                amharicSub4.setText("ኛ");
                amharicSub5.setText("ኜ");
                amharicSub6.setText("ኚ");
                amharicSub7.setText("ኞ");
            }
        });
        amharic16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetterAmharic(amharic16.getText().toString());
                amharicSub1.setText("አ");
                amharicSub2.setText("ኡ");
                amharicSub3.setText("ኢ");
                amharicSub4.setText("ኣ");
                amharicSub5.setText("ኤ");
                amharicSub6.setText("እ");
                amharicSub7.setText("ኦ");
            }
        });
        amharic17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetterAmharic(amharic17.getText().toString());
                amharicSub1.setText("ከ");
                amharicSub2.setText("ኩ");
                amharicSub3.setText("ኪ");
                amharicSub4.setText("ካ");
                amharicSub5.setText("ኬ");
                amharicSub6.setText("ክ");
                amharicSub7.setText("ኮ");
            }
        });
        amharic18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetterAmharic(amharic18.getText().toString());
                amharicSub1.setText("ኸ");
                amharicSub2.setText("ኹ");
                amharicSub3.setText("ኺ");
                amharicSub4.setText("ኻ");
                amharicSub5.setText("ኼ");
                amharicSub6.setText("ኽ");
                amharicSub7.setText("ኾ");
            }
        });
        amharic19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetterAmharic(amharic19.getText().toString());
                amharicSub1.setText("ወ");
                amharicSub2.setText("ዉ");
                amharicSub3.setText("ዊ");
                amharicSub4.setText("ዋ");
                amharicSub5.setText("ዌ");
                amharicSub6.setText("ው");
                amharicSub7.setText("ዎ");
            }
        });
        amharic20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetterAmharic(amharic20.getText().toString());
                amharicSub1.setText("ዐ");
                amharicSub2.setText("ዑ");
                amharicSub3.setText("ዒ");
                amharicSub4.setText("ዓ");
                amharicSub5.setText("ዔ");
                amharicSub6.setText("ዕ");
                amharicSub7.setText("ዖ");
            }
        });
        amharic21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetterAmharic(amharic21.getText().toString());
                amharicSub1.setText("ዘ");
                amharicSub2.setText("ዙ");
                amharicSub3.setText("ዚ");
                amharicSub4.setText("ዛ");
                amharicSub5.setText("ዜ");
                amharicSub6.setText("ዝ");
                amharicSub7.setText("ዞ");
            }
        });
        amharic22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetterAmharic(amharic22.getText().toString());
                amharicSub1.setText("ዠ");
                amharicSub2.setText("ዡ");
                amharicSub3.setText("ዢ");
                amharicSub4.setText("ዣ");
                amharicSub5.setText("ዤ");
                amharicSub6.setText("ዥ");
                amharicSub7.setText("ዦ");
            }
        });
        amharic23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetterAmharic(amharic23.getText().toString());
                amharicSub1.setText("የ");
                amharicSub2.setText("ዩ");
                amharicSub3.setText("ዪ");
                amharicSub4.setText("ያ");
                amharicSub5.setText("ዬ");
                amharicSub6.setText("ይ");
                amharicSub7.setText("ዮ");
            }
        });
        amharic24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetterAmharic(amharic24.getText().toString());
                amharicSub1.setText("ደ");
                amharicSub2.setText("ዱ");
                amharicSub3.setText("ዲ");
                amharicSub4.setText("ዳ");
                amharicSub5.setText("ዴ");
                amharicSub6.setText("ድ");
                amharicSub7.setText("ዶ");
            }
        });
        amharic25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetterAmharic(amharic25.getText().toString());
                amharicSub1.setText("ጀ");
                amharicSub2.setText("ጁ");
                amharicSub3.setText("ጂ");
                amharicSub4.setText("ጃ");
                amharicSub5.setText("ጄ");
                amharicSub6.setText("ጅ");
                amharicSub7.setText("ጆ");
            }
        });
        amharic26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetterAmharic(amharic26.getText().toString());
                amharicSub1.setText("ገ");
                amharicSub2.setText("ጉ");
                amharicSub3.setText("ጊ");
                amharicSub4.setText("ጋ");
                amharicSub5.setText("ጌ");
                amharicSub6.setText("ግ");
                amharicSub7.setText("ጎ");
            }
        });
        amharic27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetterAmharic(amharic27.getText().toString());
                amharicSub1.setText("ጠ");
                amharicSub2.setText("ጡ");
                amharicSub3.setText("ጢ");
                amharicSub4.setText("ጣ");
                amharicSub5.setText("ጤ");
                amharicSub6.setText("ጥ");
                amharicSub7.setText("ጦ");
            }
        });
        amharic28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetterAmharic(amharic28.getText().toString());
                amharicSub1.setText("ጨ");
                amharicSub2.setText("ጩ");
                amharicSub3.setText("ጪ");
                amharicSub4.setText("ጫ");
                amharicSub5.setText("ጬ");
                amharicSub6.setText("ጭ");
                amharicSub7.setText("ጮ");
            }
        });
        amharic29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetterAmharic(amharic29.getText().toString());
                amharicSub1.setText("ጰ");
                amharicSub2.setText("ጱ");
                amharicSub3.setText("ጲ");
                amharicSub4.setText("ጳ");
                amharicSub5.setText("ጴ");
                amharicSub6.setText("ጵ");
                amharicSub7.setText("ጶ");
            }
        });
        amharic30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetterAmharic(amharic30.getText().toString());
                amharicSub1.setText("ጸ");
                amharicSub2.setText("ጹ");
                amharicSub3.setText("ጺ");
                amharicSub4.setText("ጻ");
                amharicSub5.setText("ጼ");
                amharicSub6.setText("ጽ");
                amharicSub7.setText("ጾ");
            }
        });
        amharic31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetterAmharic(amharic31.getText().toString());
                amharicSub1.setText("ፀ");
                amharicSub2.setText("ፁ");
                amharicSub3.setText("ፂ");
                amharicSub4.setText("ፃ");
                amharicSub5.setText("ፄ");
                amharicSub6.setText("ፅ");
                amharicSub7.setText("ፆ");
            }
        });
        amharic32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetterAmharic(amharic32.getText().toString());
                amharicSub1.setText("ፈ");
                amharicSub2.setText("ፉ");
                amharicSub3.setText("ፊ");
                amharicSub4.setText("ፋ");
                amharicSub5.setText("ፌ");
                amharicSub6.setText("ፍ");
                amharicSub7.setText("ፎ");
            }
        });
        amharic33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetterAmharic(amharic33.getText().toString());
                amharicSub1.setText("ፐ");
                amharicSub2.setText("ፑ");
                amharicSub3.setText("ፒ");
                amharicSub4.setText("ፓ");
                amharicSub5.setText("ፔ");
                amharicSub6.setText("ፕ");
                amharicSub7.setText("ፖ");
            }
        });

        amharic111.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLetterAmharic(amharic111.getText().toString());
                amharicSub1.setText("ቨ");
                amharicSub2.setText("ቩ");
                amharicSub3.setText("ቪ");
                amharicSub4.setText("ቫ");
                amharicSub5.setText("ቬ");
                amharicSub6.setText("ቭ");
                amharicSub7.setText("ቮ");
            }
        });

        //changing language keyboard
        alphaLang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(langCount %  2 !=0){

                    lang = false;
                    layoutParams.setMargins(5, 730, 5, 0);
                    // Apply LayoutParams to the LinearLayout
                    alphaKeyboard.setLayoutParams(layoutParams);

                    line1amha.setVisibility(View.GONE);
                    line2amha.setVisibility(View.GONE);
                    line3amha.setVisibility(View.GONE);
                    line4amha.setVisibility(View.GONE);
                    line5amha.setVisibility(View.GONE);

                    line1eng.setVisibility(View.VISIBLE);
                    line2eng.setVisibility(View.VISIBLE);
                    line3eng.setVisibility(View.VISIBLE);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        alphaLang.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
                    }
                    alphaLang.setTextColor(Color.BLACK);
                    alphaLang.setText("ENG");
                    alphaLang.setTextColor(Color.BLACK);

                }else{
                    lang = true;
                    layoutParams.setMargins(5, 510, 5, 0);
                    // Apply LayoutParams to the LinearLayout
                    alphaKeyboard.setLayoutParams(layoutParams);
                    line1eng.setVisibility(View.GONE);
                    line2eng.setVisibility(View.GONE);
                    line3eng.setVisibility(View.GONE);


                    line1amha.setVisibility(View.VISIBLE);
                    line2amha.setVisibility(View.VISIBLE);
                    line3amha.setVisibility(View.VISIBLE);
                    line4amha.setVisibility(View.VISIBLE);
                    line5amha.setVisibility(View.VISIBLE);

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        alphaLang.setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));
                    }
                    String hexColor = "#0f7af0";
                    alphaLang.setTextColor(Color.parseColor(hexColor));
                    alphaLang.setText("AMH");
                    alphaLang.setTextColor(Color.WHITE);
                }
                langCount++;
            }
        });

        capitalLetter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (upperCounter % 2 != 0){
                    changeLetter();
                    upperBool = false;


                }else {
                    changeLetter();
                    upperBool = true;

                }
                upperCounter++;
            }
        });


    }
    //for capital letter
    void changeLetter(){
        if(upperBool){
            alphaA.setAllCaps(false);
            alphaB.setAllCaps(false);
            alphaC.setAllCaps(false);
            alphaD.setAllCaps(false);
            alphaE.setAllCaps(false);
            alphaF.setAllCaps(false);
            alphaG.setAllCaps(false);
            alphaH.setAllCaps(false);
            alphaI.setAllCaps(false);
            alphaJ.setAllCaps(false);
            alphaK.setAllCaps(false);
            alphaL.setAllCaps(false);
            alphaM.setAllCaps(false);
            alphaN.setAllCaps(false);
            alphaO.setAllCaps(false);
            alphaP.setAllCaps(false);
            alphaQ.setAllCaps(false);
            alphaR.setAllCaps(false);
            alphaS.setAllCaps(false);
            alphaT.setAllCaps(false);
            alphaU.setAllCaps(false);
            alphaV.setAllCaps(false);
            alphaW.setAllCaps(false);
            alphaX.setAllCaps(false);
            alphaY.setAllCaps(false);
            alphaZ.setAllCaps(false);
        }else{
            alphaA.setAllCaps(true);
            alphaB.setAllCaps(true);
            alphaC.setAllCaps(true);
            alphaD.setAllCaps(true);
            alphaE.setAllCaps(true);
            alphaF.setAllCaps(true);
            alphaG.setAllCaps(true);
            alphaH.setAllCaps(true);
            alphaI.setAllCaps(true);
            alphaJ.setAllCaps(true);
            alphaK.setAllCaps(true);
            alphaL.setAllCaps(true);
            alphaM.setAllCaps(true);
            alphaN.setAllCaps(true);
            alphaO.setAllCaps(true);
            alphaP.setAllCaps(true);
            alphaQ.setAllCaps(true);
            alphaR.setAllCaps(true);
            alphaS.setAllCaps(true);
            alphaT.setAllCaps(true);
            alphaU.setAllCaps(true);
            alphaV.setAllCaps(true);
            alphaW.setAllCaps(true);
            alphaX.setAllCaps(true);
            alphaY.setAllCaps(true);
            alphaZ.setAllCaps(true);
        }
    }

    //Change letter
    private void changeLetters(String txt){
        StringBuilder stringBuilder = new StringBuilder();
        String str;
        str = wordTxt.getText().toString();
        if(str.length()  < 14) {
            // Append to StringBuilder
            stringBuilder.append(str);
            stringBuilder.append(txt);
            str = stringBuilder.toString();
            wordTxt.setText(str);
        }

        if(!upperBool){
            wordTxt.setAllCaps(false);
        }else {
            wordTxt.setAllCaps(true);
        }
    }

    //Change amharic letter
    private void  changeLetterAmharic(String txt){
        StringBuilder stringBuilder = new StringBuilder();
        String str;
        str = wordTxt.getText().toString();
        if(str.length()  < 14) {
            // Append to StringBuilder
            stringBuilder.append(str);
            stringBuilder.append(txt);
            str = stringBuilder.toString();
            wordTxt.setText(str);
        }
    }

    private void deleteLast(){
        String orginalString = wordTxt.getText().toString();
        if (!orginalString.isEmpty()) {
            String modifiedString = orginalString.substring(0,orginalString.length()-1);
            wordTxt.setText(modifiedString);
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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            alphaKeyboard.setBackgroundTintList(ColorStateList.valueOf(color));
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
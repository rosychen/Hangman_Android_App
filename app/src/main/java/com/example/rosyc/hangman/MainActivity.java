package com.example.rosyc.hangman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Button letterA;
    private Button letterB;
    private Button letterC;
    private Button letterD;
    private Button letterE;
    private Button letterF;
    private Button letterG;
    private Button letterH;
    private Button letterI;
    private Button letterJ;
    private Button letterK;
    private Button letterL;
    private Button letterM;
    private Button letterN;
    private Button letterO;
    private Button letterP;
    private Button letterQ;
    private Button letterR;
    private Button letterS;
    private Button letterT;
    private Button letterU;
    private Button letterV;
    private Button letterW;
    private Button letterX;
    private Button letterY;
    private Button letterZ;
    private Button new_game;
    private TextView hint;
    private TextView answer;
    private TextView man;

    private int incorrectAnswer;
    private boolean victoryStatus;
    private secret_word secret_word_class;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        letterA = (Button) findViewById(R.id.A);
        letterB = (Button) findViewById(R.id.B);
        letterC = (Button) findViewById(R.id.C);
        letterD = (Button) findViewById(R.id.D);
        letterE = (Button) findViewById(R.id.E);
        letterF = (Button) findViewById(R.id.F);
        letterG = (Button) findViewById(R.id.G);
        letterH = (Button) findViewById(R.id.H);
        letterI = (Button) findViewById(R.id.I);
        letterJ = (Button) findViewById(R.id.J);
        letterK = (Button) findViewById(R.id.K);
        letterL = (Button) findViewById(R.id.L);
        letterM = (Button) findViewById(R.id.M);
        letterN = (Button) findViewById(R.id.N);
        letterO = (Button) findViewById(R.id.O);
        letterP = (Button) findViewById(R.id.P);
        letterQ = (Button) findViewById(R.id.Q);
        letterR = (Button) findViewById(R.id.R);
        letterS = (Button) findViewById(R.id.S);
        letterT = (Button) findViewById(R.id.T);
        letterU = (Button) findViewById(R.id.U);
        letterV = (Button) findViewById(R.id.V);
        letterW = (Button) findViewById(R.id.W);
        letterX = (Button) findViewById(R.id.X);
        letterY = (Button) findViewById(R.id.Y);
        letterZ = (Button) findViewById(R.id.Z);

        man = (TextView) findViewById(R.id.hangman);
        new_game = (Button) findViewById(R.id.start_over);
        hint = (TextView) findViewById(R.id.hint);
        answer = (TextView) findViewById(R.id.answer);

        /*if (savedInstanceState != null) {
            secret_word secret_word_class = new secret_word(savedInstanceState.getString("hint"), savedInstanceState.getString("answer"));

            answer.setText(savedInstanceState.getString("answer"));
            hint.setText(savedInstanceState.getString("hint"));

            letterA.setEnabled(savedInstanceState.getBoolean("A"));
            letterA.setOnClickListener(btnListener);
            letterB.setEnabled(savedInstanceState.getBoolean("B"));
            letterB.setOnClickListener(btnListener);
            letterC.setEnabled(savedInstanceState.getBoolean("C"));
            letterD.setEnabled(savedInstanceState.getBoolean("D"));
            letterE.setEnabled(savedInstanceState.getBoolean("E"));
            letterF.setEnabled(savedInstanceState.getBoolean("F"));
            letterG.setEnabled(savedInstanceState.getBoolean("G"));
            letterH.setEnabled(savedInstanceState.getBoolean("H"));
            letterI.setEnabled(savedInstanceState.getBoolean("I"));
            letterJ.setEnabled(savedInstanceState.getBoolean("J"));
            letterK.setEnabled(savedInstanceState.getBoolean("K"));
            letterL.setEnabled(savedInstanceState.getBoolean("L"));
            letterM.setEnabled(savedInstanceState.getBoolean("M"));
            letterN.setEnabled(savedInstanceState.getBoolean("N"));
            letterO.setEnabled(savedInstanceState.getBoolean("O"));
            letterP.setEnabled(savedInstanceState.getBoolean("P"));
            letterQ.setEnabled(savedInstanceState.getBoolean("Q"));
            letterR.setEnabled(savedInstanceState.getBoolean("R"));
            letterS.setEnabled(savedInstanceState.getBoolean("S"));
            letterT.setEnabled(savedInstanceState.getBoolean("T"));
            letterU.setEnabled(savedInstanceState.getBoolean("U"));
            letterV.setEnabled(savedInstanceState.getBoolean("V"));
            letterW.setEnabled(savedInstanceState.getBoolean("W"));
            letterX.setEnabled(savedInstanceState.getBoolean("X"));
            letterY.setEnabled(savedInstanceState.getBoolean("Y"));
            letterZ.setEnabled(savedInstanceState.getBoolean("Z"));


            incorrectAnswer = savedInstanceState.getInt("numberIncorrect");

            if (incorrectAnswer == 0) {
                man.setBackground(getResources().getDrawable(R.drawable.man_0, null));
            } else if (incorrectAnswer == 1) {
                man.setBackground(getResources().getDrawable(R.drawable.man_1, null));
            } else if (incorrectAnswer == 2) {
                man.setBackground(getResources().getDrawable(R.drawable.man_2, null));
            } else if (incorrectAnswer == 3) {
                man.setBackground(getResources().getDrawable(R.drawable.man_3, null));
            } else if (incorrectAnswer == 4) {
                man.setBackground(getResources().getDrawable(R.drawable.man_4, null));
            } else if (incorrectAnswer == 5) {
                man.setBackground(getResources().getDrawable(R.drawable.man_5, null));
            }
        }
        else{
        */
        secret_word_class = new secret_word();
        answer.setText(secret_word_class.getWord());
        hint.setText(secret_word_class.getHint());
        //}

    }

    private View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            goGuess(v);
            System.out.print(v.getId());
        }
    };

    @Override
    protected void onSaveInstanceState (Bundle savedInstanceState) {

        savedInstanceState.putString("answer", answer.getText().toString());
        savedInstanceState.putString("hint", hint.getText().toString());

        savedInstanceState.putBoolean("A", letterA.isEnabled());
        savedInstanceState.putBoolean("B", letterB.isEnabled());
        savedInstanceState.putBoolean("C", letterC.isEnabled());
        savedInstanceState.putBoolean("D", letterD.isEnabled());
        savedInstanceState.putBoolean("E", letterE.isEnabled());
        savedInstanceState.putBoolean("F", letterF.isEnabled());
        savedInstanceState.putBoolean("G", letterG.isEnabled());
        savedInstanceState.putBoolean("H", letterH.isEnabled());
        savedInstanceState.putBoolean("I", letterI.isEnabled());
        savedInstanceState.putBoolean("J", letterJ.isEnabled());
        savedInstanceState.putBoolean("K", letterK.isEnabled());
        savedInstanceState.putBoolean("L", letterL.isEnabled());
        savedInstanceState.putBoolean("M", letterM.isEnabled());
        savedInstanceState.putBoolean("N", letterN.isEnabled());
        savedInstanceState.putBoolean("O", letterO.isEnabled());
        savedInstanceState.putBoolean("P", letterP.isEnabled());
        savedInstanceState.putBoolean("Q", letterQ.isEnabled());
        savedInstanceState.putBoolean("R", letterR.isEnabled());
        savedInstanceState.putBoolean("S", letterS.isEnabled());
        savedInstanceState.putBoolean("T", letterT.isEnabled());
        savedInstanceState.putBoolean("U", letterU.isEnabled());
        savedInstanceState.putBoolean("V", letterV.isEnabled());
        savedInstanceState.putBoolean("W", letterW.isEnabled());
        savedInstanceState.putBoolean("X", letterX.isEnabled());
        savedInstanceState.putBoolean("Y", letterY.isEnabled());
        savedInstanceState.putBoolean("Z", letterZ.isEnabled());
        savedInstanceState.putInt("numberIncorrect", incorrectAnswer);

        savedInstanceState.putString("hangman", man.getBackground().toString());
        super.onSaveInstanceState(savedInstanceState);
    }



    public void goGuess(View v) {
        switch (v.getId()) {
            case R.id.A:
                letterA.setEnabled(false);
                secret_word_class.checkLetter('a');
                break;
            case R.id.B:
                letterB.setEnabled(false);
                secret_word_class.checkLetter('b');
                break;
            case R.id.C:
                letterC.setEnabled(false);
                secret_word_class.checkLetter('c');
                break;
            case R.id.D:
                letterD.setEnabled(false);
                secret_word_class.checkLetter('d');
                break;
            case R.id.E:
                letterE.setEnabled(false);
                secret_word_class.checkLetter('e');
                break;
            case R.id.F:
                letterF.setEnabled(false);
                secret_word_class.checkLetter('f');
                break;
            case R.id.G:
                letterG.setEnabled(false);
                secret_word_class.checkLetter('g');
                break;
            case R.id.H:
                letterH.setEnabled(false);
                secret_word_class.checkLetter('h');
                break;
            case R.id.I:
                letterI.setEnabled(false);
                secret_word_class.checkLetter('i');
                break;
            case R.id.J:
                letterJ.setEnabled(false);
                secret_word_class.checkLetter('j');
                break;
            case R.id.K:
                letterK.setEnabled(false);
                secret_word_class.checkLetter('k');
                break;
            case R.id.L:
                letterL.setEnabled(false);
                secret_word_class.checkLetter('l');
                break;
            case R.id.M:
                letterM.setEnabled(false);
                secret_word_class.checkLetter('m');
                break;
            case R.id.N:
                letterN.setEnabled(false);
                secret_word_class.checkLetter('n');
                break;
            case R.id.O:
                letterO.setEnabled(false);
                secret_word_class.checkLetter('o');
                break;
            case R.id.P:
                letterP.setEnabled(false);
                secret_word_class.checkLetter('p');
                break;
            case R.id.Q:
                letterQ.setEnabled(false);
                secret_word_class.checkLetter('q');
                break;
            case R.id.R:
                letterR.setEnabled(false);
                secret_word_class.checkLetter('r');
                break;
            case R.id.S:
                letterS.setEnabled(false);
                secret_word_class.checkLetter('s');
                break;
            case R.id.T:
                letterT.setEnabled(false);
                secret_word_class.checkLetter('t');
                break;
            case R.id.U:
                letterU.setEnabled(false);
                secret_word_class.checkLetter('u');
                break;
            case R.id.V:
                letterV.setEnabled(false);
                secret_word_class.checkLetter('v');
                break;
            case R.id.W:
                letterW.setEnabled(false);
                secret_word_class.checkLetter('w');
                break;
            case R.id.X:
                letterX.setEnabled(false);
                secret_word_class.checkLetter('x');
                break;
            case R.id.Y:
                letterY.setEnabled(false);
                secret_word_class.checkLetter('y');
                break;
            case R.id.Z:
                letterZ.setEnabled(false);
                secret_word_class.checkLetter('z');
                break;
        }
        answer.setText(secret_word_class.getWord());


        victoryStatus = secret_word_class.getVictoryStatus();

        if (victoryStatus == true){
            Toast.makeText(MainActivity.this, "Congratulations, you win!\nPress \"New Game\" to start a new game.", Toast.LENGTH_LONG).show();
            letterA.setEnabled(false);
            letterB.setEnabled(false);
            letterC.setEnabled(false);
            letterD.setEnabled(false);
            letterE.setEnabled(false);
            letterF.setEnabled(false);
            letterG.setEnabled(false);
            letterH.setEnabled(false);
            letterI.setEnabled(false);
            letterJ.setEnabled(false);
            letterK.setEnabled(false);
            letterL.setEnabled(false);
            letterM.setEnabled(false);
            letterN.setEnabled(false);
            letterO.setEnabled(false);
            letterP.setEnabled(false);
            letterQ.setEnabled(false);
            letterR.setEnabled(false);
            letterS.setEnabled(false);
            letterT.setEnabled(false);
            letterU.setEnabled(false);
            letterV.setEnabled(false);
            letterW.setEnabled(false);
            letterX.setEnabled(false);
            letterY.setEnabled(false);
            letterZ.setEnabled(false);
        }

        incorrectAnswer = secret_word_class.getNumberWrong();
        if (incorrectAnswer == 0){
            man.setBackground(getResources().getDrawable(R.drawable.man_0, null));
        }
        else if (incorrectAnswer == 1){
            man.setBackground(getResources().getDrawable(R.drawable.man_1, null));
        }
        else if (incorrectAnswer == 2){
            man.setBackground(getResources().getDrawable(R.drawable.man_2, null));
        }
        else if (incorrectAnswer == 3){
            man.setBackground(getResources().getDrawable(R.drawable.man_3, null));
        }
        else if (incorrectAnswer == 4){
            man.setBackground(getResources().getDrawable(R.drawable.man_4, null));
        }
        else if (incorrectAnswer == 5){
            man.setBackground(getResources().getDrawable(R.drawable.man_5, null));
        }
        else{
            man.setBackground(getResources().getDrawable(R.drawable.man_6, null));
            Toast.makeText(MainActivity.this, "Sorry, you lost.\nPress \"New Game\" to start a new game.", Toast.LENGTH_LONG).show();
            letterA.setEnabled(false);
            letterB.setEnabled(false);
            letterC.setEnabled(false);
            letterD.setEnabled(false);
            letterE.setEnabled(false);
            letterF.setEnabled(false);
            letterG.setEnabled(false);
            letterH.setEnabled(false);
            letterI.setEnabled(false);
            letterJ.setEnabled(false);
            letterK.setEnabled(false);
            letterL.setEnabled(false);
            letterM.setEnabled(false);
            letterN.setEnabled(false);
            letterO.setEnabled(false);
            letterP.setEnabled(false);
            letterQ.setEnabled(false);
            letterR.setEnabled(false);
            letterS.setEnabled(false);
            letterT.setEnabled(false);
            letterU.setEnabled(false);
            letterV.setEnabled(false);
            letterW.setEnabled(false);
            letterX.setEnabled(false);
            letterY.setEnabled(false);
            letterZ.setEnabled(false);
        }
    }

    public void goRestart(View view){
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
}
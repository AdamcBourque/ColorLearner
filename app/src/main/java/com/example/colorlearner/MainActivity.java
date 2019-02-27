package com.example.colorlearner;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        update_display(null);
        addListener();
    }
    private void addListener(){
        EditText.OnEditorActionListener listener = new EditText.OnEditorActionListener(){
            @Override
            public boolean onEditorAction(TextView v, int actionID, KeyEvent event){
                if (actionID == EditorInfo.IME_ACTION_DONE){
                    rightColor(getCurrentFocus());
                    hideKeyboardFrom(getApplicationContext(), getCurrentFocus());
                    return true;
                }else{
                    return false;
                }
            }
        };
        EditText top1 = findViewById(R.id.top1);
        top1.setOnEditorActionListener(listener);
        EditText top2 = findViewById(R.id.top2);
        top2.setOnEditorActionListener(listener);
        EditText top3 = findViewById(R.id.top3);
        top3.setOnEditorActionListener(listener);
        EditText top4 = findViewById(R.id.top4);
        top4.setOnEditorActionListener(listener);
        EditText top5 = findViewById(R.id.top5);
        top5.setOnEditorActionListener(listener);
        EditText top6 = findViewById(R.id.top6);
        top6.setOnEditorActionListener(listener);
    }
    public String[] colors = {"RED", "BLUE", "GREEN", "PINK", "WHITE","BLACK", "PURPLE", "ORANGE"};
    public String c1, c2, c3, c4, c5, c6;
    private void setColorByName(String c, View view){
        int colorID = getResources().getIdentifier(c,"color",this.getPackageName());
        if (colorID != 0) {
            int color = ContextCompat.getColor(this, colorID);
            view.setBackgroundColor(color);
        }else{
            Toast.makeText(this,"Your color is wrong", Toast.LENGTH_SHORT).show();
        }
    }
    public void update_display(View view){
        int ints[] = {0,0,0,0,0,0};
        int temp;
        for (int i=0; i<6; i++){
            temp = (int)(Math.random()*8);
            for (int j = 0; j<i; j++){
                if (ints[j] == temp){
                    i--;
                }else{
                    ints[i]=temp;
                }
            }
        }
        setColorByName(colors[ints[0]],findViewById(R.id.top1));
        setColorByName(colors[ints[1]],findViewById(R.id.top2));
        setColorByName(colors[ints[2]],findViewById(R.id.top3));
        setColorByName(colors[ints[3]],findViewById(R.id.top4));
        setColorByName(colors[ints[4]],findViewById(R.id.top5));
        setColorByName(colors[ints[5]],findViewById(R.id.top6));
        EditText top1 = findViewById(R.id.top1);
        EditText top2 = findViewById(R.id.top2);
        EditText top3 = findViewById(R.id.top3);
        EditText top4 = findViewById(R.id.top4);
        EditText top5 = findViewById(R.id.top5);
        EditText top6 = findViewById(R.id.top6);
        top1.setText("");
        top2.setText("");
        top3.setText("");
        top4.setText("");
        top5.setText("");
        top6.setText("");
        c1 = colors[ints[0]];
        c2 = colors[ints[1]];
        c3 = colors[ints[2]];
        c4 = colors[ints[3]];
        c5 = colors[ints[4]];
        c6 = colors[ints[5]];
    }
    public void hideKeyboardFrom(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
    private void rightColor(View view){
        int thing = view.getId();
        EditText input = findViewById(thing);
        String name = input.getText().toString().toUpperCase();
        switch (thing){
            case R.id.top1:
                if (name.equalsIgnoreCase(c1)) {
                    Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
                }
            case R.id.top2:
                if (name.equalsIgnoreCase(c2)) {
                    Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
                }
            case R.id.top3:
                if (name.equalsIgnoreCase(c3)) {
                    Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
                }
            case R.id.top4:
                if (name.equalsIgnoreCase(c4)) {
                    Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
                }
            case R.id.top5:
                if (name.equalsIgnoreCase(c5)) {
                    Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
                }
            case R.id.top6:
                if (name.equalsIgnoreCase(c6)) {
                    Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
                }
            }
            hideKeyboardFrom(getApplicationContext(),getCurrentFocus());
        }

    }


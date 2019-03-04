package com.example.colorlearner;

import android.app.Activity;
import android.content.Context;
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

import java.util.*;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        colors.add("GREEN");
        colors.add("RED");
        colors.add("BLUE");
        colors.add("WHITE");
        colors.add("PURPLE");
        colors.add("ORANGE");
        update_display( colors);
        addListener();
    }
    private void addListener(){
        EditText.OnEditorActionListener listener = new EditText.OnEditorActionListener(){
            @Override
            public boolean onEditorAction(TextView v, int actionID, KeyEvent event){
                if (actionID == EditorInfo.IME_ACTION_DONE){
                    rightColor(getCurrentFocus(), colors);
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
    ArrayList<String> colors = new ArrayList<String>();

    private void setColorByName(String c, View view){
        int colorID = getResources().getIdentifier(c,"color",this.getPackageName());
        if (colorID != 0) {
            int color = ContextCompat.getColor(this, colorID);
            view.setBackgroundColor(color);
        }else{
            Toast.makeText(this,"Your color is wrong", Toast.LENGTH_SHORT).show();
        }
    }
    public void update_display( ArrayList colors){
        Collections.shuffle(colors);
        setColorByName((String)colors.get(0),findViewById(R.id.top1));
        setColorByName((String)colors.get(1),findViewById(R.id.top2));
        setColorByName((String)colors.get(2),findViewById(R.id.top3));
        setColorByName((String)colors.get(3),findViewById(R.id.top4));
        setColorByName((String)colors.get(4),findViewById(R.id.top5));
        setColorByName((String)colors.get(5),findViewById(R.id.top6));
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

    }
    public void hideKeyboardFrom(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
    private void rightColor(View view, ArrayList colors){
        String c1 = (String)colors.get(0);
        String c2 = (String)colors.get(1);
        String c3 = (String)colors.get(2);
        String c4 = (String)colors.get(3);
        String c5 = (String)colors.get(4);
        String c6 = (String)colors.get(5);
        int thing = view.getId();
        EditText input = findViewById(thing);
        String name = input.getText().toString().toUpperCase();
        switch (thing){
            case R.id.top1:
                if (name.equalsIgnoreCase(c1)) {
                    Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
                    break;
                }else {
                    Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
                }
            case R.id.top2:
                if (name.equalsIgnoreCase(c2)) {
                    Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
                    break;
                }else {
                    Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
                }
            case R.id.top3:
                if (name.equalsIgnoreCase(c3)) {
                    Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
                    break;
                }else {
                    Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
                }
            case R.id.top4:
                if (name.equalsIgnoreCase(c4)) {
                    Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
                    break;
                }else {
                    Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
                }
            case R.id.top5:
                if (name.equalsIgnoreCase(c5)) {
                    Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
                    break;
                }else {
                    Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
                }
            case R.id.top6:
                if (name.equalsIgnoreCase(c6)) {
                    Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
                    break;
                }else {
                    Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
                }
            }
            hideKeyboardFrom(getApplicationContext(),getCurrentFocus());
        }
        public void click(View view){
            update_display(colors);
        }

    }


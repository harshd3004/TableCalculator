package com.example.tablecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText inpBox;
    float num1=0,num2=0;
    char op;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inpBox=(EditText) findViewById(R.id.txtInp);
    }

    public void buttonClicked(View v){
        Button btn = (Button) findViewById(v.getId());
        String ch = btn.getText().toString();
        int no=-1;
        try {
            no = Integer.parseInt(ch);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(no>=0 && no<=9){
            inpBox.setText(inpBox.getText().toString() + no);
        }
        if(ch.equals(".")){
            inpBox.setText(inpBox.getText().toString() + ch);
        }
        if(ch.equals("00")){
            inpBox.setText(inpBox.getText().toString() + "0");
        }
        if(ch.equals("C")){
            inpBox.setText("");
        }
        if(ch.equals("Del")){
            String str = inpBox.getText().toString();
            str = str.substring(0,str.length()-1);
            inpBox.setText(str);
        }

        if(ch.equals("%") || ch.equals("/") || ch.equals("X")||ch.equals("+")||ch.equals("-")){
            if(inpBox.getText().toString().isEmpty()){
                return;
            }
            num1 = Float.parseFloat(inpBox.getText().toString());
            inpBox.setText("");
            op = ch.charAt(0);
        }

        if(ch.equals("=")){
            num2 = Float.parseFloat(inpBox.getText().toString());
            float res;
            switch (op){
                case '%' : res = num1 %num2;
                            break;
                case 'X' : res = num1 *num2;
                    break;
                case '/' : res = num1 /num2;
                    break;
                case '+' : res = num1 +num2;
                    break;
                case '-' : res = num1 -num2;
                    break;
                default:res = 0;

            }
            inpBox.setText(Float.toString(res));
        }
    }
}
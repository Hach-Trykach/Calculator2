package com.nedoboy.calculator2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    final int MENU_RESET_ID = 1;
    final int MENU_QUIT_ID = 2;

    Button btnAdd, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnSin, btnResult;
    Button btnSub;
    Button btnMult;
    Button btnDiv;

    TextView tvResult;

    String oper = "", pole = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMult = findViewById(R.id.btnMult);
        btnDiv = findViewById(R.id.btnDiv);
        btnSin = findViewById(R.id.btnSin);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn0 = findViewById(R.id.btn0);
        btnResult = findViewById(R.id.btnResult);

        tvResult = findViewById(R.id.tvResult);

// прописываем обработчик
        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btnSin.setOnClickListener(this);
        btnResult.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
// TODO Auto-generated method stub
        float result = 0;

// определяем нажатую кнопку и выполняем соответствующую операцию
// в oper пишем операцию, потом будем использовать в выводе
        switch (v.getId()) {
            case R.id.btnAdd:
                oper = "+";
                pole = tvResult.getText().toString() + oper;
                break;
            case R.id.btnSub:
                oper = "-";
                pole = tvResult.getText().toString() + oper;
                break;
            case R.id.btnMult:
                oper = "*";
                pole = tvResult.getText().toString() + oper;
                break;
            case R.id.btnDiv:
                oper = "/";
                pole = tvResult.getText().toString() + oper;
                break;
            case R.id.btn1:
                oper = "1";
                pole = tvResult.getText().toString() + oper;
                break;
            case R.id.btn2:
                oper = "2";
                pole = tvResult.getText().toString() + oper;
                break;
            case R.id.btn3:
                oper = "3";
                pole = tvResult.getText().toString() + oper;
                break;
            case R.id.btn4:
                oper = "4";
                pole = tvResult.getText().toString() + oper;
                break;
            case R.id.btn5:
                oper = "5";
                pole = tvResult.getText().toString() + oper;
                break;
            case R.id.btn6:
                oper = "6";
                pole = tvResult.getText().toString() + oper;
                break;
            case R.id.btn7:
                oper = "7";
                pole = tvResult.getText().toString() + oper;
                break;
            case R.id.btn8:
                oper = "8";
                pole = tvResult.getText().toString() + oper;
                break;
            case R.id.btn9:
                oper = "9";
                pole = tvResult.getText().toString() + oper;
                break;
            case R.id.btn0:
                oper = "0";
                pole =

                        tvResult.getText().toString() + oper;
                break;
            case R.id.btnResult:
// result = num1 / num2;
// tvResult.setText((int) Float.parseFloat(pole));

                String[] lines = pole.split( "\n" );

                float total = Float.parseFloat( lines[0].trim() ); //We know this is a number.

                for( int i = 1; i < lines.length; i++ ) {
                    total = calculate( lines[i].trim(), (int) total);
                }
                break;
            case R.id.btnSin:
                oper = String.valueOf(Math.sin(Double.parseDouble(String.valueOf(result))));
                break;
            default:
                break;
        }

// формируем строку вывода
        tvResult.setText(pole);
    }
    private int calculate(String input, int total ) {
        switch( input.charAt( 0 ) ) {
            case '+':
                return total + Integer.parseInt( input.substring(1));
            case '-':
                return total - Integer.parseInt( input.substring(1));
            case '*':
                return total * Integer.parseInt( input.substring(1));
            case '/':
                return total / Integer.parseInt( input.substring(1));
        }
        return total;
    }

    // создание меню
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, MENU_RESET_ID, 0, "Reset");
        menu.add(0, MENU_QUIT_ID, 0, "Quit");
        return super.onCreateOptionsMenu(menu);
    }

    // обработка нажатий на пункты меню
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENU_RESET_ID:
// очищаем поля
                tvResult.setText("");
                break;
            case MENU_QUIT_ID:
// выход из приложения
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

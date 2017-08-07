//package com.android.lasttest;
//
//import android.content.ContentValues;
//import android.content.Intent;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
//import android.util.Log;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//
//public class SQLLiteActivity extends AppCompatActivity implements View.OnClickListener {
//
//    private Button btnSell, btnBuy;
//    private TextView getLot, openPrice, stopLoss, takeProfit;
//    DatabaseHelper dbHelper;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sqllite);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//
//        getLot = (TextView) findViewById(R.id.getLot);
//        openPrice = (TextView) findViewById(R.id.openPrice);
//        takeProfit = (TextView) findViewById(R.id.stopLoss);
//        stopLoss = (TextView) findViewById(R.id.takeProfit);
//
//        btnSell = (Button) findViewById(R.id.btn_sell);
//        btnBuy = (Button) findViewById(R.id.btn_buy);
//
//
////        btnSell.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////
////                onBackPressed();
////            }
////        });
////        btnBuy.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////
////                onBackPressed();
////            }
////        });
//        btnSell.setOnClickListener(this);
//        btnBuy.setOnClickListener(this);
//
//
//        dbHelper = new DatabaseHelper(this);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                onBackPressed();
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
//
//    @Override
//    public void onClick(View v) {
//        // создаем объект для данных
//        ContentValues cv = new ContentValues();
//
//        // получаем данные из полей ввода
//        String name = etName.getText().toString();
//        String email = etEmail.getText().toString();
//
//        // подключаемся к БД
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//
//
//        switch (v.getId()) {
//            case R.id.btnAdd:
//                Log.d(LOG_TAG, "--- Insert in mytable: ---");
//                // подготовим данные для вставки в виде пар: наименование столбца - значение
//
//                cv.put("name", name);
//                cv.put("email", email);
//                // вставляем запись и получаем ее ID
//                long rowID = db.insert("mytable", null, cv);
//                Log.d(LOG_TAG, "row inserted, ID = " + rowID);
//                break;
//            case R.id.btnRead:
//                Log.d(LOG_TAG, "--- Rows in mytable: ---");
//                // делаем запрос всех данных из таблицы mytable, получаем Cursor
//                Cursor c = db.query("mytable", null, null, null, null, null, null);
//
//                // ставим позицию курсора на первую строку выборки
//                // если в выборке нет строк, вернется false
//                if (c.moveToFirst()) {
//
//                    // определяем номера столбцов по имени в выборке
//                    int idColIndex = c.getColumnIndex("id");
//                    int nameColIndex = c.getColumnIndex("name");
//                    int emailColIndex = c.getColumnIndex("email");
//
//                    do {
//                        // получаем значения по номерам столбцов и пишем все в лог
//                        Log.d(LOG_TAG,
//                                "ID = " + c.getInt(idColIndex) +
//                                        ", name = " + c.getString(nameColIndex) +
//                                        ", email = " + c.getString(emailColIndex));
//                        // переход на следующую строку
//                        // а если следующей нет (текущая - последняя), то false - выходим из цикла
//                    } while (c.moveToNext());
//                } else
//                    Log.d(LOG_TAG, "0 rows");
//                c.close();
//                break;
//            case R.id.btnClear:
//                Log.d(LOG_TAG, "--- Clear mytable: ---");
//                // удаляем все записи
//                int clearCount = db.delete("mytable", null, null);
//                Log.d(LOG_TAG, "deleted rows count = " + clearCount);
//                break;
//        }
//        // закрываем подключение к БД
//        dbHelper.close();
//    }
//}

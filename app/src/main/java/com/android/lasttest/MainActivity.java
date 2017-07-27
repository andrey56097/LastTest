package com.android.lasttest;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<XXXGroupInfo> deptList = new ArrayList<XXXGroupInfo>();

    private CustomAdapter listAdapter;
    private ExpandableListView simpleExpandableListView;

    int lastExpandedPosition = -1;

    FloatingActionButton actionButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);

        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadData2();
                listAdapter.notifyDataSetChanged();
            }
        });

        // add data for displaying in expandable list view
        loadData();

        simpleExpandableListView = (ExpandableListView) findViewById(R.id.simpleExpandableListView);
        listAdapter = new CustomAdapter(MainActivity.this, deptList);

        simpleExpandableListView.setAdapter(listAdapter);

//        simpleExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
//            @Override
//            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
//                //get the group header
//                XXXGroupInfo headerInfo = deptList.get(groupPosition);
//                //get the child info
//                XXXChildInfo detailInfo = headerInfo.getChildList().get(childPosition);
//                //display it or do something with it
////                Toast.makeText(getBaseContext(), " Clicked on :: " + headerInfo.getName()
////                        + "/" + detailInfo.getName() + " Clicked on :: "+ headerInfo, Toast.LENGTH_LONG).show();
//                return false;
//            }
//        });
        final String[] mCatsName = {"Удалить", "Изменить", "Другое"};

        simpleExpandableListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                AlertDialog.Builder alertdialogbuilder = new AlertDialog.Builder(MainActivity.this);

                alertdialogbuilder.setView(R.layout.dialog);
                alertdialogbuilder.setTitle("Select A Item " + position);

                alertdialogbuilder.setItems(mCatsName, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        deleteItem(position);
                        listAdapter.notifyDataSetChanged();
                    }
                });

                AlertDialog dialog = alertdialogbuilder.create();

                dialog.show();


                return false;
            }
        });


        simpleExpandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                //get the group header
                XXXGroupInfo headerInfo = deptList.get(groupPosition);

                Toast.makeText(getBaseContext(), " Header is :: " + headerInfo.getNameofPair() + "Header position ::" + groupPosition,
                        Toast.LENGTH_LONG).show();

                return false;

            }

        });


        simpleExpandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                if (lastExpandedPosition != -1
                        && groupPosition != lastExpandedPosition) {
                    simpleExpandableListView.collapseGroup(lastExpandedPosition);
                }
                lastExpandedPosition = groupPosition;
            }
        });
    }

    //load some initial data into out list
    private void loadData() {

        addProduct("AUDUSD", "sell", 0.5, "0.75975 -> 0.75918", 3.05, 117.069, 117.069, 117.069, 12, 0.0, 0.0, 0.0);

        addProduct("CADJPY", "sell", 0.7, "0.75800 -> 0.75800", 3.05, 117.069, 117.069, 117.069, 12, 0.0, 0.0, 0.0);

        addProduct("JPYCHF", "sell", 0.7, "0.75800 -> 0.75800", 3.05, 117.069, 117.069, 117.069, 12, 0.0, 0.0, 0.0);

    }

    private void loadData2() {

        addProduct("JPYCHF", "sell", 0.7, "0.75800 -> 0.75800", 3.05, 117.069, 117.069, 117.069, 12, 0.0, 0.0, 0.0);
    }

    private int addProduct(String nameOfPair, String directionOfPair, double valueOfPair, String openClosePrice, double rightValue,
                           double priceOpen, double takeProfit, double stopLoss, int margin, double param1, double param2, double param3) {

        int groupPosition = 0;


        XXXGroupInfo headerInfo = new XXXGroupInfo();

        headerInfo.setNameofPair(nameOfPair);
        headerInfo.setDirectionOfPair(directionOfPair);
        headerInfo.setValueOfPair(valueOfPair);
        headerInfo.setOpenClosePrice(openClosePrice);
        headerInfo.setRightValue(rightValue);


        deptList.add(headerInfo);


        ArrayList<XXXChildInfo> productList = headerInfo.getChildList();

        XXXChildInfo detailInfo = new XXXChildInfo();


        detailInfo.setPriceOpen(priceOpen);
        detailInfo.setTakeProfit(takeProfit);
        detailInfo.setStopLoss(stopLoss);
        detailInfo.setMargin(margin);
        detailInfo.setParam1(param1);
        detailInfo.setParam2(param2);
        detailInfo.setParam3(param3);

        productList.add(detailInfo);

        headerInfo.setChildList(productList);

        groupPosition = deptList.indexOf(headerInfo);
        Toast.makeText(getBaseContext(), "Size  " + deptList.size(), Toast.LENGTH_LONG).show();

        return groupPosition;
    }

    private int deleteItem(int position) {

        deptList.remove(position);

        return position;
    }
}
package com.android.lasttest;


import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<XXXGroupInfo> deptList = new ArrayList<XXXGroupInfo>();;

    private SearchReposAdapter listAdapter;

    private ListView listView;

//    int groupGlobalPosition;

    FloatingActionButton actionButton;
    FloatingActionButton actionButton2;
    RelativeLayout relativeLayout;

    boolean i=true;
    //    int lastExpandedPosition = -1;
    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        relativeLayout = (RelativeLayout) findViewById(R.id.relative_layout_change);
        actionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        actionButton2 = (FloatingActionButton) findViewById(R.id.floatingActionButton2);
        listView = (ListView) findViewById(R.id.listView);
        listView.setItemsCanFocus(false);

        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadData2();
                listAdapter.notifyDataSetChanged();
            }
        });
//        actionButton2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent mainIntent = new Intent(MainActivity.this, SQLLiteActivity.class);
////                mainIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
////                mainIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
//                startActivity(mainIntent);
//            }
//        });

        loadData();



        // add data for displaying in expandable list view

        listAdapter = new SearchReposAdapter(MainActivity.this, deptList);
        listView.setAdapter(listAdapter);


//       simpleExpandableListView = (ExpandableListView) findViewById(R.id.simpleExpandableListView);
//        listAdapter = new CustomAdapter(MainActivity.this, deptList);
//        simpleExpandableListView.setAdapter(listAdapter);

//        simpleExpandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
//            @Override
//            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
//
//                groupGlobalPosition = groupPosition;
//                Toast.makeText(MainActivity.this, "getParent  " + groupPosition, Toast.LENGTH_SHORT).show();
//                return false;
//            }
//        });
//        simpleExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
//            @Override
//            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
//                groupGlobalPosition = groupPosition;
//                Toast.makeText(MainActivity.this, "getParent " + groupPosition + " getChild " + childPosition, Toast.LENGTH_SHORT).show();
//
//                return false;
//            }
//        });

        final String[] mCatsName = {"Удалить", "Изменить", "Другое"};

//        simpleExpandableListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//            @Override
//            public boolean onItemLongClick(final AdapterView<?> parent, View view, final int position, long id) {
//
//                AlertDialog.Builder alertdialogbuilder = new AlertDialog.Builder(MainActivity.this);
//
//                alertdialogbuilder.setView(R.layout.dialog);
//
//                Log.e("groupGlobalPosition1 - " , groupGlobalPosition+"");
//                alertdialogbuilder.setTitle("Select A Item " + groupGlobalPosition);
//                Log.e("groupGlobalPosition2 - " , groupGlobalPosition+"");
//
//                parent.getOnItemLongClickListener();
//                alertdialogbuilder.setItems(mCatsName, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                        deleteItem(groupGlobalPosition);
//                        listAdapter.notifyDataSetChanged();
//                    }
//                });
//
//                AlertDialog dialog = alertdialogbuilder.create();
//
//                dialog.show();
//
//                return false;
//            }
//        });

//        simpleExpandableListView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
//            @Override
//            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//                Toast.makeText(getApplicationContext(), "xxxxxxxxxx", Toast.LENGTH_SHORT).show();
//            }
//        });

//        simpleExpandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
//            @Override
//            public void onGroupExpand(int groupPosition) {
//
//                if (lastExpandedPosition != -1 && groupPosition != lastExpandedPosition) {
//                    simpleExpandableListView.collapseGroup(lastExpandedPosition);
//                }
//                lastExpandedPosition = groupPosition;
//                listAdapter.notifyDataSetChanged();
//            }
//        });

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                Toast.makeText(getApplicationContext(), "xxxxxxxxxx", Toast.LENGTH_SHORT).show();
//
//                if (relativeLayout.getVisibility() == View.GONE) {
//                    //expandedChildList.set(arg2, true);
////                    vh.rightValue.setVisibility(View.GONE);
//                    relativeLayout.setVisibility(View.VISIBLE);
//                } else {
//                    //expandedChildList.set (arg2, false);
////                    vh.rightValue.setVisibility(View.VISIBLE);
//                    relativeLayout.setVisibility(View.GONE);
//                }
//
////                view.setVisibility(View.GONE);
//                listAdapter.notifyDataSetChanged();
//            }
//        });

//        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//
//                AlertDialog.Builder alertdialogbuilder = new AlertDialog.Builder(MainActivity.this);
//
////                alertdialogbuilder.setView(R.layout.dialog);
//
//                alertdialogbuilder.setTitle("Select A Item " + position);
//
//                parent.getOnItemLongClickListener();
//                alertdialogbuilder.setItems(mCatsName, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//
//                    }
//                });
//
//                AlertDialog dialog = alertdialogbuilder.create();
//
//                dialog.show();
//
//                return false;
//            }
//        });

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
////                makeToast("GOOD");
////                if (relativeLayout.getVisibility() == View.VISIBLE) {
////                    //expandedChildList.set(arg2, true);
////                    relativeLayout.setVisibility(View.GONE);
////                } else {
////                    //expandedChildList.set(arg2, false);
////                    relativeLayout.setVisibility(View.VISIBLE);
////                }
////                int count =  listAdapter.getCount();
////                for (int i = 0; i <count ; i++)
////                    listView.collapseGroup(i);
//            }
//        });

//        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                makeToast("Not BAD");
//                return false;
//            }
//        });

        final int[] lastExpandedPosition = {-1};
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                if (view.findViewById(R.id.relative_layout_change).getVisibility() == View.VISIBLE){
//                    Toast.makeText(getApplicationContext(), "OK", Toast.LENGTH_SHORT).show();
                    view.findViewById(R.id.relative_layout_change).setVisibility(View.GONE);

                    listAdapter.notifyDataSetChanged();
                } else {
                    view.findViewById(R.id.relative_layout_change).setVisibility(View.VISIBLE);
                }
//                if (relativeLayout.getVisibility() == View.VISIBLE) {
                    //expandedChildList.set(arg2, true);
//                    vh.rightValue.setVisibility(View.GONE);
//                    relativeLayout.setVisibility(View.VISIBLE);
//                } else {
                    //expandedChildList.set (arg2, false);
//                    vh.rightValue.setVisibility(View.VISIBLE);
//                    relativeLayout.setVisibility(View.VISIBLE);
//                }
//                Toast.makeText(getApplicationContext(), "xxxxxxxxxx", Toast.LENGTH_SHORT).show();
            }
        });
//        listView.setSelected(true);
//        listView.setClickable(true);

    }

    //load some initial data into out list
    private void loadData() {

        addProduct("AUDUSD", "buy", 0.5, "0.75975 -> 0.75918", 3.05, 117.069, 117.069, 117.069, 12, 0.0, 0.0, 0.0);

        addProduct("CADJPY", "sell", 0.7, "0.75800 -> 0.75800", 3.05, 117.069, 117.069, 117.069, 12, 0.0, 0.0, 0.0);

        addProduct("JPYCHF", "buy", 0.7, "0.75800 -> 0.75800", 3.05, 117.069, 117.069, 117.069, 12, 0.0, 0.0, 0.0);

        addProduct("AUDUSD", "sell", 0.5, "0.75975 -> 0.75918", 3.05, 117.069, 117.069, 117.069, 12, 0.0, 0.0, 0.0);

//        addProduct("CADJPY", "sell", 0.7, "0.75800 -> 0.75800", 3.05, 117.069, 117.069, 117.069, 12, 0.0, 0.0, 0.0);
//
//        addProduct("JPYCHF", "sell", 0.7, "0.75800 -> 0.75800", 3.05, 117.069, 117.069, 117.069, 12, 0.0, 0.0, 0.0);
//
//        addProduct("AUDUSD", "sell", 0.5, "0.75975 -> 0.75918", 3.05, 117.069, 117.069, 117.069, 12, 0.0, 0.0, 0.0);
//
//        addProduct("CADJPY", "sell", 0.7, "0.75800 -> 0.75800", 3.05, 117.069, 117.069, 117.069, 12, 0.0, 0.0, 0.0);
//
//        addProduct("JPYCHF", "sell", 0.7, "0.75800 -> 0.75800", 3.05, 117.069, 117.069, 117.069, 12, 0.0, 0.0, 0.0);
//
//        addProduct("AUDUSD", "sell", 0.5, "0.75975 -> 0.75918", 3.05, 117.069, 117.069, 117.069, 12, 0.0, 0.0, 0.0);
//
//        addProduct("CADJPY", "sell", 0.7, "0.75800 -> 0.75800", 3.05, 117.069, 117.069, 117.069, 12, 0.0, 0.0, 0.0);
//
//        addProduct("JPYCHF", "sell", 0.7, "0.75800 -> 0.75800", 3.05, 117.069, 117.069, 117.069, 12, 0.0, 0.0, 0.0);
//
//        addProduct("AUDUSD", "sell", 0.5, "0.75975 -> 0.75918", 3.05, 117.069, 117.069, 117.069, 12, 0.0, 0.0, 0.0);
//
//        addProduct("CADJPY", "sell", 0.7, "0.75800 -> 0.75800", 3.05, 117.069, 117.069, 117.069, 12, 0.0, 0.0, 0.0);
//
//        addProduct("JPYCHF", "sell", 0.7, "0.75800 -> 0.75800", 3.05, 117.069, 117.069, 117.069, 12, 0.0, 0.0, 0.0);

    }

    private void loadData2() {
        addProduct("JPYCHF", "sell", 0.7, "0.75800 -> 0.75800", 3.05, 117.069, 117.069, 117.069, 12, 0.0, 0.0, 0.0);
    }

    private void loadData3(String nameOfPair, String directionOfPair, double valueOfPair, String openClosePrice, double rightValue,
                           double priceOpen, double takeProfit, double stopLoss, int margin, double param1, double param2, double param3){
        addProduct(nameOfPair,directionOfPair,valueOfPair,openClosePrice,rightValue,priceOpen,takeProfit,stopLoss,margin,param1,
                param2,param3);
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
        headerInfo.setPriceOpen(priceOpen);
        headerInfo.setTakeProfit(takeProfit);
        headerInfo.setStopLoss(stopLoss);
        headerInfo.setMargin(margin);
        headerInfo.setParam1(param1);
        headerInfo.setParam2(param2);
        headerInfo.setParam3(param3);
        deptList.add(headerInfo);


//        ArrayList<XXXChildInfo> productList = headerInfo.getChildList();
//
//        XXXChildInfo detailInfo = new XXXChildInfo();
//
//        detailInfo.setPriceOpen(priceOpen);
//        detailInfo.setTakeProfit(takeProfit);
//        detailInfo.setStopLoss(stopLoss);
//        detailInfo.setMargin(margin);
//        detailInfo.setParam1(param1);
//        detailInfo.setParam2(param2);
//        detailInfo.setParam3(param3);
//        productList.add(detailInfo);
//
//        headerInfo.setChildList(productList);

        groupPosition = deptList.indexOf(headerInfo);
//        Toast.makeText(getBaseContext(), "Size  " + deptList.size(), Toast.LENGTH_LONG).show();

        return groupPosition;
    }

    private int deleteItem(int position) {

        deptList.remove(position);
        Log.e("Deleted item ", position+"   Size "+deptList.size());

        return position;
    }

    public void  makeToast(String massage){
        Toast.makeText(MainActivity.this, massage, Toast.LENGTH_SHORT).show();
    }
}
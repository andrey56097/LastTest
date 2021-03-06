//package com.android.lasttest;
//
//import android.app.AlertDialog;
//import android.content.Context;
//import android.content.DialogInterface;
//import android.support.v7.widget.RecyclerView;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseExpandableListAdapter;
//import android.widget.ExpandableListView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import java.util.ArrayList;
//
///**
// * Created by batsa on 25.07.2017.
// */
//
//public class CustomAdapter extends BaseExpandableListAdapter {
//
//    private int lastExpandedPosition = -1;
//    private Context context;
//    private ArrayList<XXXGroupInfo> deptList;
//
//    public CustomAdapter(Context context, ArrayList<XXXGroupInfo> deptList) {
//        super();
//        this.context = context;
//        this.deptList = deptList;
//    }
//
//    @Override
//    public Object getChild(int groupPosition, int childPosition) {
////        ArrayList<XXXChildInfo> productList = deptList.get(groupPosition).getChildList();
////        return productList.get(childPosition);
//    }
//
//    @Override
//    public long getChildId(int groupPosition, int childPosition) {
//        return childPosition;
//    }
//
//    @Override
//    public View getChildView(final int groupPosition, int childPosition, boolean isLastChild,
//                             View view, ViewGroup parent) {
//
//        XXXChildInfo detailInfo = (XXXChildInfo) getChild(groupPosition, childPosition);
//        if (view == null) {
//            LayoutInflater infalInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            view = infalInflater.inflate(R.layout.layout_row_view_description, null);
//        }
//
//        TextView priceOpen = (TextView) view.findViewById(R.id.price_open);
//        priceOpen.setText(String.format("%s", detailInfo.getPriceOpen()));
//
//        TextView takeProfit = (TextView) view.findViewById(R.id.take_profit);
//        takeProfit.setText(String.format("%s", detailInfo.getTakeProfit()));
//
//        TextView stopLoss = (TextView) view.findViewById(R.id.stop_loss);
//        stopLoss.setText(String.format("%s", detailInfo.getStopLoss()));
//
//        TextView margin = (TextView) view.findViewById(R.id.margin);
//        margin.setText(String.format("%s", detailInfo.getMargin()));
//
//        TextView param1 = (TextView) view.findViewById(R.id.param_1);
//        param1.setText(String.format("%s", detailInfo.getParam1()));
//
//        TextView param2 = (TextView) view.findViewById(R.id.param_2);
//        param2.setText(String.format("%s", detailInfo.getParam2()));
//
//        TextView param3 = (TextView) view.findViewById(R.id.param_3);
//        param3.setText(String.format("%s", detailInfo.getParam3()));
//
//
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context,  "CUSTOM ADAPTER CLICK", Toast.LENGTH_LONG).show();
//            }
//        });
//
//        view.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                Toast.makeText(context,  "CUSTOM ADAPTER LONG CLICK" + "     parentPosition "+groupPosition+"     childPosition "+groupPosition, Toast.LENGTH_LONG).show();
//
//                return false;
//            }
//        });
//
//        return view;
//    }
//
//    @Override
//    public int getChildrenCount(int groupPosition) {
//
////        ArrayList<XXXChildInfo> productList = deptList.get(groupPosition).getChildList();
////        return productList.size();
//
//    }
//
//    @Override
//    public Object getGroup(int groupPosition) {
//        return deptList.get(groupPosition);
//    }
//
//    @Override
//    public int getGroupCount() {
//        return deptList.size();
//    }
//
//    @Override
//    public long getGroupId(int groupPosition) {
//        return groupPosition;
//    }
//    @Override
//    public View getGroupView(final int groupPosition, boolean isLastChild, View view, final ViewGroup parent) {
//
//
//
//        XXXGroupInfo headerInfo = (XXXGroupInfo) getGroup(groupPosition);
//        if (view == null) {
//            LayoutInflater inf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            view = inf.inflate(R.layout.layout_row_view, null);
//
//        }
//
//        TextView nameOfPair = (TextView) view.findViewById(R.id.name_pair);
//        nameOfPair.setText(headerInfo.getNameofPair());
//
//        TextView valuePair = (TextView) view.findViewById(R.id.value_pair);
//        valuePair.setText(String.format("%s ", headerInfo.getValueOfPair()));
//
//        TextView directionOfPair = (TextView) view.findViewById(R.id.direction_pair);
//        directionOfPair.setText(headerInfo.getDirectionOfPair());
//
//        final TextView openClosePrice = (TextView) view.findViewById(R.id.open_close_price);
//        openClosePrice.setText(headerInfo.getOpenClosePrice());
//
//        final TextView rightValue = (TextView) view.findViewById(R.id.rightValue);
//        rightValue.setText(String.format("%s ", headerInfo.getRightValue()));
//
//
//        final String[] mCatsName = {"Удалить", "Изменить", "Другое"};
//
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if ( openClosePrice.getVisibility() == View.GONE)
//                {
//                    //expandedChildList.set(arg2, true);
//                    openClosePrice.setVisibility(View.VISIBLE);
//                }
//                else
//                {
//                    //expandedChildList.set(arg2, false);
//                    openClosePrice.setVisibility(View.GONE);
//                }
//            }
//        });
//
//        view.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                Toast.makeText(context,  "getGroupView LONG CLICK" + "     groupPosition "+groupPosition, Toast.LENGTH_LONG).show();
//
//                AlertDialog.Builder alertdialogbuilder = new AlertDialog.Builder(context);
//
////                alertdialogbuilder.setView(R.layout.dialog);
//
//                alertdialogbuilder.setTitle("Select A Item " + groupPosition);
//
////                parent.getOnItemLongClickListener();
//                alertdialogbuilder.setItems(mCatsName, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
////                        deleteItem(groupGlobalPosition);
//                    }
//                });
//
//                AlertDialog dialog = alertdialogbuilder.create();
////
//                dialog.show();
//
//                return false;
//            }
//        });
//
//        return view;
//    }
//
//    @Override
//    public boolean hasStableIds() {
//        return true;
//    }
//
//    @Override
//    public boolean isChildSelectable(int groupPosition, int childPosition) {
//        return true;
//    }
//
//}

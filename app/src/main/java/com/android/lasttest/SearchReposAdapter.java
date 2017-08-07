package com.android.lasttest;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by batsa on 29.03.2017.
 */

public class SearchReposAdapter extends ArrayAdapter<XXXGroupInfo> {

    ArrayList<XXXGroupInfo> reposes;
    Context context;
    private LayoutInflater layoutInflater;

    public SearchReposAdapter(Context context, ArrayList<XXXGroupInfo> objects) {
        super(context, 0, objects);
        this.context = context;
        this.layoutInflater = layoutInflater.from(context);
        reposes = objects;
    }

//    public void set

    private boolean[] mVisibilityList = null;
    private String[] mNameList = null;
    public void setVisibilityList(boolean[] iVisibilityList)
    {
        mVisibilityList = iVisibilityList;
    }

    public XXXGroupInfo getItem(int position) {
        return reposes.get(position);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder vh;
        if (convertView == null) {
            View view = layoutInflater.inflate(R.layout.layout_row_change, parent, false);
            vh = ViewHolder.create((RelativeLayout) view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        XXXGroupInfo headerInfo = getItem(position);

        vh.nameOfPair.setText(headerInfo.getNameofPair());
        vh.nameOfPair.setTypeface(null, Typeface.BOLD);
        vh.valuePair.setText(String.format("%s ", headerInfo.getValueOfPair()));
        vh.openClosePrice.setText(headerInfo.getOpenClosePrice());
        if (headerInfo.getDirectionOfPair().matches("sell")){
            vh.valuePair.setTextColor(Color.RED);
        } else if (headerInfo.getDirectionOfPair().matches("buy")){
            vh.valuePair.setTextColor(Color.BLUE);
        }
        vh.directionOfPair.setText(headerInfo.getDirectionOfPair());
        if (headerInfo.getDirectionOfPair().matches("sell")){
            vh.directionOfPair.setTextColor(Color.RED);
        } else if (headerInfo.getDirectionOfPair().matches("buy")){
            vh.directionOfPair.setTextColor(Color.BLUE);
        }
        vh.rightValue.setText(String.format("%s ", headerInfo.getRightValue()));
        vh.priceOpen.setText(String.format("%s", headerInfo.getPriceOpen()));
        vh.takeProfit.setText(String.format("%s", headerInfo.getTakeProfit()));
        vh.stopLoss.setText(String.format("%s", headerInfo.getStopLoss()));
        vh.margin.setText(String.format("%s", headerInfo.getMargin()));
        vh.param1.setText(String.format("%s", headerInfo.getParam1()));
        vh.param1.setTextColor(Color.BLUE);
        vh.param2.setText(String.format("%s", headerInfo.getParam2()));
        vh.param2.setTextColor(Color.RED);
        vh.param3.setText(String.format("%s", headerInfo.getParam3()));
        vh.param3.setTextColor(Color.GRAY);

//        vh.relativeLayout.setVisibility(View.GONE);
        vh.mainRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                expand(position, vh);

                if (vh.relativeLayout.getVisibility() == View.GONE) {
                    //expandedChildList.set(arg2, true);
//                    vh.rightValue.setVisibility(View.GONE);
//                    vh.relativeLayout.setVisibility(View.VISIBLE);
                    expand(position,vh);
                } else {
                    //expandedChildList.set (arg2, false);
//                    vh.rightValue.setVisibility(View.VISIBLE);
//                    vh.relativeLayout.setVisibility(View.GONE);
                }
            }
        });

        final String[] mCatsName = {"Удалить", "Изменить", "Другое"};

//        vh.mainRelativeLayout.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//
//                AlertDialog.Builder alertdialogbuilder = new AlertDialog.Builder(context);
//
////                alertdialogbuilder.setView(R.layout.dialog);
//
//                alertdialogbuilder.setTitle("Select A Item " + position);
//
////                parent.getOnItemLongClickListener();
//                alertdialogbuilder.setItems(mCatsName, new DialogInterface.OnClickListener() {
//
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        reposes.remove(position);
//                        notifyDataSetChanged();
//                    }
//                });
//
//                AlertDialog dialog = alertdialogbuilder.create();
//
//                dialog.show();
//
//                notifyDataSetChanged();
//                return false;
//            }
//        });
        return vh.rootView;
    }

    private static class ViewHolder {

        public final RelativeLayout rootView;

        public final TextView nameOfPair;
        public final TextView valuePair;
        public final TextView directionOfPair;
        public final TextView openClosePrice;
        public final TextView rightValue;

        public final TextView priceOpen;
        public final TextView takeProfit;
        public final TextView stopLoss;
        public final TextView margin;
        public final TextView param1;
        public final TextView param2;
        public final TextView param3;

        public final RelativeLayout relativeLayout;
        public final RelativeLayout mainRelativeLayout;


        public ViewHolder(RelativeLayout rootView, TextView nameOfPair, TextView valuePair, TextView directionOfPair,
                          TextView openClosePrice, TextView rightValue, TextView priceOpen, TextView takeProfit, TextView stopLoss,
                          TextView margin, TextView param1, TextView param2, TextView param3, RelativeLayout relativeLayout, RelativeLayout mainRelativeLayout) {

            this.rootView = rootView;

            this.nameOfPair = nameOfPair;
            this.valuePair = valuePair;
            this.directionOfPair = directionOfPair;
            this.openClosePrice = openClosePrice;
            this.rightValue = rightValue;

            this.priceOpen = priceOpen;
            this.takeProfit = takeProfit;
            this.stopLoss = stopLoss;
            this.margin = margin;
            this.param1 = param1;
            this.param2 = param2;
            this.param3 = param3;

            this.relativeLayout = relativeLayout;
            this.mainRelativeLayout = mainRelativeLayout;
        }

        public static ViewHolder create(RelativeLayout rootView) {

            TextView nameOfPair = (TextView) rootView.findViewById(R.id.name_pair);
            TextView valuePair = (TextView) rootView.findViewById(R.id.value_pair);
            TextView directionOfPair = (TextView) rootView.findViewById(R.id.direction_pair);
            TextView openClosePrice = (TextView) rootView.findViewById(R.id.open_close_price);
            TextView rightValue = (TextView) rootView.findViewById(R.id.rightValue);

            TextView priceOpen = (TextView) rootView.findViewById(R.id.price_open);
            TextView takeProfit = (TextView) rootView.findViewById(R.id.take_profit);
            TextView stopLoss = (TextView) rootView.findViewById(R.id.stop_loss);
            TextView margin = (TextView) rootView.findViewById(R.id.margin);
            TextView param1 = (TextView) rootView.findViewById(R.id.param_1);
            TextView param2 = (TextView) rootView.findViewById(R.id.param_2);
            TextView param3 = (TextView) rootView.findViewById(R.id.param_3);

            RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.relative_layout_change);
            RelativeLayout mainRelativeLayout = (RelativeLayout) rootView.findViewById(R.id.layout_main_change);


            return new ViewHolder(rootView, nameOfPair, valuePair, directionOfPair, openClosePrice, rightValue, priceOpen, takeProfit, stopLoss, margin, param1, param2, param3, relativeLayout, mainRelativeLayout);
        }
    }


    public void expand(int groupPosition, ViewHolder viewHolder) {

//        if (lastExpandedPosition != -1 && groupPosition != lastExpandedPosition) {
//            viewHolder.mainRelativeLayout.setVisibility(View.GONE);
//        }
//        lastExpandedPosition = groupPosition;

        for (int i = 0; i < reposes.size(); i++) {
            if (i != groupPosition) {
                viewHolder.relativeLayout.setVisibility(View.GONE);
            } else viewHolder.relativeLayout.setVisibility(View.GONE);
            notifyDataSetChanged();
        }
        viewHolder.relativeLayout.setVisibility(View.GONE);

//        for (XXXGroupInfo xx: reposes) {
//            if (reposes.get(xx) != groupPosition)
//            viewHolder.mainRelativeLayout.setVisibility(View.GONE);
//        }
    }

    public void remove(){

    }
}

package com.mohamedfoad.sqlitefromasset.adapter;

import android.content.Context;
import android.provider.BaseColumns;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mohamedfoad.sqlitefromasset.R;
import com.mohamedfoad.sqlitefromasset.model.Product;

import java.util.List;

/**
 * Created by EasyUApp on 12/26/2017.
 */

public class ListProductAdapter extends BaseAdapter {
    private Context mContext;
    private List<Product> mProductList;

    public ListProductAdapter(Context mContext, List<Product> mProductList) {
        this.mContext = mContext;
        this.mProductList = mProductList;
    }


    @Override
    public int getCount() {
        return mProductList.size();
    }

    @Override
    public Object getItem(int position) {
        return mProductList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mProductList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = View.inflate(mContext, R.layout.item_listview,null);
        TextView tvName = v.findViewById(R.id.tv_product_name);
        TextView tvPrice =v.findViewById(R.id.tv_product_price);
        TextView tvDescription = v.findViewById(R.id.tv_product_description);

        tvName.setText(mProductList.get(position).getName());
        tvPrice.setText(String.valueOf(mProductList.get(position).getPrice()) + " $");
        tvDescription.setText(mProductList.get(position).getDescription());
        return v;
    }
}

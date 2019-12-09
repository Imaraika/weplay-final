package com.example.weplay;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter< GroundViewHolder > {


    private Context mContext;
    private List< PlaygroundData > mGroundList;

    Adapter(Context mContext, List< PlaygroundData > mGroundList) {
        this.mContext = mContext;
        this.mGroundList = mGroundList;
    }
    @Override
    public GroundViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item_row, parent, false);
        return new GroundViewHolder(mView);
    }
    @Override
    public void onBindViewHolder(final GroundViewHolder holder, int position) {
        holder.mImage.setImageResource(mGroundList.get(position).getPlaygroundImage());
        holder.mTitle.setText(mGroundList.get(position).getPlaygroundName());

        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intnt = new Intent(mContext,DetailActivity.class);
                intnt.putExtra("Title", mGroundList.get(holder.getAdapterPosition()).getPlaygroundName());
                intnt.putExtra("Description", mGroundList.get(holder.getAdapterPosition()).getPlaygroundDescription());
                intnt.putExtra("Image", mGroundList.get(holder.getAdapterPosition()).getPlaygroundImage());
                mContext.startActivity(intnt);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mGroundList.size();
    }
}
class GroundViewHolder extends RecyclerView.ViewHolder {

    ImageView mImage;
    TextView mTitle;
    CardView mCardView = itemView.findViewById(R.id.cardview);


    GroundViewHolder(View itemView) {
        super(itemView);

        mImage = itemView.findViewById(R.id.ivImage);
        mTitle = itemView.findViewById(R.id.tvTitle);
    }
}
package de.hsworms.inf3032.adapters;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

import de.hsworms.inf3032.R;
import de.hsworms.inf3032.listeners.ListItemClickListener;


public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ViewHolder> {

    private Context mContext;
    private Activity mActivity;

    private ArrayList<String> mItemList;
    private ListItemClickListener mItemClickListener;

    public FavoriteAdapter(Context mContext, Activity mActivity, ArrayList<String> mItemList) {
        this.mContext = mContext;
        this.mActivity = mActivity;
        this.mItemList = mItemList;
    }

    public void setItemClickListener(ListItemClickListener itemClickListener) {
        this.mItemClickListener = itemClickListener;
    }


    @Override
    public FavoriteAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_favorite_recycler, parent, false);
        return new FavoriteAdapter.ViewHolder(view, viewType, mItemClickListener);
    }

    @Override
    public int getItemCount() {
        return (null != mItemList ? mItemList.size() : 0);

    }

    @Override
    public void onBindViewHolder(FavoriteAdapter.ViewHolder mainHolder, int position) {

        // setting data over views
        String title = mItemList.get(position);
        mainHolder.tvTitleText.setText(Html.fromHtml(title));
        mainHolder.tvTagText.setText(String.valueOf(position + 1));


        Random rand = new Random();
        int i = rand.nextInt(6) + 1;


        switch (i) {
            case 1:
                mainHolder.tvTagText.setBackground(ContextCompat.getDrawable(mContext, R.drawable.circle_blue));
                break;
            case 2:
                mainHolder.tvTagText.setBackground(ContextCompat.getDrawable(mContext, R.drawable.circle_red));
                break;

            case 3:
                mainHolder.tvTagText.setBackground(ContextCompat.getDrawable(mContext, R.drawable.circle_orange));
                break;

            case 4:
                mainHolder.tvTagText.setBackground(ContextCompat.getDrawable(mContext, R.drawable.circle_purple));
                break;
            case 5:
                mainHolder.tvTagText.setBackground(ContextCompat.getDrawable(mContext, R.drawable.circle_green));
                break;
            case 6:
                mainHolder.tvTagText.setBackground(ContextCompat.getDrawable(mContext, R.drawable.circle_deep_blue));
                break;
            default:
                break;
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private RelativeLayout lytContainer;
        private TextView tvTagText, tvTitleText;
        private ImageButton btnDelete;
        private ListItemClickListener itemClickListener;


        public ViewHolder(View itemView, int viewType, ListItemClickListener itemClickListener) {
            super(itemView);

            this.itemClickListener = itemClickListener;
            // Find all views ids
            tvTagText = itemView.findViewById(R.id.item_tag);
            tvTitleText = itemView.findViewById(R.id.item_title);
            btnDelete = itemView.findViewById(R.id.btn_delete);
            lytContainer = itemView.findViewById(R.id.lyt_container);
            lytContainer.setOnClickListener(this);
            btnDelete.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            if (itemClickListener != null) {
                itemClickListener.onItemClick(getLayoutPosition(), view);
            }
        }
    }
}

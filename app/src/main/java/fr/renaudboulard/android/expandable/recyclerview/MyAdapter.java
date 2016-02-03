package fr.renaudboulard.android.expandable.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by a525906 on 02/02/2016.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Expandable> mDataset;
    private OnItemClickListener onItemClickListener;


    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<Expandable> myDataset, OnItemClickListener onItemClickListener) {
        this.mDataset = myDataset;
        this.onItemClickListener = onItemClickListener;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = null;
        switch (viewType) {
            case 1:
                v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.card_view, parent, false);

                return new ViewHolder(v,this.onItemClickListener, false);
            case 0:
                v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.card_view_expandable, parent, false);

                return new ViewHolder(v,this.onItemClickListener, true);

            default:
                v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.card_view, parent, false);

                return new ViewHolder(v,this.onItemClickListener, false);

        }


    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTextView.setText(mDataset.get(position).getTitle());

    }

    @Override
    public int getItemViewType(int position) {
        // Just as an example, return 0 or 2 depending on position
        // Note that unlike in ListView adapters, types don't have to be contiguous
        Expandable expandable = mDataset.get(position);
        if(expandable.isChild()){
            return 0;
        } else {
            return 1;
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        public TextView mTextView;
        public OnItemClickListener onItemClickListener;

        public ViewHolder(View v, OnItemClickListener onItemCL, boolean isChild) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.info_text);
            onItemClickListener = onItemCL;
            if (!isChild){
                v.setOnClickListener(this);
            }
        }

        @Override
        public void onClick(View v) {
            onItemClickListener.onItemClick(getPosition());

        }
    }
}
package fr.renaudboulard.android.expandable.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemClickListener{

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Expandable> myDataset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(mLayoutManager);

        myDataset = new ArrayList<>();
        myDataset.add(new Expandable("Line 1", false));
        myDataset.add(new Expandable("Line 2", false));
        myDataset.add(new Expandable("Line 3", false));
        myDataset.add(new Expandable("Line 4", false));
        myDataset.add(new Expandable("Line 5", false));
        myDataset.add(new Expandable("Line 6", false));

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(myDataset,this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onItemClick(int position) {
        if (!myDataset.get(position).isExpand()) {
            myDataset.add(position + 1, new Expandable("Expandable 2", true));
            myDataset.add(position + 1, new Expandable("Expandable 1", true));
            mAdapter.notifyItemRangeInserted(position + 1,2);
            myDataset.get(position).setIsExpand(true);
            mRecyclerView.scrollToPosition(position+2);
        } else {
            myDataset.get(position).setIsExpand(false);
            myDataset.remove(position + 1);
            myDataset.remove(position + 1);
            mAdapter.notifyItemRangeRemoved(position + 1,2);

        }

    }
}

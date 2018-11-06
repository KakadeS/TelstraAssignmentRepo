package com.example.sayalikakade.telstraassignmenttask.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.sayalikakade.telstraassignmenttask.R;
import com.example.sayalikakade.telstraassignmenttask.viewmodel.DataViewModel;
import com.example.sayalikakade.telstraassignmenttask.databinding.ActivityContainerBinding;


import static android.databinding.DataBindingUtil.inflate;
import static android.support.v7.widget.LinearLayoutManager.VERTICAL;

public class CountryFragment extends Fragment {
    private DataViewModel dataViewModel;
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            View view = bind(inflater);
            swipeRefreshLayout = view.findViewById(R.id.refresh_data);
            initRecyclerView(view);
            return view;
    }

    public void onResume() {
        super.onResume();
        swipeRefreshLayout.setRefreshing(false);
        dataViewModel.setUp();
    }

    private View bind(LayoutInflater inflater) {
        ActivityContainerBinding binding = inflate(inflater,R.layout.activity_container,null,false);
        dataViewModel = new DataViewModel();
        binding.setViewModel(dataViewModel);
        return binding.getRoot();
    }

    private void initRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.data_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), VERTICAL));
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(false);
                dataViewModel.setUp();
            }
        });

    }
}

package edu.uic.cs478.sp2025.informationapp;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
// Fragment Classes for Attractions and Restaurants Activity
public class ListFragment extends Fragment {
    private RecyclerView recyclerView;
    private ItemAdapter adapter;
    private String type;
    private int selectedPosition = RecyclerView.NO_POSITION;
    private SharedViewModel viewModel;

    private static final String ARG_TYPE = "type";

    static ListFragment newInstance(String type){
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TYPE,type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!= null){
            type = getArguments().getString(ARG_TYPE);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        List<?> items = getItemsForType();

        adapter = new ItemAdapter(items);
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        List<?> items = getItemsForType();
        if (!items.isEmpty()) {
            viewModel.selectItem(items.get(0));
        }
        viewModel.getSelectedItem().observe(getViewLifecycleOwner(), item -> {
            selectedPosition = items.indexOf(item);
            adapter.setSelectedPosition(selectedPosition);
            adapter.notifyDataSetChanged();
        });
    }

    private List<?> getItemsForType(){
        if ("attractions".equals(type)) {
            return ChicagoData.attractions;
        } else if ("restaurants".equals(type)) {
            return ChicagoData.restaurants;
        } else {
            return new ArrayList<>();
        }
    }

    class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
        private List<?> items;
        private int selectedPosition = RecyclerView.NO_POSITION;

        public ItemAdapter(List<?> items) {
            this.items = items;
        }

        public void setSelectedPosition(int position) {
            selectedPosition = position;
        }

        @NonNull
        @Override
        public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_item, parent, false);
            return new ItemViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
            Object item = items.get(position);
            String name = "";
            if (item instanceof Attraction) {
                name = ((Attraction) item).getName();
            } else if (item instanceof Restaurant) {
                name = ((Restaurant) item).getName();
            }
            holder.textView.setText(name);

            // Highlight logic
            if (position == selectedPosition) {
                holder.itemView.setBackgroundColor(
                        ContextCompat.getColor(holder.itemView.getContext(), R.color.selected_item_color)
                );
            } else {
                holder.itemView.setBackgroundColor(Color.TRANSPARENT);
            }
        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        class ItemViewHolder extends RecyclerView.ViewHolder {
            TextView textView;

            public ItemViewHolder(@NonNull View itemView) {
                super(itemView);
                textView = itemView.findViewById(R.id.textViewItem);

                itemView.setOnClickListener(v -> {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        int previousSelected = selectedPosition;
                        selectedPosition = position;
                        notifyItemChanged(previousSelected);
                        notifyItemChanged(selectedPosition);

                        viewModel.selectItem(items.get(position));
                    }
                });
            }
        }
    }
}
package com.example.lesson6task5java.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lesson6task5java.R;
import com.example.lesson6task5java.module.User;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_AVAILABLE_YES = 0;
    private static final int TYPE_AVAILABLE_NO = 1;

    Context context;
    List<User> users;

    public RecyclerAdapter(Context context, List<User> users){
        this.context = context;
        this.users = users;
    }

    @Override
    public int getItemViewType(int position){
        User user = users.get(position);

        if (user.isAvailable()){
            return TYPE_AVAILABLE_YES;
        } else {
        return TYPE_AVAILABLE_NO;
        }

    }

    @Override
    public int getItemCount() { return users.size(); }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
       if (viewType==TYPE_AVAILABLE_YES){
           View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recycle_layout_yes, viewGroup,false);
      return new RecyclerViewYESHolder(view);
       }else{
       View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recycler_layout_not,viewGroup, false);
        return new RecyclerViewNOTHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        User user = users.get(position);

        if (holder instanceof RecyclerViewYESHolder){
            TextView first_name = ((RecyclerViewYESHolder)holder).first_name;
            TextView last_name = ((RecyclerViewYESHolder)holder).last_name;

            first_name.setText(user.getFirstName());
            last_name.setText(user.getLastName());
        }

        if (holder instanceof RecyclerViewNOTHolder){
            TextView first_name = ((RecyclerViewNOTHolder)holder).first_name;
            TextView last_name = ((RecyclerViewNOTHolder)holder).last_name;

            first_name.setText("The first name is not available");
            last_name.setText("The second name is not available");
        }
    }

    public class  RecyclerViewYESHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView first_name, last_name;

        public RecyclerViewYESHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;

            first_name = view.findViewById(R.id.first_name);
            last_name = view.findViewById(R.id.last_name);
        }
    }

    public class  RecyclerViewNOTHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView first_name, last_name;

        public RecyclerViewNOTHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;

            first_name = view.findViewById(R.id.first_name);
            last_name = view.findViewById(R.id.last_name);
        }
    }
}

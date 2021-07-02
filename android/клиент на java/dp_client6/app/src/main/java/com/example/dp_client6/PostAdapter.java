package com.example.dp_client6;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class PostAdapter  extends RecyclerView.Adapter<PostAdapter.ViewHolder>{

    private final LayoutInflater inflater;
    private final List<Post> Posts;

    public PostAdapter(Context context, List<Post> Posts) {
        this.Posts = Posts;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PostAdapter.ViewHolder holder, int position) {
        Post post = Posts.get(position);
        //holder.flagView.setImageBitmap(Post.getFlagResource());
        //holder.flagView.setImageResource(R.drawable.ic_dashboard_black_24dp);
        if(post.getFlagResource().equals("0")){
            holder.flagView.setVisibility(View.GONE);
        }
            Glide.with(inflater.getContext()).load(post.getFlagResource())
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .into(holder.flagView);
        //holder.flagView.setVisibility(View.GONE);
        holder.nameView.setText(post.getName());
        holder.capitalView.setText(post.getCapital());
    }

    @Override
    public int getItemCount() {
        return Posts.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView flagView;
        final TextView nameView, capitalView;
        ViewHolder(View view){
            super(view);
            flagView = (ImageView)view.findViewById(R.id.flag);
            nameView = (TextView) view.findViewById(R.id.name);
            capitalView = (TextView) view.findViewById(R.id.capital);
        }
    }
}

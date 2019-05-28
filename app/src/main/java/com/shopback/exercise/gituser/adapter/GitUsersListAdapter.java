package com.shopback.exercise.gituser.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.shopback.exercise.gituser.R;
import com.shopback.exercise.gituser.model.GitUser;

import java.util.List;

/**
 * Created by Ricky on 2019-05-28.
 */
public class GitUsersListAdapter extends RecyclerView.Adapter<GitUsersListAdapter.ViewHolder> {

    private Context context;
    private List<GitUser> gitUserList;

    public GitUsersListAdapter(Context context, List<GitUser> gitUserList) {
        this.context = context;
        this.gitUserList = gitUserList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // scalable can use viewType create to various holder
        ViewHolder holder = createGitUsersViewHolder();
        return holder;
    }

    private ViewHolder createGitUsersViewHolder() {
        View view = LayoutInflater.from(context).inflate(R.layout.gituser_item, null);
        ViewHolder holder = new ViewHolder(view);
        holder.userIconView = view.findViewById(R.id.user_icon);
        holder.userNameView = view.findViewById(R.id.user_name);
        holder.siteAdminView = view.findViewById(R.id.site_admin);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GitUser gitUser = gitUserList.get(position);
        Glide.with(context).load(gitUser.getAvatarURL()).into(holder.userIconView);

        holder.userNameView.setText(gitUser.getLogin());

        boolean isShowAdminView = gitUser.getSiteAdmin();
        holder.siteAdminView.setVisibility(isShowAdminView ? View.VISIBLE : View.INVISIBLE);
    }

    @Override
    public int getItemCount() {
        return gitUserList != null && !gitUserList.isEmpty() ? gitUserList.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView userIconView;
        public TextView userNameView;
        public TextView siteAdminView;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}

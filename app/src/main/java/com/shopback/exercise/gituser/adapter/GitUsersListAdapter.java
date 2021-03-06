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
    private ItemClickListener itemClickListener;

    public GitUsersListAdapter(Context context, List<GitUser> gitUserList,
                               ItemClickListener itemClickListener) {
        this.context = context;
        this.gitUserList = gitUserList;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // scalable can use viewType create to various holder
        ViewHolder holder = createGitUsersViewHolder();
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GitUser gitUser = gitUserList.get(position);
        Glide.with(context).load(gitUser.getAvatarURL()).into(holder.userIconView);

        holder.userNameView.setText(gitUser.getLogin());

        boolean isShowAdminView = gitUser.getSiteAdmin();
        holder.siteAdminView.setVisibility(isShowAdminView ? View.VISIBLE : View.GONE);
        holder.itemView.setOnClickListener(v -> {
            if (itemClickListener != null) {
                itemClickListener.onItemClick(gitUser.getLogin());
            }
        });

        holder.indexNumberView.setText(String.valueOf(position + 1));
    }

    private ViewHolder createGitUsersViewHolder() {
        View view = LayoutInflater.from(context).inflate(R.layout.item_gituser, null);
        ViewHolder holder = new ViewHolder(view);
        holder.userIconView = view.findViewById(R.id.user_icon);
        holder.userNameView = view.findViewById(R.id.user_login_name);
        holder.siteAdminView = view.findViewById(R.id.site_admin);
        holder.indexNumberView = view.findViewById(R.id.index_number);
        return holder;
    }

    @Override
    public int getItemCount() {
        return gitUserList != null && !gitUserList.isEmpty() ? gitUserList.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView userIconView;
        public TextView userNameView;
        public TextView siteAdminView;
        public TextView indexNumberView;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    public interface ItemClickListener {
        void onItemClick(String loginName);
    }
}

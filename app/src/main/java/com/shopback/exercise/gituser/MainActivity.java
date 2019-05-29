package com.shopback.exercise.gituser;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.shopback.exercise.gituser.adapter.GitUsersListAdapter;
import com.shopback.exercise.gituser.model.GitUser;
import com.shopback.exercise.gituser.ui.main.MainPresenter;
import com.shopback.exercise.gituser.ui.main.MainView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ricky on 2019-05-28.<br/>
 * main activity handle entry point<br/>
 * and create presenter implements view.
 */
public class MainActivity extends AppCompatActivity implements MainView {

    private MainPresenter mainPresenter;

    @BindView(R.id.gituser_recyclerview)
    RecyclerView gitUserRecyclerView;

    private GitUsersListAdapter gitUsersListAdapter;

    private List<GitUser> gitUsersList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initPresenter();
        initGitUsersList();
    }

    private void initGitUsersList() {
        mainPresenter.fetchUsers(0);

        gitUsersListAdapter = new GitUsersListAdapter(this, gitUsersList);

        gitUserRecyclerView.setLayoutManager(new LinearLayoutManager(this,
                RecyclerView.VERTICAL, false));
        gitUserRecyclerView.setAdapter(gitUsersListAdapter);

    }

    private void initPresenter() {
        mainPresenter = new MainPresenter(this);
    }

    @Override
    public void addGitUsers(List<GitUser> usersList) {
        gitUsersList.addAll(usersList);
        gitUsersListAdapter.notifyDataSetChanged();

//        PagedList.Config pagedListConfig =
//                (new PagedList.Config.Builder())
//                        .setEnablePlaceholders(false)
//                        .setPageSize(20).build();
//        LivePagedListBuilder itemPagedList = (new LivePagedListBuilder(itemDataSourceFactory, pagedListConfig))
//                .build();
    }

    @Override
    public void showGitUserDetail(GitUser gitUser) {

    }
}

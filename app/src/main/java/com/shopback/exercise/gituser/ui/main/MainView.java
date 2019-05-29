package com.shopback.exercise.gituser.ui.main;

import com.shopback.exercise.gituser.model.GitUser;

import java.util.List;

/**
 * Created by Ricky on 2019-05-28.
 */
public interface MainView {
    void addGitUsers(List<GitUser> gitUsersList);
    void fetchGitUsersFail();
}

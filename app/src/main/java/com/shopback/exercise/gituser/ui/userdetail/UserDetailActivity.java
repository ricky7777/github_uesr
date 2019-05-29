package com.shopback.exercise.gituser.ui.userdetail;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.shopback.exercise.gituser.MainActivity;
import com.shopback.exercise.gituser.R;
import com.shopback.exercise.gituser.model.GitUser;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import utils.ProgressDialogUtil;

/**
 * Created by Ricky on 2019-05-29.<br/>
 * user detail screen, when receiver user login name<br/>
 * call api to get user detail and display it
 */
public class UserDetailActivity extends AppCompatActivity implements UserDetailView {
    @BindView(R.id.user_icon)
    ImageView userIconView;

    @BindView(R.id.user_name)
    TextView userNameView;

    @BindView(R.id.bio_view)
    TextView bioView;

    @BindView(R.id.user_login_name)
    TextView userLoginNameView;

    @BindView(R.id.site_admin)
    TextView siteAdminView;

    @BindView(R.id.location_view)
    View locationView;

    @BindView(R.id.location_url_view)
    TextView locationURLView;

    @BindView(R.id.blog_view)
    View blogView;

    @BindView(R.id.blog_url_view)
    TextView blogURLView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!getIntent().hasExtra(MainActivity.INTENT_KEY_LOGINNAME)) {
            finish();
            return;
        }

        String loginName = getIntent().getStringExtra(MainActivity.INTENT_KEY_LOGINNAME);
        if (loginName == null || loginName.isEmpty()) {
            finish();
            return;
        }

        UserDetailPresenter userDetailPresenter = new UserDetailPresenter(this);
        userDetailPresenter.fetchUser(loginName);

        setContentView(R.layout.activity_userdetail);
        ButterKnife.bind(this);

        ProgressDialogUtil.showProgressDialog(this);
    }


    @Override
    public void showGitUserDetail(GitUser gitUser) {
        String avatarURL = gitUser.getAvatarURL();
        if (avatarURL != null && !avatarURL.isEmpty()) {
            Glide.with(this)
                    .load(avatarURL)
                    .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                    .into(userIconView);
        }

        userNameView.setText(gitUser.getName());
        if (gitUser.getBio() == null) {
            bioView.setVisibility(View.GONE);
        } else {
            bioView.setText(gitUser.getBio().toString());
            bioView.setVisibility(View.VISIBLE);
        }
        userLoginNameView.setText(gitUser.getLogin());
        siteAdminView.setVisibility(gitUser.getSiteAdmin() ? View.VISIBLE : View.GONE);

        if (gitUser.getLocation() == null) {
            locationView.setVisibility(View.GONE);
        } else {
            locationURLView.setText(gitUser.getLocation());
            locationView.setVisibility(View.VISIBLE);
        }

        if (gitUser.getBlog() == null) {
            blogView.setVisibility(View.GONE);
        } else {
            blogURLView.setText(gitUser.getBlog());
            blogView.setVisibility(View.VISIBLE);
        }

        ProgressDialogUtil.dismiss();
    }

    @Override
    public void fetchGitUserFail() {
        Toast.makeText(this, R.string.error_message_fetch_data_fail, Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.button_close)
    public void close() {
        finish();
    }
}

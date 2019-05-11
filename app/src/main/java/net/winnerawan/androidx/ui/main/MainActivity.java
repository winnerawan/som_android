package net.winnerawan.androidx.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import butterknife.ButterKnife;
import net.winnerawan.androidx.R;
import net.winnerawan.androidx.ui.base.BaseActivity;
import net.winnerawan.androidx.ui.chart.ChartActivity;
import net.winnerawan.androidx.utils.ViewUtils;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainView {

    @Inject
    MainMvpPresenter<MainView> presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getActivityComponent().inject(this);

        ViewUtils.setStatusBar(this);
        setUnBinder(ButterKnife.bind(this));

        presenter.onAttach(this);
        setUp();
    }


    @Override
    protected void setUp() {
        new Handler().postDelayed(() -> startActivity(new Intent(getApplicationContext(), ChartActivity.class)), 3000);

    }

}

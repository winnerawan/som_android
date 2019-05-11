package net.winnerawan.androidx.di.component;

import net.winnerawan.androidx.ui.chart.ChartActivity;
import net.winnerawan.androidx.ui.detail.DetailActivity;
import net.winnerawan.androidx.ui.main.MainActivity;
import net.winnerawan.androidx.ui.splash.SplashActivity;
import dagger.Component;
import net.winnerawan.androidx.di.PerActivity;
import net.winnerawan.androidx.di.module.ActivityModule;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2017
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(SplashActivity activity);

    void inject(MainActivity mainActivity);

    void inject(DetailActivity detailActivity);

    void inject(ChartActivity chartActivity);
}

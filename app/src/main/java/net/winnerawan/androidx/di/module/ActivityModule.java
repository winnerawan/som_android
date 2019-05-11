package net.winnerawan.androidx.di.module;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import net.winnerawan.androidx.di.PerActivity;
import net.winnerawan.androidx.ui.chart.ChartMvpPresenter;
import net.winnerawan.androidx.ui.chart.ChartPresenter;
import net.winnerawan.androidx.ui.chart.ChartView;
import net.winnerawan.androidx.ui.detail.DetailMvpPresenter;
import net.winnerawan.androidx.ui.main.MainPresenter;
import net.winnerawan.androidx.ui.detail.DetailView;
import net.winnerawan.androidx.ui.main.MainView;
import dagger.Module;
import dagger.Provides;

import net.winnerawan.androidx.di.ActivityContext;
import net.winnerawan.androidx.ui.splash.SplashMvpPresenter;
import net.winnerawan.androidx.ui.splash.SplashView;
import net.winnerawan.androidx.utils.rx.AppSchedulerProvider;
import net.winnerawan.androidx.utils.rx.SchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;
import net.winnerawan.androidx.ui.detail.DetailPresenter;
import net.winnerawan.androidx.ui.main.MainMvpPresenter;
import net.winnerawan.androidx.ui.splash.SplashPresenter;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2017
 */

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }


    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }

    @Provides
    @PerActivity
    SplashMvpPresenter<SplashView> provideSplashPresenter(
            SplashPresenter<SplashView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    MainMvpPresenter<MainView> provideMainPresenter(
            MainPresenter<MainView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    DetailMvpPresenter<DetailView> provideDetailPresenter(
            DetailPresenter<DetailView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    ChartMvpPresenter<ChartView> provideChartPresenter(
            ChartPresenter<ChartView> presenter) {
        return presenter;
    }

}

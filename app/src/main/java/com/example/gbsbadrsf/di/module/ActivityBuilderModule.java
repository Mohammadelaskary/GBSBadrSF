package com.example.gbsbadrsf.di.module;

import com.example.gbsbadrsf.productionsequence.ProductionSequence;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {
    @ContributesAndroidInjector
    abstract ProductionSequence contributeproductionsequencefragment();
}

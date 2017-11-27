package com.example.raulstriglio.livedataroompoc.di.modules;

import android.content.Context;
import com.example.raulstriglio.livedataroompoc.App;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

/**
 * Created by raul.striglio on 24/11/17.
 */

@Module
public class AppModule {

    @Provides
    @Singleton
    Context provideContext(App application) {
        return application;
    }

}

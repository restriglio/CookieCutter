package com.example.globant.livedataroompoc.global;

import android.support.annotation.NonNull;

import com.birbit.android.jobqueue.JobManager;
import com.birbit.android.jobqueue.scheduling.FrameworkJobSchedulerService;

/**
 * Created by raul.striglio on 23/01/18.
 */

public class SchedulerJobService extends FrameworkJobSchedulerService {

    @NonNull
    @Override
    protected JobManager getJobManager() {
        return JobManagerFactory.getJobManager();
    }
}

package com.android.basemvvm.util.scheduler;

import io.reactivex.Scheduler;

/**
 * Allow providing different types of [Scheduler]s.
 */
public interface BaseSchedulerProvider {
    Scheduler computation();
    Scheduler io();
    Scheduler ui();
}

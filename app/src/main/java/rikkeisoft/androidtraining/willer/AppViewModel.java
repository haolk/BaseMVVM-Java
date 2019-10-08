package rikkeisoft.androidtraining.willer;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import rikkeisoft.androidtraining.willer.data.source.Repository;
import rikkeisoft.androidtraining.willer.util.scheduler.SchedulerProvider;

public abstract class AppViewModel extends ViewModel {
    @Inject
    protected Repository repository;
    @Inject
    protected SchedulerProvider schedulerProvider;

    MutableLiveData<Boolean> loader = new MutableLiveData<>();

    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    public AppViewModel() {
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (mCompositeDisposable != null)
            mCompositeDisposable.clear();
    }

    public void showLoading() {
        loader.setValue(true);
    }

    public void closeLoading() {
        loader.setValue(false);
    }

    protected void addDisposable(Disposable disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }
}

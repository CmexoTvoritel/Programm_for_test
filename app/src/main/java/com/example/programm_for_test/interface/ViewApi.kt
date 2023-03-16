package com.example.programm_for_test.`interface`

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ViewApi(application: Application): AndroidViewModel(application) {
    private val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    fun fetchCryptoList(retrofitService: RetrofitService?) {
        retrofitService?.let {
            compositeDisposable.add(retrofitService.getGlobalData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        Log.e("TAG", it.data.toString())
                    },{
                        Log.e("Loh", "Loh")
                    }
                ))
        }

    }

}
package snu.kr.daggerlesson.ui.main

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import snu.kr.daggerlesson.api.API
import snu.kr.daggerlesson.model.Post

class MainPresenter : Main.Presenter {
    private val subscriptions = CompositeDisposable()
    private val api = API.create()
    lateinit var view: Main.View

    override fun subscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun unsubscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun attach(view: Main.View) {
        this.view = view
    }

    override fun loadData() {
        val subscribe = api.getPostList().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ list: List<Post> ->
                    view.showData(list.take(10))
                }, { error ->
                    view.showError()
                    error.printStackTrace()
                })

        subscriptions.add(subscribe)
    }

}
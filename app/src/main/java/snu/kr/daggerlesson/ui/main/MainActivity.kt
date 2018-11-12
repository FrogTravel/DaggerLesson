package snu.kr.daggerlesson.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import snu.kr.daggerlesson.R
import snu.kr.daggerlesson.di.component.DaggerActivityComponent
import snu.kr.daggerlesson.di.module.ActivityModule
import snu.kr.daggerlesson.model.Post
import snu.kr.daggerlesson.ui.main.util.PostAdapter
import javax.inject.Inject

class MainActivity : AppCompatActivity(), Main.View {
    @Inject
    lateinit var presenter: Main.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        injectDependency()
        presenter.attach(this)

        presenter.loadData()
    }

    private fun injectDependency() {
        val activityComponent = DaggerActivityComponent.builder()
                .activityModule(ActivityModule(this))
                .build()

        activityComponent.inject(this)
    }

    override fun showData(posts: List<Post>) {
        recyclerView.adapter = PostAdapter(posts)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun showError() {
        errorTextView.text = "WTF MAAAAN"
    }
}

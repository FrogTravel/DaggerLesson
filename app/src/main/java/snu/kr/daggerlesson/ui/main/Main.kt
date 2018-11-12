package snu.kr.daggerlesson.ui.main

import snu.kr.daggerlesson.BaseMVP
import snu.kr.daggerlesson.model.Post

interface Main {
    interface View: BaseMVP.View{
        fun showData(posts: List<Post>)
        fun showError()
    }

    interface Presenter : BaseMVP.Presenter<Main.View> {
        fun loadData()
    }
}
package snu.kr.daggerlesson

class BaseMVP<in T>{
    interface Presenter<in T>{
        fun subscribe()
        fun unsubscribe()
        fun attach(view: T)
    }

    interface View{

    }
}
package com.gzeinnumer.rxjava2examplekt

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class MainActivity : AppCompatActivity() {
    var tv: TextView? = null

    var str = StringBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv = findViewById(R.id.tv)
        initRX()
        initRXSimple()
    }

    private fun initRXSimple() {
        Observable.create<String> { emitter ->
            str.append("2. Value Default").append("\n")
            setView()
            emitter.onNext("Hello Zein")
            //                emitter.onNext(null); // contoh error
            emitter.onComplete()
        }.subscribe(object : Observer<String> {
            override fun onSubscribe(d: Disposable) {
                str.append("1. Loading onSubscribe").append("\n")
                setView()
            }

            override fun onNext(s: String) {
                str.append("3. onNext ").append(s).append("\n")
                setView()
            }

            override fun onError(e: Throwable) {
                str.append("3. onError ").append(e.message).append("\n")
                setView()
            }

            override fun onComplete() {
                str.append("4. Loading onComplete").append("\n")
                setView()
            }
        })
    }

    private fun initRX() {
        val observaBLE = Observable.create<String> { emitter ->
                str.append("2. Value Default").append("\n")
                setView()
                emitter.onNext("Hello Zein")
                //                emitter.onNext(null); // contoh error
                emitter.onComplete()
            }
        val obserVER: Observer<String> = object : Observer<String> {
                override fun onSubscribe(d: Disposable) {
                    str.append("1. Loading onSubscribe").append("\n")
                    setView()
                }

                override fun onNext(s: String) {
                    str.append("3. onNext ").append(s).append("\n")
                    setView()
                }

                override fun onError(e: Throwable) {
                    str.append("3. onError ").append(e.message).append("\n")
                    setView()
                }

                override fun onComplete() {
                    str.append("4. Loading onComplete").append("\n")
                    setView()
                }
            }
        observaBLE.subscribe(obserVER)
    }

    private fun setView() {
        tv!!.text = str.toString()
    }
}
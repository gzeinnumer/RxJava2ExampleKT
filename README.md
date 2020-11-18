# RxJava2ExampleKT

- Source
  - [Part 1](https://medium.com/nusanet/pengenalan-rxjava-untuk-pemula-bagian-1-2c9895a73c70)
  - [Part 2](https://medium.com/nusanet/pengenalan-rxjava-untuk-pemula-bagian-2-29b843853cd6)

- Implementation
```gradle
implementation 'io.reactivex.rxjava2:rxandroid:2.1.1'
implementation 'io.reactivex.rxjava2:rxjava:2.2.9'
```

- Example 1
```kotlin
var str = StringBuilder()

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
```

- Example 2
```kotlin
var str = StringBuilder()

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
```

- `setview();`
```kotlin
    private fun setView() {
        var tv: TextView = findViewById(R.id.tv)
        tv.text = str.toString()
    }
```

- Preview

<p align="center">
  <img src="https://github.com/gzeinnumer/RxJava2ExampleKT/blob/master/preview/example1.jpg" width="400"/>
</p>


---

**FullCode [MainActivity](https://github.com/gzeinnumer/RxJava2ExampleKT/blob/master/app/src/main/java/com/gzeinnumer/rxjava2examplekt/MainActivity.kt)**

---

```
Copyright 2020 M. Fadli Zein
```
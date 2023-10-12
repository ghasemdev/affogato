[![Version](https://shields.io/badge/VERSION-1.9.0-blue?style=for-the-badge)](https://github.com/ghasemdev/affogato/releases/tag/1.5.2)
[![Kotlin](https://shields.io/badge/Kotlin-1.9.10-pink?style=for-the-badge)](https://kotlinlang.org/)
[![API](https://shields.io/badge/Api-+21-green?style=for-the-badge)](https://www.android.com/)
[![License MIT](https://shields.io/badge/LICENSE-MIT-orange?style=for-the-badge)](https://opensource.org/licenses/MIT)

![affogato_img](assets/affogato.png)

# Affogato

Affogato is a multipurpose library for Jetpack Compose, Android and Kotlin.

### [Core-ktx](https://github.com/ghasemdev/affogato/wiki/Core-Ktx)

Core-ktx is a Kotlin library that provides a set of Kotlin extensions. Like collections, operations,
string, math, random, date time, color, block scope and try-catch functions. Also, `TimeAgo` is my
favorite extension for times 😄.

```kotlin
TimeAgo.format(now()) // a moment ago
now().timeAgo(locale = TimeAgo.Locale.EN) // a moment ago
```

### [Coroutines](https://github.com/ghasemdev/affogato/wiki/Coroutines)

Coroutines module contains suspended try-catch from Core-ktx and `DispatchersProvider` for handling
coroutines context in main and test source.

```Kotlin
// Normal way
suspend fun foo() = withContext(Dispatchers.Default) {
  return try {
    // do something return value
  } catch (_: Exception) {
    null
  }
}

// Affogato way
suspend fun foo() = suspendedTryCatchNull {
  // do something return value
}
```

### [Logger](https://github.com/ghasemdev/affogato/wiki/Logger)

Logger module contains a simple logger for Android. It's a wrapper for `Log` and`Logger` with some
extensions.

```Kotlin
// Setup
Logger.tag = "MyApp"

Logger.isDebug = BuildConfig.DEBUG // if debug mode false onRelease will be called.
Logger.onRealease = { tag, message, throwable ->
  // do something
}

// Extension
logcat { "Hello Affogato" }
logcat(tag = "TAG") { "Hello Affogato" }
logcat(LogLevel.INFO) { "Hello Affogato" }
try {
  // do something
} catch (e: Exception) {
  logcat(throwable = e) { "Hello Affogato" }
}
```

### [Metrica-ktx](https://github.com/ghasemdev/affogato/wiki/Metrica-Ktx)

This module adds Yandex Metrica to your project. You can use it for crashlytics and reporting events
and push notifications.

```kotlin
yandexMetrica("api-key") {
  // configuration
}

@Serializable
data class Foo(val bar: String)
YandexMetricaX.reportEvent("event_name", Foo("bar"))
```

### [Okhttp](https://github.com/ghasemdev/affogato/wiki/Okhttp)

Okhttp builder is part of this module. You can use it for building okhttp client with a simple
syntax. Also, you can track download and upload progress with `DownloadStreamResponseBody`
and `UploadStreamRequestBody`.

```kotlin
val client = okHttp {
  addInterceptor(HttpLoggingInterceptor())
  cache(Cache(cacheDir, cacheSize))
}
```

### [Structure](https://github.com/ghasemdev/affogato/wiki/Structure)

This module contains useful structure class like `DataState` and `EntityMapper`. Also, it contains
`SingletonHolder` for creating singleton classes or `ObjectPool` for creating heavy objects to save
time. You can use checker class for validate phone, email and password.

```kotlin
class SharedPref private constructor(private val context: Context) {
  // ...
  companion object : SingletonHolder<SharedPref, Context>(::SharedPref)
}

StringPool["key"] = "token"
StringPool["key"] // token

Phone("09123456789").isValid() // true
Phone("09123456789").format("IR") // +98 912 345 6789
```

### [Compose Unit Size](https://github.com/ghasemdev/affogato/wiki/Unit-Size)

The unit is one of the **Jetpack Compose** modules of this library, which can support relative
screen sizes in `sdp`, `ssp` and custom create with `@Dimen`. Also, we can
use `rememberWindowSize()` to know in which device we are (Compact, Medium, Expanded) or
use `postureState` to build adaptive and responsive UIs in **Foldables**.

```kotlin
@Dimen(type = "dp", values = ["320:70", "480:80", "600:180", "720:180"])
val icon = 80.dp

dimen.icon // 80.dp in device with width 480.dp
```

# Links

Affogato is currently available for maven/gradle builds
at [Jitpack](https://jitpack.io/#ghasemdev/affogato/1.5.2) (
read [Getting started](https://github.com/ghasemdev/affogato/wiki/Getting-Started)).

* [Wiki](https://github.com/ghasemdev/affogato/wiki)
* [Change log](https://github.com/ghasemdev/affogato/blob/master/CHANGELOG.md)

# Download

### Gradle Setup

Step 1. Add the JitPack repository to your `build.gradle` file

```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Step 2. Add the dependency

```
dependencies {
    implementation 'com.github.ghasemdev.affogato:AFFOGATO_MODULE:AFFOGATO_VERSION'
}
```

---

### Maven Setup

Step 1. Add the JitPack repository to your `build.gradle` file

```
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

Step 2. Add the dependency

```
<dependency>
    <groupId>com.github.ghasemdev.affogato</groupId>
    <artifactId>AFFOGATO_MODULE</artifactId>
    <version>AFFOGATO_VERSION</version>
</dependency>
```

---

### License

```
The MIT License (MIT)

Copyright (c) 2022 ghasemdev

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
associated documentation files (the "Software"), to deal in the Software without restriction,
including without limitation the rights to use, copy, modify, merge, publish, distribute,
sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial
portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES
OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
```

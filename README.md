[![Version](https://shields.io/badge/VERSION-1.0.0--beta02-blue?style=for-the-badge)](https://github.com/ghasemdev/affogato/releases/tag/1.0.0-beta02)
[![Kotlin](https://shields.io/badge/Kotlin-1.7.10-pink?style=for-the-badge)](https://kotlinlang.org/)
[![API](https://shields.io/badge/Api-+21-green?style=for-the-badge)](https://www.android.com/)
[![License MIT](https://shields.io/badge/LICENSE-MIT-orange?style=for-the-badge)](https://opensource.org/licenses/MIT)

![affogato_img](assets/affogato.png)

# Affogato

Affogato is a multipurpose library for Jetpack Compose, Android and Kotlin.

### [Unit](https://github.com/ghasemdev/affogato/wiki/Unit)

The unit is one of the **Jetpack Compose** modules of this library, which can support all screen
sizes in `sdp`, `ssp` or custom create with `@Dimen`.

# Links

Affogato is currently available for maven/gradle builds
at [Jitpack](https://jitpack.io/#ghasemdev/affogato/1.0.0-beta02) (
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

***

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

***

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

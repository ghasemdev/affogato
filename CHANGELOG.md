# Change Log

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](http://keepachangelog.com/)
and this project adheres to [Semantic Versioning](http://semver.org/).

## [🎉 v1.1.1 Core-ktx] - 2022-08-14

### 💥 Breaking Changes

* Rename date parameter in LookupMessages to dateInMillis
* Rename toString -> format in all datetime extensions

### 🐛 Fixes

* Fix duplicated $ sign in `ar` and `fa` TimeAgo Messages

## [🎉 v1.1.0 Core-ktx] - 2022-08-13

### 🚀 Features

* Collections Function (built-in and get functions based on Range and Progression, sorting map,
  rotate, head, tail and ...)
* Operations Function (collection operation add, sub, mul, div and rem, string times and some
  boolean operator)
* String Function (formatting and get functions based on Range and Progression, separate,
  removeDecimalPart, rotate and ... )
* Math Function (math for collection like median, std, variance and more, BD and BI, round with
  digit, infix pow and degree to radian, ... )
* Random Function (choice, choices and nextInt-long based on Progression)
* Date Time Function (convert all type of date time to each other :), now functions and time ago)
* Color Converter (rgb to hex, hex to rgb)
* Block Scope Function
* Try-Catch Functions and Counter

### 💥 Breaking Changes

* Change time ago messages package
* Remove onDate function from LookupMessages class
* Change `as...` function -> `to...` function for date time converters

## [🎉 v1.1.0-beta02 Core-ktx] - 2022-08-13

### 🚀 Features

* Add factory pattern to set local in `TimeAgo`
* Add new languages for `TimeAgo`
* Add cut off, local number, week support for `TimeAgo`
* Add new compact format function for numbers

### 💥 Breaking Changes

* Change time ago messages package
* Remove onDate function from LookupMessages class
* Change `as...` function -> `to...` function for date time converters

### 🐛 Fixes

* Fix TimeAgo arabic issue

### 🧪 Tests

* Add more tests

## [🎉 v1.1.0-beta01 Core-ktx] - 2022-08-10

### 🚀 Features

* Collections Function (built-in and get functions based on Range and Progression, sorting map,
  rotate, head, tail and ...)
* Operations Function (collection operation add, sub, mul, div and rem, string times and some
  boolean operator)
* String Function (formatting and get functions based on Range and Progression, separate,
  removeDecimalPart, rotate and ... )
* Math Function (math for collection like median, std, variance and more, BD and BI, round with
  digit, infix pow and degree to radian, ... )
* Random Function (choice, choices and nextInt-long based on Progression)
* Date Time Function (convert all type of date time to each other :), now functions and time ago)
* Color Converter (rgb to hex, hex to rgb)
* Block Scope Function
* Try-Catch Functions and Counter

## [🎉 v1.0.0 Affogato Unit] - 2022-07-27

### 🚀 Features

* sdp and ssp unit
* Dimen tag for create auto dimensions
* Window Size, Global Window Size, rememberWindowSize()
* Window Orientation, isLandscape
* Posture, postureState, postureFlow, ...
* Hinge Size, hingeWidthDp, hingeHeightDp, ...
* WindowLayoutInfo, windowLayoutInfoState, windowLayoutInfo, ...

## [🎉 v1.0.0-beta05 Affogato Unit] - 2022-07-26

### 🐛 Fixes

* Fix orientation in landscape

## [🎉 v1.0.0-beta04 Affogato Unit] - 2022-07-17

### 🐛 Fixes

* Fix Build Issue

## [🎉 v1.0.0-beta03 Affogato Unit] - 2022-07-17

### 🚀 Features

* Add Window Size
* Add rememberWindowSize()

## [🎉 v1.0.0-beta02 Affogato Unit] - 2022-07-16

### 🚀 Features

* Add new sample

### 🧪 Tests

* Add tests for dimen tag validator

### 💭 Other

* Add doc and update readme

## [🎉 v1.0.0-beta01 Affogato Unit] - 2022-07-15

### 🚀 Features

* Add sdp and ssp unit
* Add Dimen tag for create auto dimensions

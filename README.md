# Native Android library (aar) with dependency of Flutter module

Details: 
+ English (WIP) - https://medium.com/@askarsyzdykov/android-lib-with-flutter-module-a124ffcd758
+ Russian -  https://medium.com/@askarsyzdykov/build-native-android-library-with-a-flutter-dependency-a124ffcd758

### To compile aar follow run the commands below:

Clone this project:
```sh
$ git clone https://github.com/askarsyzdykov/native_flutter_lib.git
```

Go to flutter_library folder:
```sh
$ cd flutter_library/
```

Get dependencies and compile Flutter module:
```sh
$ flutter pub get
$ flutter clean && flutter build aar
```

Make sure that library/build.gradle has uncommented line:
```groovy
embed project(path: ":flutter", configuration: "default")
```
and this line commented:
```groovy
// implementation project(path: ":flutter")
```

*Note*: If you want to run sample app from this project you must invert 
```groovy
implementation project(path: ":flutter")
// embed project(path: ":flutter", configuration: "default")
```

Compile native module:
```sh
$ cd ..
$ ./gradlew clean assemble
```

Done. 

### Aar is ready to be used 🎉 It is located in library/build/outputs/aar/

# KleeGameBaseShared
A library from the KleeGameBase series that contains the classes shared between client and server

To implement this library with Gradle and Jitpack add the following repository to your build.gradle
```
allprojects {
	repositories {
		maven { url 'https://jitpack.io' }
	}
}
```  
Then add the dependency
```
dependencies {
  implementation 'com.github.KleeSup:KleeGameBaseShared:VERSION'
}
```
Note that you need to replace the 'VERSION' part in the dependency with the newest version of the library.

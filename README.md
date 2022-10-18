# KleeGameBaseShared
A library from the KleeGameBase series that contains the classes shared between client and server

## Used Libraries
- crykn his fork of Kryonet [Link](https://github.com/crykn/kryonet)
- Kryo serialization library from Esotericsoftware [Link](https://github.com/EsotericSoftware/kryo)

## Implementation
[![](https://jitpack.io/v/KleeSup/KleeGameBaseShared.svg)](https://jitpack.io/#KleeSup/KleeGameBaseShared)
To implement this library with Gradle and Jitpack, add the following repository to your build.gradle:
```
allprojects {
  repositories {
    maven { url 'https://jitpack.io' }
  }
}
```  
Then add the dependency:
```
dependencies {
  implementation 'com.github.KleeSup:KleeGameBaseShared:VERSION'
}
```
Note that you need to replace the 'VERSION' part in the dependency with the newest version of the library.

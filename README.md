<div align="center">
 <img src = "https://raw.githubusercontent.com/Enrique213-VP/MrOlympiaCompose/main/Assets/Olym.png?raw=true" width = "100%"/>
</div>

<br/>

<h1 align="center">Mr.Olympia</h1>

<div align="center">
    <a href = "https://developer.android.com/jetpack/androidx/versions/all-channel">
      <img src = "https://img.shields.io/badge/Jetpack%20Compose-1.1.1-brightgreen" />
    </a>
<a href="https://github.com/Enrique213-VP"><img alt="Profile" src="https://img.shields.io/badge/Github-Enrique213--VP-blue?logo=Github"/></a>
</div>

<br/>

<div align="center">
Jetpack Compose project about participants of Mr.Olympia that I considerate are goods, either because your history, poses, trophies and hard work in this lifestyle.
</div>
<br/>

## Download
Go to the [Releases](https://github.com/Enrique213-VP/MrOlympiaCompose/releases) to download the latest APK.

<img src="/Assets/olympia.gif" align="right" width="320"/>

## Tech stack & Open-source libraries
- Minimum SDK level 25
- [Kotlin](https://kotlinlang.org/) based, [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) for asynchronous.
- Jetpack
  - Lifecycle: Observe Android lifecycles and handle UI states upon the lifecycle changes.
  - DataBinding: Binds UI components in your layouts to data sources in your app using a declarative format rather than programmatically.
  - [Hilt](https://dagger.dev/hilt/): for dependency injection.
- Architecture
  - MVVM Architecture (View - DataBinding - ViewModel - Model)
- [Recyclerview](https://developer.android.com/jetpack/androidx/releases/recyclerview): Scrolling the data collections.
- [Retrofit2 & OkHttp3](https://github.com/square/retrofit): Construct the REST APIs and paging network data.
- [Moshi](https://github.com/square/moshi/): A modern JSON library for Kotlin and Java.
- [Hilt](https://developer.android.com/training/dependency-injection/hilt-android?hl=es-419): Inject dependencies.
- [Coil](https://coil-kt.github.io/coil/): Loading images from network.
- [Postman](https://www.postman.com/): Built for a mock server for the API.
- [Mock Server](https://learning.postman.com/docs/designing-and-developing-your-api/mocking-data/setting-up-mock/): Built for the API.
- [JUnit](https://junit.org/junit4/): Testing.

<br/>

## Find this repository useful? :grin:
Support it by joining __[stargazers](https://github.com/Enrique213-VP/MrOlympiaCompose/stargazers)__ for this repository. :star: <br>
Also, __[follow me](https://github.com/Enrique213-VP)__ on GitHub for my next creations! :bison:

#

## Screens for demo project
In this case, a mock server in Postman was created to design an API where the data of the MR.Olympia participants are consumed, 
then in the server requests OkHttp was used as a client to visualize the status of the data, thus being able to display this information 
by means of a LazyColumn (RecyclerView), also, If you would see the project in web, you can go to this repository __[Mr.Old](https://github.com/Seb9809/mr-olympia-winners)__

## 

Postman Mock           |  
:-------------------------:
![](https://github.com/Enrique213-VP/MrOlympiaCompose/blob/main/Assets/Postman/Request.png?raw=true)  

## 

Code request OkHttp            |  Structure request Json
:-------------------------:|:-------------------------: 
![](https://github.com/Enrique213-VP/MrOlympiaCompose/blob/main/Assets/okHttp/secondRequestOkHttp.png?raw=true)  |  ![](https://github.com/Enrique213-VP/MrOlympiaCompose/blob/main/Assets/okHttp/secondRequestOkHttp.png.png?raw=true)


# License
```xml
Designed and developed by 2022 Svape (Sergio Vargas)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

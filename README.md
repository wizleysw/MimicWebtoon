# Mimic Webtoon

Naver Webtoon Clone Coding Project in Kotlin to study modern App.

Resource related infos are not included as CopyRight issue.

## Features

- Webtoon List
- Episode List
- Notice
- Settings

## Dev note

Dev details are written in Korean. 

https://bughunting.kr/android/Kotlin%EC%9C%BC%EB%A1%9C-%EB%84%A4%EC%9D%B4%EB%B2%84%EC%9B%B9%ED%88%B0-%ED%81%B4%EB%A1%A0-%EC%BD%94%EB%94%A9%ED%95%B4%EB%B3%B4%EA%B8%B0/

## Objectives

This project is aimed to learn these things.

- kotlin coroutine : coroutine scope experience 
- parse : jsoup 
- coordinate layout : MainActivity

## Dependencies

```
dependencies {
    implementation fileTree(dir: "libs", include: ["*.jar"])
    implementation "org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version"
    implementation 'androidx.core:core-ktx:1.3.1'
    implementation 'androidx.appcompat:appcompat:1.2.0'
    implementation 'androidx.constraintlayout:constraintlayout:1.1.3'
    testImplementation 'junit:junit:4.13'
    androidTestImplementation 'androidx.test.ext:junit:1.1.1'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.2.0'

    //noinspection GradleCompatible
    implementation 'com.android.support:design:25.0.0'

    //noinspection GradleCompatible
    implementation "com.android.support:recyclerview-v7:28.0.0"

    implementation 'androidx.preference:preference:1.1.1'
    implementation 'org.jsoup:jsoup:1.13.1'
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.1.1'

    implementation 'com.github.bumptech.glide:glide:4.11.0'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.11.0'
}
```

## Shape

- MainActivity

![combined main](https://raw.githubusercontent.com/wizleysw/MimicWebtoon/master/img/combined/combined_menu.png)

- EpisodeActivity

![combined detail](https://raw.githubusercontent.com/wizleysw/MimicWebtoon/master/img/combined/combined_episode.png)

- NoticeActivity

![combined notice](https://raw.githubusercontent.com/wizleysw/MimicWebtoon/master/img/combined/combined_webview.png)



# Posts Application
This app use kotlin language and pattern MVP


List 3rd party library.

    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.1")
    //glide
    implementation 'com.github.bumptech.glide:glide:4.12.0'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.11.0'
    //mock
    testImplementation 'org.mockito:mockito-core:3.6.0'
    testImplementation 'org.mockito:mockito-inline:3.6.0'

    testImplementation 'junit:junit:4.+'
    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'

    //Picasso
    def picassoVersion = "2.71828"
    implementation "com.squareup.picasso:picasso:$picassoVersion"

    implementation 'com.github.chrisbanes:PhotoView:2.0.0'

## Features
- List posts from all user
- Post detail
- User Detail
- List photos from user albums
- Detail of photo 

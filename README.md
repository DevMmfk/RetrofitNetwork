# RetrofitNetwork
1 - Add it in your root build.gradle at the end of repositories:
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  ```
 2 - Add the dependency:
  ```
  implementation 'com.github.DevMmfk:RetrofitNetwork:0.0.11'
  ```
3 - Create class extent from Application and add this class in manifests then add Network Config content base url and add add header if exist
  ````
  class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        /**  Set base url and headers for api */
        Initialize.networkConfig("https://...", getHeaderMap())
    }

    private fun getHeaderMap(): HashMap<String, String> {
        val headerMap = HashMap<String, String>()
        /** if you want add header */

        headerMap["Authorization"] = "Bearer ..."
        return headerMap
    }
}
```
In manifests : 
```
 <application
        android:name="com.network.app.MyApp"
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/Theme.MyApplication">
        <activity android:name="com.network.layer.MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>
    ```
    

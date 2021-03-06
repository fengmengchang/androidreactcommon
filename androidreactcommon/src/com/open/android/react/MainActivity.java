package com.open.android.react;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;

import com.facebook.react.LifecycleState;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.shell.MainReactPackage;
import com.open.android.react.packages.CommonReactPackage;

/**
 * 
 *****************************************************************************************************************************************************************************
 * 1.react-native start 开启服务
 * 2.下载index.android.bundle
 * http://localhost:8081/index.android.bundle?platform=android
 * 3.adb reverse tcp:8081 tcp:8081
 * 
 * git clone https://github.com/facebook/react-native.git
cd react-native && npm install
Running the RNTester app on iOS

Now open RNTester/RNTester.xcodeproj and hit Run in Xcode.

Running the RNTester app on Android

Note that you'll need the Android NDK installed, see prerequisites.

./gradlew :RNTester:android:app:installDebug
# Start the packager in a separate shell (make sure you ran npm install):
./scripts/packager.sh
http://localhost:8081/RNTester/js/RNTesterApp.android.js
 * @author :fengguangjing
 * @createTime:2017-6-13下午5:42:56
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class MainActivity extends AppCompatActivity implements DefaultHardwareBackBtnHandler {
	public ReactRootView mReactRootView;
	public ReactInstanceManager mReactInstanceManager;
	public String bundleAssetName = "index.android.bundle";
	public String jSMainModuleName = "index.android";
	public String moduleName = "helloworld";
	public boolean remoteable;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
 
//        bundleAssetName = getIntent().getStringExtra("bundleAssetName");
//        jSMainModuleName = getIntent().getStringExtra("jSMainModuleName");
//        moduleName = getIntent().getStringExtra("moduleName");
        
//        mReactRootView = new ReactRootView(this);
//        mReactInstanceManager = ReactInstanceManager.builder()
//                .setApplication(getApplication())
//                .setBundleAssetName(bundleAssetName)
//                .setJSMainModuleName(jSMainModuleName)
//                .addPackage(new MainReactPackage())
//                .addPackage(new CommonReactPackage())
//                .setUseDeveloperSupport(BuildConfig.DEBUG)
//                .setInitialLifecycleState(LifecycleState.RESUMED)
//                .build();
//        mReactRootView.startReactApplication(mReactInstanceManager, moduleName, null);
//
//        setContentView(mReactRootView);
        initIntent();
        initReactRoot();
    }
    
    /**
     * 接受页面传参
     */
    public void initIntent(){
    	if(getIntent().getStringExtra("bundleAssetName")!=null){
    		bundleAssetName = getIntent().getStringExtra("bundleAssetName");
    	}
    	if(getIntent().getStringExtra("jSMainModuleName")!=null){
    		jSMainModuleName = getIntent().getStringExtra("jSMainModuleName");
    	}
    	if(getIntent().getStringExtra("moduleName")!=null){
    		moduleName = getIntent().getStringExtra("moduleName");
    	}
    }
    
    /**
     * 初始化rootview
     */
    public void initReactRoot(){
    	mReactRootView = new ReactRootView(this);
        mReactInstanceManager = ReactInstanceManager.builder()
                .setApplication(getApplication())
                .setBundleAssetName(bundleAssetName)
                .setJSMainModuleName(jSMainModuleName)
                .addPackage(new MainReactPackage())
                .addPackage(new CommonReactPackage())
                .setUseDeveloperSupport(BuildConfig.DEBUG)
                .setInitialLifecycleState(LifecycleState.RESUMED)
                .build();
        mReactRootView.startReactApplication(mReactInstanceManager, moduleName, null);

        setContentView(mReactRootView);
    }

    @Override
    public void invokeDefaultOnBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (mReactInstanceManager != null) {
            mReactInstanceManager.onHostPause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (mReactInstanceManager != null) {
            mReactInstanceManager.onHostResume(this, this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mReactInstanceManager != null) {
            mReactInstanceManager.onHostDestroy();
        }
    }
    @Override
    public void onBackPressed() {
        if (mReactInstanceManager != null) {
            mReactInstanceManager.onBackPressed();
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_MENU && mReactInstanceManager != null) {
            mReactInstanceManager.showDevOptionsDialog();
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
        	if ( mReactInstanceManager != null) {
                mReactInstanceManager.showDevOptionsDialog();
                return true;
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    public static void startMainActivity(Context context,String bundleAssetName,String jSMainModuleName,String moduleName){
    	Intent intent = new Intent();
    	intent.setClass(context, MainActivity.class);
    	intent.putExtra("bundleAssetName", bundleAssetName);
    	intent.putExtra("jSMainModuleName", jSMainModuleName);
    	intent.putExtra("moduleName", moduleName);
    	context.startActivity(intent);
    }
}

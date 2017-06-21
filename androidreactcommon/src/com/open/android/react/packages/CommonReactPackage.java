/** ***************************************************************************************************************************************************************************** *  * @author :fengguangjing * @createTime:2017-6-13下午4:03:33 * @version:4.2.4 * @modifyTime: * @modifyAuthor: * @description: ***************************************************************************************************************************************************************************** */package com.open.android.react.packages;import java.util.ArrayList;import java.util.Arrays;import java.util.Collections;import java.util.List;import com.facebook.react.ReactPackage;import com.facebook.react.bridge.JavaScriptModule;import com.facebook.react.bridge.NativeModule;import com.facebook.react.bridge.ReactApplicationContext;import com.facebook.react.uimanager.ViewManager;import com.open.android.react.modules.CircleManager;import com.open.android.react.modules.DateDialogModule;import com.open.android.react.modules.RCTReactImageManager;import com.open.android.react.modules.RCTVideoViewManager;import com.open.android.react.modules.ReactSwipeRefreshLayoutManager;import com.open.android.react.modules.ReactWebViewManager;import com.open.android.react.modules.ToastModule;import com.open.android.react.modules.VideoViewManager;/** *****************************************************************************************************************************************************************************  *  * @author :fengguangjing * @createTime:2017-6-13下午4:03:33 * @version:4.2.4 * @modifyTime: * @modifyAuthor: * @description: *****************************************************************************************************************************************************************************  */public class CommonReactPackage implements ReactPackage {	@Override	public List<Class<? extends JavaScriptModule>> createJSModules() {		return Collections.emptyList();	}	/**	 * module	 * 	 * @param reactContext	 * @return	 */	@Override	public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {		List<NativeModule> modules = new ArrayList<NativeModule>();		modules.add(new ToastModule(reactContext));		modules.add(new DateDialogModule(reactContext));		return modules;	}	/**	 * 创建原生UI组件控制器	 * 	 * @param reactContext	 * @return	 */	@Override	public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {		return Arrays.<ViewManager> asList(				new CircleManager(),				new VideoViewManager(),				new RCTVideoViewManager(),				new RCTReactImageManager(),				new ReactWebViewManager(),				new ReactSwipeRefreshLayoutManager()				);	}}
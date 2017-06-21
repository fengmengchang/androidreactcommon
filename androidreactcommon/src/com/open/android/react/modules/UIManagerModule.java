/** ***************************************************************************************************************************************************************************** *  * @author :fengguangjing * @createTime:2017-6-16下午1:54:41 * @version:4.2.4 * @modifyTime: * @modifyAuthor: * @description: ***************************************************************************************************************************************************************************** */package com.open.android.react.modules;import com.facebook.react.bridge.ReactApplicationContext;import com.facebook.react.bridge.ReactContextBaseJavaModule;import com.facebook.react.bridge.ReactMethod;import com.facebook.react.bridge.Callback;import com.facebook.react.uimanager.IllegalViewOperationException;import com.facebook.react.uimanager.PixelUtil;/** *****************************************************************************************************************************************************************************  *  * @author :fengguangjing * @createTime:2017-6-16下午1:54:41 * @version:4.2.4 * @modifyTime: * @modifyAuthor: * @description: *****************************************************************************************************************************************************************************  */public class UIManagerModule extends ReactContextBaseJavaModule {	public UIManagerModule(ReactApplicationContext reactContext) {		super(reactContext);	}	/**	 * UIManager.measureLayout(		  100,		  100,		  (msg) => {		    console.log(msg);		  },		  (x, y, width, height) => {		    console.log(x + ':' + y + ':' + width + ':' + height);		  }		);	 */	@ReactMethod	public void measureLayout(int tag, int ancestorTag, Callback errorCallback, Callback successCallback) {		try {			float[] mMeasureBuffer = new float[4];//			measureLayout(tag, ancestorTag, mMeasureBuffer);			float relativeX = PixelUtil.toDIPFromPixel(mMeasureBuffer[0]);			float relativeY = PixelUtil.toDIPFromPixel(mMeasureBuffer[1]);			float width = PixelUtil.toDIPFromPixel(mMeasureBuffer[2]);			float height = PixelUtil.toDIPFromPixel(mMeasureBuffer[3]);			successCallback.invoke(relativeX, relativeY, width, height);		} catch (IllegalViewOperationException e) {			errorCallback.invoke(e.getMessage());		}	}	/* (non-Javadoc)	 * @see com.facebook.react.bridge.NativeModule#getName()	 */	@Override	public String getName() {		// TODO Auto-generated method stub		return "UIManagerModule";	}}
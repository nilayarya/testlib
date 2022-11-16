package com.haptikrnlib

import ai.haptik.android.wrapper.sdk.HaptikSDK
import ai.haptik.android.wrapper.sdk.model.InitData
import ai.haptik.android.wrapper.sdk.model.SignupData
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import org.json.JSONObject


class HaptikRnLibModule(reactContext: ReactApplicationContext) :
  ReactContextBaseJavaModule(reactContext) {

  override fun getName(): String {
    return NAME
  }

  // Example method
  // See https://reactnative.dev/docs/native-modules-android

  val initData = InitData()

  @ReactMethod
  fun setprimaryColor(col_ : String){
    initData.primaryColor = col_
  }

  @ReactMethod
  fun setenableTypingSuggestion(flag : Boolean){
    initData.enableTypingSuggestions = flag
  }

  @ReactMethod
  fun sethideComposer(flag : Boolean){
    initData.hideComposer = flag
  }

  @ReactMethod
  fun setnoHeader(flag : Boolean){
    initData.noHeader = flag
  }

  @ReactMethod
  fun setprivacyPolicyUrl(link_ : String){
    initData.privacyPolicyUrl = link_
  }

  @ReactMethod
  fun setinitializeLanguage(lng_ : String){
    initData.initializeLanguage = lng_
  }

  @ReactMethod
  fun setcomposerPlaceholder(plcholder_ : String){
    initData.composerPlaceholder = plcholder_
  }

  @ReactMethod
  fun setcustomCss(link_ : String){
    initData.customCss = link_
  }

  @ReactMethod
  fun setdefaultInitdata() {
    initData.primaryColor = "#420420"
    initData.enableTypingSuggestions = true
    initData.hideComposer = true
    initData.noHeader = true
    initData.initializeLanguage = "en"
    initData.composerPlaceholder = "Type Message...."
  }


  var isLaunchMessage = false;
  var msg = "";
  @ReactMethod
  fun setLaunchMessage(msg_ : String){
    isLaunchMessage = true
    msg = msg_
  }

  var isCustomSignup = false
  val signupData = SignupData()
  @ReactMethod
  fun setSignupData(authCode_ : String, authId_ : String, signupType_ : String) {
      isCustomSignup = true
      signupData.authCode = authCode_
      signupData.authId = authId_
      signupData.signupType = signupType_
      signupData.customData = JSONObject().apply {
        put("custom-data-one", "date-one")
        put("custom-data-two", "data-two")
      }
  }

@ReactMethod
  fun HaptikSDKinit() {
    val context = reactApplicationContext
    HaptikSDK.init(context, initData)
    HaptikSDK.init(context, initData)
    if(isLaunchMessage==true) { HaptikSDK.setLaunchMessage(msg) }
    if(!isCustomSignup) { HaptikSDK.loadGuestConversation() }
    else { HaptikSDK.loadConversation(signupData) }
  }

  @ReactMethod
  fun HaptikSDKlogout() {
    val context = reactApplicationContext
    HaptikSDK.logout(context)
  }

  companion object {
    const val NAME = "HaptikRnLib"
  }
}




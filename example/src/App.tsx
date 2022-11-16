/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow strict-local
 */

 import React from 'react';
 import type {Node} from 'react'; 
 import {SafeAreaView, StyleSheet, View, Button} from 'react-native';
 import {NativeModules} from 'react-native';
 /* $FlowFixMe[missing-local-annot] The type annotation(s) required by Flow's
  * LTI update could not be added via codemod */

 /*Init all Data Here before starting Bot Activity*/

 /*NativeModules.HaptikRnLib.setprimaryColor("#420420");
 NativeModules.HaptikRnLib.setenableTypingSuggestion(false);
 NativeModules.HaptikRnLib.sethideComposer(false);
 NativeModules.HaptikRnLib.setnoHeader(true);
 NativeModules.HaptikRnLib.setinitializeLanguage("en");
 NativeModules.HaptikRnLib.setcomposerPlaceholder("Type Message....");
 NativeModules.HaptikRnLib.setSignupData("XYZ","34345","uber");

 NativeModules.HaptikRnLib.setLaunchMessage("this is from js side. HI");
 NativeModules.HaptikRnLib.setSignupData("XYZ","34345","uber");*/



 const App: () => Node = () => {
   const backgroundStyle = {
     backgroundColor: 'white',
   };
 
   return (
     <SafeAreaView style={backgroundStyle}>
       <View style={styles.buttonContainer}>
         <Button onPress={() => NativeModules.HaptikRnLib.HaptikSDKinit()} title="Start native activity" />
       </View>
     </SafeAreaView>
   );
 };
 
 const styles = StyleSheet.create({
   buttonContainer: {
     height: '100%',
     width: '50%',
     justifyContent: 'space-between',
     alignSelf: 'center',
     marginTop: '50%',
   },
 });
 
 export default App;


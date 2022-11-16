import {NativeModules} from 'react-native';

function showSDK () {
   return NativeModules.HaptikRnLib.navigateToExample();
}

module.exports = showSDK
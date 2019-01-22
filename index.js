import {NativeModules, Platform, ActionSheetIOS} from 'react-native';

const {RNActionSheet} = NativeModules;

const ActionSheet = (props, callback) => {
  const {options, title, destructiveButtonIndex, cancelButtonIndex} = props;
  if(Platform.OS === "ios") {
    ActionSheetIOS.showActionSheetWithOptions({
      title                 : title,
      options               : options,
      destructiveButtonIndex: destructiveButtonIndex,
      cancelButtonIndex     : cancelButtonIndex
    }, callback)
  } else {
    RNActionSheet.show(title, options, callback)
  }
};
export default ActionSheet;

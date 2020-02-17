import {NativeModules, Platform, ActionSheetIOS} from 'react-native';
import PropTypes from 'prop-types';

const {RNActionsheet} = NativeModules;

const ActionSheet = (props, callback) => {
  const {optionsIOS, optionsAndroid, title, tintColor, message, destructiveButtonIndex, cancelButtonIndex, onCancelAndroidIndex} = props;
  if(Platform.OS === "ios") {
    ActionSheetIOS.showActionSheetWithOptions({
      title                 : title,
      message               : message,
      tintColor             : tintColor,
      options               : optionsIOS,
      destructiveButtonIndex: destructiveButtonIndex === null ? undefined : destructiveButtonIndex,
      cancelButtonIndex     : cancelButtonIndex,
    }, callback)
  } else {
    RNActionsheet.show(title, optionsAndroid, onCancelAndroidIndex, callback)
  }
};
ActionSheet.propTypes = {
  optionsIOS            : PropTypes.array.isRequired,
  optionsAndroid        : PropTypes.array.isRequired,
  title                 : PropTypes.string.isRequired,
  message               : PropTypes.string,
  tintColor             : PropTypes.string,
  destructiveButtonIndex: PropTypes.number,
  cancelButtonIndex     : PropTypes.number,
  onCancelAndroidIndex  : PropTypes.number.isRequired,
};
export default ActionSheet;

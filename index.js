import {NativeModules, Platform, ActionSheetIOS} from 'react-native';
import PropTypes from 'prop-types';

const {RNActionsheet} = NativeModules;

const ActionSheet = (props, callback) => {
  const {optionsIOS, optionsAndroid, title, destructiveButtonIndex, cancelButtonIndex} = props;
  if(Platform.OS === "ios") {
    ActionSheetIOS.showActionSheetWithOptions({
      title                 : title,
      options               : optionsIOS,
      destructiveButtonIndex: destructiveButtonIndex,
      cancelButtonIndex     : cancelButtonIndex
    }, callback)
  } else {
    RNActionsheet.show(title, optionsAndroid, callback)
  }
};
ActionSheet.propTypes = {
  optionsIOS            : PropTypes.array.isRequired,
  optionsAndroid        : PropTypes.array.isRequired,
  title                 : PropTypes.string.isRequired,
  destructiveButtonIndex: PropTypes.number,
  cancelButtonIndex     : PropTypes.number,
}
export default ActionSheet;

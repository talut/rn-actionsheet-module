import {ActionSheetIOS, NativeModules, Platform} from 'react-native';

const {RNActionsheet} = NativeModules;

const ActionSheet = (props, callback) => {
    const {
        optionsIOS,
        optionsAndroid,
        title,
        tintColor,
        backgroundColor,
        message,
        destructiveButtonIndex,
        cancelButtonIndex,
        onCancelAndroidIndex
    } = props;
    if (Platform.OS === "ios") {
        ActionSheetIOS.showActionSheetWithOptions({
            title: title,
            message: message,
            tintColor: tintColor,
            options: optionsIOS,
            destructiveButtonIndex: destructiveButtonIndex ? destructiveButtonIndex : undefined,
            cancelButtonIndex: cancelButtonIndex,
        }, callback)
    } else {
        RNActionsheet.show(title, optionsAndroid, onCancelAndroidIndex, tintColor, backgroundColor, callback)
    }
};

export default ActionSheet;

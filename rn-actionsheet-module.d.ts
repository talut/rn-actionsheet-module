// Type definitions for react-native-wizard 2.1.1
// Project: https://github.com/talut/react-native-wizard
// Definitions by: Talut TASGIRAN <https://github.com/talut>
// TypeScript Version: 2.8

declare module "rn-actionsheet-module" {
    import {FunctionComponent} from "react"

    interface ActionSheetProps {
        optionsIOS: string[],
        optionsAndroid: string[],
        title: string,
        message: string,
        tintColor?: string,
        destructiveButtonIndex?: number,
        cancelButtonIndex?: number,
        onCancelAndroidIndex: number,
    }

    const RNActionSheetModule: FunctionComponent<ActionSheetProps>
    export default RNActionSheetModule
}


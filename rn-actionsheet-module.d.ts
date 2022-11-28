// Type definitions for rn-actionsheet-module 1.0.4
// Project: https://github.com/talut/rn-actionsheet-module
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

    const ActionSheet: FunctionComponent<ActionSheetProps>
    export default ActionSheet
}


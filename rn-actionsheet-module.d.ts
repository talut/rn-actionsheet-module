// Type definitions for rn-actionsheet-module 1.0.4
// Project: https://github.com/talut/rn-actionsheet-module
// Definitions by: Talut TASGIRAN <https://github.com/talut>
// TypeScript Version: 2.8

declare module "rn-actionsheet-module" {

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

    interface ActionSheetCallback {
        (index: number): void
    }

    interface IActionSheet {
        props: ActionSheetProps,
        callback: ActionSheetCallback
    }


    const ActionSheet: IActionSheet
    export default ActionSheet
}


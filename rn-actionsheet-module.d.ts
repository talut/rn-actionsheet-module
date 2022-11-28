// Type definitions for rn-actionsheet-module 1.0.4
// Project: https://github.com/talut/rn-actionsheet-module
// Definitions by: Talut TASGIRAN <https://github.com/talut>
// TypeScript Version: 2.8

declare module "rn-actionsheet-module" {

  /**
   * Props for ActionSheet
   * @interface ActionSheetProps
   * @property {string[]} optionsIOS - Options for iOS
   * @property {string[]} optionsAndroid - Options for Android
   * @property {string} title - Title of ActionSheet
   * @property {string} message - Message of ActionSheet
   * @property {string} [tintColor] - Tint color of ActionSheet
   * @property {string} [backgroundColor] - Background color of ActionSheet (Android only)
   * @property {number} [destructiveButtonIndex] - Index of destructive button
   * @property {number} [cancelButtonIndex] - Index of cancel button
   * @property {number} onCancelAndroidIndex - Index of cancel button for Android
   */
  interface ActionSheetProps {
    optionsIOS: string[],
    optionsAndroid: string[],
    title: string,
    message?: string,
    tintColor?: string,
    backgroundColor?: string,
    destructiveButtonIndex?: number | null,
    cancelButtonIndex?: number,
    onCancelAndroidIndex: number,
  }

  /**
   * Callback function for action sheet
   * @param index Index of selected option
   */
  interface ActionSheetOnSelect {
    (index: number): void;
  }

  const ActionSheet: (props: ActionSheetProps, onSelect: ActionSheetOnSelect) => void;
  export default ActionSheet;
}


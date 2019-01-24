# React Native ActionSheet
With this package you can easily use picker with onPress function.

Also this package is workaround for Android Picker problem (https://github.com/facebook/react-native/issues/15556). 

Using [`ActionSheetIOS`](https://facebook.github.io/react-native/docs/actionsheetios) component for IOS and using `RecyclerView` and `BottomSheetDialog` for Android as `NativeModule`. 

<img src="./docs/rn-actionsheet-module-android.png"> <img src="./docs/rn-actionsheet-module-ios.png">

## Getting Started

**With NPM**

```
npm install --save rn-actionsheet-module
```

**With YARN**

```
yarn add rn-actionsheet-module
```

**Automatic linking**

```
react-native link rn-actionsheet-module
```

**Manual Linking**

**[Manual Installation](/docs/manual-installation.md)** (If something went wrong with react-native link)

## Props

| Props                 | Type | Required | OS         |
|-----------------------|------|----------|------------|
|optionsIOS             |number|**Yes**   |IOS         |
|optionsAndroid         |array |**Yes**   |Android     |
|title                  |string|**Yes**   |Android, IOS|
|destructiveButtonIndex |object|No        |IOS         |
|cancelButtonIndex      |func  |No        |IOS         |

## Usage

```javascript
import ActionSheet from 'rn-actionsheet-module'

<TouchableOpacity onPress={() => {
   ActionSheet(
       {
          title             : "Lorem ipsum",
          optionsIOS        : ["Cancel", "From Gallery", "From Camera"],
          optionsAndroid    : ["From Gallery", "From Camera"],
          cancelButtonIndex : 0
       }, (index) => {
        alert(index)
       }
   )
}}>
  <Text>Show ActionSheet</Text>
</TouchableOpacity>
```

## FYI
You can use more than one ActionSheet in same screen.

## License
This project is licensed under the MIT License - see the [LICENSE.md](./LICENSE.md) file for details

# RNActionSheet - rn-actionsheet

## Getting started

`npm install rn-actionsheet --save`
`yarn add rn-actionsheet`

### Automatic Installation

`$ react-native link rn-actionsheet`

#### Manual Installation for Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.taluttasgiran.actionsheet.RNActionsheetPackage;` to the imports at the top of the file
  - Add `new RNActionsheetPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':rn-actionsheet'
  	project(':rn-actionsheet').projectDir = new File(rootProject.projectDir, 	'../node_modules/rn-actionsheet/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      implementation project(':rn-actionsheet')
  	```


## Usage
```javascript
import ActionSheet from 'rn-actionsheet';
```
  
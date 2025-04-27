- After setting up, delete this file.

## Project setup

- [dart_common_dev](https://github.com/lastpolukrovka/dev/blob/main/SETUP.md#dart_common_dev)
- [dart_desktop_dev](https://github.com/lastpolukrovka/dev/blob/main/SETUP.md#dart_desktop_dev)
- [dart_mobile_dev](https://github.com/lastpolukrovka/dev/blob/main/SETUP.md#dart_mobile_dev)
- [dart_web_dev](https://github.com/lastpolukrovka/dev/blob/main/SETUP.md#dart_web_dev)
- [kotlin_android_dev](https://github.com/lastpolukrovka/dev/blob/main/SETUP.md#kotlin_android_dev)
- [typescript_api_dev](https://github.com/lastpolukrovka/dev/blob/main/SETUP.md#typescript_api_dev)

### dart_common_dev

- If you need to change the application name from 'dart_common_dev' to 'dart_common_${your_name}':
- - 'dart_common_dev/pubspec.yaml':
- - - 'name: dart_common_dev' to 'name: dart_common_${your_name}'

### dart_desktop_dev

- If you need to change the application name from 'dart_desktop_dev' to 'dart_desktop_${your_name}':
- - 'dart_desktop_dev/pubspec.yaml':
- - - 'name: dart_desktop_dev' to 'name: dart_desktop_${your_name}'
 
- Delete directories:
- - linux 
- - macos
- - windows

- Commands:
- - cd dart_desktop_${your_name}
- - flutter create --org com --template=app --platforms=windows,macos,linux .

### dart_mobile_dev

- If you need to change the application name from 'dart_mobile_dev' to 'dart_mobile_${your_name}':
- - 'dart_mobile_dev/pubspec.yaml':
- - - 'name: dart_mobile_dev' to 'name: dart_mobile_${your_name}'

- Delete directories:
- - android
- - ios

- Commands:
- - cd dart_mobile_${your_name}
- - flutter create --org com --template=app --platforms=android,ios .

### dart_web_dev

- If you need to change the application name from 'dart_web_dev' to 'dart_web_${your_name}':
- - 'dart_web_dev/app/pubspec.yaml':
- - - 'name: dart_web_dev' to 'name: dart_web_${your_name}'

- Delete directories:
- - web

- Commands:
- - cd dart_web_${your_name}
- - flutter create --org com --template=app --platforms=web .

### kotlin_android_dev

- If you need to change the application name from 'kotlin_android_dev' to 'kotlin_android_${your_name}':
- - 'kotlin_android_dev/settings.gradle.kts':
- - - 'rootProject.name = "kotlin_android_dev"' to 'rootProject.name = "kotlin_android_${your_name}"'
- - 'kotlin_android_dev/app/build.gradle.kts':
- - - 'namespace = "com.kotlin_android_dev"' to 'namespace = "com.kotlin_android_${your_name}"'
- - - 'applicationId = "com.kotlin_android_dev"' to 'applicationId = "com.kotlin_android_${your_name}"'
- - 'kotlin_android_dev/app/src/main/res/values/strings.xml':
- - - '<string name="app_name">KotlinAndroidDev/string>' to '<string name="app_name">${your_name}</string>'
- - 'kotlin_android_dev/app/src/main/kotlin/com/kotlin_android_dev' to 'kotlin_android_${your_name}/app/src/main/kotlin/com/kotlin_android_${your_name}'

### typescript_api_dev

- If you need to change the application name from 'typescript_api_dev' to 'typescript_api_${your_name}':
- - 'typescript_api_dev/app/package.json':
- - - '"name": "typescript_api_dev"' to '"name": "typescript_api_${your_name}"'
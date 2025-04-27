import 'package:dart_desktop_dev/named_theme/base_named_theme.dart';
import 'package:dart_desktop_dev/named_theme/dark_theme.dart';
import 'package:dart_desktop_dev/named_theme/light_theme.dart';
import 'package:flutter/material.dart';

@immutable
final class FlutterThemeUtility {
  const FlutterThemeUtility._();

  static BaseNamedTheme getNamedThemeFromContext(BuildContext context) {
    if(Theme.of(context).brightness == Brightness.dark) {
      return DarkTheme();
    }
    return LightTheme();
  }
}
import 'package:dart_mobile_dev/named_theme/base_named_theme.dart';
import 'package:flutter/material.dart';

@immutable
final class DarkTheme extends BaseNamedTheme {
  const DarkTheme();

  @override
  Color get backgroundPrimary => Color.fromRGBO(34, 34, 34, 1.0);

  @override
  Color get backgroundSecondary => Color.fromRGBO(37, 39, 42, 1.0);

  @override
  Color get border => Color.fromRGBO(230, 234, 239, 1.0);

  @override
  Color get brand => Color.fromRGBO(255, 119, 0, 1.0);

  @override
  Color get onBrand => Color.fromRGBO(34, 34, 34, 1.0);

  @override
  Color get text => Color.fromRGBO(255, 255, 255, 1.0);

  @override
  Color get hintText => Color.fromRGBO(160, 160, 160, 1.0);
}
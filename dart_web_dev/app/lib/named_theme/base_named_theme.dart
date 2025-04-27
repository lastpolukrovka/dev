import 'package:flutter/material.dart';

@immutable
abstract base class BaseNamedTheme {
  const BaseNamedTheme();

  Color get backgroundPrimary;
  Color get backgroundSecondary;
  Color get border;
  Color get brand;
  Color get onBrand;
  Color get text;
  Color get hintText;
}
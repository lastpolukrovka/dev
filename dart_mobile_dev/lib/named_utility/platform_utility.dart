import 'package:flutter/material.dart';
import 'package:responsive_framework/responsive_framework.dart';

@immutable
final class PlatformUtility {
  const PlatformUtility._();

  static Widget getNamedWidgetFromContextAndMobileWidgetAndTabletWidgetAndLargeTabletWidget(
      BuildContext context,
      {required Widget mobileWidget,
      Widget? tabletWidget,
      Widget? largeTabletWidget})
  {
    if(ResponsiveBreakpoints.of(context).isMobile) {
      return mobileWidget;
    }
    if(ResponsiveBreakpoints.of(context).isTablet) {
      return tabletWidget ?? mobileWidget;
    }
    return largeTabletWidget ?? mobileWidget;
  }

  static TextTheme getTextThemeFromContextAndColor(BuildContext context, Color color) {
    if(ResponsiveBreakpoints.of(context).isMobile) {
      return TextTheme(
          headlineMedium: TextStyle(
              fontSize: 26.0,
              fontWeight: FontWeight.w600,
              fontFamily: "Inter",
              color: color),
          bodyLarge: TextStyle(
              fontSize: 18.0,
              fontWeight: FontWeight.w500,
              fontFamily: "Inter",
              color: color),
          bodyMedium: TextStyle(
              fontSize: 16.0,
              fontWeight: FontWeight.w500,
              fontFamily: "Inter",
              color: color),
          bodySmall: TextStyle(
              fontSize: 14.0,
              fontWeight: FontWeight.w400,
              fontFamily: "Inter",
              color: color)
      );
    }
    if(ResponsiveBreakpoints.of(context).isTablet) {
      return TextTheme(
          headlineMedium: TextStyle(
              fontSize: 28.0,
              fontWeight: FontWeight.w600,
              fontFamily: "Inter",
              color: color),
          bodyLarge: TextStyle(
              fontSize: 20.0,
              fontWeight: FontWeight.w500,
              fontFamily: "Inter",
              color: color),
          bodyMedium: TextStyle(
              fontSize: 18.0,
              fontWeight: FontWeight.w500,
              fontFamily: "Inter",
              color: color),
          bodySmall: TextStyle(
              fontSize: 16.0,
              fontWeight: FontWeight.w400,
              fontFamily: "Inter",
              color: color)
      );
    }
    return TextTheme(
        headlineMedium: TextStyle(
            fontSize: 30.0,
            fontWeight: FontWeight.w600,
            fontFamily: "Inter",
            color: color),
        bodyLarge: TextStyle(
            fontSize: 22.0,
            fontWeight: FontWeight.w500,
            fontFamily: "Inter",
            color: color),
        bodyMedium: TextStyle(
            fontSize: 20.0,
            fontWeight: FontWeight.w500,
            fontFamily: "Inter",
            color: color),
        bodySmall: TextStyle(
            fontSize: 18.0,
            fontWeight: FontWeight.w400,
            fontFamily: "Inter",
            color: color)
    );
  }
}
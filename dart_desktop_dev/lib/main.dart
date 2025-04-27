import 'package:dart_desktop_dev/named_utility/system_tray_utility.dart';
import 'package:dart_desktop_dev/named_utility/window_manager_utility.dart';
import 'package:dart_desktop_dev/named_vm/app_vm/app_vm.dart';
import 'package:flutter/material.dart';

Future<void> main() async {
  WidgetsFlutterBinding.ensureInitialized();
  await SystemTrayUtility.initSystemTrayParameterAppWindow();
  await WindowManagerUtility.initParameterWindowManager();
  runApp(AppVM());
}

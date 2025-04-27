import 'package:flutter/material.dart';
import 'package:dart_mobile_dev/named_vm/app_vm/app_vm.dart';

Future<void> main() async {
  WidgetsFlutterBinding.ensureInitialized();
  runApp(AppVM());
}

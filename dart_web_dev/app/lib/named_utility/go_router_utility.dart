import 'package:dart_web_dev/named_utility/keys_routers_utility.dart';
import 'package:dart_web_dev/named_vm/example_vm/example_vm.dart';
import 'package:dart_web_dev/named_vm/main_vm/main_vm.dart';
import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';

@immutable
final class GoRouterUtility {
  static final GoRouter goRouter = GoRouter(
      initialLocation: KeysRoutersUtility.mainVM,
      routes: [
        GoRoute(
            path: KeysRoutersUtility.mainVM,
            builder: (BuildContext context, GoRouterState state) => MainVM()),
        GoRoute(
            path: KeysRoutersUtility.exampleVM,
            builder: (BuildContext context, GoRouterState state) => ExampleVM())
      ],
      redirect: (BuildContext context, GoRouterState state) {
        return null;
      },
      errorBuilder: (BuildContext context, GoRouterState state) {
        return Container(
          color: Colors.red,
          child: Center(
              child: Text("404 Not found")
          ),
        );
      });

  const GoRouterUtility._();
}
import 'package:dart_desktop_dev/named_utility/keys_routers_utility.dart';
import 'package:dart_desktop_dev/named_vm/main_vm/main_vm.dart';
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
      ],
      redirect: (BuildContext context, GoRouterState state) {
        return null;
      });

  const GoRouterUtility._();
}
import 'package:dart_common_dev/named_utility/ready_data_utility.dart';
import 'package:dart_desktop_dev/l10n/app_localizations.dart';
import 'package:dart_desktop_dev/named_utility/go_router_utility.dart';
import 'package:dart_desktop_dev/named_utility/keys_breakpoints_utility.dart';
import 'package:dart_desktop_dev/named_utility/window_manager_utility.dart';
import 'package:dart_desktop_dev/named_vm/app_vm/data_for_app_vm.dart';
import 'package:dart_desktop_dev/named_vm/app_vm/enum_data_for_app_vm.dart';
import 'package:flutter/material.dart';
import 'package:library_architecture_mvvm_modify/library_architecture_mvvm_modify.dart' as lamm;
import 'package:responsive_framework/responsive_framework.dart';
import 'package:window_manager/window_manager.dart';

final class AppVM extends StatefulWidget {
  const AppVM({super.key});

  @override
  State<AppVM> createState() => _AppVMState();
}

final class _AppVMState extends State<AppVM> with WindowListener {
  // ModelWrapperRepository
  // NamedUtility

  // TempCacheProvider
  final _tempCacheProvider = lamm.TempCacheProvider();

  // NamedStreamWState
  late final lamm.BaseNamedStreamWState<DataForAppVM> _namedStreamWState;

  @override
  Widget build(BuildContext context) {
    final dataWNamed = _namedStreamWState.getDataForNamed;
    switch(dataWNamed.getEnumDataForNamed) {
      case EnumDataForAppVM.isLoading:
        return Container(color: Colors.white);
      case EnumDataForAppVM.exception:
        return Container(
          color: Colors.red,
          child: Center(
              child: Text("Exception: ${dataWNamed.exceptionController.getKeyParameterException}")
          ),
        );
      case EnumDataForAppVM.success:
        return MaterialApp.router(
            debugShowCheckedModeBanner: true,
            title: "",
            themeMode: ThemeMode.dark,
            theme: ThemeData(
                useMaterial3: true,
                brightness: Brightness.light),
            darkTheme: ThemeData(
                useMaterial3: true,
                brightness: Brightness.dark),
            localizationsDelegates: AppLocalizations.localizationsDelegates,
            supportedLocales: AppLocalizations.supportedLocales,
            builder: (context, child) => ResponsiveBreakpoints.builder(
              child: child!,
              breakpoints: [
                const Breakpoint(start: 0,end: 599, name: MOBILE),
                const Breakpoint(start: 600,end: 900, name: TABLET),
                const Breakpoint(start: 901, end: 1300, name: KeysBreakpointsUtility.largeTablet),
                const Breakpoint(start: 1301,end: 2047, name: DESKTOP),
                const Breakpoint(start: 2048,end: 2560, name: KeysBreakpointsUtility.largeDesktop),
                const Breakpoint(start: 2561,end: double.infinity, name: KeysBreakpointsUtility.tv),
              ],),
            routerConfig: GoRouterUtility.goRouter
        );
    }
  }

  @override
  void initState() {
    _namedStreamWState = lamm.DefaultStreamWState(DataForAppVM(true));
    super.initState();
    WindowManagerUtility.addFromWindowListenerParameterWindowManager(this);
    _init();
  }

  @override
  void dispose() {
    _tempCacheProvider.dispose([]);
    _namedStreamWState.dispose();
    WindowManagerUtility.removeFromWindowListenerParameterWindowManager(this);
    super.dispose();
  }

  @override
  void onWindowClose() {
    WindowManagerUtility.hideParameterWindowManager();
  }

  Future<void> _init() async {
    _namedStreamWState.listenStreamDataForNamedFromCallback((event) {
      setState(() {});
    });
    final firstRequest = await _firstRequest();
    lamm.debugPrint("AppVM: $firstRequest");
    if(!mounted) {
      return;
    }
    _namedStreamWState.notifyStreamDataForNamed();
  }

  Future<String> _firstRequest() async {
    await Future.delayed(const Duration(seconds: 1));
    _namedStreamWState.getDataForNamed.isLoading = false;
    return ReadyDataUtility.success;
  }
}
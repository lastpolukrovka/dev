import 'package:dart_common_dev/named_utility/ready_data_utility.dart';
import 'package:dart_desktop_dev/named_utility/flutter_theme_utility.dart';
import 'package:dart_desktop_dev/named_utility/platform_utility.dart';
import 'package:dart_desktop_dev/named_vm/example_vm/data_for_example_vm.dart';
import 'package:dart_desktop_dev/named_vm/example_vm/enum_data_for_example_vm.dart';
import 'package:flutter/material.dart';
import 'package:library_architecture_mvvm_modify/library_architecture_mvvm_modify.dart' as lamm;

final class ExampleVM extends StatefulWidget {
  const ExampleVM({super.key});

  @override
  State<ExampleVM> createState() => _ExampleVMState();
}

final class _ExampleVMState extends State<ExampleVM> {
  // ModelWrapperRepository
  // NamedUtility

  // TempCacheProvider
  final _tempCacheProvider = lamm.TempCacheProvider();

  // NamedStreamWState
  late final lamm.BaseNamedStreamWState<DataForExampleVM> _namedStreamWState;

  @override
  Widget build(BuildContext context) {
    final namedThemeFromContext = FlutterThemeUtility.getNamedThemeFromContext(context);
    final textThemeFromContextAndColor = PlatformUtility.getTextThemeFromContextAndColor(context, namedThemeFromContext.text);
    final dataWNamed = _namedStreamWState.getDataForNamed;
    switch(dataWNamed.getEnumDataForNamed) {
      case EnumDataForExampleVM.isLoading:
        return PlatformUtility.getNamedWidgetFromSeven(
            context,
            mobileWidget: Scaffold(
              backgroundColor: namedThemeFromContext.backgroundPrimary,
              appBar: AppBar(
                backgroundColor: namedThemeFromContext.backgroundPrimary,
                title: Text(
                    "Flutter App",
                    style: textThemeFromContextAndColor.headlineMedium),
              ),
              body: Center(
                child: CircularProgressIndicator(
                    color: namedThemeFromContext.text),
              ),
            ),
            tabletWidget: Scaffold(
              backgroundColor: namedThemeFromContext.backgroundPrimary,
              appBar: AppBar(
                backgroundColor: namedThemeFromContext.backgroundPrimary,
                title: Text(
                    "Flutter App",
                    style: textThemeFromContextAndColor.headlineMedium),
              ),
              body: Center(
                child: CircularProgressIndicator(
                    color: namedThemeFromContext.text),
              ),
            ),
            largeTabletWidget: Scaffold(
              backgroundColor: namedThemeFromContext.backgroundPrimary,
              appBar: AppBar(
                backgroundColor: namedThemeFromContext.backgroundPrimary,
                title: Text(
                    "Flutter App",
                    style: textThemeFromContextAndColor.headlineMedium),
              ),
              body: Center(
                child: CircularProgressIndicator(
                    color: namedThemeFromContext.text),
              ),
            ),
            desktopWidget: Scaffold(
              backgroundColor: namedThemeFromContext.backgroundPrimary,
              appBar: AppBar(
                backgroundColor: namedThemeFromContext.backgroundPrimary,
                title: Text(
                    "Flutter App",
                    style: textThemeFromContextAndColor.headlineMedium),
              ),
              body: Center(
                child: CircularProgressIndicator(
                    color: namedThemeFromContext.text),
              ),
            ),
            largeDesktopWidget: Scaffold(
              backgroundColor: namedThemeFromContext.backgroundPrimary,
              appBar: AppBar(
                backgroundColor: namedThemeFromContext.backgroundPrimary,
                title: Text(
                    "Flutter App",
                    style: textThemeFromContextAndColor.headlineMedium),
              ),
              body: Center(
                child: CircularProgressIndicator(
                    color: namedThemeFromContext.text),
              ),
            ),
            tvWidget: Scaffold(
              backgroundColor: namedThemeFromContext.backgroundPrimary,
              appBar: AppBar(
                backgroundColor: namedThemeFromContext.backgroundPrimary,
                title: Text(
                    "Flutter App",
                    style: textThemeFromContextAndColor.headlineMedium),
              ),
              body: Center(
                child: CircularProgressIndicator(
                    color: namedThemeFromContext.text),
              ),
            )
        );
      case EnumDataForExampleVM.exception:
        return PlatformUtility.getNamedWidgetFromSeven(
            context,
            mobileWidget: Scaffold(
              backgroundColor: namedThemeFromContext.backgroundPrimary,
              appBar: AppBar(
                backgroundColor: namedThemeFromContext.backgroundPrimary,
                title: Text(
                    "Flutter App",
                    style: textThemeFromContextAndColor.headlineMedium
                ),
              ),
              body: Center(
                child: Text(
                    "Exception: ${dataWNamed.exceptionController.getKeyParameterException}",
                    style: textThemeFromContextAndColor.bodyMedium),
              ),
            ),
            tabletWidget: Scaffold(
              backgroundColor: namedThemeFromContext.backgroundPrimary,
              appBar: AppBar(
                backgroundColor: namedThemeFromContext.backgroundPrimary,
                title: Text(
                    "Flutter App",
                    style: textThemeFromContextAndColor.headlineMedium),
              ),
              body: Center(
                child: Text(
                    "Exception: ${dataWNamed.exceptionController.getKeyParameterException}",
                    style: textThemeFromContextAndColor.bodyMedium),
              ),
            ),
            largeTabletWidget: Scaffold(
              backgroundColor: namedThemeFromContext.backgroundPrimary,
              appBar: AppBar(
                backgroundColor: namedThemeFromContext.backgroundPrimary,
                title: Text(
                    "Flutter App",
                    style: textThemeFromContextAndColor.headlineMedium),
              ),
              body: Center(
                child: Text(
                    "Exception: ${dataWNamed.exceptionController.getKeyParameterException}",
                    style: textThemeFromContextAndColor.bodyMedium),
              ),
            ),
            desktopWidget: Scaffold(
              backgroundColor: namedThemeFromContext.backgroundPrimary,
              appBar: AppBar(
                backgroundColor: namedThemeFromContext.backgroundPrimary,
                title: Text(
                    "Flutter App",
                    style: textThemeFromContextAndColor.headlineMedium),
              ),
              body: Center(
                child: Text(
                    "Exception: ${dataWNamed.exceptionController.getKeyParameterException}",
                    style: textThemeFromContextAndColor.bodyMedium),
              ),
            ),
            largeDesktopWidget: Scaffold(
              backgroundColor: namedThemeFromContext.backgroundPrimary,
              appBar: AppBar(
                backgroundColor: namedThemeFromContext.backgroundPrimary,
                title: Text(
                    "Flutter App",
                    style: textThemeFromContextAndColor.headlineMedium),
              ),
              body: Center(
                child: Text(
                    "Exception: ${dataWNamed.exceptionController.getKeyParameterException}",
                    style: textThemeFromContextAndColor.bodyMedium),
              ),
            ),
            tvWidget: Scaffold(
              backgroundColor: namedThemeFromContext.backgroundPrimary,
              appBar: AppBar(
                backgroundColor: namedThemeFromContext.backgroundPrimary,
                title: Text(
                    "Flutter App",
                    style: textThemeFromContextAndColor.headlineMedium),
              ),
              body: Center(
                child: Text(
                    "Exception: ${dataWNamed.exceptionController.getKeyParameterException}",
                    style: textThemeFromContextAndColor.bodyMedium),
              ),
            )
        );
      case EnumDataForExampleVM.success:
        return PlatformUtility.getNamedWidgetFromSeven(
            context,
            mobileWidget: Scaffold(
              backgroundColor: namedThemeFromContext.backgroundPrimary,
              appBar: AppBar(
                backgroundColor: namedThemeFromContext.backgroundPrimary,
                title: Text(
                    "Flutter App",
                    style: textThemeFromContextAndColor.headlineMedium
                ),
              ),
              body: Center(
                child: Text(
                    "MobileWidget",
                    style: textThemeFromContextAndColor.bodyMedium),
              ),
            ),
            tabletWidget: Scaffold(
              backgroundColor: namedThemeFromContext.backgroundPrimary,
              appBar: AppBar(
                backgroundColor: namedThemeFromContext.backgroundPrimary,
                title: Text(
                    "Flutter App",
                    style: textThemeFromContextAndColor.headlineMedium),
              ),
              body: Center(
                child: Text(
                    "TabletWidget",
                    style: textThemeFromContextAndColor.bodyMedium),
              ),
            ),
            largeTabletWidget: Scaffold(
              backgroundColor: namedThemeFromContext.backgroundPrimary,
              appBar: AppBar(
                backgroundColor: namedThemeFromContext.backgroundPrimary,
                title: Text(
                    "Flutter App",
                    style: textThemeFromContextAndColor.headlineMedium),
              ),
              body: Center(
                child: Text(
                    "LargeTabletWidget",
                    style: textThemeFromContextAndColor.bodyMedium),
              ),
            ),
            desktopWidget: Scaffold(
              backgroundColor: namedThemeFromContext.backgroundPrimary,
              appBar: AppBar(
                backgroundColor: namedThemeFromContext.backgroundPrimary,
                title: Text(
                    "Flutter App",
                    style: textThemeFromContextAndColor.headlineMedium),
              ),
              body: Center(
                child: Text(
                    "DesktopWidget",
                    style: textThemeFromContextAndColor.bodyMedium),
              ),
            ),
            largeDesktopWidget: Scaffold(
              backgroundColor: namedThemeFromContext.backgroundPrimary,
              appBar: AppBar(
                backgroundColor: namedThemeFromContext.backgroundPrimary,
                title: Text(
                    "Flutter App",
                    style: textThemeFromContextAndColor.headlineMedium),
              ),
              body: Center(
                child: Text(
                    "LargeDesktopWidget",
                    style: textThemeFromContextAndColor.bodyMedium),
              ),
            ),
            tvWidget: Scaffold(
              backgroundColor: namedThemeFromContext.backgroundPrimary,
              appBar: AppBar(
                backgroundColor: namedThemeFromContext.backgroundPrimary,
                title: Text(
                    "Flutter App",
                    style: textThemeFromContextAndColor.headlineMedium),
              ),
              body: Center(
                child: Text(
                    "TVWidget",
                    style: textThemeFromContextAndColor.bodyMedium),
              ),
            )
        );
    }
  }

  @override
  void initState() {
    _namedStreamWState = lamm.DefaultStreamWState(DataForExampleVM(true));
    super.initState();
    _init();
  }

  @override
  void dispose() {
    _tempCacheProvider.dispose([]);
    _namedStreamWState.dispose();
    super.dispose();
  }

  Future<void> _init() async {
    _namedStreamWState.listenStreamDataForNamedFromCallback((event) {
      setState(() {});
    });
    final firstRequest = await _firstRequest();
    lamm.debugPrint("ExampleVM: $firstRequest");
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
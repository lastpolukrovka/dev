import 'package:dart_common_dev/named_utility/ready_data_utility.dart';
import 'package:flutter/material.dart';
import 'package:library_architecture_mvvm_modify/library_architecture_mvvm_modify.dart' as lamm;

enum EnumDataForExampleVMTestMain {
  isLoading,
  exception,
  success
}

final class DataForExampleVMTestMain extends lamm.BaseDataForNamed<EnumDataForExampleVMTestMain> {
  DataForExampleVMTestMain(super.isLoading);

  @override
  EnumDataForExampleVMTestMain get getEnumDataForNamed {
    if(isLoading) {
      return EnumDataForExampleVMTestMain.isLoading;
    }
    if(exceptionController.isWhereNotEqualsNullParameterException()) {
      return EnumDataForExampleVMTestMain.exception;
    }
    return EnumDataForExampleVMTestMain.success;
  }

  @override
  String toString() {
    return "DataForExampleVMTestMain(isLoading: $isLoading, "
        "exceptionController: $exceptionController)";
  }
}

final class ExampleVMTestMain extends StatefulWidget {
  const ExampleVMTestMain({super.key});

  @override
  State<ExampleVMTestMain> createState() => _ExampleVMTestMainState();
}

final class _ExampleVMTestMainState extends State<ExampleVMTestMain> {
  // ModelWrapperRepository
  // NamedUtility

  // TempCacheProvider
  final _tempCacheProvider = lamm.TempCacheProvider();

  // NamedStreamWState
  late final lamm.BaseNamedStreamWState<DataForExampleVMTestMain> _namedStreamWState;

  @override
  Widget build(BuildContext context) {
    final dataWNamed = _namedStreamWState.getDataForNamed;
    switch(dataWNamed.getEnumDataForNamed) {
      case EnumDataForExampleVMTestMain.isLoading:
        return Container(color: Colors.white);
      case EnumDataForExampleVMTestMain.exception:
        return Container(
          color: Colors.red,
          child: Center(
              child: Text("Exception: ${dataWNamed.exceptionController.getKeyParameterException}")
          ),
        );
      case EnumDataForExampleVMTestMain.success:
        return MaterialApp(
          home: Scaffold(
            body: Center(
                child: Text("Hello World")
            ),
          ),
        );
    }
  }

  @override
  void initState() {
    _namedStreamWState = lamm.DefaultStreamWState(DataForExampleVMTestMain(true));
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
    lamm.debugPrint("ExampleVMTestMain: $firstRequest");
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

void main() {
  WidgetsFlutterBinding.ensureInitialized();
  runApp(ExampleVMTestMain());
}
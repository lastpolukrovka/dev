import 'package:library_architecture_mvvm_modify/library_architecture_mvvm_modify.dart';
import 'package:meta/meta.dart';

@immutable
base class Example extends BaseModel {
  const Example({required String uniqueId}) : super(uniqueId);

  @override
  Example clone() => Example(uniqueId: uniqueId);

  @override
  String toString() {
    return "Example(uniqueId: $uniqueId)";
  }
}
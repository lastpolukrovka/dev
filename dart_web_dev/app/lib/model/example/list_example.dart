import 'package:dart_web_dev/model/example/example.dart';
import 'package:library_architecture_mvvm_modify/library_architecture_mvvm_modify.dart';
import 'package:meta/meta.dart';

@immutable
base class ListExample<T extends Example> extends BaseListModel<T> {
  const ListExample({required List<T> listModel}) : super(listModel);

  @override
  ListExample<T> clone() {
    List<T> newListModel = List.empty(growable: true);
    for (final T itemModel in listModel) {
      newListModel.add(itemModel.clone() as T);
    }
    return ListExample<T>(listModel: newListModel);
  }

  @override
  String toString() {
    String strListModel = "\n";
    for (final T itemModel in listModel) {
      strListModel += "$itemModel,\n";
    }
    return "ListExample(listModel: [$strListModel])";
  }
}
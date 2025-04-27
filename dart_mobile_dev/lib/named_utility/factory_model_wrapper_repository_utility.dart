import 'package:meta/meta.dart';
import 'package:dart_mobile_dev/model_wrapper_repository/example_wrapper_repository/example_wrapper_repository.dart';

@immutable
final class FactoryModelWrapperRepositoryUtility {
  const FactoryModelWrapperRepositoryUtility._();

  static ExampleWrapperRepository get getExampleWrapperRepository {
    return const ExampleWrapperRepository();
  }
}
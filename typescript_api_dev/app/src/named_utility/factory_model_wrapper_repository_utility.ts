import ExampleWrapperRepository from "../model_wrapper_repository/example_wrapper_repository/example_wrapper_repository";

class FactoryModelWrapperRepositoryUtility {
    private constructor() {
    }

    public static get getExampleWrapperRepository(): ExampleWrapperRepository {
        return new ExampleWrapperRepository();
    }
}

export default FactoryModelWrapperRepositoryUtility;
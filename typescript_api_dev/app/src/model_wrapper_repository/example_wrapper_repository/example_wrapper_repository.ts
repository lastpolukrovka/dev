import { BaseModelWrapperRepository, EnumGuilty, LocalException, Result, ResultWithModelWrapper, ResultWithListModelsWrapper } from "@antonpichka/vitruvius";
import ExampleWrapper from "../../model/example/example_wrapper/example_wrapper";
import ListExampleWrapper from "../../model/example/example_wrapper/list_example_wrapper";

class ExampleWrapperRepository extends BaseModelWrapperRepository {
    public constructor() {
        super();
    }

    public override dispose(): void {
    }
    
    public async getExampleParameterUnknown(): Promise<ResultWithModelWrapper> {
        throw Error();
    }
}

export default ExampleWrapperRepository;
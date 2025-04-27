import { ExceptionController, BaseNamedVitruvius } from "@antonpichka/vitruvius";
import DataForExampleVitruvius from "./data_for_example_vitruvius";
import FirstRequestMethodExampleVitruvius from "./first_request_method_example_vitruvius/first_request_method_example_vitruvius";

class ExampleVitruvius extends BaseNamedVitruvius<DataForExampleVitruvius> {
    // ModelWrapperRepository
    // NamedUtility

    public constructor() {
        super(new DataForExampleVitruvius());
    }

    public override dispose(): void {
    }

    public async firstRequest(): Promise<FirstRequestMethodExampleVitruvius> {
        return new FirstRequestMethodExampleVitruvius(ExceptionController.success());
    }
}

export default ExampleVitruvius;
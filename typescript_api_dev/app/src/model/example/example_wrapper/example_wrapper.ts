import { BaseModelWrapper } from "@antonpichka/vitruvius";
import Example from "../example";

class ExampleWrapper extends BaseModelWrapper {
    public constructor(listObject: Array<any>) {
        super(listObject);
    }

    public override createModel(): Example {
        return new Example(this.listObject[0]);
    }
}

export default ExampleWrapper;
import { BaseDataForNamedVitruvius } from "@antonpichka/vitruvius";

class DataForExampleVitruvius extends BaseDataForNamedVitruvius {
    public constructor() {
        super();
    }

    public override toString(): string {
        return "DataForExampleVitruvius(exceptionController: " + this.exceptionController + ")";
    }
}

export default DataForExampleVitruvius;
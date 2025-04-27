import { BaseModel } from "@antonpichka/vitruvius";

class Example extends BaseModel {
    public constructor(uniqueId: string) {
        super(uniqueId);
    }

    public override clone(): Example {
        return new Example(this.uniqueId);
    }

    public override toString(): string {
        return "Example(uniqueId: " + this.uniqueId + ")";
    }
}

export default Example;
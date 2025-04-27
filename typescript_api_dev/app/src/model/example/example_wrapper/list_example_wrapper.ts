import { BaseListModelWrapper } from "@antonpichka/vitruvius";
import Example from "../example";
import ListExample from "../list_example";
import ExampleWrapper from "./example_wrapper";

class ListExampleWrapper extends BaseListModelWrapper {
    public constructor(listsListObject: Array<Array<any>>) {
        super(listsListObject);
    }
    
    public override createListModel(): ListExample<Example> {
        const listModel = new Array<Example>();
        for(const itemListObject of this.listsListObject) {
            const exampleWrapper = new ExampleWrapper(itemListObject);
            listModel.push(exampleWrapper.createModel());
        }
        return new ListExample(listModel);
    }
}

export default ListExampleWrapper;
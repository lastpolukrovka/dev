import { BaseListModel } from "@antonpichka/vitruvius";
import Example from "./example";

class ListExample<T extends Example> extends BaseListModel<T> {
    public constructor(listModel: Array<T>) {
        super(listModel);
    }

    public override clone(): ListExample<T> {
        const newListModel = new Array<T>();
        for(const itemModel of this.listModel) {
            newListModel.push(itemModel.clone() as T);
        }
        return new ListExample(newListModel);
    }

    public override toString(): string {
        let strListModel = "\n";
        for(const itemModel of this.listModel) {
            strListModel += itemModel + ",\n";
        }
        return "ListExample(listModel: [" + strListModel + "])";
    }
}

export default ListExample;
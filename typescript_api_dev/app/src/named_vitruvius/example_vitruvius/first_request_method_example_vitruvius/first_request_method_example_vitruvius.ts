import { BaseNamedMethodNamedVitruvius, ExceptionController } from "@antonpichka/vitruvius";
import EnumFirstRequestMethodExampleVitruvius from "./enum_first_request_method_example_vitruvius"; 

class FirstRequestMethodExampleVitruvius extends BaseNamedMethodNamedVitruvius<EnumFirstRequestMethodExampleVitruvius> {
    public constructor(exceptionController: ExceptionController) {
        super(exceptionController);
    }

    public override get getEnumNamedMethodNamedVitruvius(): EnumFirstRequestMethodExampleVitruvius {
        if(this.exceptionController.isWhereNotEqualsNullParameterException()) {
            return EnumFirstRequestMethodExampleVitruvius.exception;
        }
        return EnumFirstRequestMethodExampleVitruvius.success;
    }

    public override toString(): string {
        return "FirstRequestMethodExampleVitruvius(exceptionController: " + this.exceptionController + ")";
    }

    public get getJSONWhereSuccess(): {} {
        return {
            timestamp : new Date().toLocaleString(),
            message : "Success"
        };
    }

    public get getJSONWhereGatewayTimeoutParameterExceptionController(): {} {
        return {
            timestamp : new Date().toLocaleString(),
            message : "Exception: " + this.exceptionController.getKeyParameterException
        };
    }
}

export default FirstRequestMethodExampleVitruvius;
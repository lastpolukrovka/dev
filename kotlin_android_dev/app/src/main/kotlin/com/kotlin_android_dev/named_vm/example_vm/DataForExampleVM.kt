package com.kotlin_android_dev.named_vm.example_vm

import io.github.antonpichka.lamm.base_data_for_named.BaseDataForNamed

class DataForExampleVM(isLoading: Boolean) : BaseDataForNamed<EnumDataForExampleVM>(isLoading)
{
    override fun getEnumDataForNamed(): EnumDataForExampleVM {
        if(isLoading) {
            return EnumDataForExampleVM.IS_LOADING
        }
        if(exceptionController.isWhereNotEqualsNullParameterException()) {
            return EnumDataForExampleVM.EXCEPTION
        }
        return EnumDataForExampleVM.SUCCESS
    }

    override fun toString(): String {
        return "DataForExampleVM(isLoading: $isLoading, " +
                "exceptionController: $exceptionController)"
    }
}
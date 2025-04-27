package com.kotlin_android_dev.named_vm.second_vm

import io.github.antonpichka.lamm.base_data_for_named.BaseDataForNamed

class DataForSecondVM(isLoading: Boolean) : BaseDataForNamed<EnumDataForSecondVM>(isLoading)
{
    override fun getEnumDataForNamed(): EnumDataForSecondVM {
        if(isLoading) {
            return EnumDataForSecondVM.IS_LOADING
        }
        if(exceptionController.isWhereNotEqualsNullParameterException()) {
            return EnumDataForSecondVM.EXCEPTION
        }
        return EnumDataForSecondVM.SUCCESS
    }

    override fun toString(): String {
        return "DataForSecondVM(isLoading: $isLoading, " +
                "exceptionController: $exceptionController)"
    }
}
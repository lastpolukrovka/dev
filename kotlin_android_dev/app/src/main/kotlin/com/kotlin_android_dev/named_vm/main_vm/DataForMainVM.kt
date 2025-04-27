package com.kotlin_android_dev.named_vm.main_vm

import io.github.antonpichka.lamm.base_data_for_named.BaseDataForNamed

class DataForMainVM(isLoading: Boolean) : BaseDataForNamed<EnumDataForMainVM>(isLoading)
{
    override fun getEnumDataForNamed(): EnumDataForMainVM {
        if(isLoading) {
            return EnumDataForMainVM.IS_LOADING
        }
        if(exceptionController.isWhereNotEqualsNullParameterException()) {
            return EnumDataForMainVM.EXCEPTION
        }
        return EnumDataForMainVM.SUCCESS
    }

    override fun toString(): String {
        return "DataForMainVM(isLoading: $isLoading, " +
                "exceptionController: $exceptionController)"
    }
}
package com.kotlin_android_dev.named_vm.app_vm

import io.github.antonpichka.lamm.base_data_for_named.BaseDataForNamed

class DataForAppVM(isLoading: Boolean): BaseDataForNamed<EnumDataForAppVM>(isLoading) {
    override fun getEnumDataForNamed(): EnumDataForAppVM {
        if(isLoading) {
            return EnumDataForAppVM.IS_LOADING
        }
        if(exceptionController.isWhereNotEqualsNullParameterException()) {
            return EnumDataForAppVM.EXCEPTION
        }
        return EnumDataForAppVM.SUCCESS
    }

    override fun toString(): String {
        return "DataForAppVM(isLoading: $isLoading, " +
                "exceptionController: $exceptionController)"
    }
}
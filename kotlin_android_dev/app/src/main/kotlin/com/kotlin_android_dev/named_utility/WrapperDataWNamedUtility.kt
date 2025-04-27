package com.kotlin_android_dev.named_utility

import io.github.antonpichka.lamm.base_data_for_named.BaseDataForNamed

class WrapperDataWNamedUtility<T : Enum<T>, Y : BaseDataForNamed<T>>(val dataWNamed: Y, val iteration: Int)
{
    override fun toString(): String {
        return "WrapperDataWNamedUtility(dataWNamed: $dataWNamed, iteration: $iteration)"
    }
}
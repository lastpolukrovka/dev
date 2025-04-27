package com.kotlin_android_dev.model.example.example_wrapper

import io.github.antonpichka.lamm.base_model.BaseModelWrapper
import io.github.antonpichka.lamm.base_model.BaseModel
import com.kotlin_android_dev.model.example.Example

open class ExampleWrapper(listObject: List<Any>) : BaseModelWrapper(listObject) {
    @Suppress("UNCHECKED_CAST")
    override fun<T : BaseModel> createModel(): T {
        return Example(listObject[0] as String) as T
    }
}
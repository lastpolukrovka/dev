package com.kotlin_android_dev.model.example.example_wrapper

import io.github.antonpichka.lamm.base_model.BaseListModelWrapper
import io.github.antonpichka.lamm.base_model.BaseModel
import io.github.antonpichka.lamm.base_model.BaseListModel
import com.kotlin_android_dev.model.example.Example
import com.kotlin_android_dev.model.example.ListExample

open class ListExampleWrapper(listsListObject: List<List<Any>>) : BaseListModelWrapper(listsListObject) {
    @Suppress("UNCHECKED_CAST")
    override fun<T : BaseModel, Y : BaseListModel<T>> createListModel(): Y {
        val listModel = mutableListOf<Example>()
        for(itemListObject: List<Any> in listsListObject) {
            val exampleWrapper = ExampleWrapper(itemListObject)
            listModel.add(exampleWrapper.createModel())
        }
        return ListExample(listModel) as Y
    }
}
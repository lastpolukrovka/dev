package com.kotlin_android_dev.model.example

import io.github.antonpichka.lamm.base_model.BaseModel

open class Example(uniqueId: String) : BaseModel(uniqueId) {
    override fun clone(): Example {
        return Example(uniqueId)
    }

    override fun toString(): String {
        return "Example(uniqueId: $uniqueId)"
    }
}
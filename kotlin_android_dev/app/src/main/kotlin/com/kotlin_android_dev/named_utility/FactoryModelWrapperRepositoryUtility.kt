package com.kotlin_android_dev.named_utility

import com.kotlin_android_dev.model_wrapper_repository.example_wrapper_repository.ExampleWrapperRepository

class FactoryModelWrapperRepositoryUtility private constructor() {
    companion object {
        fun getExampleWrapperRepository(): ExampleWrapperRepository {
            return ExampleWrapperRepository()
        }
    }
}
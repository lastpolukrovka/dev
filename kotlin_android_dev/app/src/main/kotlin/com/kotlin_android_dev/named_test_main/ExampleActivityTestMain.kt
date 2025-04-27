package com.kotlin_android_dev.named_test_main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kotlin_android_dev.named_utility.ReadyDataUtility
import com.kotlin_android_dev.named_utility.WrapperDataWNamedUtility
import com.kotlin_android_dev.named_view_model.BaseNamedViewModel
import io.github.antonpichka.lamm.TempCacheProvider
import io.github.antonpichka.lamm.base_data_for_named.BaseDataForNamed
import io.github.antonpichka.lamm.base_named_stream_w_state.BaseNamedStreamWState
import io.github.antonpichka.lamm.base_named_stream_w_state.DefaultStreamWState
import io.github.antonpichka.lamm.debugPrint
import kotlinx.coroutines.delay

enum class EnumDataForExampleVMTestMain {
    IS_LOADING,
    EXCEPTION,
    SUCCESS
}

class DataForExampleVMTestMain(isLoading: Boolean) : BaseDataForNamed<EnumDataForExampleVMTestMain>(isLoading)
{
    override fun getEnumDataForNamed(): EnumDataForExampleVMTestMain {
        if(isLoading) {
            return EnumDataForExampleVMTestMain.IS_LOADING
        }
        if(exceptionController.isWhereNotEqualsNullParameterException()) {
            return EnumDataForExampleVMTestMain.EXCEPTION
        }
        return EnumDataForExampleVMTestMain.SUCCESS
    }

    override fun toString(): String {
        return "DataForExampleVMTestMain(isLoading: $isLoading, " +
                "exceptionController: $exceptionController)"
    }
}

class ExampleViewModelTestMain(
    tempCacheProvider: TempCacheProvider,
    namedStreamWState: BaseNamedStreamWState<EnumDataForExampleVMTestMain, DataForExampleVMTestMain>) : BaseNamedViewModel<EnumDataForExampleVMTestMain,DataForExampleVMTestMain>(tempCacheProvider,namedStreamWState)
{
    override fun onCleared() {
        super.onCleared()
        tempCacheProvider.dispose(listOf())
    }
}

class ExampleViewModelFactoryTestMain() : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ExampleViewModelTestMain(TempCacheProvider(), DefaultStreamWState(DataForExampleVMTestMain(true))) as T
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExampleVMTestMain(
    viewModel: ExampleViewModelTestMain = viewModel(factory = ExampleViewModelFactoryTestMain()))
{
    var state by remember { mutableStateOf(WrapperDataWNamedUtility(viewModel.getDataForNamed(), 0)) }
    LaunchedEffect(Unit) {
        viewModel.listenStreamDataForNamedFromCallback { event ->
            state = WrapperDataWNamedUtility(event, state.iteration + 1)
        }
        val firstRequest = firstRequest(viewModel)
        debugPrint("ExampleVMTestMain: $firstRequest")
        viewModel.notifyStreamDataForNamed()
    }
    DisposableEffect(Unit) {
        onDispose {
        }
    }
    val dataWNamed = state.dataWNamed
    when (dataWNamed.getEnumDataForNamed()) {
        EnumDataForExampleVMTestMain.IS_LOADING -> {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.White
            ) {
            }
        }
        EnumDataForExampleVMTestMain.EXCEPTION -> {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.White
            ) {
                Text(
                    text = "Exception: ${dataWNamed.exceptionController.getKeyParameterException()}"
                )
            }
        }
        EnumDataForExampleVMTestMain.SUCCESS -> {
            MaterialTheme {
                Scaffold { paddingValues ->
                    Column(
                        modifier = Modifier.padding(paddingValues)
                    ) {
                        Text(
                            text = "Success",
                        )
                    }
                }
            }
        }
    }
}

private suspend fun firstRequest(exampleViewModelTestMain: ExampleViewModelTestMain): String {
    if(exampleViewModelTestMain.isInitFirstRequest) {
        return ReadyDataUtility.DUPLICATE
    }
    delay(1000)
    exampleViewModelTestMain
        .getDataForNamed()
        .isLoading = false
    exampleViewModelTestMain
        .isInitFirstRequest = true
    return ReadyDataUtility.SUCCESS
}

class ExampleActivityTestMain : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExampleVMTestMain()
        }
    }
}
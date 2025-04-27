package com.kotlin_android_dev.named_vm.app_vm

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kotlin_android_dev.named_utility.KeysRoutersUtility
import com.kotlin_android_dev.named_utility.ReadyDataUtility
import com.kotlin_android_dev.named_utility.WrapperDataWNamedUtility
import com.kotlin_android_dev.named_view_model.BaseNamedViewModel
import com.kotlin_android_dev.named_vm.main_vm.MainVM
import com.kotlin_android_dev.named_vm.second_vm.SecondVM
import io.github.antonpichka.lamm.TempCacheProvider
import io.github.antonpichka.lamm.base_named_stream_w_state.BaseNamedStreamWState
import io.github.antonpichka.lamm.base_named_stream_w_state.DefaultStreamWState
import io.github.antonpichka.lamm.debugPrint
import kotlinx.coroutines.delay

class AppViewModel(
    tempCacheProvider: TempCacheProvider,
    namedStreamWState: BaseNamedStreamWState<EnumDataForAppVM, DataForAppVM>) : BaseNamedViewModel<EnumDataForAppVM,DataForAppVM>(tempCacheProvider,namedStreamWState)
{
    override fun onCleared() {
        super.onCleared()
        tempCacheProvider.dispose(listOf())
    }
}

class AppViewModelFactory() : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AppViewModel(TempCacheProvider(), DefaultStreamWState(DataForAppVM(true))) as T
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppVM(
    navHostController: NavHostController = rememberNavController(),
    viewModel: AppViewModel = viewModel(factory = AppViewModelFactory()))
{
    var state by remember { mutableStateOf(WrapperDataWNamedUtility(viewModel.getDataForNamed(),0)) }
    LaunchedEffect(Unit) {
        viewModel.listenStreamDataForNamedFromCallback { event ->
            state = WrapperDataWNamedUtility(event,state.iteration+1)
        }
        val firstRequest = firstRequest(viewModel)
        debugPrint("AppVM: $firstRequest")
        viewModel.notifyStreamDataForNamed()
    }
    DisposableEffect(Unit) {
        onDispose {
        }
    }
    val dataWNamed = state.dataWNamed
    when(dataWNamed.getEnumDataForNamed()) {
        EnumDataForAppVM.IS_LOADING -> {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.White
            ) {
            }
        }
        EnumDataForAppVM.EXCEPTION -> {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.White
            ) {
                Text(
                    text = "Exception: ${dataWNamed.exceptionController.getKeyParameterException()}"
                )
            }
        }
        EnumDataForAppVM.SUCCESS -> {
            MaterialTheme {
                NavHost(navHostController, startDestination = KeysRoutersUtility.MAIN_VM) {
                    composable(KeysRoutersUtility.MAIN_VM) {
                        MainVM(navHostController)
                    }
                    composable(KeysRoutersUtility.SECOND_VM) {
                        SecondVM(navHostController)
                    }
                }
            }
        }
    }
}

private suspend fun firstRequest(appViewModel: AppViewModel): String {
    if(appViewModel.isInitFirstRequest) {
        return ReadyDataUtility.DUPLICATE
    }
    delay(1000)
    appViewModel
        .getDataForNamed()
        .isLoading = false
    appViewModel
        .isInitFirstRequest = true
    return ReadyDataUtility.SUCCESS
}
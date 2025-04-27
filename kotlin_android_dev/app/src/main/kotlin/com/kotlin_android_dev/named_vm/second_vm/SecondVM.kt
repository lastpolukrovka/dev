package com.kotlin_android_dev.named_vm.second_vm

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.kotlin_android_dev.named_composable.AndroidThemeComposable
import com.kotlin_android_dev.named_composable.PlatformComposable
import com.kotlin_android_dev.named_composable.TypographyComposable
import com.kotlin_android_dev.named_utility.ReadyDataUtility
import com.kotlin_android_dev.named_utility.WrapperDataWNamedUtility
import com.kotlin_android_dev.named_view_model.BaseNamedViewModel
import io.github.antonpichka.lamm.TempCacheProvider
import io.github.antonpichka.lamm.base_named_stream_w_state.BaseNamedStreamWState
import io.github.antonpichka.lamm.base_named_stream_w_state.DefaultStreamWState
import io.github.antonpichka.lamm.debugPrint
import kotlinx.coroutines.delay

class SecondViewModel(
    tempCacheProvider: TempCacheProvider,
    namedStreamWState: BaseNamedStreamWState<EnumDataForSecondVM, DataForSecondVM>) : BaseNamedViewModel<EnumDataForSecondVM,DataForSecondVM>(tempCacheProvider,namedStreamWState)
{
    override fun onCleared() {
        super.onCleared()
        tempCacheProvider.dispose(listOf())
    }
}

class SecondViewModelFactory() : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SecondViewModel(TempCacheProvider(), DefaultStreamWState(DataForSecondVM(true))) as T
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondVM(
    navController: NavController,
    viewModel: SecondViewModel = viewModel(factory = SecondViewModelFactory()))
{
    var state by remember { mutableStateOf(WrapperDataWNamedUtility(viewModel.getDataForNamed(),0)) }
    LaunchedEffect(Unit) {
        viewModel.listenStreamDataForNamedFromCallback { event ->
            state = WrapperDataWNamedUtility(event,state.iteration+1)
        }
        val firstRequest = firstRequest(viewModel)
        debugPrint("SecondVM: $firstRequest")
        viewModel.notifyStreamDataForNamed()
    }
    DisposableEffect(Unit) {
        onDispose {
        }
    }
    val androidThemeComposable = AndroidThemeComposable()
    val typographyComposable = TypographyComposable(androidThemeComposable.text())
    val typographyComposableFirst = TypographyComposable(androidThemeComposable.onBrand())
    val dataWNamed = state.dataWNamed
    when (dataWNamed.getEnumDataForNamed()) {
        EnumDataForSecondVM.IS_LOADING -> {
            PlatformComposable(
                callbackWTablet = {
                    Scaffold(
                        containerColor = androidThemeComposable.backgroundPrimary(),
                        topBar = {
                            TopAppBar(
                                title = {
                                    Text(
                                        text = "SecondVM",
                                        style = typographyComposable.headlineMedium
                                    )
                                },
                                colors = topAppBarColors(
                                    containerColor = androidThemeComposable.backgroundPrimary()),
                            )
                        },
                    ) { paddingValues ->
                        Column(
                            modifier = Modifier.padding(paddingValues)
                        ) {
                            Text(
                                text = "Loading",
                                style = typographyComposable.bodyMedium
                            )
                        }
                    }
                },
                callbackWLargeTablet = {
                    Scaffold(
                        containerColor = androidThemeComposable.backgroundPrimary(),
                        topBar = {
                            TopAppBar(
                                title = {
                                    Text(
                                        text = "SecondVM",
                                        style = typographyComposable.headlineMedium
                                    )
                                },
                                colors = topAppBarColors(
                                    containerColor = androidThemeComposable.backgroundPrimary()),
                            )
                        },
                    ) { paddingValues ->
                        Column(
                            modifier = Modifier.padding(paddingValues)
                        ) {
                            Text(
                                text = "Loading",
                                style = typographyComposable.bodyMedium
                            )
                        }
                    }
                }
            ) {
                Scaffold(
                    containerColor = androidThemeComposable.backgroundPrimary(),
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(
                                    text = "SecondVM",
                                    style = typographyComposable.headlineMedium
                                )
                            },
                            colors = topAppBarColors(
                                containerColor = androidThemeComposable.backgroundPrimary()),
                        )
                    },
                ) { paddingValues ->
                    Column(
                        modifier = Modifier.padding(paddingValues)
                    ) {
                        Text(
                            text = "Loading",
                            style = typographyComposable.bodyMedium
                        )
                    }
                }
            }
        }
        EnumDataForSecondVM.EXCEPTION -> {
            PlatformComposable(
                callbackWTablet = {
                    Scaffold(
                        containerColor = androidThemeComposable.backgroundPrimary(),
                        topBar = {
                            TopAppBar(
                                title = {
                                    Text(
                                        text = "SecondVM",
                                        style = typographyComposable.headlineMedium
                                    )
                                },
                                colors = topAppBarColors(
                                    containerColor = androidThemeComposable.backgroundPrimary()),
                            )
                        },
                    ) { paddingValues ->
                        Column(
                            modifier = Modifier.padding(paddingValues)
                        ) {
                            Text(
                                text = "Exception: ${dataWNamed.exceptionController.getKeyParameterException()}",
                                style = typographyComposable.bodyMedium
                            )
                        }
                    }
                },
                callbackWLargeTablet = {
                    Scaffold(
                        containerColor = androidThemeComposable.backgroundPrimary(),
                        topBar = {
                            TopAppBar(
                                title = {
                                    Text(
                                        text = "SecondVM",
                                        style = typographyComposable.headlineMedium
                                    )
                                },
                                colors = topAppBarColors(
                                    containerColor = androidThemeComposable.backgroundPrimary()),
                            )
                        },
                    ) { paddingValues ->
                        Column(
                            modifier = Modifier.padding(paddingValues)
                        ) {
                            Text(
                                text = "Exception: ${dataWNamed.exceptionController.getKeyParameterException()}",
                                style = typographyComposable.bodyMedium
                            )
                        }
                    }
                }
            ) {
                Scaffold(
                    containerColor = androidThemeComposable.backgroundPrimary(),
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(
                                    text = "SecondVM",
                                    style = typographyComposable.headlineMedium
                                )
                            },
                            colors = topAppBarColors(
                                containerColor = androidThemeComposable.backgroundPrimary()),
                        )
                    },
                ) { paddingValues ->
                    Column(
                        modifier = Modifier.padding(paddingValues)
                    ) {
                        Text(
                            text = "Exception: ${dataWNamed.exceptionController.getKeyParameterException()}",
                            style = typographyComposable.bodyMedium
                        )
                    }
                }
            }
        }
        EnumDataForSecondVM.SUCCESS -> {
            PlatformComposable(
                callbackWTablet = {
                    Scaffold(
                        containerColor = androidThemeComposable.backgroundPrimary(),
                        topBar = {
                            TopAppBar(
                                title = {
                                    Text(
                                        text = "SecondVM",
                                        style = typographyComposable.headlineMedium
                                    )
                                },
                                colors = topAppBarColors(
                                    containerColor = androidThemeComposable.backgroundPrimary()),
                            )
                        },
                    ) { paddingValues ->
                        Column(
                            modifier = Modifier.padding(paddingValues)
                        ) {
                            Button(
                                colors = buttonColors(
                                    containerColor = androidThemeComposable.brand()
                                ),
                                onClick = {
                                    navController.popBackStack()
                                }
                            ) {
                                Text(
                                    text = "Go Back",
                                    style = typographyComposableFirst.bodyMedium)
                            }
                        }
                    }
                },
                callbackWLargeTablet = {
                    Scaffold(
                        containerColor = androidThemeComposable.backgroundPrimary(),
                        topBar = {
                            TopAppBar(
                                title = {
                                    Text(
                                        text = "SecondVM",
                                        style = typographyComposable.headlineMedium
                                    )
                                },
                                colors = topAppBarColors(
                                    containerColor = androidThemeComposable.backgroundPrimary()),
                            )
                        },
                    ) { paddingValues ->
                        Column(
                            modifier = Modifier.padding(paddingValues)
                        ) {
                            Button(
                                colors = buttonColors(
                                    containerColor = androidThemeComposable.brand()
                                ),
                                onClick = {
                                    navController.popBackStack()
                                }
                            ) {
                                Text(
                                    text = "Go Back",
                                    style = typographyComposableFirst.bodyMedium)
                            }
                        }
                    }
                }
            ) {
                Scaffold(
                    containerColor = androidThemeComposable.backgroundPrimary(),
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(
                                    text = "SecondVM",
                                    style = typographyComposable.headlineMedium
                                )
                            },
                            colors = topAppBarColors(
                                containerColor = androidThemeComposable.backgroundPrimary()),
                        )
                    },
                ) { paddingValues ->
                    Column(
                        modifier = Modifier.padding(paddingValues)
                    ) {
                        Button(
                            colors = buttonColors(
                                containerColor = androidThemeComposable.brand()
                            ),
                            onClick = {
                                navController.popBackStack()
                            }
                        ) {
                            Text(
                                text = "Go Back",
                                style = typographyComposableFirst.bodyMedium)
                        }
                    }
                }
            }
        }
    }
}

private suspend fun firstRequest(secondViewModel: SecondViewModel): String {
    if(secondViewModel.isInitFirstRequest) {
        return ReadyDataUtility.DUPLICATE
    }
    delay(1000)
    secondViewModel
        .getDataForNamed()
        .isLoading = false
    secondViewModel
        .isInitFirstRequest = true
    return ReadyDataUtility.SUCCESS
}
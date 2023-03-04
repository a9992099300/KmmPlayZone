package admin.gamescreate

import admin.gamecreate.CreateGameViewModel
import admin.gamecreate.models.CreateGameAction
import admin.gamecreate.models.CreateGameEvent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adeo.kviewmodel.compose.ViewModel
import com.adeo.kviewmodel.compose.observeAsState
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import theme.Theme
import widgets.ActionButton
import widgets.CommonTextField

@Composable
fun CreateGameScreen() {
    val rootController = LocalRootController.current

    ViewModel(factory = { CreateGameViewModel() }) { viewModel ->
        val viewState = viewModel.viewStates().observeAsState().value
        val viewAction = viewModel.viewActions().observeAsState().value

        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = viewState.title.ifBlank { "Add Game" },
                color = Theme.colors.secondaryTextColor,
                fontSize = 28.sp,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.padding(top = 16.dp))

            CommonTextField(
                text = viewState.title,
                hint = "Game Title"
            ) {
                viewModel.obtainEvent(CreateGameEvent.TitleChanged(it))
            }

            Spacer(modifier = Modifier.padding(top = 16.dp))

            CommonTextField(
                text = viewState.description,
                hint = "Game Description",
                enabled = viewState.isSending
            ) {
                viewModel.obtainEvent(CreateGameEvent.DescriptionChanged(it))
            }

            Spacer(modifier = Modifier.padding(top = 16.dp))

            CommonTextField(
                text = viewState.version,
                hint = "Game Version",
                enabled = viewState.isSending
            ) {
                viewModel.obtainEvent(CreateGameEvent.VersionChanged(it))
            }

            Spacer(modifier = Modifier.padding(top = 16.dp))

            CommonTextField(
                text = viewState.size,
                hint = "Game Size (mb)",
                enabled = viewState.isSending
            ) {
                viewModel.obtainEvent(CreateGameEvent.SizeChanged(it))
            }

            Spacer(modifier = Modifier.padding(top = 16.dp))

            ActionButton(
                title = "Create Game",
                isSending = viewState.isSending
            ) {
                viewModel.obtainEvent(CreateGameEvent.SubmitCreation)
            }
        }

        when (viewAction) {
            is CreateGameAction.CloseScreen -> {
                rootController.popBackStack()
            }

            null -> {}
        }
    }
}
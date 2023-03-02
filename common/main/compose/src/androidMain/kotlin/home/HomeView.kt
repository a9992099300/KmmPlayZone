package home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import home.models.HomeEvent
import home.models.HomeViewState
import theme.Theme

@Composable
fun HomeView(viewState: HomeViewState, eventHandler: (HomeEvent) -> Unit) {
        Row(modifier = Modifier.clickable {
            eventHandler.invoke(HomeEvent.UserprofileClicked)
        }.padding(start = 24.dp, top = 26.dp,
            end = 24.dp, bottom = 0.dp)) {
            AsyncImage(
                modifier = Modifier.clip(RoundedCornerShape(28.dp)).size(56.dp),
                model = viewState.avatarUrl,
                contentDescription = "Avatar",
                contentScale = ContentScale.FillBounds,
            )
            
            Column(modifier = Modifier.padding(start = 20.dp)) {
                Text(viewState.status, color = Theme.colors.secondaryTextColor.copy(alpha = 0.5F),
                fontSize = 12.sp)
                Text(
                    modifier = Modifier.padding(top= 4.dp),
                    text = viewState.username,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    color = Theme.colors.secondaryTextColor)
            }
        }

}
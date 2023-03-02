package home

import com.adeo.kviewmodel.BaseSharedViewModel
import home.models.HomeAction
import home.models.HomeEvent
import home.models.HomeViewState

class HomeViewModel: BaseSharedViewModel<HomeViewState, HomeAction, HomeEvent>(
    initialState = HomeViewState(
      username = "Erik All",
        avatarUrl = "https://sputnik.kg/img/101808/12/1018081237_0:0:5184:3456_1440x900_80_0_1_5842cff5fa23b60f9e77b575d56794ab.jpg.webp?source-sid=afp"
    )
) {
    override fun obtainEvent(viewEvent: HomeEvent) {
        when(viewEvent) {
            HomeEvent.UserprofileClicked -> showUserProfile()
        }
    }

    private fun showUserProfile() {
        viewAction = HomeAction.ShowUserProfile
    }
}
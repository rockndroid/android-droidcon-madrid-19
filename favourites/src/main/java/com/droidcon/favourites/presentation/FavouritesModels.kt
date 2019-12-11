package com.droidcon.favourites.presentation

import com.droidcon.schedule.ui.model.SessionRow

sealed class FavouritesState {
    object Empty : FavouritesState()
    data class Content(val sessionRows: List<SessionRow>) : FavouritesState()
}
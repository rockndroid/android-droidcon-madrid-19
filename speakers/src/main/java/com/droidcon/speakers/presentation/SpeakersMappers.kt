package com.droidcon.speakers.presentation

import com.droidcon.speakers.domain.Speaker

fun Iterable<Speaker>.toState(onClickAction: (String) -> Unit): SpeakersState =
    SpeakersState(map { it.toState(onClickAction) })

fun Speaker.toState(onClickAction: (String) -> Unit): SpeakerState =
    SpeakerState(
        id = id,
        title = name.fullName,
        subtitle = tagLine,
        avatar = profilePicture,
        onClickAction = onClickAction
    )

fun Speaker.toDetailState(): SpeakerDetailState = SpeakerDetailState(
    speakerAvatar = profilePicture.rawUrl,
    speakerName = name.fullName,
    speakerDescription = bio,
    speakerTalks = listOf()
)
package com.droidcon.speakers.presentation.speakersearch.model

import com.droidcon.speakers.domain.Speaker
import com.droidcon.speakers.presentation.speakerlist.model.toState

fun Iterable<Speaker>.toSpeakersSearchResult(
    onClickAction: (String) -> Unit
): SpeakersSearchResult {
    if (count() == 0) return SpeakersSearchResult.Empty

    return SpeakersSearchResult.Content(toState(onClickAction))
}
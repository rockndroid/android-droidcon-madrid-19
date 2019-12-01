package com.droidcon.speakers.presentation.recyclerview

import androidx.recyclerview.widget.DiffUtil
import com.droidcon.speakers.presentation.SpeakerTalk
import javax.inject.Inject

class SpeakerTalkDiffCallback @Inject constructor() : DiffUtil.ItemCallback<SpeakerTalk>() {

    override fun areItemsTheSame(oldItem: SpeakerTalk, newItem: SpeakerTalk): Boolean =
        oldItem.talkId == newItem.talkId

    override fun areContentsTheSame(oldItem: SpeakerTalk, newItem: SpeakerTalk): Boolean =
        oldItem == newItem
}
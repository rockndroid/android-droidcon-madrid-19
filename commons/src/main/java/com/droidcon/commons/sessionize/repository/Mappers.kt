package com.droidcon.commons.sessionize.repository

import com.droidcon.commons.sessionize.api.LinkDto
import com.droidcon.commons.sessionize.api.SpeakerDto
import com.droidcon.commons.sessionize.storage.LinkDO
import com.droidcon.commons.sessionize.storage.SpeakerDO

// DTO Mappers

fun LinkDto.toDataModel(): LinkData =
    LinkData(
        title = this.title,
        url = this.url.asUrl(),
        linkType = this.linkType
    )

fun SpeakerDto.toDataModel(): SpeakerData =
    SpeakerData(
        id = this.id,
        name = NameData(
            firstName = this.firstName,
            lastName = this.lastName,
            fullName = this.fullName
        ),
        bio = this.bio,
        tagLine = this.tagLine,
        profilePicture = this.profilePicture.asUrl(),
        links = this.links.map { it.toDataModel() }
    )

fun SpeakerDto.toDO(): SpeakerDO = SpeakerDO(
    id = id,
    firstName = firstName,
    lastName = lastName,
    fullName = fullName,
    tagLine = tagLine,
    profilePicture = profilePicture,
    bio = bio,
    links = links.map { it.toDO() }
)

fun LinkDto.toDO(): LinkDO = LinkDO(
    title = title,
    url = url,
    linkType = linkType
)

// DO Mappers

fun SpeakerDO.toDataModel(): SpeakerData = SpeakerData(
    id = id,
    name = getNameData(),
    bio = bio,
    tagLine = tagLine,
    profilePicture = profilePicture.asUrl(),
    links = links.map { it.toDataModel() }
)

fun SpeakerDO.getNameData(): NameData = NameData(
    firstName = firstName,
    lastName = lastName,
    fullName = fullName
)

fun LinkDO.toDataModel(): LinkData = LinkData(
    title = title,
    url = url.asUrl(),
    linkType = linkType
)
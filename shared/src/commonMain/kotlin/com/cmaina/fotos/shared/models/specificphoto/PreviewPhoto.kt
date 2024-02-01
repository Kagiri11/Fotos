package com.cmaina.domain.models.specificphoto

import com.cmaina.fotos.shared.models.photos.PhotoUrls

data class PreviewPhoto(
    val blurHash: String?,
    val id: String?,
    val urls: PhotoUrls?
)

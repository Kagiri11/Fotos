package com.cmaina.domain.models.photostats

data class DomainPhotoStatistics(
    val domainPhotoStatDownloads: DomainPhotoStatDownloads,
    val id: String,
    val domainPhotoStatLikes: DomainPhotoStatLikes,
    val domainPhotoStatsViews: DomainPhotoStatsViews
)
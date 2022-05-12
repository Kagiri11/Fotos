package com.cmaina.domain.models.photos

data class DomainPhotoListItem(
    val altDescription: String,
    val blurHash: String,
    val categories: List<Any>,
    val color: String,
    val created_at: String,
    val currentUserCollections: List<Any>,
    val description: String,
    val height: Int,
    val id: String,
    val likedByUser: Boolean,
    val likes: Int,
    val linksDomain: DomainPhotoLinks,
    val promotedAt: String,
    val sponsorship: Sponsorship,
    val domainTopicSubmissions: DomainTopicSubmissions,
    val updatedAt: String,
    val domainUrls: DomainUrls,
    val domainPhotoUser: DomainPhotoUser,
    val width: Int
)
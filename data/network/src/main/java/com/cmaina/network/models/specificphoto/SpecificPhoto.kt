package com.cmaina.network.models.specificphoto

import com.cmaina.network.models.PhotoLinks
import com.cmaina.network.models.Sponsorship
import com.cmaina.network.models.TopicSubmissions
import com.cmaina.network.models.Urls
import com.cmaina.network.models.User

data class SpecificPhoto(
    val alt_description: Any,
    val blur_hash: String,
    val categories: List<Any>,
    val color: String,
    val created_at: String,
    val current_user_collections: List<Any>,
    val description: Any,
    val downloads: Int,
    val exif: Exif,
    val height: Int,
    val id: String,
    val liked_by_user: Boolean,
    val likes: Int,
    val links: PhotoLinks,
    val location: Location,
    val meta: Meta,
    val promoted_at: Any,
    val public_domain: Boolean,
    val related_collections: RelatedCollections,
    val sponsorship: Sponsorship,
    val tags: List<Any>,
    val tags_preview: List<Any>,
    val topic_submissions: TopicSubmissions,
    val topics: List<Topic>,
    val updated_at: String,
    val urls: Urls,
    val user: User,
    val views: Int,
    val width: Int
)
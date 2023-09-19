package com.cmaina.network.api

import com.cmaina.network.models.photos.PhotoListItem
import com.cmaina.network.models.photostats.PhotoStatistics
import com.cmaina.network.models.search.PhotoSearchResultDto
import com.cmaina.network.models.specificphoto.SpecificPhoto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class PhotosRemoteSource(private val client: HttpClient) {

    suspend fun fetchPhotos(page: Int ) = client.get("photos") {
        url {
            parameters.append("page", "$page")
        }
    }

    suspend fun fetchPhoto(id: String) = client.get("photos/$id")

    suspend fun fetchRandomPhoto() = client.get("photos/random")

    suspend fun likePhoto(id: String): PhotoListItem = client.get("photos/$id/like").body()

    suspend fun fetchPhotoStatistics(id: String) =
        client.get("photos/$id/statistics")

    suspend fun searchPhotos(
        searchQuery: String,
        page: Int
    ): PhotoSearchResultDto = client.get("search/photos") {
        url {
            parameters.append("query", searchQuery)
            parameters.append("page", page.toString())
        }
    }.body()

}
package com.cmaina.domain.repository

import androidx.paging.PagingData
import com.cmaina.domain.models.photos.DomainPhotoListItem
import com.cmaina.domain.models.photostats.DomainPhotoStatistics
import com.cmaina.domain.models.specificphoto.SpecificPhotoDomainModel
import com.cmaina.domain.utils.NetworkResult
import kotlinx.coroutines.flow.Flow

interface PhotosRepository {

    suspend fun fetchPhotos(): Flow<PagingData<DomainPhotoListItem>>

    suspend fun getRandomPhoto(): Flow<NetworkResult<DomainPhotoListItem>>

    suspend fun getSpecificPhoto(photoId: String): Flow<SpecificPhotoDomainModel>

    suspend fun getPhotoStatistics(): Flow<DomainPhotoStatistics>

    suspend fun searchPhoto(searchString: String): Flow<PagingData<DomainPhotoListItem>>
}

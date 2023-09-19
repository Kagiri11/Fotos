package com.cmaina.repository.sources

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import com.cmaina.domain.models.auth.AuthDomainResponse
import com.cmaina.domain.repository.AuthRepository
import com.cmaina.domain.utils.Result
import com.cmaina.network.api.AuthRemoteSource
import com.cmaina.network.providers.UserAccessToken
import com.cmaina.repository.mappers.toDomain
import com.cmaina.repository.utils.safeApiCall
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AuthRepositoryImpl(
    private val authRemoteSource: AuthRemoteSource,
    private val preferences: DataStore<Preferences>
) : AuthRepository {

    private val userAuthenticatedPref = booleanPreferencesKey("userAuthenticated")

    override suspend fun authenticateUser(authCode: String): Result<AuthDomainResponse> {
        return safeApiCall { authRemoteSource.authorizeUser(code = authCode).toDomain() }
    }

    override suspend fun saveUserAuthentication(accessToken: String) {
        preferences.apply {
            edit { it[userAuthenticatedPref] = true }
            edit { it[UserAccessToken] = accessToken }
        }
    }

    override suspend fun clearStaleUserAuthentication() {
        preferences.edit {
            it[userAuthenticatedPref] = false
        }
    }

    override suspend fun checkIfUserHasBeenAuthenticated(): Flow<Boolean> {
        return preferences.data.map {
            it[userAuthenticatedPref] ?: false
        }
    }
}

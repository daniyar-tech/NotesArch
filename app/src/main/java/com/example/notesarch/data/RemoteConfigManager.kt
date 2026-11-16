
package com.example.notesarch.data

import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.remoteConfigSettings
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteConfigManager @Inject constructor() {

    private val remoteConfig = FirebaseRemoteConfig.getInstance()

    suspend fun getWelcomeMessage(): String {
        val settings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 0
        }

        remoteConfig.setConfigSettingsAsync(settings)

        remoteConfig.setDefaultsAsync(
            mapOf("welcome_message" to "Добро пожаловать в NotesArch!")
        ).await()

        remoteConfig.fetchAndActivate().await()

        return remoteConfig.getString("welcome_message")
    }
}

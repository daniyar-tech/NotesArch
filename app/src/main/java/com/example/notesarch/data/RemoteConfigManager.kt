package com.example.notesarch.data

import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.remoteConfigSettings
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteConfigManager @Inject constructor() {

    private val remoteConfig = FirebaseRemoteConfig.getInstance()

    suspend fun fetchConfig() {
        val settings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 0
        }

        remoteConfig.setConfigSettingsAsync(settings)

        remoteConfig.setDefaultsAsync(
            mapOf(
                "welcome_message" to "\u0414\u043e\u0431\u0440\u043e \u043f\u043e\u0436\u0430\u043b\u043e\u0432\u0430\u0442\u044c \u0432 NotesArch!",
                "new_feature_enabled" to false,
                "maintenance_mode" to false
            )
        ).await()

        remoteConfig.fetchAndActivate().await()
    }

    fun getWelcomeMessage(): String {
        return remoteConfig.getString("welcome_message")
    }

    fun isNewFeatureEnabled(): Boolean {
        return remoteConfig.getBoolean("new_feature_enabled")
    }

    fun isMaintenanceModeEnabled(): Boolean {
        return remoteConfig.getBoolean("maintenance_mode")
    }
}
package com.example.notesarch.presentation.common

sealed class UiText {
    data class DynamicString(val value: String) : UiText()
    data class StringResource(val resId: Int, val args: List<Any> = emptyList()) : UiText()

    fun asString(context: android.content.Context): String = when (this) {
        is DynamicString -> value
        is StringResource -> context.getString(resId, *args.toTypedArray())
    }
}
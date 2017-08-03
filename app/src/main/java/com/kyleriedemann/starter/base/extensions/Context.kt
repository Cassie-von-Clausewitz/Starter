package com.kyleriedemann.starter.base.extensions

import android.content.Context
import android.content.ContextWrapper
import android.app.Activity

/**
 * Gets a [Context] as an [Activity] if one exists in the [ContextWrapper]
 */
fun Context.getActivity() : Activity? {
    var context = this
    while (context is ContextWrapper) {
        if (context is Activity) {
            return context
        }
        context = context.baseContext
    }
    return null
}
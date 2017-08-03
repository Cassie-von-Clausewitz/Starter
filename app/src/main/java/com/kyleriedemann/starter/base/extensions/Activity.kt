package com.kyleriedemann.starter.base.extensions

import android.app.Activity
import android.content.Intent
import kotlin.reflect.KClass

/**
 * Start an Activity as a new task, clearing the current backstack.
 */
fun Activity.startNew(intent: Intent) {
    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    startActivity(intent)
}

/**
 * Start an Activity as a new task, clearing the current backstack.
 */
fun Activity.startNew(activityClass: KClass<out Activity>) {
    val intent = Intent(this, activityClass.java)
    startNew(intent)
}

/**
 * Just start an activity based on a class. That's all I want to do, android.
 */
fun Activity.startActivity(activityClass: KClass<out Activity>) {
    val intent = Intent(this, activityClass.java)
    startActivity(intent)
}

/** Lazy delegate for easily getting an intent extra as a string. */
fun Activity.stringExtra(id: String) = lazy { intent.getStringExtra(id) }

/** Lazy delegate for easily getting an intent extra as any serializable. */
fun <T> Activity.serializableExtra(id: String): Lazy<T> = lazy { intent.getSerializableExtra(id) as T }

/**
 * Send out a generic text intent.
 */
fun Activity.shareText(text: String) {
    val sendIntent = Intent()
    sendIntent.action = Intent.ACTION_SEND
    sendIntent.putExtra(Intent.EXTRA_TEXT, text)
    sendIntent.type = "text/plain"
    startActivity(sendIntent)
}

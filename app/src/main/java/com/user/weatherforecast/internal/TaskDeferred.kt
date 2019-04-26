package com.user.weatherforecast.internal

import com.google.android.gms.tasks.Task
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Deferred

fun <T> Task<T>.asDeferred(): Deferred<T> {
    val deffered = CompletableDeferred<T>()

    this.addOnSuccessListener { result ->
        deffered.complete(result)
    }

    this.addOnFailureListener { exception ->
        deffered.completeExceptionally(exception)
    }

    return deffered
}
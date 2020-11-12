package com.myecommerce.base.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

/**
 * Used as a wrapper for data that is exposed via a [androidx.lifecycle.LiveData] that represents an event.
 * [https://medium.com/androiddevelopers/livedata-with-snackbar-navigation-and-other-events-the-singleliveevent-case-ac2622673150]
 */
class Event<out T>(private val content: T) {

    private var hasBeenHandled = false

    /**
     * Returns the content and prevents its use again.
     */
    fun getContentIfNotHandled(): T? = if (hasBeenHandled) {
        null
    } else {
        hasBeenHandled = true
        content
    }

    /**
     * Returns the content, even if it's already been handled.
     */
    fun peekContent(): T = content
}

/**
 * An [Observer] for [Event]s, simplifying the pattern of checking if the [Event]'s content has
 * already been handled.
 *
 * @param consumeEvent If `true`, [block] is only called if the [Event]'s content has not been
 * handled, otherwise it's always called.
 *
 * @param block Callback to handle the [Event].
 *
 * @see com.hm.goe.base.ktx.observeEvent
 */
class EventObserver<T>(
    private val consumeEvent: Boolean = true,
    private val block: (T) -> Unit
) : Observer<Event<T>> {
    override fun onChanged(event: Event<T>?) {
        if (consumeEvent) {
            event?.getContentIfNotHandled()
        } else {
            event?.peekContent()
        }?.let {
            block(it)
        }
    }
}

/**
 * Convenience method to emit an [Event] via [LiveData.postValue].
 */
fun <T> MutableLiveData<Event<T>>.postEvent(content: T) {
    postValue(Event(content))
}

/**
 * Convenience method to emit an [Event] via [LiveData.setValue].
 */
fun <T> MutableLiveData<Event<T>>.event(content: T) {
    value = Event(content)
}

fun <T> LiveData<Event<T>>.eventValue() = value?.peekContent()
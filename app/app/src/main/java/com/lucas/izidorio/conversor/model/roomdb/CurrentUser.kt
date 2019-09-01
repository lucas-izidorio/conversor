package com.lucas.izidorio.conversor.model.roomdb

import android.content.Context

object CurrentUser {

    private var currentUserId = -1
    private var currentUser: User? = null

    fun startSession(context: Context, user: String, password: String): CurrentUser {
        currentUser = AppDatabase(context).userDao().getUser(user, password)
        currentUserId = currentUser?.id ?: -1
        return this
    }
    fun updateCurrentUser(context: Context): CurrentUser {
        if (currentUserId != -1) AppDatabase(context).userDao().getUser(currentUserId)
        return this
    }
    fun getCurrentUser(): User? {
        return currentUser
    }
}
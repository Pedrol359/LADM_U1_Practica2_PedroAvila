package com.example.practica1_binance_pedroavilabermudez.data

import android.content.Intent
import com.example.practica1_binance_pedroavilabermudez.CompraCripto
import com.example.practica1_binance_pedroavilabermudez.data.model.LoggedInUser
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    fun login(username: String, password: String): Result<LoggedInUser> {
        try {
            // TODO: handle loggedInUser authentication
            val fakeUser = LoggedInUser(java.util.UUID.randomUUID().toString(), "Benigno")

            return Result.Success(fakeUser)
        } catch (e: Throwable) {
            return Result.Error(IOException("Error al iniciar sesión", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }
}
package com.example.modules

import kotlinx.serialization.Serializable

/***
 * Образ сущности "Пользователь" из базы данных
 */
@Serializable
data class User(
    val id: String? = null,
    val name: String,
    val email: String,
    val password: String,
    val createDate: String? = null
)


package org.chevalierlab.kashier.home.data.dto

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class ItemsItem(

	@SerialName("createdAt")
	val createdAt: String,

	@SerialName("price")
	val price: Int,

	@SerialName("name")
	val name: String,

	@SerialName("id")
	val id: Int,

	@SerialName("userId")
	val userId: String,

	@SerialName("updatedAt")
	val updatedAt: String
)
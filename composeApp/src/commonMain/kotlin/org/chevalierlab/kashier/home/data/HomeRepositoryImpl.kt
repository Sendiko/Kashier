package org.chevalierlab.kashier.home.data

import kotlinx.coroutines.flow.Flow
import org.chevalierlab.kashier.home.data.datasource.DummyDataSource
import org.chevalierlab.kashier.home.data.datasource.ItemRemoteDataSource
import org.chevalierlab.kashier.home.data.datasource.TransactionRemoteDataSource
import org.chevalierlab.kashier.home.data.datasource.UserLocalDataSource
import org.chevalierlab.kashier.home.data.datasource.getDeviceName
import org.chevalierlab.kashier.home.data.dto.CreateTransactionRequest
import org.chevalierlab.kashier.home.domain.models.Item
import org.chevalierlab.kashier.home.domain.repository.HomeRepository

class HomeRepositoryImpl(
    private val dataSource: DummyDataSource,
    private val transactionDataSource: TransactionRemoteDataSource,
    private val remoteDataSource: ItemRemoteDataSource,
    private val userLocalDataSource: UserLocalDataSource
) : HomeRepository {

    override suspend fun getItems(userId: String): Result<List<Item>> {
        val result = remoteDataSource.getItems(userId)

        return if (result.isSuccess) {
            try {
                val itemsResponse = result.getOrThrow()
                Result.success(itemsResponse.items.map { it.toDomain() })
            } catch (e: Exception) {
                Result.failure(e)
            }
        } else {
            Result.failure(result.exceptionOrNull() ?: Exception("Unknown remote error."))
        }
    }

    override suspend fun postItem(item: Item): Result<Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteItem(id: Int): Result<Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun putItem(item: Item): Result<Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun postTransaction(total: Int, userId: String, items: Int): Result<Boolean> {
        val request = CreateTransactionRequest(total, userId, items)
        val result = transactionDataSource.createTransaction(request)

        return when (result) {
            200 -> Result.success(true)
            400 -> Result.failure(Exception("Bad Request."))
            401 -> Result.failure(Exception("Unauthorized."))
            500 -> Result.failure(Exception("Server Error."))
            else -> Result.failure(Exception("Transaction failed."))
        }
    }

    override suspend fun createUser() {
        val allowedChars = ('0'..'9')
        val randomIdentifier = (1..10).map { allowedChars.random() }.joinToString("")
        val userIdentifier = "${getDeviceName()}_$randomIdentifier"
        userLocalDataSource.saveUser(userIdentifier)
    }

    override fun getUser(): Flow<String> {
        return userLocalDataSource.getUser()
    }

}
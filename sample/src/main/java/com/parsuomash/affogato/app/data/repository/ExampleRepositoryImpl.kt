package com.parsuomash.affogato.app.data.repository

import com.parsuomash.affogato.app.di.DefaultRepository
import com.parsuomash.affogato.app.domain.repository.ExampleRepository
import com.parsuomash.affogato.hilt.binding.HiltBinding
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@HiltBinding(
  component = SingletonComponent::class,
  scope = Singleton::class,
  qualifier = DefaultRepository::class
)
class ExampleRepositoryImpl : ExampleRepository {
  override suspend fun getData() = "data"
}

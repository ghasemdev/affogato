package com.parsuomash.affogato.app.domain.repository

interface ExampleRepository {
  suspend fun getData(): String
}

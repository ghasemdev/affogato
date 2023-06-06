package com.parsuomash.affogato.app

import com.parsuomash.affogato.app.di.DefaultRepository
import com.parsuomash.affogato.app.di.FakeRepository
import com.parsuomash.affogato.app.domain.repository.ExampleRepository
import com.parsuomash.affogato.hilt.binding.SingletonBinding
import javax.inject.Inject

class ViewModel @Inject constructor(
  @DefaultRepository val repository: ExampleRepository,
  @FakeRepository val fake: ExampleRepository,
)

@SingletonBinding
class FooImpl : Foo
interface Foo

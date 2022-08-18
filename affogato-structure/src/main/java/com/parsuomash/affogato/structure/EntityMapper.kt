package com.parsuomash.affogato.structure

/**
 * EntityMapper used for creating cache or remote mapper.
 *
 * Example:
 * ```kotlin
 * data class Student(val name: String)
 * data class StudentResponse(val id: Int, val name: String)
 *
 * class StudentMapper : EntityMapper<StudentResponse, Student> {
 *   override fun mapFromEntity(entity: StudentResponse): Student {
 *     return Student(entity.name)
 *   }
 *
 *   override fun mapToEntity(domainModel: Student): StudentResponse {
 *     return StudentResponse(-1, domainModel.name)
 *   }
 * }
 * ```
 * @since 1.3.0
 */
interface EntityMapper<Entity, DomainModel> {
  fun mapFromEntity(entity: Entity): DomainModel
  fun mapToEntity(domainModel: DomainModel): Entity
}

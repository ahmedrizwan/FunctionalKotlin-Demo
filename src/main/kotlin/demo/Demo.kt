package demo

import arrow.core.Either
import arrow.core.Left
import arrow.core.Right

fun main(args: Array<String>) {
    generateRawUsers()
}

data class RawUser(
        val fullName: String,
        val email: String,
        val phone: String,
        val streetAddress: String,
        val city: String,
        val zipCode: String)

data class DomainUser(val person: Person, val phoneNumber: PhoneNumber)

data class Person(val firstName: String, val lastName: String)

data class PhoneNumber(val countryCode: Int, val areaCode: Int, val prefix: Int, val lineNumber: Int)

fun rawUserToDomainUser(rawUser: RawUser): DomainUser {
    throw NotImplementedError()
}

val pattern = """(\d)-(\d{3})-(\d{3})-(\d{4})""".toRegex()
fun phoneToDomainPhoneNumber(phone: String): PhoneNumber {
    throw NotImplementedError()
}

fun fullNameToPerson(name: String): Either<Exception, Person> {
    val names = name.split(" ")
    return Right(Person(names[0], names[1]))
}

package demo

fun main(args: Array<String>) {
}

data class RawUser(
        val fullName: String,
        val email: String,
        val phone: String,
        val streetAddress: String,
        val city: String,
        val zipCode: String)

fun transformRawUserToDomainUser(rawUser: RawUser): DomainUser {
    // TODO: Implement!!!
}

fun transformNameToDomainPerson(name: String): Person {
    // TODO: Implement!!!
}

fun transformPhoneToDomainPhoneNumber(phone: String): PhoneNumber {
    // TODO: Implement!!!
}

data class DomainUser(val person: Person, val phoneNumber: PhoneNumber)

data class Person(val firstName: String, val lastName: String)

data class PhoneNumber(val countryCode: Int, val areaCode: Int, val prefix: Int, val lineNumber: Int)

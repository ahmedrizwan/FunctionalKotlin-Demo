//package working
//
//import arrow.core.*
//import arrow.instances.either.monad.binding
//import java.lang.NumberFormatException
//
//fun main(args: Array<String>) {
//    rawUsers.map(::transform)
//            .map { maybeDomainUser ->
//                maybeDomainUser.fold({
//                    println(it.localizedMessage)
//                }, {
//                    println(it)
//                })
//            }
//}
//
//fun transform(rawUser: RawUser): Either<Exception, DomainUser> {
//    return binding {
//        val person = rawUser.person.bind()
//        val phoneNumber = PhoneNumber.from(rawUser.phone).bind()
//        DomainUser(person, phoneNumber)
//    }
//}
//
//data class DomainUser(val person: Person, val phoneNumber: PhoneNumber)
//
//data class Person(val firstName: String, val lastName: String)
//
//data class RawUser(
//        val fullName: String,
//        val email: String,
//        val phone: String,
//        val streetAddress: String,
//        val city: String,
//        val zipCode: String) {
//    val person: Either<Exception, Person> by lazy {
//        val names = fullName.split(" ").toList()
//        if (names.size == 2) {
//            return@lazy Right(Person(names[0], names[1]))
//        }
//        return@lazy Left(Exception("$fullName is not a correctly formatted name"))
//    }
//}
//
//data class PhoneNumber(val countryCode: Int, val areaCode: Int, val prefix: Int, val lineNumber: Int) {
//    companion object {
//        private val pattern = """(\d)-(\d{3})-(\d{3})-(\d{4})""".toRegex()
//
//        private fun String.intValue(): Either<NumberFormatException, Int> {
//            return Try { this.toInt() }.toEither { NumberFormatException("$this is not a number!") }
//        }
//
//        fun from(phoneString: String): Either<NumberFormatException, PhoneNumber> {
//            val values = pattern.matchEntire(phoneString)?.groupValues?.toList()?.takeLast(4)
//            values?.let {
//                return binding {
//                    val countryCode = it[0].intValue().bind()
//                    val areaCode = it[1].intValue().bind()
//                    val prefix = it[2].intValue().bind()
//                    val lineNumber = it[3].intValue().bind()
//
//                    PhoneNumber(countryCode, areaCode, prefix, lineNumber)
//                }
//            }
//
//            return Left(NumberFormatException("$phoneString didn't parse!"))
//        }
//    }
//
//}
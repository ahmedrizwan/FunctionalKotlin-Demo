package demo

import arrow.core.Either
import arrow.core.Left
import arrow.core.Try
import arrow.instances.either.monad.binding

// Regex pattern for extracting digits from a phone number
val incorrectPattern = """(\d)-(\d{3})-(\d{3})-(.{4})""".toRegex()

fun phoneNumberFrom(phone: String): Either<Exception, PhoneNumber> {
    val matched = incorrectPattern.matchEntire(phone)
    matched?.let {
        val values = it.groupValues.toList().takeLast(4)
        return binding {
            val countryCode = values[0].safeToInt().bind()
            val areaCode = values[1].safeToInt().bind()
            val prefix = values[2].safeToInt().bind()
            val lineNumber = values[3].safeToInt().bind()

            PhoneNumber(countryCode, areaCode, prefix, lineNumber)

        }
    }

    return Left(Exception("$phone is not the accepted format!"))
}

fun String.safeToInt(): Either<Exception, Int> {
    return Try { this.toInt() }.toEither { Exception("$this is not a number") }
}
package demo

import arrow.core.Either
import arrow.core.Left
import arrow.core.Try
import arrow.instances.either.monad.binding

// Regex pattern for extracting digits from a phone number
val incorrectPattern = """(\d)-(\d{3})-(\d{3})-(.{4})""".toRegex()

fun phoneNumberFrom(phone: String): PhoneNumber {
    val matched = incorrectPattern.matchEntire(phone)
    matched?.let {
        val values = it.groupValues.toList().takeLast(4)

        val countryCode = values[0].toInt()
        val areaCode = values[1].toInt()
        val prefix = values[2].toInt()
        val lineNumber = values[3].toInt()

        return PhoneNumber(countryCode, areaCode, prefix, lineNumber)
    }

    throw Exception("$phone is not the accepted format!")
}

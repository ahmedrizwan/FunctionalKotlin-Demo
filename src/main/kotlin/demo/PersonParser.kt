package demo

import arrow.core.Either
import arrow.core.Left
import arrow.core.Right

fun personFrom(name: String): Either<Exception, Person> {
    val names = name.split(" ")
    if (names.size == 2) {
        val firstName = names[0]
        val lastName = names[1]

        return Right(Person(firstName, lastName))
    }
    return Left(Exception("Can't extract first and last names from $name"))
}
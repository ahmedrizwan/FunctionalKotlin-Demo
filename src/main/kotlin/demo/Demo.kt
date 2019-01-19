package demo

import arrow.core.Either
import arrow.instances.either.monad.binding

fun main(args: Array<String>) {
    generateRawUsers()
            .map(::domainUserFrom)
            .map { println(it) }
}

fun domainUserFrom(rawUser: RawUser): Either<Exception, DomainUser> {
    return binding {
        val maybePerson = personFrom(rawUser.fullName).bind()
        val maybePhoneNumber = phoneNumberFrom(rawUser.phone).bind()
        DomainUser(maybePerson, maybePhoneNumber)
    }
}

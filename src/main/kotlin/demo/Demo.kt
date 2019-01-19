package demo

fun main(args: Array<String>) {
    generateRawUsers()
            .map { rawUser ->
                val person = fullNameToPerson(rawUser.fullName)
                val phoneNumber = phoneToDomainPhoneNumber(rawUser.phone)

                println("$person and $phoneNumber parsed!")
                DomainUser(person, phoneNumber)
            }
            .map { domainUser ->
                println(domainUser)
            }
}

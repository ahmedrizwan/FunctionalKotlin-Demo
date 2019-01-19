package demo

fun main(args: Array<String>) {
    generateRawUsers()
            .map { rawUser ->
                val person = fullNameToPerson(rawUser.fullName)
                println(person)

                val phoneNumber = phoneToDomainPhoneNumber(rawUser.phone)
                println(phoneNumber)

                // create domainUser
            }

}

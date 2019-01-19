package demo

fun main(args: Array<String>) {
    generateRawUsers()
            .map {
                val person = fullNameToPerson(it.fullName)
                val phoneNumber = phoneToDomainPhoneNumber(it.phone)

                DomainUser(person, phoneNumber)
            }
            .map { domainUser ->
                println(domainUser)
            }
}

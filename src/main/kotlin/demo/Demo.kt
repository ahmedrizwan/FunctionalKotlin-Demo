package demo

fun main(args: Array<String>) {
    generateRawUsers()
            .map(::domainUserFrom)
}

fun domainUserFrom(rawUser: RawUser) {
    
}


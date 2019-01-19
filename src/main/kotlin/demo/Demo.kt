package demo

fun main(args: Array<String>) {
    generateRawUsers()
            .map(::transform)
}

fun transform(rawUser: RawUser) {
    
}


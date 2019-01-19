package demo

fun fullNameToPerson(name: String): Person {
    val names = name.split(" ")
    val firstName = names[0]
    val lastName = names[1]

    return Person(firstName, lastName)
}
/**
 * =====================================================
 * Kotlin Collections Task 1 - Monkeys
 *
 *    __v__
 *   ( o o )   __v__
 *    (---)   ( o o )
 *             (---)
 *
 * Oh, no! There are monkeys loose in your house. You
 * had better collect all their names so that you can
 * report them to the authorities!
 */


fun main() {
    println("Kotlin Collections Task 1 - Monkeys")
    println("-----------------------------------")
    println()

    // Create a list to store monkey names
    val monkeys = mutableListOf<String>()

    // Add in some test monkeys
    monkeys.add("Dave")
    monkeys.add("Jimmy")
    monkeys.add("Amy")

    // Show the monkeys
    showMonkeys(monkeys)
    println(monkeyCounter(monkeys))

    // Check the list
    check(monkeys.count() == 3)
    check(monkeyCounter(monkeys) == "There are 3 monkeys!")

    // See which monkey has the longest name
    println("Longest Name: ${longestMonkeyName(monkeys)}")
    check(longestMonkeyName(monkeys) == "Jimmy")

    // Adding Monkeys --------------------------------------------

    // Ask the user for three new monkey names and add to the list
    for (i in 1..3) {
        getNewMonkey(monkeys)
    }

    // Show the monkeys
    showMonkeys(monkeys)
    println(monkeyCounter(monkeys))
    println("Longest Name: ${longestMonkeyName(monkeys)}")

    // Check the list
    check(monkeys.count() == 6)
    check(monkeyCounter(monkeys) == "There are 6 monkeys!")

    // Removing Monkeys --------------------------------------------

    // Delete the first monkey
    deleteFirstMonkey(monkeys)

    // Show the monkeys
    showMonkeys(monkeys)
    println(monkeyCounter(monkeys))
    println("Longest Name: ${longestMonkeyName(monkeys)}")

    // Check the list
    check(monkeys.count() == 5)
    check(monkeyCounter(monkeys) == "There are 5 monkeys!")

    // Delete the last monkey
    deleteLastMonkey(monkeys)

    // Show the monkeys
    showMonkeys(monkeys)
    println(monkeyCounter(monkeys))
    println("Longest Name: ${longestMonkeyName(monkeys)}")

    // Check the list
    check(monkeys.count() == 4)
    check(monkeyCounter(monkeys) == "There are 4 monkeys!")

    // Try to delete 10 monkeys
    for (i in 1..10) {
        deleteFirstMonkey(monkeys)
    }

    // Show the monkeys
    showMonkeys(monkeys)
    println(monkeyCounter(monkeys))
    println("Longest Name: ${longestMonkeyName(monkeys)}")

    // Check the list
    check(monkeys.count() == 0)
    check(monkeyCounter(monkeys) == "There are no monkeys!")
}


/**
 * Show a given list of monkeys in the format
 * Monkey List
 * -------------------
 * Monkey 1: Dave
 * Monkey 2: Jimmy
 * Monkey 3: Sally
 * etc.
 */
fun showMonkeys(monkeyList: List<String>) {
    println("\nMonkey List")
    println("-------------------")

    // Loop through the given list and show each monkey
    monkeyList.forEachIndexed { monkey, name ->
        println("$name: $monkey")
    }
    if (monkeyList.isEmpty()) println("There are no monkeys to list!")
    println()
}


/**
 * Get a monkey name from the user (no blanks allowed)
 * and then add it to the given monkey list
 */
fun getNewMonkey(monkeyList: MutableList<String>) {
    // Ask the user for a monkey name (no blanks)
    var input: String

    print("Enter New Monkey: ")
    while (true) {
        input = readln()
        if (input.isNotEmpty()) break
        println("Please enter a name that is not blank!")
    }

    // Add the name to the list
    monkeyList.add(input)

    // Show some feedback
    println("Added new monkey: $input")
}


/**
 * Returns the number of monkeys in the given list
 * in the format:
 *   There are N monkeys!
 * If there are no monkeys, it should return:
 *   There are no monkeys!
 */
fun monkeyCounter(monkeyList: List<String>): String {
    // return the number of monkeys in the list
    val numMonkeys = monkeyList.size
    if (numMonkeys == 0) return "There are no monkeys!"
    return "There are $numMonkeys monkeys!"
}


/**
 * Returns the name of the monkey
 * If lengths match, return the lowest index
 */
fun longestMonkeyName(monkeyList: List<String>): String {
    if (monkeyList.isEmpty()) return "There are no monkeys!"
    // Loop through the list and find the longest name
    return monkeyList.maxBy { it.length }
}


/**
 * Removes the first monkey from the given list
 * if the list is not empty
 */
fun deleteFirstMonkey(monkeyList: MutableList<String>) {
    if (monkeyList.isEmpty()) return
    // Show some feedback
    println("Removing monkey: ${monkeyList[0]}")
    // Remove the first one from the list
    monkeyList.removeAt(0)
}


/**
 * Removes the last monkey from the given list
 * if the list is not empty
 */
fun deleteLastMonkey(monkeyList: MutableList<String>) {
    // Show some feedback
    println("Removing monkey: ${monkeyList[monkeyList.lastIndex]}")

    // Remove the last one from the list
    monkeyList.removeAt(monkeyList.lastIndex)
}


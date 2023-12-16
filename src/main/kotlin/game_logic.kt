// Класс, представляющий результат оценки догадки.
data class GuessResult(val bulls: Int, val cows: Int)

// Генерация тайного числа.
fun generateSecretNumber(): String {
    // Создание списка цифр от '0' до '9'.
    val digits = ('0'..'9').toList()
    // Перемешивание списка цифр и выбор первых четырех цифр.
    val shuffledDigits = digits.shuffled().subList(0, 4)
    // Объединение выбранных цифр в строку.
    return shuffledDigits.joinToString("")
}

// Оценка догадки по сравнению с тайным числом.
fun evaluateGuess(userGuess: String, secretNumber: String): GuessResult {
    // Переменные для хранения количества быков и коров.
    var bulls = 0
    var cows = 0

    for (i in userGuess.indices) {
        if (userGuess[i] == secretNumber[i]) {
            bulls++
        } else if (secretNumber.contains(userGuess[i])) {
            cows++
        }
    }

    return GuessResult(bulls, cows)
}

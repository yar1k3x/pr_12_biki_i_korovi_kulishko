fun main() {
    // Вывод приветствия и правил игры.
    println("Игра 'Быки и Коровы'")
    println("Компьютер загадал 4-значное тайное число, состоящее из уникальных цифр. Попробуйте отгадать его!")
    println("«Коровы» - цифры угаданы на неверных позициях. «Быки» - цифры угаданы вплоть до позиции.")

    // Генерация тайного числа компьютером.
    val secretNumber = generateSecretNumber()
    // Переменная для хранения количества попыток.
    var countAttempts = 0

    // Бесконечный цикл для ввода догадок игрока.
    while (true) {
        // Запрос ввода 4-значного числа от пользователя.
        print("Введите 4-значное число: ")
        val userGuess = readln()

        // Проверка корректности ввода (4-значное число из цифр).
        if (isValidGuess(userGuess)) {
            // Увеличение счетчика попыток.
            countAttempts++
            // Оценка догадки и вывод результатов.
            val (bulls, cows) = evaluateGuess(userGuess, secretNumber)
            println("Результат попытки $countAttempts: $bulls бык(ов), $cows корова(ы)")

            // Проверка на отгаданное число (4 быка).
            if (bulls == 4) {
                println("Поздравляем! Вы отгадали число $secretNumber за $countAttempts попыток.")
                break
            }
        } else {
            println("Введите корректное 4-значное число!")
        }
    }
}

// Проверка корректности ввода (4-значное число из цифр).
fun isValidGuess(guess: String): Boolean {
    return guess.length == 4 && guess.all { it.isDigit() }
}

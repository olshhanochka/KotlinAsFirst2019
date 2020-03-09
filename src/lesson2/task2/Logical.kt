@file:Suppress("UNUSED_PARAMETER")

package lesson2.task2

import lesson1.task1.sqr
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * Пример
 *
 * Лежит ли точка (x, y) внутри окружности с центром в (x0, y0) и радиусом r?
 */
fun pointInsideCircle(x: Double, y: Double, x0: Double, y0: Double, r: Double) =
    sqr(x - x0) + sqr(y - y0) <= sqr(r)

/**
 * Простая
 *
 * Четырехзначное число назовем счастливым, если сумма первых двух ее цифр равна сумме двух последних.
 * Определить, счастливое ли заданное число, вернуть true, если это так.
 */
fun isNumberHappy(number: Int): Boolean {
    val a = number / 100 // первые два числа
    val a1 = a / 10 // первое число
    val a2 = a % 10 // второе число
    val b = number % 100 // вторые два числа
    val b1 = b / 10 // третье число
    val b2 = b % 10 // четвертое число
    return when {
        (a1 + a2) == (b1 + b2) -> true
        else -> false

    }
}

/**
 * Простая
 *
 * На шахматной доске стоят два ферзя (ферзь бьет по вертикали, горизонтали и диагоналям).
 * Определить, угрожают ли они друг другу. Вернуть true, если угрожают.
 * Считать, что ферзи не могут загораживать друг друга.
 */
fun queenThreatens(x1: Int, y1: Int, x2: Int, y2: Int): Boolean {
   return when {
        (x1 == x2) -> true
        (y1 == y2) -> true
        ((x1 + y1) == (x2 + y2)) -> true
        ((x1 - y1) == (x2 - y2)) -> true
        else -> false
    }
}


/**
 * Простая
 *
 * Дан номер месяца (от 1 до 12 включительно) и год (положительный).
 * Вернуть число дней в этом месяце этого года по григорианскому календарю.
 */
fun daysInMonth(month: Int, year: Int): Int {
    val y = year % 400
    val v = year % 100
    val b = year % 4
    val c = when {
        (y == 0) -> 29
        (v == 0) -> 28
        (b == 0) -> 29
        else -> 28
    }

    return when(month){
        1, 3, 5, 7, 8, 10, 12 -> 31
        4, 6, 9, 11 -> 30
        2 -> c
        else -> 0
    }


}

/**
 * Средняя
 *
 * Проверить, лежит ли окружность с центром в (x1, y1) и радиусом r1 целиком внутри
 * окружности с центром в (x2, y2) и радиусом r2.
 * Вернуть true, если утверждение верно
 */
fun circleInside(
    x1: Double, y1: Double, r1: Double,
    x2: Double, y2: Double, r2: Double
): Boolean {
    //(a1 - a2)^2 + (b1-b2)^2 < (r-r2)^2 то лежит
    val a: Double = (x2 - x1).pow(2)
    val b: Double = (y2 - y1).pow(2)
    val c: Double = (r2 - r1).pow(2)
    println(a)
    println(b)
    println(c)
    return when {
        (a + b) < c -> true
        else -> false
    }
}

/**
 * Средняя
 *
 * Определить, пройдет ли кирпич со сторонами а, b, c сквозь прямоугольное отверстие в стене со сторонами r и s.
 * Стороны отверстия должны быть параллельны граням кирпича.
 * Считать, что совпадения длин сторон достаточно для прохождения кирпича, т.е., например,
 * кирпич 4 х 4 х 4 пройдёт через отверстие 4 х 4.
 * Вернуть true, если кирпич пройдёт
 */
fun brickPasses(a: Int, b: Int, c: Int, r: Int, s: Int): Boolean = TODO()

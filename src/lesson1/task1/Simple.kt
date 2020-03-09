@file:Suppress("UNUSED_PARAMETER")

package lesson1.task1

import lesson2.task1.ageDescription
import lesson2.task2.circleInside
import lesson2.task2.daysInMonth
import lesson2.task2.isNumberHappy
import lesson3.task1.digitNumber
import lesson3.task1.fib
import kotlin.math.*

/**
 * Пример
 *
 * Вычисление квадрата целого числа
 */
fun sqr(x: Int) = x * x

/**
 * Пример
 *
 * Вычисление квадрата вещественного числа
 */
fun sqr(x: Double) = x * x

/**
 * Пример
 *
 * Вычисление дискриминанта квадратного уравнения
 */
fun discriminant(a: Double, b: Double, c: Double) = sqr(b) - 4 * a * c

/**
 * Пример
 *
 * Поиск одного из корней квадратного уравнения
 */
fun quadraticEquationRoot(a: Double, b: Double, c: Double) =
    (-b + sqrt(discriminant(a, b, c))) / (2 * a)

/**
 * Пример
 *
 * Поиск произведения корней квадратного уравнения
 */
fun quadraticRootProduct(a: Double, b: Double, c: Double): Double {
    val sd = sqrt(discriminant(a, b, c))
    val x1 = (-b + sd) / (2 * a)
    val x2 = (-b - sd) / (2 * a)
    return x1 * x2 // Результат
}

/**
 * Пример главной функции
 */
fun main() {
    println(fib(5))
    //println(digitNumber(1))
    //println (daysInMonth(2, 2020))
    //println (isNumberHappy(1234))
   // println (ageDescription(350))

    //val x = numberRevert (478)
    //println(x)
    //val x = accountInThreeYears(100, 10)
    //println(x)
    //val x = travelMinutes(9, 25, 13, 1)
    //println(x)
    //val db = trackLength (3.0,0.0,0.0,4.0)
    //println (db)
    //val db = angleInRadian (36, 14,35)
    //println (db)
    //val db = lengthInMeters (8, 2, 11)
    //println (db)
    //val d = seconds (8, 20,35 )
    //println (d)
    //val x1x2 = quadraticRootProduct(1.0, 13.0, 42.0)
    //printLn("Root product: $x1x2")
}

/**
 * Тривиальная
 *
 * Пользователь задает время в часах, минутах и секундах, например, 8:20:35.
 * Рассчитать время в секундах, прошедшее с начала суток (30035 в данном случае).
 */
fun seconds(hours: Int, minutes: Int, seconds: Int): Int {
    val x = hours * 3600//
    val y = minutes * 60
    val c = x + y + seconds
    return c
}

/**
 * Тривиальная
 *
 * Пользователь задает длину отрезка в саженях, аршинах и вершках (например, 8 саженей 2 аршина 11 вершков).
 * Определить длину того же отрезка в метрах (в данном случае 18.98).
 * 1 сажень = 3 аршина = 48 вершков, 1 вершок = 4.445 см.
 */
fun lengthInMeters(sagenes: Int, arshins: Int, vershoks: Int): Double {
    var ver = 4.445
    val verM = ver / 100
    val ars = (48 * verM) / 3
    val sag = 48 * verM
    val a = sagenes * sag
    val b = arshins * ars
    val c = vershoks * verM
    val d = a + b + c
    return d
}


/**
 * Тривиальная
 *
 * Пользователь задает угол в градусах, минутах и секундах (например, 36 градусов 14 минут 35 секунд).
 * Вывести значение того же угла в радианах (например, 0.63256).
 */
fun angleInRadian(deg: Int, min: Int, sec: Int): Double {
    PI
    val x = deg * (PI / 180)
    val y = min * (PI / (180 * 60))
    val z = sec * (PI / (180 * 60 * 60))
    val rad = x + y + z
    return rad
}

/**
 * Тривиальная
 *
 * Найти длину отрезка, соединяющего точки на плоскости с координатами (x1, y1) и (x2, y2).
 * Например, расстояние между (3, 0) и (0, 4) равно 5
 */
fun trackLength(x1: Double, y1: Double, x2: Double, y2: Double): Double {
    val a = x2 - x1
    val b = y2 - y1
    val c = a * a
    val d = b * b
    val kor = sqrt(c + d)
    return kor

}

/**
 * Простая
 *
 * Пользователь задает целое число, большее 100 (например, 3801).
 * Определить третью цифру справа в этом числе (в данном случае 8).
 */
fun thirdDigit(number: Int): Int {
    val a = number / 100
    val b = a % 10
    return b
}

/**
 * Простая
 *
 * Поезд вышел со станции отправления в h1 часов m1 минут (например в 9:25) и
 * прибыл на станцию назначения в h2 часов m2 минут того же дня (например в 13:01).
 * Определите время поезда в пути в минутах (в данном случае 216).
 */
fun travelMinutes(hoursDepart: Int, minutesDepart: Int, hoursArrive: Int, minutesArrive: Int): Int {
    val a = (hoursDepart * 3600) + (minutesDepart * 60)
    val b = (hoursArrive * 3600) + (minutesArrive * 60)
    val c = (b - a) / 60
    return c
}


/**
 * Простая
 *
 * Человек положил в банк сумму в s рублей под p% годовых (проценты начисляются в конце года).
 * Сколько денег будет на счету через 3 года (с учётом сложных процентов)?
 * Например, 100 рублей под 10% годовых превратятся в 133.1 рубля
 */
fun accountInThreeYears(initial: Int, percent: Int): Double {
    val b: Double = 1 + (percent / 100.0)
    val c: Double = b.pow(3)
    return initial * c

}

/**
 * Простая
 *
 * Пользователь задает целое трехзначное число (например, 478).
 * Необходимо вывести число, полученное из заданного перестановкой цифр в обратном порядке (например, 874).
 */
fun numberRevert(number: Int): Int {
    val a = number % 10 //8
    val b = number / 10 // 47
    val c = b % 10 //7
    val d = b / 10 //4
    return a * 100 + c * 10 + d
}


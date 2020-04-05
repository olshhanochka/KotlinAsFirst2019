@file:Suppress("UNUSED_PARAMETER")

package lesson11.task1

import lesson4.task1.abs
import java.lang.IllegalArgumentException
import kotlin.math.abs

/**
 * Класс "Величина с размерностью".
 *
 * Предназначен для представления величин вроде "6 метров" или "3 килограмма"
 * Общая сложность задания - средняя.
 * Величины с размерностью можно складывать, вычитать, делить, менять им знак.
 * Их также можно умножать и делить на число.
 *
 * В конструктор передаётся вещественное значение и строковая размерность.
 * Строковая размерность может:
 * - либо строго соответствовать одной из abbreviation класса Dimension (m, g)
 * - либо соответствовать одной из приставок, к которой приписана сама размерность (Km, Kg, mm, mg)
 * - во всех остальных случаях следует бросить IllegalArgumentException
 */
class DimensionalValue(val value1: Double, val dimension1: String) : Comparable<DimensionalValue> {
    /**
     * Величина с БАЗОВОЙ размерностью (например для 1.0Kg следует вернуть результат в граммах -- 1000.0)
     */
    val value: Double
        get() {
            return when (Dimension.from(dimension1)) {
                Dimension.KILOGRAM -> DimensionPrefix.KILO.multiplier * value1
                Dimension.KILOMETER -> DimensionPrefix.KILO.multiplier * value1
                Dimension.MILLIGRAM -> DimensionPrefix.MILLI.multiplier * value1
                Dimension.MILLIMETER -> DimensionPrefix.MILLI.multiplier * value1
                else -> value1
            }
        }

    /**
     * БАЗОВАЯ размерность (опять-таки для 1.0Kg следует вернуть GRAM)
     */
    val dimension: Dimension
        get() {
            return when (Dimension.from(dimension1)) {
                Dimension.KILOGRAM -> Dimension.GRAM
                Dimension.KILOMETER -> Dimension.METER
                Dimension.MILLIGRAM -> Dimension.GRAM
                Dimension.MILLIMETER -> Dimension.METER
                else -> Dimension.from(dimension1)
            }
        }

    /**
     * Конструктор из строки. Формат строки: значение пробел размерность (1 Kg, 3 mm, 100 g и так далее).
     */
    constructor(s: String) : this(s.substringBefore(" ").toDouble(), s.substringAfter(" "))

    /**
     * Сложение с другой величиной. Если базовая размерность разная, бросить IllegalArgumentException
     * (нельзя складывать метры и килограммы)
     */
    operator fun plus(other: DimensionalValue): DimensionalValue {
        if (dimension == other.dimension) {
            return DimensionalValue(value + other.value, dimension.abbreviation)
        } else throw IllegalArgumentException()
    }

    /**
     * Смена знака величины
     */
    operator fun unaryMinus(): DimensionalValue {
        val min = - value
        return DimensionalValue(min, dimension.abbreviation)
//        return if (value < 0) {
//            DimensionalValue(abs(value), dimension.abbreviation)
//        } else DimensionalValue(-value, dimension.abbreviation)
    }

    /**
     * Вычитание другой величины. Если базовая размерность разная, бросить IllegalArgumentException
     */
    operator fun minus(other: DimensionalValue): DimensionalValue {
        if (dimension == other.dimension) {
            return DimensionalValue(value - other.value, dimension.abbreviation)
        } else throw IllegalArgumentException()
    }

    /**
     * Умножение на число
     */
    operator fun times(other: Double): DimensionalValue = DimensionalValue(value * other, dimension.abbreviation)

    /**
     * Деление на число
     */
    operator fun div(other: Double): DimensionalValue = DimensionalValue(value / other, dimension.abbreviation)

    /**
     * Деление на другую величину. Если базовая размерность разная, бросить IllegalArgumentException
     */
    operator fun div(other: DimensionalValue): Double {
        if (dimension == other.dimension) {
            return value / other.value
        } else throw IllegalArgumentException()
    }

    /**
     * Сравнение на равенство
     */
    override fun equals(other: Any?): Boolean {
        if (other !is DimensionalValue) {
            return false
        }
        return value == (other as DimensionalValue).value && dimension == (other as DimensionalValue).dimension
    }

    override fun hashCode(): Int {
        return value.hashCode() + dimension.hashCode()
    }

    /**
     * Сравнение на больше/меньше. Если базовая размерность разная, бросить IllegalArgumentException
     */
    override fun compareTo(other: DimensionalValue): Int {
        return if (dimension == other.dimension) {
            if (value < other.value) {
                -1
            } else 1
        } else throw IllegalArgumentException()
    }
}

/**
 * Размерность. В этот класс можно добавлять новые варианты (секунды, амперы, прочие), но нельзя убирать
 */
enum class Dimension(val abbreviation: String) {
    METER("m"),
    GRAM("g"),
    KILOGRAM("Kg"),
    KILOMETER("Km"),
    MILLIMETER("mm"),
    MILLIGRAM("mg");

    companion object {
        fun from(findValue: String): Dimension = Dimension.values().first { it.abbreviation == findValue }
    }

}

/**
 * Приставка размерности. Опять-таки можно добавить новые варианты (деци-, санти-, мега-, ...), но нельзя убирать
 */
enum class DimensionPrefix(val abbreviation: String, val multiplier: Double) {
    KILO("K", 1000.0),
    MILLI("m", 0.001);
}
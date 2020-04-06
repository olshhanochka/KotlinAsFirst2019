@file:Suppress("UNUSED_PARAMETER")

package lesson12.task1

import java.util.*
import java.util.Collections.list

/**
 * Класс "Телефонная книга".
 *
 * Общая сложность задания -- средняя.
 * Объект класса хранит список людей и номеров их телефонов,
 * при чём у каждого человека может быть более одного номера телефона.
 * Человек задаётся строкой вида "Фамилия Имя".
 * Телефон задаётся строкой из цифр, +, *, #, -.
 * Поддерживаемые методы: добавление / удаление человека,
 * добавление / удаление телефона для заданного человека,
 * поиск номера(ов) телефона по заданному имени человека,
 * поиск человека по заданному номеру телефона.
 *
 * Класс должен иметь конструктор по умолчанию (без параметров).
 */
class PhoneBook {
    var cont: MutableMap<String, MutableList<String>> = mutableMapOf()
    /**
     * Добавить человека.
     * Возвращает true, если человек был успешно добавлен,
     * и false, если человек с таким именем уже был в телефонной книге
     * (во втором случае телефонная книга не должна меняться).
     */
    fun addHuman(name: String): Boolean {
        if (cont.containsKey(name)) {
            return false
        } else
            cont[name] = mutableListOf()
        return true
    }

    /**
     * Убрать человека.
     * Возвращает true, если человек был успешно удалён,
     * и false, если человек с таким именем отсутствовал в телефонной книге
     * (во втором случае телефонная книга не должна меняться).
     */
    fun removeHuman(name: String): Boolean {
        return if (cont.containsKey(name)) {
            cont.remove(name)
            true
        } else false
    }

    /**
     * Добавить номер телефона.
     * Возвращает true, если номер был успешно добавлен,
     * и false, если человек с таким именем отсутствовал в телефонной книге,
     * либо у него уже был такой номер телефона,
     * либо такой номер телефона зарегистрирован за другим человеком.
     */
    fun addPhone(name: String, phone: String): Boolean {
        if (cont.containsKey(name)) {
            cont.values.forEach() {
                if (!it.contains(phone)) {
                    var ll = cont[name]
                    if (ll.isNullOrEmpty()) {
                        cont[name] = mutableListOf(phone)
                        return true
                    } else
                        ll.add(phone)
                    return true
                } else return false
            }
        } else cont[name] = mutableListOf(phone)
        return true
    }

    /**
     * Убрать номер телефона.
     * Возвращает true, если номер был успешно удалён,
     * и false, если человек с таким именем отсутствовал в телефонной книге
     * либо у него не было такого номера телефона.
     */
    fun removePhone(name: String, phone: String): Boolean {
        if (!cont.containsKey(name)) {
            cont.values.forEach() {
                return if (it.contains(phone)) {
                    false
                } else false
            }
        } else
            cont.remove(name)
        return true
    }

    /**
     * Вернуть все номера телефона заданного человека.
     * Если этого человека нет в книге, вернуть пустой список
     */
    fun phones(name: String): Set<String> {
        if (cont.containsKey(name)) {
            val mm = cont[name]
            if (mm.isNullOrEmpty()) {
                cont[name] = mutableListOf()
                return emptySet()
            } else
                return mm.toSet()
        } else return emptySet()
    }

    /**
     * Вернуть имя человека по заданному номеру телефона.
     * Если такого номера нет в книге, вернуть null.
     */
    fun humanByPhone(phone: String): String? {
        cont.values.forEach() { i ->
            if (i.contains(phone)) {
                var keyy = cont.filterValues { it.contains(phone) }.keys
                return keyy.first()
            }
        }
        return null
    }

    /**
     * Две телефонные книги равны, если в них хранится одинаковый набор людей,
     * и каждому человеку соответствует одинаковый набор телефонов.
     * Порядок людей / порядок телефонов в книге не должен иметь значения.
     */
    override fun equals(other: Any?): Boolean {
        return if (other !is PhoneBook) {
            false
        } else {
            (other.cont.keys.containsAll(cont.keys)
                    && (other.cont.values.flatten().containsAll(cont.values.flatten())))
        }
    }

    override fun hashCode(): Int {
        return cont.keys.hashCode() + cont.values.flatten().sorted().hashCode()
    }
}
/**
 * MyString is a class representing a string. The class supports basic string capabilities:
- string creation
- concatenation and trimming of strings
- search in a string
- converting a number of type Integer to a string
- converting a string to a number of type Float
 */
class MyString : CharSequence {
    //array for characters of string
    private val value: CharArray
    //string size
    private val size: Int

    /**
     * Creates a string from a sequence of characters
     *
     * @param myString sequence of characters
     */
    constructor(myString: CharSequence) {
        size = myString.length
        value = CharArray(size)
        for (i in 0 until size) {
            value[i] = myString[i]
        }
    }

    /**
     * Creates a string from character array
     *
     * @param myString array of characters
     */
    constructor(myString: CharArray) {
        size = myString.size
        value = myString
    }

    /**
     * Adds a sequence of characters to the end of the current string
     *
     * @param addString the sequence of characters to be added
     */
    fun concat(addString: CharSequence): CharSequence {
        val newSize = size + addString.length
        val result = CharArray(newSize)
        System.arraycopy(value, 0, result, 0, size)
        for ((index, i) in (size until newSize).withIndex()) {
            result[i] = addString[index]
        }
        return MyString(result)
    }

    fun concat(addString: MyString): MyString {
        val newSize = size + addString.length
        val result = CharArray(newSize)
        System.arraycopy(value, 0, result, 0, size)
        for ((index, i) in (size until newSize).withIndex()) {
            result[i] = addString[index]
        }
        return MyString(result)
    }

    operator fun contains(findString: CharSequence): Boolean {
        for (i in 0 until size) {
            if (value[i] == findString[0]) {
                var index = 1
                for (j in i + 1 until i + findString.length) {
                    if (value[j] != findString[index]) {
                        return false
                    }
                    index++
                }
                return true
            }
        }
        return false
    }

    fun trimm(start: Int, end: Int): CharSequence {
        return subSequence(start, end)
    }

    fun toFloat(): Float {
        return toString().toFloat()
    }

    override val length: Int
        get() = size

    override fun get(index: Int): Char {
        return value[index]
    }

    override fun subSequence(start: Int, end: Int): CharSequence {
        val result = CharArray(end - start)
        for ((index, i) in (start until end).withIndex()) {
            result[index] = value[i]
        }
        return MyString(result)
    }

    override fun toString(): String {
        val result = StringBuilder()
        for (i in 0 until size) {
            result.append(value[i])
        }
        return result.toString()
    }

    companion object {
        fun intToMyString(number: Int): MyString {
            var positiveNumber = kotlin.math.abs(number)
            val size = (kotlin.math.log10(positiveNumber.toDouble()) + 1).toInt()
            val value: CharArray
            var index = 0
            if (number < 0) {
                value = CharArray(size + 1)
                value[0] = '-'
                index = 1
            } else {
                value = CharArray(size)
            }
            for (i in size + index - 1 downTo index) {
                value[i] = ('0'.toInt() + positiveNumber % 10).toChar()
                positiveNumber /= 10
            }
            return MyString(value)
        }
    }
}
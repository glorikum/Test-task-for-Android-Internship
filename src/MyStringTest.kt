import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class MyStringTest() {
    private val size = 10
    private lateinit var actual: String
    private lateinit var expected: MyString

    @Before
    fun setUp() {
        actual = "0123456789"
        expected = MyString("0123456789")
    }

    @Test
    fun concat() {
        for (i in 0 until size) {
            assertEquals(expected.concat(i.toString()).toString(), actual.plus(i))
        }
    }

    @Test
    fun contains() {
        var find: String = ""
        for (i in 0 until size) {
            find = find.plus(i)
            assertEquals(expected.contains(find), actual.contains(find))
        }
    }

    @Test
    fun trim() {
        for (i in 0 until size) {
            assertEquals(expected.trim(i, i + 1).toString(), actual.subSequence(i, i + 1))
        }
    }

    @Test
    fun toFloat() {
        for (i in 0 until size) {
            assertEquals(expected.trim(i, i + 1).toFloat(), actual.subSequence(i, i + 1).toString().toFloat())
        }
    }

    @Test
    fun getLength() {
        for (i in 0 until size) {
            assertEquals(expected.length, actual.length)
            expected.trim(i,i+1)
            actual.subSequence(i, i + 1)
        }
    }

    @Test
    fun get() {
        for (i in 0 until size) {
            assertEquals(expected.get(i), actual.get(i))
        }
    }

    @Test
    fun intToString() {
        for (i in -size until size) {
            expected = MyString.intToMyString(i)
            actual = i.toString()
            assertEquals(expected.toString(), actual)
        }
    }
}
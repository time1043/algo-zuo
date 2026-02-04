package started004

import com.time1043.started004.SelectBubbleInsertSort
import org.junit.jupiter.api.Test
import kotlin.random.Random
import kotlin.test.assertContentEquals

class SelectBubbleInsertSortTest {
    val sorter = SelectBubbleInsertSort()

    private val epoch = 3
    private val maxSize = 10
    private val maxValue = 100

    fun generateRandomArray(maxSize: Int, maxValue: Int): IntArray {
        val nums = IntArray(maxSize)
        for (i in nums.indices)
            nums[i] = Random.nextInt(1, maxValue)
        return nums
    }

    fun violenceSolution(nums: IntArray) {
        nums.sort()
    }

    fun check(solution: (IntArray) -> Unit) {
        repeat(epoch) {
            val input = generateRandomArray(maxSize, maxValue)
            val expected = input.copyOf().also { violenceSolution(it) }
            val actual = input.copyOf().also { solution(it) }

            // println("Input   : ${input.contentToString()}")
            // println("Expected: ${expected.contentToString()}")
            // println("Actual  : ${actual.contentToString()}")
            assertContentEquals(expected, actual)
        }
    }

    @Test
    fun selectionSort() {
        check(sorter::selectionSort)
    }

    @Test
    fun bubbleSort() {
        check(sorter::bubbleSort)
    }

    @Test
    fun insertSort() {
        check(sorter::insertSort)
    }
}
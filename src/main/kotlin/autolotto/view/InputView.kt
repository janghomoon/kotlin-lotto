package autolotto.view

import autolotto.valid.*

object InputView {
    private const val LOTTO_AMOUNT = 1000

    private val positiveNumberValidator = PositiveNumberValidatorStrategy()
    private val lottoAmountValidator = LottoAmountValidatorStrategy()
    private val winningNumberValidator = WinningNumberValidatorStrategy()
    private val numberValidatorStrategy = NumberValidatorStrategy()

    fun getLottoGameCount(amount: Int): Int {
        return amount / LOTTO_AMOUNT
    }

    fun printLottoGameCount(amount: Int) {
        println("${getLottoGameCount(amount)}개를 구매했습니다.")
    }

    fun getLottoPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        val input: Int = readLine()?.toIntOrNull() ?: throw RuntimeException("0 이 아닌 숫자를 입력해주세요")

        if (!positiveNumberValidator.isValid(input)) {
            throw RuntimeException(positiveNumberValidator.getErrorMessage())
        }

        if (!lottoAmountValidator.isValid(input)) {
            throw RuntimeException(lottoAmountValidator.getErrorMessage())
        }

        return input
    }

    fun getWinningNumber(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val input: String? = readLine()
        if (input.isNullOrEmpty()) {
            throw RuntimeException("당청번호를 입력해주세요.")
        }
        val splitValue = splitWinningNumbers(input)
        return splitValue.map { e ->
            if (!numberValidatorStrategy.isValid(e)) {
                throw RuntimeException(numberValidatorStrategy.getErrorMessage())
            }
            val number = Integer.parseInt(e)
            if (!positiveNumberValidator.isValid(number)) {
                throw RuntimeException(positiveNumberValidator.getErrorMessage())
            }
            number
        }.also { numbers ->
            if (!winningNumberValidator.isValid(numbers)) {
                throw RuntimeException(winningNumberValidator.getErrorMessage())
            }
        }
    }

    fun printInputWinningNumber(winningNumbers: List<Int>) {
        val winningNumber = winningNumbers.joinToString { "," }
        println(winningNumber)
    }

    private fun splitWinningNumbers(input: String): List<String> {
        return input.split(",").map { e -> e.trim() }
    }
}

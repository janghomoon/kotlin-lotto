package autolotto.service

import autolotto.domain.WinningLottoNumber
import autolotto.entity.Lotto
import autolotto.enums.prize.Prize
import autolotto.repository.LottoRepository
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoServiceTest {
    val lottoRepository: LottoRepository = LottoRepository()
    val service: LottoService = LottoService(lottoRepository)

    @Test
    fun `lotto 값 생성 시 중복되는 숫자가 없어야한다`() {
        service.start(1)
        val lotto = lottoRepository.findAll().first()
        lotto.getNumbers().size shouldBe 6
    }

    @Test
    fun `당첨번호에 따른 당첨등수 보너스 포함 산정 테스트`() {
        val lottos =
            listOf(
                Lotto(setOf(15, 14, 17, 9, 3, 6)),
                Lotto(setOf(1, 2, 3, 7, 8, 9)),
                Lotto(setOf(1, 2, 17, 14, 15, 16)),
                Lotto(setOf(7, 8, 17, 9, 15, 30)),
            )
        lottos.forEach { lotto -> lottoRepository.save(lotto) }
        val winningLottoNumber = WinningLottoNumber(setOf(7, 8, 9, 17, 14, 15), 30)
        val result = service.getResult(winningLottoNumber)

        result.get(Prize.THREE) shouldBe 2
        result.get(Prize.FOUR) shouldBe 1
        result.get(Prize.BONUS) shouldBe 1
    }
}

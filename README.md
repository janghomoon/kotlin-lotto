# kotlin-lotto
## 문자열 덧셈 계산기
### 기능 요구사항
- 공백 문자열 또는 null이 입력될 경우 0을 반환한다.
- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열이 입력될 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
- 커스텀 구분자를 지정할 수 있다. 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
- 숫자 이외의 값 또는 음수가 입력될 경우 RuntimeException 예외를 던진다.

## 로또
### UseCase
로또 발급
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급한다.
- 구입된 로또 개수와 발급된 로또의 번호를 출력한다.

로또 추첨
- 지난주 당첨 번호를 입력하면 당첨 통계를 반환한다.
- 당첨 번호는 ,를 구분자로 입력한다.
- 당첨 번호를 입력받은 뒤 보너스 번호를 입력받는다.
- 등수별 당첨 결과와 총 수익률을 출력한다.

### Policy
로또
- 로또 1장의 가격은 1000원이다.
- 로또 1장이 가지고 있는 번호는 6개이다.
- 로또 번호는 1~45 사이의 숫자이고 중복될 수 없다.
- 로또 번호는 오름차순 정렬되어 있다.

당첨
- 등수별 당첨 금액은 다음과 같다.
  - 번호 3개 일치 - 5000원
  - 번호 4개 일치 - 50000원
  - 번호 5개 일치 - 1500000원
  - 번호 5개 일치, 보너스 번호 일치 - 30000000원
  - 번호 6개 일치 - 2000000000원

당첨 통계
- 당첨 통계에는 등수별 당첨 결과와 수익률이 포함된다.

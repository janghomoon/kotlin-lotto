# kotlin-lotto

# 문자열 덧셈 계산기 
- [X] 쉼표 또는 콜론이 포함된 문자열을 입력받는다.
- [X] 쉼표 또는 콜론으로 구분하여 숫자의 합을 반환한다.
- [X] 커스텀 문자열은  “//”와 “\n” 사이에 와야한다.
- [X] 문자열 계산기에 숫자외의 값이나 음수를 전달하면 RuntimeException이 발생한다.


# 로또(자동)
- [X] 로또 구입 금액을 입력 받는다.
- [X] 로또 1장의 가격은 1000원이고, 구입 금액에 대한 로또 갯수를 출력해준다.
- [X] 로또 1장을 1~45까지의 숫자를 셔플로 돌려 정렬해서 출력해준다.
- [X] 구매한 로또갯수 만큼 로또를 발급해준다.
- [X] 로또 당첨 번호는 ,를 구분해서 6개를 입력 받을 수 있다.
- [X] 구입한 로또 여러개 대해 당첨 번호가 몇개 포함되어있는지 체크한다.
- [X] 수익률을 계산 : 번돈에서 구매한 금액을 나눈 뒤 소숫점 2자리까지만 남긴다.


# 로또(2등)
- [X] 로또 안에 포함된 숫자를 관리하는 객체를 만든다. (LottoNumber)
  - [X] 로또 숫자는 1~45까지의 숫자이다.
  - [X] 로또는 중복되지 않은 숫자로 이루어져있다. 
- [X] 로또는 LottoNumber 여러개를 가지고 LottoNumberGenerator를 통해 만든다.
- [X] 로또 숫자를 원하는 수만큼 만들어내는 LottoNumberGenerator 객체가 있다. 
- [X] 구입한 금액만큼 로또를 발급해준다. (LottoMachine)
- [X] 당첨 통계에 2등도 추가한다.
- [X] 보너스 볼을 입력받는다. 

# 로또(수동)
- [X] 사용자가 원하는 만큼의 갯수를 수동으로 구매할 수 있다.
  - [X] 수동으로 구매한 갯수를 제외한 나머지 갯수는 자동으로 당첨번호를 부여한다.
- [X] 수동으로 구매하고자 하는 로또 갯수에 대해 당첨 번호를 직접 입력할 수 있다.

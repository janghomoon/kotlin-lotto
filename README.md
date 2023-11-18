# kotlin-lotto

## STEP1 (1단계 - 문자열 덧셈 계산기)
### 실습 환경 구축
[로또 저장소](https://github.com/next-step/kotlin-lotto)를 기반으로 미션을 진행한다. [온라인 코드 리뷰 요청 1단계 문서](https://github.com/next-step/nextstep-docs/blob/master/codereview/review-step1.md)를 참고해 실습 환경을 구축한다.
1. 미션 시작 버튼을 눌러 미션을 시작한다.
2. 저장소에 자신의 GitHub 아이디로 된 브랜치가 생성되었는지 확인한다.
3. 저장소를 자신의 계정으로 Fork 한다.


+ 코드리뷰 요청 1단계 [[동영상]](https://www.youtube.com/watch?v=YkgBUt7zG5k) [[문서]](https://github.com/next-step/nextstep-docs/blob/master/codereview/review-step1.md)
+ 코드리뷰 요청 2단계 [[동영상]](https://www.youtube.com/watch?v=HnTdFJd0PtU) [[문서]](https://github.com/next-step/nextstep-docs/blob/master/codereview/review-step2.md)
+ 코드리뷰 요청 3단계 [[동영상]](https://www.youtube.com/watch?v=fzrT3eoecUw) [[문서]](https://github.com/next-step/nextstep-docs/blob/master/codereview/review-step3.md)

### 문자열 덧셈 계산기
새로운 언어를 배워 써먹을 만큼 숙련도를 높이려면 많이 노력해야 한다. 코틀린을 처음 배웠는데 정확한 코틀린 문법이 기억나지 않는 경우 유용하게 써먹을 수 있다.

#### 기능 요구 사항
- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다.
- 입력받은 문자열이 null이거나 빈 문자열일 경우 0을 반환 한다.

#### 기능 목록
- [x] 계산기에 입력 받은 문자열이 빈 문자열이거나 null 일 경우 0을 반환한다.
  - (“”)으로 입력 받은 경우 0을 반환한다.
  - (null)으로 입력 받은 경우 0을 반환한다.
- [x] 계산기에 입력 받은 문자열은 구분자를 (“,”, “:”) 포함 할 수 있다.
  - 구분자가 없고 숫자 1개만 존재 할 경우 숫자 1개를 반환한다.
  - (“3”)으로 입력 받은 경우 3을 반환한다.
  - (“3:5,5”)으로 입력 받은 경우 13을 반환한다.
- [x] 계산기에 입력 받은 문자열 앞에 (“//”)가 존재 하는 경우 (“//”) 뒤에 오는 문자를 커스텀 구분자로 사용한다.
  - (“//\n3;3”)으로 입력 받은 경우 예외를 던진다.
  - (“//;\n3;3”)으로 입력 받은 경우 6을 반환한다. 
- [x] 계산기에 입력 받은 문자열에 구분자로 나눠진 항들은 숫자로만 이루어져야한다.
  - (“3:5,a”)으로 입력 받은 경우 예외를 던진다.
  - (“//;\n3;a”)으로 입력 받은 경우 예외를 던진다.
- [x] 계산기에 입력 받은 문자열에 구분자로 나눠진 항들은 0이상 100 이하의 정수여야한다. (임의로 지정)
  - (“300:5,5”)으로 입력 받은 경우 예외를 던진다.
  - (“100:5,5”)으로 입력 받은 경우 10을 반환한다.
  - (“-1:5,5”)으로 입력 받은 경우 예외를 던진다.
  - (“0:5,5”)으로 입력 받은 경우 10을 반환한다.

#### 프로그래밍 요구 사항
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다.
  - 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.


## STEP2 (2단계 - 로또(자동))
### 기능 요구사항
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.

### 기능 목록
- [x] 구입 금액은 0이상의 정수여야 하며, 1000으로 나누었을때 나머지가 0이여야한다.
  - 구입 금액에 빈문자열 입력시 예외(IllegalArgumentException)를 던진다.
  - 구입 금액에 `만원` 입력시 예외(IllegalArgumentException)를 던진다.
  - 구입 금액에 `0` 입력시 예외(IllegalArgumentException)를 던진다.
  - 구입 금액에 `900` 입력시 예외(IllegalArgumentException)를 던진다.
  - 구입 금액에 `1500` 입력시 예외(IllegalArgumentException)를 던진다.
  - 구입 금액에 `10001` 입력시 예외(IllegalArgumentException)를 던진다.
  - 구입 금액에 `1000` 입력시 구입금액이 `1000`원 이여야한다.
  - 구입 금액에 `23000` 입력시 구입금액이 `23000`원 이여야한다.
- [x] 로또 가격은 `1000~3000`원 사이의 정수여야 하며, `1000`으로 나누었을때 나머지가 `0`이 나와야 합니다
  - 로또 가격 생성시 `0`을 넣을 경우 예외(IllegalArgumentException)를 던진다.
  - 로또 가격 생성시 `900`을 넣을 경우 예외(IllegalArgumentException)를 던진다.
  - 로또 가격 생성시 `4000`을 넣을 경우 예외(IllegalArgumentException)를 던진다.
  - 로또 가격 생성시 `2300`을 넣을 경우 예외(IllegalArgumentException)를 던진다.
  - 로또 가격 생성시 `2001`을 넣을 경우 예외(IllegalArgumentException)를 던진다.
  - 로또 가격 생성시 `2000`을 넣을 경우 `2000`원을 가진 로또 가격이 생성된다.
  - 로또 가격 생성시 `1000`을 넣을 경우 `1000`원을 가진 로또 가격이 생성된다.
- [x] 로또 상금은 `0~2000000000`원 사이의 정수여야 합니다.
  - 로또 상금 생성시 `-100`을 넣을 경우 예외(IllegalArgumentException)를 던진다.
  - 로또 상금 생성시 `-4000`을 넣을 경우 예외(IllegalArgumentException)를 던진다.
  - 로또 상금 생성시 `-2300000`을 넣을 경우 예외(IllegalArgumentException)를 던진다.
  - 로또 상금 생성시 `2000000001`을 넣을 경우 예외(IllegalArgumentException)를 던진다.
  - 로또 상금 생성시 `2000000000`을 넣을 경우 `2000000000`원을 가진 로또 상금이 생성된다.
  - 로또 상금 생성시 `5000`을 넣을 경우 `5000`원을 가진 로또 상금이 생성된다.
- [x] 로또 번호는 `1~45`사이의 정수여야 합니다.
  - 로또 번호 생성시 `-1` 을 넣을 경우 예외(IllegalArgumentException)를 던진다.
  - 로또 번호 생성시 `0`을 넣을 경우 예외(IllegalArgumentException)를 던진다.
  - 로또 번호 생성시 `46`을 넣을 경우 예외(IllegalArgumentException)를 던진다.
  - 로또 번호 생성시 `6`을 넣을 경우 `6`을 가지고 있는 로또 번호 생성 되어야 한다.
  - 로또 번호 생성시 `1`을 넣을 경우 `1`을 가지고 있는 로또 번호 생성 되어야 한다.
  - 로또 번호 생성시 `45`을 넣을 경우 `45`을 가지고 있는 로또 번호 생성 되어야 한다.
- [x] 로또 번호 리스트는 비어 있거나, 중복될 수 없고, `1~45`사이의 정수로 구성된 6개의 숫자여야 한다.
  - 로또 번호 리스트 생성시 []을 넣을 경우 예외(IllegalArgumentException)를 던진다.
  - 로또 번호 리스트 생성시 [1, 2, 3, 4, 5, 5]을 넣을 경우 예외(IllegalArgumentException)를 던진다.
  - 로또 번호 리스트 생성시 [1, 2, 3, 4, 5, 6, 7]을 넣을 경우 예외(IllegalArgumentException)를 던진다.
  - 로또 번호 리스트 생성시 [0, 2, 3, 4, 5, 6]을 넣을 경우 예외(IllegalArgumentException)를 던진다.
  - 로또 번호 리스트 생성시 [41, 42, 43, 44, 45, 46]을 넣을 경우 예외(IllegalArgumentException)를 던진다.
  - 로또 번호 리스트 생성시 [1, 2, 3, 4, 5, 6]을 넣을 경우 [1, 2, 3, 4, 5, 6]을 가지고 있는 로또 번호 리스트가 생성 되어야 한다.
- [x] 로또 당첨 번호는 비어 있거나, 중복될 수 없고, `1~45`사이의 정수로 구성된 6개의 숫자여야 한다.
  - 로또 당첨 번호 리스트 생성시 []을 넣을 경우 예외(IllegalArgumentException)를 던진다.
  - 로또 당첨 번호 리스트 생성시 [1, 2, 3, 4, 5]을 넣을 경우 예외(IllegalArgumentException)를 던진다.
  - 로또 당첨 번호 리스트 생성시 [1, 2, 3, 4, 5, 5]을 넣을 경우 예외(IllegalArgumentException)를 던진다.
  - 로또 당첨 번호 리스트 생성시 [1, 2, 3, 4, 5, 6, 7]을 넣을 경우 예외(IllegalArgumentException)를 던진다.
  - 로또 당첨 번호 리스트 생성시 [0, 1, 2, 3, 4, 5]을 넣을 경우 예외(IllegalArgumentException)를 던진다.
  - 로또 당첨 번호 리스트 생성시 [41, 42, 43, 44, 45, 46]을 넣을 경우 예외(IllegalArgumentException)를 던진다.
  - 로또 당첨 번호 리스트 생성시 [1, 2, 3, 4, 5, 6]을 넣을 경우 지난 주 당첨 로또 번호 리스트에 [1, 2, 3, 4, 5, 6]이 저장 되어야 한다.
- [x] 로또 번호 맞춘 횟수는 `0~6`사이의 정수만 들어올 수 있다.
  - 로또 번호 맞춘 횟수 생성시 `-100`을 넣을 경우 예외(IllegalArgumentException)를 던진다.
  - 로또 번호 맞춘 횟수 생성시 `-1`을 넣을 경우 예외(IllegalArgumentException)를 던진다.
  - 로또 번호 맞춘 횟수 생성시 `7`을 넣을 경우 예외(IllegalArgumentException)를 던진다.
  - 로또 번호 맞춘 횟수 생성시 `1`을 넣을 경우 `1`을 가지고 있는 로또 번호 맞춘 횟수가 생성 되어야 한다.
  - 로또 번호 맞춘 횟수 생성시 `3`을 넣을 경우 `3`을 가지고 있는 로또 번호 맞춘 횟수가 생성 되어야 한다.
  - 로또 번호 맞춘 횟수 생성시 `6`을 넣을 경우 `6`을 가지고 있는 로또 번호 맞춘 횟수가 생성 되어야 한다.
- [x] 당첨된 로또 티켓 카운트는 `0`보다 많은 정수만 들어올 수 있다.
  - 당첨된 로또 티켓 카운트 생성시 '-1000'을 입력할 경우 예외(IllegalArgumentException)를 던진다.
  - 당첨된 로또 티켓 카운트 생성시 '-100'을 입력할 경우 예외(IllegalArgumentException)를 던진다.
  - 당첨된 로또 티켓 카운트 생성시 '-10'을 입력할 경우 예외(IllegalArgumentException)를 던진다.
  - 당첨된 로또 티켓 카운트 생성시 '-1'을 입력할 경우 예외(IllegalArgumentException)를 던진다.
  - 당첨된 로또 티켓 카운트 생성시 `3`을 입력할 경우 `3`개의 횟수를 가진 당첨 로또 티켓 카운트가 생성되어야 한다.
  - 당첨된 로또 티켓 카운트 생성시 `100`을 입력할 경우 `100`개의 횟수를 가진 당첨 로또 티켓 카운트가 생성되어야 한다.
- [x] 수익률은 `0.0`보다 낮은 실수가 들어올 수 없다.
  - 수익률 생성시 `-1.0`을 입력할 경우 예외(IllegalArgumentException)를 던진다.
  - 수익률 생성시 `-10.0`을 입력할 경우 예외(IllegalArgumentException)를 던진다.
  - 수익률 생성시 `100.0` 입력시 `100.0`을 가진 수익률이 생성 되어야한다.
  - 수익률 생성시 `100000.0` 입력시 `100000.0`을 가진 수익률이 생성 되어야한다.

### 프로그래밍 요구 사항
- 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
  - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
  - UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
  - 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
- 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
- git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.

### 힌트
- 로또 자동 생성은 shuffled()을 활용한다.
- sorted()를 활용해 정렬 가능하다.
- contains()를 활용하면 어떤 값이 존재하는지 유무를 판단할 수 있다.

### 실행 결과

구입금액을 입력해 주세요.<br/>
 14000<br/>
 14개를 구매했습니다.<br/>
 [8, 21, 23, 41, 42, 43]<br/>
 [3, 5, 11, 16, 32, 38]<br/>
 [7, 11, 16, 35, 36, 44]<br/>
 [1, 8, 11, 31, 41, 42]<br/>
 [13, 14, 16, 38, 42, 45]<br/>
 [7, 11, 30, 40, 42, 43]<br/>
 [2, 13, 22, 32, 38, 45]<br/>
 [23, 25, 33, 36, 39, 41]<br/>
 [1, 3, 5, 14, 22, 45]<br/>
 [5, 9, 38, 41, 43, 44]<br/>
 [2, 8, 9, 18, 19, 21]<br/>
 [13, 14, 18, 21, 23, 35]<br/>
 [17, 21, 29, 37, 42, 45]<br/>
 [3, 8, 27, 30, 35, 44]<br/>

지난 주 당첨 번호를 입력해 주세요.<br/>
 1, 2, 3, 4, 5, 6<br/>

당첨 통계<br/>
 ---------<br/>
 3개 일치 (5000원)- 1개<br/>
 4개 일치 (50000원)- 0개<br/>
 5개 일치 (1500000원)- 0개<br/>
 6개 일치 (2000000000원)- 0개<br/>
 총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)<br/>

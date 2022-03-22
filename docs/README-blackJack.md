## 기능 요구사항

- 게임에 참여할 사람의 이름을 입력받는다.
  - 이름은 `,`기준으로 분리한다.
  - 중복된 이름이 있을 경우 예외를 발생시킨다.
  - 이름이 공백일 경우 예외를 발생시킨다.
  - 플레이어의 이름은 `딜러`가 될 수 없다.
  - 플레이어 수가 `1`명 이상 `7`명 이하여야 한다.
  

- 각 플레이어들의 배팅 금액을 입력받는다.
  - 배팅 금액이 `자연수`가 아닐 경우 예외를 발생시킨다.


- 카드 명세
  - 카드 숫자는 `2`부터 `10`까지 존재한다.
  - `King`, `Queen`, `Jack`은 카드 숫자 `10`으로 간주한다.
  - `Ace`는 카드 숫자 `1` 또는 `11`로 간주한다.
  

- 딜러와 플레이어들에게 두 장씩 카드를 `랜덤`으로 나눈다.
    - 카드를 중복해서 나누어줄 수 없다.


- 플레이어 카드 나누기
  - 플레이어가 받은 카드의 합계가 `21`이하일 경우 카드를 추가로 받을지 선택할 수 있다.
  - 플레이어가 카드를 추가로 받지 않는 경우, 다음 플레이어 차례를 진행한다.


- 딜러 카드 나누기
  - 처음에 받은 2장의 합계가 `16`이하이면 반드시 1장의 카드를 추가로 받아야 한다. 
  - 카드의 합계가 `17`이상이면 추가로 받을 수 없다.
  
    
- 결과 판단
  - 블랙잭
    - 처음 두 장의 카드 합이 21일 경우 블랙잭이다.
    - 둘 중 한명이 블랙잭인 경우, 블랙잭인 참가자가 승리하고 `배팅 금액의 1.5배`를 얻는다.
    - 플레이어와 딜러 모두 블랙잭일 경우 무승부이며, 수익을 얻지 않는다.
  - 버스트
    - 카드 합이 21을 초과할 경우 버스트이다.
    - 플레이어가 버스트이면 **딜러의 결과에 관계없이** 플레이어가 패배하고 `배팅 금액`만큼 잃는다.
  - 딜러보다 **플레이어의 카드 합계가 클 경우** 플레이어가 승리하고 `배팅 금액`만큼 얻는다.
  - 딜러보다 **플레이어의 카드 합계가 작을 경우** 플레이어가 패배하고 `배팅 금액`만큼 잃는다.
  - 딜러와 **플레이어의 카드 합계가 같을 경우** 무승부로 처리하고 수익을 얻지 않는다.


- 결과 출력
  - 딜러와 플레이어가 가진 `카드의 종류`와 `카드의 합계`를 출력한다.
  - 참가자들의 `승무패`를 출력한다.
  - 참가자들의 `최종 수익`을 출력한다.
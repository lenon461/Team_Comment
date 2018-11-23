/*
 * 유리수 클래스 Fraction 을 작성하라. Fraction 객체는 유리수 값을 가지고 있어야 한다.
(힌트: 유리수는 정수 두개로 표현 가능: 분자(numerator)와 분모(denominator))

생성자

public Fraction(int numerator, int denominator)
다음과 같은 메소드를 통해 객체의 값을 변경할 수 있어야 함.

public Fraction add(Fraction i): 자기와 유리수 i를 더한 유리수 객체를 반환

public Fraction add(int i): 자기와 정수 i를 더한 유리수 객체를 반환

public Fraction negate(): 자기와 부호가 다른 유리수 객체를 반환

public Fraction inverse(): 자기의 역수인 유리수 객체를 반환

public Fraction multiply(Fraction i): 자기에 유리수 i를 곱한 객체를 반환

public Fraction multiply(int i): 자기에 정수 i를 곱한 객체를 반환

public String toString(): 자기를 문자열로 변환해서 반환. 예, "3/5".

public void setNumerator(int numIn): 분자 수정

public void setDenominator(int numIn): 분모 수정

다음과 같은 메소드를 통해 객체의 값을 열람할 수 있어야 함.

public int getNumerator(): 분자 반환

public int getDenominator(): 분모 반환

결과물 유리수는 약분이 가능할 경우 항상 약분이 되어야 한다. 즉 기약분수 형태로 결과물이 나와야 한다. (예: 4/6 은 2/3 으로 출력되어야 함) 이를 위해 이미 정의된 findGCD 함수를 사용한다.

바람직한 입출력 예제는 다음과 같다:

Fraction f1 = new Fraction(3,6);
System.out.println(f1.toString()); // "1/2" 출력
System.out.println(f1.multiply(2)); // "1/1" 출력
Fraction f2 = new Fraction(2,6);
System.out.println(f1.add(f2)); // "5/6" 출력
System.out.println(f2.negate()); // "-1/3" 출력
System.out.println(f2.inverse()); // "3/1" 출력
System.out.println(f1.multiply(f2)); // "1/6" 출력

다음의 코드의 빈 부분을 채우면 된다.
 * */

public class Fraction {
  // fill here: define member variables 
	private int numerator, denominator;
  /** Java method to find GCD of two number using Euclid's method 
    * @return GDC of two numbers in Java */  
  private static int findGCD(int number1, int number2) { 
    //base case 
    if(number2 == 0) { 
      return number1; 
    } 
    return findGCD(number2, number1 % number2); 
  }

  public Fraction(int numerator, int denominator) {
	  int GCD = findGCD(numerator, denominator);
      this.numerator = numerator / GCD;
      this.denominator = denominator / GCD;
  }

//자기와 유리수 i를 더한 유리수 객체를 반환
  public Fraction add(Fraction i) {
      // 분자 중간 결과 = (this.분자 * i.분모) + (i.분자 * this.분모)
      int result_num = (this.numerator * i.getDenominator()) + (i.getNumerator() * this.denominator);
      // 분모 중간 결과 = this.분모 * i.분모
      int result_denom = this.denominator * i.getDenominator();
      return new Fraction (result_num, result_denom);
  }

//자기와 정수 i를 더한 유리수 객체를 반환
  public Fraction add(int i) {
      // 분자 중간 결과 = this.분자 + i * this.분모
      int result_num = this.numerator + i * this.denominator;
      return new Fraction(result_num, this.denominator);
  }

  // 부호 다르게
  public Fraction negate() {
      return new Fraction (-this.numerator, this.denominator);
  }

  // 역수
  public Fraction inverse() {
      return new Fraction (this.denominator, this.numerator);
  }

  // 유리수 곱
  public Fraction multiply(Fraction i) {
      // 분자 중간 결과 = this.분자 * i.분자
      int result_num = this.numerator * i.getNumerator();
      // 분모 중간 결과 = this.분모 * i.분모
      int result_denom = this.denominator * i.getDenominator();
      return new Fraction (result_num, result_denom);
  }

  // 정수 곱
  public Fraction multiply(int i) {
      // 분자 중간 결과 = this.분자 * i
      return new Fraction (this.numerator * i, this.denominator);
  }

  // 문자열 반환
  public String toString() {
      return this.numerator + "/" + this.denominator;
  }

  // 분자 수정
  public void setNumerator(int numIn) {
      this.numerator = numIn;
  }

  // 분모 수정
  public void setDenominator(int numIn) {
      this.denominator = numIn;
  }

  // 분자 반환
  public int getNumerator() {
      return this.numerator;
  }

  // 분모 반환
  public int getDenominator() {
      return this.denominator;
  }

}
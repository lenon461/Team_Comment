// 다음 원뿔의 클래스를 정의하고 부피와 표면적을 계산하는 프로그램을 작성하라.

/*
 * 원뿔의 부피(volume)와 표면적(area)을 계산하는 공식은 다음과 같다:
volume=13πr2h

area=πrr2+h2−−−−−−√+πr2

여기서 r 은 원뿔 밑의 원의 반지름, h 는 원뿔의 높이를 의미한다. 
π 는 이미 정의된 상수 PI를 사용한다.

바람직한 입출력 예제는 다음과 같다:

Cone c = new Cone(7.3, 12.1);
System.out.println(c.getVolume()) // 674.9000866666667 출력 
System.out.println(c.getArea()) // 491.2534170024458 출력

필요한 함수는 https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html 에서 찾아서 쓰도록 한다.

 * */
public class Cone {
  private static double PI = 3.14; 
  private double radius;  // 원뿔 밑의 원의 반지름  
  private double height;  // 원뿔의 높이 
  public Cone(double radius, double height) {
    // fill here 
	  this.radius = radius;
	  this.height = height;
  }
  public double getVolume() {
	  double volume = (PI * radius * radius * height)/3; 
	return volume;  // 현재 원뿔의 부피 반환 
    // fill here
  }
  public double getArea() {  // 현재 원뿔의 표면적 반환 
    return (PI * radius * radius) + PI * radius * Math.sqrt(radius* radius + height * height);
  }
//  public static void main(String[] args){
//	  Cone c = new Cone(7.3, 12.1);
//	  System.out.println(c.getVolume()); // 674.9000866666667 출력 
//	  System.out.println(c.getArea()); // 491.2534170024458 출력
// }
}
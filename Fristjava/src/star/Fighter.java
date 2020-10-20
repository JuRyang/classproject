package star;

public class Fighter extends Unit implements Fightable {
	
	@Override
	public void move() {
		System.out.println("이동합니다.");
		x+=10;
		y+=10;
	}
	
	
	@Override
	public void attack() {
		System.out.println("공격합니다.");
		hp-=10;
	}
}

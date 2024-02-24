package level1;

public class Bandaging {

	static class Monster {

		int health;
		int successTime;

		public Monster(int health) {
			this.health = health;
			this.successTime = 0;
		}

		public void applyDamage(int damage) {
			health -= damage;
			successTime = 0;
		}

		public void recover(int recovery, int successRecovery, int time, int maxHealth) {
			health = Math.min(health + recovery, maxHealth);
			successTime++;
			if (successTime == time) {
				health = Math.min(health + successRecovery, maxHealth);
				successTime = 0;
			}
		}
	}

	public int solution(int[] bandage, int health, int[][] attacks) {
		Monster monster = new Monster(health);

		int time = bandage[0];
		int recovery = bandage[1];
		int successRecovery = bandage[2];

		int idx = 0;
		for (int i = 1; i <= attacks[attacks.length - 1][0]; i++) {
			if (monster.health <= 0) {
				return -1;
			}
			if (attacks[idx][0] == i) {
				monster.applyDamage(attacks[idx][1]);
				idx++;
				continue;
			}
			monster.recover(recovery, successRecovery, time, health);
		}

		return monster.health > 0 ? monster.health : -1;
	}
}


public class Game {
	private float playAreaHeight;
	private float playAreaWidth;
	private int score;
	private float enemySpawnTime;
	private float enemySpawnTimer;
	private boolean isPaused;
	
	public Game(float height, float width, float spawnTime) {
		playAreaHeight = height;
		playAreaWidth = width;
		score = 0;
		enemySpawnTime = spawnTime;
		enemySpawnTimer = 0;
		isPaused = false;
	}
	
	private void SpawnRandomEnemy() {
		
	}
	private void SpawnRandomObjective() {
		
	}
	private void SpawnBullet(float x, float y, float th) {
		
	}
	public void GameLoop() {
		
	}
	private void MoveGameObjects() {
		
	}
	private void CheckPlayerObjectiveCollision() {
		
	}
	private void CheckForKillingCollisions() {
		
	}
	private void RemoveDeadObjects() {
		
	}
	public boolean CheckMoveAgainstEdges(float x, float y, float scale) {
		return true;
	}
	public boolean CheckMoveAgainstWalls(float x, float y, float scale) {
		return true;
	}
	private void Pause() {
		
	}
	private void GameOver() {
		
	}
	
}

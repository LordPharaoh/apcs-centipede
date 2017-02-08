# Plan for implementation
## Interfaces
MovingObject = move, detectCollision, getBoundingRect
- Mushroom
	- Health
- Player
	- Shoot
- Centipede
- Spider
- Bullet

OtherThings
- Score
- Lives
- Timer
- High score

## Collisions
| Primary Object | Secondary Object | Behavior |
| -------------- | ---------------- | -------- |
| Spider         | Mushroom         | nothing  |
| Spider         | Player           | delete |
| Spider | Bullet | delete |
| Spider | Cent | nothing |
| Mushroom | Spider | delete |
| Mushroom | Player | nothing |
| Mushroom | Cent | nothing |
| Mushroom | Bullet | -health |
| Cent | Spider | nothing |
| Cent | Player | nothing | 
| Cent | Mushroom | bounce |
| Cent | Bullet | delete, makeShroom |
| Player | Spider | nextHealth |
| Player | Mushroom | block |
| Player | Cent | nextHealth |
| Bullet | ALL | delete | 

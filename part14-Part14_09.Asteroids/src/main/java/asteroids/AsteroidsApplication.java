package asteroids;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AsteroidsApplication extends Application {
    public static final int WIDTH = 300;
    public static final int HEIGHT = 200;
    
    private Pane pane;
    private Ship ship;
    private List<Asteroid> asteroids;
    private List<Projectile> projectiles;
    private Map<KeyCode, Boolean> pressedKeys;
    private AtomicInteger points;
    private Text pointsDisplay;
    private boolean spacePressed;
    
    @Override
    public void start(Stage stage) {
        initializeGame(stage);
        startGameLoop();
    }
    
    private void initializeGame(Stage stage) {
        this.pane = new Pane();
        this.pane.setPrefSize(WIDTH, HEIGHT);
        
        this.points = new AtomicInteger();
        this.pointsDisplay = new Text(10, 20, "Points: 0");
        this.pane.getChildren().add(pointsDisplay);
        
        this.ship = new Ship(WIDTH / 2, HEIGHT / 2);
        this.asteroids = new ArrayList<>();
        this.projectiles = new ArrayList<>();
        this.pressedKeys = new HashMap<>();        
        this.spacePressed = false;
        
        // Initial asteroids
        for (int i = 0; i < 5; i++) {
            Asteroid asteroid = new Asteroid(new Random().nextInt(WIDTH / 3), new Random().nextInt(HEIGHT / 2));
            asteroids.add(asteroid);
            pane.getChildren().add(asteroid.getCharacter());
        }
        
        pane.getChildren().add(ship.getCharacter());
        
        Scene scene = new Scene(pane);
        scene.setOnKeyPressed(event -> pressedKeys.put(event.getCode(), true));
        scene.setOnKeyReleased(event -> pressedKeys.put(event.getCode(), false));
        
        stage.setTitle("Asteroids!");
        stage.setScene(scene);
        stage.show();
    }
    
    private void startGameLoop() {
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                processInput();
                updateGameObjects();
                checkCollisions();
                spawnAsteroids();
                removeDestroyedObjects();
            }
        }.start();
    }
    
    private void processInput() {
        if (pressedKeys.getOrDefault(KeyCode.LEFT, false)) ship.turnLeft();
        if (pressedKeys.getOrDefault(KeyCode.RIGHT, false)) ship.turnRight();
        if (pressedKeys.getOrDefault(KeyCode.UP, false)) ship.accelerate();       
        if (pressedKeys.getOrDefault(KeyCode.SPACE, false)) {
            if (!spacePressed) {
                shoot();
                spacePressed = true;
            }
        } else {
            spacePressed = false;
        }
    }
    
    private void shoot() {
        Projectile projectile = new Projectile((int) ship.getCharacter().getTranslateX(), (int) ship.getCharacter().getTranslateY());
        projectile.getCharacter().setRotate(ship.getCharacter().getRotate());
        projectiles.add(projectile);
        
        projectile.accelerate();
        projectile.setMovement(projectile.getMovement().normalize().multiply(3));
        
        pane.getChildren().add(projectile.getCharacter());
    }
    
    private void updateGameObjects() {
        ship.move();
        asteroids.forEach(Asteroid::move);
        projectiles.forEach(Projectile::move);
    }
    
    private void checkCollisions() {
        asteroids.forEach(asteroid -> {
            if (ship.collide(asteroid)) gameOver();
        });
        
        projectiles.forEach(projectile -> {
            asteroids.stream()
                .filter(asteroid -> projectile.collide(asteroid))
                .forEach(asteroid -> {
                    projectile.setAlive(false);
                    asteroid.setAlive(false);
                });
            
            if (!projectile.isAlive()) {
                pointsDisplay.setText("Points: " + points.addAndGet(1));
            }
        });
    }
    
    private void spawnAsteroids() {
        if (Math.random() < 0.005) {
            Asteroid asteroid = new Asteroid(WIDTH, HEIGHT);
            if (!asteroid.collide(ship)) {
                asteroids.add(asteroid);
                pane.getChildren().add(asteroid.getCharacter());
            }
        }
    }
    
    private void removeDestroyedObjects() {
        projectiles.removeIf(projectile -> {
            if (!projectile.isAlive()) {
                pane.getChildren().remove(projectile.getCharacter());
                return true;
            }
            return false;
        });
        
        asteroids.removeIf(asteroid -> {
            if (!asteroid.isAlive()) {
                pane.getChildren().remove(asteroid.getCharacter());
                return true;
            }
            return false;
        });
    }
    
    private void gameOver() {
        pane.getChildren().remove(ship.getCharacter());
        
        Text gameOverText = new Text("Game Over");
        gameOverText.setFont(Font.font("Arial", FontWeight.BOLD, 20));

        Button restartButton = new Button("Restart");
        restartButton.setOnAction(e -> initializeGame((Stage) pane.getScene().getWindow())); 

        VBox gameOverBox = new VBox(10, gameOverText, restartButton);
        gameOverBox.setAlignment(Pos.CENTER);

        gameOverBox.setLayoutX(WIDTH / 2 - 50);
        gameOverBox.setLayoutY(HEIGHT / 2 - 30);

        pane.getChildren().add(gameOverBox);
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static int partsCompleted() {
        // State how many parts you have completed using the return value of this method
        return 4;
    }
}


/*
//
// ~~~~~~~ Legacy code:
//

package asteroids;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AsteroidsApplication extends Application {
    public static int WIDTH = 300;
    public static int HEIGHT = 200;   
    
    @Override
    public void start(Stage stage) throws Exception {
        Pane pane = new Pane();
        pane.setPrefSize(WIDTH, HEIGHT);
        
        Text pointsDisplay = new Text(10, 20, "Points: 0");
        AtomicInteger points = new AtomicInteger();
        pane.getChildren().add(pointsDisplay);

        Ship ship = new Ship(WIDTH / 2, HEIGHT / 2);
        
        List<Asteroid> asteroids = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Random rnd = new Random();
            Asteroid asteroid = new Asteroid(rnd.nextInt(WIDTH / 3), rnd.nextInt(HEIGHT / 2));
            asteroids.add(asteroid);
        }
        
        pane.getChildren().add(ship.getCharacter());   
        asteroids.forEach(asteroid -> 
                pane.getChildren().add(asteroid.getCharacter()));
        
        Scene scene = new Scene(pane);
        
        Map<KeyCode, Boolean> pressedKeys = new HashMap<>();
        
        scene.setOnKeyPressed(event -> {
            pressedKeys.put(event.getCode(), Boolean.TRUE);
        });

        scene.setOnKeyReleased(event -> {
            pressedKeys.put(event.getCode(), Boolean.FALSE);
        });

        List<Projectile> projectiles = new ArrayList<>();
        
        new AnimationTimer() {

            @Override
            public void handle(long now) {
                if(pressedKeys.getOrDefault(KeyCode.LEFT, false)) {
                    ship.turnLeft();
                }

                if(pressedKeys.getOrDefault(KeyCode.RIGHT, false)) {
                    ship.turnRight();
                }
                
                if(pressedKeys.getOrDefault(KeyCode.UP, false)) {
                    ship.accelerate();
                }
                
                if (pressedKeys.getOrDefault(KeyCode.SPACE, false)) {
                    // we shoot
                    Projectile projectile = new Projectile((int) ship.getCharacter().getTranslateX(), (int) ship.getCharacter().getTranslateY());
                    projectile.getCharacter().setRotate(ship.getCharacter().getRotate());
                    projectiles.add(projectile);

                    projectile.accelerate();
                    projectile.setMovement(projectile.getMovement().normalize().multiply(3));

                    pane.getChildren().add(projectile.getCharacter());
                }

                ship.move();
                asteroids.forEach(asteroid -> asteroid.move());
                projectiles.forEach(projectile -> projectile.move());
                
                asteroids.forEach(asteroid -> {
                    if (ship.collide(asteroid)) {
                        stop();
                    }
                });
                
                if(Math.random() < 0.005) {
                    Asteroid asteroid = new Asteroid(WIDTH, HEIGHT);
                    if(!asteroid.collide(ship)) {
                        asteroids.add(asteroid);
                        pane.getChildren().add(asteroid.getCharacter());
                    }
                }
                
                List<Projectile> projectilesToRemove = projectiles.stream().filter(projectile -> {
                    List<Asteroid> collisions = asteroids.stream()
                            .filter(asteroid -> asteroid.collide(projectile))
                            .collect(Collectors.toList());

                    if(collisions.isEmpty()) {
                        return false;
                    }
                    
                    collisions.stream().forEach(collided -> {
                        asteroids.remove(collided);
                        pane.getChildren().remove(collided.getCharacter());
                    });                   
                    return true;
                }).collect(Collectors.toList());
                
                projectilesToRemove.forEach(projectile -> {
                    pane.getChildren().remove(projectile.getCharacter());
                    projectiles.remove(projectile);
                });
                
                projectiles.forEach(projectile -> {
                    asteroids.forEach(asteroid -> {
                        if(projectile.collide(asteroid)) {
                            projectile.setAlive(false);
                            asteroid.setAlive(false);
                        }
                    });
                    
                    if (!projectile.isAlive()) {
                        pointsDisplay.setText("Points: " + points.addAndGet(1));
                    }
                });

                projectiles.stream()
                    .filter(projectile -> !projectile.isAlive())
                    .forEach(projectile -> pane.getChildren().remove(projectile.getCharacter()));
                projectiles.removeAll(projectiles.stream()
                                        .filter(projectile -> !projectile.isAlive())
                                        .collect(Collectors.toList()));

                asteroids.stream()
                        .filter(asteroid -> !asteroid.isAlive())
                        .forEach(asteroid -> pane.getChildren().remove(asteroid.getCharacter()));
                asteroids.removeAll(asteroids.stream()
                                            .filter(asteroid -> !asteroid.isAlive())
                                            .collect(Collectors.toList()));
            }
        }.start();
        
        stage.setTitle("Asteroids!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static int partsCompleted() {
        // State how many parts you have completed using the return value of this method
        return 0;
    }
}

*/


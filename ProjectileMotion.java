import java.util.Scanner;

public class ProjectileMotion {

    // Acceleration due to gravity (m/s^2)


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final double GRAVITY = 9.8;
        double initialVelocity = 12; // m/s
        double angleDegrees = 70; // deg
        double initialHeight = 15; // m

        // Convert angle to radians
        double angleRadians = Math.toRadians(angleDegrees);

        // Calculate horizontal and vertical velocities
        double velocityX = initialVelocity * Math.cos(angleRadians);
        double velocityY = initialVelocity * Math.sin(angleRadians);


        // Time to reach the maximum height
        double timeToMaxHeight = velocityY / GRAVITY;
        // Maximum height
        double maxHeight = initialHeight + (velocityY * timeToMaxHeight) - (0.5 * GRAVITY * Math.pow(timeToMaxHeight, 2));


        // Total flight time (quadratic equation to include initial height)
        double totalTime = (velocityY + Math.sqrt(Math.pow(velocityY, 2) + 2 * GRAVITY * initialHeight)) / GRAVITY;



        // Range (horizontal distance)
        double range = velocityX * totalTime;

        // Print results
        System.out.printf("\n--- Projectile Motion Results ---\n");
        System.out.printf("Maximum Height: %.2f meters\n", maxHeight);
        System.out.printf("Total Flight Time: %.2f seconds\n", totalTime);
        System.out.printf("Range (Horizontal Distance): %.2f meters\n", range);

        System.out.println("\nPosition of the ball at different times:");
        for (double t = 0; t <= totalTime; t += 0.1) {
            double x = velocityX * t;
            double y = initialHeight + (velocityY * t) - (0.5 * GRAVITY * Math.pow(t, 2));
            if (y < 0) y = 0; // Ball hits the ground
            System.out.printf("Time: %.2f sec -> X: %.2f m, Y: %.2f m\n", t, x, y);
            if (y == 0) break; // Stop printing when the ball hits the ground
        }

        scanner.close();
    }
}

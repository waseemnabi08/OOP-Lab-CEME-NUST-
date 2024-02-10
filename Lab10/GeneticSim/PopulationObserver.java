import java.util.List;

public class PopulationObserver {
    // Function to track the population
    public void trackPopulation(List<Organism> organisms) {
        System.out.println("Tracking Population:");
        for (Organism organism : organisms) {
            System.out.println("Organism: " + organism.getName() +
                    " | Age: " + organism.getAge() +
                    " | Health: " + organism.getHealth() +
                    " | Max Health: " + organism.getMaxHealth());
        }
        System.out.println("---------------------------");
    }

    // Function to analyze the evolution of the population
   public void analyzeEvolution(List<Organism> organisms) {
        System.out.println("Analyzing Evolution:");

        // Calculate and print average age and health of the population
        int totalAge = 0;
        int totalHealth = 0;

        for (Organism organism : organisms) {
            totalAge += organism.getAge();
            totalHealth += organism.getHealth();
        }

        int averageAge = totalAge / organisms.size();
        int averageHealth = totalHealth / organisms.size();

        System.out.println("Average Age: " + averageAge);
        System.out.println("Average Health: " + averageHealth);
        System.out.println("---------------------------");
    }
}

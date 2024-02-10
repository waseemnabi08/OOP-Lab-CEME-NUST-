import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main{
    public static void main(String[] args) {
        
        Graph graph = new Graph();
        TaskEngine taskEngine = new TaskEngine();
        Airplane airplane = new Airplane("VN-A123", "A", "F", graph);
        Airplane airplane2 = new Airplane("XY-23", "B", "E", graph);
        Gate gate = new Gate("GATE-1", GateState.EMPTY);
        Runway runway = new Runway("RUNWAY-1",20);
        Taxiway taxiway = new Taxiway("TAXIWAY-1", 25);
        List<Gate> gates = new ArrayList<>();
        List<Runway> runways = new ArrayList<>();
        List<Taxiway> taxiways = new ArrayList<>();
        gates.add(gate);
        runways.add(runway);
        taxiways.add(taxiway);
        AirportGroundNetwork network = new AirportGroundNetwork(gates, runways, taxiways);

        Map<String, Object> supplementalData = new HashMap<>();
        supplementalData.put("airplane", airplane);
        supplementalData.put("taxiway", taxiway);
        supplementalData.put("airplane2", airplane2);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addEdge("A", "B", 4);
        graph.addEdge("A", "C", 2);
        graph.addEdge("B", "C", 1);
        graph.addEdge("B", "D", 5);
        graph.addEdge("C", "D", 8);
        graph.addEdge("C", "E", 10);
        graph.addEdge("D", "E", 2);
        graph.addEdge("D", "F", 6);
        graph.addEdge("E", "F", 3);
        
        supplementalData.put("graph", graph);
        Task task1 = new Task("TASK-1", 5, 0,  ActionType.MOVE, network, graph);
        Task task2 = new Task("TASK-2", 2, 0,  ActionType.HOLD, network, graph);
        Task task3 = new Task("TASK-3", 3, 0,  ActionType.PARK, network, graph);
        Task task4 = new Task("TASK-4", 5, 0,  ActionType.MOVE, network, graph);
        taskEngine.addTask(task1);
        taskEngine.addTask(task2);
        taskEngine.addTask(task3);
        taskEngine.addTask(task4);

        
        taskEngine.dispatchTask(airplane, network);
        taskEngine.dispatchTask(airplane, network);
        taskEngine.dispatchTask(airplane, network);
       taskEngine.dispatchTask(airplane2, network); 
        

    }
}

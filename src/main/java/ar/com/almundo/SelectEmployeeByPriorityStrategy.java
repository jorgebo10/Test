package ar.com.almundo;

import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public final class SelectEmployeeByPriorityStrategy implements SelectEmployeeStrategy {
    private final Queue<Employee> availableEmployeesQueue;

    public SelectEmployeeByPriorityStrategy(final Queue<Employee> employees) {
        this.availableEmployeesQueue = new PriorityBlockingQueue<>(employees);
    }

    @Override
    public Optional<Employee> getNextSelectableEmployee() {
            return Optional.ofNullable(this.availableEmployeesQueue.poll());
        }

    @Override
    public void addSelectableEmployee(final Employee employee) {
        availableEmployeesQueue.add(employee);
    }
}

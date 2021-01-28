package _1_;


import javax.persistence.*;
import java.util.HashSet;
import java.util.List;

@Entity(name = "projects")
public class Project extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private int budget;
    @ManyToMany
    private List<Employee> employeeList;

    public Project() {
    }

    public Project(String name, int budget) {
        this.name = name;
        this.budget = budget;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", budget=" + budget +
                ", employeeList=" + employeeList +
                '}';
    }
}

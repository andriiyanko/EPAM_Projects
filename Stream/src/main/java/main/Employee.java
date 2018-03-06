package main;

public class Employee {
    private String name;

    private String nativeCity;

    private int age;

    private int workExperience;

    private Position position;

    public Employee(String name, String nativeCity, int age, int workExperience, Position position) {
        this.name = name;
        this.nativeCity = nativeCity;
        this.age = age;
        this.workExperience = workExperience;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getNativeCity() {
        return nativeCity;
    }

    public int getAge() {
        return age;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", surName=" + nativeCity + ", age=" + age + ", workExperience=" + workExperience
                + ", position=" + position + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((nativeCity == null) ? 0 : nativeCity.hashCode());
        result = prime * result + ((position == null) ? 0 : position.hashCode());
        result = prime * result + workExperience;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (age != other.age)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (nativeCity == null) {
            if (other.nativeCity != null)
                return false;
        } else if (!nativeCity.equals(other.nativeCity))
            return false;
        if (position != other.position)
            return false;
        if (workExperience != other.workExperience)
            return false;
        return true;
    }
}

package app;

public class Student {
    private String name;
    private String id;
    private String department;
    private double cgpa;
    private static int counter = 2340;

    public Student(String name, String department, double cgpa) {
        this.name = name;
        this.department = department;
        setCgpa(cgpa);
        id = getId();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return String.format("%s%d",name.substring(0,2).toLowerCase(),counter++);
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        if (cgpa >= 0 && cgpa <=4 )
            this.cgpa = cgpa;
        else this.cgpa = 0;
    }

    @Override
    public String toString() {
        return String.format("%s\t%s\t%s\t%.1f\n",id,name,department,cgpa);
    }
}

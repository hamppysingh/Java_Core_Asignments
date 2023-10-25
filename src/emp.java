class Emp {
    private int id;
    private String name;
    private int deptId;
    protected double basicSalary;

    public Emp(int id, String name, int deptId, double basicSalary) {
        this.id = id;
        this.name = name;
        this.deptId = deptId;
        this.basicSalary = basicSalary;
    }

    @Override
    public String toString() {
        return "Emp ID: " + id + ", Name: " + name + ", Dept ID: " + deptId;
    }

    public double computeNetSalary() {
        return 0;
    }
}

class Mgr extends Emp {
    private double perfBonus;

    public Mgr(int id, String name, int deptId, double basicSalary, double perfBonus) {
        super(id, name, deptId, basicSalary);
        this.perfBonus = perfBonus;
    }

    @Override
    public String toString() {
        return super.toString() + ", Performance Bonus: " + perfBonus;
    }

    @Override
    public double computeNetSalary() {
        return basicSalary + perfBonus;
    }

    public double getPerformanceBonus() {
        return perfBonus;
    }
}

class Worker extends Emp {
    private double hoursWorked;
    private double hourlyRate;

    public Worker(int id, String name, int deptId, double basicSalary, double hoursWorked, double hourlyRate) {
        super(id, name, deptId, basicSalary);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public String toString() {
        return super.toString() + ", Hours Worked: " + hoursWorked + ", Hourly Rate: " + hourlyRate;
    }

    @Override
    public double computeNetSalary() {
        return basicSalary + (hoursWorked * hourlyRate);
    }

    public double getHourlyRate() {
        return hourlyRate;
    }
}
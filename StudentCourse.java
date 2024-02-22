public class StudentCourse {
    private boolean isCompleted;
    private int classAtempts;
    private double grade;

    public StudentCourse(boolean isCompleted, int classAtempts, double grade) {
        setIsCompleted(isCompleted);
        setClassAttempts(classAtempts);
        setGrade(grade);
    }

    public void setIsCompleted(boolean completed) {
        this.isCompleted = completed;
    }

    public void setClassAttempts(int attempts) {
        this.classAtempts = attempts;
    }

    public void setGrade(double grade) {
        if (grade < 0 || grade > 100)
            throw new Exception("THAT GRADE IS NOT POSSIBLE")
        this.grade = grade;
    }

    public double getGrade() {
        return this.grade;
    }

    public int getAttempts() {
        return this.classAtempts;
    }

    public boolean getIsCompleted() {
        return this.isCompleted;
    }

    public String getLetterGrade() {
        return "A+";
    }


}

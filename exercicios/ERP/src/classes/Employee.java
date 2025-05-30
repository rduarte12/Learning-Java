package classes;

public abstract sealed class Employee extends Account permits Manager, Clerk, Salesmann {

    protected  String name;
    protected  String password;
    protected  boolean isAdmin;
    protected Email emailObj = new Email();

    public String getEmail() {
        return emailObj.getEmail(); 
    }

    public void setEmail(String email) {
        if (email != null && !email.isEmpty()) {
            emailObj.setEmail(email);
        } else {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
    }
    

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isAdmin() {
        return isAdmin;
    }
    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    abstract Employee newEmployee(Employee employee);

}

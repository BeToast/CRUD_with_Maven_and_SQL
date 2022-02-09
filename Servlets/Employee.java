public class Employee {
  public int id;
  public String name, email, desig, salary, number;

  public Employee(int id, String name, String email, String design, String salary, String number){
    this.id = id;
    this.name = name;
    this.email = email;
    this.desig = design;
    this.salary = salary;
    this.number = number;
  }

  public int getId(){
    return id;
  }
  public String getName(){
    return name;
  }
  public String getEmail(){
    return email;
  }
  public String getDesig(){
    return desig;
  }
  public String getSalary(){
    return salary;
  }
  public String getNumber(){
    return number;
  }

}

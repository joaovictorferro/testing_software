package br.com.ufal.iSoccer.entidades;

public class Person {
    private String name;
    private String cpf;
    private String tel;
    private String email;
    private String type;
    private double salary;

    public Person(String name, String cpf, String tel, String email, double salary, String type) {
        this.name = name;
        this.cpf = cpf;
        this.tel = tel;
        this.email = email;
        this.salary = salary;
        this.type = type;
    }

    public Person(String name, String cpf, String tel, String email){
        this.name = name;
        this.cpf = cpf;
        this.tel = tel;
        this.email = email;
    }

    public Person(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        return true;
    }
}
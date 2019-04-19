class TeamQA {
    String name;
    int age;
    String gender;
    String designation;
    String project_name;

}

class Trainee {
    public static void main(String[] args) {
        TeamQA t = new TeamQA();
        t.name="Preeti";
        t.age=20;
        t.designation="QA Trainee";
        t.project_name="Clever Queue";
        t.gender="Female";
        System.out.println("My name is"+" "+t.name+",I am"+" "+t.age+"years old"+" "+"I am working as a"+" "+t.designation+" "+"and handling"+" "+t.project_name+" "+"project"+" "+"and I am a"+" "+t.gender);

//        second object
        TeamQA t1 = new TeamQA();
        t.name="gangwar";
        t.age=22;
        t.designation="QA Trainee";
        t.project_name="Clever Queue";
        t.gender="Female";
        System.out.println("My name is"+" "+t.name+",I am"+" "+t.age+"years old"+" "+"I am working as a"+" "+t.designation+" "+"and handling"+" "+t.project_name+" "+"project"+" "+"and I am a"+" "+t.gender);



    }
}

package JFT11;

public class Exercise1 {
    public static void main(String[] args) {
        Adult adult = new Adult();
        adult.setName("Billy White");
        adult.setAge(30);
        adult.setGender("male");
        adult.setHeight(6.5f);
        adult.setWeight(11.0f);
        adult.setPPSNo("5645614F");
        adult.setOccupation("Software Developer");
        adult.setIsMarried(true);
        adult.setIsCarOwner(true);

        Child child = new Child();
        child.setName("Frank Davis");
        child.setAge(3);
        child.setGender("male");
        child.setHeight(1.5f);
        child.setWeight(3.0f);
        // child.setSchoolCardNo(null);

        Baby baby = new Baby();
        baby.setName("Gillian Taylor");
        baby.setAge(1);
        baby.setGender("female");
        baby.setHeight(0.6f);
        baby.setWeight(1.0f);
        baby.setIsTeething(true);

        System.out.println(adult.toString());
        System.out.println(adult.eat());
        System.out.println(adult.drive());
        System.out.println();
        System.out.println(child.toString());
        System.out.println(child.eat());
        System.out.println(child.swim());
        System.out.println();
        System.out.println(baby.toString());
        System.out.println(baby.sleep());
        System.out.println(baby.swim());

    }
    
}

class Human {
    private String name;
    private int age;
    private String gender;
    private float height;
    private float weight;

    // Setters

    public void setName(String _name){
        this.name = _name;
    }

    public void setAge(int _age){
        this.age = _age;
    }

    public void setGender(String _gender){
        this.gender = _gender;
    }

    public void setHeight(float _height){
        this.height = _height;
    }

    public void setWeight(float _weight){
        this.weight = _weight;
    }

    // Getters

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public String getGender(){
        return this.gender;
    }

    public float getHeight(){
        return this.height;
    }

    public float getWeight(){
        return this.weight;
    }

    // Actions

    public String sleep(){
        return "Sleeping soundly...";
    }

    public String eat(){
        return "Eating slowly and chewing carefully...";
    }

    public String swim(){
        return "Arms rotating and pushing the body forward...";
    }

    // Method
    public String toString(){
        return "Name: " + this.getName() + "\nAge: " + this.getAge() + "\nGender: " + this.getGender() + "\nHeight: " + this.getHeight() + "\nWeight: " + this.getWeight();
    }
}

class Adult extends Human {
    
    private String ppsNo;
    private String occupation;
    private Boolean isMarried;
    private Boolean isCarOwner;

    // Setters

    public void setPPSNo(String _ppsNo){
        this.ppsNo = _ppsNo;
    }

    public void setOccupation(String _occupation){
        this.occupation = _occupation;
    }

    public void setIsMarried(Boolean _isMarried){
        this.isMarried = _isMarried;
    }

    public void setIsCarOwner(Boolean _isCarOwner){
        this.isCarOwner = _isCarOwner;
    }

    // Getters

    public String getPPSNo(){
        return this.ppsNo;
    }

    public String getOccupation(){
        return this.occupation;
    }

    public Boolean getIsMarried(){
        return this.isMarried;
    }

    public Boolean getIsCarOwner(){
        return this.isCarOwner;
    }

    // Actions

    public String drive(){
        return "Driving a car safely...";
    }

    public String procreate(){
        return "Procreating...";
    }

    // Method

    public String toString(){ 
        return super.toString() + "\nPPSNo: " + this.getPPSNo() + "\nOccupation: " + this.getOccupation() + 
        "\nMarriage Status: " + this.getIsMarried() + "\nCar Owner: " + this.getIsCarOwner();
    }
}

class Child extends Human {

    private String schoolCardNo = "N/A";

    // Setter

    public void setSchoolCardNo(String _schoolCardNo){
        this.schoolCardNo = _schoolCardNo;
    }

    // Getter

    public String getSchoolCardNo(){
        return this.schoolCardNo;
    }

    // Actions

    public String swim(){
        if (this.getAge() <= 5) {
            return "As the child is 5 years old or younger, armbands must be worn and " +
            "parental supervision is required. Arms rotating and pushing the body forward...";
        } else {
            return super.swim();
        }
    }

    // Method

    public String toString(){
        return super.toString() + "\nSchool Card No: " + this.getSchoolCardNo();
    }
}

class Baby extends Human {

    private Boolean isTeething;

    // Setter

    public void setIsTeething(Boolean _isTeething){
        this.isTeething = _isTeething;
    }

    // Getter

    public Boolean getIsTeething(){
        return this.isTeething;
    }

    // Actions

    public String sleep(){
        return "Baby having difficulty sleeping due to teething pain.";
    }

    public String swim(){
        return "A baby cannot swim safely...";
    }

    // Method

    public String toString(){
        return super.toString() + "\nTeething: " + this.getIsTeething();
    }
}

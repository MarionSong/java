package Mypackage2;
class Person extends Object{
	int age;
	public boolean equals(Object obj) {
		if(this==obj) return true;
		if(!(obj instanceof Person)) return false;
		Person p=(Person) obj;
		return this.age==p.age;
		
	}
	public String toString() {
		return "Person[age="+age+"]";
	}
}




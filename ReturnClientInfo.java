//Class created to retrieve client information quickly 
class ReturnClientInfo{
	private String name;
	private String age;
	
	public ReturnClientInfo(String name, String age){
		this.name = name;
		this.age = age;
	
	}
	public String getName(){
		return name;
	}
	
	public String getAge(){
		return age;
	}	
	@Override
	public String toString() {
		return "ClientInfo [name=" + name + ", age=" + age + "]";
	}
}
public aspect EmployeeAspect{

	private pointcut log() : execution(* Employee.*(..));

	before() : log(){
		System.out.println("*****Before calling " + thisJoinPoint + " at " + new java.util.Date());
	}
	after(): log(){
		System.out.println("****After calling " + thisJoinPoint);
	}
}
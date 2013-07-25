def str = null
println str?.toUpperCase() //str?.to_s


/*String str = null
if(str != null)
	println(str.toUpperCase())
*/

def countries = [:]
countries += ["US":"Washington"]
countries += ["UK" : "London"]
countries += ["India":"New Delhi"]
countries.each {println("${it.key}, ${it.value}")}


def langs = ["Java","C#","Scala"]
langs.each {println it}
println(langs.class.name)

/*ArrayList<String> langs = new ArrayList<String>();
langs.add("Java");
langs.add("C#");
langs.add("Scala");

for(int i=0;i<langs.size();i++){
	System.out.println(langs.get(i));
}*/
 
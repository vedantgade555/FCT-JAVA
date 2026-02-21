package com.config.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import java.util.List;
import org.springframework.stereotype.Component;

@Component("inst")
public class Instructor {

	@Value("#{100+5}")
	private int id;
	@Value("#{4<6?'Vedant':'Ved'}")
	private String name;

	@Value("#{topics}")
	private List<String> topics;

	@Autowired
	private Profile profile;
	
	@Value("#{5>4}")
	private boolean Active;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", name=" + name + ", topics=" + topics + ", profile=" + profile + ", Active="
				+ Active + "]";
	}

	

}

/*
 * package com.config.annotations;
 * 
 * import java.util.List; import
 * org.springframework.beans.factory.annotation.Value; import
 * org.springframework.stereotype.Component;
 * 
 * @Component public class DemoSpEL {
 * 
 * // 1. Literal Value
 * 
 * @Value("101") private int id;
 * 
 * // 2. String Literal
 * 
 * @Value("Vedant") private String name;
 * 
 * // 3. Math Expression
 * 
 * @Value("#{10 + 20}") private int sum;
 * 
 * // 4. Multiplication
 * 
 * @Value("#{5 * 6}") private int multiply;
 * 
 * // 5. Ternary Operator
 * 
 * @Value("#{50 > 40 ? 'Yes' : 'No'}") private String conditionResult;
 * 
 * // 6. Static Method Call
 * 
 * @Value("#{T(java.lang.Math).sqrt(64)}") private double squareRoot;
 * 
 * // 7. System Property
 * 
 * @Value("#{systemProperties['java.version']}") private String javaVersion;
 * 
 * // 8. Inject Entire List
 * 
 * @Value("#{topics}") private List<String> topics;
 * 
 * // 9. Get List Element
 * 
 * @Value("#{topics[1]}") private String secondTopic;
 * 
 * // 10. String Method
 * 
 * @Value("#{'spring framework'.toUpperCase()}") private String upperCase;
 * 
 * @Override public String toString() { return "DemoSpEL {" + "\nid=" + id +
 * ",\nname='" + name + '\'' + ",\nsum=" + sum + ",\nmultiply=" + multiply +
 * ",\nconditionResult='" + conditionResult + '\'' + ",\nsquareRoot=" +
 * squareRoot + ",\njavaVersion='" + javaVersion + '\'' + ",\ntopics=" + topics
 * + ",\nsecondTopic='" + secondTopic + '\'' + ",\nupperCase='" + upperCase +
 * '\'' + "\n}"; } }
 */

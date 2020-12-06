package testproject;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//TranspotationWalk transpotationWalk = new TranspotationWalk();
		//transpotationWalk.walk();
		GenericXmlApplicationContext gac = new GenericXmlApplicationContext("classpath:applicationcontext.xml");//스프링 컨테이너를 만듦
		TranspotationWalk tw = gac.getBean("twalk", TranspotationWalk.class);
		tw.walk();
		gac.close();

	}

}

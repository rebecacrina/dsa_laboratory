import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PolyFactory {
	
	private static final Pattern monomial = Pattern.compile("([+-])?(\\d+)?x(?:\\^(\\d+))?");
	
	public static Polynomial Factory(String inputString){
		return new Polynomial(parseString(inputString));
	}
	
	private static List<Monomial> parseString(String inputString){
		List<Monomial> list = new ArrayList<>();
		Matcher m = monomial.matcher(inputString);
		int index = 0;
	    float freeTerm = 0;
	    
	    while (m.find()) {
	        float coefficient = (m.group(2) == null) ? 1 : Float.parseFloat(m.group(2));
	        int degree = (m.group(3) == null) ? 1 : Integer.parseInt(m.group(3));
	        if ("-".equals(m.group(1)))
	        	coefficient *= -1;
	        
	        list.add(new Monomial(coefficient, degree));
	        index = m.end();
	    }
	    if(index < inputString.length()){
	    	if(index!=0 && inputString.charAt(index-1)=='-'){
	    		freeTerm = -1;
	    		}
	    	else{
	    		freeTerm = 1;}
	    	freeTerm *=  Float.parseFloat(inputString.substring(index, inputString.length()));
	    	list.add(new Monomial(freeTerm, 0));
	    }
		return list;
	}
}

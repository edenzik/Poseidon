/**
 * 
 */
package edu.brandeis.flow.core.operator.filter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.json.JSONException;
import org.json.JSONObject;

import edu.brandeis.flow.core.operator.JSONOperator;

/**
 * @author Yahui
 * 
 * Filter: has two mood: Regex or numerical
 *
 */
public final class Filter extends JSONOperator {
	String exp;
	String key;
	String target;
	String mode;

	public Filter() {
		super();
		this.exp = "";
		this.key = "";
		this.target = "";
		this.mode = "";
	}
	
	public void setup(String key, String target, String mode, String exp){
		this.setKey(key);
		this.setMode(mode);
		this.setTarget(target);
		this.setExpression(exp);
		
	}
	
	@Override
	public void run() {
		if (isNumerical()) {
			numMode();
		}else {
			regexMode();
		}
	}
	
	public void regexMode(){ //accept only the "=" relational operator --> match
		JSONObject top;
		//Match patterns
		Pattern pattern = null;
		try {
            pattern = Pattern.compile(target);

            while (true) {
            	
    			if((top = read()) != null) {
    				//if no key is specified, then sends all json objects
        			if(key.equals("")) send(top);
        			//else, filter out all json object that matches the pattern
        			else{   
        				if(!top.has(key)) send(top);
        				else{
        					Matcher matcher = pattern.matcher(top.getString(key));
                            //if not match, send; else, drop
                            if(!matcher.matches()) send(top);
                            //else System.out.println("FILTER:::" + top.toString());
        				}
                        
        			}
    			}

    		} 
        } catch (PatternSyntaxException exception) {
            System.err.println(exception.getDescription());
        } catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}
	
	public void numMode() {
		JSONObject top;
		while (true) {
			if ((top = read()) != null) {
				//if no key is specified, then sends all json objects
    			if(key.equals("")) send(top);
    			//else if term is not specified, filter out all json objects that contain the key specified
    			else if(target.equals("") && !top.has(key)) send(top);
    			//if the term is specified
    			else {
    				try {
						int termInt = Integer.parseInt(top.getString(key));
						int targetInt = Integer.parseInt(target);
						if(exp.equals("=") && targetInt != termInt) send(top); //send if not equal
						else if(exp.equals(">") && targetInt >= termInt) send(top); //drop if target < term
						else if(exp.equals("<") && targetInt <= termInt) send(top); //drop if target > term
					} catch (NumberFormatException | JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    				
    			}
			}
		}
	}
	
	public String getExpression(){
		return exp;
	}
	
	private void setExpression(String exp) {
		this.exp = exp;
	}

	public String getKey() {
		return key;
	}

	private void setKey(String key) {
		this.key = key;
	}

	public String getTarget() {
		return target;
	}

	private void setTarget(String target) {
		this.target = target;
	}
	
	public String getMode(){
		return mode;
	}
	
	private void setMode(String mode){
		this.mode = mode;
	}

	

	
	public boolean isRegex() {
		return mode.equalsIgnoreCase("regex");
	}
	
	public boolean isNumerical() {
		return mode.equalsIgnoreCase("numerical");
	}



}


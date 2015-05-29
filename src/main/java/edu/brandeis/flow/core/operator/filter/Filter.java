/**
 * 
 */
package edu.brandeis.flow.core.operator.filter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.json.JSONException;
import edu.brandeis.flow.core.json.JSONObject;

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
	boolean drop;

	public Filter() {
		super();
		this.exp = "";
		this.key = "";
		this.target = "";
		this.mode = "";
	}
	
	public void setup(String key, String target, String mode, String exp, boolean drop){
		this.setKey(key);
		this.setMode(mode);
		this.setTarget(target);
		this.setExpression(exp);
		this.drop = drop;
		
	}
	
	/**
	 * Runs the thread and filters on a predicate (in num or regex mode)
	 * 
	 */
	@Override
	public void run() {
		if (isNumerical()) {
			try {
				numMode();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			regexMode();
		}
	}
	
	/**
	 * Filters by regular expressions
	 * 
	 */
	public void regexMode(){ //accept only the "=" relational operator --> match
		JSONObject top;
		//Match patterns
		Pattern pattern = null;
		try {
            pattern = Pattern.compile(target.toLowerCase());

            while (true) {
            	
    			if((top = read()) != null) {
    				//if no key is specified, then sends all json objects
        			if(key.equals("")) send(top);
        			//else, filter out all json object that matches the pattern
        			else{   
        				JSONObject tmpTop = new JSONObject(top.toString().toLowerCase());
        				if(!tmpTop.has(key.toLowerCase())) send(top);
        				else{
        					Matcher matcher = pattern.matcher(tmpTop.getString(key.toLowerCase()));
                            //if not match, send; else, drop
        					if(matcher.matches() && !drop) {
        						send(top);
        					}
        					else if(!matcher.matches() && drop) send(top);
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
	
	/**
	 * Filters by number predicate
	 * @throws JSONException
	 */
	public void numMode() throws JSONException {
		JSONObject top;
		while (true) {
			if ((top = read()) != null) {
				JSONObject tmpTop = new JSONObject(top.toString().toLowerCase());
				//if no key is specified, then sends all json objects
    			if(key.equals("")) send(top);
    			//else if term is not specified, filter out all json objects that contain the key specified
    			else if(target.equals("") && !tmpTop.has(key.toLowerCase()) && drop) send(top);
    			else if(target.equals("") && tmpTop.has(key.toLowerCase()) && !drop) send(top);
    			//if the term is specified
    			else {
    				try {
						int termInt = Integer.parseInt(tmpTop.getString(key.toLowerCase()));
						int targetInt = Integer.parseInt(target);
						if(drop){
							if(exp.equals("=") && targetInt != termInt) send(top); //send if not equal
							else if(exp.equals(">") && targetInt >= termInt) send(top); //drop if target < term
							else if(exp.equals("<") && targetInt <= termInt) send(top); //drop if target > term
						}else {
							if(exp.equals("=") && targetInt == termInt) send(top); //send if not equal
							else if(exp.equals(">") && targetInt < termInt) send(top); //drop if target < term
							else if(exp.equals("<") && targetInt > termInt) send(top); //drop if target > term
						}
						
					} catch (NumberFormatException | JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    				
    			}
			}
		}
	}
	
	/**
	 * Gets the current expression filtering on
	 * @return
	 */
	public String getExpression(){
		return exp;
	}
	
	/**
	 * Sets the filter expression
	 * @param exp
	 */
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


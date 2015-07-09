package com.sky.demo.qua.base;

import com.google.common.base.CaseFormat;
import com.google.common.base.Preconditions;
import com.sky.demo.qua.annotation.Difficulty;
import com.sky.demo.qua.annotation.Exercise;


/**
 * @author sy
 */
@Exercise(name = "StringInflect", related = CaseFormat.class, difficulty = Difficulty.NORMAL)
public class StringInflect {

    /**
     * Converts strings separated by under_score to UpperCamelCase
     * 
     * @param string the target string
     * @param upperCaseFirstLetter make the first letter uppercase or not
     */
    public static String camelize(String string, boolean upperCaseFirstLetter) {
		Preconditions.checkNotNull(string);

    	if(upperCaseFirstLetter == true){
    		return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, string);
    	} else {
    		return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, string);
    	}	
        
    }

    /**
     * 
     * Replaces underscores with dashes in the string.(e.g. an_example -> an-example)
     * 
     * @param string to be converted
     */
    public static String dasherize(String string) {
		Preconditions.checkNotNull(string);
    	return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_HYPHEN, string);
    }

    /**
     * Makes an underscored, lowercase form from a CamelCase string. (e.g. CamelCase -> camel_case)
     * 
     * @return a string separated by underscores
     */
    public static String underscore(String word) {
		Preconditions.checkNotNull(word);
    	return CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, word);
    }
}

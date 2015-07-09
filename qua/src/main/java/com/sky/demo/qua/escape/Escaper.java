package com.sky.demo.qua.escape;


import com.google.common.base.Preconditions;
import com.google.common.html.HtmlEscapers;
import com.sky.demo.qua.annotation.Difficulty;
import com.sky.demo.qua.annotation.Exercise;


/**
 * @author sy
 */
@Exercise(name="Escaper", difficulty = Difficulty.EASY)
public abstract class Escaper {

    private Escaper(){
    }

    /**
     * escape the given plain string input by user to prevent XSS attack
     *
     * @param str the String to escape
     * @return the escaped string
     */
    public String escape(String str) {
        //TODO implement
        Preconditions.checkNotNull(str);
    	return HtmlEscapers.htmlEscaper().escape(str);
    }


}

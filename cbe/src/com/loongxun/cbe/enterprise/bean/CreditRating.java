package com.loongxun.cbe.enterprise.bean;
// default package



/**
*
* 描述：信用等级释义实体
*
* @author 楚昌胜 
* @since 2014-2-20 下午04:03:12
* @version 1.0
*/
public class CreditRating {
	private int creditId;//信用等级Id
	private double lowScores;//限制信用等级的下限分数。
	private double highScores;//限制信用等级的上限分数。
	private String creditSymbol;//信用等级的标志。AAA，AA，A，BBB，BB，B，C
	private String definitions;//释义。对该信用等级的企业说明


    // Constructors

    /** default constructor */
    public CreditRating() {
    }

	/** minimal constructor */
    public CreditRating(Double lowScores, Double highScores, String creditSymbol) {
        this.lowScores = lowScores;
        this.highScores = highScores;
        this.creditSymbol = creditSymbol;
    }
    
    /** full constructor */
    public CreditRating(Double lowScores, Double highScores, String creditSymbol, String definitions) {
        this.lowScores = lowScores;
        this.highScores = highScores;
        this.creditSymbol = creditSymbol;
        this.definitions = definitions;
    }

   
    // Property accessors

    public Integer getCreditId() {
        return this.creditId;
    }
    
    public void setCreditId(Integer creditId) {
        this.creditId = creditId;
    }

    public Double getLowScores() {
        return this.lowScores;
    }
    
    public void setLowScores(Double lowScores) {
        this.lowScores = lowScores;
    }

    public Double getHighScores() {
        return this.highScores;
    }
    
    public void setHighScores(Double highScores) {
        this.highScores = highScores;
    }

    public String getCreditSymbol() {
        return this.creditSymbol;
    }
    
    public void setCreditSymbol(String creditSymbol) {
        this.creditSymbol = creditSymbol;
    }

    public String getDefinitions() {
        return this.definitions;
    }
    
    public void setDefinitions(String definitions) {
        this.definitions = definitions;
    }
   








}
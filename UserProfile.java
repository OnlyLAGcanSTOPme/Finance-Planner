public class UserProfile implements UserIFC {
  Name uName;
	int ID;
	DOB uDOB;
	CurrencyType uCurrencyType;
	double Income;
	Frequency PayrollFrequency;
	float TaxRate;
  
  public UserProfile() {
     
  }
  
  public void AddUser(Name vName, int vID, DOB vDOB, CurrencyType vCurrencyType, double vIncome, Frequency vPayrollFrequency, float vTaxRate) {
      uName = vName;
      ID = vID;
      uDOB = vDOB;
      uCurrencyType = vCurrencyType;
      Income = vIncome;
      PayrollFrequency = vPayrollFrequency;
      TaxRate = vTaxRate;
  }

  public Name getName(){
    return this.uName;
  }
	public int getID(){
	  return this.ID;
	}
	public DOB getDOB(){
	  return this.DOB;
	}
	public CurrencyType getCurrencyType(){
	  return this.uCurrencyType;
	}
	public double getIncome(){
	  return this.Income;
	}
	public Frequency getPayrollFrequency(){
	  return this.PayrollFrequency;
	}
	public float getTaxRate(){
	  return this.TaxRate;
	}


	public void setName(Name vName){
	  this.uName = vName;
	}
	public void setID(int vID){
	  this.ID = vID;
	}
  public void setDOB(vDOB){
	  this.uDOB;
	}
	public void setCurrencyType(CurrencyType vCurrencyType){
	  this.uCurrencyType = vCurrencyType;
	}
	public void setIncome(double vIncome){
	  this.Income = vIncome;
	}
	public void setPayrollFrequency(Frequency vPrllFreq){
	  this.PayrollFrequency = vPrllFreq;
	}
	public void setTaxRate(float vTaxRate){
	  this.TaxRate = vTaxRate;
	}
}

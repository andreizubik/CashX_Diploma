package model;

import lombok.Data;

@Data
public class LastPhoneCallsByContext{
	private UserPromoCodeSms userPromoCodeSms;
	private LoanCollectionLoans loanCollectionLoans;
	private UserUncompletedRegistrations userUncompletedRegistrations;
	private ApplicationUnsignedApplications applicationUnsignedApplications;
	private LoanClosedLoans loanClosedLoans;

}

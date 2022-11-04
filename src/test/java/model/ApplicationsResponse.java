package model;

import lombok.Data;

@Data
public class ApplicationsResponse {
	private int verifierId;
	private String accountNumber;
	private int requestedTenor;
	private String confirmationCode;
	private String userLastName;
	private Object targetUrl;
	private Object rejectionReasonCode;
	private String createdAt;
	private Object promoCode;
	private String verifierUsername;
	private int requestedPrincipal;
	private int resolvedById;
	private String userFirstName;
	private int requestNumber;
	private int productId;
	private String branchName;
	private String bankName;
	private Object rejectionReason;
	private int id;
	private String state;
	private Object confirmedAt;
	private Object maxPaidDay;
	private Object loanId;
	private int potentialLoanNumber;
	private boolean isRepeat;
	private Object aventusDecisionEngineStatus;
	private String productName;
	private LastPhoneCallsByContext lastPhoneCallsByContext;
	private String userPhoneNumber;
	private String decisionEngineId;
	private int userId;
	private Object repaymentDate;
	private Object postponedUntil;
	private String resolvedAt;
	private Object repaidByClient;
	private int approvedTenor;
	private Object affiliate;
	private int approvedPrincipal;


}

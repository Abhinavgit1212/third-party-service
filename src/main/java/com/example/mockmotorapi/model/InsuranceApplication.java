package com.example.mockmotorapi.model;

import com.example.mockmotorapi.model.enums.ApplicationStatus;

public record InsuranceApplication(
        String applicationId,
        ApplicationStatus applicationStatus,
        ProposerDetailsDto proposerDetails,
        AssetDetailsDto assetDetailsDto,
        PaymentDetails paymentDetails,
        QuoteDetails quote,
        PolicyApplicationData policyDetails,
        ProposalDetailResponse proposalDetailResponse,
        String pinCode,
        NomineeDetailsDto nomineeDetails
) {
    public InsuranceApplication withProposerDetails(ProposerDetailsDto proposer) {
        return new InsuranceApplication(applicationId, applicationStatus, proposer, assetDetailsDto, paymentDetails, quote, policyDetails, proposalDetailResponse, pinCode, nomineeDetails);
    }
    public InsuranceApplication withNomineeDetails(NomineeDetailsDto nominee) {
        return new InsuranceApplication(applicationId, applicationStatus, proposerDetails, assetDetailsDto, paymentDetails, quote, policyDetails, proposalDetailResponse, pinCode, nominee);
    }
}

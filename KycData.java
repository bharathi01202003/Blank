package com.example.model.kyc;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
    "registrationAddress", "kycAddresses", "kycRiskAssessment",
    "kycSite", "kycFund", "kycApprovedProducts", "kycSegment",
    "kycRiskLevel", "riskIndustry", "kycStatus", "lastRecertificationDate",
    "kycJurisdictions", "kycClientCoverage", "kycPassportEligibility",
    "pole", "activitySector", "exposureToRussia"
})
public class KycData {
    // Assume all fields are defined here with getters and setters
}

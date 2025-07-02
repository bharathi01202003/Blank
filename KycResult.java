package com.example.model.kyc;

public class KycResult {
    private KycIdentifier[] identifiers;
    private KycData kycData;

    public KycIdentifier[] getIdentifiers() {
        return identifiers;
    }

    public void setIdentifiers(KycIdentifier[] identifiers) {
        this.identifiers = identifiers;
    }

    public KycData getKycData() {
        return kycData;
    }

    public void setKycData(KycData kycData) {
        this.kycData = kycData;
    }
}

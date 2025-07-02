package com.example.service;

import com.example.dto.MergedResult;
import com.example.model.finance.FinanceEntity;
import com.example.model.finance.FinanceIdentifier;
import com.example.model.finance.FinanceResult;
import com.example.model.kyc.KycIdentifier;
import com.example.model.kyc.KycResult;
import com.example.model.kyc.KycResultWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MergerService {

    @Autowired
    private RestTemplate restTemplate;

    public List<MergedResult> getMergedData() {
        FinanceResult financeResult = restTemplate.getForObject("http://localhost:8081/finance", FinanceResult.class);
        KycResultWrapper kycResultWrapper = restTemplate.getForObject("http://localhost:8082/kyc", KycResultWrapper.class);

        List<FinanceEntity> financeEntities = financeResult.getResults();
        List<KycResult> kycResults = kycResultWrapper.getResults();

        return kycResults.stream()
            .flatMap(kyc -> Arrays.stream(kyc.getIdentifiers())
                .flatMap(kycId ->
                    financeEntities.stream()
                        .filter(fin -> fin.getIdentifiers() != null &&
                            fin.getIdentifiers().getKycId() != null &&
                            fin.getIdentifiers().getKycId().equals(kycId.getKycId()))
                        .map(fin -> new MergedResult(kycId.getKycId(), fin, kyc.getKycData()))
                )
            ).collect(Collectors.toList());
    }
}

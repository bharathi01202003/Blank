package com.example.service;

import com.example.dto.MergedResult;
import com.example.model.finance.FinanceEntity;
import com.example.model.finance.FinanceIdentifier;
import com.example.model.finance.FinanceResult;
import com.example.model.kyc.KycIdentifier;
import com.example.model.kyc.KycResult;
import com.example.model.kyc.KycResultWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MergerService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${finance.api.url}")
    private String financeApiUrl;

    @Value("${kyc.api.url}")
    private String kycApiUrl;

    public List<MergedResult> getMergedData() {
        FinanceResult financeResult = restTemplate.getForObject(financeApiUrl, FinanceResult.class);
        KycResultWrapper kycResultWrapper = restTemplate.getForObject(kycApiUrl, KycResultWrapper.class);

        if (financeResult == null || kycResultWrapper == null ||
            financeResult.getResults() == null || kycResultWrapper.getResults() == null) {
            return List.of(); // empty list if API fails
        }

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
